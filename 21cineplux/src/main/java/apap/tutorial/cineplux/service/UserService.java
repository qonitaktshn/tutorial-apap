package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getListUser();
    UserModel findByUsername(String username);
    UserModel getUserById(String id);
    void deleteUser(UserModel user);
    Boolean checkIfValidOldPassword(UserModel user, String password);
    void changePassword(UserModel user, String password);
    Boolean checkIfValidNewPassword(String password);
}
