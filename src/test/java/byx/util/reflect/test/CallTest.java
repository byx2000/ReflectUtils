package byx.util.reflect.test;

import static byx.util.reflect.ReflectUtils.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CallTest
{
    @Test
    public void test()
    {
        int i = (int) call(A.class, "getInt");
        assertEquals(7749, i);

        A a = (A) call(A.class, "create", 4321);
        assertEquals(4321, a.getAge());

        assertThrows(RuntimeException.class, () -> call(A.class, "create", 4321, true));

        assertThrows(RuntimeException.class, () -> call(A.class, "create1", 4321));
    }
}
