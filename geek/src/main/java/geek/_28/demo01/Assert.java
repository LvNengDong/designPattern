package geek._28.demo01;

import java.util.Objects;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/3 14:44
 */
public class Assert {
    public static void assertEquals(Integer expectedValue, Integer actualValue) {
        if (!Objects.equals(actualValue, expectedValue)) {
            String message = String.format(
                    "Test failed, expected: %d, actual: %d.", expectedValue, actualValue);
            System.out.println(message);
        } else {
            System.out.println("Test succeeded.");
        }
    }

    public static boolean assertNull(Integer actualValue) {
        boolean isNull = actualValue == null;
        if (isNull) {
            System.out.println("Test succeeded.");
        } else {
            System.out.println("Test failed, the value is not null:" + actualValue);
        }
        return isNull;
    }
}
