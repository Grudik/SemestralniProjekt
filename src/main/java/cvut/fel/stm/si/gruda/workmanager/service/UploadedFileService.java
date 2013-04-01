/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.UploadedFileDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface UploadedFileService {
    
    public Long addUploadedFile(String name, String note, Byte[] file, Long project, Long ticket, Long workedHours);
    public boolean removeUploadedFile(Long fileId);
    
    @Transactional(readOnly=true)
    public UploadedFileDto getUploadedFile(Long fileId);
    @Transactional(readOnly=true)
    public List<UploadedFileDto> getAllUploadedFiles();
    @Transactional(readOnly=true)
    public List<UploadedFileDto> getAllUploadedFilesByProject(Long projectId);
    
}