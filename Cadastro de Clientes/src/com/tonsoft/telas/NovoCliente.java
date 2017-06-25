package com.tonsoft.telas;

import com.tonsoft.cliente.Cliente;
import com.tonsoft.principal.CadastroPrincipal;
import com.tonsoft.tablemodel.TableModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class NovoCliente extends JDialog {

    public static void main(String[] args) {
        NovoCliente dialog = new NovoCliente();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.pack();
    }

    public NovoCliente(Frame owner, boolean modal) {
        super(owner, modal);
        initComponents();
    }

    public NovoCliente() {
        initComponents();
    }

    private void btnCancelarActionPerformed(ActionEvent e) {
        dispose();
    }

    private void btnSalvarActionPerformed(ActionEvent e) {
        if ( txtNome.getText().equals(" ") || txtCelular.getText().equals("(  )       -    ") ||
                txtCpf.getText().equals("   .   .   -  ") ||
                txtRg.getText().equals("  .   .   - ") ||
                txtIdade.getText().equals("  /  /  ")||
                txtRua.getText().equals("") ||
                txtBairro.getText().equals("") ||
                txtCidade.getText().equals("") ||
                txtNumero.getText().equals("")||
                cbEstado.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null, "Campos obrigatórios não pode ser vazios!");

        } else {

            Cliente cliente = new Cliente(txtNome.getText(), txtCelular.getText()
                    , txtEmail.getText(), txtCidade.getText(), txtCpf.getText(),
                    txtRg.getText(), txtIdade.getText(), txtTelefone.getText(),
                    txtRua.getText(), txtBairro.getText(), txtComp.getText(), txtNumero.getText(),
                    cbEstado.getSelectedItem().toString());

            TableModel tableModel = CadastroPrincipal.getInstanceModel();
            tableModel.addCliente(cliente);
            dispose();
        }
    }

    private void initComponents() {
        panel1 = new JPanel();
        label1 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        txtNome = new JFormattedTextField();
        txtIdade = new JFormattedTextField();
        txtCpf = new JFormattedTextField();
        txtRg = new JFormattedTextField();
        rbM = new JRadioButton();
        rbF = new JRadioButton();
        panel2 = new JPanel();
        label2 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        txtTelefone = new JFormattedTextField();
        txtEmail = new JTextField();
        txtCelular = new JFormattedTextField();
        panel3 = new JPanel();
        label3 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        label15 = new JLabel();
        label16 = new JLabel();
        campoObg = new JLabel();
        txtRua = new JTextField();
        txtBairro = new JTextField();
        txtComp = new JTextField();
        txtNumero = new JFormattedTextField();
        txtCidade = new JTextField();
        cbEstado = new JComboBox();
        label17 = new JLabel();
        panel4 = new JPanel();
        btnSalvar = new JButton();
        btnCancelar = new JButton();

        //======== this ========
        setTitle("Novo Cliente");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Dados Pessoais"));
            panel1.setBackground(Color.white);

            panel1.setLayout(null);

            //---- label1 ----
            label1.setIcon(new ImageIcon(getClass().getResource("/com/tonsoft/drawable/dados_pessoais.jpg")));
            panel1.add(label1);
            label1.setBounds(10, 15, 120, 120);

            //---- label4 ----
            label4.setText("*  Nome:  ");
            label4.setForeground(Color.black);
            panel1.add(label4);
            label4.setBounds(new Rectangle(new Point(165, 20), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("*  Data nasc:  ");
            label5.setForeground(Color.black);
            panel1.add(label5);
            label5.setBounds(new Rectangle(new Point(165, 60), label5.getPreferredSize()));

            //---- label6 ----
            label6.setText("Sexo:  ");
            label6.setForeground(Color.black);
            panel1.add(label6);
            label6.setBounds(new Rectangle(new Point(165, 105), label6.getPreferredSize()));

            //---- label7 ----
            label7.setText("*  CPF:  ");
            label7.setForeground(Color.black);
            panel1.add(label7);
            label7.setBounds(new Rectangle(new Point(480, 35), label7.getPreferredSize()));

            //---- label8 ----
            label8.setText("*  RG:  ");
            label8.setForeground(Color.black);
            panel1.add(label8);
            label8.setBounds(new Rectangle(new Point(480, 75), label8.getPreferredSize()));

            //---- txtNome ----
            txtNome.setBackground(Color.white);
            try {
                MaskFormatter mascaraNome = new MaskFormatter("U******************************************");
                mascaraNome.setValidCharacters(" abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                mascaraNome.install(txtNome);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            panel1.add(txtNome);
            txtNome.setBounds(225, 16, 200, txtNome.getPreferredSize().height);

            //---- txtIdade ----
            txtIdade.setBackground(Color.white);
            try {
                MaskFormatter mascaraIdade = new MaskFormatter("##/##/####");
                mascaraIdade.setValidCharacters("0123456789");
                mascaraIdade.install(txtIdade);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            panel1.add(txtIdade);
            txtIdade.setBounds(250, 58, 100, txtIdade.getPreferredSize().height);

            //---- txtCpf ----
            txtCpf.setBackground(Color.white);
            try {
                MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
                mascaraCpf.setPlaceholderCharacter(' ');
                mascaraCpf.setValidCharacters("0123456789");
                mascaraCpf.install(txtCpf);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            panel1.add(txtCpf);
            txtCpf.setBounds(540, 30, 120, txtCpf.getPreferredSize().height);

            //---- txtRg ----
            txtRg.setBackground(Color.white);
            try {
                MaskFormatter mascaraRg = new MaskFormatter("##.###.###-#");
                mascaraRg.setPlaceholderCharacter(' ');
                mascaraRg.setValidCharacters("0123456789");
                mascaraRg.install(txtRg);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            panel1.add(txtRg);
            txtRg.setBounds(540, 70, 120, txtRg.getPreferredSize().height);

            //---- rbM ----
            rbM.setText("M");
            rbM.setBackground(Color.white);
            rbM.setForeground(Color.black);
            rbM.setSelected(true);
            panel1.add(rbM);
            rbM.setBounds(new Rectangle(new Point(210, 100), rbM.getPreferredSize()));

            //---- rbF ----
            rbF.setText("F");
            rbF.setBackground(Color.white);
            rbF.setForeground(Color.black);
            panel1.add(rbF);
            rbF.setBounds(new Rectangle(new Point(255, 100), rbF.getPreferredSize()));
        }

        contentPane.add(panel1);
        panel1.setBounds(0, 5, 700, 150);

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("Contato"));
            panel2.setBackground(Color.white);
            panel2.setLayout(null);

            //---- label2 ----
            label2.setIcon(new ImageIcon(getClass().getResource("/com/tonsoft/drawable/email.jpg")));
            panel2.add(label2);
            label2.setBounds(10, 20, 120, 120);

            //---- label9 ----
            label9.setText("*  Celular:  ");
            label9.setForeground(Color.black);
            panel2.add(label9);
            label9.setBounds(new Rectangle(new Point(165, 25), label9.getPreferredSize()));

            //---- label10 ----
            label10.setText("Telefone:  ");
            label10.setForeground(Color.black);
            panel2.add(label10);
            label10.setBounds(new Rectangle(new Point(165, 70), label10.getPreferredSize()));

            //---- label11 ----
            label11.setText("E-mail:  ");
            label11.setForeground(Color.black);
            panel2.add(label11);
            label11.setBounds(new Rectangle(new Point(165, 115), label11.getPreferredSize()));

            //---- Campos obrigatorios ----
            campoObg.setText("*  Campos obrigatórios.");
            campoObg.setForeground(Color.RED);
            panel2.add(campoObg);
            campoObg.setBounds(new Rectangle(new Point(475, 128), campoObg.getPreferredSize()));

            //---- txtTelefone ----
            txtTelefone.setBackground(Color.white);
            try {
                MaskFormatter mascaraTelefone = new MaskFormatter("(##) ####-####");
                mascaraTelefone.setPlaceholderCharacter(' ');
                mascaraTelefone.setValidCharacters("0123456789");
                mascaraTelefone.install(txtTelefone);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            panel2.add(txtTelefone);
            txtTelefone.setBounds(240, 68, 120, txtTelefone.getPreferredSize().height);

            //---- txtEmail ----
            txtEmail.setBackground(Color.white);
            panel2.add(txtEmail);
            txtEmail.setBounds(225, 112, 150, txtEmail.getPreferredSize().height);

            //---- txtCelular ----
            txtCelular.setBackground(Color.white);
            try {
                MaskFormatter mascaraCelular = new MaskFormatter("(##) # ####-####");
                mascaraCelular.setPlaceholderCharacter(' ');
                mascaraCelular.setValidCharacters("0123456789");
                mascaraCelular.install(txtCelular);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            panel2.add(txtCelular);
            txtCelular.setBounds(225, 23, 120, txtCelular.getPreferredSize().height);

        }
        contentPane.add(panel2);
        panel2.setBounds(0, 155, 700, 150);

        //======== panel3 ========
        {
            panel3.setBorder(new TitledBorder("Endere\u00e7o"));
            panel3.setBackground(Color.white);
            panel3.setLayout(null);

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/com/tonsoft/drawable/endereco.jpg")));
            panel3.add(label3);
            label3.setBounds(10, 20, 120, 120);

            //---- label12 ----
            label12.setText("*  Rua:  ");
            label12.setForeground(Color.black);
            panel3.add(label12);
            label12.setBounds(new Rectangle(new Point(165, 35), label12.getPreferredSize()));

            //---- label13 ----
            label13.setText("*  Bairro:  ");
            label13.setForeground(Color.black);
            panel3.add(label13);
            label13.setBounds(new Rectangle(new Point(165, 70), label13.getPreferredSize()));

            //---- label14 ----
            label14.setText("*  Numero:  ");
            label14.setForeground(Color.black);
            panel3.add(label14);
            label14.setBounds(new Rectangle(new Point(480, 35), label14.getPreferredSize()));

            //---- label15 ----
            label15.setText("*  Cidade:");
            label15.setForeground(Color.black);
            panel3.add(label15);
            label15.setBounds(425, 70, 55, label15.getPreferredSize().height);

            //---- label16 ----
            label16.setText("Complemento:  ");
            label16.setForeground(Color.black);
            panel3.add(label16);
            label16.setBounds(new Rectangle(new Point(165, 110), label16.getPreferredSize()));

            //---- txtRua ----
            txtRua.setBackground(Color.white);
            panel3.add(txtRua);
            txtRua.setBounds(210, 30, 180, txtRua.getPreferredSize().height);

            //---- txtBairro ----
            txtBairro.setBackground(Color.white);
            panel3.add(txtBairro);
            txtBairro.setBounds(230, 70, 150, txtBairro.getPreferredSize().height);

            //---- txtComp ----
            txtComp.setBackground(Color.white);
            panel3.add(txtComp);
            txtComp.setBounds(265, 107, 180, txtComp.getPreferredSize().height);

            //---- txtNumero ----
            txtNumero.setBackground(Color.white);
            try {
                MaskFormatter mascaraNumero = new MaskFormatter("#####");
                mascaraNumero.setPlaceholderCharacter(' ');
                mascaraNumero.install(txtNumero);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            panel3.add(txtNumero);
            txtNumero.setBounds(555, 30, 80, txtNumero.getPreferredSize().height);

            //---- txtCidade ----
            txtCidade.setBackground(Color.white);
            panel3.add(txtCidade);
            txtCidade.setBounds(505, 70, 150, txtCidade.getPreferredSize().height);

            //---- cbEstado ----
            cbEstado.setBackground(Color.white);
            cbEstado.setModel(new DefaultComboBoxModel(new String[] { "", "AC", "AL", "AM", "AP",
                    "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
                    "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"}));
            panel3.add(cbEstado);
            cbEstado.setBounds(575, 107, 80, cbEstado.getPreferredSize().height);

            //---- label17 ----
            label17.setText("UF:  ");
            label17.setForeground(Color.black);
            panel3.add(label17);
            label17.setBounds(new Rectangle(new Point(542, 110), label17.getPreferredSize()));
        }
        contentPane.add(panel3);
        panel3.setBounds(0, 305, 700, 150);

        //======== panel4 ========
        {
            panel4.setBorder(new TitledBorder(""));
            panel4.setBackground(Color.white);
            panel4.setLayout(null);

            //---- btnSalvar ----
            btnSalvar.setText("Salvar");
            btnSalvar.addActionListener(e -> btnSalvarActionPerformed(e));
            panel4.add(btnSalvar);
            btnSalvar.setBounds(215, 5, 90, btnSalvar.getPreferredSize().height);

            //---- btnCancelar ----
            btnCancelar.setText("Cancelar");
            btnCancelar.addActionListener(e -> {
                btnCancelarActionPerformed(e);
                btnCancelarActionPerformed(e);
            });
            panel4.add(btnCancelar);
            btnCancelar.setBounds(415, 5, 90, btnCancelar.getPreferredSize().height);
        }
        contentPane.add(panel4);
        panel4.setBounds(0, 455, 700, 45);

        { // compute preferred size
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
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rbM);
        buttonGroup1.add(rbF);
    }

    private JPanel panel1;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JFormattedTextField txtNome;
    private JFormattedTextField txtIdade;
    private JFormattedTextField txtCpf;
    private JFormattedTextField txtRg;
    private JRadioButton rbM;
    private JRadioButton rbF;
    private JPanel panel2;
    private JLabel label2;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JFormattedTextField txtTelefone;
    private JTextField txtEmail;
    private JFormattedTextField txtCelular;
    private JPanel panel3;
    private JLabel label3;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JLabel label15;
    private JLabel label16;
    private JLabel campoObg;
    private JTextField txtRua;
    private JTextField txtBairro;
    private JTextField txtComp;
    private JFormattedTextField txtNumero;
    private JTextField txtCidade;
    private JComboBox cbEstado;
    private JLabel label17;
    private JPanel panel4;
    private JButton btnSalvar;
    private JButton btnCancelar;
}
