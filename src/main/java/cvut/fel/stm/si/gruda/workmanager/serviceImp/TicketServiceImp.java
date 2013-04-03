/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.Project;
import cvut.fel.stm.si.gruda.workmanager.bo.Ticket;
import cvut.fel.stm.si.gruda.workmanager.bo.UploadedFile;
import cvut.fel.stm.si.gruda.workmanager.dto.TicketDto;
import cvut.fel.stm.si.gruda.workmanager.helper.DtoTransformerHelper;
import cvut.fel.stm.si.gruda.workmanager.service.TicketService;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class TicketServiceImp extends AbstractDataAccessServiceImp implements TicketService {

    @Override
    public Long addTicket(String name, String note, int averageTime, Long parent, Long project, Long uploadedFile) {
        
        Ticket t = new Ticket();
        t.setAvegageTime(averageTime);
        t.setName(name);
        t.setNote(note);
        Ticket par = genericDao.getById(parent, Ticket.class);
        t.setParent(par);
        Project pro = genericDao.getById(project, Project.class);
        t.setProject(pro);
        UploadedFile uf = genericDao.getById(uploadedFile, UploadedFile.class);
        t.setUploadedFile(uf);
        
        return genericDao.saveOrUpdate(t).getId();
    }

    @Override
    public boolean removeTicket(Long ticketId) {
        
        genericDao.removeById(ticketId, Ticket.class);
        return true;        
                
    }

    @Override
    public TicketDto getTicket(Long ticketId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TicketDto> getAllTickets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TicketDto> getAllTicketsByProjectId(Long projectId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TicketDto> getAllTicketsByUserId(Long userId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private TicketDto transformEntityToDto(Ticket t) {
        
        TicketDto tDto = new TicketDto();
        tDto.setAverageTime(t.getAvegageTime());
        tDto.setId(t.getId());
        tDto.setName(t.getName());
        tDto.setNote(t.getNote());
        tDto.setParent(t.getParent().getId());
        tDto.setProject(t.getProject().getId());
        tDto.setTickets(DtoTransformerHelper.getIdentifiers(t.getTickets()));
        tDto.setUploadedFile(t.getUploadedFile().getId());
        tDto.setWorkOnTickets(DtoTransformerHelper.getIdentifiers(t.getWorkOnTickets()));
        tDto.setWorkedHours(DtoTransformerHelper.getIdentifiers(t.getWorkedHours()));
        
        
        return tDto;
        
    }
    
}
