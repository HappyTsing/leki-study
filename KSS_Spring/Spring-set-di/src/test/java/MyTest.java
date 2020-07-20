import com.wang.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class MyTest {
    public static void main(String[] args) {
        //    获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //        Index index = (Index) context.getBean("index");
        //         getBean的参数是beans.xml中的id值
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());

        //Student{
        // name='王乐卿',
        // address=Address{address='浙江省嘉兴市'},
        // books=[红楼梦, 水浒传, 西游记],
        // hobbys=[看电影, 听歌, 打代码],
        // games=[王者荣耀, 英雄联盟, 穿越火线],
        // wife='null',
        // info={password=value of passwoed, driver=value of driver}}
    }
//    @Test
//        public void Test2(){
//
//
//        }


}
