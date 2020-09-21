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