/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.TicketDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface TicketService {
    
    public Long addTicket(String name, String note, int averageTime, Long parent, Long project, Long uploadedFile);
    public boolean removeTicket(Long ticketId);
//    public boolean setUserWorkOnTicket(Long userId,Long ticketId);
//    public boolean unSetUserWorkOnTicket(Long userId,Long ticketId);
    
    @Transactional(readOnly=true)    
    public TicketDto getTicket(Long ticketId);
    @Transactional(readOnly=true)
    public List<TicketDto> getAllTickets();
    @Transactional(readOnly=true)
    public List<TicketDto> getAllTicketsByProjectId(Long projectId);
//    @Transactional(readOnly=true)
//    public List<TicketDto> getAllTicketsByUserId(Long userId);
            
}
