/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Grudik-stolni
 */

@Entity
public class Ticket extends AbstractBusinessObject {
    @OneToOne(mappedBy = "ticket")
    private UploadedFile uploadedFile;
    
    private String name;
    private String note;
    private int avegageTime;

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    @OneToMany(mappedBy = "parent")
    private List<Ticket> tickets;
    
    @OneToMany(mappedBy = "ticket")
    private List<WorkedHours> workedHours;
    
    @OneToMany(mappedBy = "ticket")
    private List<WorkOnTicket> workOnTickets;
    
    @ManyToOne
    private Ticket parent;
    
    @ManyToOne
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<WorkOnTicket> getWorkOnTickets() {
        return workOnTickets;
    }

    public void setWorkOnTickets(List<WorkOnTicket> workOnTickets) {
        this.workOnTickets = workOnTickets;
    }

    public Ticket getParent() {
        return parent;
    }

    public void setParent(Ticket parent) {
        this.parent = parent;
    }

    public List<WorkOnTicket> getWorkOnTicket() {
        return workOnTickets;
    }

    public void setWorkOnTicket(List<WorkOnTicket> workOnTicket) {
        this.workOnTickets = workOnTicket;
    }
    

    public List<WorkedHours> getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(List<WorkedHours> workedHours) {
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

    public int getAvegageTime() {
        return avegageTime;
    }

    public void setAvegageTime(int avegageTime) {
        this.avegageTime = avegageTime;
    }
    
    
    
}
