package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.Robot;

public class CompressCommand extends CommandBase {
	
	public CompressCommand() {
		
		requires(compressor);
	}
	
	protected void initialize() {
		
		if (Robot.canCompress) {
			
			System.out.println("Can compress");
			
			try {
				
				compressor.compress();
				
			} catch (Exception e) {
				
			}
		}
		
		else {
			
			System.out.println("Can't compress");
		}
	}
	
	protected void execute() {
		
	}
	
	protected void interrupted() {
		
	}
	
	protected void end() {
		
	}
	
	protected boolean isFinished() {
		
		return true;
	}

}
