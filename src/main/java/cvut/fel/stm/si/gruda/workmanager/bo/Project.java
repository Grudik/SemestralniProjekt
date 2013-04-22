/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Grudik-stolni
 */
@Entity
public class Project extends AbstractBusinessObject {

    private String name;
    private String note;
    @OneToMany(mappedBy = "project",cascade= CascadeType.REMOVE)
    private List<UploadedFile> uploadedFiles;
    @OneToMany(mappedBy = "project",cascade= CascadeType.REMOVE)
    private List<Ticket> tickets;
    @OneToMany(mappedBy = "project",cascade= CascadeType.REMOVE)
    private List<WorkOnProject> workOnProjects;
    @OneToMany(mappedBy = "project",cascade= CascadeType.REMOVE)
    private List<OtherCosts> otherCosts;
    @ManyToOne
    private Customer customer;

    public List<UploadedFile> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<WorkOnProject> getWorkOnProjects() {
        return workOnProjects;
    }

    public void setWorkOnProjects(List<WorkOnProject> workOnProjects) {
        this.workOnProjects = workOnProjects;
    }

    public List<OtherCosts> getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(List<OtherCosts> otherCosts) {
        this.otherCosts = otherCosts;
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
