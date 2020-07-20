import com.wang.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //    获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //        Index index = (Index) context.getBean("index");
        //         getBean的参数是beans.xml中的id值
//        Service service = (Service) context.getBean("service");
        People people = (People) context.getBean("people");
        people.getCat().name();
        people.getDog().name();
    }
}
