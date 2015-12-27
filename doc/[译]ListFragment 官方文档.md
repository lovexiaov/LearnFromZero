# [译]ListFragment 官方文档

ListFragment 是一个通过绑定如数组或游标的数据资源呈现列表中元素的碎片，当用户选中其中的条目时，给予显示和处理。

ListFragment 寄存一个 ListView 对象，该对象可被绑定在不同的数据资源中，通常是一个数组或一个持有查询结果的游标。绑定，屏幕补助和行布局将在下面的小节中讨论。

### 屏幕布局

ListFragment 有一个由一个单独的列表视图组成的默认布局。然而，如果需要，我们可以通过在 onCreateView(LayoutInflater, ViewGroup, Bundle) 中返回你自己的视图来自定义碎片布局。为了达到此目的，你的视图*必须*包含一个 id 为 "@android:id/list" 的 ListView 对象，如果该对象通过代码生成，则它的 id 为[list]()。

在你的视图中可以包含另一个任意类型的视图对象，用于当列表视图为空时显示。这个“空列表”提示器必须用"android:empty" 作为其 id。注意，当空视图出现时，列表视图会在没有数据需要呈现时被隐藏。

如下代码演示了一个（丑陋的）自定义列表布局。它有一个绿色背景的列表和一个红色背景的“无数据”替代信息。

```xml
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
         android:orientation="vertical"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         android:paddingLeft="8dp"
         android:paddingRight="8dp">

     <ListView android:id="@id/android:list"
               android:layout_width="match_parent"
               android:layout_height="match_parent"
               android:background="#00FF00"
               android:layout_weight="1"
               android:drawSelectorOnTop="false"/>

     <TextView android:id="@id/android:empty"
               android:layout_width="match_parent"
               android:layout_height="match_parent"
               android:background="#FF0000"
               android:text="No data"/>
 </LinearLayout>
```

### 行布局

你可以为列表中个别行指定布局。通过在被碎片持有的 ListAdapter 对象中指定布局资源来实现（该 ListAdapter 将 ListView 和数据绑定起来，后面有更多相关内容）。

ListAdapter 的构造器拥有一个给每一行指定一个布局资源的参数。它还包含两个附加参数使我们指定哪一个数据字段与行布局资源中的哪一个对象相关联。这两个参数一般为平行数组。

Android 提供了一些标准的行布局资源。它们包含在 [R.layout]() 类中，有如 simple_list_item_1, simple_list_item_2 和 two_line_list_item 的名称。如下布局 XML 是 two_line_list_item 的资源文件，该布局为列表中的每一行呈现两个数据字段，一个在上，一个在下。

```xml
 <?xml version="1.0" encoding="utf-8"?>
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:orientation="vertical">

     <TextView android:id="@+id/text1"
         android:textSize="16sp"
         android:textStyle="bold"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"/>

     <TextView android:id="@+id/text2"
         android:textSize="16sp"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"/>
 </LinearLayout>
```

你必须清楚知道与此布局中每一个 TextView 对象绑定的数据。语法规则在下一小节中讨论。

### 与数据绑定

你可以使用一个 ListAdapter 接口的实现类将数据绑定到 ListFragment 的 ListView 对象上。Android 提供了两个标准的列表适配器： [SimpleAdapter]()用来绑定静态数据（Maps），[SimpleCursorAdapter]() 用来绑定游标查询结果数据。

你必须使用`ListFragment.setListAdapter()`来关联列表和适配器。不要直接调用 `ListView.setAdapter()`否则其他重要的初始化操作会被跳过。
