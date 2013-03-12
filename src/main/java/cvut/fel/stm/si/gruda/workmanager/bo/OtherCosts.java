/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Grudik-stolni
 */
@Entity
public class OtherCosts extends AbstractBusinessObject {

    
    @Temporal(TemporalType.DATE)
    private Date time;
    private int value;
    private String name;
    private String note;

    @ManyToOne
    private User user;
    
    @ManyToOne
    private SettlingTime settlingTime;
    
    @ManyToOne
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    
}
