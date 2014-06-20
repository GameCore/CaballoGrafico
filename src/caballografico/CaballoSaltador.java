/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package caballografico;



public class CaballoSaltador {
    static final int N = 8;  
    static final int n = (N+1);  
    public int [][] tablero = new int[n][n]; 
    private boolean exito; private int [][]SALTO = {{2,1}, {1,2}, {-1,2}, {-2,1},          
        {-2,-1}, {-1,-2}, {1,-2}, {2,-1}}; 
    private int x0, y0;  // constructor 
    public CaballoSaltador(int x, int y) throws Exception 
    {  
    if ((x < 1) || (x > N) ||   (y < 1) || (y > N))    throw new Exception("Coordenadas fuera de rango");
      x0 = x;  y0 = y;  
    for(int i = 1; i<= N; i++)   
    for(int j = 1; j<= N; j++)    
    tablero[i][j] = 0;  
    tablero[x0][y0] = 1;    
    exito = false; 
} 
    
    public int [][] rMatriz(){
        return this.tablero; 
}
    
public boolean resolverProblema() 
{  saltoCaballo(x0, y0, 2);  
return exito;
}  private void saltoCaballo(int x, int y, int i) 
{  int nx, ny;  
int k;
 k = 0; // inicializa el conjunto de posibles movimientos   
do {   
    k++;
   nx = x + SALTO[k-1][0];
   ny = y + SALTO[k-1][1];
   // determina si nuevas coordenadas son aceptables
   if ((nx >= 1) && (nx <= N) && (ny >= 1) && (ny <= N)
            &&
            (tablero[nx][ny] == 0))
       {    
           tablero[nx][ny]= i;
       if (i < N*N)
           {               
               saltoCaballo(nx, ny, i+1);
           // se analiza si se ha completado la soluciÃ³n 
               if (!exito)
{ // no se alcanzÃ³ la soluciÃ³n 
    tablero[nx][ny] = 0; // se borra anotaciÃ³n
}      }      else       exito = true;  // tablero cubierto  
       }  } while ((k < 8) && !exito); } 
//muestra por pantalla los pasos del caballo 
public void escribirTablero() 
{  for(int i = 1; i <= N; i++)   
{   for(int j = 1;
         j <= N; j++)    
        System.out.print(tablero[i][j] + "  ");   
        System.out.println("");
}

}


}
