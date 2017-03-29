package org.usfirst.frc.team5426.robot.commands;

import org.usfirst.frc.team5426.robot.OI;
import org.usfirst.frc.team5426.robot.RobotMap;
import org.usfirst.frc.team5426.robot.subsystems.Climber;
import org.usfirst.frc.team5426.robot.subsystems.CompressorControl;
import org.usfirst.frc.team5426.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5426.robot.subsystems.GearShooter;
import org.usfirst.frc.team5426.robot.subsystems.Intake;
import org.usfirst.frc.team5426.robot.subsystems.Launcher;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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
    public static CompressorControl compressor;
    public static GearShooter gearshooter;
    public static Launcher launcher;
    public static Climber climber;
    public static OI oi;
    
    //public static ADXRS450_Gyro gyro;
    
    public static SendableChooser<Front> front;

    public CommandBase(String name) {

        super(name);
    }

    public CommandBase() {

        super();
    }

    public static void init() {
    	
    	front = new SendableChooser<>();
    	front.addDefault("Intake", Front.INTAKE);
    	front.addObject("Gear Shooter", Front.SHOOTER);

    	intake = new Intake();
        drive = new DriveTrain();
        gearshooter = new GearShooter();
        launcher = new Launcher();
        climber = new Climber();
        compressor = new CompressorControl();
        oi = new OI();
        
        //gyro = new ADXRS450_Gyro();
    }
    
    //private static AnalogInput u = new AnalogInput(0);

    public static void updateSmartDashboard() {
    	
    	SmartDashboard.putData("Door Status", GearShooter.shooter_solenoid);
    }
}
