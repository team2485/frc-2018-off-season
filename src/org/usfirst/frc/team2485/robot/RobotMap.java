package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2485.util.SpeedControllerWrapper;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//CONSTANTS//
	
	public static double ROBOT_WIDTH = 27;
	
	public static int driveRightPort1 = 1;
	public static int driveRightPort2 = 3;
	public static int driveRightPort3 = 2;
	public static int driveLeftPort1 = 4;
	public static int driveLeftPort2 = 6;
	public static int driveLeftPort3 = 5;
	
	public static int kRightDriveEncPortA = 0;
	public static int kRightDriveEncPortB = 1;
	public static int kLeftDriveEncPortB = 2;
	public static int kLeftDriveEncPortA = 3; 
	
	//HARDWARE//
	
	public static AHRS ahrs;
	
	public static CANTalon driveLeft1;
	public static CANTalon driveLeft2;
	public static CANTalon driveLeft3;
	public static CANTalon driveRight1;
	public static CANTalon driveRight2;
	public static CANTalon driveRight3;
	
	public static SpeedControllerWrapper driveLeft;
	public static SpeedControllerWrapper driveRight;
	
	public static Encoder leftDriveEnc;
	public static Encoder rightDriveEnc;
	
	//SUBSYSTEMS//
	public static DriveTrain drivetrain;
	
	public static void init() {

		ahrs = new AHRS(Port.kMXP);
		
		driveLeft1 = new CANTalon(driveLeftPort1);
		driveLeft2 = new CANTalon(driveLeftPort2);
		driveLeft3 = new CANTalon(driveLeftPort3);
		driveRight1 = new CANTalon(driveRightPort1);
		driveRight2 = new CANTalon(driveRightPort2);
		driveRight3 = new CANTalon(driveRightPort3);
		
		driveLeft = new SpeedControllerWrapper(driveLeft1, driveLeft2, driveLeft3);
		driveRight = new SpeedControllerWrapper(driveRight1, driveRight2, driveRight3);
		
		leftDriveEnc = new Encoder(kRightDriveEncPortA, kRightDriveEncPortB);
		rightDriveEnc = new Encoder(kLeftDriveEncPortA, kLeftDriveEncPortB);
	}
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
