package team5427.frc.robot.commands.chassis;

import static edu.wpi.first.units.Units.Rotation;

import edu.wpi.first.math.controller.HolonomicDriveController;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import team5427.frc.robot.subsystems.Swerve.SwerveSubsystem;

public class AlignFromPolar extends Command {
    private SwerveSubsystem swerveSubsystem;
    private HolonomicDriveController driveController;
    private CommandXboxController joy;
    private static Pose2d targetPose;
    private boolean isRight;
    public AlignFromPolar(CommandXboxController driverJoystick, boolean isRight){
        this.swerveSubsystem = SwerveSubsystem.getInstance();
        driveController = new HolonomicDriveController(new PIDController(0, 0, 0), new PIDController(0)
        
    }

}
