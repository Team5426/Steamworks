package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.OI;
import org.usfirst.frc.team5426.robot.RobotMap;
import org.usfirst.frc.team5426.robot.subsystems.Climber;
import org.usfirst.frc.team5426.robot.subsystems.CompressorControl;
import org.usfirst.frc.team5426.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5426.robot.subsystems.GearShooter;
import org.usfirst.frc.team5426.robot.subsystems.Intake;
import org.usfirst.frc.team5426.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import utils.Front;

/**
 * Created by Duncan on 1/24/2017.
 */
public abstract class CommandBase extends Command {

	public static Intake intake;
    public static DriveTrain drive;
    public static GearShooter gearshooter;
    public static Launcher launcher;
    public static Climber climber;
    public static CompressorControl compressor;
    public static OI oi;
    
    public static SendableChooser<Front> front;

    public CommandBase(String name) {

        super(name);
    }

    public CommandBase() {

        super();
    }

    public static void init() {

    	intake = new Intake();
        drive = new DriveTrain();
        gearshooter = new GearShooter();
        launcher = new Launcher();
        climber = new Climber();
        compressor = new CompressorControl();
        oi = new OI();
        
        front = new SendableChooser<>();
    	front.addDefault("Intake", Front.INTAKE);
    	front.addObject("Gear Shooter", Front.SHOOTER);
    }
    
    //private static AnalogInput u = new AnalogInput(0);

    public static void updateSmartDashboard() {
    	
    	SendableChooser<Front> front = new SendableChooser<>();
    	front.addDefault("Intake", Front.INTAKE);
    	front.addObject("Gear Shooter", Front.SHOOTER);
    	
    	SmartDashboard.putData("Front", front);
    	
    	RobotMap.init();
    }
}
