package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private final Spark elevator = new Spark(1);

    private Elevator() {

    }

    public void setSpeed(double speed) {
        elevator.set(speed);
    }

    public void stop() {
        elevator.set(0);
    }

    private static Elevator instance;

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }
        return instance;
    }
}
