package org.usfirst.frc.team5426.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class AutonomousTurn extends CommandBase {
	
	private double angle;
	
	public AutonomousTurn(double angle) {
		
		requires(drive);
		
		this.angle = angle;
	}
	
	protected void initialize() {
		
		drive.gyro.reset();
		
		double heading = drive.gyro.getAngle() + angle;
		
		while (Math.abs(heading - drive.gyro.getAngle()) > 0.4) {
			
			drive.getDrive().arcadeDrive(0.0, -((angle < 0.0) ? - 0.6 : 0.6));
			
			Timer.delay(0.005);
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
