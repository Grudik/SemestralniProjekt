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
    private int avegageTime;
    private List<Long> tickets;
    private List<Long> workedHours;
    private List<Long> workOnTickets;
    private Long parent;
    private Long project;

    public TicketDto() {
    }

    public TicketDto(Long id, String name, String note, int avegageTime, List<Long> tickets, List<Long> workedHours, List<Long> workOnTickets, Long parent, Long project) {
        this.id = id;
        this.name = name;
        this.note = note;
        this.avegageTime = avegageTime;
        this.tickets = tickets;
        this.workedHours = workedHours;
        this.workOnTickets = workOnTickets;
        this.parent = parent;
        this.project = project;
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
