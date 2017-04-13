package org.usfirst.frc.team5426.robot.commands;

public class OpenDoorsCommand extends CommandBase {
	
	public OpenDoorsCommand(double timeout) {
		
		requires(gearshooter);
		
		this.setTimeout(timeout);
	}
	
	@Override
	protected void initialize() {
		
		if (!gearshooter.doors_solenoid.get()) {
		
			gearshooter.doors_solenoid.set(true);
		}
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected void interrupted() {
		
	}
	
	@Override
	protected void end() {
		
	}
	
	@Override
	protected boolean isFinished() {
		
		if (this.isTimedOut()) {
			
			return true;
		}
		
		return false;
	}

}
