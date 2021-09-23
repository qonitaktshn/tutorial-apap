package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

import java.util.List;

public interface PenjagaService {
    void addPenjaga(PenjagaModel penjaga);

    // Method untuk mengupdate bioskop
    boolean updatePenjaga(PenjagaModel penjaga);

    // Method untuk mendapatkan data sebuah Bioskop berdasarkan idnya
    PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga);

    // Method untuk mendapatkan daftar penjaga yang telah tersimpan
    List<PenjagaModel> getPenjagaList();

    // Method untuk menghapus penjaga
    boolean deletePenjaga(PenjagaModel penjaga, Long noPenjaga);

}
