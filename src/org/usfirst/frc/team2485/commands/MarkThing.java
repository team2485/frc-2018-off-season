package org.usfirst.frc.team2485.commands;

import org.usfirst.frc.team2485.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class MarkThing extends Command {
	private double dist;
	
	public MarkThing (double dist) {
		requires(RobotMap.driveTrain);
		this.dist = dist;
	}
	
	public void execute() {
		RobotMap.driveTrain.markThing(dist);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return RobotMap.driveLeft.get() == 0;
	}
}
