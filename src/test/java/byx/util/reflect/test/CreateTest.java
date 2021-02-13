package byx.util.reflect.test;

import static byx.util.reflect.ReflectUtils.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateTest
{
    public static class A
    {
        public int i;
        public Double x;
        public String s;

        public A()
        {
            this.i = 123;
            this.x = 3.14;
            this.s = "hello";
        }

        public A(int i, Double x, String s)
        {
            this.i = i;
            this.x = x;
            this.s = s;
        }
    }

    @Test
    public void test()
    {
        String r1 = create(String.class);
        assertEquals("", r1);
        String r2 = create(String.class, "hello");
        assertEquals("hello", r2);
        int r3 = create(Integer.class, 123);
        assertEquals(123, r3);
        A r4 = create(A.class);
        assertEquals(123, r4.i);
        assertEquals(3.14, r4.x);
        assertEquals("hello", r4.s);
        A r5 = create(A.class, 888, 97.5, "hi");
        assertEquals(888, r5.i);
        assertEquals(97.5, r5.x);
        assertEquals("hi", r5.s);

        assertThrows(RuntimeException.class, () -> create(Integer.class));
        assertThrows(RuntimeException.class, () -> create(A.class, "hello", 123));
    }
}
