/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import cvut.fel.stm.si.gruda.workmanager.provider.HashProvider;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Grudik-stolni
 */
@Entity
public class User extends AbstractBusinessObject {
    
    private String name;
    private String surname;
    private String login;
    private String email;
    private String phone;
    
    @Autowired
    private transient HashProvider hashProvider;
    @Column(length = 40, nullable = false)
    private String salt;
    @Column(length=40, nullable = false)
    private String password; 
    
    @OneToMany(mappedBy = "user")
    private List<OtherCosts> otherCosts;
    @OneToMany(mappedBy = "user")
    private List<WorkOnProject> workOnProjects;    
    @OneToMany(mappedBy = "user")
    private List<WorkOnTicket> workOtTickets;    
    @OneToMany(mappedBy = "user")
    private List<WorkedHours> workedHours;
    
    
    public HashProvider getHashProvider() {
        return hashProvider;
    }

    public void setHashProvider(HashProvider hashProvider) {
        this.hashProvider = hashProvider;
    }

    public List<OtherCosts> getOtherCosts() {
        return otherCosts;
    }

    public void setOtherCosts(List<OtherCosts> otherCosts) {
        this.otherCosts = otherCosts;
    }

    public List<WorkOnProject> getWorkOnProjects() {
        return workOnProjects;
    }

    public void setWorkOnProjects(List<WorkOnProject> workOnProjects) {
        this.workOnProjects = workOnProjects;
    }

    public List<WorkOnTicket> getWorkOtTickets() {
        return workOtTickets;
    }

    public void setWorkOtTickets(List<WorkOnTicket> workOtTickets) {
        this.workOtTickets = workOtTickets;
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
        this.salt = hashProvider.computeHash(System.nanoTime() + "");
        this.password = hashProvider.computeHash(password + salt);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public boolean hasPassword(String password){
        if(hashProvider.computeHash(password + salt).equals(this.password)){
            return true;
        }
        return false;
    }
    
}
