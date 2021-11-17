package apap.tutorial.cineplux.repository;

import apap.tutorial.cineplux.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDB extends JpaRepository<UserModel, String> {
    UserModel findByUsername(String username);
    List<UserModel> findAll();
    Optional<UserModel> findById(String id);
}
