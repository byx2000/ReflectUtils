package byx.util.reflect.test;

import org.junit.jupiter.api.Test;

import static byx.util.reflect.ReflectUtils.setProperty;
import static org.junit.jupiter.api.Assertions.*;

public class SetPropertyTest
{
    public static class Student
    {
        private int id;
        private String name;
        private Double score;

        public int getId()
        {
            return id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public Double getScore()
        {
            return score;
        }

        public void setScore(Double score)
        {
            this.score = score;
        }
    }

    public static class Student2 extends Student
    {
        private boolean male;

        public boolean isMale()
        {
            return male;
        }

        public void setMale(boolean male)
        {
            this.male = male;
        }
    }

    @Test
    public void test()
    {
        Student r1 = new Student();
        setProperty(r1, "id", 1001);
        setProperty(r1, "name", "XiaoMing");
        setProperty(r1, "score", 97.5);
        assertEquals(1001, r1.getId());
        assertEquals("XiaoMing", r1.getName());
        assertEquals(97.5, r1.getScore());

        Student2 r2 = new Student2();
        setProperty(r2, "male", true);
        setProperty(r2, "name", "XiaoHong");
        assertTrue(r2.isMale());
        assertEquals("XiaoHong", r2.getName());

        assertThrows(RuntimeException.class, () -> setProperty(r1, "gender", "male"));
    }
}
