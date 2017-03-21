package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CompressorControl extends Subsystem {
	
	private Compressor compressor;
	
	public CompressorControl() {
		
		compressor = new Compressor(RobotMap.PNEUMATICS_CAN);
	}
	
	public void compress() {
		
		compressor.start();
	}
	
	public void stop() {
		
		compressor.stop();
	}
	
	@Override
	protected void initDefaultCommand() {
		
		
	}
}
