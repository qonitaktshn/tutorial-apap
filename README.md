# Tutorial APAP
## Authors
* **Qonita Nur Iffat** - *1906307233* - *APAP-C*

---
## Tutorial 2
1. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi!
Ketika saya membuka link tersebut, page yang muncul adalah whitelable error page. template might not exist. Hal ini dikarenakan belum dibuatnya template yang direturn oleh controller yaitu "add-bioskop". Controller ini berfungsi untuk mengatur logic dan route api dimana controller akan memanggil template HTML. apabila template tersebut tidak ada maka respon yang diberikan adalah error tersebut.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.
Menurut saya, anotasi @Autowired pada class Controller digunakan agar constructor, setter method, getter method tidak perlu lagi untuk dibuat. Seluruh field atau property akan diisikan oleh Spring dengan object yang sesuai dengan tipe datanya. anotasi @Autowired pada class Controller merupakan suatu pengimplementasian dari konsep dependancy injection yang mana anotasi @Autowired pada class Controller tersebut dapat memasukkan dependensi objek secara implisit. Pada tutorial 2 kali ini, pengimplementasian tersebut ada pada controller untuk service.

3. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Ketika saya membuka link tersebut, tampilan yang muncul adalah Whitelabel Error Page. There was an unexpected error (type=Bad Request, status=400). Required request parameter 'jumlahStudio' for method parameter type int is not present. Hal ini terjadi dikarenakan tidak adanya jumlahStudio pada link tersebut, sehingga link tersebut memberikan parameter yang kosong. Padahal, jumlahStudio adalah parameter yang wajib diisi.

4. Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?
Pada tutorial kali ini, saya menambahkan bioskop dengan nama Bioskop Maung dengan idBioskop 10. Saya melakukan penambahan pada link:
http://localhost:8080/bioskop/add?idBioskop=10&namaBioskop=Bioskop%20Maung&alamat=Maung%20Fasilkom&noTelepon=081xxx&jumlahStudio=10

    Link yang harus diakses untuk melihat Bioskop dengan nama Bioskop maung, yaitu:
    http://localhost:8080/bioskop/view?idBioskop=10

5. Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Saya menambahkan bioskon dengan idBioskop 50 menggunakan link berikut:
http://localhost:8080/bioskop/add?idBioskop=50&namaBioskop=Bioskop%20Qwonz&alamat=Qwonz%20Fasilkom&noTelepon=081xxx&jumlahStudio=10
Tampilan: 
![Tampilan setelah menambahkan](https://ibb.co/BnpDNTQ)

Tampilan mengakses viewall:
![Tampilan pada viewall](https://ibb.co/8sXVGKv)

## Tutorial 1

### What I have learned today
Pada tutorial 1 ini, saya belajar banyak terkait bagaimana cara menggunakan Github dan Springboot. Mulai dari setup awal hingga membuat suatu website meskipun hanya dapat dibuka melalui localhost. Saya juga mengetahui bagaimana menggunakan @RequestParam dan @PathVarianle.

### Github

1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue tracker merupakan suatu software yang memungkinkan untuk melakukan pencatatan masalah ataupun bug serta melacak masalah tersebut hingga dapat diselesaikan. Masalah yang dapat diselesaikan diantaranya: pengembangan ide, elemen yang dirasa membuat pelanggan tidak nyaman, error dalam fitur, pull request, dan lainnya.

    source:
    https://www.zendesk.com/blog/issue-tracker/
    https://monday.com/blog/project-management/issue-tracker/

2. Apa perbedaan dari git merge dan git merge --squash?
Perbedaan dari git merge dan git meger --squash yaitu melayani tujuan yang berbeda. Apabila kita melakukan git merge maka dapat dilakukan penggabungan dari semua commit pada branch sumber dengan melakukan commit pada branch yang ingin dituju yang menghasilkan penggabungan pada branch serta pada master. Berbeda dengan git merge --squash, hasil dari penggabungan hanya akan menghasilkan satu commit pada branch yang dituju dengan semua perubahan yang telah tergabung menjadi satu.

    source:
    https://devblogs.microsoft.com/devops/squash-a-whole-new-way-to-merge-pull-requests/
    https://www.it-swarm-id.com/id/git/dalam-git-apa-perbedaan-antara-menggabungkan-squash-dan-rebase/968059910/

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?
Version control system merupakan tools yang cukup penting untuk digunakan oleh software engineer. Hal ini dikarenakan VCS merupakan kumpulan dari perangkat lunak yang telah terintegrasi yang dapat mengelola perubahan kode seiring berjalannya waktu. Sistem ini akan menyimpan file sehingga mampu melacak setiap perubahan kode yang telah dilakukan. Git sebagai VCS sangat berguna untuk menangani multiple local branches yang memungkinkan software engineer dapat memiliki versi kode yang berbeda secara bersamaan dan dapat dipilih untuk dibagikan.

    source:
    https://glints.com/id/lowongan/version-control-system/#.YTjOuZ0zaHt
    https://www.seguetech.com/a-review-of-software-version-control-systems-benefits-and-why-it-matters/#:~:text=Git%20is%20especially%20useful%20for,later%20to%20merge%20the%20versions.

### Spring

4. Apa itu library & dependency?
Library merupakan kumpulan dari kode yang telah disediakan oleh framework yang akan kita gunakan. Kumpulan kode tersebut biasanya berada dalam package atau tempat lain sesuai dengan bahasa yang digunakan dimana kode tersebut akan dapat membantu user sehingga apabila user ingin menggunakan dapat langsung di import. Sedangkan dependency sendiri merupakan gambaran dari ketergantungan suatu program dengan program lainnya yang membuat program tersebut dapat bekerja. Sehingga, depedency ini dapat digunakan sesuai dengan kebutuhan program yang akan dibuat.

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven merupakan Java Build Tools yang menggunakan konsep dari Project Object Model atau biasa disingkat dengan POM, dimana POM itu sendiri memiliki informasi serta konfigurasi yang akan digunakan oleh Maven untuk membuat suatu project. Maven biasa digunakan untuk mempermudah pengelolaan dan pembangunan suatu project serta dependency dan dokumentasinya. Penggunaan maven dikarenakan mavem dapat melakukan penambahan pada semua dependencies yang dibutuhkan secara otomatis dengan membaca POM file, serta terdapat kemudahan dalam penambahan dependency yang hanya dilakukan dengan cara menuliskan kode pada POM. Terdapat alternatif lain dari Maven adalah Gradle, CMake, dan Jenkins.

    source:
    https://medium.com/@acep.abdurohman90/mengenal-maven-sebagai-java-build-tools-5ba752f75812

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
Selain untuk melakukan pengembangan web, Spring dapat digunakan untuk fasilitas mailing, membuat aplikasi enterprise, adanya beragam posi untuk melakukan pengaturan data ke database, serta dapat digunakan untuk membuat mobile app.

    source:
    https://socs.binus.ac.id/2017/10/04/framework-spring-java/

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
@RequestParam digunakan untuk parameter kueri GET yang mana @RequestParam akan mengekstrak nilai dari string kueri yang dapat digunakan untuk melakukan fitering, sorting, dan pagination, sedangkan @PathVariable digunakan untuk bagian jalur dimana @PathVariable akan mengestrak nilai URI Path dalam variable Path yang nilainya tidak dapat dikodekan. Sehingga, @RequestParam akan lebih baik digunakan apabila kita ingin memberikan nilai yang statis. Sebaliknya, apabila kita ingin menggunakan nilai yang dinamis maka lebih baik menggunakan @PathVariable.

    source:
    https://edupro.id/questions/3370312/perbedaan-antara-pathvariable-requestparam-dan-requestbody

### What I did not understand

- [ ] Apabila terdapat error, saya masih bingung untuk menyelesaikannya.
- [ ] Fungsi yang ada pada Spring masih belum saya pahami lebih dalam.
- [ ] Saya masih bingung terkait alur pengerjaan Spring dan github dikarenakan kedua hal tersebut masih baru menurut saya.
