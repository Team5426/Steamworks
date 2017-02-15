package org.usfirst.frc.team5426.robot.commands;

public class LauncherShootCommand extends CommandBase {
	
	public LauncherShootCommand() {
		
		requires(launcher);
	}
	
	protected void initialize() {
		
	}
	
	protected void execute() {
		
		launcher.shoot(1.0);
		
	}
	
	protected void end() {
		
		launcher.stop();
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

}
