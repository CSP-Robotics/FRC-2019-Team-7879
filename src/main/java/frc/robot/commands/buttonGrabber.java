/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class buttonGrabber extends Command {

  Joystick joy = Robot.m_oi.getJoystick();

  public buttonGrabber() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.grabber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(joy.getRawButtonPressed(1)) {
      Robot.grabber.setPosition(0.1);
    }
    else if(joy.getRawButtonPressed(2)){
      Robot.grabber.setPosition(0.4);
    }
    else if(joy.getRawButtonPressed(4)){
      Robot.grabber.setPosition(0.85);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.grabber.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
