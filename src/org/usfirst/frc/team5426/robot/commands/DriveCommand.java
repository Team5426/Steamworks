package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Timer;

public class DriveCommand extends CommandBase {

    public DriveCommand() {

        requires(drive);
    }

    protected void initialize() {

    }

    protected void execute() {
    	
        drive.drive(-OI.controller.getLeftAxisY(), -OI.controller.getLeftAxisX());
        
        // Sending the drive command as fast as possible is pointless and hogs CPU cycles.
        // The 0.003 second delay between drive commands avoids that while still not
        // affecting the speed of the robot
    }

    protected boolean isFinished() {

        return false;
    }

    protected void end() {

    }

    protected void interrupted() {
    	
    }
}
