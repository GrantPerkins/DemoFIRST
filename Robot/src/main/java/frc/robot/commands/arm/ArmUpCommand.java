package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class ArmUpCommand extends CommandBase {
    private final ArmSubsystem arm;

    public ArmUpCommand() {
        this.arm = RobotContainer.armSubsystem;

        addRequirements(arm);
    }

    @Override
    public void execute() {
        arm.setSetpoint(25.0);
    }

    @Override
    public boolean isFinished() {
        return arm.atSetpoint();
    }
}
