/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.arm.ArmDownCommand;
import frc.robot.commands.arm.ArmMiddleCommand;
import frc.robot.commands.chassis.DefaultDriveCommand;
import frc.robot.commands.claw.CloseClawCommand;
import frc.robot.commands.claw.OpenClawCommand;
import frc.robot.input.Extreme3DPro;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ChassisSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class RobotContainer {
    public static final ChassisSubsystem chassisSubsystem = new ChassisSubsystem();
    public static final ArmSubsystem armSubsystem = new ArmSubsystem();
    public static final ClawSubsystem clawSubsystem = new ClawSubsystem();
    public static final VisionSubsystem visionSubsystem = new VisionSubsystem();
    public static final Extreme3DPro joystick = new Extreme3DPro(0);

    public RobotContainer() {
        chassisSubsystem.setDefaultCommand(new DefaultDriveCommand());
        configureButtonBindings();
    }

    public void configureButtonBindings() {
        joystick.getButton(1).whenPressed(new ArmDownCommand());
        joystick.getButton(2).whenPressed(new ArmMiddleCommand());
        joystick.getButton(5).whenPressed(new OpenClawCommand());
        joystick.getButton(6).whenPressed(new CloseClawCommand());
    }
}
