// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;;

public class Chassis extends SubsystemBase {
  /** Creates a new chassis. */
  PWMVictorSPX leftMotor, rightMotor;
  Encoder leftEncoder, rightEncoder;
  DifferentialDrive differentialDrive;
  public Chassis() {
    leftMotor = new PWMVictorSPX(Constants.LEFT_MOTOR_PORT);
    rightMotor = new PWMVictorSPX(Constants.RIGHT_MOTOR_PORT);

    differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
    //differentialDrive.setRightSideInverted(false);
    differentialDrive.setSafetyEnabled(false);
    leftEncoder = new Encoder(Constants.LEFT_ENCODER_A, Constants.LEFT_ENCODER_B);
    rightEncoder = new Encoder(Constants.RIGHT_ENCODER_A, Constants.RIGHT_ENCODER_B);
    
    leftEncoder.setDistancePerPulse(Constants.INCHES_PER_PULSE);
    rightEncoder.setDistancePerPulse(Constants.INCHES_PER_PULSE);
    addChild("leftEncoder", leftEncoder);
    addChild("rightEncoder", rightEncoder);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void reset() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void drive(double speed, double direction) {
    differentialDrive.arcadeDrive(speed, direction);
  }

  public void stop() {
    drive(0,0);
  }

  public double getLeftDistance() {
    return leftEncoder.getDistance();
  }
}
