package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;

public class ShootGearCommand extends CommandBase {
	
	public ShootGearCommand(double timeout) {
		
		requires(gearshooter);
		
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		
		gearshooter.shoot();
		
		Timer.delay(RobotMap.GEAR_SHOOT_SECONDS);
		
		gearshooter.stop();
	}
	
	protected void execute() {
		
	}
	
	protected void interrupted() {
		
		gearshooter.stop();
	}
	
	protected void end() {
		
		gearshooter.stop();
	}
	
	protected boolean isFinished() {
		
		if (this.isTimedOut()) {
			
			return true;
		}
		
		return false;
	}

}
