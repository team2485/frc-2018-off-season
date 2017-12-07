package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.util.TransferNode;
import org.usfirst.frc.team2485.util.WarlordsPIDController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	public enum DriveSpeed {
		SLOW_SPEED_RATING, NORMAL_SPEED_RATING;

		public double getSpeedFactor() {

			switch (this) {
			case SLOW_SPEED_RATING:
				return 0.5;
			case NORMAL_SPEED_RATING:
				return 1.0;
			default:
				return 1.0;
			}
		}
	}
	
	public static final double STEERING_DEADBAND = 0.15;
	public static final double THROTTLE_DEADBAND = 0.05;
	private static final double MIN_CURRENT = 2;
	private static final double MAX_CURRENT = 20;
	
	private WarlordsPIDController anglePID;
	private WarlordsPIDController angleVelocityPID;
	
	private WarlordsPIDController distancePID;
	private WarlordsPIDController velocityPID;
	
	private TransferNode deltaVelocityTN;
	private TransferNode velocityTN;
	
	/**
	 * AHRS + given setpoint -> anglePID -> deltaVelocityTN
	 * Encoders + deltaVelocityTN (as setpoint) -> velocityPID -> current 
	 * 
	 * 
	 * 
	 */
    public DriveTrain() {
    	anglePID = new WarlordsPIDController();
    	anglePID.setSources(RobotMap.ahrs);
    	anglePID.setOutputs(deltaVelocityTN);
    	
    	angleVelocityPID = new WarlordsPIDController();
    	angleVelocityPID.setSources(deltaVelocityTN);
    }
	
    public void reset(){
		emergencyStop();
	}
	
	public void emergencyStop() {
		RobotMap.driveLeft.set(0);
		RobotMap.driveRight.set(0);
	}
	
    public void initDefaultCommand() {
        
    }
}

