/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.CustomerDto;
import cvut.fel.stm.si.gruda.workmanager.dto.ProjectDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface CustomerService {
    
    public Long addCustomer(String name, String surname, String email, String phone, String note);
    public CustomerDto getCustomer(Long customerId);
    public boolean removeCustomer(Long customerId);
    @Transactional(readOnly=true)
    public List<CustomerDto> getAllCustomers();
    @Transactional(readOnly=true)
    public List<ProjectDto> getAllProjectsByCustomerId(Long customerId);
    
    
}
