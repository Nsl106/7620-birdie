package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

    @Override
    public void robotInit() {
        Controls.init();
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }


    public static void main(String... args) {
        RobotBase.startRobot(Robot::new);
    }

}
