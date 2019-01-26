/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class driveTimed extends Command {

  private final double m_speed;
  private final double m_rotation;

  /*
   * @param speed The speed along the X-axis (-1.0 - 1.0)
   * @param time The length of time to drive
   * @param rotation The rate of rotation around the Z-axis (-1.0 - 1.0)
   */
  public driveTimed(double speed, double time, double rotation) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);
    m_speed = speed;
    m_rotation = rotation;
    setTimeout(time);
  }

  public driveTimed() {
    this(1, 10, 0);
  }

  public driveTimed(double time) {
    this(1, time, 0);
  }

  public driveTimed(double time, double rotation) {
    this(1, time, rotation);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.driveTrain.drive(m_speed, m_rotation);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
