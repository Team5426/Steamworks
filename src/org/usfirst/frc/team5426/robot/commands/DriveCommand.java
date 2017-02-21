package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.OI;
import org.usfirst.frc.team5426.robot.RobotMap;

import utils.Front;

public class DriveCommand extends CommandBase {
	
    public DriveCommand() {

        requires(drive);
    }

    @Override
    protected void initialize() {
    	
    }

    @Override
    protected void execute() {
    	
    	if (RobotMap.FRONT.equals(Front.INTAKE)) {
    		
    		drive.drive(-OI.controller.getLeftAxisY(), -OI.controller.getLeftAxisX(), true);
    	}
    	
    	else {
    		
    		drive.drive(OI.controller.getLeftAxisY(), OI.controller.getLeftAxisX(), true);
    	}
        
        // Sending the drive command as fast as possible is pointless and hogs CPU cycles.
        // The 0.003 second delay between drive commands avoids that while still not
        // affecting the speed of the robot
    }

    @Override
    protected boolean isFinished() {

        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
    	
    }
}
