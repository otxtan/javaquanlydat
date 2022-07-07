/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Process.Dat;
import Process.Hoadon;
import Process.Nguoiban;
import Process.Nguoimua;
import Process.Taikhoan;
import java.awt.CardLayout;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author otxtan
 */
public class chucnang extends javax.swing.JFrame {

    /**
     * Creates new form chucnang
     */
    CardLayout cardLayout;
    DefaultTableModel tbqldat = new DefaultTableModel();
    DefaultTableModel tbqlhd = new DefaultTableModel();
    DefaultTableModel tbqthongke = new DefaultTableModel();
    DefaultTableModel tbqlkh = new DefaultTableModel();
    private String tentk, password;

    public chucnang() {
        initComponents();
        String[] cot = {"ID Đất", "ID người bán", "Diện tích", "Vị trí", "Giá bán", "Trạng thái", "Ngày giao bán"};
        tbqldat.setColumnIdentifiers(cot);
        String[] cot1 = {"Mã HĐ", "ID đất", "ID người bán", "ID người mua", "Thành tiền", "Ngày bán"};
        tbqlhd.setColumnIdentifiers(cot1);
        String[] cot2 = {"ID", "CMND", "Họ tên", "Ngày sinh", "Số điệnt thoại", "Địa chỉ"};
        tbqlkh.setColumnIdentifiers(cot2);

        tbqthongke.setColumnIdentifiers(cot1);
        //khoa nut quan ly dat
        txtCmnd.setEnabled(false);
        txtIDdat.setEnabled(true);
        txtIDnguoiban.setEnabled(true);
        txtHoTen.setEnabled(false);
        txtNgaySinh.setEnabled(false);
        txtSDT.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtDienTich.setEnabled(true);
        txtViTri.setEnabled(true);
        txtGiaBan.setEnabled(true);
        cbTrangThai.setEnabled(true);
        txtNgaygiaoban.setEnabled(true);
        btnThem.setEnabled(true);
        btnXoa.setEnabled(true);
        btnTimKiem.setEnabled(true);
        btnLenHoaDon.setEnabled(true);
        btnLuu.setEnabled(false);
        btnKluu.setEnabled(false);
        //khoa nut quan ly hoa don
        txtMaHD.setEnabled(false);
        txtIDdathd.setEnabled(false);
        txtIDnguoibanhd.setEnabled(false);
        txtIDnguoimuahd.setEnabled(false);
        txtTongtienhd.setEnabled(false);
        txtNgaybanhd.setEnabled(false);

        //
        txtidkh.setEnabled(false);
        txtcmndkh.setEnabled(false);
        txthotenkh.setEnabled(false);
        txtngaysinhkh.setEnabled(false);
        txtsdtkh.setEnabled(false);
        txtdiachikh.setEnabled(false);
        btnsuanm.setEnabled(true);
        btnsuanb.setEnabled(true);
        btnluukh.setEnabled(false);
        btnkluukh.setEnabled(false);
        btnLuuhd.setEnabled(false);
        btnKluuhd.setEnabled(false);
        tbView.setModel(tbqldat);
        tbviewhoadon.setModel(tbqlhd);
        tbviewthongke.setModel(tbqthongke);
        tbviewkhach.setModel(tbqlkh);
        cardLayout = (CardLayout) CARD.getLayout();
    }

    public chucnang(String tentk, String password) {
        initComponents();
        String[] cot = {"ID Đất", "ID người bán", "Diện tích", "Vị trí", "Giá bán", "Trạng thái", "Ngày giao bán"};
        tbqldat.setColumnIdentifiers(cot);
        String[] cot1 = {"Mã HĐ", "ID đất", "ID người bán", "ID người mua", "Thành tiền", "Ngày bán"};
        tbqlhd.setColumnIdentifiers(cot1);
        String[] cot2 = {"ID", "CMND", "Họ tên", "Ngày sinh", "Số điệnt thoại", "Địa chỉ"};
        tbqlkh.setColumnIdentifiers(cot2);
        jLabel22.setText("XIN CHÀO "+tentk);
        tbqthongke.setColumnIdentifiers(cot1);
        //khoa nut quan ly dat
        txtCmnd.setEnabled(false);
        txtIDdat.setEnabled(true);
        txtIDnguoiban.setEnabled(true);
        txtHoTen.setEnabled(false);
        txtNgaySinh.setEnabled(false);
        txtSDT.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtDienTich.setEnabled(true);
        txtViTri.setEnabled(true);
        txtGiaBan.setEnabled(true);
        cbTrangThai.setEnabled(true);
        txtNgaygiaoban.setEnabled(true);
        btnThem.setEnabled(true);
        btnXoa.setEnabled(true);
        btnTimKiem.setEnabled(true);
        btnLenHoaDon.setEnabled(true);
        btnLuu.setEnabled(false);
        btnKluu.setEnabled(false);
        //khoa nut quan ly hoa don
        txtMaHD.setEnabled(false);
        txtIDdathd.setEnabled(false);
        txtIDnguoibanhd.setEnabled(false);
        txtIDnguoimuahd.setEnabled(false);
        txtTongtienhd.setEnabled(false);
        txtNgaybanhd.setEnabled(false);

        //
        txtidkh.setEnabled(false);
        txtcmndkh.setEnabled(false);
        txthotenkh.setEnabled(false);
        txtngaysinhkh.setEnabled(false);
        txtsdtkh.setEnabled(false);
        txtdiachikh.setEnabled(false);
        btnsuanm.setEnabled(true);
        btnsuanb.setEnabled(true);
        btnluukh.setEnabled(false);
        btnkluukh.setEnabled(false);
        btnLuuhd.setEnabled(false);
        btnKluuhd.setEnabled(false);
        tbView.setModel(tbqldat);
        tbviewhoadon.setModel(tbqlhd);
        tbviewthongke.setModel(tbqthongke);
        tbviewkhach.setModel(tbqlkh);
        cardLayout = (CardLayout) CARD.getLayout();
        this.tentk = tentk;
        this.password = password;
    }

// phuong thuc tu viet
    public void cleartable() {
        int n = tbqldat.getRowCount() - 1;

        while (n >= 0) {
            tbqldat.removeRow(n);
            n--;
        }
    }

    public void cleartablehd() {
        int n = tbqlhd.getRowCount() - 1;

        while (n >= 0) {
            tbqlhd.removeRow(n);
            n--;
        }
    }

    public void cleartablekh() {
        int n = tbqlkh.getRowCount() - 1;

        while (n >= 0) {
            tbqlkh.removeRow(n);
            n--;
        }
    }

    public void cleartablethongke() {
        int n = tbqthongke.getRowCount() - 1;

        while (n >= 0) {
            tbqthongke.removeRow(n);
            n--;
        }
    }

    public void shownguoiban() {
        Nguoiban nb = new Nguoiban();
        List<Nguoiban> list = nb.getallnguoiban();
        for (int i = 0; i < list.size(); i++) {
            String row[] = new String[6];
            row[0] = String.valueOf(list.get(i).getId_nguoiban());
            row[1] = list.get(i).getCmnd();
            row[2] = list.get(i).getHoten();
            row[3] = list.get(i).getNgaysinh();
            row[4] = list.get(i).getSodienthoai();
            row[5] = list.get(i).getDiachi();

            tbqlkh.addRow(row);
        }
    }

    public void shownguoimua() {
        Nguoimua nb = new Nguoimua();
        List<Nguoimua> list = nb.getallnguoimua();
        for (int i = 0; i < list.size(); i++) {
            String row[] = new String[6];
            row[0] = String.valueOf(list.get(i).getId_nguoimua());
            row[1] = list.get(i).getCmnd();
            row[2] = list.get(i).getHoten();
            row[3] = list.get(i).getNgaysinh();
            row[4] = list.get(i).getSodienthoai();
            row[5] = list.get(i).getDiachi();

            tbqlkh.addRow(row);
        }
    }

    public void showdat() {
        Dat dat = new Dat();
        List<Dat> list = dat.getAll();

        for (int i = 0; i < list.size(); i++) {
            String row[] = new String[7];
            row[0] = String.valueOf(list.get(i).getId_dat());
            row[1] = String.valueOf(list.get(i).getId_nguoiban());
            row[2] = Double.toString(list.get(i).getDientich());
            row[3] = list.get(i).getVitri();
            row[4] = String.valueOf(list.get(i).getGiaban());
            row[5] = list.get(i).getTrangthai();
            row[6] = list.get(i).getNgaygiaoban();
            tbqldat.addRow(row);

        }

    }

    //hien thi tat ca hoa don
    public void showHD() {
        Hoadon hd = new Hoadon();
        List<Hoadon> list = hd.getALLHD();

        for (int i = 0; i < list.size(); i++) {
            String row[] = new String[6];
            row[0] = String.valueOf(list.get(i).getId_hoadon());
            row[1] = String.valueOf(list.get(i).getId_dat());
            row[2] = String.valueOf(list.get(i).getId_nguoiban());
            row[3] = String.valueOf(list.get(i).getId_nguoimua());
            row[4] = String.valueOf(list.get(i).getTongtien());
            row[5] = list.get(i).getNgayban();

            tbqlhd.addRow(row);

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btndoipass = new javax.swing.JButton();
        CARD = new javax.swing.JPanel();
        QLDAT = new javax.swing.JPanel();
        viewdat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbView = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbtime = new javax.swing.JLabel();
        txtIDdat = new javax.swing.JTextField();
        txtIDnguoiban = new javax.swing.JTextField();
        txtViTri = new javax.swing.JTextField();
        txtDienTich = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        cbTrangThai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnLenHoaDon = new javax.swing.JButton();
        lbhienthi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnKluu = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        txtNgaygiaoban = new javax.swing.JTextField();
        txtTimkiem = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtCmnd = new javax.swing.JTextField();
        QLHOADON = new javax.swing.JPanel();
        Viewhoadon = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtIDdathd = new javax.swing.JTextField();
        txtIDnguoibanhd = new javax.swing.JTextField();
        txtIDnguoimuahd = new javax.swing.JTextField();
        txtTongtienhd = new javax.swing.JTextField();
        txtNgaybanhd = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbviewhoadon = new javax.swing.JTable();
        btnSuahd = new javax.swing.JButton();
        btnXoahd = new javax.swing.JButton();
        btnTimkiemhd = new javax.swing.JButton();
        txttimkiemhd = new javax.swing.JTextField();
        btnLuuhd = new javax.swing.JButton();
        btnKluuhd = new javax.swing.JButton();
        btnLmmoi = new javax.swing.JButton();
        THONGKE = new javax.swing.JPanel();
        Viewthongke = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbThang = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbviewthongke = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        txttienthang = new javax.swing.JFormattedTextField();
        btnXemthongke = new javax.swing.JButton();
        DOIPASS = new javax.swing.JPanel();
        viewKH = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtidkh = new javax.swing.JTextField();
        txtcmndkh = new javax.swing.JTextField();
        txthotenkh = new javax.swing.JTextField();
        txtngaysinhkh = new javax.swing.JTextField();
        txtsdtkh = new javax.swing.JTextField();
        txtdiachikh = new javax.swing.JTextField();
        btnsuanb = new javax.swing.JButton();
        btnsuanm = new javax.swing.JButton();
        btnluukh = new javax.swing.JButton();
        btnkluukh = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbviewkhach = new javax.swing.JTable();
        cbkhach = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setOpaque(false);

        jSplitPane1.setEnabled(false);

        jPanel6.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setText("QUẢN LÝ ĐẤT");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setText("QUẢN LÝ HÓA ĐƠN");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 255));
        jButton3.setText("THỐNG KÊ");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 255, 255));
        jButton5.setText("ĐĂNG XUẤT");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btndoipass.setBackground(new java.awt.Color(204, 255, 255));
        btndoipass.setText("QUẢN LÝ KHÁCH HÀNG");
        btndoipass.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btndoipass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoipassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btndoipass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndoipass, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jSplitPane1.setLeftComponent(jPanel6);

        CARD.setLayout(new java.awt.CardLayout());

        viewdat.setBackground(new java.awt.Color(255, 255, 255));

        tbView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Đất", "ID người bán", "Diện tích", "Vị Trí", "Giá bán", "Trạng thái", "Ngày giao bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbView.setGridColor(new java.awt.Color(204, 204, 204));
        tbView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbView);

        jLabel3.setText("ID đất:");

        jLabel4.setText("ID người bán:");

        jLabel5.setText("Vị trí:");

        jLabel6.setText("Diện tích:");

        jLabel7.setText("Giá bán:");

        jLabel8.setText("Trạng thái:");

        lbtime.setText("Ngày giao bán:");

        txtIDdat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIDdat.setEnabled(false);
        txtIDdat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDdatActionPerformed(evt);
            }
        });

        txtIDnguoiban.setToolTipText("");
        txtIDnguoiban.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIDnguoiban.setEnabled(false);
        txtIDnguoiban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDnguoibanActionPerformed(evt);
            }
        });

        txtViTri.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDienTich.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtGiaBan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa bán", "Đã bán" }));
        cbTrangThai.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnThem.setBackground(new java.awt.Color(204, 255, 255));
        btnThem.setBorder(null);
        btnThem.setLabel("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(204, 255, 255));
        btnSua.setBorder(null);
        btnSua.setLabel("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setBorder(null);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(204, 255, 255));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(null);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnLenHoaDon.setBackground(new java.awt.Color(204, 255, 255));
        btnLenHoaDon.setText("Lên hóa đơn");
        btnLenHoaDon.setBorder(null);
        btnLenHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLenHoaDonActionPerformed(evt);
            }
        });

        lbhienthi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbhienthi.setText("Trước khi thêm, lên hóa đơn vui lòng nhập thông tin khách hàng");

        jLabel11.setText("Địa chỉ:");

        jLabel12.setText("Họ Tên:");

        jLabel14.setText("Ngày sinh:");

        jLabel16.setText("Số điện thoại:");

        txtHoTen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSDT.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtDiaChi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLuu.setBackground(new java.awt.Color(204, 255, 255));
        btnLuu.setText("Lưu");
        btnLuu.setBorder(null);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnKluu.setBackground(new java.awt.Color(204, 255, 255));
        btnKluu.setText("Quay lại");
        btnKluu.setBorder(null);
        btnKluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKluuActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(204, 255, 255));
        jButton10.setText("Làm mới");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        txtNgaygiaoban.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTimkiem.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập (Id,diện tích, giá tiền,....) muốn tìm kiếm:"));

        txtNgaySinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setText("CMND:");

        javax.swing.GroupLayout viewdatLayout = new javax.swing.GroupLayout(viewdat);
        viewdat.setLayout(viewdatLayout);
        viewdatLayout.setHorizontalGroup(
            viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewdatLayout.createSequentialGroup()
                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewdatLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(lbhienthi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(viewdatLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewdatLayout.createSequentialGroup()
                                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewdatLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewdatLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtGiaBan)
                                            .addComponent(txtDienTich))
                                        .addGap(18, 18, 18)
                                        .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8))
                                        .addGap(447, 447, 447))
                                    .addGroup(viewdatLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                            .addComponent(txtIDdat))
                                        .addGap(18, 18, 18)
                                        .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(viewdatLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(viewdatLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtIDnguoiban, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(viewdatLayout.createSequentialGroup()
                                                .addGap(89, 89, 89)
                                                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(viewdatLayout.createSequentialGroup()
                                                        .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbtime)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txtNgaygiaoban, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(viewdatLayout.createSequentialGroup()
                                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(viewdatLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(viewdatLayout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(406, 406, 406)))
                                .addGap(0, 132, Short.MAX_VALUE)))))
                .addGap(84, 84, 84)
                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLenHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKluu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addGroup(viewdatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        viewdatLayout.setVerticalGroup(
            viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewdatLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbhienthi)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewdatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLenHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(viewdatLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(txtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(viewdatLayout.createSequentialGroup()
                                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtIDnguoiban, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(viewdatLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIDdat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))))
                .addGap(18, 18, 18)
                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDienTich, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnKluu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtViTri, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtime)
                    .addComponent(txtNgaygiaoban, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewdatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout QLDATLayout = new javax.swing.GroupLayout(QLDAT);
        QLDAT.setLayout(QLDATLayout);
        QLDATLayout.setHorizontalGroup(
            QLDATLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewdat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        QLDATLayout.setVerticalGroup(
            QLDATLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewdat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CARD.add(QLDAT, "QLDAT");

        QLHOADON.setBackground(new java.awt.Color(255, 255, 255));

        Viewhoadon.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Mã hóa đơn:");

        jLabel15.setText("ID đất");

        jLabel17.setText("ID người bán");

        jLabel18.setText("ID người mua");

        jLabel20.setText("Tổng tiền");

        jLabel21.setText("Ngày bán:");

        tbviewhoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "ID đất", "ID người bán", "ID người mua", "Tổng tiền", "Ngày bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbviewhoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbviewhoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbviewhoadon);

        btnSuahd.setBackground(new java.awt.Color(204, 255, 255));
        btnSuahd.setText("Sửa");
        btnSuahd.setBorder(null);
        btnSuahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuahdActionPerformed(evt);
            }
        });

        btnXoahd.setBackground(new java.awt.Color(204, 255, 255));
        btnXoahd.setText("Xóa");
        btnXoahd.setBorder(null);
        btnXoahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoahdActionPerformed(evt);
            }
        });

        btnTimkiemhd.setBackground(new java.awt.Color(204, 255, 255));
        btnTimkiemhd.setText("Tìm kiếm");
        btnTimkiemhd.setBorder(null);
        btnTimkiemhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemhdActionPerformed(evt);
            }
        });

        txttimkiemhd.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhập thông tin tìm kiếm:(Id, tổng tiền, ngày bán,...)"));

        btnLuuhd.setBackground(new java.awt.Color(204, 255, 255));
        btnLuuhd.setText("Lưu");
        btnLuuhd.setBorder(null);
        btnLuuhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuhdActionPerformed(evt);
            }
        });

        btnKluuhd.setBackground(new java.awt.Color(204, 255, 255));
        btnKluuhd.setText("Quaylại");
        btnKluuhd.setBorder(null);
        btnKluuhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKluuhdActionPerformed(evt);
            }
        });

        btnLmmoi.setBackground(new java.awt.Color(204, 255, 255));
        btnLmmoi.setText("Làm mới");
        btnLmmoi.setBorder(null);

        javax.swing.GroupLayout ViewhoadonLayout = new javax.swing.GroupLayout(Viewhoadon);
        Viewhoadon.setLayout(ViewhoadonLayout);
        ViewhoadonLayout.setHorizontalGroup(
            ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewhoadonLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewhoadonLayout.createSequentialGroup()
                        .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewhoadonLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIDnguoimuahd, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                            .addGroup(ViewhoadonLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaHD)))
                        .addGap(20, 20, 20)
                        .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIDdathd, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(txtTongtienhd))
                        .addGap(62, 62, 62)
                        .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgaybanhd, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtIDnguoibanhd))
                        .addGap(34, 34, 34)
                        .addComponent(btnLmmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoahd, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(btnSuahd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ViewhoadonLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(ViewhoadonLayout.createSequentialGroup()
                                .addComponent(txttimkiemhd)
                                .addGap(179, 179, 179)))
                        .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ViewhoadonLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnTimkiemhd, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(btnKluuhd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(btnLuuhd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        ViewhoadonLayout.setVerticalGroup(
            ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewhoadonLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtIDdathd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtIDnguoibanhd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuahd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLmmoi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(txtIDnguoimuahd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongtienhd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaybanhd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoahd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttimkiemhd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimkiemhd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ViewhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ViewhoadonLayout.createSequentialGroup()
                        .addComponent(btnLuuhd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKluuhd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout QLHOADONLayout = new javax.swing.GroupLayout(QLHOADON);
        QLHOADON.setLayout(QLHOADONLayout);
        QLHOADONLayout.setHorizontalGroup(
            QLHOADONLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Viewhoadon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        QLHOADONLayout.setVerticalGroup(
            QLHOADONLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Viewhoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CARD.add(QLHOADON, "QLHOADON");

        THONGKE.setBackground(new java.awt.Color(255, 255, 255));

        Viewthongke.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Thống kê theo tháng:");

        cbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel19.setText("THỐNG KÊ DOANH SỐ");

        tbviewthongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "ID người bán", "ID người mua", "Thành tiền", "Ngày bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbviewthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbviewthongkeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbviewthongke);

        jLabel23.setText("TỔNG CỘNG:");

        txttienthang.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.### vnd"))));

        btnXemthongke.setBackground(new java.awt.Color(204, 255, 255));
        btnXemthongke.setText("Xem");
        btnXemthongke.setBorder(null);
        btnXemthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemthongkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewthongkeLayout = new javax.swing.GroupLayout(Viewthongke);
        Viewthongke.setLayout(ViewthongkeLayout);
        ViewthongkeLayout.setHorizontalGroup(
            ViewthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewthongkeLayout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ViewthongkeLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(ViewthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ViewthongkeLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXemthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttienthang, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        ViewthongkeLayout.setVerticalGroup(
            ViewthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewthongkeLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(ViewthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ViewthongkeLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(ViewthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnXemthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txttienthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout THONGKELayout = new javax.swing.GroupLayout(THONGKE);
        THONGKE.setLayout(THONGKELayout);
        THONGKELayout.setHorizontalGroup(
            THONGKELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Viewthongke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        THONGKELayout.setVerticalGroup(
            THONGKELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Viewthongke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CARD.add(THONGKE, "THONGKE");

        DOIPASS.setBackground(new java.awt.Color(255, 255, 255));

        viewKH.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("ID khách hàng:");

        jLabel27.setText("CMND:");

        jLabel28.setText("Họ tên:");

        jLabel29.setText("Ngày sinh:");

        jLabel30.setText("Số điện thoại:");

        jLabel31.setText("Địa chỉ:");

        txtdiachikh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachikhActionPerformed(evt);
            }
        });

        btnsuanb.setBackground(new java.awt.Color(204, 255, 255));
        btnsuanb.setText("Sửa thông tin người bán");
        btnsuanb.setBorder(null);
        btnsuanb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuanbActionPerformed(evt);
            }
        });

        btnsuanm.setBackground(new java.awt.Color(204, 255, 255));
        btnsuanm.setText("Sửa thông tin người mua");
        btnsuanm.setBorder(null);
        btnsuanm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuanmActionPerformed(evt);
            }
        });

        btnluukh.setBackground(new java.awt.Color(204, 255, 255));
        btnluukh.setText("Lưu");
        btnluukh.setBorder(null);
        btnluukh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluukhActionPerformed(evt);
            }
        });

        btnkluukh.setBackground(new java.awt.Color(204, 255, 255));
        btnkluukh.setText("Quay lại");
        btnkluukh.setBorder(null);
        btnkluukh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkluukhActionPerformed(evt);
            }
        });

        tbviewkhach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID người mua", "CMND", "Họ tên", "Ngày sinh", "Số điện thoại", "Địa chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbviewkhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbviewkhachMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbviewkhach);

        cbkhach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "bán", "mua" }));

        jButton6.setBackground(new java.awt.Color(204, 255, 255));
        jButton6.setText("Xem");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewKHLayout = new javax.swing.GroupLayout(viewKH);
        viewKH.setLayout(viewKHLayout);
        viewKHLayout.setHorizontalGroup(
            viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewKHLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewKHLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(viewKHLayout.createSequentialGroup()
                        .addComponent(txthotenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel31))
                    .addGroup(viewKHLayout.createSequentialGroup()
                        .addComponent(txtcmndkh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel29))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, viewKHLayout.createSequentialGroup()
                        .addComponent(txtidkh, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel30)))
                .addGap(18, 18, 18)
                .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsdtkh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngaysinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viewKHLayout.createSequentialGroup()
                        .addComponent(txtdiachikh, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbkhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnkluukh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnsuanb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnsuanm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnluukh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(193, 193, 193))
        );
        viewKHLayout.setVerticalGroup(
            viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewKHLayout.createSequentialGroup()
                .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewKHLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtidkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(txtsdtkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcmndkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(jLabel29)
                                .addComponent(txtngaysinhkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtdiachikh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbkhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthotenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)))
                    .addGroup(viewKHLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnsuanb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsuanm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnluukh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnkluukh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout DOIPASSLayout = new javax.swing.GroupLayout(DOIPASS);
        DOIPASS.setLayout(DOIPASSLayout);
        DOIPASSLayout.setHorizontalGroup(
            DOIPASSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOIPASSLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(viewKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DOIPASSLayout.setVerticalGroup(
            DOIPASSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DOIPASSLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(viewKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        CARD.add(DOIPASS, "DOIPASS");

        jSplitPane1.setRightComponent(CARD);

        jLabel22.setText("XIN CHÀO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(56, 56, 56)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jPanel1, gridBagConstraints);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chucnag.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jLabel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        showdat();
        showHD();


    }//GEN-LAST:event_formWindowOpened

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CARD, "THONGKE");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CARD, "QLDAT");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CARD, "QLHOADON");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIDdatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDdatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDdatActionPerformed

    private void txtIDnguoibanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDnguoibanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDnguoibanActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        // khoa nut
        lbhienthi.setText("Nhập thông tin người bán -> thông tin mảnh đất");
        txtCmnd.setEnabled(true);
        txtIDdat.setEnabled(false);
        txtIDnguoiban.setEnabled(false);
        txtHoTen.setEnabled(true);
        txtNgaySinh.setEnabled(true);
        txtSDT.setEnabled(true);
        txtDiaChi.setEnabled(true);
        txtDienTich.setEnabled(true);
        txtViTri.setEnabled(true);
        txtGiaBan.setEnabled(true);
        cbTrangThai.setEnabled(true);

        btnThem.setEnabled(true);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);

        btnTimKiem.setEnabled(false);
        btnLenHoaDon.setEnabled(false);
        btnLuu.setEnabled(true);
        btnKluu.setEnabled(true);


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        txtHoTen.setEnabled(false);
        txtNgaySinh.setEnabled(false);
        txtSDT.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtDienTich.setEnabled(true);
        txtViTri.setEnabled(true);
        txtGiaBan.setEnabled(true);
        cbTrangThai.setEnabled(true);
        txtIDdat.setEnabled(false);
        txtIDnguoiban.setEnabled(true);
        txtNgaygiaoban.setEnabled(true);
        btnThem.setEnabled(false);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(false);
        btnTimKiem.setEnabled(false);
        btnLenHoaDon.setEnabled(false);
        btnLuu.setEnabled(true);
        btnKluu.setEnabled(true);

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        //them
        Dat dat = new Dat();
        Nguoiban nguoiban = new Nguoiban();
        Nguoimua nguoimua = new Nguoimua();

        if (btnThem.isEnabled()) {
            if (!txtHoTen.getText().equals("") && !txtNgaySinh.getText().equals("") && !txtSDT.getText().equals("") && !txtDiaChi.getText().equals("") && !txtDienTich.getText().equals("") && !txtViTri.getText().equals("") && !txtGiaBan.getText().equals("") && !txtNgaygiaoban.getText().equals("")) {
                nguoiban.setCmnd(txtCmnd.getText());
                nguoiban.setHoten(txtHoTen.getText());
                nguoiban.setNgaysinh(txtNgaySinh.getText());
                nguoiban.setSodienthoai(txtSDT.getText());
                nguoiban.setDiachi(txtDiaChi.getText());
                dat.setDientich(Double.parseDouble(txtDienTich.getText()));
                dat.setVitri(txtViTri.getText());
                dat.setGiaban(Integer.parseInt(txtGiaBan.getText()));
                dat.setTrangthai((cbTrangThai.getSelectedItem().toString()));
                dat.setNgaygiaoban(txtNgaygiaoban.getText());
                if (dat.addDat(nguoiban, dat, txtCmnd.getText())) {
                    cleartable();
                    showdat();
                    JOptionPane.showMessageDialog(rootPane, " Thêm thành công");

                } else {
                    JOptionPane.showMessageDialog(rootPane, " Thêm thất bại");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhấp đầy đủ thông tin");
            }

        }
        //sua
        if (btnSua.isEnabled()) {
            dat.setId_dat(Integer.parseInt(txtIDdat.getText()));
            dat.setId_nguoiban(Integer.parseInt(txtIDnguoiban.getText()));
            double dientich = Double.parseDouble(txtDienTich.getText());
            dat.setDientich(dientich);
            dat.setVitri(txtViTri.getText());
            dat.setGiaban(Integer.parseInt(txtGiaBan.getText()));
            dat.setTrangthai(cbTrangThai.getSelectedItem().toString());
            dat.setNgaygiaoban(txtNgaygiaoban.getText());

            if (dat.Suadat(dat)) {
                cleartable();
                showdat();
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thất bại");
            }

        }
        // xoa 
        if (btnXoa.isEnabled()) {
            int id_dat = Integer.parseInt(txtIDdat.getText());
            if (dat.deleteDat(id_dat)) {
                cleartable();
                showdat();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thất bại");
            }

        }
//        len hoa don
        if (btnLenHoaDon.isEnabled()) {
            if (!cbTrangThai.getSelectedItem().toString().equals("Đã bán")) {
                if (!txtHoTen.getText().equals("") && !txtNgaySinh.getText().equals("") && !txtSDT.getText().equals("") && !txtDiaChi.getText().equals("") && !txtDienTich.getText().equals("") && !txtViTri.getText().equals("") && !txtGiaBan.getText().equals("") && !txtNgaygiaoban.getText().equals("")) {
                    nguoimua.setCmnd(txtCmnd.getText());
                    nguoimua.setHoten(txtHoTen.getText());
                    nguoimua.setNgaysinh(txtNgaySinh.getText());
                    nguoimua.setSodienthoai(txtSDT.getText());
                    nguoimua.setDiachi(txtDiaChi.getText());

                    if (dat.lenHoaDon(nguoimua, txtCmnd.getText(), Integer.parseInt(txtIDdat.getText()), Integer.parseInt(txtIDnguoiban.getText()), Integer.parseInt(txtGiaBan.getText()), txtNgaygiaoban.getText())) {
                        cleartable();
                        cleartablehd();
                        showdat();
                        showHD();
                        JOptionPane.showMessageDialog(rootPane, "Lên hóa đơn thành công");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "lên hóa đơn Thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Vui lòng nhấp đầy đủ thông tin");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Mảnh đất đã được bán vui lòng chọn mảnh khác");
            }

        }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        txtIDdat.setEnabled(true);
        txtIDnguoiban.setEnabled(false);
        txtHoTen.setEnabled(false);
        txtNgaySinh.setEnabled(false);
        txtSDT.setEnabled(false);
        txtDienTich.setEnabled(false);
        txtViTri.setEnabled(false);
        txtGiaBan.setEnabled(false);
        cbTrangThai.setEnabled(true);
        txtDiaChi.setEnabled(false);
        txtNgaygiaoban.setEnabled(false);
        btnThem.setEnabled(false);
        btnXoa.setEnabled(true);
        btnSua.setEnabled(false);
        btnTimKiem.setEnabled(false);
        btnLenHoaDon.setEnabled(false);
        btnLuu.setEnabled(true);
        btnKluu.setEnabled(true);
    }//GEN-LAST:event_btnXoaActionPerformed
// lam moi

    public void lammoidat() {
        txtHoTen.setText("");
        txtNgaySinh.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtIDdat.setText("");
        txtIDnguoiban.setText("");
        txtNgaygiaoban.setText("");
        txtDienTich.setText("");
        txtViTri.setText("");
        txtGiaBan.setText("");

    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        lammoidat();
        cleartable();
        showdat();

    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnKluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKluuActionPerformed
        // TODO add your handling code here:
        txtCmnd.setEnabled(false);
        txtIDdat.setEnabled(true);
        txtHoTen.setEnabled(false);
        txtNgaySinh.setEnabled(false);
        txtSDT.setEnabled(false);
        txtDiaChi.setEnabled(false);
        txtDienTich.setEnabled(true);
        txtViTri.setEnabled(true);
        txtGiaBan.setEnabled(true);
        cbTrangThai.setEnabled(true);
        txtNgaygiaoban.setEnabled(true);
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnTimKiem.setEnabled(true);
        btnLenHoaDon.setEnabled(true);
        btnLuu.setEnabled(false);
        btnKluu.setEnabled(false);
        lbtime.setText("Ngày giao bán:");
        lammoidat();
    }//GEN-LAST:event_btnKluuActionPerformed

    private void tbViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbViewMouseClicked
        // TODO add your handling code here:
        Dat dat = new Dat();
        int row = this.tbView.getSelectedRow();
        String id_dat = (this.tbView.getModel().getValueAt(row, 0).toString());
        int iddat = Integer.parseInt(id_dat);
        Dat dat1 = dat.getTheoId(iddat);
        if (dat1 != null) {
            txtIDdat.setText(String.valueOf(dat1.getId_dat()));
            txtIDnguoiban.setText(String.valueOf(dat1.getId_nguoiban()));
            txtDienTich.setText(String.valueOf(dat1.getDientich()));
            txtViTri.setText(dat1.getVitri());
            txtGiaBan.setText(String.valueOf(dat1.getGiaban()));
            if (dat1.getTrangthai().equals("Chưa bán")) {
                cbTrangThai.setSelectedIndex(0);
            } else if (dat1.getTrangthai().equals("Đã bán")) {
                cbTrangThai.setSelectedIndex(1);
            }
            txtNgaygiaoban.setText(dat1.getNgaygiaoban());
        }

    }//GEN-LAST:event_tbViewMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        Dat dat = new Dat();
        cleartable();
        List<Dat> list = dat.searchDat(txtTimkiem.getText());

        for (int i = 0; i < list.size(); i++) {
            String row[] = new String[7];
            row[0] = String.valueOf(list.get(i).getId_dat());
            row[1] = String.valueOf(list.get(i).getId_nguoiban());
            row[2] = String.valueOf(list.get(i).getDientich());
            row[3] = list.get(i).getVitri();
            row[4] = String.valueOf(list.get(i).getGiaban());
            row[5] = list.get(i).getTrangthai();
            row[6] = list.get(i).getNgaygiaoban();

            tbqldat.addRow(row);
        }

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLenHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLenHoaDonActionPerformed
        // TODO add your handling code here:
        txtCmnd.setEnabled(true);
        lbtime.setText("Ngày lập hóa đơn:");
        txtIDdat.setEnabled(false);
        txtIDnguoiban.setEnabled(false);
        txtHoTen.setEnabled(true);
        txtNgaySinh.setEnabled(true);
        txtSDT.setEnabled(true);
        txtDiaChi.setEnabled(true);
        txtDienTich.setEnabled(false);
        txtViTri.setEnabled(false);
        txtGiaBan.setEnabled(true);
        cbTrangThai.setEnabled(true);

        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);

        btnTimKiem.setEnabled(false);
        btnLenHoaDon.setEnabled(true);
        btnLuu.setEnabled(true);
        btnKluu.setEnabled(true);
    }//GEN-LAST:event_btnLenHoaDonActionPerformed

    private void btnSuahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuahdActionPerformed
        // TODO add your handling code here:
        txtMaHD.setEnabled(true);
        txtIDdathd.setEnabled(true);
        txtIDnguoibanhd.setEnabled(true);
        txtIDnguoimuahd.setEnabled(true);
        txtTongtienhd.setEnabled(true);
        txtNgaybanhd.setEnabled(true);
        btnSuahd.setEnabled(true);
        btnXoahd.setEnabled(false);
        btnTimkiemhd.setEnabled(true);
        btnLuuhd.setEnabled(true);
        btnKluuhd.setEnabled(true);

    }//GEN-LAST:event_btnSuahdActionPerformed

    private void tbviewhoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbviewhoadonMouseClicked
        // TODO add your handling code here:
        int row = this.tbviewhoadon.getSelectedRow();
        String id_HD = (this.tbviewhoadon.getModel().getValueAt(row, 0).toString());
        Hoadon hd = new Hoadon();
        hd = hd.getTheoIDHD(Integer.parseInt(id_HD));
        if (hd != null) {
            txtMaHD.setText(String.valueOf(hd.getId_hoadon()));
            txtIDdathd.setText(String.valueOf(hd.getId_dat()));
            txtIDnguoibanhd.setText(String.valueOf(hd.getId_nguoiban()));
            txtIDnguoimuahd.setText(String.valueOf(hd.getId_nguoimua()));
            txtTongtienhd.setText(String.valueOf(hd.getTongtien()));
            txtNgaybanhd.setText(hd.getNgayban());
        }

    }//GEN-LAST:event_tbviewhoadonMouseClicked

    private void btnXoahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoahdActionPerformed
        // TODO add your handling code here:
        txtMaHD.setEnabled(true);
        txtIDdathd.setEnabled(true);
        txtIDnguoibanhd.setEnabled(true);
        txtIDnguoimuahd.setEnabled(true);
        txtTongtienhd.setEnabled(true);
        txtNgaybanhd.setEnabled(true);
        btnSuahd.setEnabled(false);
        btnXoahd.setEnabled(true);
        btnTimkiemhd.setEnabled(true);
        btnLuuhd.setEnabled(true);
        btnKluuhd.setEnabled(true);

    }//GEN-LAST:event_btnXoahdActionPerformed

    private void btnTimkiemhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemhdActionPerformed
        // TODO add your handling code here:
        cleartablehd();
        String timkiem = txttimkiemhd.getText();
        Hoadon hd = new Hoadon();
        List<Hoadon> list = hd.searchHD(timkiem);
        for (int i = 0; i < list.size(); i++) {
            String row[] = new String[6];
            row[0] = String.valueOf(list.get(i).getId_hoadon());
            row[1] = String.valueOf(list.get(i).getId_dat());
            row[2] = String.valueOf(list.get(i).getId_nguoiban());
            row[3] = String.valueOf(list.get(i).getId_nguoimua());
            row[4] = String.valueOf(list.get(i).getTongtien());
            row[5] = list.get(i).getNgayban();

            tbqlhd.addRow(row);

        }


    }//GEN-LAST:event_btnTimkiemhdActionPerformed

    private void btnLuuhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuhdActionPerformed
        // TODO add your handling code here:
        Hoadon hd = null;
//        sua hoa don
        if (btnSuahd.isEnabled()) {
            hd = new Hoadon();
            hd.setId_hoadon(Integer.parseInt(txtMaHD.getText()));
            hd.setId_dat(Integer.parseInt(txtIDdathd.getText()));
            hd.setId_nguoiban(Integer.parseInt(txtIDnguoibanhd.getText()));
            hd.setId_nguoimua(Integer.parseInt(txtIDnguoimuahd.getText()));
            hd.setTongtien(Integer.parseInt(txtTongtienhd.getText()));
            hd.setNgayban(txtNgaybanhd.getText());
            if (hd.edithd(hd)) {
                cleartablehd();
                showHD();
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thất bại");
            }
        }
//        xoa hoa don

        if (btnXoahd.isEnabled()) {
            hd = new Hoadon();
            if (hd.deleteHD(Integer.parseInt(txtMaHD.getText()))) {
                cleartablehd();
                showHD();
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, "Xóa thất bại");
            }

        }
    }//GEN-LAST:event_btnLuuhdActionPerformed

    private void btnKluuhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKluuhdActionPerformed
        // TODO add your handling code here:
        txtMaHD.setEnabled(false);
        txtIDdathd.setEnabled(false);
        txtIDnguoibanhd.setEnabled(false);
        txtIDnguoimuahd.setEnabled(false);
        txtTongtienhd.setEnabled(false);
        txtNgaybanhd.setEnabled(false);
        btnSuahd.setEnabled(true);
        btnXoahd.setEnabled(true);
        btnTimkiemhd.setEnabled(true);
        btnLuuhd.setEnabled(false);
        btnKluuhd.setEnabled(false);

    }//GEN-LAST:event_btnKluuhdActionPerformed

    private void tbviewthongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbviewthongkeMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbviewthongkeMouseClicked

    private void btnXemthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemthongkeActionPerformed
        // TODO add your handling code here:
        cleartablethongke();
        Hoadon hd = new Hoadon();
        int thang = Integer.parseInt(cbThang.getSelectedItem().toString());
        

        List<Hoadon> list = hd.Thongke(thang);
        for (int i = 0; i < list.size(); i++) {
            String row[] = new String[6];
            row[0] = String.valueOf(list.get(i).getId_hoadon());
            row[1] = String.valueOf(list.get(i).getId_dat());
            row[2] = String.valueOf(list.get(i).getId_nguoiban());
            row[3] = String.valueOf(list.get(i).getId_nguoimua());
            row[4] = String.valueOf(list.get(i).getTongtien());
            row[5] = list.get(i).getNgayban();

            tbqthongke.addRow(row);

        }
        int tong = hd.Tongtienthongke(thang);
        txttienthang.setText(String.valueOf(tong));
    }//GEN-LAST:event_btnXemthongkeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Dangnhap dn = new Dangnhap();
        dn.setLocationRelativeTo(null);
        this.dispose();
        dn.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btndoipassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoipassActionPerformed
        // TODO add your handling code here:
        cardLayout.show(CARD, "DOIPASS");
    }//GEN-LAST:event_btndoipassActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        cleartablekh();
        if (cbkhach.getSelectedItem().toString().equals("bán")) {

            shownguoiban();
            btnsuanm.setEnabled(false);
            btnsuanb.setEnabled(true);
        } else {
            shownguoimua();
            btnsuanb.setEnabled(false);
            btnsuanm.setEnabled(true);
        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void tbviewkhachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbviewkhachMouseClicked
        // TODO add your handling code here:
        Nguoiban nb = new Nguoiban();
        Nguoimua nm = new Nguoimua();
        int row = this.tbviewkhach.getSelectedRow();
        String idkhach = (this.tbviewkhach.getModel().getValueAt(row, 0).toString());
        int id = Integer.parseInt(idkhach);
        if (cbkhach.getSelectedItem().toString().equals("bán")) {
            nb = nb.gettheoidnguoiban(id);
            txtidkh.setText(String.valueOf(nb.getId_nguoiban()));
            txtcmndkh.setText(nb.getCmnd());
            txthotenkh.setText(nb.getHoten());
            txtngaysinhkh.setText(nb.getNgaysinh());
            txtsdtkh.setText(nb.getSodienthoai());
            txtdiachikh.setText(nb.getDiachi());

        } else if (cbkhach.getSelectedItem().toString().equals("mua")) {
            nm = nm.gettheoidnguoimua(id);
            txtidkh.setText(String.valueOf(nm.getId_nguoimua()));
            txtcmndkh.setText(nm.getCmnd());
            txthotenkh.setText(nm.getHoten());
            txtngaysinhkh.setText(nm.getNgaysinh());
            txtsdtkh.setText(nm.getSodienthoai());
            txtdiachikh.setText(nm.getDiachi());

        }

    }//GEN-LAST:event_tbviewkhachMouseClicked

    private void txtdiachikhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachikhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachikhActionPerformed

    private void btnsuanbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanbActionPerformed
        // TODO add your handling code here:
        txtidkh.setEnabled(true);
        txtcmndkh.setEnabled(true);
        txthotenkh.setEnabled(true);
        txtngaysinhkh.setEnabled(true);
        txtsdtkh.setEnabled(true);
        txtdiachikh.setEnabled(true);
        btnsuanm.setEnabled(false);
        btnsuanb.setEnabled(true);
        btnluukh.setEnabled(true);
        btnkluukh.setEnabled(true);
    }//GEN-LAST:event_btnsuanbActionPerformed

    private void btnsuanmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanmActionPerformed
        // TODO add your handling code here:
        txtidkh.setEnabled(true);
        txtcmndkh.setEnabled(true);
        txthotenkh.setEnabled(true);
        txtngaysinhkh.setEnabled(true);
        txtsdtkh.setEnabled(true);
        txtdiachikh.setEnabled(true);
        btnsuanm.setEnabled(true);
        btnsuanb.setEnabled(false);
        btnluukh.setEnabled(true);
        btnkluukh.setEnabled(true);
    }//GEN-LAST:event_btnsuanmActionPerformed

    private void btnluukhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluukhActionPerformed
        // TODO add your handling code here:
        if (btnsuanb.isEnabled()) {
            Nguoiban nb = new Nguoiban();
            nb.setId_nguoiban(Integer.parseInt(txtidkh.getText()));
            nb.setCmnd(txtcmndkh.getText());
            nb.setHoten(txthotenkh.getText());
            nb.setNgaysinh(txtngaysinhkh.getText());
            nb.setSodienthoai(txtsdtkh.getText());
            nb.setDiachi(txtdiachikh.getText());
            if (nb.suattnguoiban(nb)) {
                cleartablekh();
                shownguoiban();
                JOptionPane.showMessageDialog(rootPane, "cập nhật thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, "cập nhật thất bại");
            }

        }
        if (btnsuanm.isEnabled()) {
            Nguoimua nm = new Nguoimua();
            nm.setId_nguoimua(Integer.parseInt(txtidkh.getText()));
            nm.setCmnd(txtcmndkh.getText());
            nm.setHoten(txthotenkh.getText());
            nm.setNgaysinh(txtngaysinhkh.getText());
            nm.setSodienthoai(txtsdtkh.getText());
            nm.setDiachi(txtdiachikh.getText());
            if (nm.suattnguoimua(nm)) {
                cleartablekh();
                shownguoimua();
                JOptionPane.showMessageDialog(rootPane, "cập nhật thành công");

            } else {
                JOptionPane.showMessageDialog(rootPane, "cập nhật thất bại");
            }

        }
    }//GEN-LAST:event_btnluukhActionPerformed

    private void btnkluukhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkluukhActionPerformed
        // TODO add your handling code here:
        if (btnsuanb.isEnabled()) {
            txtidkh.setEnabled(false);
            txtcmndkh.setEnabled(false);
            txthotenkh.setEnabled(false);
            txtngaysinhkh.setEnabled(false);
            txtsdtkh.setEnabled(false);
            txtdiachikh.setEnabled(false);
            btnsuanm.setEnabled(false);
            btnsuanb.setEnabled(false);
            btnluukh.setEnabled(false);
            btnkluukh.setEnabled(false);
        }
        if (btnsuanm.isEnabled()) {
            txtidkh.setEnabled(false);
            txtcmndkh.setEnabled(false);
            txthotenkh.setEnabled(false);
            txtngaysinhkh.setEnabled(false);
            txtsdtkh.setEnabled(false);
            txtdiachikh.setEnabled(false);
            btnsuanm.setEnabled(false);
            btnsuanb.setEnabled(false);
            btnluukh.setEnabled(false);
            btnkluukh.setEnabled(false);
        }


    }//GEN-LAST:event_btnkluukhActionPerformed

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
            java.util.logging.Logger.getLogger(chucnang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chucnang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chucnang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chucnang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chucnang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CARD;
    private javax.swing.JPanel DOIPASS;
    private javax.swing.JPanel QLDAT;
    private javax.swing.JPanel QLHOADON;
    private javax.swing.JPanel THONGKE;
    private javax.swing.JPanel Viewhoadon;
    private javax.swing.JPanel Viewthongke;
    private javax.swing.JButton btnKluu;
    private javax.swing.JButton btnKluuhd;
    private javax.swing.JButton btnLenHoaDon;
    private javax.swing.JButton btnLmmoi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnLuuhd;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuahd;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimkiemhd;
    private javax.swing.JButton btnXemthongke;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoahd;
    private javax.swing.JButton btndoipass;
    private javax.swing.JButton btnkluukh;
    private javax.swing.JButton btnluukh;
    private javax.swing.JButton btnsuanb;
    private javax.swing.JButton btnsuanm;
    private javax.swing.JComboBox<String> cbThang;
    private javax.swing.JComboBox<String> cbTrangThai;
    private javax.swing.JComboBox<String> cbkhach;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbhienthi;
    private javax.swing.JLabel lbtime;
    private javax.swing.JTable tbView;
    private javax.swing.JTable tbviewhoadon;
    private javax.swing.JTable tbviewkhach;
    private javax.swing.JTable tbviewthongke;
    private javax.swing.JTextField txtCmnd;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienTich;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtIDdat;
    private javax.swing.JTextField txtIDdathd;
    private javax.swing.JTextField txtIDnguoiban;
    private javax.swing.JTextField txtIDnguoibanhd;
    private javax.swing.JTextField txtIDnguoimuahd;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNgaybanhd;
    private javax.swing.JTextField txtNgaygiaoban;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtTongtienhd;
    private javax.swing.JTextField txtViTri;
    private javax.swing.JTextField txtcmndkh;
    private javax.swing.JTextField txtdiachikh;
    private javax.swing.JTextField txthotenkh;
    private javax.swing.JTextField txtidkh;
    private javax.swing.JTextField txtngaysinhkh;
    private javax.swing.JTextField txtsdtkh;
    private javax.swing.JFormattedTextField txttienthang;
    private javax.swing.JTextField txttimkiemhd;
    private javax.swing.JPanel viewKH;
    private javax.swing.JPanel viewdat;
    // End of variables declaration//GEN-END:variables
}
