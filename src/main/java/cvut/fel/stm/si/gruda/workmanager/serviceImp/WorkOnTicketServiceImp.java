/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.Ticket;
import cvut.fel.stm.si.gruda.workmanager.bo.User;
import cvut.fel.stm.si.gruda.workmanager.bo.WorkOnTicket;
import cvut.fel.stm.si.gruda.workmanager.dto.WorkOnTicketDto;
import cvut.fel.stm.si.gruda.workmanager.service.WorkOnTicketService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class WorkOnTicketServiceImp extends AbstractDataAccessServiceImp implements WorkOnTicketService{

    @Override
    public Long addWorkOnTicket(boolean ownerOfTicket, Long user, Long ticket) {
        
        WorkOnTicket wot = new WorkOnTicket();
        wot.setOwner(ownerOfTicket);
        wot.setTicket(genericDao.getById(ticket, Ticket.class));
        wot.setUser(genericDao.getById(user, User.class));
        
        return genericDao.saveOrUpdate(wot).getId();
    }

    @Override
    public boolean deleteWorkOnTicket(Long workOnTicketId) {
        
        genericDao.removeById(workOnTicketId, WorkOnTicket.class);
        return true;
    }

    @Override
    public WorkOnTicketDto getWorkOnTicket(Long workOnTicketId) {
        
        return transformEntityToDto(genericDao.getById(workOnTicketId, WorkOnTicket.class));
        
    }

    @Override
    public List<WorkOnTicketDto> getAllWorkOnTickets() {
        
        List<WorkOnTicket> wots = genericDao.getAll(WorkOnTicket.class);
        List<WorkOnTicketDto> wotDtos = new ArrayList<WorkOnTicketDto>();
        for (WorkOnTicket wot : wots) {
            wotDtos.add(transformEntityToDto(wot));
        }
        return wotDtos;
    }

    @Override
    public List<WorkOnTicketDto> getAllWorkOnTicketByProjectId(Long projectId) {
        
        List<WorkOnTicket> wots = genericDao.getAll(WorkOnTicket.class);
        List<WorkOnTicketDto> wotDtos = new ArrayList<WorkOnTicketDto>();
        for (WorkOnTicket wot : wots) {
            if (wot.getTicket().getProject().getId() == projectId) {
                wotDtos.add(transformEntityToDto(wot));
            }
        }
        return wotDtos;
    }

    @Override
    public List<WorkOnTicketDto> getAllWorkOnTicketByUserId(Long userId) {
        
        List<WorkOnTicket> wots = genericDao.getAll(WorkOnTicket.class);
        List<WorkOnTicketDto> wotDtos = new ArrayList<WorkOnTicketDto>();
        for (WorkOnTicket wot : wots) {
            if (wot.getUser().getId() == userId) {
                wotDtos.add(transformEntityToDto(wot));
            }
        }
        return wotDtos;
    }
    
    private WorkOnTicketDto transformEntityToDto(WorkOnTicket wot) {
        
        WorkOnTicketDto wotDto = new WorkOnTicketDto();
        
        wotDto.setId(wot.getId());
        wotDto.setOwnerOfTicket(wot.isOwner());
        wotDto.setTicket(wot.getTicket().getId());
        wotDto.setUser(wot.getUser().getId());
        
        return wotDto;
        
    }
}
