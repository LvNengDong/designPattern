package geek._28.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/3 14:46
 */
public class TestCaseRunner {
    public static void main(String[] args) {
        System.out.println("Run testToNumber()");
        new TextTest().testToNumber();
        System.out.println("Run testToNumber_nullorEmpty()");
        new TextTest().testToNumber_nullorEmpty();
        System.out.println("Run testToNumber_containsLeadingAndTrailingSpaces()");
        new TextTest().testToNumber_containsLeadingAndTrailingSpaces();
        System.out.println("Run testToNumber_containsMultiLeadingAndTrailingSpaces()");
        new TextTest().testToNumber_containsMultiLeadingAndTrailingSpaces();
        System.out.println("Run testToNumber_containsInvalidCharaters()");
        new TextTest().testToNumber_containsInvalidCharaters();
    }
}
