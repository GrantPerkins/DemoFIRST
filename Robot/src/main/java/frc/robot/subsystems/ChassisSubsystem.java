package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class ChassisSubsystem extends SubsystemBase {
    PWMTalonSRX leftTalonSRX;
    PWMTalonSRX rightTalonSRX;
    DifferentialDrive driveBase;
    Encoder leftEncoder;
    Encoder rightEncoder;
    ADXRS450_Gyro gyro;

    public ChassisSubsystem() {
        leftTalonSRX = new PWMTalonSRX(Constants.DriveConstants.LEFT_MOTOR_PORT);
        rightTalonSRX = new PWMTalonSRX(Constants.DriveConstants.RIGHT_MOTOR_PORT);
        rightTalonSRX.setInverted(true);
        driveBase = new DifferentialDrive(leftTalonSRX, rightTalonSRX);
        driveBase.setRightSideInverted(false);

        leftEncoder = new Encoder(Constants.DriveConstants.LEFT_ENCODER_PORTS[0],
                Constants.DriveConstants.LEFT_ENCODER_PORTS[1], Constants.DriveConstants.LEFT_ENCODER_REVERSED);
        leftEncoder.setDistancePerPulse(Constants.DriveConstants.ENCODER_CPR);

        rightEncoder = new Encoder(Constants.DriveConstants.RIGHT_ENCODER_PORTS[0],
                Constants.DriveConstants.RIGHT_ENCODER_PORTS[1], Constants.DriveConstants.RIGHT_ENCODER_REVERSED);
        rightEncoder.setDistancePerPulse(Constants.DriveConstants.ENCODER_DISTANCE_PER_PULSE);

        gyro = new ADXRS450_Gyro();
    }

    public void drive(double speed, double rotation) {
        driveBase.arcadeDrive(speed, rotation);
    }

    public double getLeftDistance() {
        return leftEncoder.getDistance();
    }

    public double getRightDistance() {
        return rightEncoder.getDistance();
    }

    public void resetDistances() {
        leftEncoder.reset();
        rightEncoder.reset();
    }
}
