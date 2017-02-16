package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.OI;
import org.usfirst.frc.team5426.robot.subsystems.Climber;
import org.usfirst.frc.team5426.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5426.robot.subsystems.GearShooter;
import org.usfirst.frc.team5426.robot.subsystems.Intake;
import org.usfirst.frc.team5426.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Created by Duncan on 1/24/2017.
 */
public abstract class CommandBase extends Command {

    public static DriveTrain drive;
    public static GearShooter gearshooter;
    public static Intake intake;
    public static Launcher launcher;
    public static Climber climber;
    public static OI oi;

    public CommandBase(String name) {

        super(name);
    }

    public CommandBase() {

        super();
    }

    public static void init() {

        drive = new DriveTrain();
        gearshooter = new GearShooter();
        //intake = new Intake();
        launcher = new Launcher();
        climber = new Climber();
        oi = new OI();
    }
    
    //private static AnalogInput u = new AnalogInput(0);

    public static void updateSmartDashboard() {
    	
    	//SmartDashboard.putNumber("Distance", u.getValue() * 0.125);
    }
}
