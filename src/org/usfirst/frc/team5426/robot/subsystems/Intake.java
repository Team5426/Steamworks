package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private double SHOOT_SPEED;
	
	private Talon motor;
	
	public Intake() {
		
		SHOOT_SPEED = 1.0;
		motor = new Talon(RobotMap.INTAKE_CHANNEL);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void intake() {
		
		motor.set(this.SHOOT_SPEED);
	}
	
	public void stop() {
		
		motor.set(0.0);
	}

}
