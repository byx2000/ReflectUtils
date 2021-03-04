package byx.util.reflect.test;

import org.junit.jupiter.api.Test;

import static byx.util.reflect.ReflectUtils.getPrimitive;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetPrimitiveTest {
    public static class A {
    }

    @Test
    public void test() {
        assertEquals(byte.class, getPrimitive(Byte.class));
        assertEquals(short.class, getPrimitive(Short.class));
        assertEquals(int.class, getPrimitive(Integer.class));
        assertEquals(long.class, getPrimitive(Long.class));
        assertEquals(float.class, getPrimitive(Float.class));
        assertEquals(double.class, getPrimitive(Double.class));
        assertEquals(char.class, getPrimitive(Character.class));
        assertEquals(boolean.class, getPrimitive(Boolean.class));

        assertEquals(byte.class, getPrimitive(byte.class));
        assertEquals(short.class, getPrimitive(short.class));
        assertEquals(int.class, getPrimitive(int.class));
        assertEquals(long.class, getPrimitive(long.class));
        assertEquals(float.class, getPrimitive(float.class));
        assertEquals(double.class, getPrimitive(double.class));
        assertEquals(char.class, getPrimitive(char.class));
        assertEquals(boolean.class, getPrimitive(boolean.class));

        assertEquals(String.class, getPrimitive(String.class));
        assertEquals(A.class, getPrimitive(A.class));
    }
}
