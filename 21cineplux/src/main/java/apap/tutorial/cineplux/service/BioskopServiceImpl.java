package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BioskopServiceImpl implements BioskopService {
    @Autowired
    BioskopDB bioskopDB;

    @Override
    public void addBioskop(BioskopModel bioskop) { bioskopDB.save(bioskop); }

    @Override
    public void updateBioskop(BioskopModel bioskop) {
        System.out.println(bioskop.getNamaBioskop());
        System.out.println(bioskop.getNoBioskop());
        System.out.println(bioskop.getAlamatBioskop());
        System.out.println(bioskop.getJumlahStudio());
        System.out.println(bioskop.getWaktuTutup());
        System.out.println(bioskop.getWaktuBuka());
        bioskopDB.save(bioskop);
    }

    @Override
    public boolean deleteBioskop(BioskopModel bioskop, Long noBioskop) {
        LocalTime currentTime = LocalTime.now();
        LocalTime closeTime = bioskop.getWaktuTutup();
        LocalTime openTime = bioskop.getWaktuBuka();
        boolean time = true;
        if (currentTime.isAfter(closeTime) || currentTime.isBefore(openTime) ) {
            bioskopDB.deleteById(noBioskop);
        }
        else {
            time = false;
        }
        return time;
    }

    @Override
    public List<BioskopModel> getBioskopList() { return bioskopDB.findAll(); }

    @Override
    public List<BioskopModel> findAllBioskopOrderBynamaBioskopAsc() {
        return bioskopDB.findAllByOrderByNamaBioskopAsc();
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop) {
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if (bioskop.isPresent()) {
            return bioskop.get();
        }
        return null;
    }
}