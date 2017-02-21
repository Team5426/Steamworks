package org.usfirst.frc.team5426.robot.commands;

import java.util.Date;

public class LauncherShootCommand extends CommandBase {
	
	public static Date blender = null;
	
	public LauncherShootCommand(double timeout) {
		
		requires(launcher);
		
		this.setTimeout(timeout);
	}
	
	protected void initialize() {
		
		if (blender == null) blender = new Date(System.currentTimeMillis() + 1000);
		
		if (System.currentTimeMillis() - blender.getTime() >= 0) {
			
			launcher.startBlender();
		}
		
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
