package Util;

public class Util {
    public static Object[] append(Object[] array1,Object content){
        Object[] array2 = new Object[]{content};
        Object[] array = new Object[array1.length + array2.length];
        System.arraycopy(array1, 0, array, 0, array1.length);
        System.arraycopy(array2, 0, array, array1.length, array2.length);
        return array;
    }
}
