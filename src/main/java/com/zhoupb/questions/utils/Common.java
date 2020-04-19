package com.zhoupb.questions.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Common {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 判断src字符串和dest字符串是否相似
	 * 
	 * @param src
	 * @param dest
	 * @param count 允许不同的字符的个数，n越少，越相似
	 * @return
	 */
	public static boolean isSimilar(String src, String dest, int count) {
		if (src == null || src.length() == 0 || dest == null || dest.length() == 0 || count > 0)
			return false;
		int n = src.length(), m = dest.length();
		char[] a = new char[n + 1];
		char[] b = new char[m + 1];
		System.arraycopy(src.toCharArray(), 0, a, 1, n);
		System.arraycopy(dest.toCharArray(), 0, b, 1, m);
		int f[][] = new int[n + 5][m + 5];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) {
				f[i][j] = Math.max(f[i - 1][j], f[i - 1][j]);
				if (a[i] == b[j])
					f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
			}
		return Math.max(n, m) - f[n][m] <= count;
	}
	
	/**
	 * 对象转json
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String objectToString(Object object) {
        try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        return null;
    }

	/**
	 * json转对象
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
    public static <T> T stringToObject(String json,Class<T> clazz) {
        try {
			return objectMapper.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
        return null;
    }

}
