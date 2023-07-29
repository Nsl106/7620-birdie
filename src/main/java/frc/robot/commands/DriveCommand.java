package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private final DoubleSupplier driveSpeed;
    private final DoubleSupplier rotationSpeed;
    private final Drivetrain drivetrain;

    public DriveCommand(DoubleSupplier driveSpeed, DoubleSupplier rotationSpeed) {
        this.driveSpeed = driveSpeed;
        this.rotationSpeed = rotationSpeed;
        this.drivetrain = Drivetrain.getInstance();
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.setSpeed(driveSpeed.getAsDouble(), rotationSpeed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
