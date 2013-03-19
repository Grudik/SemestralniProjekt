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
public class CustomerDto extends AbstractDto {
    
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String note;
    
    private List<Long> projects;

    public CustomerDto() {
    }

    public CustomerDto(Long id, String name, String surname, String email, String phone, String note, List<Long> projects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.note = note;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Long> getProjects() {
        return projects;
    }

    public void setProjects(List<Long> projects) {
        this.projects = projects;
    }
    
}
