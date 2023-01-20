// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Forward;
import frc.robot.commands.turn;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj.XboxController;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final Chassis chassis = new Chassis();
  public static final XboxController controller = new XboxController(1);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
  }
    //configureButtonBindings();


  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */


  private void configureButtonBindings() {
    // SmartDashboard.putData("Forward", new Forward(10));
    // SmartDashboard.putData("Turn90", new turn(90));
    if (controller.getLeftBumperPressed() == true) {
      if (controller.getRightBumperPressed() == true){
        chassis.drive(0.15, 0);
      } else {
        chassis.drive(0,90);
      }
    } else if (controller.getRightBumperPressed() == true) {
      chassis.drive(0,270);
    }
    if (controller.getLeftBumperReleased() == true) {
      if (controller.getRightBumperReleased() == true) {
        chassis.stop();
      } else {
        chassis.drive(0,270);
      }
    } else if (controller.getRightBumperReleased() == true) {
      chassis.drive(0,90);
    }
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new PrintCommand("message");

  }
}
