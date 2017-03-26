package org.usfirst.frc.team5426.robot.commands;

public class CompressCommand extends CommandBase {
	
	public CompressCommand(double timeout) {
		
		requires(compressor);
		
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		
		compressor.compress();
	}
	
	protected void execute() {
		
	}
	
	protected void interrupted() {
		
		//compressor.stop();
	}
	
	protected void end() {
		
		compressor.stop();
	}
	
	protected boolean isFinished() {
		
		if (this.isTimedOut()) {
			
			this.cancel();
			
			return true;
		}
		
		return false;
	}

}
