package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShooter extends Subsystem {
	
	public static Solenoid shooter_solenoid;
	//public static Solenoid doors_solenoid;
	
	public GearShooter() {
		
		shooter_solenoid = new Solenoid(0);
		//doors_solenoid = new Solenoid(0);
	}
	
	public void shoot() {
		
		shooter_solenoid.set(true);
		
		//doors_solenoid.set(true);
		
		Timer.delay(0.2);
		
		//doors_solenoid.set(true);
	}
	
	public void stop() {
		
		shooter_solenoid.set(false);
	}

	@Override
	protected void initDefaultCommand() {
		
		//this.setDefaultCommand(new ShootGearCommand());
	}

}
