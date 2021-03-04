package byx.util.reflect.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static byx.util.reflect.ReflectUtils.*;

public class GetReturnTypeTest {
    public static class A {
        public static int getInt() {
            return 123;
        }

        public Double getDouble(int x) {
            return 3.14 + x;
        }
    }

    @Test
    public void test() {
        Class<?> r1 = getReturnType(String.class, "valueOf", Integer.class);
        assertEquals(r1, String.class);
        Class<?> r2 = getReturnType(String.class, "length");
        assertEquals(r2, int.class);
        Class<?> r3 = getReturnType(String.class, "substring", int.class, int.class);
        assertEquals(r3, String.class);
        Class<?> r4 = getReturnType(A.class, "getInt");
        assertEquals(r4, int.class);
        Class<?> r5 = getReturnType(A.class, "getDouble", int.class);
        assertEquals(r5, Double.class);

        assertThrows(RuntimeException.class, () -> getReturnType(String.class, "create"));
        assertThrows(RuntimeException.class, () -> getReturnType(String.class, "substring", int.class, double.class));
        assertThrows(RuntimeException.class, () -> getReturnType(A.class, "getInt", int.class));
    }
}
