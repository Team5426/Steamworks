package org.usfirst.frc.team5426.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class ShootGearCommand extends CommandBase {
	
	public ShootGearCommand() {
		
		requires(gearshooter);
		
		this.setInterruptible(false);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		gearshooter.open();
		
		Timer.delay(0.1);
		
		gearshooter.close();
	}
	
	protected void interrupted() {
		
	}
	
	protected void end() {
		
		if (gearshooter.isOpen()) gearshooter.close();
	}
	
	protected boolean isFinished() {
		
		return false;
	}

}
