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
		
		drive.drive(speed, angle, true);
		
		this.setTimeout(seconds);
	}
	
	protected void execute() {
		
	}
	
	protected boolean isFinished() {
		
		if (this.isTimedOut()) {
			
			this.cancel();
			
			return true;
		}
		
		return false;
	}

}
