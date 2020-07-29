package com.eda.Grafo;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class RootController implements Initializable{
	
	private ImageView[] imgs;
    private long [][] z;
    String rutas = "";
    ArrayList<Integer> rutaImprecion = new ArrayList<>();
    int inicio;
   	int turno = 0;
   	int last;
   	String camino;
   	
    @FXML
    private Line linea5_6;
    
    @FXML
    private Line linea5_1;

    @FXML
    private Line linea4_5;

    @FXML
    private Line linea2_4;

    @FXML
    private Line linea2_3;

    @FXML
    private Line linea2_6;

    @FXML
    private Line linea6_3;

    @FXML
    private Line linea1_6;
   	
    @FXML
    private ImageView aero_1;

    @FXML
    private ImageView aero_2;

    @FXML
    private ImageView aero_3;

    @FXML
    private ImageView aero_4;

    @FXML
    private ImageView aero_5;
    
    @FXML
    private ImageView aero_6;

	
	@FXML
    private Button Ruta;

    @FXML
    private Button limpiar;
    

    @FXML
    void generarRutaOnMouseClicked(MouseEvent event) {
    	ruta();
    	pintarRuta(rutaImprecion);
    	
    }
    
    @FXML
    void limpiarOnMouseClicked(MouseEvent event) {
    	String rutas = "";
        rutaImprecion = new ArrayList<>();
        inicio=0;
        turno = 0;
        last=0;
       	camino="";
       	imgs= new ImageView[]{aero_1,aero_2, aero_3, aero_4,aero_5,aero_6};
       	for(int i=0;i< imgs.length; i++) {
       		imgs[i].setImage(new Image("Recursos/icono.png"));
       	}

    }
    
    @FXML
    void interseccionOnMouseClicked(MouseEvent event) {
    	turno++;
    	
    	if (turno==1) {
    		inicio=1;
		}
    	
    	if (turno==2) {
    		last=1;
    		turno=0;
    	}
    	
    	
    }

    @FXML
    void sala1OnMouseClicked(MouseEvent event) {
    	turno++;
    	
    	if (turno==1) {
    		inicio=2;
		}
    	
    	if (turno==2) {
    		last=2;
    		turno=0;
    	}

    }

    @FXML
    void sala2OnMouseClicked(MouseEvent event) {
    	turno++;
    	
    	if (turno==1) {
    		inicio=3;
		}
    	
    	if (turno==2) {
    		last=3;
    		turno=0;
    	}
    }

    @FXML
    void sala3OnMouseClicked(MouseEvent event) {
    	turno++;
    	
    	if (turno==1) {
    		inicio=4;
		}
    	
    	if (turno==2) {
    		last=4;
    		turno=0;
    	}
    }

    @FXML
   void sala4OnMouseClicked(MouseEvent event) {
    	turno++;
    	
    	if (turno==1) {
    		inicio=5;
		}
    	
    	if (turno==2) {
    		last=5;
    		turno=0;
    	}
    }

    @FXML
    void sala5OnMouseClicked(MouseEvent event) {
    	turno++;
    	
    	if (turno==1) {
    		inicio=6;
		}
    	
    	if (turno==2) {
    		last=6;
    		turno=0;
    	}

    }
	 
    
   @Override
	public void initialize(URL location, ResourceBundle resources) {
		//Random random = new Random(System.currentTimeMillis());
		Grafo<NodoGrafo> aerolinea = new Grafo<NodoGrafo>();
		NodoGrafo[] aeropuertos = new NodoGrafo[6];
		String[] nombresAeropuertos = {"intersecion","sala 1", "sala 2", "sala 3","sala 4", "sala 5"};
		imgs= new ImageView[]{aero_1,aero_2, aero_3, aero_4,aero_5,aero_6};
		for(int i=0; i<aeropuertos.length;i++) {
			aeropuertos[i] = new NodoGrafo(nombresAeropuertos[i]);
		}
		for (int i = 0; i < aeropuertos.length; i++) {
			//int n = random.nextInt(5);
			imgs[i].setImage(new Image("Recursos/icono.png"));
		}
		
		aerolinea.addArista(aeropuertos[1], aeropuertos[2], true);
		aerolinea.addArista(aeropuertos[1], aeropuertos[3], true);
		aerolinea.addArista(aeropuertos[1], aeropuertos[5], true);
		aerolinea.addArista(aeropuertos[2], aeropuertos[5], true);
		aerolinea.addArista(aeropuertos[3], aeropuertos[4], true);
		aerolinea.addArista(aeropuertos[4], aeropuertos[0], true);
		aerolinea.addArista(aeropuertos[5], aeropuertos[0], true);
		aerolinea.addArista(aeropuertos[4], aeropuertos[5], true);


		
		
		
		System.out.println("Grafo: \n"+ aerolinea.toString());
		
		long matrizA[][] = { 
                { 999999999, 999999999, 999999999, 999999999, 999999999, 5 },
                { 999999999, 999999999, 3, 10, 999999999, 20 },
                { 999999999, 3, 999999999, 999999999, 999999999, 15 },
                { 999999999, 10, 999999999, 999999999, 12, 999999999 },
                { 999999999, 999999999, 999999999, 12, 999999999, 1 },
                { 5, 20, 15, 999999999, 1, 999999999 } };
		
			z=matrizA;    		
	
   }
   
   public void ruta() {
	   Camino ruta=new Camino();
   	System.out.println("inicio "+inicio+" "+"final "+last);
   	
   	 int i = 0;
        String caminos = ruta.almo(z);
        String[] caminosSplit = caminos.split("-");
        for (String string : caminosSplit) {
            i++;
            //System.out.println(string + "\n" + i);
        }
        
        String ini = String.valueOf(inicio);
        String fini = String.valueOf(last);
        
        int control = 0;// variable local
        for (String string : caminosSplit) {
            int tamano = string.length();

            if (control == 0) {
                String j = String.valueOf(string.charAt(1));
                String l = String.valueOf(string.charAt(tamano - 1));
                //System.out.println(j + l + "iteracion:" + control);
                if (j.equals(ini) && l.equals(fini)) {
                    System.out.println("funciono");
                    rutas = string;
                    break;
                }

            } else {
                try {
                    String j = String.valueOf(string.charAt(0));
                    String l = String.valueOf(string.charAt(tamano - 1));
                    //System.out.println(j + l + "iteracion:" + control);
                    if (j.equals(ini) && l.equals(fini)) {
                        System.out.println("funciono");
                        rutas = string;
                    }
                } catch (Exception s) {
                    // TODO: handle exception
                }

            }
            control++;
        }
        
        String[] parseoRuta = rutas.split(",");
        for (String string : parseoRuta) {
            rutaImprecion.add(checarParse(string));
        }
   	
        System.out.println("-----------------------------");
        System.out.println(rutaImprecion);
   }
   
   public  int checarParse(String s) {
       int parseado = 0;
       for (int i = 0; i < s.length(); i++) {
           try {
               String g = "" + s.charAt(i);
               parseado=Integer.parseInt(g);
           }catch (Exception e) {
               //TODO: handle exception
           }
   
       }

       return parseado;
   }
   
   public  void pintarRuta(ArrayList<Integer> a) {

       for (Integer integer : a) {
           switch (integer) {
               case 1:
                   aero_1.setImage(new Image("Recursos/iconoRuta.png"));
                   break;
               case 2:
            	   aero_2.setImage(new Image("Recursos/iconoRuta.png"));
                   break;
               case 3:
            	   aero_3.setImage(new Image("Recursos/iconoRuta.png"));
                   break;
               case 4:
            	   aero_4.setImage(new Image("Recursos/iconoRuta.png"));
                   break;
               case 5:
            	   aero_5.setImage(new Image("Recursos/iconoRuta.png"));
                   break;
               case 6:
            	   aero_6.setImage(new Image("Recursos/iconoRuta.png"));
                   break;

           
               default:
                   break;
           }
       }



       
   }
}
