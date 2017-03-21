package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShooter extends Subsystem {
	
	private Solenoid solenoid;
	
	public GearShooter() {
		
		solenoid = new Solenoid(RobotMap.PNEUMATICS_CAN);
	}
	
	public void shoot() {
		
		solenoid.set(true);
	}
	
	public void stop() {
		
		solenoid.set(false);
	}
	
	public boolean isShooting() {
		
		return solenoid.get();
	}

	@Override
	protected void initDefaultCommand() {
		
		//this.setDefaultCommand(new ShootGearCommand());
	}

}
