/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.dao.GenericDao;
import org.springframework.stereotype.Component;

/**
 *
 * @author grudapav
 */
@Component
public class AbstractDataAccessServiceImp {
    protected GenericDao genericDao;
    
    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }

    public GenericDao getGenericDao() {
        return genericDao;
    }
}
