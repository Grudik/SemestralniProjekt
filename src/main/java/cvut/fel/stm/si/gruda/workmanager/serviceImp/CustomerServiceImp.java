/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.Customer;
import cvut.fel.stm.si.gruda.workmanager.dto.CustomerDto;
import cvut.fel.stm.si.gruda.workmanager.helper.DtoTransformerHelper;
import cvut.fel.stm.si.gruda.workmanager.service.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class CustomerServiceImp extends AbstractDataAccessServiceImp implements CustomerService {

    @Override
    public Long addCustomer(String name, String surname, String email, String phone, String note) {
        
        Customer c = new Customer();
        c.setName(name);
        c.setSurname(surname);
        c.setEmail(email);
        c.setPhone(phone);
        c.setNote(note);
        return getGenericDao().saveOrUpdate(c).getId();
        
    }

    @Override
    public boolean removeCustomer(Long customerId) {
        getGenericDao().removeById(customerId, Customer.class);
        return true;
    }

    @Override
    public CustomerDto getCustomer(Long customerId) {
        
        Customer c = getGenericDao().getById(customerId, Customer.class);
        return transformEntityToDto(c);
        
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        
        List<Customer> customers = getGenericDao().getAll(Customer.class);
        List<CustomerDto> custDtos = new ArrayList<CustomerDto>();
        
        for(Customer c : customers) {
            custDtos.add(transformEntityToDto(c));
        }
        return custDtos;
    }
    
    private CustomerDto transformEntityToDto(Customer c) {
        
        CustomerDto cDto = new CustomerDto();
        
        cDto.setEmail(c.getEmail());
        cDto.setId(c.getId());
        cDto.setName(c.getName());
        cDto.setNote(c.getNote());
        cDto.setPhone(c.getPhone());
        cDto.setProjects(DtoTransformerHelper.getIdentifiers(c.getProjects()));
        cDto.setSurname(c.getSurname());
        
        return cDto;
        
    }


    
}
