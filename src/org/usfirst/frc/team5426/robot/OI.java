package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.IntakeCommand;
import org.usfirst.frc.team5426.robot.commands.LauncherShootCommand;
import org.usfirst.frc.team5426.robot.commands.ShootGearCommand;

import utils.LogitechController;
import utils.LogitechJoystick;

public class OI {

    public static LogitechController controller = new LogitechController(0);
    public static LogitechJoystick joystick = new LogitechJoystick(1);

    public OI() {
    	
    	joystick.button_trigger.whileHeld(new LauncherShootCommand());
    	
    	controller.bumper_left.whenPressed(new ShootGearCommand());
    	
    	controller.button_A.whileHeld(new IntakeCommand());
    }
}
