/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.dto;

import java.util.Date;

/**
 *
 * @author GrudikNTB
 */
public class WorkedHoursDto extends AbstractDto{
     private Date startTime;
     private Date endTime;
     private String note;
     
    private Long user;
    private Long ticket;
    private Long settlingTime;

    public WorkedHoursDto(Long id, Date startTime, Date endTime, String note, Long user, Long ticket, Long settlingTime) {
        super(id);
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
        this.user = user;
        this.ticket = ticket;
        this.settlingTime = settlingTime;
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getTicket() {
        return ticket;
    }

    public void setTicket(Long ticket) {
        this.ticket = ticket;
    }

    public Long getSettlingTime() {
        return settlingTime;
    }

    public void setSettlingTime(Long settlingTime) {
        this.settlingTime = settlingTime;
    }
}
