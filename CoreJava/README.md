# Java核心卷Ⅰ代码重现
近日重读Java核心卷Ⅰ，打算手撸课本上的所有代码以加深对Java基础的理解，现在就开始！

## CH02 Java程序设计环境
### Welcome.java
经典入门代码，打印hello！

## CH03 Java的基本程序设计结构
### FirstSample.java
java中三种注释的使用
### InputTest.java
标准输入流System.in和Scanner对象实现读取输入
### Retirement.java
三种循环：while dowhile for的简单使用
格式化输出printf
> 本章节还有很多代码没有实现，待续！

## CH04 对象与类
### Calendar.java

实现了使用LocalDate类实现一个日历的输出！

知识点：两个用于显示时间的类：Date和LocalDate
 - Date类
 
    用于保存时间点，显示年月日的方法已被废弃！
    
 - LocalDate类
    
    一般用于日历表示法表示日期
    
    该对象构造时，不使用构造器，而是使用静态工厂方法
    - LocalDate.now()
    - LocalDate.of(year,month,day)
    
### EmployeeTest.java
面向对象初探，实现了一个Employee对象类，使用一个Employee数组，再使用for each循环对每个Employee对象操作，同时在代码中体现了隐式参数的使用！
### StaticTest.java
**静态字段：**
1. 一个类维护一个静态字段，每个类的实例共享同一个静态字段。而非静态字段，每个实例自己独有一个副本
2. 即便没有对象实例，静态字段也存在！

**静态常量：**

静态变量使用较少，静态常量比较常用，使用public static final定义一个静态常量。

如在Math类中定义一个静态常量PI
```java
public class Math
{
    public static final double PI=3.14159265358;
}
```
于是我们可以直接通过Math.PI访问这个常量。

注：System.out就是一个静态常量，它的声明如下：
```java
public class System
{
    public static final PrintStream out = ...
}
```
**静态方法：**

静态方法即为没有隐式参数的方法，它不是在对象上执行的方法，我们直接用类名.方法名调用！
如：Math.pow()

使用静态方法的两种情况：
1. 方法不需要访问对象状态，因为它所需要的所有参数都通过显式参数提供。
2. 方法只需要访问类的静态字段

main方法是一个静态方法，它不对任何对象进行操作，事实上，在启动程序时还没有对象，静态的main方法将执行并构造程序所需要的方法！

### Param.java
java中所有参数，包括对象参数，都是按值调用的。
但是在C语言中，可以使用&符号进行引用传递
当我们传一个对象时，其实传的是对象引用的副本
> 假设harry = new Employee()
>
> function(harry){}
>
> 此时传入方法的其实是一个对象引用的副本，它和harry都指向同一个实例对象！

### Constructor.java
展示了为数据字段赋值的三种方法：
 1. 在声明中赋值
 2. 在构造器中设置值
    > 可以在一个构造器中使用this.()来调用另一个构造器函数
 3. 初始化块
    - 静态初始化块
    - 对象初始化块

默认数据初始化为：
- 数值：0
- 布尔值：false
- 对象引用为null，String也为null
### 类设计技巧
1. 保证数据私有，不要破坏封装性，即类中的字段都应该为private，然后通过set/get方法去访问
2. 一定要对数据进行初始化，不要依赖于默认的数据初始化！
3. 不要在类中使用过多的基本类型，即要学会使用对象来替换基本类型！
4. 不是所有的字段都需要set/get方法，比如有些字段，如出生日期，不需要set方法，因为一旦初始化，不会再改变！
5. 分解有过多指责的类，即如果一个复杂的类可以分解为两个更加简单的类，那么就应该那么做！
6. 类名和方法名要能够体现它们的职责
7. 优先使用不可变的类

## CH05 继承
### inheritance

继承初体验！

**多态**：一个**对象变量**可以指示多种实际类型的现象称为多态

【例】一个Employee类型的变量既可以引用一个Employee类型的对象，也可以引用Employee类的任何一个子类的对象。
```java
Manager boss = new Manager();
Employee[] staff = new Employee[2] 
staff[0] = boss;
```
注：此时编译器只把staff[0]看作是一个Employee对象，故Manager独有的方法无法使用！

**在程序运行前，也就是编译时期JVM就能够确定方法由谁调用，这种机制称为静态绑定，反之则为动态绑定！**

**动态绑定**：在运行时能自动地选择适当的方法，称为动态绑定
 
 1. 存在一个方法f(int)和方法f(String)，那么当调用x.f(”hello“)的时候，编译器会挑选f(String)方法，当调用x.f(1)时，编译器会挑选f(int)方法
 2. 如果在子类中定义了一个与超类签名相同的方法，那么子类中的这个方法就会**覆盖**超类中这个相同签名的方法。
 3. 使用动态绑定的原因是调用的方法依赖于**隐式参数**的实际类型！假设存在调用x.f()因为可调用方法的范围为：x类的方法、x类的超类的方法！本次调用的隐式参数的实际类型可能是x类，也可能是x类的超类
 
    由于第二点，即重写覆盖，因此查找方法的顺序为：先找x类有无所需的方法（根据第一点，即方法签名），若无，再查找超类的方法（可能存在超类的方法，但是子类并没有重写）。

**静态绑定**：方法为private、static、final或者构造器，则编译器可以准确的指导应该调用哪种个方法，此时为静态绑定！

- private方法：只能被当前类使用，其子类也无法访问，因此当我们使用x.f()，其中f()为private方法时，它一定是当前类的方法！即x和f()都能确定！
- static方法属于类：它是没有隐式参数的方法（核心卷ⅠP116）
- final方法：该方法不能被子类覆盖重写，故可以确定x和f()
- 构造器

**super与this**

迄今为止，super和this都分别有两种作用：

- super  一是调用超类的方法，二是调用超类的构造器
- this   一是指示隐式参数的引用，二是调用该类的其他构造器

当然，也可以使用this来调用当前类的方法，只不过可以省略，因此没必要使用this！

**instanceof**


①obj instanceof Class

用于检测左边的对象是否是右边的类的实例:
  
1. 子类对象一定是父类的实例
    
2. 父类对象不是子类的实例       

②obj instanceof Comparable

用于检测左边的对象是否是实现了右边的接口的类的实例
   
### abstractClasses

抽象类的简单体验：

1. 有一个或多个抽象方法的类本身必然是抽象的
     
2. 不含抽象方法，也可以将类声明为抽象类
     
3. 抽象类不能实例化

可以使用抽象类的变量去引用具体子类的变量
```java
var people = new Person[2];
people[0] = new Employee("王乐卿", 50000, 2000, 03, 30);
people[1] = new Student("宋雨童", "外国语学院");

/**
 * 由于抽象类不能实例化，因此变量P永远不会引用Person对象！而是引用诸如Student、Employee具体子类的对象！
 */
for (Person p : people) {
    System.out.println(p.getName() + "," + p.getDescription());
}
```
### equals
Obejcts：所有类的超类

- 可以使用Object类型的变量引用任何类型的对象
- Object类中常用于覆盖的方法
    - equals() 
    - toString()
    - hashCode()  根据对象的**存储地址**来生成对应的散列码
- equals与==的探究

==的作用根据数据类型而有所变化
1. 若比较双方为基本数据类型，比如int，则直接比较值
2. 若比较双方是对象，则比较它们的在内存中的存储地址是否相同！

equals只用于对象，用于比较内存中的存储地址是否相同！
```java
//Object类中实现的equals，本质上就是==
public boolean equals(Object obj) {
    return (this == obj);
}
```
若是我们自己的类不对equals()方法进行重写，那么当我们调用诸如e1.equals(e2)时，实际上就是在进行e1==e2！

当然，有些官方实现的类已经对equals进行了重写，此处以String类为例：
```java
public boolean equals(Object anObject) {
    //同Object类，若是两个对象引用相同，即它们在内存中的存储地址相同，则返回true
    if (this == anObject) {
        return true;
    }
    //若是两个String对象的值相同，也返回true！
    //注意：两个分别new出来的对象的存储地址一定是不同的！可以通过hashCode函数查看！
    if (anObject instanceof String) {
        String aString = (String)anObject;
        if (!COMPACT_STRINGS || this.coder == aString.coder) {
            return StringLatin1.equals(value, aString.value);
        }
    }
    return false;
}

```


 注意：当我们使用System.out.println(e)
 
 假设e是一个对象的引用
 
 那么实际上会自动调用System.out.println(e.toString)
 
 如果显示诸如：CH05.arrayList.Employee@4e50df2e
 
 其原因是因为e对象的类的实现中，没有覆盖toString方法，而使用了默认的Object类的toString方法！
 
 ### arrayList
 
 C语言中，必须在编译时确定数组的大小
 
 即只能够：int a[2]
 
 不允许：  int n;  int a[n];
 
 而java允许在声明数组时使用变量：int n = 3;  var staff = new Employee[n];
 
 从此实现了运行时确定数组的大小！
 
 然而存在一个问题：一旦确定了数组的大小，就不能再改变了！
 
 **解决运行时动态更改数组：使用ArrayList类**
 
 泛型数组列表的声明：
 ```java
//以下三种写法等价！
ArrayList<Employee> staff = new ArrayList<Employee>();
//使用var关键字，避免重复写类名
var staff1 = new ArrayList<Employee>();
//菱形语法，可省略右侧类型参数
ArrayList<Employee> staff2 = new ArrayList<>();
```
 泛型数组列表的常用方法：add、set、get、remove、size
 
 若是已经能够估计数组的大小，可以使用ensureCapacity方法
 
 例如：staff.ensureCapacity(100)，当然只是表示可能存100个，你可以少于，也可以超过，都没问题！
 
 ### wrapper
 
对象包装器与自动装箱

包装器共有八类：Integer、Long、Short、Float、Double、Byte、Character、Boolean

前六类派生于公共的超类Number

作用一：用于一些基本类型无法使用，必须传入对象的情况：如泛型数组类型
```java
var list = new ArrayList<Integer>();
```
作用二：作为存放一些基本方法的好地方
```java
String s = "100";
int x = Integer.parseInt(s);
//此处的parseInt()方法是静态方法，与Integer对象没有任何关系，Integer类是放置这个方法的好地方。
```
基本方法是**静态方法**

### varargs
参数数量可变的方法
 
方法的最后一个参数设置为：类型... 数组名
 
例如：

double... values
> 相当于接受一个double[]数组
>
> var values = double[]

Object... args
> 相当于接收一个Object[]数组，表示可以接收任意数量的对象，如果**输入是整形或者其他基本类型**，那么会**自动装箱**为对象！

### Enum
可以为枚举类型增加构造器、方法和字段
```java
enum Size
{
    //SMALL的缩写（abbreviation）是S
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");
    
    //构造器
    private Size(String abbreviation) { this.abbreviation = abbreviation; }
    
    //方法：得到缩写
    public String getAbbreviation() { return abbreviation; }
    
    //字段：用于保存缩写
    private String abbreviation;
}

```
枚举类的三个常用方法：
- toString：返回枚举常量名
```java
//以下两句等价
System.out.println("size.toString="+size.toString());
System.out.println("size=" + size);
```
- valueOf：toString方法的逆方法,将一个枚举变量设置为枚举常量元素
```java
Size s=Enum.valueOf(Size.class ,"SMALL");
```
- values：静态方法，返回一个包含全部枚举值的数组
```java
var values = Size.values();
for (int i = 0; i < 4; i++) {
    System.out.println(values[i].getAbbreviation());
}
```
### 反射
反射的内容十分之多，暂且也用不到，决定先跳过！

### 继承的设计技巧
1. **将公共操作和字段放在超类中**：如将name字段放在超类Person中，而不是子类Employee和Student类中
2. **不要使用受保护的字段**：①子类集合是无限制的，任何人都能通过派生子类来访问protected实例字段，从而破坏了封装性；②同一个包中的类都可访问protected字段，不管它们是否是这个类的子类
3. **使用继承实现”is-a“关系**：即extend
4. **在覆盖方法时，不要改变预期的行为**
5. **使用多态，而不要使用类型信息**
6. **不要滥用反射**
## CH06 接口、lambda表达式与内部类

### 一、接口
**comparator、interfaces、timer**

**一些知识点**
1. 接口中的所有方法都自动是public方法、所有字段都是public static final
2. 接口中绝对不会有实例字段，但可以提供多个**静态方法**（Java 8之后），还可以使用**default修饰符提供一个默认方法**！
3. 不能使用new运算符实例化接口，但是可以声明接口的变量，该变量必须引用实现了该接口的类对象
4. 每个类只能有一个超类，但却可以实现多个接口，这就是有了抽象类还引入接口的原因
5. **超类优先**：超类提供了一个具体方法，接口的具有相同签名的默认方法会被忽略
6. **覆盖解决冲突**：继承的两个接口提供了两个相同签名的默认方法，为了解决冲突，必须重写方法以覆盖解决冲突！

**代码知识概括**

排序的两种方式：

1. **Comparable<T>接口**

    类可以实现Comparable接口，实现接口中的CompareTo方法，若有一个存储该类的数组，则调用**Arrays.sort(数组名)实现排序**！
    
    **缺陷**：有时候我们需要对同一个类进行多种不同的排序，而每一个类只能实现一次compareTo方法！

    况且，如String类，它自身实现了comparable<String>接口中的compareTo方法，即根据字典顺序比较字符串，且我们是无法对该类进行修改的。
    
    那么如果我们想根据字符串长度进行比较该如何实现呢？这就需要引入Comparator<T>接口

2. **Comparator<T>接口**

   首先需要一个**比较器类**，该类实现Comparator<T>接口，实现接口中的compare方法
   
   其次一个普通的对象类，假设该类为String类，现在有一个String类组成的数组
   
   调用**Arrays(数组名,比较器)实现排序**
   
   其中比较器是比较器类的实例，可以通过**Arrays(数组名,new 比较器类名())实现排序**
   

**接口与回调**：指定某个特定事件发生时应该采取的动作！详见timer文件夹下的代码！

**对象克隆**：Cloneable接口，这个接口指示一个类提供了一个安全的clone方法

Object提供了一个clone()方法，是浅拷贝！

我们需要做的是实现深拷贝！

待续！

### 二、lambda表达式
**lambda**

**简介**：lambda表达式就是一段代码块，形式诸如`（参数类型1 参数名1，参数类型2 参数名2，...) -> { 表达式 }` 使用lambda表达式的主要目的是**延迟执行**。

**规则**：
1. 没有参数，仍需要提供()，即`() -> { 表达式 }`
2. 如果根据上下文可推导出参数类型，则可以省略参数类型，即`（参数名1，参数名2，...) -> { 表达式 }` 
3. 如果只有一个参数，且参数类型可推导，则可以省略(),即`参数名 -> { 表达式 }`
4. 若是表达式只有一句，则可以省略{}

无需指定返回类型，lambda的返回类型总是会由上下文推到得出！

**函数式接口**：**只有一个抽象方法的接口**，可以有其他非抽象方法，只要保证抽象方法只有一个即可！

**lambda表达式所能做的只是转化为函数式接口**，`java.util.function`中定义了许多通用的函数式接口，我们可以把一些lambda表达式保存在这些接口类型的变量中：

```java
BiFunction<String,String,Integer> comp = (first,second) -> first.length() - second.length();
```

不过这并没有什么意义，真正的作用如下：
有一些类的方法的参数是函数式接口，如ArrayList类中的removeIf方法，其参数是`java.util.function`中的接口Predicate，于是通过上述的原理，这个接口参数就是让我们传入一个lambda表达式的！

```java
//如果数组列表中存在null值，则删除！
list.removeIf(e - > e==null);
```

**方法引用**

**构造器引用**

方法引用和构造器引用非常复杂，详见Java核心卷Ⅰ P247


### 三、内部类
**InnerClass、anonymousInnerClass、staticInnerClass**

**简介**：内部类是定义在另一个类中的类，可以对同一个包中的其它类隐藏、且可以访问其外围类的数据，包括私有的数据。

**内部类的特殊语法规则**：
1. 在外围类的作用域之外，可以通过`OuterClass.InnerClass`来引用内部类。
2. 内部类不仅能访问外围类的字段，还可以访问局部变量。当前仅当该局部变量为**最终变量**，其原理是内部类会在局部变量消失之前，复制一份局部变量，该变量不会再改变，保存下来，因此需要局部变量是最终变量。


**局部内部类**：当一个内部类仅仅在某一个方法内使用，那么，可以在一个方法内局部的定义这个类。

**局部内部类的规则**
1. 声明局部类时不能有访问说明符，即public或private
2.  局部内对外部世界完全隐藏，除了其所在的方法，其余任何地方都不知道它的存在，哪怕是其方法所在的类也不知道局部内部类的存在。

**匿名内部类**：局部内部类的进一步简化，当你使用内部类只是为了创建这个类的一个对象时，**不需要为类指定名字**！

```java
//匿名内部类语法
new SuperType（construction parameters)
{
    inner class methods and data
}
```
`SuperType`可以是接口，那么内部类就要实现这个接口
```java
// ActionListener是一个接口，这一整句话的意思是：创建一个类的新对象，这个类实现了该接口！
var listener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("时间：" + Instant.ofEpochMilli(e.getWhen()));
        if (beep) {
            Toolkit.getDefaultToolkit().beep();
        }
    }
};
```
`SuperType`也可以是一个类，那么内部类就要扩展这个类

**匿名内部类的规则**

1. 匿名内部类没有构造器，因为构造器与类名相同， 匿名内部类无类名
2. 匿名内部类的习惯用法是实现**事件监听器和其他回调**，不过如今**lambda表达式**有更好的表现！

**匿名内部类和构造类对象的比较**

如果构造参数列表的结束小括号后面跟一个开始大括号，就是在定义匿名内部类。
```java
//构造Person类的新对象
var queen = new Person("Marry");

//构造扩展了Person类的匿名内部类的对象
var prince = new Person("Jack"){
    inner class methods and data
}
```

**lambda表达式和匿名内部类的比较**

前文已经提及，如今实现事件监听器和其他回调时，lambda会更简洁！
```java
//使用匿名内部类实现start方法
public void start(int interval,boolean beep) {

    var listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("时间：" + Instant.ofEpochMilli(e.getWhen()));
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    };
    var timer = new Timer(interval, listener);
    timer.start();
}
```

```java
//使用lambda实现start方法
public void start(int interval,boolean beep) {
    
    var timer = new Timer(interval,e -> {
        System.out.println("时间：" + Instant.ofEpochMilli(e.getWhen()));
        if (beep) {
            Toolkit.getDefaultToolkit().beep();
        }
    });
    timer.start();
}
```

**静态内部类**：有时候为了把一个类隐藏在另外一个类的内部，并不需要内部类有外围类对象的一个引用，为此可以将**内部类声明为static**，这样就不会生成那个引用。

**静态内部类的规则**
1. 当且仅当内部类不需要访问外围类对象时，才使用静态内部类！
2. 静态内部类可以有静态字段和方法，而非static的内部类，在外部类加载的时候，并不会加载它，所以它里面不能有静态变量或者静态方法。

详细使用参见代码：`StaticInnerClass.java`
