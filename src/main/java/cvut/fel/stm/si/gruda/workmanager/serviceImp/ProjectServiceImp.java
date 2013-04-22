/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.Customer;
import cvut.fel.stm.si.gruda.workmanager.bo.Project;
import cvut.fel.stm.si.gruda.workmanager.dto.ProjectDto;
import cvut.fel.stm.si.gruda.workmanager.helper.DtoTransformerHelper;
import cvut.fel.stm.si.gruda.workmanager.service.ProjectService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class ProjectServiceImp extends AbstractDataAccessServiceImp implements ProjectService {

    @Override
    public Long addProject(String name, String note, Long customer) {
        
        Project p = new Project();
        
        if (customer != null) {
            p.setCustomer(genericDao.getById(customer, Customer.class));
        } 
        
        p.setName(name);
        p.setNote(note);
        
        return genericDao.saveOrUpdate(p).getId();
    }

    @Override
    public boolean removeProject(Long projectId) {
        
        genericDao.removeById(projectId, Project.class);
        return true;
        
    }

    @Override
    public ProjectDto getProject(Long projectId) {
        
        Project p = genericDao.getById(projectId, Project.class);
        return transformEntityToDto(p);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        
        List<Project> projects = genericDao.getAll(Project.class);
        List<ProjectDto> psDto = new ArrayList<ProjectDto>();
        
        for(Project p : projects) {
            psDto.add(transformEntityToDto(p));
        }
        return psDto;
        
    }

    @Override
    public List<ProjectDto> getAllProjectsByCustomerId(Long customerId) {
        List<Project> projects = genericDao.getAll(Project.class);
        List<ProjectDto> psDto = new ArrayList<ProjectDto>();
        
        for(Project p : projects) {
            if(p.getCustomer().getId() == customerId) {
                psDto.add(transformEntityToDto(p));
            }
        }
        return psDto;
    }
    
    private ProjectDto transformEntityToDto(Project p) {
        
        ProjectDto pDto = new ProjectDto();
        
        if (p.getCustomer() != null) {
            pDto.setCustomer(p.getCustomer().getId());
        }
        pDto.setId(p.getId());
        pDto.setName(p.getName());
        pDto.setNote(p.getNote());
        pDto.setOtherCosts(DtoTransformerHelper.getIdentifiers(p.getOtherCosts()));
        pDto.setTickets(DtoTransformerHelper.getIdentifiers(p.getTickets()));
        pDto.setUploadedFiles(DtoTransformerHelper.getIdentifiers(p.getUploadedFiles()));
        pDto.setWorkOnProjects(DtoTransformerHelper.getIdentifiers(p.getWorkOnProjects()));
        
        return pDto;
      
    }
}
