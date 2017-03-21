package org.usfirst.frc.team5426.robot.commands;

public class IntakeBallCommand extends CommandBase {
	
	public IntakeBallCommand(double timeout) {
		
		requires(intake);
		
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		
		intake.intake();
	}
	
	protected void execute() {
		
	}
	
	protected void interrupted() {
		
		intake.stop();
		this.cancel();
	}
	
	protected void end() {
			
		intake.stop();
	}
	
	protected boolean isFinished() {
		
		if (this.isTimedOut()) {
			
			this.cancel();
			
			return true;
		}
		
		return false;
	}
}