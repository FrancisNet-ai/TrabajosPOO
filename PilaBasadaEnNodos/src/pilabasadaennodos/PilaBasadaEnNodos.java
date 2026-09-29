/*
 * Curso: Estructura de Datos
 * Pregunta: ¿Qué son las Pilas basadas en nodos?
 *
 * Una pila basada en nodos es una pila (LIFO: el último en entrar es el
 * primero en salir) implementada con nodos enlazados en lugar de un arreglo.
 * Cada nodo guarda un dato y una referencia al nodo que está debajo de él;
 * la pila solo conserva una referencia al nodo de la cima (tope).
 * push y pop trabajan siempre sobre la cima, en tiempo O(1), y el tamaño
 * de la pila es dinámico (no tiene una capacidad fija).
 */
package pilabasadaennodos;

public class PilaBasadaEnNodos {

    // Nodo: guarda un dato y la referencia al siguiente nodo (el de abajo)
    static class Nodo {
        int dato;
        Nodo siguiente;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Pila implementada con nodos enlazados
    static class Pila {
        private Nodo tope;   // cima de la pila
        private int tamanio;

        public Pila() {
            tope = null;
            tamanio = 0;
        }

        // Inserta un elemento en la cima
        public void push(int dato) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = tope;   // el nuevo apunta a la cima anterior
            tope = nuevo;             // el nuevo pasa a ser la cima
            tamanio++;
        }

        // Saca y devuelve el elemento de la cima
        public int pop() {
            if (estaVacia()) {
                throw new RuntimeException("La pila está vacía");
            }
            int dato = tope.dato;
            tope = tope.siguiente;    // la cima baja un nivel
            tamanio--;
            return dato;
        }

        // Devuelve la cima sin sacarla
        public int peek() {
            if (estaVacia()) {
                throw new RuntimeException("La pila está vacía");
            }
            return tope.dato;
        }

        public boolean estaVacia() {
            return tope == null;
        }

        public int tamanio() {
            return tamanio;
        }

        // Muestra la pila desde la cima hasta el fondo
        public void mostrar() {
            Nodo actual = tope;
            System.out.print("tope -> ");
            while (actual != null) {
                System.out.print("[" + actual.dato + "] -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Pila pila = new Pila();

        System.out.println("=== PILA BASADA EN NODOS ===");
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("Después de push(10), push(20), push(30):");
        pila.mostrar();

        System.out.println("Cima (peek): " + pila.peek());
        System.out.println("Tamaño: " + pila.tamanio());

        System.out.println("pop(): " + pila.pop());
        System.out.println("Después de un pop:");
        pila.mostrar();

        pila.push(40);
        System.out.println("Después de push(40):");
        pila.mostrar();

        System.out.println("Vaciando la pila:");
        while (!pila.estaVacia()) {
            System.out.println("  pop(): " + pila.pop());
        }
        System.out.println("¿Está vacía? " + pila.estaVacia());
    }
}
