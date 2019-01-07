package be.uantwerpen.rc.models;

import javax.persistence.*;

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

    public Job()
    {
        this.jobId = 0L;
    }

    /**
     * Create Job with defined ID
     * @param jobId
     */
    public Job(Long jobId)
    {
        this.jobId = jobId;
    }

    public Job(Long jobId, Long idStart, Long idEnd) {
        this.jobId = jobId;
        this.idStart = idStart;
        this.idEnd = idEnd;
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
}
