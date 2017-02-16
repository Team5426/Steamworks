package org.usfirst.frc.team5426.robot.commands;

import java.util.Date;

import org.usfirst.frc.team5426.robot.subsystems.Launcher;

public class LauncherShootCommand extends CommandBase {
	
	public LauncherShootCommand() {
		
		requires(launcher);
	}
	
	protected void initialize() {
		
		if (Launcher.blenderStart == null) {
			
			Launcher.blenderStart = new Date(System.currentTimeMillis() + (1000 * 1));
		}
	}
	
	protected void execute() {
		
		if (!(Launcher.blenderStart == null)) {
			
			if ((System.currentTimeMillis() - Launcher.blenderStart.getTime()) >= 0) {
			
				launcher.getBlenderMotor().set(0.5);
			}
			
			launcher.shoot(1.0);
		}
		
	}
	
	protected void end() {
		
		launcher.stop();
		launcher.getBlenderMotor().set(0.0);
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
