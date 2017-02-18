package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;
import org.usfirst.frc.team5426.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Duncan on 1/24/2017.
 */
public class DriveTrain extends Subsystem {

	private Talon FRONT_LEFT;
	private Talon REAR_LEFT;
	private Talon FRONT_RIGHT;
	private Talon REAR_RIGHT;

	private RobotDrive drive;

	public DriveTrain() {

		FRONT_LEFT = new Talon(RobotMap.FRONT_LEFT_CHANNEL);
		REAR_LEFT = new Talon(RobotMap.REAR_LEFT_CHANNEL);
		FRONT_RIGHT = new Talon(RobotMap.FRONT_RIGHT_CHANNEL);
		REAR_RIGHT = new Talon(RobotMap.REAR_RIGHT_CHANNEL);

		drive = new RobotDrive(FRONT_LEFT, REAR_LEFT, FRONT_RIGHT, REAR_RIGHT);
	}

	@Override
	protected void initDefaultCommand() {

		this.setDefaultCommand(new DriveCommand());
	}

	public void drive(double leftYAxis, double leftXAxis) {

		drive.arcadeDrive(cube(leftYAxis), cube(leftXAxis));
		// drive.mecanumDrive_Polar(cube(leftYAxis), cube(leftXAxis), twist);
		// drive.mecanumDrive_Polar(leftYAxis, leftXAxis, twist);
	}

	private double cube(double val) {

		return Math.pow(val, 3);
	}

	public Talon getFrontLeft() {

		return FRONT_LEFT;
	}

	public Talon getFrontRight() {

		return FRONT_RIGHT;
	}

	public Talon getRearLeft() {

		return REAR_LEFT;
	}

	public Talon getRearRight() {

		return REAR_RIGHT;
	}
	
	public RobotDrive getDrive() {
		
		return drive;
	}
}
