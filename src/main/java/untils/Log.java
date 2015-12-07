package untils;

import org.apache.log4j.*;

import java.io.File;
import java.io.FileInputStream;


public class Log {
	
	private static Logger log;
	private static boolean flag=false;
	private static String filePath="config/log4j.properties";


	public Log(String name) {
		log = Logger.getLogger(name);
	}


	private static synchronized void getPropertyFile(){
		//log=Logger.getLogger("SCM-auto");
		PropertyConfigurator.configure (new File(filePath).getAbsolutePath());
		flag=true;

	}

	public static void getFlag() {
		if (flag == false) {
			Log.getPropertyFile();
		}
	}
	
	public static FileInputStream info(String mes){
		Log.getFlag();
		log.info(mes);
		return null;
	}
	
	public static void warn(String mes){
		Log.getFlag();
		log.warn(mes);
	}
	
	public static void debug(String mes){
	    Log.getFlag();
		log.debug(mes);
	}
	
	
	
	

}
