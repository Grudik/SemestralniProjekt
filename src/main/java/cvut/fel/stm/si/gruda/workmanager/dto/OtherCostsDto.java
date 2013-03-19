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
public class OtherCostsDto extends AbstractDto {
    
    private Date time;
    private int value;
    private String name;
    private String note;
    
    private Long user;
    private Long settlingTime;
    private Long project;

    public OtherCostsDto() {
    }

    public OtherCostsDto(Long id, Date time, int value, String name, String note, Long user, Long settlingTime, Long project) {
        this.id = id;
        this.time = time;
        this.value = value;
        this.name = name;
        this.note = note;
        this.user = user;
        this.settlingTime = settlingTime;
        this.project = project;
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getSettlingTime() {
        return settlingTime;
    }

    public void setSettlingTime(Long settlingTime) {
        this.settlingTime = settlingTime;
    }

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }
    
}
