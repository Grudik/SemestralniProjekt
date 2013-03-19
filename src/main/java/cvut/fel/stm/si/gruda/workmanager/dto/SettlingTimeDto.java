/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author GrudikNTB
 */
public class SettlingTimeDto extends AbstractDto {
    
    private List<Long> otherCosts;
    private Date settlingTime;
    private List<Long> workedHours;

    public SettlingTimeDto() {
    }

    public SettlingTimeDto(Long id, List<Long> otherCosts, Date settlingTime, List<Long> workedHours) {
        this.id = id;
        this.otherCosts = otherCosts;
        this.settlingTime = settlingTime;
        this.workedHours = workedHours;
    }

    public List<Long> getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(List<Long> otherCosts) {
        this.otherCosts = otherCosts;
    }

    public Date getSettlingTime() {
        return settlingTime;
    }

    public void setSettlingTime(Date settlingTime) {
        this.settlingTime = settlingTime;
    }

    public List<Long> getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(List<Long> workedHours) {
        this.workedHours = workedHours;
    }
    
}
