package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

import java.util.function.DoubleSupplier;

public class ElevatorCommand extends CommandBase {
    private final DoubleSupplier elevatorSpeed;
    private final Elevator elevator;

    public ElevatorCommand(DoubleSupplier driveSpeed) {
        this.elevatorSpeed = driveSpeed;
        this.elevator = Elevator.getInstance();
        addRequirements(elevator);
    }

    @Override
    public void execute() {
        elevator.setSpeed(elevatorSpeed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        elevator.stop();
    }
}
