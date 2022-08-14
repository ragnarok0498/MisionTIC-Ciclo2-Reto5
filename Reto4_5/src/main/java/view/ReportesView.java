package view;

import java.util.List;
import model.vo.ListaLiderVo;
import controller.ReportesController;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.vo.ProyectoVo;
import model.vo.HomecenterProyectoVo;

public class ReportesView extends JFrame implements ActionListener {

    private static ReportesController controller;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem informe1, informe2, informe3;
    private JTable tabla;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;

    //constructor
    public ReportesView() {
        controller = new ReportesController();
        barraMenu();
        etiqueta1();
        etiqueta2();
        tabla();
    }

    public void tabla() {
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500, 200));//que seas scrolleable y fijamos un tamaño
        add(tabla);
        JScrollPane jScrollPane = new JScrollPane(tabla);
        add(jScrollPane);

    }

    public void etiqueta1() {
        lblTitulo = new JLabel("Informe Reto 5");
        lblTitulo.setPreferredSize(new Dimension(500,30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }

    public void etiqueta2() {
        lblConsulta = new JLabel();
        lblConsulta.setPreferredSize(new Dimension(500,30));
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblConsulta);
    }

    public void barraMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("Informes");
        menuBar.add(menu);
        informe1 = new JMenuItem("Primer informe");
        informe2 = new JMenuItem("Segundo informe");
        informe3 = new JMenuItem("Tercer informe");

        menu.add(informe1);
        menu.add(informe2);
        menu.add(informe3);

        informe1.addActionListener(this);
        informe2.addActionListener(this);
        informe3.addActionListener(this);
    }

    public void primerInforme() {
        try {
            List<ListaLiderVo> lideres = controller.listarLideres();

            modelo = new DefaultTableModel(); //creacion modelo
            modelo.addColumn("Id Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");

            for (ListaLiderVo lider : lideres) {
                //Creamos un string de tipo objeto para crear las filas de las tablas apartir de los objetos VO con sus getters 
                Object[] fila = new Object[4];
                fila[0] = lider.getId();
                fila[1] = lider.getNombre();
                fila[2] = lider.getApellido();
                fila[3] = lider.getCiudad();
               modelo. addRow(fila);
            }

            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); //cada ves que se haga una consulta el modelo va a cambiar

        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            ex.printStackTrace();
        }
    }
    
    public void segundoInforme() {

        try {
            List<ProyectoVo> proyectos = controller.listarProyectos();
            
            modelo = new DefaultTableModel(); //creacion modelo
            modelo.addColumn("Id Proyecto");
            modelo.addColumn("Constructura");
            modelo.addColumn("Habitaciones");
            modelo.addColumn("Ciudad");

            for (ProyectoVo proyecto : proyectos) {
                //Creamos un string de tipo objeto para crear las filas de las tablas apartir de los objetos VO con sus getters 
                Object[] fila = new Object[4];
                fila[0] = proyecto.getId();
                fila[1] = proyecto.getConstructora();
                fila[2] = proyecto.getHabitaciones();
                fila[3] = proyecto.getCiudad();
               modelo. addRow(fila);
            }

            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); //cada ves que se haga una consulta el modelo va a cambiar

        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            ex.printStackTrace();
        }
    }
    
     public void tercerInforme() {

        try {
            List<HomecenterProyectoVo> proyectos = controller.listarHomecenterProyectos();
            
            modelo = new DefaultTableModel(); //creacion modelo
            modelo.addColumn("Id Compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco");

            for (HomecenterProyectoVo hProyecto : proyectos) {
                //Creamos un string de tipo objeto para crear las filas de las tablas apartir de los objetos VO con sus getters 
                Object[] fila = new Object[3];
                fila[0] = hProyecto.getId();
                fila[1] = hProyecto.getConstructora();
                fila[2] = hProyecto.getBanco();
               modelo. addRow(fila);
            }

            tabla.setModel(modelo);
            modelo.fireTableDataChanged(); //cada ves que se haga una consulta el modelo va a cambiar
            
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == informe1) {
            primerInforme();
            lblConsulta.setText("Informe de lideres");
        }
        if(e.getSource() == informe2){
            segundoInforme();
            lblConsulta.setText("Informe de proyectos");
        }
        if(e.getSource() == informe3){
        tercerInforme();
        lblConsulta.setText("Informe Homecenter");
        }
    }
}
