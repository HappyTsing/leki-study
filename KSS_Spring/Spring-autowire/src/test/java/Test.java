import com.wang.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //    获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = (People) context.getBean("people");
        //        Index index = (Index) context.getBean("index");
        //        Service service = (Service) context.getBean("service");
        //        getBean的参数是beans.xml中的id值
        people.getCat().name();
        people.getDog().name();
    }
}
