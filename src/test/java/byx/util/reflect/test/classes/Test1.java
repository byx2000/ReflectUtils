package byx.util.reflect.test.classes;

public class Test1
{
    public int i;
    public Double d;
    public String s;
    public boolean flag = false;

    public Test1()
    {
        flag = true;
    }

    public Test1(int i)
    {
        this.i = i;
    }

    public Test1(Double d)
    {
        this.d = d;
    }

    public Test1(String s)
    {
        this.s = s;
    }

    public Test1(int i, Double d, String s)
    {
        this.i = i;
        this.d = d;
        this.s = s;
    }
}
