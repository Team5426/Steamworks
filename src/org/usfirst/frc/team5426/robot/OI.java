package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.ClimbCommand;
import org.usfirst.frc.team5426.robot.commands.DescendCommand;
import org.usfirst.frc.team5426.robot.commands.LauncherShootCommand;
import org.usfirst.frc.team5426.robot.commands.ShootGearCommand;
import org.usfirst.frc.team5426.robot.subsystems.Launcher;

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
    	
    	joystick.button_trigger.whenReleased(new Launcher.RESET());
    }
}
