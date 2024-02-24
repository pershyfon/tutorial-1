Nama: Sabrina Aviana Dewi | NPM: 2206030520
# Tutorial 3
### Reflection
1. Explain what principles you apply to your project!
- Single Responsibility Principle (SRP)

    SRP adalah aturan memisahkan file berdasarkan tanggung jawab. Maka untuk memgimplementasikannya, saya memisahkan file CarController dengan ProductController agar tiap file fokus pada tanggung jawabnya masing-masing terhadap model yang berbeda. Selain itu, saya juga mengubah set id di method createCar menjadi di constructor Car() agar pada createCar(Car car) yang mana sudah terbentuk object Car, tidak perlu set id lagi, melainkan hanya tinggal memasukkan ke list. Hal ini merupakan bentuk pemisahan tanggung jawab.
- Open-Closed Principle (OCP)

    OCP adalah aturan membuka perluasan kode namun tertutup untuk modifikasi. Saya sudah mengimplementasikannya dengan mengeset id pada constructor yang membuat class Car terbuka untuk extension, namun jika ingin perubahan pada cara set id, tidak perlu mengubah source code. Selain itu , menerapkan method update yang mengubah Car tidak per-atribut melainkan langsung mengubah objectnya juga membuat kelas CarRepository lebih terbuka pada extension, namun tidak perlu mengubah source code.
- Liskov Substitution Principle (LSP)

    LSP adalah aturan bahwa apabila suatu subclass inherit suatu superclass, maka diharapkan subclass tersebut memiliki behaviour yang serupa dengan superclassnya. Sebelumnya CarController extends ProductController, padahal sifat keduanya sangat berbeda. Meskipun CarController sepenuhnya menuruni method ProductController, namun karena model yang digunakan berbeda keduanya ini menjadi tidak berhubungan. Untuk itu, tidak diperlukan inheritance. Saya membuat CarController tidak lagi meng-extend ProductController agar yang implementasi service dapat menggantikan interface service-nya dan LSP telah terimplementasi.
- Interface Segregation Principle (ISP)

    ISP adalah aturan membagi interface menjadi interface yang lebih kecil dan spesifik terhadap suatu kebutuhan. Saya telah mengimplementasikan ISP dengan membuat dua interface berbeda untuk kebutuhan yang berbeda, yaitu CarService dan ProductService.
- Dependency Inversions Principle (DIP)

    DIP adalah aturan bahwa kode seharusnya bergantung pada kelas abstrak atau interface, bukan pada implementasi konkritannya. Saya telah mengimplementasikan DIP dengan mengubah import CarServiceImpl menjadi CarService pada CarController agar kode tidak bergantung pada kelas konkritnya. 
2. Explain the advantages of applying SOLID principles to your project with examples. 

    Prinsip SOLID dapat meningkatkan maintainability dan keterbacaan kode. Dengan memisahkan tanggung jawab ke dalam kelas-kelas yang berbeda dan mematuhi SRP, setiap kelas menjadi lebih fokus dan lebih mudah dipahami. Ini memudahkan pemeliharaan kode karena perubahan hanya perlu dilakukan di satu tempat yang sesuai dengan tanggung jawab kelas tersebut. Dengan menerapkan OCP, kita dapat menambahkan fitur baru atau mengubah perilaku tanpa mengganggu kode yang sudah ada dan mengurangi risiko terhadap efek samping. Dengan mematuhi LSP, kode lebih mudah dipahami dan digunakan oleh pengguna lain tanpa kejutan atau perilaku yang tidak diharapkan. Dengan ISP, mengurangi ketergantungan antarkelas. Dengan DIP, memudahkan pergantian implementasi tanpa harus mengubah banyak kode dan perubahan pada satu bagian kode tidak merusak pengerjaan kode lain.

    Contoh: 
    
    - Memisahkan CarController dengan ProductController membuat masing-masing tanggung jawab tidak tercampur dan memudahkan maintainability kode jika memerlukan pekerjaan pada hanya salah satu tanggung jawab.
    - Menggunakan interface CarService dan ProductService daripada implementasi konkritnya membuat kita tidak perlu mengubah controller lagi jika membuat implementasi baru seperti BetterCarServiceImpl.


3. Explain the disadvantages of not applying SOLID principles to your project with examples.
    - Jika tidak menerapkan OCP dan DIP, ketergantungan antarkelas akan membuat kode sulit untuk diuji dan sulit melakukan perubahan karena akan banyak bagian yang perlu diperhatikan untuk diganti.
    - Jika tidak menerapkan SRP, mengurangi tingkat keterbacaan kode dan jika dilakukan perubahan/testing pada satu tanggung jawab, perlu memperhatikan kode tanggung jawab yang lain juga.
    - Jika tidak menerapkan LSP dan ISP, meningkatkan ketergantungan tidak penting, mempersulit keterbacaan kode, dan mengurangi fleksibilitas kode terhadap perubahan dan penambahan.
   
# Tutorial 2
### Reflection
1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.

   - **Unnecessary Imports**. Statement import yang bisa dihapus, baik karena tidak digunakan, terduplikat, maupun secara implisit sudah tercakup dalam package.
   
      Strategi: Menghapus baris-baris import yang tidak digunakan dan mengganti import yang menggunakan star (*) dengan import satu-satu bagian dari package yang dibutuhkan.
   - **Unecessary Modifier**. Field di interface dan annotation akan otomatis *public static final* dan methodnya *public abstract*. Tidak memerlukan modifier lagi.

      Strategi: Menghapus modifier pada method-method di ProductService.java
2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
   
   Menurut saya, workflow yang sekarang sudah menerapkan CI/CD. Karena workflow `ci.yml` sudah otomatis running test case setiap kali `push` dari branch mana pun, yang mana berarti sudah menerapkan continuous integration (CI). Deployment saya menggunakan Koyeb yang juga sudah otomatis re-deploy setiap ada perubahan pada branch `master` repo, yang mana berarti telah menerapkan continuous deployment (CD).


# Tutorial 1
### Reflection 1
Setelah mempelajari tentang clean code & secure coding, saya memahami ada beberapa praktik yang dapat diaplikasikan pada kode saya, yaitu:
1. **Nama variabel yang padat dan jelas maknanya.** 

    Pada prinsip clean code, hal ini dilakukan untuk meningkatkan *readability* kode tanpa menggunakan komen.
2. ***Break down* kode menjadi fungsi-fungsi kecil.**

    Setiap fungsi yang telah dipecah kecil menjalankan 1 tugas saja. Hal ini supaya mudah dikelola dan meningkatkan modularitas.
3. **Nama fungsi yang padat dan deskriptif.**

    Nama fungsi harus menjelaskan fungsi yang dilakukannya. Namun, tetap padat dan jelas. Jangan sampai terlalu panjang.
### Reflection 2
1. Setelah membuat unit test, saya makin merasa yakin bahwa kode saya berjalan baik. Tidak ada jumlah pasti berapa unit test yang harus dibuat dalam satu *class*  namun, minimal sejumlah *method* yang ada dalam kelas tersebut. Cara untuk memastikan bahwa unit test kita cukup untuk memverifikasi program adalah unit test harus memverifikasi apa yang dapat dilakukan *method*/unit tersebut beserta keterbatasannya. Juga bisa dengan menerapkan code coverage. Namun, code coverage 100% juga belum memastikan tidak ada error/bug.
2. Duplikasi sebagian kode yang berisi prosedur persiapan & variabel dari kedua tes akan menurunkan kualitas *clean code*. Namun, pemisahan fungsionalitas tes tetap harus dilakukan untuk kemudahan mendiagnosis error. Untuk itu, solusinya adalah dengan membuat fungsi terpisah untuk bagian yang sama persis, dilanjutkan dengan 2 fungsi berbeda yang memverifikasi produk & jumlah produk.