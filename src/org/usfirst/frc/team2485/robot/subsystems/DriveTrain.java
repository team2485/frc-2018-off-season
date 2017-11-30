package org.usfirst.frc.team2485.robot.subsystems;

import org.usfirst.frc.team2485.robot.RobotMap;
import org.usfirst.frc.team2485.util.TransferNode;
import org.usfirst.frc.team2485.util.WarlordsPIDController;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private WarlordsPIDController anglePID;
	private WarlordsPIDController velocityPID;
	
	private TransferNode deltaVelocityTN;
	
    public DriveTrain() {
    	anglePID = new WarlordsPIDController();
    	anglePID.setSources(RobotMap.ahrs);
    	anglePID.setOutputs(deltaVelocityTN);
    	
    	velocityPID = new WarlordsPIDController();
    	velocityPID.setSources(deltaVelocityTN);
    }
	
	
    public void initDefaultCommand() {
        
    }
}

