/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase {
    private final Servo servo;

    public ClawSubsystem() {
        servo = new Servo(Constants.ClawConstants.SERVO_PORT);
    }

    public void open() {
        servo.set(Constants.ClawConstants.SERVO_OPEN);
    }

    public void close() {
        servo.set(Constants.ClawConstants.SERVO_CLOSED);
    }
}
