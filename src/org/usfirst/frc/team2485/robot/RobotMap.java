package org.usfirst.frc.team2485.robot;

import org.usfirst.frc.team2485.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2485.util.AHRSWrapperRateAndAngle;
import org.usfirst.frc.team2485.util.DeadReckoning;
import org.usfirst.frc.team2485.util.EncoderWrapperRateAndDistance;
import org.usfirst.frc.team2485.util.MultipleEncoderWrapper;
import org.usfirst.frc.team2485.util.SpeedControllerWrapper;
import org.usfirst.frc.team2485.util.AHRSWrapperRateAndAngle.Units;
import org.usfirst.frc.team2485.util.MultipleEncoderWrapper.MultipleEncoderWrapperMode;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.hal.PDPJNI;

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
	
	//Sensors
	public static Encoder driveEncLeft, driveEncRight;
	
	public static MultipleEncoderWrapper averageEncoderDistance, averageEncoderRate;
	public static EncoderWrapperRateAndDistance driveEncRateLeft, driveEncRateRight;
	public static AHRSWrapperRateAndAngle ahrsRateRads;
	public static DeadReckoning autoDeadReckoning;
	
	public static PowerDistributionPanel pdp;
	
	
	//SUBSYSTEMS//
	public static DriveTrain driveTrain;
	
	public static void init() {
		
		pdp = new PowerDistributionPanel();

		ahrs = new AHRS(Port.kMXP);
		
		driveEncLeft = new Encoder(kLeftDriveEncPortA, kLeftDriveEncPortB);
		driveEncRight = new Encoder(kRightDriveEncPortA, kRightDriveEncPortB);
		

		averageEncoderDistance = new MultipleEncoderWrapper(PIDSourceType.kDisplacement,
				MultipleEncoderWrapperMode.AVERAGE, driveEncLeft, driveEncRight);

		averageEncoderRate = new MultipleEncoderWrapper(PIDSourceType.kRate, MultipleEncoderWrapperMode.AVERAGE,
				driveEncLeft, driveEncRight);
		ahrsRateRads = new AHRSWrapperRateAndAngle(PIDSourceType.kRate, Units.RADS);
		autoDeadReckoning = new DeadReckoning(ahrs, driveEncLeft, driveEncRight);

		
		
		driveLeft1 = new CANTalon(driveLeftPort1);
		driveLeft2 = new CANTalon(driveLeftPort2);
		driveLeft3 = new CANTalon(driveLeftPort3);
		driveRight1 = new CANTalon(driveRightPort1);
		driveRight2 = new CANTalon(driveRightPort2);
		driveRight3 = new CANTalon(driveRightPort3);
		
		driveLeft = new SpeedControllerWrapper(driveLeft1, driveLeft2, driveLeft3);
		driveRight = new SpeedControllerWrapper(driveRight1, driveRight2, driveRight3);
		
		driveTrain  = new DriveTrain();
		//@todo create custom CANTalon-encoder wrapper
		
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
