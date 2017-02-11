package org.usfirst.frc.team5426.robot;

import utils.LogitechController;
import utils.LogitechJoystick;

public class OI {

    public static LogitechController controller = new LogitechController(0);
    public static LogitechJoystick joystick = new LogitechJoystick(1);

    public OI() {
    	
    	// uncomment as needed
    	//joystick.button_trigger.whileActive(new ShootGearCommand());
    }
}
