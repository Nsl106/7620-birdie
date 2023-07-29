package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Pneumatics;

public class Controls {
    private static final CommandXboxController driver = new CommandXboxController(0);

    public static void init() {
        Drivetrain.getInstance().setDefaultCommand(new DriveCommand(() -> driver.getLeftY() * 0.5, () -> driver.getLeftX() * 0.5));

        driver.b().onTrue(new InstantCommand(() -> Pneumatics.getInstance().toggleCompressor()));
        driver.leftBumper().onTrue(new InstantCommand(() -> Pneumatics.getInstance().toggleHead()));
        driver.rightBumper().onTrue(new InstantCommand(() -> Pneumatics.getInstance().toggleBeak()));
        Elevator.getInstance().setDefaultCommand(new ElevatorCommand(() -> driver.getRightY() * 0.5));
    }
}
