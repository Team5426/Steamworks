package org.usfirst.frc.team5426.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	
	public static int 		FRONT_LEFT_CHANNEL,
	 						REAR_LEFT_CHANNEL,
	 						FRONT_RIGHT_CHANNEL,
	 						REAR_RIGHT_CHANNEL,
	 						INTAKE_CHANNEL,
	 						LAUNCHER_CHANNEL,
	 						CLIMBER_CHANNEL,
	 						BLENDER_CHANNEL;
	
	public static double	LAUNCHER_SPEED,
							INTAKE_SPEED,
							BLENDER_SPEED,
							CLIMB_SPEED,
							GEAR_SHOOT_SECONDS;
	
	public static void init() {
		
		FRONT_LEFT_CHANNEL 	= 9;
		REAR_LEFT_CHANNEL 	= 8;
		FRONT_RIGHT_CHANNEL = 7; 
		REAR_RIGHT_CHANNEL 	= 6;
		INTAKE_CHANNEL		= 4;
		LAUNCHER_CHANNEL	= 5;
		CLIMBER_CHANNEL		= 2;
		BLENDER_CHANNEL		= 3;
		
		LAUNCHER_SPEED 		= (double) SmartDashboard.getNumber("Launcher Speed", 1.0);
		INTAKE_SPEED		= (double) SmartDashboard.getNumber("Intake Speed", 1.0);
		BLENDER_SPEED		= (double) SmartDashboard.getNumber("Blender Speed", 0.5);
		GEAR_SHOOT_SECONDS	= (double) SmartDashboard.getNumber("Gear Shoot Seconds", 0.3);
		CLIMB_SPEED			= (double) SmartDashboard.getNumber("Climb Speed", 1.0);
		
	}

}
