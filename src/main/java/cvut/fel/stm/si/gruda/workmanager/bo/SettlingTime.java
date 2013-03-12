/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Grudik-stolni
 */
@Entity
public class SettlingTime extends AbstractBusinessObject {
    @OneToMany(mappedBy = "settlingTime")
    private List<OtherCosts> otherCosts;
    
    @Temporal(TemporalType.DATE)
    private Date settlingTime;
    
    @OneToMany(mappedBy = "settlingTime")
    private List<WorkedHours> workedHours;

    public List<OtherCosts> getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(List<OtherCosts> otherCosts) {
        this.otherCosts = otherCosts;
    }

    public List<WorkedHours> getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(List<WorkedHours> workedHours) {
        this.workedHours = workedHours;
    }

    public Date getSettlingTime() {
        return settlingTime;
    }

    public void setSettlingTime(Date settlingTime) {
        this.settlingTime = settlingTime;
    }
    
    
    
}
