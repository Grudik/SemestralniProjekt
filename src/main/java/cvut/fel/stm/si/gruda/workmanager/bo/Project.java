/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Grudik-stolni
 */
@Entity
public class Project extends AbstractBusinessObject  {
    
    @OneToMany(mappedBy = "project")
    private List<Ticket> tickets;
    
    @OneToMany(mappedBy = "project")
    private List<WorkOnProject> workOnProjects;
    
    @OneToMany(mappedBy = "project")
    private List<OtherCosts> otherCosts;
    
    private String name;
    private String note;
    
    @ManyToOne
    private Customer customer;

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
