/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.Project;
import cvut.fel.stm.si.gruda.workmanager.bo.Ticket;
import cvut.fel.stm.si.gruda.workmanager.bo.UploadedFile;
import cvut.fel.stm.si.gruda.workmanager.bo.WorkedHours;
import cvut.fel.stm.si.gruda.workmanager.dto.UploadedFileDto;
import cvut.fel.stm.si.gruda.workmanager.service.UploadedFileService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class UploadedFileServiceImp extends AbstractDataAccessServiceImp implements UploadedFileService{

    @Override
    public Long addUploadedFile(String name, String note, Byte[] file, Long project, Long ticket, Long workedHours) {
        
        UploadedFile uf = new UploadedFile();
        uf.setName(name);
        uf.setNote(note);
        uf.setFile(file);
        uf.setProject(genericDao.getById(project, Project.class));
        uf.setTicket(genericDao.getById(ticket, Ticket.class));
        uf.setWorkedHours(genericDao.getById(workedHours, WorkedHours.class));
        
        return genericDao.saveOrUpdate(uf).getId();
    }

    @Override
    public boolean removeUploadedFile(Long fileId) {
        
        genericDao.removeById(fileId, UploadedFile.class);
        return true;
    }

    @Override
    public UploadedFileDto getUploadedFile(Long fileId) {
        
        return transformEntityToDto(genericDao.getById(fileId, UploadedFile.class));
        
    }

    @Override
    public List<UploadedFileDto> getAllUploadedFiles() {
        
        List<UploadedFile> ufs = genericDao.getAll(UploadedFile.class);
        List<UploadedFileDto> ufDtos = new ArrayList<UploadedFileDto>();
        for(UploadedFile uf : ufs) {
            ufDtos.add(transformEntityToDto(uf));
        }
        return ufDtos;
        
    }

    @Override
    public List<UploadedFileDto> getAllUploadedFilesByProject(Long projectId) {
        
        List<UploadedFile> ufs = genericDao.getAll(UploadedFile.class);
        List<UploadedFileDto> ufDtos = new ArrayList<UploadedFileDto>();
        for(UploadedFile uf : ufs) {
            if (uf.getProject().getId() == projectId) {
                ufDtos.add(transformEntityToDto(uf));
            }
        }
        return ufDtos;
        
    }
    
    private UploadedFileDto transformEntityToDto(UploadedFile uf) {
        
        UploadedFileDto ufDto = new UploadedFileDto();
        ufDto.setFile(uf.getFile());
        ufDto.setId(uf.getId());
        ufDto.setName(uf.getName());
        ufDto.setNote(uf.getNote());
        ufDto.setProject(uf.getProject().getId());
        ufDto.setTicket(uf.getTicket().getId());
        ufDto.setWorkedHours(uf.getWorkedHours().getId());
        
        return ufDto;
        
    }


}
