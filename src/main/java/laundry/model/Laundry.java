package laundry.model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import laundry.db.MyConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Laundry {
    private String id_laundry, kasir,tanggal,jam, id_pelanggan, nama_pelanggan, telp, member, setrika, nama_parfum, status;
    private int id_parfum;
    private double berat,harga,harga_p;
    public MyConnection database;
    public Connection connection;
    
//    CONSTRUKTOR
    public Laundry() {
    }

    public Laundry(String id_laundry, String kasir, String tanggal, String jam, String id_pelanggan, String nama_pelanggan, String telp, String member, String setrika, String nama_parfum, String status, int id_parfum, double berat, double harga, double harga_p) {
        this.id_laundry = id_laundry;
        this.kasir = kasir;
        this.tanggal = tanggal;
        this.jam = jam;
        this.id_pelanggan = id_pelanggan;
        this.nama_pelanggan = nama_pelanggan;
        this.telp = telp;
        this.member = member;
        this.setrika = setrika;
        this.nama_parfum = nama_parfum;
        this.status = status;
        this.id_parfum = id_parfum;
        this.berat = berat;
        this.harga = harga;
        this.harga = harga_p;
    }

    

//    CREATE
    public boolean createTransaksi(){
        String insertSQL = "INSERT INTO transaksi VALUES (?,?,?,?,?,?,?,?,?,?)";
//        System.out.println(insertSQL);
//        System.out.println(getId_laundry());
//        System.out.println(getKasir());
//        System.out.println(getTanggal());
//        System.out.println(getJam());
//        System.out.println(getId_pelanggan());
//        System.out.println(getNama_pelanggan());
//        System.out.println(getTelp());
//        System.out.println(getMember());
//        System.out.println(getStatus());
//        System.out.println(getHarga());

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            ps.setString(1, this.getId_laundry());
            ps.setString(2, this.getKasir());
            ps.setString(3, this.getTanggal());
            ps.setString(4, this.getJam());
            ps.setString(5, this.getId_pelanggan());
            ps.setString(6, this.getNama_pelanggan());
            ps.setString(7, this.getTelp());
            ps.setString(8, this.getMember());
            ps.setString(9, this.getStatus());
            ps.setDouble(10, this.getHarga());
            
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    public boolean createLaundry(){
        String insertSQL = "INSERT INTO laundry VALUES (?,?,?,?)";
//        System.out.println(insertSQL);
//        System.out.println(getId_laundry());
//        System.out.println(getBerat());
//        System.out.println(getSetrika());
//        System.out.println(getId_parfum());

        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(insertSQL);
            ps.setString(1, this.getId_laundry());
            ps.setDouble(2, this.getBerat());
            ps.setString(3, this.getSetrika());
            ps.setInt(4, this.getId_parfum());
            
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Insert Gagal");
        }
        return false;
    }
    
//    READ
    public ArrayList<Laundry> read(){
        String selectSQL = 
                "SELECT A.id_laundry, A.kasir, A.tanggal, A.waktu, A.id_pelanggan, A.nama_pelanggan, "
                + "A.telp, A.member, B.berat, B.setrika, B.id_parfum, C.nama_parfum, A.status, A.harga "
                + "FROM transaksi A JOIN laundry B ON A.id_laundry = B.id_laundry "
                + "JOIN parfum C ON B.id_parfum = C.id_parfum";
        ArrayList<Laundry> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(selectSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Laundry laundry = new Laundry();
                laundry.setId_laundry(rs.getString(1));
                laundry.setKasir(rs.getString(2));
                laundry.setTanggal(rs.getString(3));
                laundry.setJam(rs.getString(4));
                laundry.setId_pelanggan(rs.getString(5));
                laundry.setNama_pelanggan(rs.getString(6));
                laundry.setTelp(rs.getString(7));
                laundry.setMember(rs.getString(8));
                laundry.setBerat(rs.getDouble(9));
                laundry.setSetrika(rs.getString(10));
                laundry.setId_parfum(rs.getInt(11));
                laundry.setNama_parfum(rs.getString(12));
                laundry.setStatus(rs.getString(13));
                laundry.setHarga(rs.getDouble(14));
                
                list.add(laundry);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Parfum.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    UPDATE
    public boolean updateTransaksi(){
        String updateSQL = "UPDATE transaksi SET kasir= ?, id_pelanggan = ?, nama_pelanggan = ?, telp = ?, member =?,"
                + "status = ?, harga = ? WHERE id_laundry= ? ";
//        System.out.println(updateSQL);
//        System.out.println(getId_laundry());
//        System.out.println(getKasir());
//        System.out.println(getTanggal());
//        System.out.println(getJam());
//        System.out.println(getId_pelanggan());
//        System.out.println(getNama_pelanggan());
//        System.out.println(getTelp());
//        System.out.println(getMember());
//        System.out.println(getStatus());
//        System.out.println(getHarga());

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setString(1, this.getKasir());
            ps.setString(2, this.getId_pelanggan());
            ps.setString(3, this.getNama_pelanggan());
            ps.setString(4, this.getTelp());
            ps.setString(5, this.getMember());
            ps.setString(6, this.getStatus());
            ps.setDouble(7, this.getHarga());
            ps.setString(8, this.getId_laundry());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    public boolean updateLaundry(){
        String updateSQL = "UPDATE laundry SET berat= ?, setrika = ?, id_parfum = ? WHERE id_laundry= ? ";
//        System.out.println(updateSQL);
//        System.out.println(getId_laundry());
//        System.out.println(getBerat());
//        System.out.println(getSetrika());
//        System.out.println(getId_parfum());

        this.database = new MyConnection();
        this.connection = this.database.getConnection();

        try {
            PreparedStatement ps = this.connection.prepareStatement(updateSQL);
            ps.setDouble(1, this.getBerat());
            ps.setString(2, this.getSetrika());
            ps.setInt(3, this.getId_parfum());
            ps.setString(4, this.getId_laundry());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Update Gagal");
        }
        return false;
    }
    
//    DELETE
    public boolean deleteTransaksi(){
        String deleteSQL = "DELETE FROM transaksi WHERE id_laundry= ?";
//        System.out.println(deleteSQL);
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setString(1, this.getId_laundry());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    public boolean deleteLaundry(){
        String deleteSQL = "DELETE FROM laundry WHERE id_laundry= ?";
//        System.out.println(deleteSQL);
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(deleteSQL);
            ps.setString(1, this.getId_laundry());
            ps.execute();
            return true;
        }catch (SQLException ex) {
            System.out.println("Delete Gagal");
        }
        
        return false;
    }
    
//    SEARCH
    public ArrayList<Laundry> search(String kata){
//        System.out.println(kata);
        String searchSQL = "SELECT A.id_laundry, A.kasir, A.tanggal, A.waktu, A.id_pelanggan, A.nama_pelanggan, A.telp, A.member, B.berat, B.setrika, B.id_parfum, C.nama_parfum, A.status, A.harga FROM transaksi A JOIN laundry B ON A.id_laundry = B.id_laundry JOIN parfum C ON B.id_parfum = C.id_parfum WHERE A.nama_pelanggan LIKE '%"+kata+"%'";
        ArrayList<Laundry> list = new ArrayList<>();
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                
                Laundry laundry = new Laundry();
                laundry.setId_laundry(rs.getString(1));
                laundry.setKasir(rs.getString(2));
                laundry.setId_pelanggan(rs.getString(3));
                laundry.setNama_pelanggan(rs.getString(4));
                laundry.setTelp(rs.getString(5));
                laundry.setMember(rs.getString(6));
                laundry.setBerat(rs.getDouble(7));
                laundry.setSetrika(rs.getString(8));
                laundry.setId_parfum(rs.getInt(9));
                laundry.setStatus(rs.getString(10));
                laundry.setHarga(rs.getInt(11));
                
                list.add(laundry);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        
        return null;
    }
    
//    CARI PARFUM
    public boolean cariParfum(String kata){
        String searchSQL = "SELECT * FROM parfum WHERE nama_parfum LIKE '%"+kata+"%' ";
        
        this.database = new MyConnection();
        this.connection = this.database.getConnection();
        
        try {
            PreparedStatement ps = this.connection.prepareStatement(searchSQL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                setHarga_p(rs.getDouble(3));
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Parfum.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL");
        }
        return false;
    }
    
//    CETAK
    public boolean cetak(){
        try {
            File namafile = new File("src\\main\\java\\laundry\\report\\reportTransaksi.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, database.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            System.out.println(e);
        }
        
        return false;
    }
    
//    GEETER
    public String getId_laundry() {
        return id_laundry;
    }

    public String getKasir() {
        return kasir;
    }

    public String getId_pelanggan() {
        return id_pelanggan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public String getTelp() {
        return telp;
    }

    public String getMember() {
        return member;
    }

    public String getSetrika() {
        return setrika;
    }

    public String getNama_parfum() {
        return nama_parfum;
    }

    public String getStatus() {
        return status;
    }

    public int getId_parfum() {
        return id_parfum;
    }

    public double getHarga() {
        return harga;
    }

    public double getBerat() {
        return berat;
    }

    public MyConnection getDatabase() {
        return database;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public double getHarga_p() {
        return harga_p;
    }
    
//    SEETER

    public void setId_laundry(String id_laundry) {
        this.id_laundry = id_laundry;
    }

    public void setKasir(String kasir) {
        this.kasir = kasir;
    }

    public void setId_pelanggan(String id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public void setSetrika(String setrika) {
        this.setrika = setrika;
    }

    public void setNama_parfum(String nama_parfum) {
        this.nama_parfum = nama_parfum;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId_parfum(int id_parfum) {
        this.id_parfum = id_parfum;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public void setDatabase(MyConnection database) {
        this.database = database;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public void setHarga_p(double harga_p) {
        this.harga_p = harga_p;
    }
    
    
    
    
}
