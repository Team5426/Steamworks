package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	private Spark motor;
	
	public Launcher() {
		
		motor = new Spark(RobotMap.LAUNCHER_CHANNEL);
	}
	
	public void shoot(double speed) {
		
		motor.set(speed);
	}
	
	public void stop() {
		
		motor.set(0.0);
	}
	
	public boolean isShooting() {
		
		if (motor.get() > 0) return true;
		return false;
	}

	@Override
	protected void initDefaultCommand() {
		
		//this.setDefaultCommand(new ShootLauncher());
	}

}
