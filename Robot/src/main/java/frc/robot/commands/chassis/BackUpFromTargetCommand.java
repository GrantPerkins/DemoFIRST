/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.chassis;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class BackUpFromTargetCommand extends CommandBase {
    private final ChassisSubsystem chassisSubsystem;
    private final VisionSubsystem visionSubsystem;

    public BackUpFromTargetCommand() {
        chassisSubsystem = RobotContainer.chassisSubsystem;
        visionSubsystem = RobotContainer.visionSubsystem;
        addRequirements(chassisSubsystem);
    }

    @Override
    public void execute() {
        chassisSubsystem.drive(-.5, 0);
    }

    @Override
    public void end(boolean interrupted) {
        chassisSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return visionSubsystem.getWidth() < Constants.VisionConstants.FAR_ENOUGH;
    }
}
