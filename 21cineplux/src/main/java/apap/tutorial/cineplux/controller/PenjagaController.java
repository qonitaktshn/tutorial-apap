package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PenjagaController {

    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @GetMapping("penjaga/add/{noBioskop}")
    public String addPenjagaForm(
            @PathVariable Long noBioskop, Model model
    ) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga", penjaga);
        return "form-add-penjaga";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagasubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga", penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    @GetMapping("/penjaga/update/{noPenjaga}")
    public String updatePenjagaForm(
            @PathVariable Long noPenjaga,
            Model model
    ){
        if (noPenjaga == null) {
            return "error-view";
        }

        PenjagaModel penjaga = penjagaService.getPenjagaByNoPenjaga(noPenjaga);
        if (penjaga == null) {
            return "error-view";
        }
        model.addAttribute( "penjaga",penjaga);
        return"form-update-penjaga" ;
    }

    @PostMapping("/penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ){
        if (penjagaService.updatePenjaga(penjaga)) {
            model.addAttribute( "noPenjaga",penjaga.getNoPenjaga());
            return "update-penjaga";
        }
        else {
            return "update-penjaga-failed";
        }
    }

    @PostMapping("/penjaga/delete")
    public String deletePenjagaSubmit(
            @ModelAttribute BioskopModel bioskop, Model model
    ){
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        int res = 1;
        for (PenjagaModel penjaga:
                bioskop.getListPenjaga()){
            res = penjagaService.deletePenjaga(penjaga);
        }
        if (res == 1) {
            return "delete-penjaga";
        }
        return "delete-penjaga-failed";
    }
}