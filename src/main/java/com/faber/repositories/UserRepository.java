package com.faber.repositories;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.faber.entities.User;
import org.springframework.data.repository.CrudRepository;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
