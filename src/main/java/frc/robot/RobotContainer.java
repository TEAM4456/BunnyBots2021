// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.*;
import frc.robot.Commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  

  private final DifferentialDrive diffDrive = new DifferentialDrive(RobotMap.leftMaster, RobotMap.rightMaster);
  private final Drive drive = new Drive(RobotMap.leftMaster, RobotMap.rightMaster);
  private final Claw claw = new Claw(RobotMap.clawTalon);
  private final Lift lift = new Lift(RobotMap.liftTalon);
  private final XboxController controller = new XboxController(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    drive.setDefaultCommand(new RunCommand(() -> diffDrive.arcadeDrive(controller.getRawAxis(0), -controller.getRawAxis(1), controller.getStickButtonPressed(Hand.kRight)), drive));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton aButton = new JoystickButton(controller, 1);
    aButton.whileHeld(new moveTheLift(lift, 0.2));

    JoystickButton xButton = new JoystickButton(controller, 3);
    xButton.whileHeld(new moveTheLift(lift, -0.2));

    JoystickButton bButton = new JoystickButton(controller, 2);
    bButton.whileHeld(new moveTheClaw(claw, 0.2));

    JoystickButton yButton = new JoystickButton(controller, 4);
    yButton.whileHeld(new moveTheClaw(claw, -0.2));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  /** public Command getAutonomousCommand() {
    return;
  }
  */
}
