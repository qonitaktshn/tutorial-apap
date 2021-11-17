package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user. setPassword(pass);
        System.out.println(user.getRole());
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new  BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    public UserModel findByUsername(String username) {
        return userDb.findByUsername(username);
    }

    public List<UserModel> getListUser() {
        return userDb.findAll();
    }

    @Override
    public UserModel getUserById(String id) {
        Optional<UserModel> user = userDb.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public void deleteUser(UserModel user) {
        userDb.delete(user);
    }

    @Override
    public Boolean checkIfValidOldPassword(UserModel user, String password) {
        return new BCryptPasswordEncoder().matches(password, user.getPassword());
    }

    @Override
    public void changePassword(UserModel user, String password) {
        String hashedPassword = encrypt(password);
        user.setPassword(hashedPassword);
        userDb.save(user);
    }

    @Override
    public Boolean checkIfValidNewPassword(String password) {
        String huruf = ".*[A-Za-z].*";
        String angka = ".*[0-9].*";
        String simbol = ".*[!@#$%&*()_+=|<>?{}\\[\\]~-].*";
        if(password.length()<8 || !password.matches(huruf) || !password.matches(angka) || !password.matches(simbol)){
            return false;
        }
        return true;
    }
}

