package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.FilmService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util. ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private UserService userService;

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        List<FilmModel> temp = new ArrayList<>();
        BioskopModel bioskop = new BioskopModel();
        FilmModel film = new FilmModel();
        temp.add(film);
        bioskop.setListFilm(temp);

        model.addAttribute("bioskop", bioskop);
        model.addAttribute( "listFilmAll", filmService.getListFilm());
        return "form-add-bioskop";
    }

//    @PostMapping("/bioskop/add")
//    public String addBioskopsubmit(
//            @ModelAttribute BioskopModel bioskop,
//            Model model
//    ){
//        bioskopService.addBioskop(bioskop);
//        model.addAttribute( "noBioskop", bioskop.getNoBioskop());
//        return "add-bioskop";
//    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        //<BioskopModel> listBioskop = bioskopService.getBioskopList();
        List<BioskopModel> listBioskop = bioskopService.findAllBioskopOrderBynamaBioskopAsc();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        String username = user.getUsername();
        UserModel userModel = userService.findByUsername(username);

        model.addAttribute ( "listBioskop", listBioskop);
        model.addAttribute("user", userModel);

        return "viewall-bioskop" ;
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        if (noBioskop == null) {
            return "error-view";
        }
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if (bioskop == null) {
            return "error-view";
        }
        else {
            List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
            List<FilmModel> listFilm = bioskop.getListFilm();

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = (User) auth.getPrincipal();
            String username = user.getUsername();
            UserModel userModel = userService.findByUsername(username);

            model.addAttribute("user", userModel);
            model.addAttribute( "bioskop", bioskop);
            model.addAttribute("listPenjaga", listPenjaga);
            model.addAttribute( "listFilmAll", listFilm);


            return "view-bioskop";
        }
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ){
        if (noBioskop == null) {
            return "error-view";
        }

        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if (bioskop == null) {
            return "error-view";
        }

        model.addAttribute( "bioskop",bioskop);
        return"form-update-bioskop" ;
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.updateBioskop(bioskop);
        model.addAttribute( "noBioskop",bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping("/bioskop/delete/{noBioskop}")
    public String deleteBioskop (
            @PathVariable Long noBioskop, Model model
    ) {
        if (noBioskop == null) {
            return "error-view";
        }

        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);

        if (bioskop == null) {
            return "error-view";
        }
        else {
            // Bioskop yang dapat di delete hanyalah bioskop yang tidak memiliki penjaga
            if (bioskop.getListPenjaga().isEmpty() && bioskopService.deleteBioskop(bioskop, noBioskop)) {
                model.addAttribute( "noBioskop",bioskop.getNoBioskop());
                return "delete-bioskop";
            }
            else {
                return "delete-bioskop-failed";
            }
        }

    }

    @PostMapping(value = "/bioskop/add/", params = {"plusRow"})
    private String plusRow(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskop.getListFilm().add(new FilmModel());
        model.addAttribute("bioskop", bioskop);
        model.addAttribute( "listFilmAll", filmService.getListFilm());
        return "form-add-bioskop";
    }

    @PostMapping(value=("/bioskop/add/"), params = ("minRow"))
    public String minRow(
            @ModelAttribute BioskopModel bioskop,
            @RequestParam("minRow") int index,
            Model model
    ){
        bioskop.getListFilm().remove(index);
        model.addAttribute("bioskop", bioskop);
        model.addAttribute( "listFilmAll", filmService.getListFilm());
        return "form-add-bioskop";
    }

    @PostMapping(value="/bioskop/add/", params = {"submitBioskop"})
    private String submitBioskop(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.addBioskop(bioskop);
        model.addAttribute( "noBioskop", bioskop.getNoBioskop());
        model.addAttribute( "listFilmAll", filmService.getListFilm());
        return "add-bioskop";
    }

}