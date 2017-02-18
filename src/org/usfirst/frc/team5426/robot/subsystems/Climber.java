package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	
	private CANTalon motor;
	
	public Climber() {
		
		motor = new CANTalon(2);
	}

	@Override
	protected void initDefaultCommand() {
		
		
	}
	
	public void climb() {
		
		motor.set(RobotMap.CLIMB_SPEED);
	}
	
	public void descend() {
		
		motor.set(RobotMap.CLIMB_SPEED);
	}
	
	public void stop() {
		
		motor.set(0.0);
	}
}
