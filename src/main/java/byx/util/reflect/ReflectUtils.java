package byx.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtils
{
    private static final Map<Class<?>, Class<?>> primitiveAndWrap = new HashMap<>();

    static
    {
        primitiveAndWrap.put(byte.class, Byte.class);
        primitiveAndWrap.put(short.class, Short.class);
        primitiveAndWrap.put(int.class, Integer.class);
        primitiveAndWrap.put(long.class, Long.class);
        primitiveAndWrap.put(float.class, Float.class);
        primitiveAndWrap.put(double.class, Double.class);
        primitiveAndWrap.put(char.class, Character.class);
        primitiveAndWrap.put(boolean.class, Boolean.class);
    }

    /**
     * 判断是不是基本类型
     * @param type 类型
     * @return 如果type是基本类型，则返回true，否则返回false
     */
    public static boolean isPrimitive(Class<?> type)
    {
        return primitiveAndWrap.containsKey(type);
    }

    /**
     * 获取包装类型
     * @param type 类型
     * @return 如果type是基本类型，则返回对应的包装类型，否则返回type
     */
    public static Class<?> getWrap(Class<?> type)
    {
        if (!isPrimitive(type)) return type;
        return primitiveAndWrap.get(type);
    }

    /**
     * 获取基本类型
     * @param type 类型
     * @return 如果type是包装类型，则返回对应的基本类型，否则返回type
     */
    public static Class<?> getPrimitive(Class<?> type)
    {
        for (Class<?> key : primitiveAndWrap.keySet())
        {
            if (primitiveAndWrap.get(key) == type) return key;
        }
        return type;
    }

    /**
     * 创建对象
     * @param type 类型
     * @param params 构造函数参数
     * @param <T> 类型
     * @return 通过调用特定构造函数创建的对象
     */
    public static <T> T create(Class<T> type, Object... params)
    {
        for (Constructor<?> constructor : type.getConstructors())
        {
            try
            {
                return type.cast(constructor.newInstance(params));
            }
            catch (Exception ignored) {}
        }
        throw new RuntimeException("No matching constructor.");
    }

    /**
     * 调用静态方法
     * @param type 类型
     * @param methodName 方法名
     * @param params 参数
     * @return 静态方法的返回值
     */
    public static Object call(Class<?> type, String methodName, Object... params)
    {
        for (Method method : type.getMethods())
        {
            if (method.getName().equals(methodName))
            {
                try
                {
                    return method.invoke(null, params);
                }
                catch (Exception ignored) {}
            }
        }
        throw new RuntimeException("No matching static method.");
    }
}
