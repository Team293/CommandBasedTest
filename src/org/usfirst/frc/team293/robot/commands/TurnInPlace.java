package org.usfirst.frc.team293.robot.commands;

import org.usfirst.frc.team293.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnInPlace extends Command {
		double deltaTheta;
		boolean isFinished = false;
    public TurnInPlace(double angle) {
    	deltaTheta = angle;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.TrainofDriving);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.TrainofDriving.resetGyro();
    	Robot.TrainofDriving.resetEnc();
    	Robot.TrainofDriving.resetInitialPower();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isFinished = Robot.TrainofDriving.newGyroTurnInPlace(deltaTheta);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.TrainofDriving.tankdrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
