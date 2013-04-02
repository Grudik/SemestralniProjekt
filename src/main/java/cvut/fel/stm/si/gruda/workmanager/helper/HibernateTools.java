/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.helper;

import cvut.fel.stm.si.gruda.workmanager.bo.AbstractBusinessObject;
import org.hibernate.proxy.HibernateProxy;


public class HibernateTools {
    /**
     * Get id from the proxy of the object without hitting the database
     * @return identifikator objektu
     */
    public static Long getIdentifier(AbstractBusinessObject o){
        if(o == null) return null;
        Long id = null;
        if(o instanceof HibernateProxy){
            id = (Long)((HibernateProxy) o).getHibernateLazyInitializer().getIdentifier();
        }else{
            id = o.getId();
        }
        return id;
    }
}