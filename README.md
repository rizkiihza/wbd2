# Tugas 2 IF3110 Pengembangan Aplikasi Berbasis Web

### Penjelasan
Basis data yang digunakan ada dua, yaitu basis data account yang digunakan pada identity service dan basis data ojek yang digunakan pad fitur lain.

Konsep shared session dengan menggunakan REST:

Setelah user berhasil login dengan username dan password yang tervalidasi, akan dibuat sebuah session id yang menyimpan id user yang sedang login, dan session token yang menyimpan token untuk user tersebut.
Sehingga fitur lain dapat mengakses session tersebut.

Pembangkitan token dan expire time pada sistem yang anda buat :
Token digenerate secara random setelah user berhasil login, dengga lama expire timenya default.

Kelebihan dari arsitektur aplikasi tugas ini :
1. Tidak perlu dilakukan pengecakan user setiap kali mengakses page berbeda. Karena adanya token.
2. Kemudahan dalam administrasi, tidak repot dalam pengambilan id dari user ketika sedang berada di page lain.

kelemahan dari arsitektur aplikasi tugas ini :
1. Cukup sulit dalam implementasinya.
2. Ketika sistem diserang, akan sangat mudah mengakses keseluruhan sisten web, dikarenakan hanya perlu 1 token dalam mengakses keseluruhannya.

### Pembagian Tugas

REST :
1. Generate token : 13515083
2. Validasi token : 13515104, 13515041
3. Login, Register : 13515083

SOAP :
Keseluruhan SOAP dibuat bersama tergantung kebutuhan dalam pembuatan web app.

Web app (JSP) :
1. Order : 13515041
2. Profile : 13515104
3. History : 13515083


Ade | Johan | Kristianto | Micky | Michael | Rangga | Raudi | Robert | Sashi 

Dosen : Yudistira Dwi Wardhana | Riza Satria Perdana | Muhammad Zuhri Catur Candra