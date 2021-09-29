package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util. ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        model.addAttribute("bioskop",new BioskopModel());
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopsubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ){
        bioskopService.addBioskop(bioskop);
        model.addAttribute( "noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        //<BioskopModel> listBioskop = bioskopService.getBioskopList();
        List<BioskopModel> listBioskop = bioskopService.findAllBioskopOrderBynamaBioskopAsc();
        model.addAttribute ( "listBioskop", listBioskop);
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

            model.addAttribute( "bioskop", bioskop);
            model.addAttribute("listPenjaga", listPenjaga);

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

}