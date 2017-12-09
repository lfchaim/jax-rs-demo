package br.com.whs.jaxrsdemo.db;

import java.io.File;

import br.com.whs.jaxrsdemo.util.FileUtil;

public class BigDB {

	private static final String DATA_PATH = "/temp/jaxrsdemo";
	
	private String read( String document ){
		FileUtil fu = new FileUtil();
		String content = fu.read(DATA_PATH, document);
		return content;
	}
	
	private boolean write( String document, String content ){
		FileUtil fu = new FileUtil();
		if( !dirExist(DATA_PATH) )
			createDir(DATA_PATH);
		boolean ret = fu.write(DATA_PATH, document, content, false);
		return ret;
	}
	
	public boolean add( String document, String content ){
		String currCont = read(document);
		boolean ret = false;
		if( currCont == null || currCont.trim().length() < 1 ){
			ret = write(document,content);
		}
		return ret;
	}
	
	public String select( String document ){
		return read(document);
	}
	
	private boolean dirExist( String dir ){
		return new File(dir).exists();
	}

	private boolean createDir( String dir ){
		return new File(dir).mkdirs();
	}
}
