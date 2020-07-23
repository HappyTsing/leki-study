import com.wang.AppConfig;
import com.wang.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
//    public static void main(String[] args) {

    @org.junit.Test
    public void Testjunit(){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        User myUser = context.getBean("myUser",User.class);
//        User myUser = (User) context.getBean("getUser");
        System.out.println(myUser.getName());
    }
}
