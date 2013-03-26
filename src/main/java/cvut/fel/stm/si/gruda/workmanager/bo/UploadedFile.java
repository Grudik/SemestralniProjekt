/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author GrudikNTB
 */
@Entity
public class UploadedFile extends AbstractBusinessObject {

    String name;
    String note;
    Byte[] file;
    @ManyToOne
    private Project project;
    @OneToOne
    private Ticket ticket;
    @OneToOne
    private WorkedHours workedHours;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public WorkedHours getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(WorkedHours workedHours) {
        this.workedHours = workedHours;
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

    public Byte[] getFile() {
        return file;
    }

    public void setFile(Byte[] file) {
        this.file = file;
    }
}
