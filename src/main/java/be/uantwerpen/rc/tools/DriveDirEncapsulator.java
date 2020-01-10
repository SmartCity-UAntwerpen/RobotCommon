package be.uantwerpen.rc.tools;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class DriveDirEncapsulator {
    @OneToMany
    private List<DriveDir> driveDirs;

    public DriveDirEncapsulator()
    {
        driveDirs=new ArrayList<>();
    }

    public DriveDirEncapsulator(List<DriveDir>driveDirs)
    {
        this.driveDirs=driveDirs;
    }

    public void addDriveDir(DriveDir driveDir)
    {
        driveDirs.add(driveDir);
    }

    public List<DriveDir> getDriveDirs()
    {
        return driveDirs;
    }
}
