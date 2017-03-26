package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.commands.AutonomousDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraight extends CommandGroup {
	
	public DriveStraight() {
		
		this.addSequential(new AutonomousDrive(0.7, 0.0, 3.2));
	}
}
