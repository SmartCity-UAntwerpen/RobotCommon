package be.uantwerpen.rc.models;

import be.uantwerpen.rc.tools.DriveDir;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Job Data Class
 */
@Entity
@Table(name = "jobs", catalog = "\"robotDB_new\"")
public class Job
{
    /**
     * ID of Job
     */
    @Id
    private Long jobId;

    /**
     * Start ID of Point(?)
     */
    private Long idStart;

    /**
     * End ID of Point(?)
     */
    private Long idEnd;

    /**
     * ID of Vehicle
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="botId")
    private Bot bot;

    //@Transient
    //@ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.PERSIST)
    //@CollectionTable(name="drivedirections", joinColumns = @JoinColumn(name="id"))
    /*@AttributeOverrides({
            @AttributeOverride(name="dir", column=@Column(name="direction")),
            @AttributeOverride(name="angle", column = @Column(name="directionAngle")),
            @AttributeOverride(name="command", column = @Column(name="directionCommand"))
    })*/
    //@OneToMany(fetch = FetchType.EAGER)
    /*@JoinTable(
            name="drivedirections",
            joinColumns={
                    @JoinColumn(name="driveId", referencedColumnName="id")},
            inverseJoinColumns={
                    @JoinColumn(name="jobId", referencedColumnName="id")})*/
/*    @OneToMany(fetch = FetchType.LAZY)*/
    @JoinColumn(name="driveId")
    private List<DriveDir> driveDirections = new LinkedList<>();

    public Job()
    {
        this.jobId = 0L;
        this.driveDirections = new LinkedList<>();
    }

    /**
     * Create Job with defined ID
     * @param jobId
     */
    public Job(Long jobId)
    {
        this.jobId = jobId;
        this.driveDirections = new LinkedList<>();
    }

    public Job(Long jobId, Long idStart, Long idEnd)
    {
        this.jobId = jobId;
        this.idStart = idStart;
        this.idEnd = idEnd;
        this.driveDirections = new LinkedList<>();
    }

    /**
     * Get Job ID
     * @return ID of Job
     */
    public Long getJobId()
    {
        return jobId;
    }

    /**
     * Set Job ID
     * @param jobId ID of Job
     */
    public void setJobId(Long jobId)
    {
        this.jobId = jobId;
    }

    /**
     * Get Start Point ID
     * @return Start Point ID
     */
    public Long getIdStart()
    {
        return idStart;
    }

    /**
     * Set Start Point ID
     * @param idStart Start Point ID
     */
    public void setIdStart(Long idStart)
    {
        this.idStart = idStart;
    }

    /**
     * Get End Point ID
     * @return End Point ID
     */
    public Long getIdEnd()
    {
        return idEnd;
    }

    /**
     * Set End Point ID
     * @param idEnd End Point ID
     */
    public void setIdEnd(Long idEnd)
    {
        this.idEnd = idEnd;
    }


    @Override
    public String toString()
    {
        return "Job{" +
                "jobId=" + jobId +
                '}';
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }



    public List<DriveDir> getDriveDirections() {
        return driveDirections;
    }

    public void setDriveDirections(List<DriveDir> driveDirections) {
        this.driveDirections = driveDirections;
    }
}
