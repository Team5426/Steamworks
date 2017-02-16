package org.usfirst.frc.team5426.robot.commands;

public class ClimbCommand extends CommandBase {
	
	public ClimbCommand() {
		
		requires(climber);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		climber.descend();
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
