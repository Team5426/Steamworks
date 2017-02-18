package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.ClimbCommand;
import org.usfirst.frc.team5426.robot.commands.IntakeBallCommand;
import org.usfirst.frc.team5426.robot.commands.LauncherShootCommand;
import org.usfirst.frc.team5426.robot.commands.ShootGearCommand;

import utils.LogitechController;
import utils.LogitechJoystick;

public class OI {

    public static LogitechController controller = new LogitechController(0);
    public static LogitechJoystick joystick = new LogitechJoystick(1);

    public OI() {
    	
    	controller.button_A.whileActive(new IntakeBallCommand(1.0));
    	joystick.button_trigger.whileActive(new LauncherShootCommand(1.0));
    	
    	controller.button_X.whileActive(new ClimbCommand(1.0));
    	//controller.button_Y.whileActive(new DescendCommand(1.0));
    	controller.bumper_left.whileActive(new ShootGearCommand(1.0));
    	
    	//joystick.button_trigger.whenInactive(new ResetCommand(1.0));
    }
}
