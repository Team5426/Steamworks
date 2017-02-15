package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.IntakeCommand;
import org.usfirst.frc.team5426.robot.commands.LauncherShootCommand;
import org.usfirst.frc.team5426.robot.commands.ShootGearCommand;

import edu.wpi.first.wpilibj.command.Command;
import utils.LogitechController;
import utils.LogitechJoystick;

public class OI {

    public static LogitechController controller = new LogitechController(0);
    public static LogitechJoystick joystick = new LogitechJoystick(1);

    public OI() {
    	
    	joystick.button_trigger.whileHeld(new LauncherShootCommand());
    	
    	// Since we cannot pass a method as a command, we must create a local instance of
    	// a command and reset the launcher timer is the execute() method
    	joystick.button_trigger.whenReleased(new Command() {
    		
    		protected void initialize() {
    			
    			this.setInterruptible(false);
    			this.setRunWhenDisabled(true);
    		}
    		
    		protected void execute() {
    			
    			LauncherShootCommand.reset();
    		}
    		
			@Override
			protected boolean isFinished() {
				
				return false;
			}
    		
    	});
    	
    	controller.bumper_left.whenPressed(new ShootGearCommand());
    	
    	controller.button_A.whileHeld(new IntakeCommand());
    }
}
