package org.usfirst.frc.team5426.robot;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Console extends Thread implements Runnable {

	private static Console instance;
  
	private List<String> messageList = new CopyOnWriteArrayList<>();

	private static int messageCount = 0;
	
	public synchronized void addMessage(String type, String message) {
		
		messageCount++;
		
		String padding ="";
		
		for(int i = 0; i < 3 - ((int) (Math.log10(messageCount))); i++) {
			
			padding += " ";
		}
		
		messageList.add(type + "[" + padding + messageCount + "][LOG]" + message);
	}
	
	public static Console getInstance() {
		
		return instance;
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
