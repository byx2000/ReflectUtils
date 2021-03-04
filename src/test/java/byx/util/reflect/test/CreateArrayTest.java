package byx.util.reflect.test;

import byx.util.reflect.ReflectUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static byx.util.reflect.ReflectUtils.*;

public class CreateArrayTest {
    public static class A {
    }

    public static class B extends A {
    }

    @Test
    public void test() {
        int[] intArray = createArray(int.class, 1, 2, 3);
        assertTrue(Arrays.equals(new int[]{1, 2, 3}, intArray));
        Integer[] integerArray = createArray(Integer.class, 4, 5, 6);
        assertTrue(Arrays.equals(new Integer[]{4, 5, 6}, integerArray));
        String[] stringArray = createArray(String.class, "aaa", "bbb", "ccc");
        assertTrue(Arrays.equals(new String[]{"aaa", "bbb", "ccc"}, stringArray));
        Object[] objectArray = createArray(Object.class, 123, "hello", 3.14);
        assertTrue(Arrays.equals(new Object[]{123, "hello", 3.14}, objectArray));
        B[] b = createArray(B.class, new B(), new B(), new B());
        A[] a = createArray(A.class, new B(), new B(), new B());
        A[] aa = createArray(B.class, new B(), new B(), new B());
    }
}
