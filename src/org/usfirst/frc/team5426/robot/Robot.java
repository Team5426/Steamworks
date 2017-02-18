package org.usfirst.frc.team5426.robot;

import org.usfirst.frc.team5426.robot.auto.DriveStraight;
import org.usfirst.frc.team5426.robot.auto.DropGear;
import org.usfirst.frc.team5426.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * Created by Duncan on 1/24/2017.
 */
public class Robot extends IterativeRobot {
    
	private Command auto;
	private SendableChooser<Object> mode;
	
	@Override
    public void robotInit() {

    	RobotMap.init();
        CommandBase.init();
        
        mode = new SendableChooser<>();
    	mode.addDefault("Bring Gear", new DropGear());
    	mode.addObject("Drive Straight",  new DriveStraight());
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
    	
    	Scheduler.getInstance().run();
    }
    
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
