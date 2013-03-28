/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.service;

import cvut.fel.stm.si.gruda.workmanager.dto.UserDto;
import cvut.fel.stm.si.gruda.workmanager.dto.WorkedHoursDto;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author GrudikNTB
 */
@Transactional
public interface UserService {

    public Long addUser(String name, String surname, String login, String email, String password, String phone);

    public void deleteUser(Long userId);

    @Transactional(readOnly = true)
    public UserDto getUserById(Long userId);

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers();
    
}
