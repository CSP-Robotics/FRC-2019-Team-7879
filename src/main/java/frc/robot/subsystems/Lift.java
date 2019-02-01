/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final DigitalInput m_limit1 = new DigitalInput(RobotMap.limit1);
  private final DigitalInput m_limit2 = new DigitalInput(RobotMap.limit2);
  private final DigitalInput m_limit3 = new DigitalInput(RobotMap.limit3);

  private final Counter counter1 = new Counter(m_limit1);
  private final Counter counter2 = new Counter(m_limit2);
  private final Counter counter3 = new Counter(m_limit3);

  private final SpeedController m_liftMotor1 = new Spark(RobotMap.liftMotor1);
  private final SpeedController m_liftMotor2 = new Spark(RobotMap.liftMotor2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void goUp() {
    m_liftMotor1.set(0.5);
    m_liftMotor2.set(0.5);
  }

  public void goDown() {
    m_liftMotor1.set(-0.5);
    m_liftMotor2.set(-0.5);
  }

  public void stop() {
    m_liftMotor1.set(0);
    m_liftMotor2.set(0);
  }

  public boolean isSwitchSet(int limit) {
    if(limit == 1) {
      return counter1.get() > 0;
    }else if(limit == 2) {
      return counter2.get() > 0;
    }else if(limit == 3) {
      return counter3.get() > 0;
    }else {
      return true;
    }
  }

  public void resetCounter(int limit) {
    if(limit == 1) {
      counter1.reset();
    }else if(limit == 2) {
      counter2.reset();
    }else if(limit == 3) {
      counter3.reset();
    }
  }
}
