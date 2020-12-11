/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Constants {
    public static final class ClawConstants {
        public static final int SERVO_PORT = 8;
    
        public static final double SERVO_CLOSED = 0.0;
        public static final double SERVO_OPEN = 1.0;
    
        public static final double SERVO_ACTION_TIME = 1.0;
      }

    public static final class ArmConstants {
        public static final int MOTOR_PORT = 9;
        public static final int POTENTIOMETER_PORT = 0;
    
        public static final double POTENTIOMETER_RANGE = 270.0;
        public static final double POTENTIOMETER_OFFSET = -192.0;
    
        public static final double P = 0.0258;
        public static final double D = 0.00312;
      }

    public static final class DriveConstants {
        public static final int LEFT_MOTOR_PORT = 7;
        public static final int RIGHT_MOTOR_PORT = 6;
    
        public static final int[] LEFT_ENCODER_PORTS = new int[]{0, 1};
        public static final int[] RIGHT_ENCODER_PORTS = new int[]{2, 3};
        public static final boolean LEFT_ENCODER_REVERSED = true;
        public static final boolean RIGHT_ENCODER_REVERSED = false;

    
        public static final int ENCODER_CPR = 140;
        public static final double WHEEL_DIAMETER_METERS = 0.09;
        public static final double GEAR_RATIO = 72.0 / 90.0;
        public static final double ENCODER_DISTANCE_PER_PULSE =
            (WHEEL_DIAMETER_METERS * Math.PI) / ((double) ENCODER_CPR) * GEAR_RATIO;

      }
}
