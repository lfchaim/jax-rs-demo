package br.com.whs.jaxrsdemo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtil {

	public boolean write( String dirName, String fileName, String content, boolean append ){
		FileWriter f = null;
		BufferedWriter b = null;
		boolean ret = false;
		if( !exists(dirName) )
			mkdirs(dirName);
		try {
			f = new FileWriter(new File(dirName,fileName),append);
			b = new BufferedWriter(f);
			b.write(content);
			b.flush();
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{b.close();}catch(Exception e){}
			try{f.close();}catch(Exception e){}
		}
		return ret;
	}
	
	public String read( String dirName, String fileName ){
		FileReader f = null;
		BufferedReader b = null;
		String ret = null;
		StringBuffer sb = new StringBuffer();
		if( !exists(dirName, fileName) )
			return ret;
		try {
			f = new FileReader(new File(dirName,fileName));
			b = new BufferedReader(f);
			String line = null;
			while((line=b.readLine()) != null){
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{b.close();}catch(Exception e){}
			try{f.close();}catch(Exception e){}
		}
		return ret;
	}
	
	public static boolean exists(String dir, String name){
		return new File(dir,name).exists();
	}

	public static boolean exists(String dir){
		return new File(dir).exists();
	}
	
	public static boolean mkdirs( String dir ){
		return new File(dir).mkdirs();
	}

}
