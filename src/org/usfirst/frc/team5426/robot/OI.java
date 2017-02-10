package org.usfirst.frc.team5426.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import utils.LogitechController;

public class OI {

    private static LogitechController controller;

    private static Button buttonA;
    private static Button buttonB;
    private static Button buttonX;
    private static Button buttonY;

    private static Button rightBumper;
    private static Button leftBumper;

    public OI() {


    }

    public static void init() {

        controller = new LogitechController(0);
    }
    
    public static Joystick getStick() {
    	
    	return controller;
    }

    public static double getLeftAxisY() {

        return -controller.getRawAxis(1);
    }

    public static double getLeftAxisX() {

        return -controller.getRawAxis(0);
    }

    public static double getRightAxisY(){

        return controller.getRawAxis(5);
    }


    public static double getRightAxisX() {

        return controller.getRawAxis(4);
    }
}
