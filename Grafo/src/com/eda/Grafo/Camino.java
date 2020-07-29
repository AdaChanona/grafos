package com.eda.Grafo;

public class Camino {
	  String recorrido[][];


	    public String almo(long [][] mady){
	        int vertices = mady.length;
	        long matriz[][]=mady;
	        String caminos [][]= new String[vertices][vertices];
	        String caminosaux[][]= new String[vertices][vertices];
	        String caminoRecorrido= "", cadena = "",caminitos="";
	        int i,j,k;
	        float t1,t2, t3, t4,minimo;
	        // matrices caminosy matriz caminosnada
	        for (i = 0; i < vertices; i++) {
	            for (j = 0; j< vertices; j++) {
	                caminos[i][j]= "";
	                caminosaux[i][j]="";
	            }
	        }
	        
	        
	        
	        for (k = 0; k < vertices; k++) {
	            for (i = 0; i <vertices; i++) {
	                for (j = 0; j < vertices; j++) {
	                    t1=matriz[i][j];
	                    t2=matriz[i][k];
	                    t3=matriz[k][j];
	                    t4=t2 +t3;
	                    
	                    //search Minimo
	                    minimo = Math.min(t1, t4);
	                    if (t2!=t4) {
	                        if (minimo==t4) {
	                            caminoRecorrido="";
	                            caminosaux[i][j]=k+"";
	                            caminos[i][j]=caminoR(i,k,caminosaux,caminoRecorrido)+(k+1);
	                        }
	                    }
	                    matriz[i][j]=(long)minimo;
	                       
	                }
	            }
	        }
	        
	        // End first Cycle(for)
	        // adding walk to cadena
	        for (i = 0; i < vertices;i ++) {
	            for (j = 0; j < vertices;j ++) {
	                cadena=cadena+"["+matriz[i][j]+"]";
	            }
	            cadena = cadena +"\n";
	        }
	        
	        
	        
	        // Logic There Are its More More Important
	        
	        for (i = 0; i < vertices; i++) {
	            for ( j = 0; j < vertices; j++) {
	                if (matriz[i][j]!=1000000000) {
	                    if (i!=j) {
	                        if (caminos[i][j].equals("")) {
	                            caminitos +=""+(i+1)+","+(j+1)+"-";
	                        }else{
	                            caminitos +=""+(i+1)+","+caminos[i][j]+","+(j+1)+"-";
	                        }
	                    }
	                    // end first if
	                }
	                
	                
	            }
	        }
	 
	     return "\n"+caminitos;
	    }
	    
	    public String caminoR(int i, int k ,String[][] caminosaux,String caminorecorrido){
	        if (caminosaux[i][k].equals("")) {
	            return "";
	        }else{
	            //recursividad al billon
	            
	            int c = Integer.parseInt(caminosaux[i][k].toString());
	            caminorecorrido +=caminoR(i,c,caminosaux,caminorecorrido)+
	                    (Integer.parseInt(caminosaux[i][k].toString())+1+" , ");
	        
	        }
	       return caminorecorrido;     
	    }

	    public String[][] getRecorrido() {
	        return recorrido;
	    }
    
    
}
