## SimpleAdapter

SimpleAdapter 是一个映射静态数据和 XML 文件中定义的视图的简单适配器。你可以指定支持列表的数据为 Map 类型的 ArrayList。每个 ArrayList 中的实体对应列表中的一行。Map 集合中包含每一行的数据。我们还要指定一个 XML 文件(该文件定义了用于将行呈现出来的视图)，和一个映射特定视图的 Map 集合。绑定数据和视图发生在两个阶段。首先，如果`SimpleAdapter.ViewBinder`可用，`setViewValue(android.view.View, Object, String)` 被调用。如果返回值为真，则绑定已经发生。反之，如下视图会依次进行尝试：

+ 一个继承了 Checkable（例如：CheckBox）的视图。预期的绑定值是一个布尔类型。
+ TextView。预期的绑定值是一个字符串，`setViewText(TextView, String)`被调用。
+ ImageView。预期的帮定制是一个资源 id 或一个字符串，`setViewImage(ImageView, int)`或` setViewImage(ImageView, String)`被调用。

如果没有找到合适的绑定，则抛出` IllegalStateException`。


## SimpleCursorAdapter

SimpleCursorAdapter 是一个映射游标中的列和在 XML 文件中定义的 TextView 或 ImageView 的简单适配器。你可以指定你需要的列，你需要展示该列的视图和定义视图样式的 XML 文件。绑定发生在两个阶段。首先，如果`SimpleCursorAdapter.ViewBinder`可用，`setViewValue(android.view.View, android.database.Cursor, int)`被调用。如果返回值为真，则绑定已经发生。如果返回值为假且待绑定的视图是 TextView，`setViewText(TextView, String)`被调用。如果返回值为假且待绑定的视图是 ImageView，`setViewImage(ImageView, String)`被调用。如果没有找到合适的绑定，则抛出`IllegalStateException`。如果该适配器配合过滤器使用，如`AutoCompleteTextView`中的实例，你可以使用` SimpleCursorAdapter.CursorToStringConverter`和` FilterQueryProvider`接口控制过滤进程。参考[convertToString(android.database.Cursor)](https://developer.android.com/reference/android/widget/SimpleCursorAdapter.html#convertToString(android.database.Cursor))和[runQueryOnBackgroundThread(CharSequence)](https://developer.android.com/reference/android/widget/CursorAdapter.html#runQueryOnBackgroundThread(java.lang.CharSequence))获取更多信息。