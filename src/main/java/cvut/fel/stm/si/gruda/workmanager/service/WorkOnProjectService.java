/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.WorkOnProjectDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface WorkOnProjectService {
    
    public Long addWorkOnProject(boolean owner, Long user, Long project);
    public boolean deleteWorkOnProject(Long workOnProjectId);
    
    @Transactional(readOnly = true)
    public WorkOnProjectDto getWorkOnProject(Long workOnProjectId);
    @Transactional(readOnly = true)
    public List<WorkOnProjectDto> getAllWorkOnProjects();
    @Transactional(readOnly = true)
    public List<WorkOnProjectDto> getAllWorkOnProjectsByProjectId(Long projectId);
    @Transactional(readOnly = true)
    public List<WorkOnProjectDto> getAllWorkOnProjectsByUserId(Long userId);
    
}
