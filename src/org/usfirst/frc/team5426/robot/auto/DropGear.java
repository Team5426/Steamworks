package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.commands.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.AutonomousShootGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {
	
	public DropGear() {
		
		this.addSequential(new AutonomousDrive(0.5, 0.0, 2));
		this.addSequential(new AutonomousShootGear());
	}

}
