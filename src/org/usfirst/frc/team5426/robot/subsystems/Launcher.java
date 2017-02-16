package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	private Victor motor_shooter;
	private Victor motor_blender;
	
	
	public Launcher() {
		
		motor_shooter = new Victor(RobotMap.LAUNCHER_CHANNEL);
		motor_blender = new Victor(RobotMap.BLENDER_CHANNEL);
	}
	
	public void shoot(double speed) {
		
		motor_shooter.set(speed);
	}
	
	public void stop() {
		
		motor_shooter.set(0.0);
	}
	
	public boolean isShooting() {
		
		if (motor_shooter.get() > 0) return true;
		
		return false;
	}

	@Override
	protected void initDefaultCommand() {
		
		//this.setDefaultCommand(new ShootLauncher());
	}
	
	public Victor getShooterMotor() {
		
		return motor_shooter;
	}
	
	public Victor getBlenderMotor() {
		
		return motor_blender;
	}

}
