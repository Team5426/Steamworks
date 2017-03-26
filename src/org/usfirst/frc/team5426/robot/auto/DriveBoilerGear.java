package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.commands.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.AutonomousShooter;
import org.usfirst.frc.team5426.robot.commands.ShootGearCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveBoilerGear extends CommandGroup {

	public DriveBoilerGear() {
		
		this.addSequential(new AutonomousDrive(-0.75, 0.0, 0.2));
		this.addSequential(new AutonomousShooter(7.0));
		this.addSequential(new AutonomousDrive(-0.75, 0.0, 1.8));
		this.addSequential(new AutonomousDrive(0.0, 0.0, 0.5));
		this.addSequential(new ShootGearCommand(0.5));
		this.addSequential(new AutonomousDrive(1.0, 0.0, 0.5));
	}
}
