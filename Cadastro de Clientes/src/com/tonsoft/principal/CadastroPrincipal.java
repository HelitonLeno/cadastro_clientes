package com.tonsoft.principal;

import java.awt.event.*;

import com.tonsoft.cliente.Cliente;
import com.tonsoft.tablemodel.TableModel;
import com.tonsoft.telas.AlterarCliente;
import com.tonsoft.telas.NovoCliente;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CadastroPrincipal extends JFrame {
    private static TableModel model;
    private static CadastroPrincipal instancia;
    private static int selectedRow = 0;

    public static void main(String[] args) {
        CadastroPrincipal frameMain = new CadastroPrincipal();
        frameMain.setVisible(true);
        frameMain.pack();
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public CadastroPrincipal() {
        initComponents();
    }

    //---- JDialog novo Cliente ----
    private void btnNovoActionPerformed(ActionEvent e) {
        NovoCliente dialog = new NovoCliente(this, true);
        dialog.setVisible(true);
    }

    //---- Ação mostar Cliente clicar duas vezes na tabela ----
    private void table1MouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){
            setSelectedRow(table1.getSelectedRow());
            AlterarCliente alterarActivity = new AlterarCliente(this, true);
            alterarActivity.setVisible(true);
        }
    }

    private void btnExcluirActionPerformed(ActionEvent e) {
        try {
            model.removeCliente(table1.getSelectedRow());
        }catch (ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(this, "Nenhum contato selecionado!!!!");
        }
    }

    private void btnPesquisarActionPerformed(ActionEvent e) {
        TableRowSorter<TableModel> tm = new TableRowSorter<TableModel>(model);
        table1.setRowSorter(tm);
        tm.setRowFilter(RowFilter.regexFilter(txtPesquisar.getText()));
    }

    private void initComponents() {
        panel1 = new JPanel();
        btnPesquisar = new JButton();
        txtPesquisar = new JTextField();
        btnNovo = new JButton();
        btnExcluir = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        model = new TableModel();
        table1 = new JTable(model);
        hSpacer1 = new JPanel(null);

        //======== this ========
        setTitle("Cadastro de Clientes");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Menu"));
            panel1.setLayout(null);

            //---- btnPesquisar ----
            btnPesquisar.setText("Pesquisar");
            btnPesquisar.addActionListener(e -> {
                btnPesquisarActionPerformed(e);
            });
            panel1.add(btnPesquisar);
            btnPesquisar.setBounds(265, 20, 100, 30);
            
            panel1.add(txtPesquisar);
            txtPesquisar.setBounds(10, 20, 250, 30);

            //---- btnNovo ----
            btnNovo.setText("Novo");
            btnNovo.addActionListener(e -> btnNovoActionPerformed(e));
            panel1.add(btnNovo);
            btnNovo.setBounds(465, 20, 100, 30);

            //---- btnExcluir ----
            btnExcluir.setText("Excluir");
            btnExcluir.addActionListener(e -> btnExcluirActionPerformed(e));
            panel1.add(btnExcluir);
            btnExcluir.setBounds(665, 20, 100, 30);
        }
        contentPane.add(panel1);
        panel1.setBounds(10, 5, 835, 70);

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("Contatos"));
            panel2.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                table1.getColumnModel().getColumn(0).setPreferredWidth(50);
                table1.getColumnModel().getColumn(1).setPreferredWidth(150);
                table1.getColumnModel().getColumn(2).setPreferredWidth(150);
                table1.getColumnModel().getColumn(3).setPreferredWidth(120);
                table1.getColumnModel().getColumn(4).setPreferredWidth(120);
                table1.getColumnModel().getColumn(5).setPreferredWidth(100);
                table1.getColumnModel().getColumn(6).setPreferredWidth(150);
                table1.getColumnModel().getColumn(7).setPreferredWidth(150);
                table1.getColumnModel().getColumn(8).setPreferredWidth(50);
                table1.getColumnModel().getColumn(9).setPreferredWidth(130);
                table1.getColumnModel().getColumn(10).setPreferredWidth(130);
                table1.getColumnModel().getColumn(11).setPreferredWidth(130);
                table1.getColumnModel().getColumn(12).setPreferredWidth(130);
                table1.getColumnModel().getColumn(13).setPreferredWidth(130);
                table1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        table1MouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(table1);
            }
            panel2.add(scrollPane1, BorderLayout.CENTER);
        }
        
        contentPane.add(panel2);
        panel2.setBounds(10, 80, 835, 395);
        contentPane.add(hSpacer1);
        hSpacer1.setBounds(845, 250, 12, hSpacer1.getPreferredSize().height);

        {
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(null);
    }

    public static CadastroPrincipal getInstance(){
        if (instancia==null){
            instancia = new CadastroPrincipal();
        }
        return instancia;
    }

    public static int getSelectedRow() {
        return CadastroPrincipal.selectedRow;
    }

    public static void setSelectedRow(int selectedRow) {
        CadastroPrincipal.selectedRow = selectedRow;
    }

    public static TableModel getInstanceModel(){
        return CadastroPrincipal.model;
    }

    private JPanel panel1;
    private JButton btnPesquisar;
    private JTextField txtPesquisar;
    private JButton btnNovo;
    private JButton btnExcluir;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel hSpacer1;
}