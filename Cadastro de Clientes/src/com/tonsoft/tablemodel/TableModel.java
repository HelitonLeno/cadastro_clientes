package com.tonsoft.tablemodel;

import com.tonsoft.cliente.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModel extends AbstractTableModel{

    private ArrayList<Cliente> clientes;
    private String[] colunas = new String[]{"ID","NOME", "CELULAR", "CPF", "RG", "DATA NASC", "E-MAIL", "TELEFONE",
    		"UF", "CIDADE", "BAIRRO", "RUA", "NUMERO", "COMPLEMENTO"};

    public TableModel(){
        this.clientes = new ArrayList<>();
    }

    public void addCliente(Cliente c){
        c.setId(getRowCount());
        this.clientes.add(c);
        fireTableDataChanged();
    }

    public void removeCliente(int rowIndex){
        this.clientes.remove(rowIndex);
        atualizarId();
        fireTableDataChanged();
    }

    public  void atualizarId(){
        for (Cliente c : clientes){
            c.setId(clientes.indexOf(c));
        }
    }

    public Cliente getCliente(int rowIndex){
        return this.clientes.get(rowIndex);
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    @Override
    public int getRowCount() {
        return this.clientes.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.clientes.get(rowIndex).getId();
            case 1:
                return this.clientes.get(rowIndex).getNome();
            case 2:
                return this.clientes.get(rowIndex).getCelular();
            case 3:
                return this.clientes.get(rowIndex).getCpf();
            case 4:
            	return this.clientes.get(rowIndex).getRg();
            case 5:
                return this.clientes.get(rowIndex).getDataNasc();
            case 6:
                return this.clientes.get(rowIndex).getEmail();
            case 7:
                return this.clientes.get(rowIndex).getTelefone();
            case 8:
                return this.clientes.get(rowIndex).getUf();
            case 9:
                return this.clientes.get(rowIndex).getCidade();
            case 10:
                return this.clientes.get(rowIndex).getBairro();
            case 11:
                return this.clientes.get(rowIndex).getRua();
            case 12:
                return this.clientes.get(rowIndex).getNumero();
            case 13:
                return this.clientes.get(rowIndex).getComp();
            default:
                return this.clientes.get(rowIndex);
        }
    }

    public void setValueAt(Cliente cliente, int rowIndex, int columnIndex) {
        for (columnIndex=0; columnIndex < getColumnCount(); columnIndex++){
            this.clientes.set(rowIndex, cliente);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
}