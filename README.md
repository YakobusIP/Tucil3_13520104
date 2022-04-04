# Tugas-Kecil-Stima-3-15-Puzzle-Problem
## General Information 
Program untuk menemukan solusi dari sebuah matriks permainan 15-Puzzle-Problem menggunakan algoritma Branch and Bound. Program akan menggunakan matriks awal sebagai sebuah e-node dan mencari anak - anaknya. Simpul anak yang dijadikan e-node selanjutnya adalah simpul yang memiliki cost paling kecil. Apabila solusi telah ditemukan, maka program akan mencetak urutan arah yang digunakan untuk mencapai simpul solusi tersebut.

## Setup
Untuk Windows Operating System
1. Jalan file **15-Puzzle-Problem** yang terdapat di folder bin
2. Apabila file tersebut tidak terbuka, jalankan file **run.bat** yang terdapat di folder bin.
3. Ketika GUI sudah terbuka, masukkan matriks awal sesuai keinginan pengguna, bisa menggunakan input secara langsung, menggunakan input dari file, atau membuat matriks random dari program.
4. Tekan tombol start ketika input sudah dimasukkan.
5. Tekan tombol reset apabila ingin mengganti metode input matriks.
6. Apabila ingin menggunakan input matriks dari sebuah file, maka file tersebut harus berisi matriks saja.
Contoh isi file input matriks:
```
1 2 3 4
5 6 0 8
9 10 7 11
13 14 15 12
```

Catatan: Apabila program terlihat stuck atau not responding, maka program sedang melakukan looping algoritma branch and bound. Untuk menghentikan looping, silahkan *end task* di task manager atau tekan CTRL + C di command prompt yang terbuka.

## Created by:
Yakobus Iryanto Prasethio (13520104)