package org.river.sealand.utils;

import java.lang.reflect.Array;

public class ArrayUtils {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    
	/**
	 * <p>
	 * 该方法实现来自apache common-lang
	 * @param array
	 * @param startIndexInclusive
	 * @param endIndexExclusive
	 * @return
	 */
    public static Object[] subarray(Object[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        int newSize = endIndexExclusive - startIndexInclusive;
        Class<?> type = array.getClass().getComponentType();
        if (newSize <= 0) {
            return (Object[]) Array.newInstance(type, 0);
        }
        Object[] subarray = (Object[]) Array.newInstance(type, newSize);
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }
    
	/**
	 * <p>
	 * 该方法实现来自apache common-lang
	 * @param array
	 * @param startIndexInclusive
	 * @param endIndexExclusive
	 * @return
	 */
    public static byte[] subarray(byte[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        int newSize = endIndexExclusive - startIndexInclusive;
        if (newSize <= 0) {
            return EMPTY_BYTE_ARRAY;
        }

        byte[] subarray = new byte[newSize];
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }
}
