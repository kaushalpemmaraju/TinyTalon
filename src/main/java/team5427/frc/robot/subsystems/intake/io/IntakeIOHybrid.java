package team5427.frc.robot.subsystems.intake.io;

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

public class IntakeIOHybrid implements IntakeIO{
    private SteelTalonFX rollerMotor;
    private SimpleSparkMax pivotMotor;

    public IntakeIOHybrid(){
        rollerMotor = new SteelTalonFX(IntakeConstants.kRollerMotorCanId);
        pivotMotor = new SimpleSparkMax(IntakeConstants.kPivotMotorCanId);
    }

    public void updateInputs(IntakeIOInputs inputs){
        inputs.rollerMotorAngularVelocity = rollerMotor.getTalonFX().getVelocity().getValue();
        inputs.rollerMotorAngularAcceleration = rollerMotor.getTalonFX().getAcceleration().getValue();
        inputs.rollerMotorCurrent = rollerMotor.getTalonFX().getStatorCurrent().getValue();
        inputs.rollerMotorLinearVelocity = Units.MetersPerSecond.of(inputs.rollerMotorAngularVelocity.in(RotationsPerSecond)
        * IntakeConstants.kRollerMotorConfiguration.finalDiameterMeters
        * Math.PI);
        inputs.rollerMotorLinearAcceleration = Units.MetersPerSecondPerSecond.of(inputs.rollerMotorAngularAcceleration.magnitude());
        inputs.rollerMotorPosition = Rotation2d.fromRotations(rollerMotor.getEncoderPosition());


        inputs.pivotMotorAngularVelocity = RotationsPerSecond.of(pivotMotor.getEncoderVelocity()/60.0);
        inputs.pivotMotorPosition = Rotation2d.fromRotations(pivotMotor.getEncoderPosition());
        inputs.pivotMotorConnected = pivotMotor.isConnected();
    }

    public void setPivotRotation(Rotation2d rotation) {
        pivotMotor.setEncoderPosition(rotation);
    }

    public void setPivotRotation(Angle rotation) {
        pivotMotor.setEncoderPosition(rotation.magnitude());
    }

    public void setRollerSpeed(LinearVelocity velocity) {
        rollerMotor.setSetpoint(velocity);
    }

    public void setRollerSpeed(AngularVelocity velocity) {
        rollerMotor.setSetpoint(velocity);
    }

    public void disableRollerMotor(boolean shouldDisable) {
        if(shouldDisable){
            rollerMotor.getTalonFX().disable();
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

    public void setRollerMotorPosition(Rotation2d position) {
        rollerMotor.setEncoderPosition(position);
    }

}
