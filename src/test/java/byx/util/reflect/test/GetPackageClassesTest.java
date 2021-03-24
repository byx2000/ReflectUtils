package byx.util.reflect.test;

import byx.util.reflect.ReflectUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GetPackageClassesTest {
    @Test
    public void test() {
        List<Class<?>> classes = ReflectUtils.getPackageClasses("byx.util.reflect.test");

        assertFalse(classes.isEmpty());

        /*for (Class<?> c : classes) {
            System.out.println(c.getName());
        }*/
    }
}
