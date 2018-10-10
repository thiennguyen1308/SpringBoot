package com.faber.business;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.entities.User;
import com.faber.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@Service//Singleton, auto init when run spring application
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getListUser() {
        List<User> user = new ArrayList<>();
        userRepository.findAll().forEach(user::add);
        return user;
    }

    public User getUserByID(int id) {
        return userRepository.findById(id).get();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
