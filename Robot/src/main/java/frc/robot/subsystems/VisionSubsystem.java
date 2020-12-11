/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
    NetworkTableEntry visionEntry;
    private int centerX = -1;
    private int width = -1;

    public VisionSubsystem() {
        visionEntry = NetworkTableInstance.getDefault().getTable("Vision").getEntry("data");
    }

    @Override
    public void periodic() {
        String[] data = visionEntry.getString("-1 -1").split(" ");
        centerX = Integer.parseInt(data[0]);
        width = Integer.parseInt(data[1]);
    }

    public int getWidth() {
        return width;
    }

    public int getCenterX() {
        return centerX == -1 ? 320: centerX;
    }
}
