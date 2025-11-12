package team5427.frc.robot.subsystems.Shooter.io;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecondPerSecond;

import com.ctre.phoenix6.StatusSignal;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.Units;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import team5427.frc.robot.subsystems.intake.IntakeConstants;
import team5427.lib.motors.SimpleSparkMax;
import team5427.lib.motors.SteelTalonFX;

public class ShooterIOSparkMax implements ShooterIO{
    private SimpleSparkMax shooterMotor;
    private SimpleSparkMax pivotMotor;

    public ShooterIOSparkMax(){
        shooterMotor = new SimpleSparkMax(IntakeConstants.kRollerMotorCanId);
        pivotMotor = new SimpleSparkMax(IntakeConstants.kPivotMotorCanId);
    }

    public void updateInputs(ShooterIOInputs inputs){
        inputs.kPivotMotorVelocity = RotationsPerSecond.of(pivotMotor.getEncoderVelocity());
        inputs.kPivotMotorPosition = Rotation2d.fromRotations(pivotMotor.getEncoderPosition());
        inputs.pivotMotorConnected = pivotMotor.isConnected();
        inputs.kShooterMotorAngularVelocity = RotationsPerSecond.of(pivotMotor.getEncoderVelocity());
        inputs.kShooterMotorVelocity = MetersPerSecond.of(shooterMotor.getEncoderVelocity());
        inputs.shooterMotorConnected = shooterMotor.isConnected();
        
    
    
    }

    public void setPivotRotation(Rotation2d rotation) {
        pivotMotor.setEncoderPosition(rotation);
    }

    public void setPivotRotation(Angle rotation) {
        pivotMotor.setEncoderPosition(rotation.magnitude());
    }

    public void setShooterSpeed(LinearVelocity velocity) {
        shooterMotor.setSetpoint(velocity);
    }

    public void setShooterMotorVelocity(AngularVelocity velocity) {
        shooterMotor.setSetpoint(velocity);
    }

    public void disableShooterMotor(boolean shouldDisable) {
        if(shouldDisable){
            shooterMotor.getSparkMax().disable();
        }
    }

    public void disablePivotMotor(boolean shouldDisable) {
        if(shouldDisable){
            pivotMotor.getSparkMax().disable();
        }
    }

    public void setPivotMotorPosition(Rotation2d position) {
        pivotMotor.setEncoderPosition(position);
    }

    public void setShooterMotorPosition(Rotation2d position) {
        shooterMotor.setEncoderPosition(position);
    }

}
