package org.usfirst.frc.team5426.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousTurn extends CommandBase implements Runnable {
	
	private double angle;
	private double heading;
	
	public AutonomousTurn(double angle) {
		
		requires(drive);
		
		this.angle = angle;
	}
	
	protected void initialize() {
		
		drive.gyro.reset();
		
		this.heading = drive.gyro.getAngle() + angle;
		
		while (Math.abs(heading - drive.gyro.getAngle()) > 0.4) {
			
			drive.getDrive().arcadeDrive(0.0, -((angle < 0.0) ? - 0.4 : 0.4));
			
		}
	}
	
	@Override
	public void run() {
		
		if (!(Math.abs(heading - drive.gyro.getAngle()) > 0.4)) {
			
			drive.getDrive().arcadeDrive(0.0, -((angle < 0.0) ? - 0.45 : 0.45));
		}
	}
	
	
	protected void execute() {
		
	}
	
	protected void end() {
		
	}

	@Override
	protected boolean isFinished() {
		
		return true;
	}

}
