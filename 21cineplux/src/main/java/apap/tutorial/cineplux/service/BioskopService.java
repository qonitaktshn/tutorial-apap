package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;

import java.util.List;

public interface BioskopService {
    // Method untuk menambah Bioskop
    void addBioskop(BioskopModel bioskop);

    // Method untuk mengupdate bioskop
    void updateBioskop(BioskopModel bioskop);

    // Method untuk mendapatkan daftar Bioskop yang telah tersimpan
    List<BioskopModel> getBioskopList();

    // Method untuk mendapatkan data sebuah Bioskop berdasarkan idnya
    BioskopModel getBioskopByNoBioskop(Long noBioskop);

    // Method untuk mendapatkan daftar bioskop yang terurut berdasarkan nama
    List<BioskopModel> findAllBioskopOrderBynamaBioskopAsc();

    // Method untuk menghapus bioskop
    boolean deleteBioskop(BioskopModel bioskop, Long noBioskop);
}