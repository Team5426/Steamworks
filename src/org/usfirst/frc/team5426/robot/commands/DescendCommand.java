package org.usfirst.frc.team5426.robot.commands;

public class DescendCommand extends CommandBase {
	
	public DescendCommand() {
		
		requires(climber);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		climber.climb();
	}
	
	protected void interrupted() {
		
	}
	
	protected void end() {
		
		climber.stop();
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
