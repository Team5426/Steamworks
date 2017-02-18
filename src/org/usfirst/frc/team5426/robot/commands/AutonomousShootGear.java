package org.usfirst.frc.team5426.robot.commands;

public class AutonomousShootGear extends CommandBase {
	
	public AutonomousShootGear() {
		
		requires(gearshooter);
	}
	
	protected void initialize() {
		
		gearshooter.shoot();
	}
	
	protected void execute() {
		
	}
	
	protected void end() {
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
