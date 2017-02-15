package org.usfirst.frc.team5426.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	
	public static int 	FRONT_LEFT_CHANNEL,
	 					REAR_LEFT_CHANNEL,
	 					FRONT_RIGHT_CHANNEL,
						REAR_RIGHT_CHANNEL,
						INTAKE_CHANNEL,
						LAUNCHER_CHANNEL,
						BLENDER_CHANNEL;
	
	public static void init() {
		
		FRONT_LEFT_CHANNEL 	= (int) SmartDashboard.getNumber("FRONT_LEFT_CHANNEL", 	2);
		REAR_LEFT_CHANNEL 	= (int) SmartDashboard.getNumber("REAR_LEFT_CHANNEL", 	3);
		FRONT_RIGHT_CHANNEL = (int) SmartDashboard.getNumber("FRONT_RIGHT_CHANNEL", 4); 
		REAR_RIGHT_CHANNEL 	= (int) SmartDashboard.getNumber("REAR_RIGHT_CHANNEL", 	5);
		INTAKE_CHANNEL		= (int) SmartDashboard.getNumber("INTAKE_CHANNEL", 0);
		LAUNCHER_CHANNEL	= (int) SmartDashboard.getNumber("LAUNCHER_CHANNEL", 1);
		BLENDER_CHANNEL		= (int) SmartDashboard.getNumber("BLENDER_CHANNEL", 6);
		
	}

}
