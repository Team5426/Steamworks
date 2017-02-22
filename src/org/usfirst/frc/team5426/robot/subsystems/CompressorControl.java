package org.usfirst.frc.team5426.robot.subsystems;

import org.usfirst.frc.team5426.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CompressorControl extends Subsystem {
	
	private Compressor compressor;
	
	public CompressorControl() {
		
		compressor = new Compressor(RobotMap.COMPRESSOR_CAN);
	}
	
	public void compress() {
		
		while (compressor.getPressureSwitchValue()) {
			
			if (!compressor.enabled()) {
				
				System.out.println("Compressor enabled");
				compressor.start();
			}
			
			if (!compressor.getPressureSwitchValue()) {
				
				System.out.println("Compressor disabled");
				compressor.stop();
				
				continue;
			}
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		
		
	}
}
