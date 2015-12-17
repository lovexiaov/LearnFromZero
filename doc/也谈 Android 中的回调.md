# 也谈 Android 中的回调

在 Android 系统中，回调几乎随处可见，最常见的就是给点击事件设置监听，如下：

```java
btn_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        // TODO log in
    }
});
```

如果你开发过 Android 应用，相信上面的代码你不会陌生。下面就根据我的理解谈一谈啥回调，为啥使用回调，以及如何在自己的代码中定义回调。

# 0x00. 什么是回调？

我们先来看一下百度百科中对回调的定义：
> *回调是一种双向调用模式，也就是说，被调用方在接口被调用时也会调用对方的接口。*

看不懂？没关系，我们再来看下面这段话：
> *在面向对象的语言中，回调是通过接口或抽象类来实现的，我们把实现这种接口的类称为回调类，回调类的对象成为回调对象。*

我们来把上面两句话归结一下：
> **回调就是抽象类（或接口）的实例实现父类的抽象方法后，将该方法交还给父类调用。**

# 0x01. 为啥使用回调？
诚如定义中所言：“回调是一种模式”，既然是模式，肯定是为了解决某一类问题而出现的。那么回调解决了什么问题呢？

这里我们引用一下刘济华老师[《漫谈设计模式》](http://book.douban.com/subject/7015068/)一书中**买车票回家过节**的例子：

小明准备坐火车回家：

```java
public class XiaoMing {
    public void celebrateSpringFestival() {
        // Buy ticket
        buyTicket();

        // Travelling by train
        travellingByTrain();

        //  Celebrating Chinese New Year
        celebrating();
    }

    private void celebrating() {}

    private void travellingByTrain() {}

    private void buyTicket() {}
}
```

而小红离家比较近，她想坐大巴回去，也好办：

```java
public class XiaoHong {
    public void celebrateSpringFestival() {
        // Buy ticket
        buyTicket();

        // Travelling by bus
        travellingByBus();

        //  Celebrating Chinese New Year
        celebrating();
    }
    private void celebrating() {}

    private void travellingByBus() {}

    private void buyTicket() {}
}
```

细心的你可以发现，两段代码中有相当一部分重复。对于重复代码我们如何去优化呢？是的，使用继承大法。但是，每个人的乘车方式都是不同的，我们无法在基类中作出明确定义，而乘车又是回家过节必需的过程（不考虑离家近的同学步行回家的情况~）。我们只有把乘车方法定义为抽象方法，让各实现类自行决定如何乘车：

```java
public abstract class BeiPiao {
    public void celebrateSpringFestival() {
        // Buy ticket
        buyTicket();

        // Travelling by bus
        travelling();

        //  Celebrating Chinese New Year
        celebrating();
    }

    abstract void travelling();

    private void celebrating() {
        System.out.println("celebrating...")
    }

    private void buyTicket() {
        System.out.println("buy ticket...")
    }
}
```

```java
public class XiaoMing extends BeiPiao {
    @Override
    void travelling() {
        System.out.println("travelling by train");
    }
}
```

```java
public class XiaoHong extends BeiPiao {
    @Override
    void travelling() {
        System.out.println("travelling by bus");       
    }
}
```

这时，公司小秘要统计各位同事怎么回家：

```java
public class Secretary {
    public void howToGetBack(BeiPiao piao) {
        piao.celebrateSpringFestival();
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        secretary.howToGetBack(new XiaoHong());
        secretary.howToGetBack(new XiaoMing());
    }
}
// 输出
travelling by bus
travelling by train
```
然而公司有位新来的同事，小蜜叫不出名字，这咋办？

```java
public class Main {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        secretary.howToGetBack(new XiaoHong());
        secretary.howToGetBack(new XiaoMing());
        secretary.howToGetBack(new BeiPiao() {
            @Override
            void travelling() {
                System.out.print("travelling by taxi");
            }
        });
    }
}

// 输出
travelling by bus
travelling by train
travelling by taxi
```

哈哈，是不是有点熟悉的感觉了？`BeiPiao`类中的`travelling()`就是一个回调函数。

其实我们这里还顺带讲了一个设计模式——模板方法模式，父类先定义好模板，具体细节交给子类去实现。

讲了这么多，相信你应该对回调有了近一步的了解，下个小结我们会讲如何在自己的代码中定义回调函数。

# 0x02. 如何在自己的代码中定义回调？
背景是这样的：最近在看郭霖大神的《第一行代码》，想系统的从头梳理一遍 Android 的基础知识。想着自己做一个 Demo 应用，定义一个 ListView，每个条目对应一个知识点。由于每个条目响应的动作都不同，而我又不想在`onItemClickListener()`方法中添加无限多个 switch-case 判断。于是我就自定义了一个`Func`类，该类代表着一个功能点：

```java
public class Func {
    private OnClickListener onClickListener;
    private String name;

    public Func(String name, OnClickListener onClickListener) {
        this.name = name;
        this.onClickListener = onClickListener;
    }

    public String getName() {
        return name;
    }

    public void onClick() {
        onClickListener.action();
    }

    public interface OnClickListener {
        void action();
    }
}
```
自定义接口 `OnClickListener` 中的`action()`就是一个回调函数。

Adapter 类中的`getView()`方法：

```java
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button btn_show_func;
        if (convertView != null) {
            btn_show_func = (Button) convertView.getTag();
        } else {
            convertView = View.inflate(context, R.layout.list_func, null);
            btn_show_func = (Button) convertView.findViewById(R.id.btn_show_func);
            convertView.setTag(btn_show_func);
        }

        btn_show_func.setText(funcs.get(position).getName());
        btn_show_func.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // funcs 是包含多个 Func 类对象的 List 集合
                funcs.get(position).onClick();
            }
        });

        return convertView;
    }
```

我们可以这样添加一个条目：

```java
Func force_offline = new Func(getString(R.string.force_offline), new Func.OnClickListener() {
    @Override
    public void action() {
        sendBroadcast(new Intent("com.lovexiaov.learnfromzero.ACTION_FORCE_OFFLINE"));
    }
});

funcs.add(force_offline);
```
`Talk is cheap, show me the code!`

附上GitHub代码地址: [LearnFromZero](https://github.com/lovexiaov/LearnFromZero.git)

# 0x03. 小结
合理利用回调可以使代码易于维护和阅读，就像上面的代码，只需要修改一个地方就可以完成添加 ListView Item 的功能。快动手实现属于你自己的回调吧~

