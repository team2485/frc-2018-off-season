package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.util.MotorSetter;
import org.usfirst.frc.team2485.util.TransferNode;
import org.usfirst.frc.team2485.util.WarlordsPIDController;
import org.usfirst.frc.team2485.util.WarlordsPIDSource;

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
	
	private WarlordsPIDSource maxAngleVelocityOutputSource, minAngleVelocityOutputSource;
	
	private WarlordsPIDController anglePID;
	private WarlordsPIDController angleVelocityPID;
	
	private WarlordsPIDController distancePID;
	private WarlordsPIDController velocityPID;
	
	private TransferNode deltaVelocityTN;
	private TransferNode velocityTN;
	private TransferNode deltaVelocityOutputTN, velocityOutputTN;
	
	private MotorSetter leftMotorSetter, rightMotorSetter;
	
	/**
	 * AHRS + given setpoint -> anglePID -> deltaVelocityTN
	 * Encoders + deltaVelocityTN (as setpoint) -> velocityPID -> current 
	 * 
	 * 
	 * 
	 */
    public DriveTrain() {
    	maxAngleVelocityOutputSource = new WarlordsPIDSource() {
			
			@Override
			public double pidGet() {
				// TODO Auto-generated method stub
				return 0;
		}
		};
    	
    	anglePID = new WarlordsPIDController();
    	anglePID.setSources(RobotMap.ahrs);
    	anglePID.setOutputs(deltaVelocityTN);
    	
    	distancePID = new WarlordsPIDController();
    	distancePID.setSources(RobotMap.averageEncoderDistance);
    	distancePID.setOutputs(velocityTN);
    	
    	angleVelocityPID = new WarlordsPIDController();
    	angleVelocityPID.setSetpoint(deltaVelocityTN.getOutput());
    	angleVelocityPID.setSources(RobotMap.ahrs);
    	angleVelocityPID.setOutputs(deltaVelocityOutputTN);
    	
    	velocityPID = new WarlordsPIDController();
    	velocityPID.setSources(velocityTN);
    	velocityPID.setOutputs(velocityOutputTN);
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
    
    public void WarlordsDrive(double throttle, double steering) {
    	angleVelocityPID.setSetpoint(steering * 2 * velocityOutputTN.getOutput() / RobotMap.ROBOT_WIDTH);
    	velocityPID.setSetpoint(throttle);
    	leftMotorSetter.setSetpoint(velocityOutputTN.getOutput() + deltaVelocityOutputTN.getOutput());
    	rightMotorSetter.setSetpoint(velocityOutputTN.getOutput() - deltaVelocityOutputTN.getOutput());

    }
    
    public void markThing(double dist) {
    	if (Math.abs(dist - RobotMap.averageEncoderDistance.pidGet()) < 250) {
    		RobotMap.driveLeft.set(0);
    		RobotMap.driveRight.set(0);
    	} else {
    		RobotMap.driveLeft.set(1);
    		RobotMap.driveRight.set(1);
    	}
    }
}

