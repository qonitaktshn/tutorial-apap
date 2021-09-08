# Tutorial APAP
## Authors
* **Qonita Nur Iffat** - *1906307233* - *APAP-C*

---
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
