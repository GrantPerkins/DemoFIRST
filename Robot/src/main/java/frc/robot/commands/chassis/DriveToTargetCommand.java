/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.chassis;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class DriveToTargetCommand extends PIDCommand {
    private final ChassisSubsystem chassisSubsystem;
    private final VisionSubsystem visionSubsystem;

    public DriveToTargetCommand() {
        super(
            new PIDController(Constants.DriveConstants.P, 0, 0), 
            RobotContainer.visionSubsystem::getCenterX, 320,
            RobotContainer.chassisSubsystem::steer,
             RobotContainer.chassisSubsystem
        );
        chassisSubsystem = RobotContainer.chassisSubsystem;
        visionSubsystem = RobotContainer.visionSubsystem;
    }

    @Override
    public void end(boolean interrupted) {
        chassisSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return visionSubsystem.getWidth() > Constants.VisionConstants.TOO_CLOSE;
    }
}
