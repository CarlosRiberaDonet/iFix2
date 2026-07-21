/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacion;

import cliente.Cliente;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author sovi8
 */
public class ReparacionTableMouseListener extends MouseAdapter{
    
    Frame parent;
    private JTable reparacionesTable;
    private List<Reparacion> reparacionesList;
    
    public ReparacionTableMouseListener(Frame parent, JTable reparacionesTable, Cliente cliente, List<Reparacion> reparacionesList) {
        this.parent = parent;
        this.reparacionesTable = reparacionesTable;
        this.reparacionesList = reparacionesList;
    }
    
     public void setReparacionesList(List<Reparacion> reparacionesList) {
        this.reparacionesList = reparacionesList;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int filaVista = reparacionesTable.rowAtPoint(e.getPoint());
            if (filaVista != -1) {
                int filaModelo = reparacionesTable.convertRowIndexToModel(filaVista);
                Reparacion reparacionSelect = reparacionesList.get(filaModelo);
                Cliente cliente = reparacionSelect.getDispositivo().getCliente();
                DetalleReparacionDialog dialog = new DetalleReparacionDialog(parent, true, cliente, reparacionSelect);
                dialog.setSize(830, 650);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        }
    }
}
