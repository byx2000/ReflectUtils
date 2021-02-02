package byx.util.reflect.test;

import static byx.util.reflect.ReflectUtils.*;
import byx.util.reflect.test.classes.Test2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CallTest
{
    @Test
    public void test()
    {
        assertEquals(100, call(Test2.class, "sm1"));
        call(Test2.class, "sm2");
        assertTrue(Test2.called);
        assertEquals("hello: byx", call(Test2.class, "sm3", "byx"));
        assertEquals(5, call(Test2.class, "sm4", 2, 3));

        assertThrows(RuntimeException.class, () -> call(Test2.class, "sm4", 2));
        assertThrows(RuntimeException.class, () -> call(Test2.class, "sm4", "hello"));
        assertThrows(RuntimeException.class, () -> call(Test2.class, "sm5"));
    }
}
