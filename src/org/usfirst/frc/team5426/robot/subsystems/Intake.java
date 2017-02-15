package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private Talon motor;
	
	public Intake() {
		
		motor = new Talon(RobotMap.INTAKE_CHANNEL);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void intake(double speed) {
		
		motor.set(speed);
	}
	
	public void stop() {
		
		motor.set(0.0);
	}

}
