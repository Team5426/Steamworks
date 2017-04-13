package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShooter extends Subsystem {
	
	public Solenoid shooter_solenoid;
	public Solenoid doors_solenoid;
	
	public GearShooter() {
		
		shooter_solenoid = new Solenoid(1);
		doors_solenoid = new Solenoid(0);
		
		shooter_solenoid.set(false);
		doors_solenoid.set(false);
	}
	
	public void shoot() {
		
		shooter_solenoid.set(true);
		
		Timer.delay(0.2);
	}
	
	public void stop() {
		
		shooter_solenoid.set(false);
	}

	@Override
	protected void initDefaultCommand() {
		
		//this.setDefaultCommand(new ShootGearCommand());
	}

}
