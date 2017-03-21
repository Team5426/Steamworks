package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousShootGear extends CommandBase {
	
	public AutonomousShootGear() {
		
		requires(gearshooter);
	}
	
	protected void initialize() {
		
		gearshooter.shoot();
		
		Timer.delay(RobotMap.GEAR_SHOOT_SECONDS);
		
		gearshooter.stop();
	}
	
	protected void execute() {
		
		gearshooter.stop();
	}
	
	protected void end() {
		
		gearshooter.stop();
	}

	@Override
	protected boolean isFinished() {
		
		if (this.isTimedOut()) {
			
			this.cancel();
			
			return true;
		}
		
		return false;
	}

}
