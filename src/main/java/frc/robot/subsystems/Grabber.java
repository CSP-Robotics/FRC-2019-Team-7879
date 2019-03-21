/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.buttonGrabber;
import edu.wpi.first.wpilibj.Servo;

/**
 * Add your docs here.
 */
public class Grabber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final Servo m_top = new Servo(RobotMap.topGrabber);
  private final Servo m_bottom = new Servo(RobotMap.topGrabber);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new buttonGrabber());
  }

  public void setPosition(double speed) {
    m_top.set(speed);
    m_bottom.set(speed);
  }

  public void stop() {
    m_top.set(1);
    m_bottom.set(1);
  }
}
