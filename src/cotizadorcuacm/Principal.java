package cotizadorcuacm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import org.jdesktop.swingx.prompt.PromptSupport;

public class Principal extends JFrame implements ActionListener {
    
    private JLabel producto[] = new JLabel[10];
    private JTextField entradas[] = new JTextField[50];
    
    private JMenuBar barra;
    private JMenu archivo[] = new JMenu[3];
    private String titles[] = {"Archivo", "Edición", "Ayuda"};
    private JMenuItem nuevo, guardar, salir, modIVA, acerca;
    private String placeholder[] = {"Producto","Piezas","Precio","Subtotal","Total"}; 
    
    public Principal(int num){
            
        setLayout(null);
        setTitle("Cotizador ComedorUACM");
        setIconImage(new ImageIcon(getClass().getResource("/img/ic_launcher.png")).getImage());
        
        barra = new JMenuBar();
        setJMenuBar(barra);
        
        for(int g = 0; g < 3 ;g++){
            archivo[g] = new JMenu(titles[g]);
            barra.add(archivo[g]);
        }
        
        nuevo = new JMenuItem("Nuevo");
        nuevo.addActionListener(this);
        archivo[0].add(nuevo);
        
        guardar = new JMenuItem("Guardar");
        guardar.addActionListener(this);
        archivo[0].add(guardar);
        
        salir = new JMenuItem("Salir");
        salir.addActionListener(this);
        archivo[0].add(salir);
        
        modIVA = new JMenuItem("Modificar IVA");
        modIVA.addActionListener(this);
        archivo[1].add(modIVA);
        
        acerca = new JMenuItem("Acerca de");
        acerca.addActionListener(this);
        archivo[2].add(acerca);
        
        for(int i = 0; i < num; i++){
            int y = (50*i);
                producto[i] = new JLabel("Producto "+(i+1));
                producto[i].setBounds(10, y, 100, 30);
                add(producto[i]);
            for(int j = 0, k = 1; j < 5; j++, k++){
                entradas[j] = new JTextField();
                PromptSupport.init(placeholder[j]+" "+ (i+1), Color.black, Color.white, entradas[j]);
                entradas[j].setBounds((10*k)+(10*(j*10)), (y+30), 100, 20);
                add(entradas[j]);               
            }
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == salir){
           System.exit(0);
       }
    }
    
}
