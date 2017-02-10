package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.commands.ShootGear;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShooter extends Subsystem {
	
	private Solenoid solenoid;
	
	public GearShooter() {
		
		solenoid = new Solenoid(0);
	}
	
	public void open() {
		
		solenoid.set(true);
	}
	
	public void close() {
		
		solenoid.set(false);
	}
	
	public boolean isOpen() {
		
		return solenoid.get();
	}

	@Override
	protected void initDefaultCommand() {
		
		this.setDefaultCommand(new ShootGear());
	}

}
