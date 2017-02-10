package org.usfirst.frc.team5426.robot;

import java.awt.Color;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Created by Duncan on 1/24/2017.
 */
public class Robot extends IterativeRobot {
    
    private Thread vt;
    
    public void robotInit() {

        CommandBase.init();
        OI.init();
        
        vt = new Thread(() -> {
        	
        	UsbCamera cam = CameraServer.getInstance().startAutomaticCapture();
        	cam.setResolution(640, 480);
        	
        	CvSink cvSink = CameraServer.getInstance().getVideo();
        	CvSource os = CameraServer.getInstance().putVideo(cam.getName(), 640, 480);
        	
        	Mat mat = new Mat();
        	
        	while (!Thread.interrupted()) {
        		
        		if (cvSink.grabFrame(mat) == 0) {
        			
					os.notifyError(cvSink.getError());
					
					continue;
				}
        		
        		//Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400),
				//		new Scalar(255, 255, 255), 5);
        		
        		Imgproc.putText(mat, String.valueOf(CommandBase.drive.getRearLeft().get()), new Point(50, 50), 12, 12, new Scalar(255));
        		
				os.putFrame(mat);
        	}
        });
        
        vt.setDaemon(true);
        vt.start();
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
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
