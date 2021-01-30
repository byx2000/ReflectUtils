package byx.util.reflect.test;

import static byx.util.reflect.ReflectUtils.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateTest
{
    @Test
    public void test()
    {
        A a = create(A.class);
        assertEquals(17, a.getAge());
        assertFalse(a.isFinish());

        a = create(A.class, 23);
        assertEquals(23, a.getAge());
        assertFalse(a.isFinish());

        a = create(A.class, true);
        assertEquals(17, a.getAge());
        assertTrue(a.isFinish());

        a = create(A.class, new B());
        assertEquals(17, a.getAge());
        assertFalse(a.isFinish());
        assertEquals(888, a.getB().getValue());

        a = create(A.class, new BB(123));
        assertEquals(17, a.getAge());
        assertFalse(a.isFinish());
        assertEquals(123, a.getB().getValue());

        a = create(A.class, 75, true);
        assertEquals(75, a.getAge());
        assertTrue(a.isFinish());

        a = create(A.class, true, 75);
        assertEquals(75, a.getAge());
        assertTrue(a.isFinish());

        assertThrows(RuntimeException.class, () -> create(A.class, 1, 2, 3));
        assertThrows(RuntimeException.class, () -> create(BB.class));
    }
}
