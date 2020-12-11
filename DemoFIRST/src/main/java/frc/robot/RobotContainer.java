/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.chassis.DefaultDriveCommand;
import frc.robot.input.Extreme3DPro;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ChassisSubsystem;

public class RobotContainer {
    public static final ChassisSubsystem chassisSubsystem = new ChassisSubsystem();
    public static final ArmSubsystem armSubsystem = new ArmSubsystem();
    public static final Extreme3DPro joystick = new Extreme3DPro(0);
    public RobotContainer() {
        chassisSubsystem.setDefaultCommand(new DefaultDriveCommand());
    }
}
