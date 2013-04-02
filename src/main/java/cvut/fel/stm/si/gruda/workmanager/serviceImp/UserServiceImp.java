/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cvut.fel.stm.si.gruda.workmanager.serviceImp;

import cvut.fel.stm.si.gruda.workmanager.bo.User;
import cvut.fel.stm.si.gruda.workmanager.dto.UserDto;
import cvut.fel.stm.si.gruda.workmanager.helper.DtoTransformerHelper;
import cvut.fel.stm.si.gruda.workmanager.provider.SHA1Provider;
import cvut.fel.stm.si.gruda.workmanager.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author GrudikNTB
 */
@Component
public class UserServiceImp extends AbstractDataAccessServiceImp implements UserService {

    @Override
    public Long addUser(String name, String surname, String login, String email, String password, String phone) {
        
        User u = new User();
        u.setName(name);
        u.setSurname(surname);
        u.setLogin(login);
        u.setEmail(email);
        u.setPhone(phone);
        u.setHashProvider(new SHA1Provider());
        u.setPassword(password);
        
        return getGenericDao().saveOrUpdate(u).getId();
    }

    @Override
    public void deleteUser(Long userId) {
        getGenericDao().removeById(userId, User.class);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User u = getGenericDao().getById(userId, User.class);
        return new UserDto(userId, u.getName(), u.getSurname(),u.getEmail(), u.getLogin(), u.getPassword(), u.getPhone(), DtoTransformerHelper.getIdentifiers(u.getOtherCosts()), DtoTransformerHelper.getIdentifiers(u.getWorkOnProjects()), DtoTransformerHelper.getIdentifiers(u.getWorkOtTickets()), DtoTransformerHelper.getIdentifiers(u.getWorkedHours()));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = getGenericDao().getAll(User.class);
        List<UserDto> personDtos = new ArrayList<UserDto>();
        
        for(User u : users) {
            personDtos.add(new UserDto(u.getId(), u.getName(), u.getSurname(),u.getEmail(), u.getLogin(), u.getPassword(), u.getPhone(), DtoTransformerHelper.getIdentifiers(u.getOtherCosts()), DtoTransformerHelper.getIdentifiers(u.getWorkOnProjects()), DtoTransformerHelper.getIdentifiers(u.getWorkOtTickets()), DtoTransformerHelper.getIdentifiers(u.getWorkedHours())));
        }
        return personDtos;
    }
    
}
