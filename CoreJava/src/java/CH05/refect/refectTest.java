package CH05.refect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class refectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class targetClass = Class.forName("CH05.refect.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.getConstructor().newInstance();

        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println(method.getName());
            method.setAccessible(true);
            method.invoke(targetObject);
        }


    }
}
