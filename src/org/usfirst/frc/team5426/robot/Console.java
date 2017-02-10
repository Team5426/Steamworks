package org.usfirst.frc.team5426.robot;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class Console extends Thread implements Runnable {

	private static Console instance;
  
	private static List<String> messageList = new CopyOnWriteArrayList<>();

	private static int messageCount = 0;
	
	public static void addMessage(String type, String message) {
		
		messageCount++;
		
		String padding ="";
		
		for (int i = 0; i < 3 - ((int) (Math.log10(messageCount))); i++) {
			
			padding += " ";
		}
		
		messageList.add(type + "[" + padding + messageCount + "][LOG]" + message);
	}
	
	public static Console getInstance() {
		
		return instance;
	}
	
	public static void debug(String msg) {
		
		addMessage("DEBUG    ", "[" + getCaller() + "]: " + msg);
	}
	
	public static void warning(String msg) {
		
		addMessage("WARNING    ", "[" + getCaller() + "]: " + msg);
	}

	public static void info(String msg) {
	
		addMessage("INFO    ", "[" + getCaller() + "]: " + msg);
	}
	
	private static String getCaller() {
		
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        
        for (int i = 1; i < elements.length; i++) {
        	
            StackTraceElement ste = elements[i];
            
            if (!ste.getClassName().equals(Logger.class.getName()) && ste.getClassName().indexOf("java.lang.Thread") != 0) {
            	
                return ste.getClassName();
            }
        }
        
        return null;
	}
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {}
		
		while (true) {
			
			try {
				Thread.sleep(80);
				
			} catch (InterruptedException e) {
				
				System.out.println("ERROR: Interrupted");
			} 
			
			if(messageList.size() > 0) {
				
				System.out.println(messageList.remove(0));
			}
		}
	}
}
