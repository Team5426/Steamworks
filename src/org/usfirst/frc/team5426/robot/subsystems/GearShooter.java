package org.usfirst.frc.team5426.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShooter extends Subsystem {
	
	private Solenoid solenoid;
	
	public GearShooter() {
		
		solenoid = new Solenoid(0);
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
