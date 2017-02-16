package org.usfirst.frc.team5426.robot.commands;

import utils.Direction;

public class ClimbCommand extends CommandBase {
	
	private Direction direction;
	
	public ClimbCommand(Direction direction) {
		
		this.direction = direction;
		
		requires(climber);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		if (direction.equals(Direction.UP)) climber.climb();
		else climber.descend();
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
