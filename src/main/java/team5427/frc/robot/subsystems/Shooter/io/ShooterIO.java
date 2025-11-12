package team5427.frc.robot.subsystems.Shooter.io;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Celsius;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;
import static edu.wpi.first.units.Units.Rotation;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecondPerSecond;
import static edu.wpi.first.units.Units.Volts;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.LinearAcceleration;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;

public interface ShooterIO {
    @AutoLog
    public static class ShooterIOInputs {
        public Rotation2d kPivotMotorPosition = new Rotation2d(0.0);
        

        public AngularVelocity kPivotMotorVelocity = RotationsPerSecond.of(0.0);
        public LinearVelocity kShooterMotorVelocity = MetersPerSecond.of(0.0);
        public AngularVelocity kShooterMotorAngularVelocity = RotationsPerSecond.of(0.0);







        public boolean pivotMotorConnected = false;
        public boolean shooterMotorConnected = false;




        
    
        
    }

    public default void updateInputs(ShooterIOInputs inputs){

    }

    public default void setPivotMotorRotation(Rotation2d rotation){

    }

    

    
    public default void setShooterMotorVelocity(LinearVelocity velocity){

    }
    public default void isIntakedProjectile(){

    }
    public default void resetPivotEncoderPosition(Rotation2d resetAngle){

    }
    

    
    
}