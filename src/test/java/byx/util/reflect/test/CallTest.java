package byx.util.reflect.test;

import byx.util.reflect.test.classes.Test2;
import byx.util.reflect.test.classes.Test3;
import org.junit.jupiter.api.Test;

import static byx.util.reflect.ReflectUtils.call;
import static org.junit.jupiter.api.Assertions.*;

public class CallTest
{
    @Test
    public void test()
    {
        assertEquals(100, call(Test2.class, "sm1"));
        assertNull(call(Test2.class, "sm2"));
        assertTrue(Test2.called);
        assertEquals("hello: byx", call(Test2.class, "sm3", "byx"));
        assertEquals(5, call(Test2.class, "sm4", 2, 3));

        assertThrows(RuntimeException.class, () -> call(Test2.class, "sm4", 2));
        assertThrows(RuntimeException.class, () -> call(Test2.class, "sm4", "hello"));
        assertThrows(RuntimeException.class, () -> call(Test2.class, "sm5"));

        Test3 t = new Test3();
        assertNull(call(t, "m1"));
        assertTrue(t.called);

        assertNull(call(t, "m2", 100));
        assertEquals(100, t.i);

        assertEquals(100, call(t, "m3", 3.14, "hello"));
        assertEquals(3.14, t.d);
        assertEquals("hello", t.s);

        assertEquals("java.lang.Integer", call((Object) Integer.class, "getName"));

        assertThrows(RuntimeException.class, () -> call(t, "m3", 3.14, "hello", 100));
        assertThrows(RuntimeException.class, () -> call(t, "m4", 100));
        assertThrows(RuntimeException.class, () -> call(null, "m2", 100));
        assertThrows(RuntimeException.class, () -> call(Integer.class, "getName"));
    }
}
