package team5427.frc.robot.commands.targeting;

import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.MetersPerSecondPerSecond;

import org.opencv.core.Mat;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.Kinematics;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearAcceleration;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.wpilibj2.command.Command;
import team5427.frc.robot.subsystems.intake.ShooterSubsystem;
import team5427.frc.robot.subsystems.shooter.ShooterConstants;
import team5427.frc.robot.subsystems.vision.VisionSubsystem;

public class ShootToTarget extends Command{
    private ShooterSubsystem shooter;
    private VisionSubsystem vision;
    private Rotation2d shootingAngle;
    private Distance neededDistanceToReachTarget;
    

    public ShootToTarget(Rotation2d shootingAngle){
        shooter = ShooterSubsystem.getInstance();
        vision = VisionSubsystem.getInstance();
        this.shootingAngle = shootingAngle;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        LinearVelocity initialVerticalVelocity = ShooterConstants.kShooterInitialVelocity.times(Math.sin(shootingAngle.getRadians()));
        double v2 = Math.pow(initialVerticalVelocity.magnitude(), 2.0);
        Distance maxHeight = Meters.of(v2).div(ShooterConstants.kGravity.times(2.0).magnitude());
        neededDistanceToReachTarget = MetersPerSecond.of(v2).div(ShooterConstants.kGravity.times(2.0).magnitude());
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        super.execute();
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return super.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
    }
}
