package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private CANTalon motor;
	
	public Intake() {
		
		motor = new CANTalon(3);
	}
	
	public void intake() {
		
		motor.set(RobotMap.INTAKE_SPEED);
	}
	
	public void stop() {
		
		motor.set(0.0);
	}
	
	public CANTalon getMotor() {
		
		return motor;
	}
	
	@Override
	protected void initDefaultCommand() {
		
		//this.setDefaultCommand(new IntakeBallCommand(1));
	}

}
