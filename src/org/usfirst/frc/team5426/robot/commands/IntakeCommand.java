package org.usfirst.frc.team5426.robot.commands;

public class IntakeCommand extends CommandBase {
	
	public IntakeCommand() {
		
		requires(intake);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		intake.intake();
	}
	
	protected void interrupted() {
		
	}
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}
	
	protected void end() {
		
		intake.stop();
	}
	
}