/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import DAO.DaoAsientos;
import DAO.DaoBoletos;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import modelo.Asiento;
import modelo.Boleto;
import modelo.Funcion;
import ventanas.VentanaPrincipal;

/**
 *
 * @author josep
 */
public class ControlAsientos implements ActionListener {
    
    VentanaPrincipal menu = new VentanaPrincipal();
    Funcion funcion = new Funcion();
    DaoAsientos daoAsientos = new DaoAsientos();
    DaoBoletos daoBoletos = new DaoBoletos();
    
    private int filasB = 5;
    private int columnasB = 2;
    private int filasA = 2;
    private int columnasA = 5;
    private int largoBoton = 70;
    private int anchoBoton = 70;
    private int ejeX = 50;
    private int ejeY = 20;
    
    private ArrayList<Asiento> lugarAsientos = new ArrayList<Asiento>(); // Lista para almacernar lo asientos que fueron seleccionados
    private ArrayList<Boleto> Boletos = new ArrayList<Boleto>(); // Lista para almacenar los ID's de los boletos creados
    
    private JToggleButton[][] botonesB1 = new JToggleButton[filasB][columnasB];
    private JToggleButton[][] botonesB2 = new JToggleButton[filasB][columnasB];
    private JToggleButton[][] botonesA = new JToggleButton[filasA][columnasA];
    private JToggleButton[][] botonesC = new JToggleButton[filasA][columnasA];
    
    private JLabel[][] btnB1 = new JLabel[filasB][columnasB];
    private JLabel[][] btnB2 = new JLabel[filasB][columnasB];
    private JLabel[][] btnA = new JLabel[filasA][columnasA];
    private JLabel[][] btnC = new JLabel[filasA][columnasA];

    public ControlAsientos(VentanaPrincipal menu, Funcion funcion) {
        this.menu = menu;
        
        // Asignarle a la funcion los datos de su sala;
        this.funcion = daoAsientos.traerDatosAsientos(funcion);
 
        this.menu.getSala().setBotonesB1(asientosZonaB1());
       this.menu.getSala().setBotonesB2(asientosZonaB2());
        this.menu.getSala().setBotonesA(asientosZonaA());
        this.menu.getSala().setBotonesC(asientosZonaC());
        this.menu.getSala().setBtnB1( btnB1 );
        
        this.menu.getSala().getBtnAceptar().addActionListener(this);
        

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Modificar los asientos cuando aceptemos todas las sillas seleccionadas
        if (this.menu.getSala().getBtnAceptar() == e.getSource() ) {
            
            for( int i = 0; i < filasB; i++ ) {
                for( int k = 0; k < columnasB; k++) {
                     if(botonesB1[i][k].isSelected()) {
                                    funcion.getZonaB()[i][k].setDisponible(0);
                                    lugarAsientos.add(funcion.getZonaB()[i][k]); //Añadir los Asientos seleccionados al arreglo para poder crear los boletos
                                } 
                     if(botonesB2[i][k].isSelected()) {
                                funcion.getZonaB2()[i][k].setDisponible(0);
                                lugarAsientos.add(funcion.getZonaB2()[i][k]); //Añadir los Asientos seleccionados al arreglo para poder crear los boletos
                            } 
                } 
                
            }
            for( int i = 0; i < filasA; i++ ) {
                for( int k = 0; k < columnasA; k++) {
                     if(botonesA[i][k].isSelected()) {
                                   funcion.getZonaA()[i][k].setDisponible(0);
                                   lugarAsientos.add(funcion.getZonaA()[i][k]); //Añadir losAsientos seleccionados al arreglo para poder crear los boletos
                            } 
                     if(botonesC[i][k].isSelected()) {
                            funcion.getZonaC()[i][k].setDisponible(0);
                            lugarAsientos.add(funcion.getZonaC()[i][k]);  //Añadir los Asientos seleccionados al arreglo para poder crear los boletos
                        }   
            }
  
        }          
            
            //Crear los boletos
            for(int i = 0; i < lugarAsientos.size(); i++) {
            Boleto boleto = new Boleto();
            boleto.setLugar(lugarAsientos.get(i));
            boleto.setFuncion(funcion);
            boleto.setPrecioBoleto(lugarAsientos.get(i).getPrecioAsiento());
            boleto.setFechaFuncion(funcion.getFechaDePresentacion());
            boleto.setHoraFuncion(funcion.getHora());
            
//            daoBoletos.agregarBoleto(boleto); // Agregar el boleto en la lista para almacenar los boletos creados y proceder al pago
            Boletos.add(boleto); //Insertar el boleto en la base de datos
        }
            menu.getPanelPago().setSize(1460, 720);
            menu.getPanelPago().setLocation(0, 0);
      
            menu.getPanelContenido().removeAll();
            menu.getPanelContenido().add(menu.getPanelPago(), BorderLayout.CENTER);
            menu.getPanelContenido().revalidate();
            menu.getPanelContenido().repaint();
            
            ControlPago controlPago = new ControlPago(menu, Boletos, funcion);
        }

    }
    
    
    
    
    
    
    
    
    // Crear los botones
    public JToggleButton[][] asientosZonaB1( ) { 
            
            botonesB1 = new JToggleButton[filasB][columnasB];
            
            int contador = 1;
            
            for( int i = 0;  i < filasB; i++) {
                
                for(int k = 0; k < columnasB; k++ ) {
                    
                    botonesB1[i][k] = new JToggleButton();
                    botonesB1[i][k].setBounds(ejeX, ejeY, largoBoton, anchoBoton);
                    
                    //Codigo para crear los LABEL (NOMBRES DE LOS ASIENTOS A UN LADO)
                    btnB1[i][k] = new JLabel();
                    btnB1[i][k] .setBounds(ejeX - 7, ejeY, largoBoton-35, anchoBoton-35);
                    btnB1[i][k] .setText("B"+ contador);
                    this.menu.getSala().getPanelSala().add(btnB1[i][k]);
                    //AQUI TERMINA EL CODIGO DE LOS LABEL'S
                    
                    AccionBotones accion = new AccionBotones();
                    
                    botonesB1[i][k].addActionListener(accion);
                    
                    if( funcion.getZonaB()[i][k].isDisponible() == 1) {
                        botonesB1[i][k].setIcon(imagenSillaDisponible());
                    } else {
                        botonesB1[i][k].setIcon(imagenSillaOcupada());
                    }
                    
                    botonesB1[i][k].setBorderPainted(false);
                    botonesB1[i][k].setContentAreaFilled(false);
                    
                   this.menu.getSala().getPanelSala().add(botonesB1[i][k]);

                   contador++;
                    ejeX += 130;  
                }
                
                ejeX = 50;
                ejeY += 100;
                
            }
            return botonesB1;
        }
    
    public JToggleButton[][] asientosZonaB2( ) { 
             ejeX = 1050;
             ejeY = 20;
            botonesB2 = new JToggleButton[filasB][columnasB];
            
             int contador = 11;
            
            for( int i = 0;  i < filasB; i++) {
                
                for(int k = 0; k < columnasB; k++ ) {
                    
                    botonesB2[i][k] = new JToggleButton();
                    botonesB2[i][k].setBounds(ejeX, ejeY, largoBoton, anchoBoton);
                    
                    //Codigo para crear los LABEL (NOMBRES DE LOS ASIENTOS A UN LADO)
                    btnB2[i][k] = new JLabel();
                    btnB2[i][k] .setBounds(ejeX - 7, ejeY, largoBoton-35, anchoBoton-35);
                    btnB2[i][k] .setText("B"+ contador);
                    this.menu.getSala().getPanelSala().add(btnB2[i][k]);
                    //AQUI TERMINA EL CODIGO DE LOS LABEL'S
                    
                   AccionBotones accion = new AccionBotones();
                    
                    botonesB2[i][k].addActionListener(accion);
                    
                    if( funcion.getZonaB2()[i][k].isDisponible() == 1) {
                        botonesB2[i][k].setIcon(imagenSillaDisponible());
                    } else {
                        botonesB2[i][k].setIcon(imagenSillaOcupada());
                    }
                    botonesB2[i][k].setBorderPainted(false);
                    botonesB2[i][k].setContentAreaFilled(false);
                    
                    this.menu.getSala().getPanelSala().add(botonesB2[i][k]);

                    contador++;
                    ejeX += 130;  
                }
                
                ejeX = 1050;
                ejeY += 100;
                
            }
            return botonesB2;
        }
    
    public JToggleButton[][] asientosZonaA( ) { 
        
             ejeX = 350;
             ejeY = 20;
            botonesA = new JToggleButton[filasA][columnasA];
            int contador = 1;
            
            
            
            for( int i = 0;  i < filasA; i++) {
                
                for(int k = 0; k < columnasA; k++ ) {
                    
                    //Crear botones con sus dimensiones y el lugar espacial en el JFrame
                    botonesA[i][k] = new JToggleButton();
                    botonesA[i][k].setBounds(ejeX, ejeY, largoBoton, anchoBoton);
                    
                    //Codigo para crear los LABEL (NOMBRES DE LOS ASIENTOS A UN LADO)
                    btnA[i][k] = new JLabel();
                    btnA[i][k] .setBounds(ejeX - 7, ejeY, largoBoton-35, anchoBoton-35);
                    btnA[i][k] .setText("A"+ contador);
                    this.menu.getSala().getPanelSala().add(btnA[i][k]);
                    //AQUI TERMINA EL CODIGO DE LOS LABEL'S
                    
                    //Crear un listener para los botones
                    AccionBotones accion = new AccionBotones();
                    botonesA[i][k].addActionListener(accion);
                    //Dar le diseño de imagen a los botones
                    
                    if ( funcion.getZonaA()[i][k].isDisponible() == 1) {
                        botonesA[i][k].setIcon(imagenSillaDisponible());
                    } else {
                        botonesA[i][k].setIcon(imagenSillaOcupada());
                    }
                    
                    botonesA[i][k].setBorderPainted(false);
                    botonesA[i][k].setContentAreaFilled(false);
                    
                   this.menu.getSala().getPanelSala().add(botonesA[i][k]);

                    contador++;
                   ejeX += 130;  
                }
                
                
                ejeX = 350;
                ejeY += 70;
                
            }
            return botonesA;
        }
    
    public JToggleButton[][] asientosZonaC( ) { 
             ejeX = 350;
             ejeY = 230;
            botonesC = new JToggleButton[filasA][columnasA];
            int contador = 1;
            
            for( int i = 0;  i < filasA; i++) {
                
                for(int k = 0; k < columnasA; k++ ) {
                    
                    botonesC[i][k] = new JToggleButton();
                    botonesC[i][k].setBounds(ejeX, ejeY, largoBoton, anchoBoton);
                    
                    //Codigo para crear los LABEL (NOMBRES DE LOS ASIENTOS A UN LADO)
                    btnC[i][k] = new JLabel();
                    btnC[i][k] .setBounds(ejeX - 7, ejeY, largoBoton-35, anchoBoton-35);
                    btnC[i][k] .setText("C"+ contador);
                    this.menu.getSala().getPanelSala().add(btnC[i][k]);
                    //AQUI TERMINA EL CODIGO DE LOS LABEL'S
                    
                    AccionBotones accion = new AccionBotones();
                    
                    botonesC[i][k].addActionListener(accion);
                    
                    if( funcion.getZonaC()[i][k].isDisponible() == 1) {
                        botonesC[i][k].setIcon(imagenSillaDisponible());
                    } else {
                        botonesC[i][k].setIcon(imagenSillaOcupada());
                    }
                    
                    botonesC[i][k].setBorderPainted(false);
                    botonesC[i][k].setContentAreaFilled(false);
                    
                    this.menu.getSala().getPanelSala().add(botonesC[i][k]);

                    contador++;
                    ejeX += 130;  
                }
                
                ejeX = 350;
                ejeY += 70;
                
            }
            return botonesC;
        }
    
    // Imagenes de las sillas
    
    public Icon imagenSillaDisponible( ) {
            ImageIcon sillaDisponible;
            sillaDisponible = new ImageIcon(getClass().getResource("/imagenes/asientoDisponible.png"));
            Icon sillaIcono = new ImageIcon(sillaDisponible.getImage().getScaledInstance(
                    70, 70, Image.SCALE_SMOOTH));
            return sillaIcono;
        }
    
    public Icon imagenSillaSeleccionada( ) {
            ImageIcon sillaSeleccion;
            sillaSeleccion = new ImageIcon(getClass().getResource("/imagenes/asientoSeleccionado.png"));
            Icon sillaIcono = new ImageIcon(sillaSeleccion.getImage().getScaledInstance(
                    70, 70, Image.SCALE_SMOOTH));
            return sillaIcono;
        }
    
//    public Icon imagenSillaDeshabilitada( ) {
//            ImageIcon sillaSeleccion;
//            sillaSeleccion = new ImageIcon(getClass().getResource("/imagenes/sillaDeshabilitado.png"));
//            Icon sillaIcono = new ImageIcon(sillaSeleccion.getImage().getScaledInstance(
//                    70, 70, Image.SCALE_SMOOTH));
//            return sillaIcono;
//        }
    
    public Icon imagenSillaOcupada( ) {
            ImageIcon sillaSeleccion;
            sillaSeleccion = new ImageIcon(getClass().getResource("/imagenes/asientoOcupado.png"));
            Icon sillaIcono = new ImageIcon(sillaSeleccion.getImage().getScaledInstance(
                    70, 70, Image.SCALE_SMOOTH));
            return sillaIcono;
        } 
    
    
    // Crear una clase interna para el accionar de los botones
    public class AccionBotones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                for( int i = 0; i < filasB; i++ ) {
                for( int k = 0; k < columnasB; k++) {
                 
                    if ( e.getSource().equals(botonesB1[i][k])) {
                        if( funcion.getZonaB()[i][k].isDisponible() == 1) {
                                if(botonesB1[i][k].isSelected()) {
                                    
                                    botonesB1[i][k].setIcon(imagenSillaSeleccionada());
                                } else {
                                    if( funcion.getZonaB()[i][k].isDisponible() == 1) {
                                        botonesB1[i][k].setIcon(imagenSillaDisponible());

                                    } else {
                                        botonesB1[i][k].setIcon(imagenSillaOcupada());
                                }
                            }
                        } else {
                            botonesB1[i][k].enable(false);
                        }
                        
                    }    
                    if ( e.getSource().equals(botonesB2[i][k])) {
                        
                        if( funcion.getZonaB2()[i][k].isDisponible() == 1) {
                            if(botonesB2[i][k].isSelected()) {

                                botonesB2[i][k].setIcon(imagenSillaSeleccionada());
                            } else {
                                if( funcion.getZonaB2()[i][k].isDisponible() == 1) {
                                    botonesB2[i][k].setIcon(imagenSillaDisponible());

                                } else {
                                    botonesB2[i][k].setIcon(imagenSillaOcupada());
                                }
                            }
                        } else {
                            botonesB2[i][k].enable(false);
                        }
                    } 
                } 
                
            }
            
            for( int i = 0; i < filasA; i++ ) {
                for( int k = 0; k < columnasA; k++) {
                 
                    if ( e.getSource().equals(botonesA[i][k])) {
                        
                        if( funcion.getZonaA()[i][k].isDisponible() == 1) {
                        
                            if(botonesA[i][k].isSelected()) {

                                botonesA[i][k].setIcon(imagenSillaSeleccionada());
                            } else {
                                if( funcion.getZonaA()[i][k].isDisponible() == 1) {
                                    botonesA[i][k].setIcon(imagenSillaDisponible());

                                } else {
                                    botonesA[i][k].setIcon(imagenSillaOcupada());
                                }
                            }
                        } else {
                            botonesA[i][k].enable(false);
                        }
                    }    
                    
                    if ( e.getSource().equals(botonesC[i][k])) {
                        
                        if( funcion.getZonaC()[i][k].isDisponible() == 1) {
                                
                        if(botonesC[i][k].isSelected()) {

                            botonesC[i][k].setIcon(imagenSillaSeleccionada()); 
                        } else {
                            if( funcion.getZonaC()[i][k].isDisponible() == 1) {
                                botonesC[i][k].setIcon(imagenSillaDisponible());

                            } else {
                                botonesC[i][k].setIcon(imagenSillaOcupada());
                            }
                        }
                        } else {
                            botonesC[i][k].enable(false);
                            
                        }
                    
                    
                } 
                
            }
  
        }
                
        }
    
         
}
}
