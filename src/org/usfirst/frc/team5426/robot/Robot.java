package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.auto.DriveStraight;
import org.usfirst.frc.team5426.robot.auto.DropGear;
import org.usfirst.frc.team5426.robot.auto.BoilerRedGear;
import org.usfirst.frc.team5426.robot.auto.BoilerBlueGear;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
import utils.Stage;

/**
 * Created by Duncan on 1/24/2017.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;
	SendableChooser<CommandGroup> autoMode;

	public static Preferences settings;

	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;

	private VisionThread visionThread;
	private double centerX = 0.0;

	private final Object imgLock = new Object();

	public static boolean canCompress = false;

	public static Stage stage;

	@Override
	public void robotInit() {

		settings = Preferences.getInstance();

		RobotMap.init();
		CommandBase.init();

		autoMode = new SendableChooser<CommandGroup>();
		autoMode.addDefault("Autonomous Straight Gear", new DropGear());
		autoMode.addObject("Autonomous Straight", new DriveStraight());
		autoMode.addObject("Autonomous Boiler Gear Red", new BoilerRedGear());
		autoMode.addObject("Autonomous Boiler Gear Blue", new BoilerBlueGear());
		SmartDashboard.putData("Autonomous Mode: ", autoMode);
	}

	@Override
	public void disabledInit() {

		canCompress = true;
	}

	@Override
	public void autonomousInit() {

		stage = Stage.AUTO;

		autonomousCommand = autoMode.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	@Override
	public void teleopInit() {

		stage = Stage.TELEOP;

		if (!(autonomousCommand == null)) {

			autonomousCommand.cancel();
		}
	}

	@Override
	public void robotPeriodic() {

	}

	@Override
	public void disabledPeriodic() {

	}

	@Override
	public void teleopPeriodic() {

		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousPeriodic() {

		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {

		LiveWindow.run();

		try {

			CommandBase.compressor.compress();

		} catch (Exception e) {

			CommandBase.compressor.stop();
		}
	}
}
