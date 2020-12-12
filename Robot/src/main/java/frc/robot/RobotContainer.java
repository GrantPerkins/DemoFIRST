/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.arm.ArmDownCommand;
import frc.robot.commands.arm.ArmUpCommand;
import frc.robot.commands.auto.GrabAndScoreCommand;
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
        SmartDashboard.putData("ArmDown", new ArmDownCommand());
        SmartDashboard.putData("ArmUp", new ArmUpCommand());
        SmartDashboard.putData("Open Claw", new OpenClawCommand());
        SmartDashboard.putData("Close Claw", new CloseClawCommand());
        SmartDashboard.putData("GrabAndScore", new GrabAndScoreCommand());
    }
}
