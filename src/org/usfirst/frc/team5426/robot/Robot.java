package org.usfirst.frc.team5426.robot;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team5426.robot.auto.DriveStraight;
import org.usfirst.frc.team5426.robot.auto.DropGear;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.vision.VisionThread;
import utils.GripPipeline;

/**
 * Created by Duncan on 1/24/2017.
 */
public class Robot extends IterativeRobot {
    
	private Command auto;
	private SendableChooser<Object> mode;
	
	/*private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private double centerX = 0.0;
	private RobotDrive drive;
	
	private final Object imgLock = new Object();*/
	
	@Override
    public void robotInit() {

    	RobotMap.init();
        CommandBase.init();
        
        mode = new SendableChooser<>();
    	mode.addDefault("Bring Gear", new DropGear());
    	mode.addObject("Drive Straight",  new DriveStraight());
    	
    	/*UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
        
        visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
        	
            if (!pipeline.filterContoursOutput().isEmpty()) {
            	
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                
                synchronized (imgLock) {
                    centerX = r.x + (r.width / 2);
                }
            }
        });*/
        
        //visionThread.start();
            
        //drive = CommandBase.drive.getDrive();
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void autonomousInit() {
    	
    	auto = (Command) mode.getSelected();
    	
    	if (!(mode == null)) auto.start();
    }
    
    @Override
    public void robotPeriodic() {
    	
    	Scheduler.getInstance().run();
    }
    
    @Override
    public void teleopInit() {
    	CommandBase.updateSmartDashboard();
    }

    @Override
    public void disabledPeriodic() {
    	
    }

    @Override
    public void teleopPeriodic() {
    	
    	Scheduler.getInstance().run();
        CommandBase.updateSmartDashboard();
    }

    public void autonomousPeriodic() {
    	
    	/*double centerX;
    	
    	synchronized (imgLock) {
    		
    		centerX = this.centerX;
    	}
    	
    	double turn = centerX - (IMG_WIDTH / 2);
    	
    	drive.arcadeDrive(-0.2, turn * 0.005);
    	
    	Scheduler.getInstance().run();
    	
    	System.out.println("Center X: " + centerX);*/
    }
    
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
