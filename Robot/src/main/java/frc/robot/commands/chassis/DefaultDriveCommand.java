/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.chassis;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ChassisSubsystem;

public class DefaultDriveCommand extends CommandBase {
    private static ChassisSubsystem chassisSubsystem;
    public DefaultDriveCommand() {
        chassisSubsystem = RobotContainer.chassisSubsystem;
        addRequirements(chassisSubsystem);
    }

    @Override
    public void execute() {
        chassisSubsystem.drive(-RobotContainer.joystick.getY(), RobotContainer.joystick.getX());
    }

    public void end(boolean interrupted) {
        chassisSubsystem.stop();
    }
}