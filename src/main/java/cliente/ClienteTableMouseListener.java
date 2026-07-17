/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import reparacion.Reparacion;
import reparacion.ReparacionController;
import reparacion.ReparacionesClienteFrame;

/**
 *
 * @author sovi8
 */
public class ClienteTableMouseListener extends MouseAdapter{
    private List<Cliente> clientesList;
    private JTable clienteTable;

    public ClienteTableMouseListener(JTable clienteTable, List<Cliente> clientesList) {
        this.clientesList = clientesList;
        this.clienteTable = clienteTable;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && clienteTable.getSelectedRow() != -1) {
            int fila = clienteTable.getSelectedRow();
            if (fila >= 0 && fila < clientesList.size()) {
                Cliente clienteSeleccionado = clientesList.get(fila);
                List<Reparacion> reparacionesList = ReparacionController.findReparacionesByIdCliente(clienteSeleccionado.getId());
                ReparacionesClienteFrame frame = new ReparacionesClienteFrame(clienteSeleccionado, reparacionesList);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        }
    }
}
