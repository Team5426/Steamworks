package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.subsystems.GearShooter;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.DoorPosition;

public class ToggleDoorsCommand extends CommandBase {
	
	private DoorPosition pos = null;
	
	public ToggleDoorsCommand(double timeout) {
		
		requires(gearshooter);
		
		this.setTimeout(timeout);
	}
	
	public ToggleDoorsCommand(DoorPosition pos, double timeout) {
		
		requires(gearshooter);
		
		this.pos = pos;
		
		this.setTimeout(timeout);
	}
	
	public void initialize() {
		
		/*if (!(pos == null)) {
		
			if (this.pos.equals(DoorPosition.CLOSE)) {
				
				GearShooter.doors_solenoid.set(false);
			}
		
			else if (this.pos.equals(DoorPosition.OPEN)) {
				
				GearShooter.doors_solenoid.set(true);
			}
		}
		
		else {
			
			if (GearShooter.doors_solenoid.get()) {
				
				GearShooter.doors_solenoid.set(false);
			}
			
			else {
				
				GearShooter.doors_solenoid.set(true);
			}
		}*/
	}
	
	public void execute() {
		
	}
	
	public void interrupted() {
		
	}
	
	public void end() {
		
	}
	
	public boolean isFinished() {
		
		if (this.isTimedOut()) {
			
			return true;
		}
		
		return false;
	}
}
