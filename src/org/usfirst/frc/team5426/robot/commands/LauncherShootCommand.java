package org.usfirst.frc.team5426.robot.commands;

import java.util.Date;

import org.usfirst.frc.team5426.robot.subsystems.Launcher;

public class LauncherShootCommand extends CommandBase {
	
	public LauncherShootCommand(double timeout) {
		
		requires(launcher);
		
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		
		launcher.startBlender();
		launcher.shoot();
	}
	
	protected void execute() {
				
	}
	
	protected void end() {
		
		launcher.stop();
	}

	@Override
	protected boolean isFinished() {
		
		return this.isTimedOut();
	}

}
