package byx.util.reflect.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static byx.util.reflect.ReflectUtils.*;

public class GetSuperClassesTest {
    public static class A {
    }

    public static class B extends A {
    }

    public static class C extends B {
    }

    @Test
    public void test() {
        List<Class<?>> r1 = getSuperClasses(Object.class);
        assertEquals(List.of(), r1);
        List<Class<?>> r2 = getSuperClasses(int.class);
        assertEquals(List.of(), r2);
        List<Class<?>> r3 = getSuperClasses(Integer.class);
        assertEquals(List.of(Number.class, Object.class), r3);
        List<Class<?>> r4 = getSuperClasses(A.class);
        assertEquals(List.of(Object.class), r4);
        List<Class<?>> r5 = getSuperClasses(B.class);
        assertEquals(List.of(A.class, Object.class), r5);
        List<Class<?>> r6 = getSuperClasses(C.class);
        assertEquals(List.of(B.class, A.class, Object.class), r6);
    }
}
