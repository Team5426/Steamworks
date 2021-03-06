package org.usfirst.frc.team5426.robot.commands;

public class ToggleDoorsCommand extends CommandBase {
	
	public ToggleDoorsCommand(double timeout) {
		
		requires(gearshooter);
		
		this.setTimeout(timeout);
	}
	
	@Override
	protected void initialize() {
		
		if (gearshooter.doors_solenoid.get()) {
			
			new CloseDoorsCommand(0.5);
		}
		
		else {
			
			new OpenDoorsCommand(0.5);
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
