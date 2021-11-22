package apap.tutorial.cineplux.controller;
import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.RoleModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.RoleService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/add")
    private String addUserFormPage(Model model){
        UserModel user = new UserModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-user" ;
    }

    @PostMapping(value = "/add")
    private String addUserSubmit(@ModelAttribute UserModel user, Model model) {
        List<UserModel> listUser = userService.getListUser();
        for (UserModel userEmail: listUser) {
            if (user.getEmail().equals(userEmail.getEmail())) {
                return "failed-add";
            }
        }
        userService.addUser(user);
        model.addAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/viewall")
    public String listUser(Model model) {
        List<UserModel> listUser = userService.getListUser();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        String username = user.getUsername();
        UserModel userModel = userService.findByUsername(username);

        model.addAttribute("listUser", listUser);
        model.addAttribute("user", userModel);

        return "viewall-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser (
            @PathVariable String id, Model model
    ) {
        if (id.equals("null")) {
            return "error-view";
        }

        UserModel user = userService.getUserById(id);
        userService.deleteUser(user);

        if (id.equals("null")) {
            return "error-view";
        }
        model.addAttribute( "id",user.getId());
        return "delete-user";
    }

    @PostMapping("/updatePassword")
    public String updatePostPassword(@ModelAttribute UserModel userModel, String newPassword, String confPassword, Model model){
        UserModel user = userService.findByUsername(userModel.getUsername());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(userModel.getPassword(), user.getPassword())){
            if (newPassword.equals(confPassword)){
                user.setPassword(newPassword);
                userService.addUser(user);
                return "update-password-sukses";
            }else {
                model.addAttribute("message", "password yang dikonfirmasi tidak sama. Ulangi!");
            }
        }else {
            model.addAttribute("message", "password lama invalid. Ulangi!");
        }
        return "form-update-password";
    }

    @GetMapping("/updatePassword")
    public String getUpdatePassword(){
        return "form-update-password";
    }
}
