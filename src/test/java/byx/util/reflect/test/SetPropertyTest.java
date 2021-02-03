package byx.util.reflect.test;

import static byx.util.reflect.ReflectUtils.*;
import byx.util.reflect.test.classes.Test4;
import byx.util.reflect.test.classes.Test5;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SetPropertyTest
{
    @Test
    public void test()
    {
        Test4 t1 = new Test4();
        setProperty(t1, "id", 1001);
        assertEquals(1001, t1.getId());
        setProperty(t1, "name", "byx");
        assertEquals("byx", t1.getName());
        setProperty(t1, "score", 87.5);
        assertEquals(87.5, t1.getScore());

        Test5 t2 = new Test5();
        setProperty(t2, "name", "aaa");
        assertEquals("aaa", t2.getName());
    }
}
