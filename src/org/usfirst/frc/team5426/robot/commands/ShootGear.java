package org.usfirst.frc.team5426.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class ShootGear extends CommandBase {

	public ShootGear() {
		
		requires(gearshooter);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		gearshooter.open();
		
		Timer.delay(0.5);
		
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
