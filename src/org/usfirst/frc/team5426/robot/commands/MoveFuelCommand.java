package org.usfirst.frc.team5426.robot.commands;

public class MoveFuelCommand extends CommandBase {
	
	public MoveFuelCommand(double timeout) {
		
		requires(intake);
		
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		
		intake.getMotor().set(0.3);
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
