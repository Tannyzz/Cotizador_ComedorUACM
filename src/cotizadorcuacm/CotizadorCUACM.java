package cotizadorcuacm;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CotizadorCUACM extends JFrame{
    
    
      
    public static void main(String[] args) {       
       
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Cotizado ComedorUACM, introduce un maximo de 10 productos.",
                "Cotizador Comedor UACM - CCUACM",
                JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(CotizadorCUACM.class.getResource("/img/ic_launcher.png")));        
        
        String numeroE = JOptionPane.showInputDialog("Introduce el número de productos a calcular");
        int num = Integer.parseInt(numeroE);
        
        Principal miVentana = new Principal(num);
        miVentana.setBounds(200, 200, 600, 600);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setDefaultCloseOperation(miVentana.EXIT_ON_CLOSE);
        
    }
    
}
