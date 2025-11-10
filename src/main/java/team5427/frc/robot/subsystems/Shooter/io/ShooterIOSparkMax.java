package team5427.frc.robot.subsystems.Shooter.io;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkMaxAlternateEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Temperature;
import edu.wpi.first.units.measure.Voltage;
import team5427.frc.robot.subsystems.Shooter.ShooterConstants;
public class ShooterIOSparkMax implements ShooterIO{
    private SparkMax shooterMotorB;
    private SparkMax shooterMotorT;
    private SparkMax pivotMotor;
    private SparkAbsoluteEncoder pivotMotorEncoder;
    private Rotation2d shooterMotorBpos;
    private Rotation2d shooterMotorTpos;
    private Rotation2d pivotMotorpos;
    private Voltage shooterMotorVoltage;
    private Voltage pivotMotorVoltage;
    private AngularVelocity shooterMotorVelocity;
    private AngularVelocity pivotMotorVelocity;
    private Current shooterMotorCurrentB;
    private Current shooterMotorCurrentT;
    private Current pivotMotorCurrent;
    private Temperature shooterMotorBTemp;
    private Temperature shooterMotorTTemp;
    private Temperature pivotMotorTemperature;
    private AngularAcceleration shooterMotorBAcceleration;
    private AngularAcceleration shooterMototTAcceleration;
    private AngularAcceleration pivotMotorAcceleration;
    public boolean isIntakedProjectile = false;
    public ShooterIOSparkMax(){
        shooterMotorB  = new SparkMax(0, MotorType.kBrushless);
        shooterMotorT = new SparkMax(0, MotorType.kBrushless);
        pivotMotor = new SparkMax(0, MotorType.kBrushless);
        



    }

    
    
}
