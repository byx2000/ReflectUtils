package byx.util.reflect.test;

import static byx.util.reflect.ReflectUtils.*;
import byx.util.reflect.test.classes.Test1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateTest
{
    @Test
    public void test()
    {
        Test1 t1 = create(Test1.class);
        assertTrue(t1.flag);

        Test1 t2 = create(Test1.class, 100);
        assertEquals(100, t2.i);

        Test1 t3 = create(Test1.class, 3.14);
        assertEquals(3.14, t3.d);

        Test1 t4 = create(Test1.class, "hello");
        assertEquals("hello", t4.s);

        Test1 t5 = create(Test1.class, 123, 88.5, "hi");
        assertEquals(123, t5.i);
        assertEquals(88.5, t5.d);
        assertEquals("hi", t5.s);

        assertThrows(RuntimeException.class, () -> create(Test1.class, "hello", "hi"));
    }
}
