/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sflores.modelo;

import com.sflores.controlador.Arista;
import com.sflores.controlador.Aristas;
import com.sflores.controlador.Puntos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pc
 */
public class VentanaPuntos extends JFrame {
    private Puntos puntos = new Puntos();
    private Aristas aristas = new Aristas();
    
    private JButton bAñadeAristas = new JButton("Añade Aristas");
    private PanelPuntos panelPuntos = new PanelPuntos(puntos,aristas);
    
    private DialogAñadeAristas dialogoAñadeAristas = new DialogAñadeAristas(this);

    public VentanaPuntos() {
        super("Une Puntos");
        add(panelPuntos, BorderLayout.CENTER);
        JPanel pB = new JPanel(new FlowLayout());
        pB.add(bAñadeAristas);
        add(pB, BorderLayout.SOUTH);
        
        bAñadeAristas.addActionListener(new manejadorBotonAñade());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        
    }
    
    private class manejadorBotonAñade implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            int[] ptos = dialogoAñadeAristas.muestra();
            if(ptos != null) {
                for (int i = 0; i < ptos.length-1; i++) {
                    aristas.añade(new Arista(puntos.punto(ptos[i]), puntos.punto(ptos[i+1])));
                    
                    panelPuntos.repaint();
                }
            }
            
        }
        

     
    }
    
    
}
