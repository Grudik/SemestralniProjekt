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
public class UserDto extends AbstractDto{
    private String name;
    private String surname;
    private String login;
    private String email;
    private String password;
    private String phone;
    
    private List<Long> otherCosts;
    private List<Long> workOnProjects;
    private List<Long> workOtTickets;
    private List<Long> workedHours;
    
    public UserDto() {};

    public UserDto(Long id, String name, String surname, String login, String email, String password, String phone, List<Long> otherCosts, List<Long> workOnProjects, List<Long> workOtTickets, List<Long> workedHours) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.otherCosts = otherCosts;
        this.workOnProjects = workOnProjects;
        this.workOtTickets = workOtTickets;
        this.workedHours = workedHours;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Long> getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(List<Long> otherCosts) {
        this.otherCosts = otherCosts;
    }

    public List<Long> getWorkOnProjects() {
        return workOnProjects;
    }

    public void setWorkOnProjects(List<Long> workOnProjects) {
        this.workOnProjects = workOnProjects;
    }

    public List<Long> getWorkOtTickets() {
        return workOtTickets;
    }

    public void setWorkOtTickets(List<Long> workOtTickets) {
        this.workOtTickets = workOtTickets;
    }

    public List<Long> getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(List<Long> workedHours) {
        this.workedHours = workedHours;
    }

}
