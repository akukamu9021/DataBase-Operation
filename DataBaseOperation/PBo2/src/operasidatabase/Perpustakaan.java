/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operasidatabase;
import java.util.Scanner;
/**
 *
 * @author USER90
 */
public class Perpustakaan {
    public Perpustakaan() {
   }

   public static void main(String[] args) throws Throwable {
      Scanner scanner = new Scanner(System.in);
      BukuDao dao = new BukuDao();

      int pilihan;
      do {
         System.out.println("\n=== MENU OPERASI DATABASE BUKU ===");
         System.out.println("1. Tampilkan Data Buku");
         System.out.println("2. Input Data Buku");
         System.out.println("3. Cari Data Buku");
         System.out.println("4. Ubah Data Buku");
         System.out.println("5. Hapus Data Buku");
         System.out.println("6. Keluar");
         System.out.print("Pilih menu [1-6]: ");

         while(!scanner.hasNextInt()) {
            System.out.print("Input harus angka 1‑6, ulangi: ");
            scanner.next();
         }

         pilihan = scanner.nextInt();
         scanner.nextLine();
         String judul;
         String pengarang;
         int tahun;
         int jumlah;
         switch (pilihan) {
            case 1:
               System.out.println("\n== Daftar Buku ==");
               dao.readBuku();
               break;
            case 2:
               System.out.println("\n== Input Data Buku Baru ==");
               System.out.print("Judul: ");
               judul = scanner.nextLine();
               System.out.print("Pengarang: ");
               pengarang = scanner.nextLine();
               System.out.print("Tahun Terbit: ");
               tahun = scanner.nextInt();
               System.out.print("Jumlah Eksemplar: ");
               jumlah = scanner.nextInt();
               scanner.nextLine();
               dao.insertBuku(judul, pengarang, tahun, jumlah);
               break;
            case 3:
               System.out.println("\n== Cari Buku ==");
               System.out.print("Masukkan ID Buku: ");
               int idCari = scanner.nextInt();
               scanner.nextLine();
               if (dao.findBukuById(idCari)) {
                  System.out.println("Buku dengan ID " + idCari + " ditemukan.");
               } else {
                  System.out.println("Buku tidak ditemukan.");
               }
               break;
            case 4:
               System.out.println("\n== Ubah Data Buku ==");
               System.out.print("Masukkan ID Buku: ");
               int idUbah = scanner.nextInt();
               scanner.nextLine();
               if (!dao.findBukuById(idUbah)) {
                  System.out.println("ID tidak ditemukan.");
               } else {
                  System.out.print("Judul Baru: ");
                  judul = scanner.nextLine();
                  System.out.print("Pengarang Baru: ");
                  pengarang = scanner.nextLine();
                  System.out.print("Tahun Terbit Baru: ");
                  tahun = scanner.nextInt();
                  System.out.print("Jumlah Baru: ");
                  jumlah = scanner.nextInt();
                  scanner.nextLine();
                  dao.updateBuku(idUbah, judul, pengarang, tahun, jumlah);
               }
               break;
            case 5:
               System.out.println("\n== Hapus Buku ==");
               System.out.print("Masukkan ID Buku: ");
               int idHapus = scanner.nextInt();
               scanner.nextLine();
               if (!dao.findBukuById(idHapus)) {
                  System.out.println("ID tidak ditemukan.");
               } else {
                  dao.deleteBuku(idHapus);
               }
               break;
            case 6:
               System.out.println("Keluar dari program…");
               break;
            default:
               System.out.println("Pilihan tidak valid.");
         }
      } while(pilihan != 6);

      scanner.close();
   }
}


