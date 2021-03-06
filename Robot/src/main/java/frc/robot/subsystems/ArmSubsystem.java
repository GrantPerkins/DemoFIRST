/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.Constants;

public class ArmSubsystem extends PIDSubsystem {
    private final SpeedController motor;
    private final Potentiometer potentiometer;

    public ArmSubsystem() {
        super(new PIDController(Constants.ArmConstants.P, 0.0, Constants.ArmConstants.D));
        m_controller.setTolerance(5.0);

        motor = new VictorSP(Constants.ArmConstants.MOTOR_PORT);
        potentiometer = new AnalogPotentiometer(Constants.ArmConstants.POTENTIOMETER_PORT,
                Constants.ArmConstants.POTENTIOMETER_RANGE, Constants.ArmConstants.POTENTIOMETER_OFFSET);
        setSetpoint(-25.0);
        enable();
    }

    @Override
    public void useOutput(double output, double setpoint) {
        motor.set(output);
    }

    @Override
    public double getMeasurement() {
        return potentiometer.get();
    }

    public boolean atSetpoint() {
        return m_controller.atSetpoint();
    }
}
