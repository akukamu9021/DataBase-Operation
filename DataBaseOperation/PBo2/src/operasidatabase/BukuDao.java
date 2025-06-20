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
public class BukuDao {
   private static final String URL = "jdbc:mysql://localhost:3306/perpustakaan";
   private static final String USER = "root";
   private static final String PASS = "";

   BukuDao() {
   }

   private Connection getConnection() throws SQLException {
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/perpustakaan", "root", "");
   }

   public void readBuku() throws Throwable {
      String sql = "SELECT * FROM buku";

      try {
         Throwable var2 = null;
         Object var3 = null;

         try {
            Connection conn = this.getConnection();

            try {
               Statement st = conn.createStatement();

               try {
                  ResultSet rs = st.executeQuery(sql);

                  try {
                     System.out.println("ID | Judul | Pengarang | Tahun | Jumlah");

                     while(rs.next()) {
                        System.out.printf("%d | %s | %s | %d | %d%n", rs.getInt("id_buku"), rs.getString("judul"), rs.getString("pengarang"), rs.getInt("tahun_terbit"), rs.getInt("jumlah"));
                     }
                  } finally {
                     if (rs != null) {
                        rs.close();
                     }

                  }
               } catch (Throwable var28) {
                  if (var2 == null) {
                     var2 = var28;
                  } else if (var2 != var28) {
                     var2.addSuppressed(var28);
                  }

                  if (st != null) {
                     st.close();
                  }

                  throw var2;
               }

               if (st != null) {
                  st.close();
               }
            } catch (Throwable var29) {
               if (var2 == null) {
                  var2 = var29;
               } else if (var2 != var29) {
                  var2.addSuppressed(var29);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var2;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var30) {
            if (var2 == null) {
               var2 = var30;
            } else if (var2 != var30) {
               var2.addSuppressed(var30);
            }

            throw var2;
         }
      } catch (SQLException var31) {
         System.err.println("Gagal membaca data: " + var31.getMessage());
      }

   }

   public boolean findBukuById(int id) throws Throwable {
      String sql = "SELECT * FROM buku WHERE id_buku = ?";

      try {
         Throwable var3 = null;
         Object var4 = null;

         try {
            Connection conn = this.getConnection();

            label676: {
               try {
                  PreparedStatement ps = conn.prepareStatement(sql);

                  try {
                     ps.setInt(1, id);
                     Throwable var7 = null;
                     Object var8 = null;

                     try {
                        ResultSet rs = ps.executeQuery();

                        try {
                           if (rs.next()) {
                              System.out.println("Buku ditemukan:");
                              System.out.println("ID Buku       : " + rs.getInt("id_buku"));
                              System.out.println("Judul         : " + rs.getString("judul"));
                              System.out.println("Pengarang     : " + rs.getString("pengarang"));
                              System.out.println("Tahun Terbit  : " + rs.getInt("tahun_terbit"));
                              System.out.println("Jumlah        : " + rs.getInt("jumlah"));
                              break label676;
                           }
                        } finally {
                           if (rs != null) {
                              rs.close();
                           }

                        }
                     } catch (Throwable var41) {
                        if (var7 == null) {
                           var7 = var41;
                        } else if (var7 != var41) {
                           var7.addSuppressed(var41);
                        }

                        throw var7;
                     }
                  } finally {
                     if (ps != null) {
                        ps.close();
                     }

                  }
               } catch (Throwable var43) {
                  if (var3 == null) {
                     var3 = var43;
                  } else if (var3 != var43) {
                     var3.addSuppressed(var43);
                  }

                  if (conn != null) {
                     conn.close();
                  }

                  throw var3;
               }

               if (conn != null) {
                  conn.close();
               }

               return false;
            }

            if (conn != null) {
               conn.close();
            }

            return true;
         } catch (Throwable var44) {
            if (var3 == null) {
               var3 = var44;
            } else if (var3 != var44) {
               var3.addSuppressed(var44);
            }

            throw var3;
         }
      } catch (SQLException var45) {
         System.err.println("Error findBukuById: " + var45.getMessage());
         return false;
      }
   }

   public void insertBuku(String judul, String pengarang, int tahunTerbit, int jumlah) throws Throwable {
      String sql = "INSERT INTO buku (judul, pengarang, tahun_terbit, jumlah) VALUES (?, ?, ?, ?)";

      try {
         Throwable var6 = null;
         Object var7 = null;

         try {
            Connection conn = this.getConnection();

            try {
               PreparedStatement ps = conn.prepareStatement(sql);

               try {
                  ps.setString(1, judul);
                  ps.setString(2, pengarang);
                  ps.setInt(3, tahunTerbit);
                  ps.setInt(4, jumlah);
                  int result = ps.executeUpdate();
                  System.out.println(result > 0 ? "Data buku berhasil ditambahkan." : "Data buku gagal ditambahkan.");
               } finally {
                  if (ps != null) {
                     ps.close();
                  }

               }
            } catch (Throwable var24) {
               if (var6 == null) {
                  var6 = var24;
               } else if (var6 != var24) {
                  var6.addSuppressed(var24);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var6;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var25) {
            if (var6 == null) {
               var6 = var25;
            } else if (var6 != var25) {
               var6.addSuppressed(var25);
            }

            throw var6;
         }
      } catch (SQLException var26) {
         System.err.println("Error insertBuku: " + var26.getMessage());
      }

   }

   public void updateBuku(int id, String judul, String pengarang, int tahunTerbit, int jumlah) throws Throwable {
      String sql = "UPDATE buku SET judul = ?, pengarang = ?, tahun_terbit = ?, jumlah = ? WHERE id_buku = ?";

      try {
         Throwable var7 = null;
         Object var8 = null;

         try {
            Connection conn = this.getConnection();

            try {
               PreparedStatement ps = conn.prepareStatement(sql);

               try {
                  ps.setString(1, judul);
                  ps.setString(2, pengarang);
                  ps.setInt(3, tahunTerbit);
                  ps.setInt(4, jumlah);
                  ps.setInt(5, id);
                  int result = ps.executeUpdate();
                  System.out.println(result > 0 ? "Data buku berhasil diubah." : "Data buku gagal diubah.");
               } finally {
                  if (ps != null) {
                     ps.close();
                  }

               }
            } catch (Throwable var25) {
               if (var7 == null) {
                  var7 = var25;
               } else if (var7 != var25) {
                  var7.addSuppressed(var25);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var7;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var26) {
            if (var7 == null) {
               var7 = var26;
            } else if (var7 != var26) {
               var7.addSuppressed(var26);
            }

            throw var7;
         }
      } catch (SQLException var27) {
         System.err.println("Error updateBuku: " + var27.getMessage());
      }

   }

   public void deleteBuku(int id) throws Throwable {
      String sql = "DELETE FROM buku WHERE id_buku = ?";

      try {
         Throwable var3 = null;
         Object var4 = null;

         try {
            Connection conn = this.getConnection();

            try {
               PreparedStatement ps = conn.prepareStatement(sql);

               try {
                  ps.setInt(1, id);
                  int result = ps.executeUpdate();
                  System.out.println(result > 0 ? "Buku berhasil dihapus." : "Buku gagal dihapus.");
               } finally {
                  if (ps != null) {
                     ps.close();
                  }

               }
            } catch (Throwable var21) {
               if (var3 == null) {
                  var3 = var21;
               } else if (var3 != var21) {
                  var3.addSuppressed(var21);
               }

               if (conn != null) {
                  conn.close();
               }

               throw var3;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (Throwable var22) {
            if (var3 == null) {
               var3 = var22;
            } else if (var3 != var22) {
               var3.addSuppressed(var22);
            }

            throw var3;
         }
      } catch (SQLException var23) {
         System.err.println("Error deleteBuku: " + var23.getMessage());
      }

   }
}

