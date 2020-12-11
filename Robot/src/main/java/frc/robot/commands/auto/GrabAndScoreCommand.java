package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.arm.ArmDownCommand;
import frc.robot.commands.arm.ArmUpCommand;
import frc.robot.commands.chassis.BackUpFromTargetCommand;
import frc.robot.commands.chassis.DriveToTargetCommand;
import frc.robot.commands.claw.CloseClawCommand;
import frc.robot.commands.claw.OpenClawCommand;

public class GrabAndScoreCommand extends SequentialCommandGroup {
    public GrabAndScoreCommand() {
        addCommands(
            new ArmDownCommand(),
            new CloseClawCommand(),
            new ArmUpCommand(),
            new DriveToTargetCommand(),
            new OpenClawCommand(),
            new BackUpFromTargetCommand(),
            new ArmDownCommand()
        );
    }
}
