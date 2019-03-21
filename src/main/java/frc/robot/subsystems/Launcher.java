/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.buttonLauncher;

/**
 * Add your docs here.
 */
public class Launcher extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands. 

  private final DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.solenoid1, RobotMap.solenoid2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new buttonLauncher());
  }

  public void shoot() {
    solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void release() {
    solenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void shootBall() {
    shoot();
    release();
  }
}
