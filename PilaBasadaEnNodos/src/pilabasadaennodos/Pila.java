/*
 * Curso: Estructura de Datos
 * Pila basada en nodos - clase Pila
 *
 * Pila (LIFO: el último en entrar es el primero en salir) implementada
 * con nodos enlazados. Solo se guarda la referencia al nodo de la cima
 * (tope); push y pop trabajan siempre sobre la cima en tiempo O(1) y
 * el tamaño es dinámico (no tiene una capacidad fija como un arreglo).
 */
package pilabasadaennodos;

public class Pila {

    private Nodo tope;     // nodo de la cima
    private int tamanio;   // cantidad de nodos

    public Pila() {
        tope = null;
        tamanio = 0;
    }

    // Inserta un elemento en la cima
    public void push(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(tope);   // el nuevo apunta a la cima anterior
        tope = nuevo;               // el nuevo pasa a ser la cima
        tamanio++;
    }

    // Saca y devuelve el elemento de la cima
    public int pop() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        int dato = tope.getDato();
        tope = tope.getSiguiente(); // la cima baja un nivel
        tamanio--;
        return dato;
    }

    // Devuelve el elemento de la cima sin sacarlo
    public int peek() {
        if (estaVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        return tope.getDato();
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    // Devuelve los elementos desde la cima hasta el fondo,
    // para mostrarlos en un componente del JFrame (JLabel, JTextArea...)
    public String recorrer() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = tope;
        while (actual != null) {
            sb.append(actual.getDato()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}
