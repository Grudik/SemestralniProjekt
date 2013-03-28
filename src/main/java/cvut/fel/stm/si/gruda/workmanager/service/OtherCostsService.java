/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.OtherCostsDto;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface OtherCostsService {
    public OtherCostsDto getOtherCosts(Long otherCostsServiceId);
    public Long addOtherCosts(Date time, int value, String name, String note, Long user, Long settlingTime, Long project);
    public boolean removeOtherCosts(Long otherCostsId);
    @Transactional(readOnly=true)
    public List<OtherCostsDto> getAllOtherCosts();
    @Transactional(readOnly=true)
    public List<OtherCostsDto> getAllOtherCostsByProjectId(Long projectId);
            
}
