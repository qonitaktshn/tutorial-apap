# Tutorial APAP
## Authors
* **Qonita Nur Iffat** - *1906307233* - *APAP-C*

---
## Tutorial 5
1. Apa itu Postman? Apa kegunaannya?
**jawab: **
Postman merupakan suatu aplikasi yang berupa plugin untuk membagikan, membuat, serta melakukan uji coba REST API. Dengan menggunakan aplikasi ini, developer akan mudah dalam membuat serta melakukan penyimpanan request HTTP/s yang mana Postman juga akan menampilkan response dari request tersebut. Postman dapat membantu developer dalam mengembangkan APIs dengan cara yang lebih mudah dan efisien serta untuk menguji API yang telah mereka buat.
    
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
**jawab: **
@JsonIgnoreProperties memiliki fungsi untuk mengabaikan properti logika yang ditentukan dalam serialisasi dan deserialisasi JSON yang dianotasi di class. @JsonIgnoreProperties memiliki elemen yaitu allowGetters, allowSetters, ignoreUnknown dan value. Fungsi dari value element adalah untuk menentukan mana properti yang akan diabaikan.  @JsonProperty nemiliki kegunaan untuk menandai metode pengambil ataupun penyetel non-standar yang akan digunakan sehubungan dengan properti json.

3. Apa kegunaan atribut WebClient?
**jawab: **
webClient berguna sebagai fondasi dan poin akses utama untuk API yang akan digunakan dengan aturan-aturan yang ada di API tersebut dimana webClient akan memberikan verifikasi req URI dengan objeck mock yang mana atribut tersebut merupakan interface yang dimiliki oleh Spring.

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
**jawab: **
ResponseEntity memiliki maksud untuk mewakili seluruh respons HTTP. Melalui ResponseEntity maka kita dapat melakukan kontrol apa pun yang masuk ke dalamnya seperti kode status, header, dan body. Tujuan utama ResponseEntity yaitu untuk menyediakan Lokasi ke sumber daya yang diubah. BindingResult menyimpan hasil validasi dan pengikatan serta berisi kesalahan yang mungkin telah terjadi. BindingResult harus muncul tepat setelah objek model yang divalidasi atau Spring gagal untuk memvalidasi objek tersebut dan melontarkan pengecualian.

## Tutorial 4
1. Jelaskan perbedaan th:include dan th:replace!
    Perbedaan dari th:include dan th:replace terletak pada penggunaan tag thymleaf. Pada th:include memiliki fungsi untuk memasukkan fragment yang telah ditentukan sebagai badan tag-hostnya, namun mengecualikasi tag fragmentnya. Sedangkan, th:replace memiliki fungsi untuk menggantikan tag host dengan fragment dimanakan hal ini menandakan bahwa akan dilakukan penghapusan pada tag host dan menggantikan tag host dengan melakukan penambahan fragment beserta dengan tag fragmentnya.

2. Jelaskan apa fungsi dari th:object!
    th:object merupakan tag thymleaf yang memiliki fungsi untuk melakukan pengiriman data dari suatu form yang dikirimkan dari view, kemudian data tersebut akan diterima oleh controller. Selain itu, tag dari th:object juga memiliki dapat mendefinisikan sesuatu menjadi suatu objek.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
    Perbedaan * dan $ ketika penggunaan th:object adalah ketika kita menggunakan * artinya kita ingin mengevaluasi suatu variabel dari th:object yang telah dideklarasi sebelumnya. Sedangkan apabila kita menggunakan $ artinya ketika akan dilakukannya suatu pengevaluasian keseluruhan variable atau atribut pada th:object.

## Tutorial 3
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
- @AllArgsConstructor: Anotasi ini memiliki fungsi untuk melakukan generate constructor hanya dengan satu parameter di dalam suatu class. Apabila terdapat @NotNull maka field tersebut akan memeriksa null pada parameternya.
- @NoArgsConstructor: Anotasi ini memiliki fungsi untuk melakukan generate constructor dengan tidak adanya parameter, lalu akan mengeluarkan suatu error berupa pesan error apabila terdapat constructor yang tidak dapat dibuat.
- @Setter: Anotasi ini memiliki fungsi untuk melakukan generate setter secara otomatis.
- @Getter: Anotasi ini memiliki fungsi untuk melakukan generate getter secara otomatis.
- @Entity: Anotasi ini memiliki fungsi bahwa suatu class tersebut akan terdefinisikan sebagai suatu entity pada database.
- @Table: Anotasi ini memiliki fungsi untuk melakukan penamaan tabel yang akan tersimpan pada suatu database.

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method tersebut?
                method finByNoBioskop adalah suatu method dimana method tersebut digunakan untuk mengambil sebuah entity dari bioskop dengan no-nya dan itu tersedia pada CrudRepository interface. Apabila kita memanggil method iniDengan menggunakan method ini, maka kita akan mendapatkan suatu entity berdasarkan no.
        
        sumber: https://www.netsurfingzone.com/jpa/spring-data-jpa-crudrepository-finbyid/
        
3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
           Anotasi dari @Jointable akan digunakan ketika kita memiliki dua buah entity yang saling berhubungan dengan tabel yang berbeda dan ingin menyimpin id dari kedua entity tersebut ke dalam tabel yang terpisah. @JoinTable digunakan ketika kita ingin mengelola hubungan antar entity dari tabel lain. Sedangkan, @JoinColum menyimpan suatu id dari entity lain pada kolom baru di tabel yang sama. Anotasi ini digunakan apabila entity memiliki hubungan langsung seperti foreign key antar keduanya.

4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull
            name pada anotasi @JoinColumn pada atribut bioskop memiliki fungsi untuk memeberi nama kolom pada tabel tertentu, referencedColumnName sendiri berfungsi untuk merujuk nama dari kolom pada suatu tabel. Lalu, fungsi dari nullable dalam anotasi agar tidak ada penyimpanan null pada database. Perbedaanya adalah NotNull tidak dapat mengeluarkan null, sedangkan nullable dapat mengeluarkan null.
    
    sumber: https://thorben-janssen.com/hibernate-tips-whats-the-difference-between-column-nullable-false-and-notnull/#:~:text=The%20%40NotNull%20annotation%20triggers%20a,persist%20lifecycle%20event%20gets%20triggered.&text=The%20%40Column(nullable%20%3D%20false,t%20generate%20the%20table%20definition.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
                FetchType hibernate sendiri memiliki kegunaan yaitu untuk melakukan penentuan apakah seluruh collection object (child) tersebut di-load atau tidak sesaat setelah object parent di-fetch. *FetchType.LAZY* memiliki fungsi untuk *tidak* melakukan load semua collection object (child) saat object parent di-fetch. Per-load-an collection object (child) tersebut hanya dilakukan ketika secara ekspklisit dibutuhkan oleh getter method. Default fetching dari strateginya adalah @OneToMany dan @ManyToMany. Berbeda dengan *FetchType.EAGER* yang akan melakukan load pada semua collection object (child) sesaat setelah object parent di-fetch. Default fetching strateginya adalah @OneToOne dan @ManyToOne. Sedangkan yang terakhir, CascadeType.ALL berarti seluruh kegiatan operasi seperti uodate, delete, ataupun operasi data lainnya akan berpengaruh kepada suatu entity.
        
        sumber: https://7seasons.wordpress.com/2013/12/27/fetchtype-lazy-dan-eager-pada hibernate/#:~:text=FetchType%20pada%20Hibernate%20berfungsi%20untuk,FetchType

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
![Tampilan setelah menambahkan](https://github.com/qonitaktshn/tutorial-apap/blob/feat/tutorial-2-21cineplux/Picture/Add.jpg)

Tampilan mengakses viewall:
![Tampilan pada viewall](https://github.com/qonitaktshn/tutorial-apap/blob/feat/tutorial-2-21cineplux/Picture/view.jpg)

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
