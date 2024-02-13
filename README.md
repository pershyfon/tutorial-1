Nama: Sabrina Aviana Dewi | NPM: 2206030520
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