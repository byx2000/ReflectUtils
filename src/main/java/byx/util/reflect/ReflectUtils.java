package byx.util.reflect;

import java.beans.PropertyDescriptor;
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
        try
        {
            Constructor<?> constructor = type.getConstructor(getTypes(params));
            return type.cast(constructor.newInstance(params));
        }
        catch (Exception e)
        {
            for (Constructor<?> constructor : type.getConstructors())
            {
                if (constructor.getParameterCount() == params.length)
                {
                    try
                    {
                        return type.cast(constructor.newInstance(params));
                    }
                    catch (Exception ignored) {}
                }
            }
            throw new RuntimeException("No matching constructor: " + type.getName());
        }
    }

    /**
     * 调用静态方法
     * @param type 类型
     * @param methodName 方法名
     * @param params 参数
     * @param <T> 返回类型
     * @return 静态方法的返回值
     */
    @SuppressWarnings("unchecked")
    public static <T> T call(Class<?> type, String methodName, Object... params)
    {
        try
        {
            Method method = type.getMethod(methodName, getTypes(params));
            return (T) method.invoke(null, params);
        }
        catch (Exception e)
        {
            for (Method method : type.getMethods())
            {
                if (method.getName().equals(methodName) && method.getParameterCount() == params.length)
                {
                    try
                    {
                        return (T) method.invoke(null, params);
                    }
                    catch (Exception ignored) {}
                }
            }
            throw new RuntimeException("No matching static method: " + methodName);
        }
    }

    /**
     * 调用实例方法
     * @param obj 实例对象
     * @param methodName 方法名
     * @param params 参数
     * @param <T> 返回类型
     * @return 实例方法的返回值
     */
    @SuppressWarnings("unchecked")
    public static <T> T call(Object obj, String methodName, Object... params)
    {
        try
        {
            Method method = obj.getClass().getMethod(methodName, getTypes(params));
            return (T) method.invoke(obj, params);
        }
        catch (Exception e)
        {
            for (Method method : obj.getClass().getMethods())
            {
                if (method.getName().equals(methodName) && method.getParameterCount() == params.length)
                {
                    try
                    {
                        return (T) method.invoke(obj, params);
                    }
                    catch (Exception ignored) {}
                }
            }
            throw new RuntimeException("No matching method: " + methodName);
        }
    }

    /**
     * 设置JavaBean的属性
     * @param bean JavaBean实例
     * @param propertyName 属性名
     * @param value 值
     */
    public static void setProperty(Object bean, String propertyName, Object value)
    {
        try
        {
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, bean.getClass());
            Method setter = pd.getWriteMethod();
            setter.invoke(bean, value);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private static Class<?>[] getTypes(Object... params)
    {
        Class<?>[] types = new Class[params.length];
        for (int i = 0; i < params.length; ++i)
        {
            types[i] = params[i].getClass();
        }
        return types;
    }
}
