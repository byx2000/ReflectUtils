package byx.util.reflect.test;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static byx.util.reflect.ReflectUtils.call;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CallTest
{
    public static class A
    {
        private final int i;
        private final String s;

        public A(int i, String s)
        {
            this.i = i;
            this.s = s;
        }

        public static int staticMethod1()
        {
            return 123;
        }

        public static String staticMethod2(String s, int i, Double x)
        {
            return s + " " + i + " " + x;
        }

        public int instanceMethod1()
        {
            return i;
        }

        public String instanceMethod2(String ss, int i, Double x)
        {
            return s + " " + ss + " " + i + " " + x;
        }
    }

    @Test
    public void test()
    {
        String r1 = call(String.class, "valueOf", 123);
        assertEquals("123", r1);
        List<?> r2 = call(Collections.class, "emptyList");
        assertEquals(Collections.emptyList(), r2);
        List<Integer> r3 = call(List.class, "of", 1, 2, 3);
        assertEquals(List.of(1, 2, 3), r3);
        int r4 = call(A.class, "staticMethod1");
        assertEquals(123, r4);
        String r5 = call(A.class, "staticMethod2", "hello", 123, 3.14);
        assertEquals("hello 123 3.14", r5);

        assertThrows(RuntimeException.class, () -> call(String.class, "create"));
        assertThrows(RuntimeException.class, () -> call(A.class, "staticMethod2", 123, "hello"));

        int r6 = call("hello", "length");
        assertEquals(5, r6);
        String r7 = call("hello", "substring", 1, 4);
        assertEquals("ell", r7);
        int r8 = call(new A(1234, "hello"), "instanceMethod1");
        assertEquals(1234, r8);
        String r9 = call(new A(888, "hi"), "instanceMethod2", "hello", 999, 97.5);
        assertEquals("hi hello 999 97.5", r9);

        assertThrows(RuntimeException.class, () -> call("hello", "size"));
        assertThrows(RuntimeException.class, () -> call(new A(123, "hello"), "instanceMethod2", 123, "hello"));

        String r10 = call((Object) A.class, "getSimpleName");
        assertEquals("A", r10);

        int r11 = call(new Object(){
            public int f(int i) {
                return i + 100;
            }
        }, "f", 123);
        assertEquals(223, r11);
    }
}
