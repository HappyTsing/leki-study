# Java核心卷Ⅰ代码重现
近日重读Java核心卷Ⅰ，打算手撸课本上的所有代码以加深对Java基础的理解，现在就开始！

## CH02
### Welcome.java
经典入门代码，打印hello！

## CH03
### FirstSample.java
java中三种注释的使用
### InputTest.java
标准输入流System.in和Scanner对象实现读取输入
### Retirement.java
三种循环：while dowhile for的简单使用
格式化输出printf
> 本章节还有很多代码没有实现，待续！

## CH04
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