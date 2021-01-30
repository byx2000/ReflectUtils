package byx.util.reflect.test;

public class A
{
    private int age;
    private boolean finish;
    private B b;

    public A()
    {
        age = 17;
        finish = false;
        b = new B();
    }

    public A(int age)
    {
        this.age = age;
        finish = false;
        b = new B();
    }

    public A(Boolean finish)
    {
        age = 17;
        this.finish = finish;
        b = new B();
    }

    public A(B b)
    {
        age = 17;
        finish = false;
        this.b = b;
    }

    public A(int age, boolean finish)
    {
        this.age = age;
        this.finish = finish;
    }

    public A(Boolean finish, int age)
    {
        this.age = age;
        this.finish = finish;
    }

    /*public A(Integer age, boolean finish)
    {
        this.age = age;
        this.finish = finish;
    }

    public A(int age, Boolean finish)
    {
        this.age = age;
        this.finish = finish;
    }

    public A(Integer age, Boolean finish)
    {
        this.age = age;
        this.finish = finish;
    }*/

    public int getAge()
    {
        return age;
    }

    public boolean isFinish()
    {
        return finish;
    }

    public B getB()
    {
        return b;
    }

    @Override
    public String toString()
    {
        return "A{" + "age=" + age + ", finish=" + finish + '}';
    }
}
