package byx.util.reflect.test;

import static byx.util.reflect.ReflectUtils.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsPrimitiveTest
{
    @Test
    public void test()
    {
        assertTrue(isPrimitive(byte.class));
        assertTrue(isPrimitive(short.class));
        assertTrue(isPrimitive(int.class));
        assertTrue(isPrimitive(long.class));
        assertTrue(isPrimitive(float.class));
        assertTrue(isPrimitive(double.class));
        assertTrue(isPrimitive(char.class));
        assertTrue(isPrimitive(boolean.class));

        assertFalse(isPrimitive(Byte.class));
        assertFalse(isPrimitive(Short.class));
        assertFalse(isPrimitive(Integer.class));
        assertFalse(isPrimitive(Long.class));
        assertFalse(isPrimitive(Float.class));
        assertFalse(isPrimitive(Double.class));
        assertFalse(isPrimitive(Character.class));
        assertFalse(isPrimitive(Boolean.class));

        assertFalse(isPrimitive(String.class));
        assertFalse(isPrimitive(A.class));
    }
}
