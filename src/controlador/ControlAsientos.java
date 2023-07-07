
package controlador;

import daos.DaoAsientos;
import daos.DaoBoletos;
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
import vista.VentanaPrincipal;

/**
 *
 * @author Monica Garcilazo
 */
public class ControlAsientos implements ActionListener {
    
    VentanaPrincipal menu = new VentanaPrincipal();
    
    Funcion funcion = new Funcion();
    
    DaoAsientos daoAsientos = new DaoAsientos();
    
    DaoBoletos daoBoletos = new DaoBoletos();
    
    private final int FILAS_B = 5;
    
    private final int COLUMNAS_B = 2;
    
    private final int FILAS_A = 2;
    
    private final int COLUMNAS_A = 5;
    
    private int largoBoton = 70;
    
    private int anchoBoton = 70;
    
    private int ejeX= 50;
    
    private int ejeY = 20;
    
    private final ArrayList<Asiento> lugarAsientos = new ArrayList<Asiento>(); 
    
    private final ArrayList<Boleto> Boletos = new ArrayList<Boleto>(); 
    
    private JToggleButton[][] botonesB1 = new JToggleButton[FILAS_B][COLUMNAS_B];
    
    private JToggleButton[][] botonesB2 = new JToggleButton[FILAS_B][COLUMNAS_B];
    
    private JToggleButton[][] botonesA = new JToggleButton[FILAS_A][COLUMNAS_A];
    
    private JToggleButton[][] botonesC = new JToggleButton[FILAS_A][COLUMNAS_A];
    
    private JLabel[][] btnB1 = new JLabel[FILAS_B][COLUMNAS_B];
    
    private JLabel[][] btnB2 = new JLabel[FILAS_B][COLUMNAS_B];
    
    private JLabel[][] btnA = new JLabel[FILAS_A][COLUMNAS_A];
    
    private JLabel[][] btnC = new JLabel[FILAS_A][COLUMNAS_A];

    /**
     * Constructor de la clase
     * @param menu Ventana Principal
     * @param funcion Funcion con la que se trabaj
     */
    public ControlAsientos(VentanaPrincipal menu, Funcion funcion) {
        this.menu = menu;

        // Asignarle a la funcion los datos de su sala;
        this.funcion = daoAsientos.traerDatosAsientos(funcion);

        this.menu.getSala().setBotonesB1(creacionAsientosZonaB1());
        this.menu.getSala().setBotonesB2(creacionAsientosZonaB2());
        this.menu.getSala().setBotonesA(creacionAsientosZonaA());
        this.menu.getSala().setBotonesC(creacionAsientosZonaC());
        this.menu.getSala().setBtnB1(btnB1);

        this.menu.getSala().getBtnAceptar().addActionListener(this);

    }
    
    /**
     * Realiza las acciones programadas segun el evento, 
     * Modifica los asientos cuando se acepten las sillas selecionadas
     **/
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.menu.getSala().getBtnAceptar() == e.getSource() ) {
            actualizarAsientosSeleccionados();
            crearBoletos();

            menu.getPanelPago().setSize(1460, 720);
            menu.getPanelPago().setLocation(0, 0);
      
            menu.getPanelContenido().removeAll();
            menu.getPanelContenido().add(menu.getPanelPago(), BorderLayout.CENTER);
            menu.getPanelContenido().revalidate();
            menu.getPanelContenido().repaint();
            
            ControlPago controlPago = new ControlPago(menu, Boletos, funcion);
        }

    }
    /**
     * Metodo que actualiza los asientos que fueron seleecionados
     **/
    public void actualizarAsientosSeleccionados(){
        
                    for( int i = 0; i < FILAS_B; i++ ) {
                for( int k = 0; k < COLUMNAS_B; k++) {
                     if(botonesB1[i][k].isSelected()) {
                                    funcion.getZonaB()[i][k].setDisponible(0);
                                    lugarAsientos.add(funcion.getZonaB()[i][k]); 
                                } 
                     if(botonesB2[i][k].isSelected()) {
                                funcion.getZonaB2()[i][k].setDisponible(0);
                                lugarAsientos.add(funcion.getZonaB2()[i][k]); 
                            } 
                } 
                
            }
            for( int i = 0; i < FILAS_A; i++ ) {
                for( int k = 0; k < COLUMNAS_A; k++) {
                     if(botonesA[i][k].isSelected()) {
                                   funcion.getZonaA()[i][k].setDisponible(0);
                                   lugarAsientos.add(funcion.getZonaA()[i][k]); 
                            } 
                     if(botonesC[i][k].isSelected()) {
                            funcion.getZonaC()[i][k].setDisponible(0);
                            lugarAsientos.add(funcion.getZonaC()[i][k]); 
                        }   
            }
  
        }    
    }
    
    /**
     * Metodo que crea los boletos dependiendo de los asientos que fueron seleccionados
     * Se almacena en la base de datos
     **/
    public void crearBoletos(){
            for(int i = 0; i < lugarAsientos.size(); i++) {
                Boleto boleto = new Boleto();
                boleto.setLugar(lugarAsientos.get(i));
                boleto.setFuncion(funcion);
                boleto.setPrecioBoleto(lugarAsientos.get(i).getPrecioAsiento());
                boleto.setFechaFuncion(funcion.getFechaDePresentacion());
                boleto.setHoraFuncion(funcion.getHora());
                
                Boletos.add(boleto); 
                }
    }
    
   /**
    * Metodo que crea los asientos de la zona B1
    * @return Arreglo de botones de la zona B1
    **/
    public JToggleButton[][] creacionAsientosZonaB1( ) { 
            
            botonesB1 = new JToggleButton[FILAS_B][COLUMNAS_B];
            
            int contador = 1;
            
            for( int i = 0;  i < FILAS_B; i++) {
                
                for(int k = 0; k < COLUMNAS_B; k++ ) {
                    
                    botonesB1[i][k] = new JToggleButton();
                    botonesB1[i][k].setBounds(ejeX, ejeY, largoBoton, anchoBoton);
                   
                    btnB1[i][k] = new JLabel();
                    btnB1[i][k] .setBounds(ejeX - 7, ejeY, largoBoton-35, anchoBoton-35);
                    btnB1[i][k] .setText("B"+ contador);
                    this.menu.getSala().getPanelSala().add(btnB1[i][k]);
                    //AQUI TERMINA EL CODIGO DE LOS LABEL'S
                    
                    AccionBotones accion = new AccionBotones();
                    
                    botonesB1[i][k].addActionListener(accion);
                    
                    if( funcion.getZonaB()[i][k].isDisponible() == 1) {
                        botonesB1[i][k].setIcon(crearIconoSilla("/imagenes/asientoDisponible.png"));
                    } else {
                        botonesB1[i][k].setIcon(crearIconoSilla("/imagenes/asientoOcupado.png"));
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
    /**
    * Metodo que crea los asientos de la zona B2
     * @return Arreglo de botones de la zona B2
    **/
    public JToggleButton[][] creacionAsientosZonaB2( ) { 
        
             ejeX = 1050;
             ejeY = 20;
            botonesB2 = new JToggleButton[FILAS_B][COLUMNAS_B];
            
             int contador = 11;
            
            for( int i = 0;  i < FILAS_B; i++) {
                
                for(int k = 0; k < COLUMNAS_B; k++ ) {
                    
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
                        botonesB2[i][k].setIcon(crearIconoSilla("/imagenes/asientoDisponible.png"));
                    } else {
                        botonesB2[i][k].setIcon(crearIconoSilla("/imagenes/asientoOcupado.png"));
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
    
    /**
    * Metodo que crea los asientos de la zona A
     * @return Arreglo de botones de la zona A
    **/
    public JToggleButton[][] creacionAsientosZonaA( ) { 
        
             ejeX = 350;
             ejeY = 20;
            botonesA = new JToggleButton[FILAS_A][COLUMNAS_A];
            int contador = 1;
            
            
            
            for( int i = 0;  i < FILAS_A; i++) {
                
                for(int k = 0; k < COLUMNAS_A; k++ ) {
                    
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
                        botonesA[i][k].setIcon(crearIconoSilla("/imagenes/asientoDisponible.png"));
                    } else {
                        botonesA[i][k].setIcon(crearIconoSilla("/imagenes/asientoOcupado.png"));
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
    /**
    * Metodo que crea los asientos de la zona C
     * @return Arreglo de botones de la zona C
    **/
    public JToggleButton[][] creacionAsientosZonaC( ) { 
             ejeX = 350;
             ejeY = 230;
            botonesC = new JToggleButton[FILAS_A][COLUMNAS_A];
            int contador = 1;
            
            for( int i = 0;  i < FILAS_A; i++) {
                
                for(int k = 0; k < COLUMNAS_A; k++ ) {
                    
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
                        botonesC[i][k].setIcon(crearIconoSilla("/imagenes/asientoDisponible.png"));
                    } else {
                        botonesC[i][k].setIcon(crearIconoSilla("/imagenes/asientoOcupado.png"));
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
    
    /**
     * Metodo que crea el icono de las sillas
     * @param imagen imagen de la silla dependiendo si es Disponible/Seleccionada/Ocupada
     * @return icono de las sillas con las medidas deseadas
     **/
    public Icon crearIconoSilla(String imagen) {
            ImageIcon silla;
            silla = new ImageIcon(getClass().getResource(imagen));
            Icon sillaIcono = new ImageIcon(silla.getImage().getScaledInstance(
                    70, 70, Image.SCALE_SMOOTH));
            return sillaIcono;
        }
  
   /**
    * Clase interna para manejar la accion de los botones
    **/
    public class AccionBotones implements ActionListener {

        @Override
         public void actionPerformed(ActionEvent e) {
            
                for( int i = 0; i < FILAS_B; i++ ) {
                for( int k = 0; k < COLUMNAS_B; k++) {
                 
                    if ( e.getSource().equals(botonesB1[i][k])) {
                        if( funcion.getZonaB()[i][k].isDisponible() == 1) {
                                if(botonesB1[i][k].isSelected()) {
                                    
                                    botonesB1[i][k].setIcon(crearIconoSilla("/imagenes/asientoSeleccionado.png"));
                                } else {
                                    if( funcion.getZonaB()[i][k].isDisponible() == 1) {
                                        botonesB1[i][k].setIcon(crearIconoSilla("/imagenes/asientoDisponible.png"));

                                    } else {
                                        botonesB1[i][k].setIcon(crearIconoSilla("/imagenes/asientoOcupado.png"));
                                }
                            }
                        } else {
                            botonesB1[i][k].enable(false);
                        }
                        
                    }    
                    if ( e.getSource().equals(botonesB2[i][k])) {
                        
                        if( funcion.getZonaB2()[i][k].isDisponible() == 1) {
                            if(botonesB2[i][k].isSelected()) {

                                botonesB2[i][k].setIcon(crearIconoSilla("/imagenes/asientoSeleccionado.png"));
                            } else {
                                if( funcion.getZonaB2()[i][k].isDisponible() == 1) {
                                    botonesB2[i][k].setIcon(crearIconoSilla("/imagenes/asientoDisponible.png"));

                                } else {
                                    botonesB2[i][k].setIcon(crearIconoSilla("/imagenes/asientoOcupado.png"));
                                }
                            }
                        } else {
                            botonesB2[i][k].enable(false);
                        }
                    } 
                } 
                
            }
            
            for( int i = 0; i < FILAS_A; i++ ) {
                for( int k = 0; k < COLUMNAS_A; k++) {
                 
                    if ( e.getSource().equals(botonesA[i][k])) {
                        
                        if( funcion.getZonaA()[i][k].isDisponible() == 1) {
                        
                            if(botonesA[i][k].isSelected()) {

                                botonesA[i][k].setIcon(crearIconoSilla("/imagenes/asientoSeleccionado.png"));
                            } else {
                                if( funcion.getZonaA()[i][k].isDisponible() == 1) {
                                    botonesA[i][k].setIcon(crearIconoSilla("/imagenes/asientoDisponible.png"));

                                } else {
                                    botonesA[i][k].setIcon(crearIconoSilla("/imagenes/asientoOcupado.png"));
                                }
                            }
                        } else {
                            botonesA[i][k].enable(false);
                        }
                    }    
                    
                    if ( e.getSource().equals(botonesC[i][k])) {
                        
                        if( funcion.getZonaC()[i][k].isDisponible() == 1) {
                                
                        if(botonesC[i][k].isSelected()) {

                            botonesC[i][k].setIcon(crearIconoSilla("/imagenes/asientoSeleccionado.png")); 
                        } else {
                            if( funcion.getZonaC()[i][k].isDisponible() == 1) {
                                botonesC[i][k].setIcon(crearIconoSilla("/imagenes/asientoDisponible.png"));

                            } else {
                                botonesC[i][k].setIcon(crearIconoSilla("/imagenes/asientoOcupado.png"));
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
