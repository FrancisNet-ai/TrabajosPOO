/*
 * Curso: Estructura de Datos
 * Pila basada en nodos - clase Nodo
 *
 * Un nodo es la unidad básica de la pila: guarda un dato y una
 * referencia (enlace) al siguiente nodo, que es el que está debajo
 * de él en la pila. El último nodo de la pila apunta a null.
 */
package pilabasadaennodos;

public class Nodo {

    private int dato;        // valor que guarda el nodo
    private Nodo siguiente;  // enlace al nodo de abajo

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
