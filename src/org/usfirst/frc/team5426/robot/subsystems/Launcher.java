package org.usfirst.frc.team5426.robot.subsystems;

import java.util.Date;

import org.usfirst.frc.team5426.robot.RobotMap;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	public static Date blenderStart = null;
	
	private Victor motor_shooter;
	private Victor motor_blender;
	
	public Launcher() {
		
		motor_shooter = new Victor(5);
		motor_blender = new Victor(RobotMap.BLENDER_CHANNEL);
	}
	
	public void shoot() {
		
		motor_shooter.set(RobotMap.LAUNCHER_SPEED);
	}
	
	public void startBlender() {
		
		motor_blender.set(RobotMap.BLENDER_SPEED);
	}
	
	public void stop() {
		
		motor_shooter.set(0.0);
		motor_blender.set(0.0);
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
	
	public static void reset() {
		
		blenderStart = null;
	}
	
	public static void setTimer() {
		
		blenderStart = new Date(System.currentTimeMillis() + 1000);
	}

}
