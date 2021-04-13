package com.zetcode.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadData {
	
	public static <T> String getFile(Class<T> clazz, String fileName)
	{
		StringBuffer sb = new StringBuffer();
		
		try {
			InputStream inputStream = clazz.getResourceAsStream(fileName);
			InputStreamReader isReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(isReader);
			
			String str;
			while((str = reader.readLine())!= null)
			{
				sb.append(str);
				sb.append('\r');
				sb.append('\n');
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}

}
