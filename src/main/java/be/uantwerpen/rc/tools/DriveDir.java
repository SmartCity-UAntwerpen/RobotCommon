package be.uantwerpen.rc.tools;

import javax.persistence.*;

/**
 * Created by Arthur on 28/04/2016.
 *
 * @Author Riad on 17/12/2019
 */
//@Embeddable
@Entity
@Table(name="drivedirs", catalog = "\"robotDB_new\"")
public class DriveDir{

    @Id
    private Long driveId;

    @Enumerated(EnumType.STRING)
    private DriveDirEnum dir;

    private double angle;
    private String command;

    public DriveDir()
    {
        this.driveId = 0L;
        this.dir = DriveDirEnum.NONE;
        this.angle = 0.0;
        this.command = "MISSING";

    }

    public DriveDir(DriveDirEnum dir)
    {
        this.driveId = 0L;
        this.angle = 0.0;
        this.dir = dir;
        this.command = "MISSING";
    }

    public DriveDir(DriveDirEnum dir, double angle)
    {
        this.driveId = 0L;
        this.dir = dir;
        this.angle = angle;
        this.command = "MISSING";
    }

    public DriveDir(String command)
    {
        this.driveId = 0L;
        this.dir = DriveDirEnum.NONE;
        this.command = command;
        this.angle = 0.0;
    }

    public DriveDir(String command, double angle)
    {
        this.driveId = 0L;
        this.dir = DriveDirEnum.NONE;
        this.angle = angle;
        this.command = command;
    }

    public DriveDir(DriveDirEnum dir, double angle, String command)
    {
        this.driveId = 0L;
        this.dir = dir;
        this.angle = angle;
        this.command = command;
    }

    public DriveDirEnum getDir() {
        return dir;
    }

    @Override
    public String toString(){
        switch(dir){
            case FORWARD:
                return "DRIVE FORWARD 120";
            case LEFT:
                return "DRIVE TURN L " + this.angle;
            case RIGHT:
                return "DRIVE TURN R " + this.angle;
            case FOLLOW:
                return "DRIVE FOLLOWLINE";
            case TURN:
                return "DRIVE ROTATE R 180 ";
            case LONGDRIVE:
                return "DRIVE FORWARD 150";
            case NONE:
                return this.command;
            default:
                return this.command;
        }
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setDir(DriveDirEnum dir) {
        this.dir = dir;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Long getDriveId() {
        return driveId;
    }

    public void setDriveId(Long driveId) {
        this.driveId = driveId;
    }
}
