/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.OtherCosts;
import cvut.fel.stm.si.gruda.workmanager.bo.Project;
import cvut.fel.stm.si.gruda.workmanager.bo.SettlingTime;
import cvut.fel.stm.si.gruda.workmanager.bo.User;
import cvut.fel.stm.si.gruda.workmanager.dto.OtherCostsDto;
import cvut.fel.stm.si.gruda.workmanager.helper.DtoTransformerHelper;
import cvut.fel.stm.si.gruda.workmanager.service.OtherCostsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class OtherCostsServiceImp extends AbstractDataAccessServiceImp implements OtherCostsService {

    @Override
    public Long addOtherCosts(Date time, int value, String name, String note, Long user, Long settlingTime, Long project) {
        
        OtherCosts oc = new OtherCosts();
        
        oc.setTime(time);
        oc.setValue(value);
        oc.setName(name);
        oc.setNote(note);
        oc.setUser(genericDao.getById(user, User.class));
        oc.setProject(genericDao.getById(project, Project.class));
        if(settlingTime != null) {
            oc.setSettlingTime(genericDao.getById(settlingTime, SettlingTime.class));
        }
        
        return genericDao.saveOrUpdate(oc).getId();
    }

    @Override
    public boolean removeOtherCosts(Long otherCostsId) {
        
        genericDao.removeById(otherCostsId, OtherCosts.class);
        return true;
        
    }

    @Override
    public OtherCostsDto getOtherCosts(Long otherCostsId) {
        
        OtherCosts oc = genericDao.getById(otherCostsId, OtherCosts.class);
        return transformEntityToDto(oc);
        
    }

    @Override
    public List<OtherCostsDto> getAllOtherCosts() {
        
        List<OtherCosts> ocs = genericDao.getAll(OtherCosts.class);
        List<OtherCostsDto> ocsDto = new ArrayList<OtherCostsDto>();
        for(OtherCosts oc : ocs) {
            ocsDto.add(transformEntityToDto(oc));
        }
        return ocsDto;
        
    }

    @Override
    public List<OtherCostsDto> getAllOtherCostsByProjectId(Long projectId) {
        
        List<OtherCosts> ocs = genericDao.getAll(OtherCosts.class);
        List<OtherCostsDto> ocsDto = new ArrayList<OtherCostsDto>();
        for(OtherCosts oc : ocs) {
            if(oc.getProject().getId() == projectId) {
                ocsDto.add(transformEntityToDto(oc));
            }
            
        }
        return ocsDto;
    }
    
    private OtherCostsDto transformEntityToDto(OtherCosts oc) {
        
        OtherCostsDto ocDto = new OtherCostsDto();
        
        ocDto.setId(oc.getId());
        ocDto.setName(oc.getName());
        ocDto.setNote(oc.getNote());
        ocDto.setProject(oc.getProject().getId());
        ocDto.setSettlingTime(oc.getSettlingTime().getId());
        ocDto.setTime(oc.getTime());
        ocDto.setUser(oc.getUser().getId());
        ocDto.setValue(oc.getValue());
        
        return ocDto;
    }
}
