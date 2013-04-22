/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.OtherCosts;
import cvut.fel.stm.si.gruda.workmanager.bo.SettlingTime;
import cvut.fel.stm.si.gruda.workmanager.bo.WorkedHours;
import cvut.fel.stm.si.gruda.workmanager.dto.SettlingTimeDto;
import cvut.fel.stm.si.gruda.workmanager.helper.DtoTransformerHelper;
import cvut.fel.stm.si.gruda.workmanager.service.SettlingTimeService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class SettlingTimeServiceImp extends AbstractDataAccessServiceImp implements SettlingTimeService {

    @Override
    public Long addSettlingTime(List<Long> otherCosts, Date settlingTime, List<Long> workedHours) {

        SettlingTime st = new SettlingTime();
        st.setSettlingTime(settlingTime);

        if (otherCosts != null) {
            List<OtherCosts> ocs = new ArrayList<OtherCosts>();
            for (Long l : otherCosts) {
                ocs.add(genericDao.getById(l, OtherCosts.class));
                st.setOtherCosts(ocs);
            }
        }
        if (workedHours != null) {
            List<WorkedHours> whs = new ArrayList<WorkedHours>();
            for (Long l : workedHours) {
                whs.add(genericDao.getById(l, WorkedHours.class));
            }
            st.setWorkedHours(whs);
        }
        
        return genericDao.saveOrUpdate(st).getId();

    }

    @Override
    public boolean removeSettlingTime(Long settlingTimeId) {

        genericDao.removeById(settlingTimeId, SettlingTime.class);
        return true;

    }

    @Override
    public SettlingTimeDto getSettlingTime(Long settlingTimeId) {

        SettlingTime st = genericDao.getById(settlingTimeId, SettlingTime.class);
        return trasformEntityToDto(st);

    }

    @Override
    public List<SettlingTimeDto> getAllSettlingTime() {

        List<SettlingTime> sts = genericDao.getAll(SettlingTime.class);
        List<SettlingTimeDto> stsDto = new ArrayList<SettlingTimeDto>();
        for (SettlingTime st : sts) {
            stsDto.add(trasformEntityToDto(st));
        }
        return stsDto;

    }

    private SettlingTimeDto trasformEntityToDto(SettlingTime st) {

        SettlingTimeDto stDto = new SettlingTimeDto();
        stDto.setId(st.getId());
        stDto.setSettlingTime(st.getSettlingTime());
        stDto.setOtherCosts(DtoTransformerHelper.getIdentifiers(st.getOtherCosts()));
        stDto.setWorkedHours(DtoTransformerHelper.getIdentifiers(st.getWorkedHours()));

        return stDto;

    }
}
