package org.usfirst.frc.team5426.robot.commands;

public class AutonomousShooter extends CommandBase {
	
	public double seconds;
	
	public AutonomousShooter(double seconds) {
		
		this.seconds = seconds;
		
		requires(launcher);
	}
	
	@Override
	protected void end() {
	}

	@Override
	protected void execute() {
		
		launcher.shoot();
		launcher.startBlender();
		
		this.setTimeout(seconds);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void interrupted() {
		
	}

	@Override
	protected boolean isFinished() {
		
		if (this.isTimedOut()) {
			
			launcher.stop();
			launcher.getBlenderMotor().set(0.0);
			
			return true;
		}
		
		return false;
	}

}
