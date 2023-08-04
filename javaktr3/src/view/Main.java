/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.IOFile;
import controller.ValidException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MonHoc;
import model.SinhVien;

/**
 *
 * @author hoabo
 */
public class Main extends javax.swing.JFrame {
    
    private List<SinhVien> listSV;
    private List<MonHoc> listMH;
    
    private DefaultTableModel tmSV;
    private DefaultTableModel tmMH;
    
    private String fSV, fMH;
    
    public Main() {
        initComponents();
        fSV = "src/controller/SV.dat";
        fMH = "src/controller/MH.dat";
        
        if(new File(fSV).exists()){
            listSV = IOFile.doc(fSV);
        }else{
            listSV = new ArrayList<>();
        }
        if(new File(fMH).exists()){
            listMH = IOFile.doc(fMH);
        }else{
            listMH = new ArrayList<>();
        }
        
        tmSV = (DefaultTableModel)tbSV.getModel();
        tmMH = (DefaultTableModel)tbMH.getModel();
        
        docSV();
        docMH();
        
        setButtonSV(true);
        setButtonMH(true);
        
        eventSV();
        eventMH();
    }

    private void docSV(){
        tmSV.setRowCount(0);
        for(SinhVien i : listSV){
            tmSV.addRow(i.toObjects());
        }
    }
    
    private void docMH(){
        tmMH.setRowCount(0);
        for(MonHoc i : listMH){
            tmMH.addRow(i.toObjects());
        }
    }
    
    private void setButtonSV(boolean b){
        themSVBT.setEnabled(b);
        cnhatSVBT.setEnabled(!b);
        bquaSVBT.setEnabled(!b);
    }
    
    private void setButtonMH(boolean b){
        themMHBT.setEnabled(b);
        cnhatMHBT.setEnabled(!b);
        bquaMHBT.setEnabled(!b);
    }
    
    private void eventSV(){
        themSVBT.addActionListener(e->{
            maSV.setText((10000+listSV.size())+"");
            tenSV.requestFocus();
            setButtonSV(false);
        });
        cnhatSVBT.addActionListener(e->{
            try{
                if(!ngaySinh.getText().matches("\\d{1,2}/\\d{1,2}/\\d{4}")){
                    throw new ValidException("Nhap ngay sinh dinh dang dd/MM/yyyy");
                }
                SinhVien s = new SinhVien(
                    Integer.parseInt(maSV.getText()),
                    tenSV.getText(),
                    ngaySinh.getText(),
                    chuyenNganhCBB.getSelectedItem().toString()
                );
                listSV.add(s);
                tmSV.addRow(s.toObjects());
                setButtonSV(true);
            }catch(ValidException ex){
                JOptionPane.showMessageDialog(this, "Nhap ngay sinh dinh dang dd/MM/yyyy");
                ngaySinh.setText("");
                ngaySinh.requestFocus();
            }
        });
        bquaSVBT.addActionListener(e->{
            setButtonSV(true);
        });
        suaSVBT.addActionListener(e->{
            int row = tbSV.getSelectedRowCount();
            if(row >= 0 && row < tbSV.getRowCount()){
                SinhVien s = new SinhVien(
                    Integer.parseInt(maSV.getText()),
                    tenSV.getText(),
                    ngaySinh.getText(),
                    chuyenNganhCBB.getSelectedItem().toString()
                );
                listSV.set(row, s);
                tmSV.removeRow(row);
                tmSV.insertRow(row, s.toObjects());
            }else{
                JOptionPane.showMessageDialog(this, "Chon dong de sua");
            }
        });
        luuSVBT.addActionListener(e->{
            IOFile.ghi(fSV,listSV);
        });
    }
    
    
        private void eventMH(){
        themMHBT.addActionListener(e->{
            maMH.setText((100+listMH.size())+"");
            tenMH.requestFocus();
            setButtonMH(false);
        });
        cnhatMHBT.addActionListener(e->{
            MonHoc m = new MonHoc(
                    Integer.parseInt(maMH.getText()),
                    tenMH.getText(),
                    Integer.parseInt(soTC.getText()),
                    loaiMHCBB.getSelectedItem().toString()
            );
            listMH.add(m);
            tmMH.addRow(m.toObjects());
            setButtonMH(true);
        });
        bquaMHBT.addActionListener(e->{
            setButtonMH(true);
        });
        xoaMHBT.addActionListener(e->{
            int row = tbMH.getSelectedRowCount();
            if(row >= 0 && row < tbMH.getRowCount()){
                listMH.remove(row);
                tmMH.removeRow(row);
            }else{
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });
        luuMHBT.addActionListener(e->{
            IOFile.ghi(fMH,listMH);
        });
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSV = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        maSV = new javax.swing.JTextField();
        tenSV = new javax.swing.JTextField();
        ngaySinh = new javax.swing.JTextField();
        chuyenNganhCBB = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        themSVBT = new javax.swing.JButton();
        cnhatSVBT = new javax.swing.JButton();
        bquaSVBT = new javax.swing.JButton();
        suaSVBT = new javax.swing.JButton();
        luuSVBT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        themMHBT = new javax.swing.JButton();
        cnhatMHBT = new javax.swing.JButton();
        bquaMHBT = new javax.swing.JButton();
        xoaMHBT = new javax.swing.JButton();
        luuMHBT = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        maMH = new javax.swing.JTextField();
        tenMH = new javax.swing.JTextField();
        soTC = new javax.swing.JTextField();
        loaiMHCBB = new javax.swing.JComboBox<>();
        asdas = new javax.swing.JScrollPane();
        tbMH = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        tbBD = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma SV", "Ho ten", "Ngay sinh", "Chuyen nganh"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSV);

        jLabel1.setText("Ma sinh vien");

        jLabel2.setText("Ho va ten");

        jLabel3.setText("Ngay sinh");

        jLabel4.setText("Chuyen nganh");

        chuyenNganhCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cong nghe phan mem", "He thong thong tin", "An toan thong tin", "Da phuong tien" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(108, 108, 108)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ngaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(tenSV)
                    .addComponent(maSV)
                    .addComponent(chuyenNganhCBB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(chuyenNganhCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        themSVBT.setText("Them moi");

        cnhatSVBT.setText("Cap nhat");

        bquaSVBT.setText("Bo qua");

        suaSVBT.setText("Sua");

        luuSVBT.setText("Luu file");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suaSVBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cnhatSVBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(themSVBT)
                                .addComponent(bquaSVBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(19, 19, 19))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(luuSVBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(themSVBT)
                .addGap(18, 18, 18)
                .addComponent(cnhatSVBT)
                .addGap(18, 18, 18)
                .addComponent(bquaSVBT)
                .addGap(18, 18, 18)
                .addComponent(suaSVBT)
                .addGap(18, 18, 18)
                .addComponent(luuSVBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Sinh Vien", jPanel1);

        themMHBT.setText("Them moi");

        cnhatMHBT.setText("Cap nhat");

        bquaMHBT.setText("Bo qua");

        xoaMHBT.setText("Xoa");

        luuMHBT.setText("Luu file");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cnhatMHBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(themMHBT)
                        .addComponent(bquaMHBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(luuMHBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(xoaMHBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(themMHBT)
                .addGap(18, 18, 18)
                .addComponent(cnhatMHBT)
                .addGap(18, 18, 18)
                .addComponent(bquaMHBT)
                .addGap(18, 18, 18)
                .addComponent(xoaMHBT)
                .addGap(18, 18, 18)
                .addComponent(luuMHBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Ma mon");

        jLabel7.setText("Ten mon");

        jLabel8.setText("So tin chi");

        jLabel9.setText("Loai mon");

        loaiMHCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dai cuong", "Co so nganh", "Chuyen nganh" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(108, 108, 108)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(soTC, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(tenMH)
                    .addComponent(maMH)
                    .addComponent(loaiMHCBB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(soTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(loaiMHCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbMH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma mon", "Ten mon", "So tin chi", "Loai mon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbMH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMHMouseClicked(evt);
            }
        });
        asdas.setViewportView(tbMH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(asdas)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(asdas, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Mon hoc", jPanel2);

        jButton11.setText("jButton1");

        jButton12.setText("jButton2");

        jButton13.setText("jButton3");

        jButton14.setText("jButton4");

        jButton15.setText("jButton5");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton13)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addGap(18, 18, 18)
                .addComponent(jButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Ma SV");

        jLabel13.setText("Ma MH");

        jLabel14.setText("Diem");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(46, 46, 46)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma SV", "Ten SV", "Ten MH", "Diem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBD.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbBD, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(72, 72, 72)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(tbBD, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Bang diem", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSVMouseClicked
        // TODO add your handling code here:
        int row = tbSV.getSelectedRow();
        if (row >= 0 && row < listSV.size()){
            maSV.setText(tbSV.getValueAt(row, 0).toString());
            tenSV.setText(tbSV.getValueAt(row, 1).toString());
            for( int i =0; i <chuyenNganhCBB.getItemCount(); i++ ){
                if (chuyenNganhCBB.getItemAt(i).equals(tmSV.getValueAt(row, 2).toString())){
                    chuyenNganhCBB.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tbSVMouseClicked

    private void tbMHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMHMouseClicked
        // TODO add your handling code here:
        int row = tbMH.getSelectedRow();
        if (row >= 0 && row < listMH.size()){
            maMH.setText(tbMH.getValueAt(row, 0).toString());
            tenMH.setText(tbMH.getValueAt(row, 1).toString());
            for( int i =0; i <loaiMHCBB.getItemCount(); i++ ){
                if (loaiMHCBB.getItemAt(i).equals(tmMH.getValueAt(row, 2).toString())){
                    loaiMHCBB.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tbMHMouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane asdas;
    private javax.swing.JButton bquaMHBT;
    private javax.swing.JButton bquaSVBT;
    private javax.swing.JComboBox<String> chuyenNganhCBB;
    private javax.swing.JButton cnhatMHBT;
    private javax.swing.JButton cnhatSVBT;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable3;
    private javax.swing.JComboBox<String> loaiMHCBB;
    private javax.swing.JButton luuMHBT;
    private javax.swing.JButton luuSVBT;
    private javax.swing.JTextField maMH;
    private javax.swing.JTextField maSV;
    private javax.swing.JTextField ngaySinh;
    private javax.swing.JTextField soTC;
    private javax.swing.JButton suaSVBT;
    private javax.swing.JScrollPane tbBD;
    private javax.swing.JTable tbMH;
    private javax.swing.JTable tbSV;
    private javax.swing.JTextField tenMH;
    private javax.swing.JTextField tenSV;
    private javax.swing.JButton themMHBT;
    private javax.swing.JButton themSVBT;
    private javax.swing.JButton xoaMHBT;
    // End of variables declaration//GEN-END:variables
}
