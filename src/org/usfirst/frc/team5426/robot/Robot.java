package org.usfirst.frc.team5426.robot;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team5426.robot.auto.DriveStraight;
import org.usfirst.frc.team5426.robot.auto.DropGear;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
import utils.GripPipeline;

/**
 * Created by Duncan on 1/24/2017.
 */
public class Robot extends IterativeRobot {
    
	private Command auto;
	private SendableChooser<Object> mode;
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private double centerX = 0.0;
	
	private final Object imgLock = new Object();
	
	public static boolean canCompress = false;
	
	@Override
    public void robotInit() {
		
		/*mode = new SendableChooser<>();
		mode.addDefault("Bring Gear", new DropGear());
    	mode.addObject("Drive Straight",  new DriveStraight());
    	SmartDashboard.putData("Auto Mode: " , mode);*/

    	RobotMap.init();
    	
    	/*mode = new SendableChooser<>();
		mode.addDefault("Bring Gear", new DropGear());
    	mode.addObject("Drive Straight",  new DriveStraight());
    	SmartDashboard.putData("Auto Mode: " , mode);*/
    	
        CommandBase.init();
    	
    	//CameraServer server = CameraServer.getInstance();
    	
    	//AxisCamera camera = server.addAxisCamera("raspberrypi.local:8081");
        //camera.setResolution(300, 300);
        
        /*visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
        	
            if (!pipeline.filterContoursOutput().isEmpty()) {
            	
            	System.out.println("FOUND SOMETHING");
            	
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                
                synchronized (imgLock) {
                	
                    centerX = r.x + (r.width / 2);
                }
            }
        });
        
        visionThread.setDaemon(true);
        visionThread.start();*/
	}

    @Override
    public void disabledInit() {
    	
    	canCompress = true;
    }

    @Override
    public void autonomousInit() {
    	
    	canCompress = false;
    	
    	/*auto = (Command) mode.getSelected();
    	auto.start();*/
    }
    
    @Override
    public void teleopInit() {
    	
    	canCompress = false;
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
        CommandBase.updateSmartDashboard();
    }
    
    @Override
    public void autonomousPeriodic() {
    	
    	/*System.out.println("autonomousPeriodic() fired");
    	
    	double centerX;
    	
    	synchronized (imgLock) {
    		
    		centerX = this.centerX;
    	}
    	
    	double turn = centerX - (IMG_WIDTH / 2);
    	
    	System.out.println("Turn: " + turn);
    	
    	RobotMap.drive.arcadeDrive(0.2, turn * 0.005);
    	
    	System.out.println("Center X: " + centerX);*/
    }
    
    @Override
    public void testPeriodic() {
    	
        LiveWindow.run();
    }
}
