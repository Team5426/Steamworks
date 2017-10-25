package org.usfirst.frc.team5426.robot.auto;

import org.usfirst.frc.team5426.robot.commands.AutonomousDrive;
import org.usfirst.frc.team5426.robot.commands.AutonomousTurn;
import org.usfirst.frc.team5426.robot.commands.CloseDoorsCommand;
import org.usfirst.frc.team5426.robot.commands.ShootGearCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BoilerRedGear extends CommandGroup {

	public BoilerRedGear() {
		
		// Closes the doors
		this.addSequential(new CloseDoorsCommand(0.01));
		
		// Initial Forward Drive
		this.addSequential(new AutonomousDrive(-0.8, 0.0, 1.15));
		
		// Initial Motor Reset
		this.addSequential(new AutonomousDrive(0.0, 0.0, 0.5));
		
		// First Turn (90 degrees)
		this.addSequential(new AutonomousTurn(-82.0));
		
		// Second Motor Reset
		this.addSequential(new AutonomousDrive(0.0, 0.0, 0.5));
		
		// Drive Forward to the peg
		this.addSequential(new AutonomousDrive(-0.50, 0.0, 3.5));
		
		// Third Motor Reset
		this.addSequential(new AutonomousDrive(0.0, 0.0, 0.2));
		
		// Shoot the gear
		this.addSequential(new ShootGearCommand(0.3));
		
		// Back up off of the peg
		this.addSequential(new AutonomousDrive(0.90, 0.0, 0.6));
		
		this.addSequential(new AutonomousDrive(0.0, 0.0, 0.2));
		
		// Turn 65 degrees towards the line
		this.addSequential(new AutonomousTurn(65.0));
		
		// Drives over the line
		this.addSequential(new AutonomousDrive(-0.8, 0.0, 1.5));
	}
}
