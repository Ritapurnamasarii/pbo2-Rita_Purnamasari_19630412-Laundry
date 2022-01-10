
package laundry.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import laundry.db.MyConnection;

public class Parfum {
    private String parfum;
    private int harga_p;
    private int id_parfum;
    public MyConnection database;
    public Connection connection;
    
//    CONSTRUKTOR

    public Parfum() {
    }

    public Parfum(String parfum, int harga_p) {
        this.parfum = parfum;
        this.harga_p = harga_p;
    }
    
//    CREATE
    public boolean create(){
        String insertSQL = "INSERT INTO parfum VALUES (?,?,?)";
//        System.out.println(insertSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            
//            ps.setString(1, " ");
//            System.out.println(getParfum());
//            System.out.println(getHarga_p());
            ps.setInt(1, this.getId_parfum());
            ps.setString(2, this.getParfum());
            ps.setInt(3, this.getHarga_p());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    
//    READ
    public ArrayList<Parfum> read(){
        String selectSQL = "SELECT * FROM parfum";
        ArrayList<Parfum> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Parfum parfum = new Parfum();
                parfum.setId_parfum(rs.getInt(1));
                parfum.setParfum(rs.getString(2));
                parfum.setHarga_p(rs.getInt(3));

                
                list.add(parfum);
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
        String updateSQL = "UPDATE parfum SET nama_parfum= ?, harga = ? WHERE id_parfum= ? ";
//        System.out.println(updateSQL);

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getParfum());
            ps.setInt(2, this.getHarga_p());
            ps.setInt(3, this.getId_parfum());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    
//    DELETE
    public boolean delete(){
        String deleteSQL = "DELETE FROM parfum WHERE id_parfum= ?";
//        System.out.println(deleteSQL);
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setInt(1, this.getId_parfum());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    
    
//    SEARCH
    public ArrayList<Parfum> search(String kata){
//        System.out.println(kata);
        String searchSQL = "SELECT * FROM parfum WHERE nama_parfum LIKE '%"+kata+"%' ";
        ArrayList<Parfum> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Parfum parfum = new Parfum();
                parfum.setId_parfum(rs.getInt(1));
                parfum.setParfum(rs.getString(2));
                parfum.setHarga_p(rs.getInt(3));
                
                list.add(parfum);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    GEETER
    public String getParfum() {
        return parfum;
    }

    public int getHarga_p() {
        return harga_p;
    }

    public int getId_parfum() {
        return id_parfum;
    }

    public MyConnection getDatabase() {
        return database;
    }

    public Connection getConnection() {
        return connection;
    }
    
//    SEETER
    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public void setHarga_p(int harga_p) {
        this.harga_p = harga_p;
    }

    public void setId_parfum(int id_parfum) {
        this.id_parfum = id_parfum;
    }

    public void setDatabase(MyConnection database) {
        this.database = database;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    
}
