/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Grudik-stolni
 */
public class WorkedHours {
    
    @Temporal(TemporalType.DATE)
    private Date startTime;
    
    @Temporal(TemporalType.DATE)
    private Date endTime;
    
    private String note;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Ticket ticket;
    
    @ManyToOne
    private SettlingTime settlingTime;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public SettlingTime getSettlingTime() {
        return settlingTime;
    }

    public void setSettlingTime(SettlingTime settlingTime) {
        this.settlingTime = settlingTime;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    


    
    
}
