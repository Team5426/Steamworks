package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.auto.DriveBoilerGear;
import org.usfirst.frc.team5426.robot.auto.DriveStraight;
import org.usfirst.frc.team5426.robot.auto.DropGear;
import org.usfirst.frc.team5426.robot.commands.CommandBase;
import org.usfirst.frc.team5426.robot.commands.ToggleDoorsCommand;
import org.usfirst.frc.team5426.robot.subsystems.GearShooter;

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
	
	@Override
    public void robotInit() {		
		
		settings = Preferences.getInstance();
		
		RobotMap.init();
        CommandBase.init();
		
        autoMode = new SendableChooser<CommandGroup>();
    	autoMode.addDefault("Autonomous Straight Gear", new DropGear());
    	autoMode.addObject("Autonomous Straight", new DriveStraight());
    	autoMode.addObject("Autonomous Boiler Gear", new DriveBoilerGear());
    	SmartDashboard.putData("Autonomous Mode: ", autoMode);
    	
    	CameraServer server = CameraServer.getInstance();
    	
    	// 10.0.100.5
    	// frc-field.local
    	// 10.54.26.11 or 10.54.26.12
    	
    	/*AxisCamera camera = server.addAxisCamera("10.54.26.11:8081");
        camera.setResolution(300, 300);
        
        visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
        	
            if (!pipeline.filterContoursOutput().isEmpty()) {
            	
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                
                synchronized (imgLock) {
                	
                    centerX = r.x + (r.width / 2);
                }
            }
        });
        
        visionThread.setDaemon(true);
        visionThread.start();*/
    	
    	//UsbCamera cam = new UsbCamera("cam0", 0);
    	//cam.setResolution(300, 300);
    	
    	//server.startAutomaticCapture(cam);
	}

    @Override
    public void disabledInit() {
    	
    	canCompress = true;
    }

    @Override
    public void autonomousInit() {
    	
    	System.out.println("Autonomous Init Fired");
    	
    	autonomousCommand = autoMode.getSelected();
    	if (autonomousCommand != null) autonomousCommand.start();
    }
    
    @Override
    public void teleopInit() {
    	
    	canCompress = false;
    }
    
    @Override
    public void robotPeriodic() {
    	
    	//SmartDashboard.putData("Door Status", GearShooter.doors_solenoid);
    	SmartDashboard.putData("Drive", CommandBase.drive);
    	SmartDashboard.putData("Door Toggle", new ToggleDoorsCommand(1.0));
    }

    @Override
    public void disabledPeriodic() {
    	
    	/*if (OI.controller.button_Y.get()) {
    		
    		CommandBase.compressor.compress();
    	}
    	
    	else {
    		
    		CommandBase.compressor.stop();
    	}*/
    }

    @Override
    public void teleopPeriodic() {
    	
    	Scheduler.getInstance().run();
        CommandBase.updateSmartDashboard();
    }
    
    @Override
    public void autonomousPeriodic() {
    	
    	Scheduler.getInstance().run();
    	
    	/*System.out.println("autonomousPeriodic() fired");
    	
    	double centerX;
    	
    	synchronized (imgLock) {
    		
    		centerX = this.centerX;
    	}
    	
    	double turn = (IMG_WIDTH / 2) - centerX;
    	
    	System.out.println("Turn: " + turn);
    	
    	RobotMap.drive.arcadeDrive(0.2, turn * 0.005);
    	
    	System.out.println("Center X: " + centerX);*/
    }
    
    @Override
    public void testPeriodic() {
    	
        LiveWindow.run();
        
        if (settings.getBoolean("Compress", true)) {
        	
        	try {
        		
        		CommandBase.compressor.compress();
        		
        	} catch (Exception e) {
        		
        		CommandBase.compressor.stop();
        	}
        }
    }
}
