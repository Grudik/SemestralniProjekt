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
public class TicketDto extends AbstractDto {

    private String name;
    private String note;
    private int averageTime;
    private List<Long> tickets;
    private List<Long> workedHours;
    private List<Long> workOnTickets;
    private Long parent;
    private Long project;
    private Long uploadedFile;

    public TicketDto(String name, String note, int averageTime, List<Long> tickets, List<Long> workedHours, List<Long> workOnTickets, Long parent, Long project, Long uploadedFile, Long id) {
        super(id);
        this.name = name;
        this.note = note;
        this.averageTime = averageTime;
        this.tickets = tickets;
        this.workedHours = workedHours;
        this.workOnTickets = workOnTickets;
        this.parent = parent;
        this.project = project;
        this.uploadedFile = uploadedFile;
    }

    public Long getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Long uploadedFile) {
        this.uploadedFile = uploadedFile;
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

    public int getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(int averageTime) {
        this.averageTime = averageTime;
    }

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }

    public List<Long> getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(List<Long> workedHours) {
        this.workedHours = workedHours;
    }

    public List<Long> getWorkOnTickets() {
        return workOnTickets;
    }

    public void setWorkOnTickets(List<Long> workOnTickets) {
        this.workOnTickets = workOnTickets;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }
}
