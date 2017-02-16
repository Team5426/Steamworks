package org.usfirst.frc.team5426.robot.commands;

import java.util.Date;

public class LauncherShootCommand extends CommandBase {
	
	public static Date blenderStart = null;
	
	public LauncherShootCommand() {
		
		requires(launcher);
	}
	
	protected void initialize() {
		
		if (blenderStart == null) {
			
			blenderStart = new Date(System.currentTimeMillis() + (1000 * 1));
		}
	}
	
	protected void execute() {
		
		if (!(blenderStart == null)) {
			
			if ((System.currentTimeMillis() - blenderStart.getTime()) >= 0) {
			
				//launcher.getBlenderMotor().set(0.5);
			}
			
			launcher.getBlenderMotor().set(0.5);
			
			launcher.shoot(1.0);
		}
		
	}
	
	public static void reset() {
		
		blenderStart = null;
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
