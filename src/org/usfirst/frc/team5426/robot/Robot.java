package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Created by Duncan on 1/24/2017.
 */
public class Robot extends IterativeRobot {
    
    private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread vt;
	private double centerX = 0.0;
	private RobotDrive drive;
	
	private final Object imagelock = new Object();
    
    public void robotInit() {

    	RobotMap.init();
        CommandBase.init();
        
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
    
        vt = new VisionThread(camera, new Pipeline(), pipeline -> {
            
            if (!pipeline.filterContoursOutput().isEmpty()) {
                
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                
                synchronized (imagelock) {
                    centerX = r.x + (r.width / 2);
                }
            }
        });
        
        visionThread.start();
        
        drive = new RobotDrive(1, 2);
    }

    public void disabledInit() {

    }

    public void autonomousInit() {

    }

    public void teleopInit() {
    	
    	Scheduler.getInstance().run();
    	CommandBase.updateSmartDashboard();
    }

    public void disabledPeriodic() {
    	
    	Scheduler.getInstance().run();
    }

    public void teleopPeriodic() {
    	
    	Scheduler.getInstance().run();
        CommandBase.updateSmartDashboard();
    }

    public void autonomousPeriodic() {
    	
    	Scheduler.getInstance().run();
        
        double centerX;
        
	    synchronized (imagelock) {
            
		    centerX = this.centerX;
	    }
        
	    double turn = centerX - (IMG_WIDTH / 2);
        
	    drive.arcadeDrive(-0.6, turn * 0.005);
    }
    
    public void testPeriodic() {
        
        LiveWindow.run();
    }
}
