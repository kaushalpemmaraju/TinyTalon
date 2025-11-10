package team5427.frc.robot.subsystems.Shooter;

import static edu.wpi.first.units.Units.MetersPerSecond;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team5427.frc.robot.Constants;
import team5427.frc.robot.subsystems.Shooter.io.ShooterIO;
import team5427.frc.robot.subsystems.Shooter.io.ShooterIOTalonFX;
import team5427.frc.robot.subsystems.Shooter.io.ShooterIO.ShooterIOInputs;
import team5427.lib.drivers.ComplexGearRatio;
import team5427.lib.motors.SteelTalonFX;

public class ShooterSubsystem extends SubsystemBase{
    private LinearVelocity shootingSpeed;
    private Rotation2d pivotAngle;
    private Rotation2d rotAngle;
    private boolean projectileReleased;
    private ShooterIO io;
    private ShooterIOInputsAutoLogged inputsAutoLogged;
    public static ShooterSubsystem shooter_instance;

    public ShooterSubsystem(){
        inputsAutoLogged = new ShooterIOInputsAutoLogged();
        switch(Constants.currentMode){
            case REAL:
                io = new ShooterIOTalonFX();
                break;
            case SIM:
                break;
            default:
                break;
        
        }
        shootingSpeed = MetersPerSecond.of(0.0);
        pivotAngle = Rotation2d.kZero;
        rotAngle = Rotation2d.kZero;
        projectileReleased = false;
    }
    

    @Override
    public void periodic(){
        io.updateInputs(inputsAutoLogged);
        io.setPivotMotorRotation(pivotAngle);
        io.setRotationalMotorRotation(rotAngle);
        io.setShooterMotorVelocity(shootingSpeed);
        Logger.processInputs("Intake/Inputs", inputsAutoLogged);
        
    }

    
}
