package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.subsystems.Launcher;

public class ResetCommand extends CommandBase {
	
	public ResetCommand(double timeout) {
		
		requires(launcher);
		
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		
		Launcher.reset();
	}
	
	protected void execute() {
		
	}
	
	protected void interrupted() {
		
		this.cancel();
	}
	
	protected void end() {
		
		this.cancel();
	}
	
	@Override
	protected boolean isFinished() {
		
		return this.isTimedOut();
	}

}
