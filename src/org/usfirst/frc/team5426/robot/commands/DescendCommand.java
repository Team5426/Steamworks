package org.usfirst.frc.team5426.robot.commands;

public class DescendCommand extends CommandBase {
	
	public DescendCommand(double timeout) {
		
		requires(climber);
		
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		
		climber.descend();
	}
	
	protected void execute() {
		
	}
	
	protected void interrupted() {
		
		climber.stop();
	}
	
	protected void end() {
		
		climber.stop();
	}
	
	@Override
	protected boolean isFinished() {
		
		return this.isTimedOut();
	}

}
