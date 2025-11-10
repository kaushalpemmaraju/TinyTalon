package team5427.frc.robot.commands.targeting;

import static edu.wpi.first.units.Units.Meters;

import org.apache.commons.math3.geometry.euclidean.threed.Rotation;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.Command;
import team5427.frc.robot.subsystems.Swerve.SwerveSubsystem;
import team5427.frc.robot.subsystems.intake.ShooterSubsystem;
import team5427.frc.robot.subsystems.vision.VisionSubsystem;
import team5427.frc.robot.FieldConstants;
import team5427.frc.robot.Constants.RobotConstants;

public class SetShooterTarget extends Command{
    private ShooterSubsystem shooter;
    private VisionSubsystem vision;
    private Rotation2d shootingAngle;
    private Rotation2d finalShootingAngle;

    public SetShooterTarget(Rotation2d shootingAngle){
        shooter = ShooterSubsystem.getInstance();
        vision = VisionSubsystem.getInstance();
        this.shootingAngle = shootingAngle;
        addRequirements(shooter);
    }

    @Override
    public void initialize() {
        Rotation2d limelightAngle = vision.getTargetX(0);
        Distance robotXDistanceFromTarget = FieldConstants.bargeHeight.minus(RobotConstants.limelightHeight).div(Math.tan(shootingAngle.getRadians()));
        finalShootingAngle = Rotation2d.fromRadians(Math.atan((FieldConstants.bargeHeight.minus(RobotConstants.shooterHeight)).in(Meters)/ (robotXDistanceFromTarget).in(Meters)));
    }

    @Override
    public void execute() {
        shooter.setAngle(finalShootingAngle);
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
