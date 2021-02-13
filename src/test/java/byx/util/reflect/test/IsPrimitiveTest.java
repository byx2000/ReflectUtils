package byx.util.reflect.test;

import org.junit.jupiter.api.Test;

import static byx.util.reflect.ReflectUtils.isPrimitive;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPrimitiveTest
{
    public static class A {}

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
