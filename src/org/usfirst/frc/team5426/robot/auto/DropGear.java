package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.commands.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.OpenDoorsCommand;
import org.usfirst.frc.team5426.robot.commands.ShootGearCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DropGear extends CommandGroup {
	
	public DropGear() {
		
		this.addSequential(new AutonomousDrive(-0.70, 0.0, 0.6));
		this.addSequential(new OpenDoorsCommand(0.1));
		this.addSequential(new AutonomousDrive(-0.70, 0.0, 0.6));
		this.addSequential(new AutonomousDrive(0.0, 0.0, 0.5));
		this.addSequential(new ShootGearCommand(0.5));
		this.addSequential(new AutonomousDrive(0.0, 0.0, 0.25));
		this.addSequential(new AutonomousDrive(0.70, 0.0, 1));
	}

}
