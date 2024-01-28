package Util;

import java.lang.reflect.Array;

public class Util {
    public static String[] reverse(String a[])
    {
        int n = a.length;
        String[] b = new String[n];
        int j = n;
        for (String s : a) {
            b[j - 1] = s;
            j = j - 1;
        }
        return b;
    }
    public static String removeLastChar(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(0, s.length() - 1));
    }
    public static Object expand(Object array) {
        int len = Array.getLength(array);
        return expand(array, len > 0 ? len << 1 : 1);
    }

    public static Object expand(Object list, int newSize) {
        Class<?> type = list.getClass().getComponentType();
        Object temp = Array.newInstance(type, newSize);
        System.arraycopy(list, 0, temp, 0, Math.min(Array.getLength(list), newSize));
        return temp;
    }
    public static Object append(Object array, Object value) {
        int length = Array.getLength(array);
        array = expand(array, length + 1);
        Array.set(array, length, value);
        return array;
    }
}
