package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Reflection {
    private static void printArray(Object[] arr) {
        for (Object o : arr) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        Field[] fields = stringClass.getDeclaredFields();
        Constructor[] constructors = stringClass.getDeclaredConstructors();
        System.out.println("== Methods ==");
        printArray(methods);
        
        String s = "abc";
        String s2 = s.replaceAll("a", "x");
        System.out.println(s2);

        Class<String> c = String.class;

        Method m = c.getDeclaredMethod("replaceAll", c, c);
        Object res = m.invoke(s, "a", "x");
        if (m.getReturnType() == c) {
            String resString = (String) res;
            System.out.println(resString);
        }
    }
}
