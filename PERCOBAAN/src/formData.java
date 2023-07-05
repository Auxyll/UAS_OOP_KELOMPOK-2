import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;



public final class formData extends javax.swing.JFrame {

    private String tgl;

    public formData() {
        initComponents();
        Connect();
        LoadTransactionNo();
        Tabel();
        LoadGolonganNo();
        DisplayHarga();
    }
    
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    
    public void Connect(){ //Method untuk connect ke database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/dblalin","root","");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadTransactionNo(){//Method untuk id
        try {
            pst = con.prepareStatement("SELECT id FROM lalin_tbl");
            rs = pst.executeQuery();
            txtid.removeAllItems();
            while(rs.next()){
                txtid.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void LoadGolonganNo(){  //Method untuk golongan
         try {
            Statement stt=con.createStatement();
            String sql = "select * from golongan_tbl";
            ResultSet res=stt.executeQuery(sql);
            txtGolongan.removeAllItems();
            while(res.next()){
                txtGolongan.addItem(res.getString(1));
            }
        }catch (SQLException ex) {
            Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DisplayHarga(){ //Method untuk menampilkan harga yang diambil dari golongan
        
         try {
            String selectedGolongan = txtGolongan.getSelectedItem().toString();
            Statement stt = con.createStatement();
            rs = stt.executeQuery("SELECT harga FROM golongan_tbl WHERE golongan='" + selectedGolongan + "'");
            
            while(rs.next()) {
                 String harga = rs.getString("harga");
                 txtHarga.setText(harga);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
    public void Tabel(){ //Method untuk tabel
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM lalin_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("Tanggal"));
                    v2.add(rs.getString("Golongan"));
                    v2.add(rs.getString("Harga")); 
                    v2.add(rs.getString("Volume"));
                    v2.add(rs.getString("Total"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtVolume = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtHarga = new javax.swing.JTextField();
        txtGolongan = new javax.swing.JComboBox<>();
        txtDate = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtid = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnExportCSV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("LAPORAN PENDAPATAN TOL HARIAN");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tanggal");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Jenis Golongan");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Harga");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Volume Kendaraan");

        txtVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVolumeActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/plus.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setMaximumSize(new java.awt.Dimension(568, 519));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/changes.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/trash.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtHarga.setEditable(false);
        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });

        txtGolongan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGolonganActionPerformed(evt);
            }
        });

        txtDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnUpdate)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtVolume, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtHarga)
                        .addComponent(txtGolongan, 0, 135, Short.MAX_VALUE)
                        .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnDelete)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGolongan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal.setFocusable(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Total Pendapatan");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("ID Transaksi");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/search.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearch))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Transaksi", "Tanggal", "Golongan", "Harga", "Volume", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnExportCSV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/excel.png"))); // NOI18N
        btnExportCSV.setText("ExportCSV");
        btnExportCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnExportCSV)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnExportCSV)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVolumeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVolumeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if(txtVolume.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Volume Kendaraan Harus Di Isi!");
        }else{
                
            try {
                //Untuk mendapatkan hasil TotalPendapatan 
                double Harga = Double.parseDouble(txtHarga.getText());
                int Volume = Integer.parseInt(txtVolume.getText());
                double TotalPendapatan = Harga * Volume;
    
                // Mengubah TotalPendapatan menjadi format mata uang Rupiah
                Locale localeID = new Locale("id", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                String totalPendapatanRupiah = formatRupiah.format(TotalPendapatan);

                txtTotal.setText(totalPendapatanRupiah);

                String selectedGolongan = txtGolongan.getSelectedItem().toString();
                String HargaStr = txtHarga.getText();
                String VolumeStr = txtVolume.getText();
                String Total = txtTotal.getText();
                //Untuk Menambahkan data pada Database
                pst = con.prepareStatement ("INSERT INTO lalin_tbl (Tanggal,Golongan,Harga,Volume,Total)VALUES(?,?,?,?,?)");
                pst.setString(1, tgl);
                pst.setString(2, selectedGolongan);
                pst.setString(3, HargaStr);
                pst.setString(4, VolumeStr);
                pst.setString(5, Total);

                int k = pst.executeUpdate();

                    if(k==1){
                        JOptionPane.showMessageDialog(this,"Data Berhasil Ditambahkan!");
                        txtDate.setDate(null);
                        txtGolongan.setSelectedItem("");
                        txtHarga.setText("");
                        txtVolume.setText("");
                        txtTotal.setText("");
                        LoadTransactionNo();
                        Tabel();
               
                    }else{
                        JOptionPane.showMessageDialog(this, "Data Gagal Ditambahkan!");
                    }
            } catch (SQLException ex) {
                Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here   
    }//GEN-LAST:event_txtHargaActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        //Untuk mencari dan memunculkan data dari database ke table berdasarkan id
        
        try {
            String tid = txtid.getSelectedItem().toString();
          
            pst = con.prepareStatement("SELECT * FROM lalin_tbl WHERE id=?");
            pst.setString(1,tid);
           
            ResultSet res = pst.executeQuery();
            SimpleDateFormat dF = new SimpleDateFormat("dd-MM-yyyy");
            
            if(res.next()==true){
                txtDate.setDate(dF.parse(res.getString(2)));
                txtGolongan.setSelectedItem(res.getString(3));
                txtHarga.setText(res.getString(4));
                txtVolume.setText(res.getString(5));
                txtTotal.setText(res.getString(6));
                
            }else{
                JOptionPane.showMessageDialog(this,"Data Tidak Di Temukan!");
                }
        }catch (SQLException | ParseException ex) {
            Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        //Untuk mengupdate data dari database
        if(txtVolume.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Volume Kendaraan Harus Di Isi!");
        }else{
            try {
                double Harga = Double.parseDouble(txtHarga.getText());
                int Volume = Integer.parseInt(txtVolume.getText());
                double TotalPendapatan = Harga * Volume;

                // Mengubah TotalPendapatan menjadi format mata uang Rupiah
                Locale localeID = new Locale("id", "ID");
                NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
                String totalPendapatanRupiah = formatRupiah.format(TotalPendapatan);

                txtTotal.setText(totalPendapatanRupiah);

                String Golongan = txtGolongan.getSelectedItem().toString();
                String HargaStr = txtHarga.getText();
                String VolumeStr = txtVolume.getText();
                String Total = txtTotal.getText();
                String tid = txtid.getSelectedItem().toString();

                pst = con.prepareStatement("UPDATE lalin_tbl SET Tanggal=?,Golongan=?,Harga=?,Volume=?,Total=? WHERE id=?");

                pst.setString(1, tgl);
                pst.setString(2, Golongan);
                pst.setString(3, HargaStr);
                pst.setString(4, VolumeStr);
                pst.setString(5, Total);
                pst.setString(6, tid);

                int k = pst.executeUpdate();
                if(k==1){
                    JOptionPane.showMessageDialog(this, "Data Berhasil Di Update!");
                    txtDate.setDate(null);
                    txtGolongan.setSelectedItem("");
                    txtHarga.setText("");
                    txtVolume.setText("");
                    txtTotal.setText("");
                    txtDate.requestFocus();
                    LoadTransactionNo();
                    Tabel();   
                }   
            } catch (SQLException ex) {
                Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        //Untuk menghapus data dari database
        try {
            String tid = txtid.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM lalin_tbl WHERE id=?");
            pst.setString(1,tid);
            
            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this, "Data Berhasil Di Hapus!");
                txtDate.setDate(null);
                txtGolongan.setSelectedItem("");
                txtHarga.setText("");
                txtVolume.setText("");
                txtTotal.setText("");
                txtDate.requestFocus();
                LoadTransactionNo();
                Tabel();
                DisplayHarga();
            }else{
                 JOptionPane.showMessageDialog(this, "Data Tidak Berhasil Di Hapus!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExportCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportCSVActionPerformed
        // Untuk mengexport data di table ke bentuk csv
        
        String filename = "D:\\Hasil Export OOP\\DataExport.csv";
        
            try(FileWriter fw = new FileWriter(filename)) {
                pst = con.prepareStatement("SELECT * FROM lalin_tbl");
                rs = pst.executeQuery();
                
                while(rs.next()){
                    fw.append(rs.getString(1));
                    fw.append(',');
                    fw.append(rs.getString(2));
                    fw.append(',');
                    fw.append(rs.getString(3));
                    fw.append(',');
                    fw.append(rs.getString(4));
                    fw.append(',');
                    fw.append(rs.getString(5));
                    fw.append(',');
                    fw.append(rs.getString(6));
                    fw.append('\n');
                }
                JOptionPane.showMessageDialog(this, "Data Berhasil Di Export!");
                fw.flush();
            }
         catch (IOException | SQLException ex) {
            Logger.getLogger(formData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportCSVActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtGolonganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGolonganActionPerformed
        // TODO add your handling code here:
        DisplayHarga();
    }//GEN-LAST:event_txtGolonganActionPerformed

    private void txtDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtDatePropertyChange
        // TODO add your handling code here:
        if(txtDate.getDate()!=null){
            SimpleDateFormat format_tanggal = new SimpleDateFormat("dd-MM-yyyy");
            tgl = format_tanggal.format(txtDate.getDate());
        }
    }//GEN-LAST:event_txtDatePropertyChange

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
            java.util.logging.Logger.getLogger(formData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExportCSV;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JComboBox<String> txtGolongan;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVolume;
    private javax.swing.JComboBox<String> txtid;
    // End of variables declaration//GEN-END:variables
}

