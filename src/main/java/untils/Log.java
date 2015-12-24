package untils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;



public class Log {
	
	private static Logger log;

	private boolean flag=false;

	private static String filePath="config/log4j.properties";


	public Log(String name) {

		this.log = Logger.getLogger(name);
		this.getFlag();
	}




	private synchronized void getPropertyFile(){

		//log=Logger.getLogger("SCM-auto");
		PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
		flag=true;

	}


	public void getFlag() {
		if (flag == false) this.getPropertyFile();
	}
	

	
	public static void info(String mes){

		log.info(mes);

	}
	
	public static void warn(String mes){


		log.warn(mes);
	}
	
	public static void debug(String mes){

	   // Log.getFlag();



		log.debug(mes);
	}
	
	
	
	

}
