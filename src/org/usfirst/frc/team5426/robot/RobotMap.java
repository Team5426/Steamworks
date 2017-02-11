package org.usfirst.frc.team5426.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	
	public static int 	FRONT_LEFT_CHANNEL,
	 					BACK_LEFT_CHANNEL,
	 					FRONT_RIGHT_CHANNEL,
						BACK_RIGHT_CHANNEL,
						INTAKE_CHANNEL,
						LAUNCHER_CHANNEL;
	
	public static void init() {
		
		FRONT_LEFT_CHANNEL 	= (int) SmartDashboard.getNumber("FRONT_LEFT_CHANNEL", 	2);
		BACK_LEFT_CHANNEL 	= (int) SmartDashboard.getNumber("BACK_LEFT_CHANNEL", 	3);
		FRONT_RIGHT_CHANNEL = (int) SmartDashboard.getNumber("FRONT_RIGHT_CHANNEL", 4); 
		BACK_RIGHT_CHANNEL 	= (int) SmartDashboard.getNumber("BACK_RIGHT_CHANNEL", 	5);
		//INTAKE_CHANNEL		= (int) SmartDashboard.getNumber("INTAKE_CHANNEL", 6); // change this
		//LAUNCHER_CHANNEL	= (int) SmartDashboard.getNumber("LAUNCHER_CHANNEL", 7); // change this too
		
	}

}
