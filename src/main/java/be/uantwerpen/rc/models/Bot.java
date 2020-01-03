package be.uantwerpen.rc.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * Bot Data Class
 */
@Entity
@Table(name = "robots",catalog = "\"robotDB_new\"")
public class Bot
{
    @Id
    private Long idCore;

    private Long idStart;
    private Long idStop;
    private Long jobId;
    private Integer percentageCompleted;
    private String workingMode;
    private Boolean busy;
    private Long link;
    private Long point;
    private Long idLocation;
    private int status;
    private Date lastupdated;
    public Bot(Long coreId){
        this.idCore=coreId;
    }
    public Bot(){
        idCore=new Random().nextLong();
    }

    @Basic
    @Column(name = "\"idstart\"")
    public Long getIdStart()
    {
        return idStart;
    }

    public void setIdStart(Long idStart)
    {
        this.idStart = idStart;
    }

    @Basic
    @Column(name = "\"idstop\"")
    public Long getIdStop()
    {
        return idStop;
    }

    public void setIdStop(Long idStop)
    {
        this.idStop = idStop;
    }

    @Id
    @Column(name = "\"idcore\"")
    public Long getIdCore()
    {
        return idCore;
    }
    public void setIdCore(Long idCore)
    {
        this.idCore = idCore;
    }

    @Basic
    @Column(name = "\"jobid\"")
    public Long getJobId()
    {
        return jobId;
    }

    public void setJobId(Long jobId)
    {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "\"linkprogress\"")
    public Integer getPercentageCompleted()
    {
        return percentageCompleted;
    }

    public void setPercentageCompleted(Integer percentageCompleted)
    {
        this.percentageCompleted = percentageCompleted;
    }

    @Basic
    @Column(name = "\"busy\"")
    public Boolean getBusy() {return busy;}

    public void setBusy(Boolean busy) {this.busy = busy;}

    @Basic
    @Column(name = "\"workingmode\"")
    public String getWorkingMode()
    {
        return workingMode;
    }

    public void setWorkingMode(String state)
    {
        this.workingMode = state;
    }

    @Basic
    @Column(name="\"location\"")
    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Bot that = (Bot) o;

        if(!Objects.equals(idCore, that.idCore)) return false;
        if(jobId != null ? !jobId.equals(that.jobId) : that.jobId != null) return false;
        if(percentageCompleted != null ? !percentageCompleted.equals(that.percentageCompleted) : that.percentageCompleted != null)
            return false;
        //if(state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int)(idCore % Integer.MAX_VALUE);

        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        result = 31 * result + (percentageCompleted != null ? percentageCompleted.hashCode() : 0);
        //result = 31 * result + (state != null ? state.hashCode() : 0);

        return result;
    }

    public Long getPoint()
    {
        return point;
    }

    public void setPoint(Long point)
    {
        this.point = point;
    }

    public Long getLinkId()
    {
        return link;
    }

    public void setLinkId(Long link)
    {
        this.link = link;
    }

    public void updateStatus(int status){
        setLastUpdated(new Date());
        setStatus(status);

    }
    @Basic
    @Column(name = "\"status\"")
    public int getStatus(){
        return status;
    }

    public void setStatus(int status){
        this.status = status;
    }


    @Column(name = "\"lastupdated\"", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdated() {
        return lastupdated;
    }
    public void setLastUpdated(Date lastupdated) {
        this.lastupdated= lastupdated;
    }


}
