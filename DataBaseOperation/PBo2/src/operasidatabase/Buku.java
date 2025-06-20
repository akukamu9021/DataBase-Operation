/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operasidatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author USER90
 */
public class Buku {
    String sql;
   String url = "jdbc:mysql://localhost:3306/perpustakaan";
   String user = "root";
   String pass = "";
   Connection koneksi;

   public Buku() {
   }

   public Connection getConnection() throws SQLException {
      return DriverManager.getConnection(this.url, this.user, this.pass);
   }

   public void readBuku() {
      this.sql = "SELECT * FROM buku";

      try {
         this.koneksi = this.getConnection();
         Statement st = this.koneksi.createStatement();
         ResultSet rs = st.executeQuery(this.sql);

         while(rs.next()) {
            System.out.print(rs.getInt("id_buku") + " | ");
            System.out.print(rs.getString("judul") + " | ");
            System.out.print(rs.getString("pengarang") + " | ");
            System.out.print(rs.getInt("tahun_terbit") + " | ");
            System.out.print(rs.getInt("jumlah") + "\n");
         }
      } catch (SQLException var3) {
         var3.printStackTrace();
      }

   }

   public void insertBuku(String judul, String pengarang, int tahunTerbit, int jumlah) {
      this.sql = "INSERT INTO buku (judul, pengarang, tahun_terbit, jumlah) VALUES (?, ?, ?, ?)";

      try {
         this.koneksi = this.getConnection();
         PreparedStatement ps = this.koneksi.prepareStatement(this.sql);
         ps.setString(1, judul);
         ps.setString(2, pengarang);
         ps.setInt(3, tahunTerbit);
         ps.setInt(4, jumlah);
         int result = ps.executeUpdate();
         if (result > 0) {
            System.out.println("Data buku berhasil ditambahkan.");
         } else {
            System.out.println("Data buku gagal ditambahkan.");
         }
      } catch (SQLException var7) {
         var7.printStackTrace();
      }

   }
}
