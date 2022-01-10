package laundry.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import laundry.db.MyConnection;

public class Pelanggan {
    String id_pel,nama,alamat,phone;
    public MyConnection database;
    public Connection connection;

//    CONSTRUKTOR
    public Pelanggan() {
    }

    public Pelanggan( String id_pel, String nama, String alamat, String phone) {
        this.nama = nama;
        this.alamat = alamat;
        this.phone = phone;
        this.id_pel = id_pel;
    }

//    CREATE
    public boolean create(){
        String insertSQL = "INSERT INTO pelanggan VALUES (?,?,?,?)";
//        System.out.println(insertSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            ps.setString(1, this.getId_pel());
            ps.setString(2, this.getNama());
            ps.setString(3, this.getAlamat());
            ps.setString(4, this.getPhone());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    
//    READ
    public ArrayList<Pelanggan> read(){
        String selectSQL = "SELECT * FROM pelanggan";
        ArrayList<Pelanggan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId_pel(rs.getString(1));
                pelanggan.setNama(rs.getString(2));
                pelanggan.setAlamat(rs.getString(3));
                pelanggan.setPhone(rs.getString(4));

                
                list.add(pelanggan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Parfum.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    UPDATE
    public boolean update(){
        String updateSQL = "UPDATE pelanggan SET nama_pelanggan= ?, alamat = ?, telp = ? WHERE id_pelanggan= ? ";
//        System.out.println(updateSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getNama());
            ps.setString(2, this.getAlamat());
            ps.setString(3, this.getPhone());
            ps.setString(4, this.getId_pel());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    
//    DELETE
    public boolean delete(){
        String deleteSQL = "DELETE FROM pelanggan WHERE id_pelanggan= ? ";
//        System.out.println(deleteSQL);
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setString(1, this.getId_pel());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    
//    SEARCH
    public ArrayList<Pelanggan> search(String kata){
//        System.out.println(kata);
        String searchSQL = "SELECT * FROM pelanggan WHERE nama_pelanggan LIKE '%"+kata+"%' OR telp LIKE '%"+kata+"%'";
        ArrayList<Pelanggan> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId_pel(rs.getString(1));
                pelanggan.setNama(rs.getString(2));
                pelanggan.setAlamat(rs.getString(3));
                pelanggan.setPhone(rs.getString(4));
                
                list.add(pelanggan);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    GEETER
    public String getId_pel() {
        return id_pel;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getPhone() {
        return phone;
    }

    public MyConnection getDatabase() {
        return database;
    }

    public Connection getConnection() {
        return connection;
    }
    
//    SEETER
    public void setId_pel(String id_pel) {
        this.id_pel = id_pel;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDatabase(MyConnection database) {
        this.database = database;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
    
    
}
