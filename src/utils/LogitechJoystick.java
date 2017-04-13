package utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class LogitechJoystick extends Joystick {
	
	public Button button_trigger;
	public Button button_side;
	public Button button_compress;
	public Button button_doors;
	public Button button_intake;
	
	public LogitechJoystick(int port) {
		
		super(port);
		
		button_trigger = new JoystickButton(this, 1);
		button_side = new JoystickButton(this, 2);
		button_compress = new JoystickButton(this, 11);
		button_doors = new JoystickButton(this, 5);
		button_intake = new JoystickButton(this, 3);
	}
	
	public double getXAxis() {
		
		return this.getXAxis();
	}
	
	public double getYAxis() {
		
		return this.getYAxis();
	}
	
	public double getZAxis() {
		
		return this.getZAxis();
	}
}
