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

语法：obj instanceof class
用于检测左边的对象是否是右边的类的实例：  
  
1. 子类对象一定是父类的实例
    
2. 父类对象不是子类的实例          
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
    - hashCode()
 