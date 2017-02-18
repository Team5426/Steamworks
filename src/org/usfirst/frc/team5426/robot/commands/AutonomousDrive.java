package org.usfirst.frc.team5426.robot.commands;

public class AutonomousDrive extends CommandBase {
	
	private double speed;
	private double angle;
	private double seconds;
	
	public AutonomousDrive(double speed, double angle, double seconds) {
		
		requires(drive);
		
		this.speed = speed;
		this.angle = angle;
		this.seconds = seconds;
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		drive.drive(speed, angle);
		
		this.setTimeout(seconds);
	}
	
	protected boolean isFinished() {
		
		return this.isTimedOut();
	}

}
