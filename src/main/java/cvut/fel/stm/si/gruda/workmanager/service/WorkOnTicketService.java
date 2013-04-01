/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.WorkOnTicketDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface WorkOnTicketService {
    
    public Long addWorkOnTicket(boolean ownerOfTicket, Long user, Long ticket);
    public boolean deleteWorkOnTicket(Long workOnTicketId);
    
    @Transactional(readOnly = true)
    public WorkOnTicketDto getWorkOnTicket(Long workOnTicketId);
    @Transactional(readOnly = true)
    public List<WorkOnTicketDto> getAllWorkOnTickets();
    @Transactional(readOnly = true)
    public List<WorkOnTicketDto> getAllWorkOnTicketByProjectId(Long projectId);
    @Transactional(readOnly = true)
    public List<WorkOnTicketDto> getAllWorkOnTicketByUserId(Long userId);
    
}
