package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.Front;

public class RobotMap {
	
	public static final int FRONT_LEFT_CHANNEL 	= 9,
	 						REAR_LEFT_CHANNEL	= 8,
	 						FRONT_RIGHT_CHANNEL	= 7,
	 						REAR_RIGHT_CHANNEL	= 6,
	 						INTAKE_CHANNEL		= 4,
	 						LAUNCHER_CHANNEL	= 5,
	 						CLIMBER_CHANNEL		= 2,
	 						BLENDER_CHANNEL		= 3;
	
	public static double	LAUNCHER_SPEED,
							INTAKE_SPEED,
							BLENDER_SPEED,
							CLIMB_SPEED,
							GEAR_SHOOT_SECONDS,
							DRIVE_SENSITIVITY,
							INTAKE_SLOW_SPEED;
	
	public static Front		FRONT;
	
	public static RobotDrive drive;
	
	public static void init() {
		
		LAUNCHER_SPEED 		= (double) SmartDashboard.getNumber("Launcher Speed", 1.0);
		INTAKE_SPEED		= (double) SmartDashboard.getNumber("Intake Speed", 1.0);
		BLENDER_SPEED		= (double) SmartDashboard.getNumber("Blender Speed", 0.5);
		GEAR_SHOOT_SECONDS	= (double) SmartDashboard.getNumber("Gear Shoot Seconds", 0.3);
		CLIMB_SPEED			= (double) SmartDashboard.getNumber("Climb Speed", 1.0);
		DRIVE_SENSITIVITY	= (double) SmartDashboard.getNumber("Drive Sensitivity", 0.5);
		INTAKE_SLOW_SPEED	= (double) SmartDashboard.getNumber("Fuel Moving Speed", 0.3);
		
		FRONT				= CommandBase.front.getSelected();
	}

}
