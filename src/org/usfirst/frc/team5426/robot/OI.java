package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.ClimbCommand;
import org.usfirst.frc.team5426.robot.commands.DescendCommand;
import org.usfirst.frc.team5426.robot.commands.IntakeCommand;
import org.usfirst.frc.team5426.robot.commands.LauncherShootCommand;
import org.usfirst.frc.team5426.robot.commands.ShootGearCommand;
import org.usfirst.frc.team5426.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;
import utils.LogitechController;
import utils.LogitechJoystick;

public class OI {

    public static LogitechController controller = new LogitechController(0);
    public static LogitechJoystick joystick = new LogitechJoystick(1);

    public OI() {
    	
    	joystick.button_trigger.whileActive(new LauncherShootCommand());
    	
    	controller.button_X.whileActive(new ClimbCommand());
    	controller.button_Y.whileActive(new DescendCommand());
    	controller.bumper_left.whileActive(new ShootGearCommand());
    	
    	// Since we cannot pass a method as a command, we must create a local instance of
    	// a command and reset the launcher timer is the execute() method
    	joystick.button_trigger.whenReleased(new Command() {
    		
    		protected void initialize() {
    			
    			this.setInterruptible(false);
    			this.setRunWhenDisabled(true);
    		}
    		
    		protected void execute() {
    			
    			Launcher.reset();
    		}
    		
			@Override
			protected boolean isFinished() {
				
				return false;
			}
    		
    	});
    }
}
