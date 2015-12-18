package untils;

<<<<<<< HEAD
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
=======
import org.apache.log4j.*;

import java.io.File;
import java.io.FileInputStream;
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c


public class Log {
	
	private static Logger log;
<<<<<<< HEAD
	private boolean flag=false;
=======
	private static boolean flag=false;
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c
	private static String filePath="config/log4j.properties";


	public Log(String name) {
<<<<<<< HEAD
		this.log = Logger.getLogger(name);
		this.getFlag();
	}


	private synchronized void getPropertyFile(){
=======
		log = Logger.getLogger(name);
	}


	private static synchronized void getPropertyFile(){
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c
		//log=Logger.getLogger("SCM-auto");
		PropertyConfigurator.configure (new File(filePath).getAbsolutePath());
		flag=true;

	}

<<<<<<< HEAD
	public void getFlag() {
		if (flag == false) {
			this.getPropertyFile();
		}
	}
	
	public static void info(String mes){
		log.info(mes);

	}
	
	public static void warn(String mes){
		//Log.getFlag();
=======
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
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c
		log.warn(mes);
	}
	
	public static void debug(String mes){
<<<<<<< HEAD
	   // Log.getFlag();
=======
	    Log.getFlag();
>>>>>>> 9e2112cdfd41f10de8e715d14725ed3f9596323c
		log.debug(mes);
	}
	
	
	
	

}
