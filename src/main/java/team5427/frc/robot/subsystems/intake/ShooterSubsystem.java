package team5427.frc.robot.subsystems.intake;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    public static ShooterSubsystem m_instance;
    private Rotation2d angle;
    
    public static ShooterSubsystem getInstance(){
        if(m_instance==null){
            m_instance = new ShooterSubsystem();
        }
        return m_instance;
    }
    public void setAngle(Rotation2d angle) {
        this.angle = angle;
    }

    
    
    @Override
    public void periodic(){

    }
}
