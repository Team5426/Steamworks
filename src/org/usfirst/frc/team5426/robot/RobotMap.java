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
	 						BLENDER_CHANNEL		= 3,
	 						
	 						PNEUMATICS_CAN		= 0;
	
	public static double	LAUNCHER_SPEED,
							INTAKE_SPEED,
							BLENDER_SPEED,
							CLIMB_SPEED,
							GEAR_SHOOT_SECONDS,
							DRIVE_SENSITIVITY,
							TURNING_GAIN,
							INTAKE_SLOW_SPEED;
	
	public static boolean COMPRESS;
	
	public static Front		FRONT;
	
	public static RobotDrive drive;
	
	public static void init() {
		
		LAUNCHER_SPEED 		= Robot.settings.getDouble("Launcher Speed", 0.75);
		INTAKE_SPEED		= Robot.settings.getDouble("Intake Speed", 1.0);
		BLENDER_SPEED		= Robot.settings.getDouble("Blender Speed", 0.5);
		GEAR_SHOOT_SECONDS	= Robot.settings.getDouble("Gear Shoot Seconds", 0.3);
		CLIMB_SPEED			= Robot.settings.getDouble("Climb Speed", 1.0);
		DRIVE_SENSITIVITY	= Robot.settings.getDouble("Drive Sensitivity", 0.5);
		INTAKE_SLOW_SPEED	= Robot.settings.getDouble("Fuel Moving Speed", 0.3);
		TURNING_GAIN		= Robot.settings.getDouble("Turning Gain", 1.0);
		
		COMPRESS = Robot.settings.getBoolean("Compress", false);
		
		FRONT				= //CommandBase.front.getSelected();
				Front.INTAKE;
	}

}
