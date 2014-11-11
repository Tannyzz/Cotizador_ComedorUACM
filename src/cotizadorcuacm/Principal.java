package cotizadorcuacm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import org.jdesktop.swingx.prompt.PromptSupport;

public class Principal extends JFrame implements ActionListener {
    
    private JLabel producto[] = new JLabel[10];
    private JTextField entradas[] = new JTextField[50];
    private JTextField matriz[][] = new JTextField[10][5];
    private JMenu archivo[] = new JMenu[3];
    private JButton herramientas[] = new JButton[5];
    private JMenuItem nuevo, guardar, salir, modIVA, acerca;
    private JButton button, button1;
    private JMenuBar barra;
    private JLabel ivaL;
    private String titles[] = {"Archivo", "Edición", "Ayuda"};
    private String text[] = {"Nuevo","Calcular","Limpiar","Historial","IVA"};    
    private String placeholder[] = {"Producto","Piezas","Precio","Subtotal","Total"};
    private String iva = "16";
    
    public Principal(int num){
            
        setLayout(null);   
 
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
        
        JToolBar bar = new JToolBar();
        bar.setSize(600, 50);
        bar.setFloatable(false);
        
            for(int h = 0; h < 4; h++){
                Icon icono = new ImageIcon(getClass().getResource("/img/"+h+".png"));
                herramientas[h] = new JButton();
                herramientas[h].setIcon(icono);
                herramientas[h].addActionListener(this); 
                bar.add(herramientas[h]);
            }
            ivaL = new JLabel(iva+"% IVA");
            bar.add(ivaL);
            
                /*Hans, al tratar de recolectar la informacion
                  de los JTextField noté que el arreglo por
                  mucho que mida 50 se esta sobreescribiedo,
                  sólo se logra recuperar el arreglo de la
                  ultima iteracion. Por eso necesite crear
                  el arreglo bidimencional.
            
            for(int i = 0; i < num; i++){
                    int y = (45*(i+1));
                        producto[i] = new JLabel("Producto "+(i+1));
                        producto[i].setBounds(10, y, 100, 30);
                        add(producto[i]);
                    for(int j = 0, k = 1; j < 5; j++, k++){
                        entradas[j] = new JTextField();
                        PromptSupport.init(placeholder[j]+" "+ (i+1), Color.black, Color.white, entradas[j]);
                        entradas[j].setBounds((10*k)+(10*(j*10)), (y+30), 100, 20);
                        add(entradas[j]);               
                    }            
                }*/
                for(int a = 0; a < num; a++){
                    int y = (45*(a+1));
                        producto[a] = new JLabel("Producto "+(a+1));
                        producto[a].setBounds(10, y, 100, 30);
                        add(producto[a]);
                    for(int b = 0, k = 2; b < 5; b++){
                         matriz[a][b] = new JTextField();
                         PromptSupport.init(placeholder[b]+" "+ (a+1), Color.black, Color.white, matriz[a][b]);
                         matriz[a][b].setBounds((10*k)+(10*(b*10)),(y+30), 100, 20);
                        add(matriz[a][b]); 
                    }
                }
        add(bar);
        setTitle("Cotizador ComedorUACM");
        setIconImage(new ImageIcon(getClass().getResource("/img/ic_launcher.png")).getImage());
        pack();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == salir){
           System.exit(0);
       }
       if(e.getSource() == herramientas[2]){
           for (int a = 0; a < 10; a++) {
               for (int b = 0; b < 5; b++) {
                    matriz[a][b].setText(null);
               }
              
           }
       }
    }
}
