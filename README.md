Nama: Sabrina Aviana Dewi
NPM: 2206030520

## Reflection 1
Setelah mempelajari tentang clean code & secure coding, saya memahami ada beberapa praktik yang dapat diaplikasikan pada kode saya, yaitu:
1. **Nama variabel yang padat dan jelas maknanya.** 

    Pada prinsip clean code, hal ini dilakukan untuk meningkatkan *readability* kode tanpa menggunakan komen.
2. ***Break down* kode menjadi fungsi-fungsi kecil.**

    Setiap fungsi yang telah dipecah kecil menjalankan 1 tugas saja. Hal ini supaya mudah dikelola dan meningkatkan modularitas.
3. **Nama fungsi yang padat dan deskriptif.**

    Nama fungsi harus menjelaskan fungsi yang dilakukannya. Namun, tetap padat dan jelas. Jangan sampai terlalu panjang.

## Reflection 2
1. Setelah membuat unit test, saya makin merasa yakin bahwa kode saya berjalan baik. Tidak ada jumlah pasti berapa unit test yang harus dibuat dalam satu *class*  namun, minimal sejumlah *method* yang ada dalam kelas tersebut. Cara untuk memastikan bahwa unit test kita cukup untuk memverifikasi program adalah unit test harus memverifikasi apa yang dapat dilakukan *method*/unit tersebut beserta keterbatasannya. Juga bisa dengan menerapkan code coverage. Namun, code coverage 100% juga belum memastikan tidak ada error/bug.
2. Duplikasi sebagian kode yang berisi prosedur persiapan & variabel dari kedua tes akan menurunkan kualitas *clean code*. Namun, pemisahan fungsionalitas tes tetap harus dilakukan untuk kemudahan mendiagnosis error. Untuk itu, solusinya adalah dengan membuat fungsi terpisah untuk bagian yang sama persis, dilanjutkan dengan 2 fungsi berbeda yang memverifikasi produk & jumlah produk.