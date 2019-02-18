/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.arcadeDriveWithJoystick;

/**
 * Controls motors attached to the robot's main chassis
 */
public class DriveTrain extends Subsystem {

  // Sets up the drive motors
  private final SpeedController m_frontLeft = new PWMVictorSPX(RobotMap.frontLeftMotor);
  private final SpeedController m_frontRight = new PWMVictorSPX(RobotMap.frontRightMotor);
  private final SpeedController m_backLeft = new PWMVictorSPX(RobotMap.backLeftMotor);
  private final SpeedController m_backRight = new PWMVictorSPX(RobotMap.backRightMotor);
  private final SpeedControllerGroup m_leftGroup = new SpeedControllerGroup(m_frontLeft, m_backLeft);
  private final SpeedControllerGroup m_rightGroup = new SpeedControllerGroup(m_frontRight, m_backRight);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftGroup, m_rightGroup);

  public DriveTrain() {
    addChild("Drive", m_drive);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new arcadeDriveWithJoystick());
  }

  public void drive(Joystick joy) {
    m_drive.arcadeDrive(joy.getY(), joy.getZ());
  }

  public void drive(double speed, double rotation) {
    m_drive.arcadeDrive(speed, rotation);
  }

  public void stop() {
    m_drive.arcadeDrive(0, 0);
  }
}
