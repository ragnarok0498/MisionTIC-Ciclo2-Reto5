package view;

import java.awt.FlowLayout;
import javax.swing.JFrame;
public class Reto4_5 {

    public static void main(String[] args) {
        var reportesView = new ReportesView();
        reportesView.setLayout(new FlowLayout()); 
        reportesView.setSize(600, 400);
        reportesView.setVisible(true);
        reportesView.setResizable(false); 
        reportesView.setTitle("Informes - Reto 5");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView.setLocationRelativeTo(null); 
        
    }
}
