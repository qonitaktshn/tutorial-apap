package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import apap.tutorial.cineplux.rest.AgePenjaga;
import apap.tutorial.cineplux.rest.BioskopDetail;
import apap.tutorial.cineplux.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PenjagaRestServiceImpl implements PenjagaRestService{
    private final WebClient webClient;

    @Autowired
    private PenjagaDB penjagaDB;

    @Override
    public PenjagaModel createPenjaga(PenjagaModel penjaga) {
        return penjagaDB.save(penjaga);
    }

    @Override
    public List<PenjagaModel> retrieveListPenjaga() {
        return penjagaDB.findAll();
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);

        if(penjaga.isPresent()) {
            return penjaga.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);

        if((now.isBefore(penjaga.getBioskop().getWaktuBuka()) || now.isAfter(penjaga.getBioskop().getWaktuTutup()))) {
            penjaga.setNamaPenjaga(penjagaUpdate.getNamaPenjaga());
            penjaga.setJenisKelamin(penjagaUpdate.getJenisKelamin());
            penjaga.setBioskop(penjagaUpdate.getBioskop());

            return penjagaDB.save(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still open!");
        }

    }

    @Override
    public void deletePenjaga(Long noPenjaga) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);

        if((now.isBefore(penjaga.getBioskop().getWaktuBuka()) || now.isAfter(penjaga.getBioskop().getWaktuTutup()))) {
            penjagaDB.delete(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still open!");
        }
    }

    public PenjagaRestServiceImpl(WebClient.Builder webclientBuilder){
        this.webClient = webclientBuilder.baseUrl("https://api.agify.io").build();
    }

    @Override
    public PenjagaModel agePredictionPenjaga(Long noPenjaga) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        String namaPenjaga = penjaga.getNamaPenjaga();
        if (namaPenjaga.length() > 1) {
            String[] namaDepan = namaPenjaga.split(" ");
            namaPenjaga = namaDepan[0];
        }

        if((now.isBefore(penjaga.getBioskop().getWaktuBuka()) || now.isAfter(penjaga.getBioskop().getWaktuTutup()))) {
            Mono<AgePenjaga> penjagaUmur = this.webClient.get().uri("?name=" + namaPenjaga).retrieve().bodyToMono(AgePenjaga.class);
            penjaga.setUmur(penjagaUmur.block().getUmur());
            penjagaDB.save(penjaga);
            return penjaga;
        } else {
            throw new UnsupportedOperationException("Bioskop still open!");
        }
    }
}
