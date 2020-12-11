package frc.robot.commands.claw;

import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClawSubsystem;


public class CloseClawCommand extends WaitCommand {
    private final ClawSubsystem claw;
    public CloseClawCommand() {
        super(Constants.ClawConstants.SERVO_ACTION_TIME);

        this.claw = RobotContainer.clawSubsystem;

        addRequirements(claw);
    }

    @Override
    public void initialize() {
        super.initialize();
        claw.close();
    }
}
