package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	private Spark motor;
	
	public Climber() {
		
		motor = new Spark(RobotMap.CLIMBER_CHANNEL);
	}

	@Override
	protected void initDefaultCommand() {
		
		
	}
	
	public void climb() {
		
		motor.set(1.0);
	}
	
	public void descend() {
		
		motor.set(-1.0);
	}
	
	public void stop() {
		
		motor.set(0.0);
	}
}
