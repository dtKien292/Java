/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.IOFile;
import controller.ValidException;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangChamCong;
import model.CongNhan;
import model.Xuong;

/**
 *
 * @author ducmanh
 */
public class Main extends javax.swing.JFrame {

    private List<CongNhan> listCN;
    private List<Xuong> listXuong;
    private List<BangChamCong> listBangCC;
    private DefaultTableModel tmCN, tmXuong, tmBangCC;

    private String fCN, fXuong, fBangCC;

    public Main() {
        initComponents();
        fCN = "src/controller/CN.dat";
        fXuong = "src/controller/XUONG.dat";
        fBangCC = "src/controller/BangCC.dat";
        if (new File(fCN).exists()) {
            listCN = IOFile.doc(fCN);
        } else {
            listCN = new ArrayList<>();
        }
        if (new File(fXuong).exists()) {
            listXuong = IOFile.doc(fXuong);
        } else {
            listXuong = new ArrayList<>();
        }
        if (new File(fBangCC).exists()) {
            listBangCC = IOFile.doc(fBangCC);
        } else {
            listBangCC = new ArrayList<>();
        }
        
        tmXuong = (DefaultTableModel) tbXuong.getModel();
        tmCN = (DefaultTableModel) tbCN.getModel();
        tmBangCC = (DefaultTableModel) tbBangCC.getModel();
        docCN();
        docXuong();
        docBangCC();
        setButtonCN(true);
        setButtonXuong(true);
        eventCN();
        eventXuong();
        eventBangCC();
        
    }

    private void docCN() {
        tmCN.setRowCount(0);
        for (CongNhan i : listCN) {
            tmCN.addRow(i.toObject());
        }
    }

    private void docXuong() {
        tmXuong.setRowCount(0);
        for (Xuong i : listXuong) {
            tmXuong.addRow(i.toObject());
        }
    }
    
    private void docBangCC() {
        tmBangCC.setRowCount(0);
        for (BangChamCong i : listBangCC) {
            tmBangCC.addRow(i.toObject());
        }
    }
    private void setButtonCN(boolean b) {
        themCNBT.setEnabled(b);
        capnhatCNBT.setEnabled(!b);
        boquaCNBT.setEnabled(!b);
    }

    private void setButtonXuong(boolean b) {
        themXBT.setEnabled(b);
        capnhatXBT.setEnabled(!b);
        boquaXBT.setEnabled(!b);
    }
    
    private void setButtonBangCC(boolean b) {
        
        capnhatXBT.setEnabled(!b);
        boquaXBT.setEnabled(!b);
    }
    
    private void eventCN() {
        themCNBT.addActionListener(e -> {
            maCN.setText((1000 + listCN.size()) + "");

            hotenCN.requestFocus();
            setButtonCN(false);
        });

        capnhatCNBT.addActionListener(e -> {
            try {
                if (!sdtCN.getText().matches("\\d+")) {
                    throw new ValidException("Dien thoai nhap so");
                }
                CongNhan c = new CongNhan(Integer.parseInt(maCN.getText()),
                        hotenCN.getText(),
                        diachiCN.getText(),
                        sdtCN.getText(),
                        Integer.parseInt(bacCN.getSelectedItem().toString())
                );
                listCN.add(c);
                tmCN.addRow(c.toObject());
                setButtonCN(true);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
                sdtCN.setText("");
                sdtCN.requestFocus();
            }
        });
        XoaCNBT.addActionListener(e -> {
            int row = tbCN.getSelectedRow();
            if (row >= 0 && row < tbCN.getRowCount()) {
                listCN.remove(row);
                tmCN.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }

        });
        luuCNBT.addActionListener(e -> {
            IOFile.ghi(fCN, listCN);
        });
        boquaCNBT.addActionListener(e -> {
            setButtonCN(true);
        });
    }

    private void eventXuong() {
        themXBT.addActionListener(e -> {
            maXuong.setText((100 + listXuong.size()) + "");
            
            tenXuong.requestFocus();
            setButtonXuong(false);
        });

        capnhatXBT.addActionListener(e -> {
            Xuong x = new Xuong(Integer.parseInt(maXuong.getText()),
                    tenXuong.getText(),
                    Integer.parseInt(hesoXuong.getSelectedItem().toString())
            );
            listXuong.add(x);
            tmXuong.addRow(x.toObject());
            setButtonXuong(true);

        });
        suaXBT.addActionListener(e -> {
            int row = tbXuong.getSelectedRow();
            if (row >= 0 && row < tbXuong.getRowCount()) {
                Xuong x = new Xuong(Integer.parseInt(maXuong.getText()),
                    tenXuong.getText(),
                    Integer.parseInt(hesoXuong.getSelectedItem().toString())
            );
                listXuong.set(row,x);
                tmXuong.removeRow(row);
                tmXuong.insertRow(row, x.toObject());
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de sua");
            }

        });
        luuXBT.addActionListener(e -> {
            IOFile.ghi(fXuong, listXuong);
        });
        boquaCNBT.addActionListener(e -> {
            setButtonXuong(true);
        });
    }
    
    private int getSoNgay(int maCN){
        int so = 0;
        for(BangChamCong i : listBangCC){
            if(i.getCongnhan().getMa() == maCN){
                so += i.getSongay();
            }
        }
        return so;
    }
    
    private CongNhan getCongNhan(int ma){
        for(CongNhan i : listCN){
            if(i.getMa() == ma){
                return i;
            }
        }
        return null;
    }
    
    private Xuong getXuong(int ma){
        for(Xuong i : listXuong){
            if(i.getMa() == ma){
                return i;
            }
        }
        return null;
    }
    
    public void eventBangCC(){
        refreshBTN.addActionListener(e -> {
            maCNCB.removeAllItems();
            for(CongNhan i : listCN){
                maCNCB.addItem(i.getMa()+"");
            }
            maXuongCB.removeAllItems();
            for(Xuong i : listXuong){
                maXuongCB.addItem(i.getMa()+"");
            }
        });
        themBangCCBTN.addActionListener(e -> {
            try {
                int maCN = Integer.parseInt(maCNCB.getSelectedItem().toString());
                int maXuong = Integer.parseInt(maXuongCB.getSelectedItem().toString());
                int ngay = Integer.parseInt(soNgay.getText());
                if (getSoNgay(maCN) + ngay > 31) {
                    JOptionPane.showMessageDialog(this, "So ngay lon hon 31");

                } else {
                    BangChamCong b = new BangChamCong(getCongNhan(maCN), getXuong(maXuong), ngay);
                    listBangCC.add(b);
                    tmBangCC.addRow(b.toObject());

                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap so");
            }
        });
        luuBangCC.addActionListener(e -> {
            IOFile.ghi(fBangCC, listBangCC);
        });
        sapxepBangCCBTN.addActionListener(e -> {
            int index = sapxepCB.getSelectedIndex();
            if (index == 0) {
                listBangCC.sort((BangChamCong o1, BangChamCong o2) -> {
                    String[] t1 = o1.getCongnhan().getHoten().split("");
                    String[] t2 = o2.getCongnhan().getHoten().split("");
                    String ten1 = t1[t1.length-1] + o1.getCongnhan().getHoten();
                    String ten2 = t2[t2.length-1] + o2.getCongnhan().getHoten();
                    return ten1.compareToIgnoreCase(ten2);
                });
            }
            if(index == 1){
                listBangCC.sort((BangChamCong o1, BangChamCong o2) -> o1.getSongay() - o2.getSongay());
            }
            tmBangCC.setRowCount(0);
            for(BangChamCong i : listBangCC){
                tmBangCC.addRow(i.toObject());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCN = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maCN = new javax.swing.JTextField();
        hotenCN = new javax.swing.JTextField();
        diachiCN = new javax.swing.JTextField();
        sdtCN = new javax.swing.JTextField();
        bacCN = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        themCNBT = new javax.swing.JButton();
        capnhatCNBT = new javax.swing.JButton();
        boquaCNBT = new javax.swing.JButton();
        XoaCNBT = new javax.swing.JButton();
        luuCNBT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbXuong = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        maXuong23 = new javax.swing.JLabel();
        tenXuong22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        maXuong = new javax.swing.JTextField();
        tenXuong = new javax.swing.JTextField();
        hesoXuong = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        themXBT = new javax.swing.JButton();
        capnhatXBT = new javax.swing.JButton();
        boquaXBT = new javax.swing.JButton();
        suaXBT = new javax.swing.JButton();
        luuXBT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBangCC = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        maCNCB = new javax.swing.JComboBox<>();
        maXuongCB = new javax.swing.JComboBox<>();
        soNgay = new javax.swing.JTextField();
        sapxepCB = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        themBangCCBTN = new javax.swing.JButton();
        luuBangCC = new javax.swing.JButton();
        sapxepBangCCBTN = new javax.swing.JButton();
        refreshBTN = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma", " Ho va Ten", "Dia chi", "SDT", "Bac"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCN);
        if (tbCN.getColumnModel().getColumnCount() > 0) {
            tbCN.getColumnModel().getColumn(4).setHeaderValue("Bac");
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Ma :");

        jLabel2.setText("Ho va Ten :");

        jLabel3.setText("Dia Chi :");

        jLabel4.setText("Dien Thoai :");

        jLabel5.setText("Bac : ");

        maCN.setEditable(false);

        diachiCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diachiCNActionPerformed(evt);
            }
        });

        sdtCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtCNActionPerformed(evt);
            }
        });

        bacCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        bacCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(104, 104, 104)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maCN)
                    .addComponent(hotenCN)
                    .addComponent(diachiCN)
                    .addComponent(sdtCN)
                    .addComponent(bacCN, 0, 179, Short.MAX_VALUE))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(hotenCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(diachiCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sdtCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(bacCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        themCNBT.setText("Them moi");
        themCNBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themCNBTActionPerformed(evt);
            }
        });

        capnhatCNBT.setText("Cap Nhat");
        capnhatCNBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatCNBTActionPerformed(evt);
            }
        });

        boquaCNBT.setText("Bo Qua");

        XoaCNBT.setText("Xoa");

        luuCNBT.setText("Luu File");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(themCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capnhatCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boquaCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(XoaCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuCNBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(themCNBT)
                .addGap(18, 18, 18)
                .addComponent(capnhatCNBT)
                .addGap(18, 18, 18)
                .addComponent(boquaCNBT)
                .addGap(18, 18, 18)
                .addComponent(XoaCNBT)
                .addGap(18, 18, 18)
                .addComponent(luuCNBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cong Nhan", jPanel1);

        tbXuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ma", "Ten Xuong", "He So"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbXuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbXuongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbXuong);

        maXuong23.setText("Ma :");

        tenXuong22.setText("Ten Xuong");

        jLabel10.setText("He So CV");

        maXuong.setEditable(false);

        tenXuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenXuongActionPerformed(evt);
            }
        });

        hesoXuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));
        hesoXuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hesoXuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maXuong23)
                    .addComponent(tenXuong22)
                    .addComponent(jLabel10))
                .addGap(117, 117, 117)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(maXuong, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(tenXuong))
                    .addComponent(hesoXuong, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maXuong23)
                    .addComponent(maXuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tenXuong22)
                    .addComponent(tenXuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(hesoXuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );

        themXBT.setText("Them moi");
        themXBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themXBTActionPerformed(evt);
            }
        });

        capnhatXBT.setText("Cap Nhat");
        capnhatXBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatXBTActionPerformed(evt);
            }
        });

        boquaXBT.setText("Bo Qua");

        suaXBT.setText("Sua");

        luuXBT.setText("Luu File");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(themXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(capnhatXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boquaXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(suaXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(luuXBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(themXBT)
                .addGap(18, 18, 18)
                .addComponent(capnhatXBT)
                .addGap(18, 18, 18)
                .addComponent(boquaXBT)
                .addGap(18, 18, 18)
                .addComponent(suaXBT)
                .addGap(18, 18, 18)
                .addComponent(luuXBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1072, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(73, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(25, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Xuong San Xuat", jPanel2);

        tbBangCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MaCN", " Ho va Ten", "Ma Xuong", "So ngay Lam Viec"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbBangCC);

        jLabel6.setText("Ma CN :");

        jLabel7.setText("Ma Xuong :");

        jLabel8.setText("So Ngay Lam Viec");

        maCNCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maXuongCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        sapxepCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ho ten Cong Nhan", "So ngay lam viec" }));

        jLabel9.setText("Sap Xep :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(67, 67, 67)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maCNCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maXuongCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(soNgay)
                    .addComponent(sapxepCB, 0, 202, Short.MAX_VALUE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maCNCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(maXuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(soNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sapxepCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(46, 46, 46))
        );

        themBangCCBTN.setText("Them");
        themBangCCBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBangCCBTNActionPerformed(evt);
            }
        });

        luuBangCC.setText("Luu file");

        sapxepBangCCBTN.setText("Sap xep ");
        sapxepBangCCBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sapxepBangCCBTNActionPerformed(evt);
            }
        });

        refreshBTN.setText("Refresh");
        refreshBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sapxepBangCCBTN)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(refreshBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(luuBangCC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(themBangCCBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(themBangCCBTN)
                .addGap(29, 29, 29)
                .addComponent(luuBangCC)
                .addGap(28, 28, 28)
                .addComponent(refreshBTN)
                .addGap(26, 26, 26)
                .addComponent(sapxepBangCCBTN)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 927, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bang Cham Cong", jPanel3);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(675, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(488, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong Ke", jPanel11);

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

    private void diachiCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diachiCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diachiCNActionPerformed

    private void sdtCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtCNActionPerformed

    private void bacCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bacCNActionPerformed

    private void themCNBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themCNBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themCNBTActionPerformed

    private void capnhatCNBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatCNBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capnhatCNBTActionPerformed

    private void tenXuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenXuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenXuongActionPerformed

    private void hesoXuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hesoXuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hesoXuongActionPerformed

    private void themXBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themXBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themXBTActionPerformed

    private void capnhatXBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatXBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capnhatXBTActionPerformed

    private void tbXuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbXuongMouseClicked
        // TODO add your handling code here:
        int row = tbXuong.getSelectedRow();
        if (row >= 0 && row <= tbXuong.getRowCount()) {
            maXuong.setText(tmXuong.getValueAt(row, 0).toString());
            tenXuong.setText(tmXuong.getValueAt(row, 1).toString());
            for (int i = 0; i < hesoXuong.getItemCount(); i++) {
                if (hesoXuong.getItemAt(i).equals(tmXuong.getValueAt(row, 2).toString())) {
                    hesoXuong.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tbXuongMouseClicked

    private void themBangCCBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBangCCBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themBangCCBTNActionPerformed

    private void sapxepBangCCBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sapxepBangCCBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sapxepBangCCBTNActionPerformed

    private void refreshBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBTNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshBTNActionPerformed

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
    private javax.swing.JButton XoaCNBT;
    private javax.swing.JComboBox<String> bacCN;
    private javax.swing.JButton boquaCNBT;
    private javax.swing.JButton boquaXBT;
    private javax.swing.JButton capnhatCNBT;
    private javax.swing.JButton capnhatXBT;
    private javax.swing.JTextField diachiCN;
    private javax.swing.JComboBox<String> hesoXuong;
    private javax.swing.JTextField hotenCN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton luuBangCC;
    private javax.swing.JButton luuCNBT;
    private javax.swing.JButton luuXBT;
    private javax.swing.JTextField maCN;
    private javax.swing.JComboBox<String> maCNCB;
    private javax.swing.JTextField maXuong;
    private javax.swing.JLabel maXuong23;
    private javax.swing.JComboBox<String> maXuongCB;
    private javax.swing.JButton refreshBTN;
    private javax.swing.JButton sapxepBangCCBTN;
    private javax.swing.JComboBox<String> sapxepCB;
    private javax.swing.JTextField sdtCN;
    private javax.swing.JTextField soNgay;
    private javax.swing.JButton suaXBT;
    private javax.swing.JTable tbBangCC;
    private javax.swing.JTable tbCN;
    private javax.swing.JTable tbXuong;
    private javax.swing.JTextField tenXuong;
    private javax.swing.JLabel tenXuong22;
    private javax.swing.JButton themBangCCBTN;
    private javax.swing.JButton themCNBT;
    private javax.swing.JButton themXBT;
    // End of variables declaration//GEN-END:variables
}
