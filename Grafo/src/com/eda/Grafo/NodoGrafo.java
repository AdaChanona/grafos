package com.eda.Grafo;

public class NodoGrafo {
	public String data; 
	public NodoGrafo left, right, parent;

	public NodoGrafo(String data){
		this.data = data;
		left = null;
		right = null;
	}

	public boolean isEmpty(){
        return right == null && left == null;
    }
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
    @Override
    public String toString() {
        return data;
    }
}
