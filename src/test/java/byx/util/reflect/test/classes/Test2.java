package byx.util.reflect.test.classes;

public class Test2
{
    public static boolean called = false;

    public static int sm1()
    {
        return 100;
    }

    public static void sm2()
    {
        called = true;
    }

    public static String sm3(String s)
    {
        return "hello: " + s;
    }

    public static int sm4(int a, int b)
    {
        return a + b;
    }
}
