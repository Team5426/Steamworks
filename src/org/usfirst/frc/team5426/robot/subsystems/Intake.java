package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private Spark motor;
	
	public Intake() {
		
		motor = new Spark(RobotMap.INTAKE_CHANNEL);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void intake() {
		
		motor.set(0.65);
	}
	
	public void stop() {
		
		motor.set(0.0);
	}

}
