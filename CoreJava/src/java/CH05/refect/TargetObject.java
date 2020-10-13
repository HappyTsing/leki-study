package CH05.refect;

/**
 * @author QingHappy
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "leqing";
    }

    public void publicMethod() {
        System.out.println("This is publicMethod");
    }

    private void privateMethod() {
        System.out.println("This is privateMethod");
    }
}
