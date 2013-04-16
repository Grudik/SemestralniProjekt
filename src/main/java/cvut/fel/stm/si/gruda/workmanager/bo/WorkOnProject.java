/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.bo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Grudik-stolni
 */

@Entity
public class WorkOnProject extends AbstractBusinessObject {
    
    private boolean ownerOfProject;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    

    public boolean isOwner() {
        return ownerOfProject;
    }

    public void setOwner(boolean owner) {
        this.ownerOfProject = owner;
    }
}
