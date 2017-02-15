package utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class LogitechController extends Joystick {
	
	public JoystickButton button_A;
	public JoystickButton button_B;
	public JoystickButton button_X;
	public JoystickButton button_Y;
	
	public JoystickButton start;
	public JoystickButton back;
	
	public JoystickButton bumper_left;
	public JoystickButton bumper_right;
	
	public JoystickButton jbutton_left;
	public JoystickButton jbutton_right;
	
	public Timer timer;
	
	public LogitechController(int port) {
		
		super(port);
		
		button_A = new JoystickButton(this, 1);
		button_B = new JoystickButton(this, 2);
		button_X = new JoystickButton(this, 3);
		button_Y = new JoystickButton(this, 4);
		
		start = new JoystickButton(this, 8);
		back = new JoystickButton(this, 7);
		
		bumper_left = new JoystickButton(this, 5);
		bumper_right = new JoystickButton(this, 6);
		
		jbutton_left = new JoystickButton(this, 9);
		jbutton_right = new JoystickButton(this, 10);
	}
	
	public void rumble(float l, float r) {
    	
		this.setRumble(RumbleType.kLeftRumble, l);
		this.setRumble(RumbleType.kRightRumble, r);
	}
	
	public double getLeftAxisX() {
		
		return this.getRawAxis(0);
	}
	
	public double getLeftAxisY() {
		
		return this.getRawAxis(1);
	}
	
	public double getRightAxisX() {
		
		return this.getRawAxis(4);
	}
	
	public double getRightAxisY() {
		
		return this.getRawAxis(5);
	}
	
	public double getLeftTrigger() {
		
    	return this.getRawAxis(2);
    }
	
    public double getRightTrigger() {
    	
    	return this.getRawAxis(3);
    }

}