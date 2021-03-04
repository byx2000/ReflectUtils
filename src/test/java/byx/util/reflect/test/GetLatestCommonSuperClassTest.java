package byx.util.reflect.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static byx.util.reflect.ReflectUtils.*;

public class GetLatestCommonSuperClassTest {
    public static class A {
    }

    public static class B {
    }

    public static class C extends B {
    }

    public static class D extends B {
    }

    public static class E extends A {
    }

    @Test
    public void test() {
        Class<?> r1 = getLatestCommonSuperClass(int.class, double.class);
        assertEquals(Object.class, r1);
        Class<?> r2 = getLatestCommonSuperClass(Object.class, String.class);
        assertEquals(Object.class, r2);
        Class<?> r3 = getLatestCommonSuperClass(double.class, Object.class);
        assertEquals(Object.class, r3);
        Class<?> r4 = getLatestCommonSuperClass(double.class, String.class);
        assertEquals(Object.class, r4);
        Class<?> r5 = getLatestCommonSuperClass(Integer.class, Double.class);
        assertEquals(Number.class, r5);
        Class<?> r6 = getLatestCommonSuperClass(Integer.class, Number.class);
        assertEquals(Number.class, r6);
        Class<?> r7 = getLatestCommonSuperClass(Number.class, Integer.class);
        assertEquals(Number.class, r7);
        Class<?> r8 = getLatestCommonSuperClass(C.class, D.class);
        assertEquals(B.class, r8);
        Class<?> r9 = getLatestCommonSuperClass(C.class, E.class);
        assertEquals(Object.class, r9);
        Class<?> r10 = getLatestCommonSuperClass(E.class, A.class);
        assertEquals(A.class, r10);
        Class<?> r11 = getLatestCommonSuperClass(A.class, B.class);
        assertEquals(Object.class, r11);
        Class<?> r12 = getLatestCommonSuperClass(A.class, A.class);
        assertEquals(A.class, r12);
        Class<?> r13 = getLatestCommonSuperClass(C.class, C.class);
        assertEquals(C.class, r13);
    }
}
