package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    //Routing URL yang diinginkan
    @RequestMapping("/bioskop/add")
    public String addBioskop(
            //Request parameter yang ingin digunakan
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambahkan objek BioskopModel kedalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variable id bioskop ke "idbioskop" untuk di render ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        // Mendapatkan semua bioskop
        List <BioskopModel> listBioskop = bioskopService.getBioskopList();

        // Add variable semua BioskopModel ke 'listBioskop' untuk dirender dalam thymeleaf
        model.addAttribute("listBioskop", listBioskop);

        // Return view template yang diinginkan
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop (
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        // Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        // Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    @GetMapping(value="/bioskop/view/id-bioskop/{idBioskop}")
    public String detailBioskopWithPathVariable (
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        // Melakukan pengecekan idBioskop ada atau tidak
        if (idBioskop == null) {
            return "error-view";
        }
        // Mendapatkan bioskop sesuai dengan idBioskop
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null) {
            return "error-view";
        }
        // Add variable BioskopModel ke 'bioskop' untuk dirender dalam thymeleaf
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }

    // Handler untuk Update jumlah studio bioskop berdasarkan idBioskop
    @RequestMapping (value= {"/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}", "/bioskop/update/id-bioskop/jumlah-studio/{jumlahStudio}"})
    public String updateBioskop (
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            @PathVariable(value = "jumlahStudio") int jumlahStudio,
            Model model
    ) {
        // Melakukan pengecekan idBioskop ada atau tidak
        if (idBioskop == null) {
            return "error-update";
        }
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);

        if (bioskopModel == null) {
                return "error-update";
        }
        model.addAttribute("bioskop", bioskopModel);
        bioskopService.updateJunlahStudio(idBioskop, jumlahStudio);

        return "update-bioskop";
    }

    @RequestMapping (value= {"/bioskop/delete/id-bioskop/{idBioskop}", "/bioskop/delete/id-bioskop/"})
    public String deleteBioskop (
            @PathVariable( value = "idBioskop", required = true) String idBioskop, Model model
    ) {
        // Melakukan pengecekan idBioskop ada atau tidak
        if (idBioskop == null) {
            return "error-delete";
        }
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        if (bioskopModel == null) {
            return "error-delete";
        }
        model.addAttribute("bioskop", bioskopModel);
        bioskopService.deleteBioskop(idBioskop);

        return "delete-bioskop";

    }

}