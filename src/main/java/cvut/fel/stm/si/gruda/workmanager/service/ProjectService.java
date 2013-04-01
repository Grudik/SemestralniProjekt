/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.ProjectDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface ProjectService {
    
    public Long addProject(String name, String note, Long customer);
    public boolean removeProject(Long projectId);
    
    @Transactional(readOnly=true)
    public ProjectDto getProject(Long projectId);
    @Transactional(readOnly=true)
    public List<ProjectDto> getAllProjects();
    @Transactional(readOnly=true)
    public List<ProjectDto> getAllProjectsByCustomerId(Long customerId);
    
}
