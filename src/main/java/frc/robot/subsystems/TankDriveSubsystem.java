// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.servohub.ServoHub.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.*;

import edu.wpi.first.math.MathUsageId;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDriveSubsystem extends SubsystemBase {

private static SparkBaseConfig config = new SparkMaxConfig();

/* sparkmax motors */
private static SparkMax LMotor1 = new SparkMax(1, MotorType.kBrushless);
private static SparkMax LMotor2 = new SparkMax(2, MotorType.kBrushless);

private static SparkMax RMotor1 = new SparkMax(3, MotorType.kBrushless);
private static SparkMax RMotor2 = new SparkMax(4, MotorType.kBrushless);

private static final double speedLimit = 0.25;

private static TankDriveSubsystem tankDriveSubsystem = new TankDriveSubsystem();
/* robot graph
 *    front
 *  O---------O
 *  |         |
 *  |LM1   RM1|
 *  O         O
 *  |LM2   RM2|
 *  |         |
 *  O---------O
       back
 */    

  /** Creates a new TankDrive subsystem. Primarially for training. */
  public TankDriveSubsystem() {
    config.inverted(false);
    LMotor2.configure(config, com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    config.inverted(true);
    RMotor1.configure(config, com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    RMotor2.configure(config, com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  
  }

  public static TankDriveSubsystem getInstance() {
    if (tankDriveSubsystem == null) {
      tankDriveSubsystem = new TankDriveSubsystem();

    }

    return tankDriveSubsystem;
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /** Sets the motor's speed. 
   * @param speed The speed of the motors.
   * @param isLeftSide Used to choose which side of the robot you want to move. Name's self explanatory.
   * 
  */

  private void setLeftMotors(double speed) {
    LMotor1.set(speed);
    LMotor2.set(speed);

  }

  private void setRightMotors(double speed) {
    RMotor1.set(speed);
    RMotor2.set(speed);

  }

  public void setMotorSpeed(double leftSpeed, double rightSpeed, boolean isLeftSide) {
    /* sets speed of left/right side motors, depending on which joystick's pushed */
    setLeftMotors(leftSpeed);
    setRightMotors(rightSpeed);    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
