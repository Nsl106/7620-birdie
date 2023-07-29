package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
    private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    private final DoubleSolenoid head = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 5, 6);
    private final DoubleSolenoid beak = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 7);

    private Pneumatics() {
        compressor.disable();
    }

    public void toggleBeak() {
        beak.toggle();
    }

    public void toggleHead() {
        head.toggle();
    }

    public void toggleCompressor() {
        if (compressor.isEnabled()) {
            compressor.disable();
        } else {
            compressor.enableDigital();
        }
    }


    private static Pneumatics instance;

    public static Pneumatics getInstance() {
        if (instance == null) {
            instance = new Pneumatics();
        }
        return instance;
    }
}
