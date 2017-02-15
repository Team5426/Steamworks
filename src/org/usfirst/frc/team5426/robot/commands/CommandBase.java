package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.OI;
import org.usfirst.frc.team5426.robot.RobotMap;
import org.usfirst.frc.team5426.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5426.robot.subsystems.GearShooter;
import org.usfirst.frc.team5426.robot.subsystems.Intake;
import org.usfirst.frc.team5426.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Created by Duncan on 1/24/2017.
 */
public abstract class CommandBase extends Command {

    public static DriveTrain drive;
    public static GearShooter gearshooter;
    public static Intake intake;
    public static Launcher launcher;
    public static OI oi;

    public CommandBase(String name) {

        super(name);
    }

    public CommandBase() {

        super();
    }

    public static void init() {

        drive = new DriveTrain();
        //gearshooter = new GearShooter();
        //intake = new Intake();
        //launcher = new Launcher();
        oi = new OI();
    }
    
    //private static AnalogInput u = new AnalogInput(0);

    public static void updateSmartDashboard() {
    	
    	if (SmartDashboard.containsKey("FRONT_LEFT_CHANNEL")
    	 && SmartDashboard.containsKey("FRONT_RIGHT_CHANNEL")
    	 && SmartDashboard.containsKey("BACK_LEFT_CHANNEL")
    	 && SmartDashboard.containsKey("BACK_RIGHT_CHANNEL")) {
    		
    		RobotMap.init();    		
    	}
    	
    	else {
    		
    		RobotMap.FRONT_LEFT_CHANNEL  = 2;
    		RobotMap.BACK_LEFT_CHANNEL 	 = 3;
    		RobotMap.FRONT_RIGHT_CHANNEL = 4;
    		RobotMap.BACK_RIGHT_CHANNEL  = 5;
    	}
    	
    	//SmartDashboard.putNumber("Distance", u.getValue() * 0.125);
    }
}