/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.SettlingTimeDto;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface SettlingTimeService {
    
    public Long addSettlingTime(List<Long> otherCosts, Date settlingTime, List<Long> workedHours);
    public boolean removeSettlingTime(Long settlingTimeId);
    
    @Transactional(readOnly=true)
    public SettlingTimeDto getSettlingTime(Long settlingTimeId);
    @Transactional(readOnly=true)
    public List<SettlingTimeDto> getAllSettlingTime();

    
}
