// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Lift extends SubsystemBase {
  private final WPI_TalonSRX lift;
  /** Creates a new runClaw. */
  public Lift(WPI_TalonSRX liftTalon) {
    lift = liftTalon;
  }

  public void runClaw(double percent) {
    lift.set(ControlMode.PercentOutput, percent);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
