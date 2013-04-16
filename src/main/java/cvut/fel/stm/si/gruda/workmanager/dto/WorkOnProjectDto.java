/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.dto;

/**
 *
 * @author GrudikNTB
 */
public class WorkOnProjectDto extends AbstractDto {

    private boolean ownerOfProject;
    private Long user;
    private Long project;

    public WorkOnProjectDto(Long id, boolean owner, Long user, Long project) {
        this.id = id;
        this.ownerOfProject = owner;
        this.user = user;
        this.project = project;
    }

    public WorkOnProjectDto() {
  
    }

    public boolean isOwnerOfProject() {
        return ownerOfProject;
    }

    public void setOwnerOfProject(boolean ownerOfProject) {
        this.ownerOfProject = ownerOfProject;
    }


    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }
    
    
}
