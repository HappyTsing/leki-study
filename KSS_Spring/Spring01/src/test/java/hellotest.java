import com.wang.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class hellotest {
    public static void main(String[] args) {
        //    获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello myhello =(Hello) context.getBean("hello");
        //     getBean的参数是beans.xml中的id值
        System.out.println(myhello.toString());
    }
}
