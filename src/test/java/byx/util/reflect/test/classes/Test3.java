package byx.util.reflect.test.classes;

public class Test3
{
    public int i;
    public Double d;
    public String s;
    public boolean called = false;

    public void m1()
    {
        called = true;
    }

    public void m2(int i)
    {
        this.i = i;
    }

    public int m3(Double d, String s)
    {
        this.d = d;
        this.s = s;
        return i;
    }
}
