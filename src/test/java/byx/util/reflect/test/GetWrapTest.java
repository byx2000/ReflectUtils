package byx.util.reflect.test;

import static byx.util.reflect.ReflectUtils.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetWrapTest
{
    @Test
    public void test()
    {
        assertEquals(Byte.class, getWrap(byte.class));
        assertEquals(Short.class, getWrap(short.class));
        assertEquals(Integer.class, getWrap(int.class));
        assertEquals(Long.class, getWrap(long.class));
        assertEquals(Float.class, getWrap(float.class));
        assertEquals(Double.class, getWrap(double.class));
        assertEquals(Character.class, getWrap(char.class));
        assertEquals(Boolean.class, getWrap(boolean.class));

        assertEquals(Byte.class, getWrap(Byte.class));
        assertEquals(Short.class, getWrap(Short.class));
        assertEquals(Integer.class, getWrap(Integer.class));
        assertEquals(Long.class, getWrap(Long.class));
        assertEquals(Float.class, getWrap(Float.class));
        assertEquals(Double.class, getWrap(Double.class));
        assertEquals(Character.class, getWrap(Character.class));
        assertEquals(Boolean.class, getWrap(Boolean.class));

        assertEquals(String.class, getWrap(String.class));
        assertEquals(A.class, getWrap(A.class));
    }
}
