/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry.form;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import laundry.model.Laundry;
import laundry.model.Login;
/**
 *
 * @author fahmi
 */
public class LaundryForm extends javax.swing.JFrame {
//    KODING KU
    Login login =  new Login();
    private String level, user, parfum, id_pel, nama_pel, telp, tanggal, jam;
    private int id_parfum, h_parfum;
    private PilihParfumForm pilihparfumform = null;
    private PilihPelangganForm pilihpelangganform = null;

//    SEETER
    public void setLevel(String level) {
        this.level = level;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public void setId_parfum(int id_parfum) {
        this.id_parfum = id_parfum;
    }

    public void setH_parfum(int h_parfum) {
        this.h_parfum = h_parfum;
    }

    public void setId_pel(String id_pel) {
        this.id_pel = id_pel;
    }

    public void setNama_pel(String nama_pel) {
        this.nama_pel = nama_pel;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
    
    
    
//    SAGAN PILIHAN
    public void itemTerpilihParfum(){
        PilihParfumForm pilihparfumform = new PilihParfumForm();
        pilihparfumform.laundryform = this;
        parfumTF.setText(parfum);
        id_parfumL.setText(String.valueOf(id_parfum));
        h_parfumL.setText(String.valueOf(h_parfum));
    }
    
    public void itemTerpilihPelanggan(){
        PilihPelangganForm pilihpelangganform = new PilihPelangganForm();
        pilihpelangganform.laundryform = this;
        id_pelangganTF.setText(id_pel);
        pelangganTF.setText(nama_pel);
        telpTF.setText(telp);
        memberTF.setText("yes");
    }
    
//    TAMPIL TANGGAL DAN JAM
    public void tanggalSekarang() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        tanggalTF.setText(dateFormat.format(date));
        waktuSekarang();
    }
    
    public void waktuSekarang() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss"); 
        jamTF.setText(dateFormat.format(date));
    }
    
//    HITUNG BIAYA
    public void hitungBiaya(){
        double berat_l = Double.parseDouble(beratTF.getText());
        double bayar,h_parfum;
        
        if (setrikaCB.isSelected()){
            h_parfum = Double.parseDouble(h_parfumL.getText());
            bayar = (berat_l * 4000) + (berat_l * h_parfum);
        }else{
            bayar = (berat_l * 4000) ;
        }
        
        if (memberTF.getText().equals("yes")){
            bayar = bayar - (bayar*0.15);
        }else {
            bayar = bayar;
        }
        
        hargaTF.setText(Double.toString(bayar));
    }
    

//    KODING KU
    Laundry laundry = new Laundry();
    
    public void tampilData(){
        ArrayList<Laundry> list = laundry.read();
        
        DefaultTableModel tableModel = (DefaultTableModel) tbLaundry.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[14];
        
        if(list.size() > 0){
//            System.out.println("Jalan");
            for (int i = 0; i<list.size(); i++){
                row[0] = list.get(i).getId_laundry();
                row[1] = list.get(i).getKasir();
                row[2] = list.get(i).getTanggal();
                row[3] = list.get(i).getJam();
                row[4] = list.get(i).getId_pelanggan();
                row[5] = list.get(i).getNama_pelanggan();
                row[6] = list.get(i).getTelp();
                row[7] = list.get(i).getMember();
                row[8] = list.get(i).getBerat();
                row[9] = list.get(i).getSetrika();
                row[10] = list.get(i).getId_parfum();
                row[11] = list.get(i).getNama_parfum();
                row[12] = list.get(i).getStatus();
                row[13] = list.get(i).getHarga();
                
                
//                KODE OTOMATIS
                String kodeAsli = list.get(i).getId_laundry();
                int kodeAngka =(Integer.parseInt(kodeAsli.substring(1))+1);
//                System.out.println(kodeAngka);
                
                id_laundryTF.setText(String.valueOf("L"+kodeAngka));
                tableModel.addRow(row);
            }
        }else if(list.size() == 0){
            id_laundryTF.setText("L1");
        }
    }
    
    public void tampilCari(){
        ArrayList<Laundry> list = laundry.search(cariTF.getText());
        
        DefaultTableModel tableModel = (DefaultTableModel) tbLaundry.getModel();
        tableModel.setRowCount(0);
        
        Object[] row = new Object[14];
        
        if(list.size() > 0){
//            System.out.println("Jalan");
            for (int i = 0; i<list.size(); i++){
                row[0] = list.get(i).getId_laundry();
                row[1] = list.get(i).getKasir();
                row[2] = list.get(i).getTanggal();
                row[3] = list.get(i).getJam();
                row[4] = list.get(i).getId_pelanggan();
                row[5] = list.get(i).getNama_pelanggan();
                row[6] = list.get(i).getTelp();
                row[7] = list.get(i).getMember();
                row[8] = list.get(i).getBerat();
                row[9] = list.get(i).getSetrika();
                row[10] = list.get(i).getId_parfum();
                row[11] = list.get(i).getNama_parfum();
                row[12] = list.get(i).getStatus();
                row[13] = list.get(i).getHarga();
                
                tableModel.addRow(row);
            }
        }
    }
    
    public void reset() {
        id_laundryTF.setEnabled(false);
        kasirTF.setText(namaL.getText());
        id_pelangganTF.setText("null");
        pelangganTF.setText("");
        telpTF.setText("");
        memberTF.setText("no");
        beratTF.setText("");
        setrikaCB.setSelected(false);
        id_parfumL.setText("1");
        parfumTF.setText("no");
        h_parfumL.setText("0");
        statusCB.setSelectedIndex(0);
        hargaTF.setText("");
        BTtambah.setEnabled(true);
        BTubah.setEnabled(false);
        BThapus.setEnabled(false);
        tampilData();
        tanggalSekarang();
      }

    /**
     * Creates new form LaundryForm
     */
    public LaundryForm() {
        initComponents();
        reset();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        userL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        namaL = new javax.swing.JLabel();
        id_laundryTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        kasirTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tanggalTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jamTF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        beratTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        parfumTF = new javax.swing.JTextField();
        id_parfumL = new javax.swing.JLabel();
        h_parfumL = new javax.swing.JLabel();
        statusCB = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        hargaTF = new javax.swing.JTextField();
        hitungBT = new javax.swing.JButton();
        setrikaCB = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        pilih_pelangganBT = new javax.swing.JButton();
        memberTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        id_pelangganTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pelangganTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        telpTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        bukan_memberBT = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        BTtambah = new javax.swing.JButton();
        BTbersih = new javax.swing.JButton();
        BThapus = new javax.swing.JButton();
        BTkeluar = new javax.swing.JButton();
        BTubah = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLaundry = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        cariTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        userL.setText("User");

        jLabel1.setText("Id Laundry");

        namaL.setText("Nama");

        id_laundryTF.setEnabled(false);

        jLabel2.setText("Kasir");

        kasirTF.setEnabled(false);

        jLabel6.setText("Tanggal");

        tanggalTF.setEnabled(false);

        jLabel13.setText("Jam");

        jamTF.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(userL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namaL))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(id_laundryTF, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(kasirTF)
                            .addComponent(tanggalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jamTF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userL)
                    .addComponent(namaL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_laundryTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kasirTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tanggalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jamTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Berat Laundry");

        jLabel8.setText("Parfum");

        parfumTF.setText("no");
        parfumTF.setEnabled(false);

        statusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pencucian", "Belum Diambil", "Sudah Diambil" }));

        jLabel9.setText("Status");

        jLabel10.setText("Harga");

        hitungBT.setText("Hitung");
        hitungBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungBTActionPerformed(evt);
            }
        });

        setrikaCB.setText("Setrika");
        setrikaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setrikaCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(beratTF, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(id_parfumL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h_parfumL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(parfumTF, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setrikaCB)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hargaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hitungBT))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(beratTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setrikaCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(parfumTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(id_parfumL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(h_parfumL, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(statusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(hitungBT))
                .addContainerGap())
        );

        pilih_pelangganBT.setText("Cari Member");
        pilih_pelangganBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilih_pelangganBTActionPerformed(evt);
            }
        });

        memberTF.setText("no");
        memberTF.setEnabled(false);

        jLabel4.setText("Id Pelanggan");

        id_pelangganTF.setEnabled(false);

        jLabel3.setText("Nama Pelanggan");

        jLabel5.setText("Telpon");

        jLabel12.setText("Member");

        bukan_memberBT.setText("Bukan member");
        bukan_memberBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bukan_memberBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(telpTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_pelangganTF)
                            .addComponent(memberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bukan_memberBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pilih_pelangganBT))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pelangganTF, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilih_pelangganBT)
                    .addComponent(bukan_memberBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_pelangganTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pelangganTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telpTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        BTtambah.setText("Tambah");
        BTtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTtambahActionPerformed(evt);
            }
        });

        BTbersih.setText("Bersih");
        BTbersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTbersihActionPerformed(evt);
            }
        });

        BThapus.setText("Hapus");
        BThapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BThapusActionPerformed(evt);
            }
        });

        BTkeluar.setText("Keluar");
        BTkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTkeluarActionPerformed(evt);
            }
        });

        BTubah.setText("Ubah");
        BTubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTubahActionPerformed(evt);
            }
        });

        jButton1.setText("Cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(187, Short.MAX_VALUE)
                .addComponent(BTtambah)
                .addGap(18, 18, 18)
                .addComponent(BTbersih)
                .addGap(18, 18, 18)
                .addComponent(BThapus)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(BTkeluar)
                .addGap(94, 94, 94)
                .addComponent(BTubah))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(BTubah)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTtambah)
                    .addComponent(BTbersih)
                    .addComponent(BThapus)
                    .addComponent(BTkeluar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tbLaundry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Laundry", "Kasir", "Tanggal", "Jam", "ID Pel", "Nama Pel", "Telp", "Member", "Berat", "Setrika", "Id Parfum", "Parfum", "Status", "Harga"
            }
        ));
        tbLaundry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLaundryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLaundry);

        jLabel11.setText("Cari Berdasarkan Nama / Alamat");

        cariTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariTFKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(55, 55, 55)
                .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(357, 357, 357))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        userL.setText(level+" :");
        namaL.setText(user);
        kasirTF.setText(user);
    }//GEN-LAST:event_formWindowActivated

    private void pilih_pelangganBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilih_pelangganBTActionPerformed
        PilihPelangganForm pilihpelangganform = new PilihPelangganForm();
        pilihpelangganform.laundryform = this;
        pilihpelangganform.setVisible(true);
    }//GEN-LAST:event_pilih_pelangganBTActionPerformed

    private void bukan_memberBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bukan_memberBTActionPerformed
        id_pelangganTF.setText("null");
        pelangganTF.setText("");
        telpTF.setText("");
        memberTF.setText("no");
    }//GEN-LAST:event_bukan_memberBTActionPerformed

    private void BTtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTtambahActionPerformed
        hitungBiaya();
        laundry.setId_laundry(id_laundryTF.getText());
        laundry.setKasir(kasirTF.getText());
        laundry.setTanggal(tanggalTF.getText());
        laundry.setJam(jamTF.getText());
        laundry.setId_pelanggan(id_pelangganTF.getText());
        laundry.setNama_pelanggan(pelangganTF.getText());
        laundry.setTelp(telpTF.getText());
        laundry.setMember(memberTF.getText());
        laundry.setBerat(Double.parseDouble(beratTF.getText()));
        if (setrikaCB.isSelected()){
            laundry.setSetrika("yes");
        }else{
            laundry.setSetrika("no");
        }
        laundry.setId_parfum(Integer.parseInt(id_parfumL.getText()));
        laundry.setStatus((String) statusCB.getSelectedItem());
        laundry.setHarga(Double.parseDouble(hargaTF.getText()));

        if (laundry.createTransaksi() & laundry.createLaundry()){
            tampilData();
            JOptionPane.showMessageDialog(null, "Berhasil Di Simpan");
            reset();
        }else{
            JOptionPane.showMessageDialog(null, "Gagal Di Simpan");
        }
    }//GEN-LAST:event_BTtambahActionPerformed

    private void BTbersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTbersihActionPerformed
        reset();
    }//GEN-LAST:event_BTbersihActionPerformed

    private void BThapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BThapusActionPerformed
        try {
            int jawab;

            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                laundry.setId_laundry(id_laundryTF.getText());

                if (laundry.deleteTransaksi() & laundry.deleteLaundry()){
                    tampilData();
                    JOptionPane.showMessageDialog(null, "Berhasil Di Hapus");
                    reset();
                }else{
                    JOptionPane.showMessageDialog(null, "Gagal Di Hapus");
                }

                tampilData();
                reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BThapusActionPerformed

    private void BTkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTkeluarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Konfirmasi Keluar Aplikasi",
            "Yakin untuk keluar dari program",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_BTkeluarActionPerformed

    private void BTubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTubahActionPerformed
        hitungBiaya();
        laundry.setId_laundry(id_laundryTF.getText());
        laundry.setKasir(kasirTF.getText());
        laundry.setTanggal(tanggalTF.getText());
        laundry.setJam(jamTF.getText());
        laundry.setId_pelanggan(id_pelangganTF.getText());
        laundry.setNama_pelanggan(pelangganTF.getText());
        laundry.setTelp(telpTF.getText());
        laundry.setMember(memberTF.getText());
        laundry.setBerat(Double.parseDouble(beratTF.getText()));
        if (setrikaCB.isSelected()){
            laundry.setSetrika("yes");
        }else{
            laundry.setSetrika("no");
        }
        laundry.setId_parfum(Integer.parseInt(id_parfumL.getText()));
        laundry.setStatus((String) statusCB.getSelectedItem());
        laundry.setHarga(Double.parseDouble(hargaTF.getText()));
        
        if (laundry.updateTransaksi() & laundry.updateLaundry()){
            tampilData();
            JOptionPane.showMessageDialog(null, "Berhasil Di Ubah");
            reset();
        }else{
            JOptionPane.showMessageDialog(null, "Gagal Di Ubah");
        }
    }//GEN-LAST:event_BTubahActionPerformed

    private void cariTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTFKeyTyped
        tampilCari();
    }//GEN-LAST:event_cariTFKeyTyped

    private void hitungBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungBTActionPerformed
        hitungBiaya();
    }//GEN-LAST:event_hitungBTActionPerformed

    private void setrikaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setrikaCBActionPerformed
        if (setrikaCB.isSelected()){
            PilihParfumForm pilihparfumform = new PilihParfumForm();
            pilihparfumform.laundryform = this;
            pilihparfumform.setVisible(true);
        }else{
            parfumTF.setText("no");
            id_parfumL.setText("1");
            h_parfumL.setText("0");
            parfumTF.enable(false);
        }
    }//GEN-LAST:event_setrikaCBActionPerformed

    private void tbLaundryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLaundryMouseClicked
        tanggalSekarang();
        id_laundryTF.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 0).toString());
        id_pelangganTF.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 4).toString());
        pelangganTF.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 5).toString());
        telpTF.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 6).toString());
        memberTF.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 7).toString());
        beratTF.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 8).toString()); 
        if (tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 9).toString().equals("yes")){
            setrikaCB.setSelected(true);
            laundry.cariParfum(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 11).toString());
            h_parfumL.setText(String.valueOf(laundry.getHarga_p())); 
        }else if (tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 9).toString().equals("no")){
            setrikaCB.setSelected(false);
            h_parfumL.setText("0");
        }
        id_parfumL.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 10).toString());
        parfumTF.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 11).toString());
        if (tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 12).toString().equals("Pencucian")){
            statusCB.setSelectedIndex(0);
        }else if (tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 12).toString().equals("Belum Diambil")){
            statusCB.setSelectedIndex(1);
        }else if (tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 12).toString().equals("Sudah Diambil")){
            statusCB.setSelectedIndex(2);
        }
        hargaTF.setText(tbLaundry.getValueAt(tbLaundry.getSelectedRow(), 13).toString());
        BTtambah.setEnabled(false);
        BTubah.setEnabled(true);
        BThapus.setEnabled(true);
    }//GEN-LAST:event_tbLaundryMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        laundry.cetak();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LaundryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaundryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaundryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaundryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaundryForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTbersih;
    private javax.swing.JButton BThapus;
    private javax.swing.JButton BTkeluar;
    private javax.swing.JButton BTtambah;
    private javax.swing.JButton BTubah;
    private javax.swing.JTextField beratTF;
    private javax.swing.JButton bukan_memberBT;
    private javax.swing.JTextField cariTF;
    private javax.swing.JLabel h_parfumL;
    private javax.swing.JTextField hargaTF;
    private javax.swing.JButton hitungBT;
    private javax.swing.JTextField id_laundryTF;
    private javax.swing.JLabel id_parfumL;
    private javax.swing.JTextField id_pelangganTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jamTF;
    private javax.swing.JTextField kasirTF;
    private javax.swing.JTextField memberTF;
    private javax.swing.JLabel namaL;
    private javax.swing.JTextField parfumTF;
    private javax.swing.JTextField pelangganTF;
    private javax.swing.JButton pilih_pelangganBT;
    private javax.swing.JCheckBox setrikaCB;
    private javax.swing.JComboBox<String> statusCB;
    private javax.swing.JTextField tanggalTF;
    private javax.swing.JTable tbLaundry;
    private javax.swing.JTextField telpTF;
    private javax.swing.JLabel userL;
    // End of variables declaration//GEN-END:variables
}
