/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.dto;

import java.util.List;

/**
 *
 * @author GrudikNTB
 */
public class ProjectDto extends AbstractDto{
    private String name;
    private String note;
    
    private Long customer;
    
    private List<Long> uploadedFiles;
    private List<Long> tickets;
    private List<Long> workOnProjects;
    private List<Long> otherCosts;

    public ProjectDto() {
    }

    public ProjectDto(String name, String note, Long customer, List<Long> uploadedFiles, List<Long> tickets, List<Long> workOnProjects, List<Long> otherCosts, Long id) {
        super(id);
        this.name = name;
        this.note = note;
        this.customer = customer;
        this.uploadedFiles = uploadedFiles;
        this.tickets = tickets;
        this.workOnProjects = workOnProjects;
        this.otherCosts = otherCosts;
    }

    public List<Long> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setUploadedFiles(List<Long> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
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

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }

    public List<Long> getWorkOnProjects() {
        return workOnProjects;
    }

    public void setWorkOnProjects(List<Long> workOnProjects) {
        this.workOnProjects = workOnProjects;
    }

    public List<Long> getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(List<Long> otherCosts) {
        this.otherCosts = otherCosts;
    }
      
}
