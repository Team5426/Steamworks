package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.Timer;

public class Drive extends CommandBase {

    public Drive() {

        requires(drive);
    }

    protected void initialize() {

    }

    protected void execute() {
    	
        drive.drive(OI.getLeftAxisY(), OI.getLeftAxisX(), OI.getRightAxisX(), false);
        
        OI.getStick().setRumble(RumbleType.kLeftRumble, 10);
        OI.getStick().setRumble(RumbleType.kRightRumble, 10);

        Timer.delay(0.005);
    }

    protected boolean isFinished() {

        return false;
    }

    protected void end() {

    }

    protected void interrupted() {

    }
}
