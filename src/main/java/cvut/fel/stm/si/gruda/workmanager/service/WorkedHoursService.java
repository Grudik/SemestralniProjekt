/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.WorkedHoursDto;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface WorkedHoursService {
    
    public Long addWorkedHours(Date startTime, Date endTime, String note, Long user, Long ticket, Long settlingTime, Long uploadedFile);
    public boolean deleteWorkedHours(Long workedHoursId);
    
    @Transactional(readOnly = true)
    public WorkedHoursDto getWorkedHours(Long id);
    @Transactional(readOnly = true)
    public List<WorkedHoursDto> getAllWorkedHours();
    @Transactional(readOnly = true)
    public List<WorkedHoursDto> getAllWorkedHoursByUser(Long userId);
    @Transactional(readOnly = true)
    public List<WorkedHoursDto> getAllWorkedHoursByProject(Long projectId);
    @Transactional(readOnly = true)
    public List<WorkedHoursDto> getAllWorkedHoursByUserAndProject(Long userId, Long projectId);
    
}
