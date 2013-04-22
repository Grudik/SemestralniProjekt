/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.Project;
import cvut.fel.stm.si.gruda.workmanager.bo.User;
import cvut.fel.stm.si.gruda.workmanager.bo.WorkOnProject;
import cvut.fel.stm.si.gruda.workmanager.dto.WorkOnProjectDto;
import cvut.fel.stm.si.gruda.workmanager.service.WorkOnProjectService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class WorkOnProjectServiceImp extends AbstractDataAccessServiceImp implements WorkOnProjectService{

    @Override
    public Long addWorkOnProject(boolean owner, Long user, Long project) {
        
        WorkOnProject wop = new WorkOnProject();
        wop.setOwner(owner);
        if (user != null) {
            wop.setUser(genericDao.getById(user, User.class));
        }
        if (project != null) {
            wop.setProject(genericDao.getById(project, Project.class));
        }

        return genericDao.saveOrUpdate(wop).getId();
        
    }

    @Override
    public boolean deleteWorkOnProject(Long workOnProjectId) {
        genericDao.removeById(workOnProjectId, WorkOnProject.class);
        return true;
    }

    @Override
    public WorkOnProjectDto getWorkOnProject(Long workOnProjectId) {
        
        return transformEntityToDto(genericDao.getById(workOnProjectId, WorkOnProject.class));
        
    }

    @Override
    public List<WorkOnProjectDto> getAllWorkOnProjects() {
        
        List<WorkOnProject> wops = genericDao.getAll(WorkOnProject.class);
        List<WorkOnProjectDto> wopDtos = new ArrayList<WorkOnProjectDto>();
        
        for(WorkOnProject wop : wops) {
            wopDtos.add(transformEntityToDto(wop));
        }
        return wopDtos;
    }

    @Override
    public List<WorkOnProjectDto> getAllWorkOnProjectsByProjectId(Long projectId) {
        
        List<WorkOnProject> wops = genericDao.getAll(WorkOnProject.class);
        List<WorkOnProjectDto> wopDtos = new ArrayList<WorkOnProjectDto>();
        
        for(WorkOnProject wop : wops) {
            if(wop.getProject().getId() == projectId) {
                wopDtos.add(transformEntityToDto(wop));
            }
        }
        return wopDtos;
    }

    @Override
    public List<WorkOnProjectDto> getAllWorkOnProjectsByUserId(Long userId) {
        
        List<WorkOnProject> wops = genericDao.getAll(WorkOnProject.class);
        List<WorkOnProjectDto> wopDtos = new ArrayList<WorkOnProjectDto>();
        
        for(WorkOnProject wop : wops) {
            if(wop.getUser().getId() == userId) {
                wopDtos.add(transformEntityToDto(wop));
            }
        }
        return wopDtos;
    }
    private WorkOnProjectDto transformEntityToDto(WorkOnProject wop) {
        
        WorkOnProjectDto wopDto = new WorkOnProjectDto();
        
        wopDto.setId(wop.getId());
        wopDto.setOwnerOfProject(wop.isOwner());
        if (wop.getProject() != null) {
            wopDto.setProject(wop.getProject().getId());
        }
        if (wop.getUser() != null) {
            wopDto.setUser(wop.getUser().getId());
        }
        
        return wopDto;
    }
}
