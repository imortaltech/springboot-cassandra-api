package com.hcl.poc.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class ServiceUtils {

	/**
	 * Util method to get randomized integer
	 */
	public int getInteger(int start,int end) {
		Random rand = new Random();
		int generatedInteger = rand.nextInt(end-start) + start;
		
		return generatedInteger;
	}
	
	/**
	 * Utils method to get randomized String
	 */
	public String getString(int size) {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(size)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	    
	    return generatedString;
	}
	
	/**
	 * Utils method to get random element from list
	 */
	public String getRandomElementFromString(List<String> list) {
		Random r = new Random();
	    int randomitem = r.nextInt(list.size());
	    
	    return list.get(randomitem);
	}
	
	/**
	 * random date in String format
	 */
	public String getRandomDate() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	/**
	 * random file generation with dummy content
	 */
	public File generateRandomFile(String fileName) throws IOException{
			File file = new File(fileName);
			PrintWriter writer = new PrintWriter(file, "UTF-8");

			Random random = new Random();
			for(int i = 0; i < 100; i++)
			{
				char[] word = new char[random.nextInt(8)+3];
				for(int j = 0; j < word.length; j++)
				{
					word[j] = (char)('a' + random.nextInt(26));

				}
				writer.print(new String(word) + ' ');
			}
			writer.close();

		return file;
	}

}
