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
    
    public void robotInit() {

    	RobotMap.init();
        CommandBase.init();
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
