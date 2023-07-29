package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private final Spark leftDrive = new Spark(0);
    private final Spark rightDrive = new Spark(2);

    private final DifferentialDrive drivetrain = new DifferentialDrive(leftDrive, rightDrive);

    private Drivetrain() {
        leftDrive.setInverted(true);
    }

    public void setSpeed(double speed, double rotation) {
        drivetrain.arcadeDrive(speed, rotation, true);
    }

    public void stop() {
        drivetrain.arcadeDrive(0, 0);
    }

    private static Drivetrain instance;

    public static Drivetrain getInstance() {
        if (instance == null) {
            instance = new Drivetrain();
        }
        return instance;
    }
}