package com.eda.Grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map; 
public class Grafo<T> { 
    private Map<T, List<T> > map = new HashMap<>(); 
    private ArrayList<T> nodos = new ArrayList<T>();
    private ArrayList<ArrayList<T>> destinos = new ArrayList<ArrayList<T>>();
    
    public void addVertice(T s) { 
        map.put(s, new LinkedList<T>()); 
    } 
    
    public void removeVertice(T s){
        map.remove(s);
    }
    
    public void addArista(T source,T destination, boolean bidirectional) { 
        if (!map.containsKey(source)) 
            addVertice(source); 
        if (!map.containsKey(destination)) 
            addVertice(destination); 
        map.get(source).add(destination); 
        if (bidirectional)
            map.get(destination).add(source); 
    } 
    
    public void removeArista(T source,T destination){
        if (map.containsKey(source)) {
            map.get(source).remove(destination);
            removeVertice(source);
        }
    }
    
    public void getVerticeCount() { 
        System.out.println("El grafo tiene "+ map.keySet().size() + " vertices"); 
    } 
    
      public void getAristasCount(boolean bidirection) { 
        int count = 0; 
        for (T v : map.keySet())
            count += map.get(v).size(); 
        if (bidirection == true)
            count = count / 2; 
        System.out.println("El grafo tiene "+ count + " aristas."); 
    } 
      
    public void hasVertice(T s) { 
        if (map.containsKey(s)) 
            System.out.println("El grafo tiene "+ s + " como un vertice."); 
        else
            System.out.println("El grafo no tiene "+ s + " como un vertice."); 
    } 
  
    public void hasArista(T s, T d) { 
        if (map.get(s).contains(d))
            System.out.println("El grafo tiene una arista entre " + s + " y " + d + "."); 
        else
            System.out.println("El grafo no tiene una arista entre "+ s + " y " + d + "."); 
    } 
  
    @Override
    public String toString() { 
        String imprimir = "";
        for (T v : map.keySet()) { 
            imprimir = imprimir+v.toString()+": "; 
            for (T w : map.get(v))
                imprimir = imprimir+w.toString()+" ";
            imprimir= imprimir +"\n";
        } 
  
        return imprimir; 
    } 
    
    public ArrayList<T> getNodes() {
    	for (T v : map.keySet())
            nodos.add(v); 
    	return nodos;
    }
    
    public ArrayList<ArrayList<T>> getDestinos() {
    	for (T v : map.keySet()) { 
    		ArrayList<T> destino = new ArrayList<T>();
            for (T w : map.get(v))
            	destino.add(w);
            destinos.add(destino);
        } 
    	return destinos;
    }
    
  
} 
