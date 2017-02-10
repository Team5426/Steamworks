package org.usfirst.frc.team5426.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	
	public static int FRONT_LEFT_CHANNEL;
	public static int BACK_LEFT_CHANNEL;
	public static int FRONT_RIGHT_CHANNEL;
	public static int BACK_RIGHT_CHANNEL;
	
	public static void init() {
		
		FRONT_LEFT_CHANNEL 	= (int) SmartDashboard.getNumber("FRONT_LEFT_CHANNEL", 	10);
		BACK_LEFT_CHANNEL 	= (int) SmartDashboard.getNumber("BACK_LEFT_CHANNEL", 	10);
		FRONT_RIGHT_CHANNEL = (int) SmartDashboard.getNumber("FRONT_RIGHT_CHANNEL", 10); 
		BACK_RIGHT_CHANNEL 	= (int) SmartDashboard.getNumber("BACK_RIGHT_CHANNEL", 	10);
	}

}
