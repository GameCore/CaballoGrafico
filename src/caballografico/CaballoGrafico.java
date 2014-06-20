/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package caballografico;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Pablo
 */
public class CaballoGrafico  extends JPanel{
    public static int distanciaLineas;
     public static int posiciones[][]= new int[8][8];
   
    
   
public CaballoGrafico(){

    
    ActionListener animate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        };
    
        Timer timer = new Timer(60*60*60,animate);
        timer.start();
    
}
   
        
    
 
 

           
           
          

             

    public static void main(String[] args) {
   boolean solucion;
 BufferedReader entrada = new BufferedReader(
         new InputStreamReader(System.in));
    int x,y;
        
try { 
             System.out.println("Posicion inicial del caballo. ");
       System.out.print(" x = ");
       x = Integer.parseInt(entrada.readLine());
       System.out.print(" y = "); 
       y = Integer.parseInt(entrada.readLine()); 
      CaballoSaltador miCaballo = new CaballoSaltador(x,y);
      
      posiciones= miCaballo.rMatriz();
            
  solucion = miCaballo.resolverProblema();
  

       if (solucion)
           miCaballo.escribirTablero(); 
       
         
}
       catch (Exception m)
       {
           System.out.println("No se pudo probar el algoritmo, " + m);  
       }

Tablero tab = new Tablero();

            

    }
    
    
    
    
    public  void paint(Graphics g) {
        
      
        
        int reinaX,reinaY;
        int ejeX,ejeY;
        int tamañoTablero = 8;
        int aux;
         CaballoGrafico.distanciaLineas = 700/tamañoTablero;
       
           Graphics2D g2d   = (Graphics2D) g;
           super.paintComponent(g2d);
           Dimension tamanio = getSize();
           ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/chess.jpg"));
           ImageIcon reinaImagen = new ImageIcon(getClass().getResource("/imagenes/reina.png"));           
           int auxEjes=CaballoGrafico.distanciaLineas;
         
         
          


           g2d.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
          
for(aux=1;aux<=64;aux++){
    
       for(int i = 1; i <= 8; i++)   
           for(int j = 1;j <= 8; j++) {   
   
       //System.out.println(posiciones[i][j]);
   if( 7 == posiciones[i][j]){
       ejeX=i;
       reinaX = ejeX*auxEjes;
       reinaX-=CaballoGrafico.distanciaLineas;
       
       ejeY=j;
       reinaY = ejeY*auxEjes;
       reinaY-=CaballoGrafico.distanciaLineas;
       
         
      
       g2d.drawImage(reinaImagen.getImage(),reinaY,reinaX,CaballoGrafico.distanciaLineas, CaballoGrafico.distanciaLineas, null);
       
    
       
       
       } 
}        

}
       
           
       
      
           
         //  g2d.drawImage(reinaImagen.getImage(),reinaX,reinaY,Caballo.distanciaLineas, Caballo.distanciaLineas, null);
            setOpaque(false);
           // le indicamos al panel que no dibuje su fondo por defecto (sino este taparía la imagen)
           
           // le indicamos al panel que continúe dibujando el resto de los componentes.
           g2d.setColor(Color.BLUE);
           int b =CaballoGrafico.distanciaLineas;
                 
    /*       for(int aux1=b;aux1<=700;aux1+=b){           
           g2d.drawLine(aux1 , 0 , aux1, 700);
           g2d.drawLine( 0 , aux1 , 700, aux1);
           
}*/
    }
    
       public static void pause(int seconds){
    Date start = new Date();
    Date end = new Date();
    while(end.getTime() - start.getTime() < seconds * 1000){
        end = new Date();
    }
}
    
    
    
    
    
}
   