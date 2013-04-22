/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.SettlingTime;
import cvut.fel.stm.si.gruda.workmanager.bo.Ticket;
import cvut.fel.stm.si.gruda.workmanager.bo.UploadedFile;
import cvut.fel.stm.si.gruda.workmanager.bo.User;
import cvut.fel.stm.si.gruda.workmanager.bo.WorkedHours;
import cvut.fel.stm.si.gruda.workmanager.dto.WorkedHoursDto;
import cvut.fel.stm.si.gruda.workmanager.service.WorkedHoursService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class WorkedHoursServiceImp extends AbstractDataAccessServiceImp implements WorkedHoursService{

    @Override
    public Long addWorkedHours(Date startTime, Date endTime, String note, Long user, Long ticket, Long settlingTime, Long uploadedFile) {
        
        WorkedHours wh = new WorkedHours();
        wh.setEndTime(endTime);
        wh.setNote(note);
        if (settlingTime != null) {
            wh.setSettlingTime(genericDao.getById(settlingTime, SettlingTime.class));
        }
        if (uploadedFile != null) {
            wh.setUploadedFile(genericDao.getById(uploadedFile, UploadedFile.class));
        }
        wh.setStartTime(startTime);
        if (ticket != null) {
            wh.setTicket(genericDao.getById(ticket, Ticket.class));
        }
        if (user != null) {
           wh.setUser(genericDao.getById(user, User.class)); 
        }
        return genericDao.saveOrUpdate(wh).getId();
    }

    @Override
    public boolean deleteWorkedHours(Long workedHoursId) {
        
        genericDao.removeById(workedHoursId, WorkedHours.class);
        return true;
    }

    @Override
    public WorkedHoursDto getWorkedHours(Long id) {
        return transformEntityToDto(genericDao.getById(id, WorkedHours.class));
    }

    @Override
    public List<WorkedHoursDto> getAllWorkedHours() {
       
        List<WorkedHours> whs = genericDao.getAll(WorkedHours.class);
        List<WorkedHoursDto> whDto = new ArrayList<WorkedHoursDto>();
        
        for(WorkedHours wh : whs) {
            whDto.add(transformEntityToDto(wh));
        }
        return whDto;
    }

    @Override
    public List<WorkedHoursDto> getAllWorkedHoursByUser(Long userId) {
        
        List<WorkedHours> whs = genericDao.getAll(WorkedHours.class);
        List<WorkedHoursDto> whDto = new ArrayList<WorkedHoursDto>();
        
        for(WorkedHours wh : whs) {
            if(wh.getUser().getId()== userId) {
            whDto.add(transformEntityToDto(wh));
            };
        }
        return whDto;
    }

    @Override
    public List<WorkedHoursDto> getAllWorkedHoursByProject(Long projectId) {
         List<WorkedHours> whs = genericDao.getAll(WorkedHours.class);
        List<WorkedHoursDto> whDto = new ArrayList<WorkedHoursDto>();
        
        for(WorkedHours wh : whs) {
            if(wh.getTicket().getProject().getId()==projectId) {
            whDto.add(transformEntityToDto(wh));
            };
        }
        return whDto;
    }

    @Override
    public List<WorkedHoursDto> getAllWorkedHoursByUserAndProject(Long userId, Long projectId) {
        List<WorkedHours> whs = genericDao.getAll(WorkedHours.class);
        List<WorkedHoursDto> whDto = new ArrayList<WorkedHoursDto>();
        
        for(WorkedHours wh : whs) {
            if(wh.getUser().getId()== userId && wh.getTicket().getProject().getId() == projectId) {
            whDto.add(transformEntityToDto(wh));
            };
        }
        return whDto;
    }
 
    private WorkedHoursDto transformEntityToDto(WorkedHours wh) {
        
        WorkedHoursDto whDto = new WorkedHoursDto();
        whDto.setEndTime(wh.getEndTime());
        whDto.setId(wh.getId());
        whDto.setNote(wh.getNote());
        whDto.setStartTime(wh.getStartTime());
        
        if (wh.getSettlingTime() != null) {
            whDto.setSettlingTime(wh.getSettlingTime().getId());
        }
        if (wh.getTicket() != null) {
            whDto.setTicket(wh.getTicket().getId());
        }
        if (wh.getUploadedFile() != null) {
            whDto.setUploadedFile(wh.getUploadedFile().getId());
        }
        if (wh.getUser() != null ) {
            whDto.setUser(wh.getUser().getId());
        }
        return whDto;
    }
}
