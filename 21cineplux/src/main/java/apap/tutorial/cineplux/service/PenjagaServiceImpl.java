package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PenjagaServiceImpl implements PenjagaService {

    @Autowired
    PenjagaDB penjagaDB;

    @Override
    public void addPenjaga(PenjagaModel penjaga) {
        penjagaDB.save(penjaga);
    }

    @Override
    public boolean updatePenjaga(PenjagaModel penjaga) {
        LocalTime currentTime = LocalTime.now();
        LocalTime closeTime = penjaga.getBioskop().getWaktuTutup();
        LocalTime openTime = penjaga.getBioskop().getWaktuBuka();
        boolean time = true;
        if (currentTime.isAfter(closeTime) || currentTime.isBefore(openTime) ) {
            penjagaDB.save(penjaga);
        }
        else {
            time = false;
        }
        return time;
    }

    @Override
    public List<PenjagaModel> getPenjagaList() { return penjagaDB.findAll(); }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);
        if (penjaga.isPresent()) {
            return penjaga.get();
        }
        return null;
    }

    @Override
    public boolean deletePenjaga(PenjagaModel penjaga, Long noPenjaga) {
        LocalTime currentTime = LocalTime.now();
        LocalTime closeTime = penjaga.getBioskop().getWaktuTutup();
        LocalTime openTime = penjaga.getBioskop().getWaktuBuka();
        boolean time = true;
        if (currentTime.isAfter(closeTime) || currentTime.isBefore(openTime) ) {
            penjagaDB.deleteById(noPenjaga);
        }
        else {
            time = false;
        }
        return time;
    }
}