// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class RobotMap {
    public static WPI_TalonSRX leftMaster;
    public static WPI_TalonSRX leftFollower;

    public static WPI_TalonSRX rightMaster;
    public static WPI_TalonSRX rightFollower;

    public static void init() {

        //Creates the talons on the left side of the drivetrain
        leftMaster = new WPI_TalonSRX(0);
        leftFollower = new WPI_TalonSRX(2);
        leftFollower.set(ControlMode.Follower, 1); // does everything leftmaster does

        //Creates the talons on the right side of the drivetrain 
        rightMaster = new WPI_TalonSRX(3);
        rightFollower = new WPI_TalonSRX(4);
        rightFollower.set(ControlMode.Follower, 3); // does everything rightmaster does 
        
        

    }
}
