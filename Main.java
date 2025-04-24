package practicalistas;
// Clase Nodo
class Nodo {
    int dato;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }
}

// Clase ListaDobleEnlazada
class ListaDobleEnlazada {
    Nodo cabeza;
    Nodo cola;

    // Insertar al final
    public void insertarAlFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    // Eliminar por valor
    public void eliminar(int valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) {
                if (actual == cabeza) {
                    cabeza = actual.siguiente;
                    if (cabeza != null) cabeza.anterior = null;
                } else if (actual == cola) {
                    cola = actual.anterior;
                    if (cola != null) cola.siguiente = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }
                return;
            }
            actual = actual.siguiente;
        }
    }

    // Buscar un valor
    public boolean buscar(int valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // Imprimir de izquierda a derecha
    public void imprimirAdelante() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // Imprimir de derecha a izquierda
    public void imprimirAtras() {
        Nodo actual = cola;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.anterior;
        }
        System.out.println();
    }
}

// Clase principal con ejemplo de uso
public class Main {
    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();

        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);

        System.out.print("Adelante: ");
        lista.imprimirAdelante(); // 10 20 30

        System.out.print("Atrás: ");
        lista.imprimirAtras(); // 30 20 10

        lista.eliminar(20);

        System.out.print("Después de eliminar 20: ");
        lista.imprimirAdelante(); // 10 30

        System.out.println("¿Está 30?: " + lista.buscar(30)); // true
        System.out.println("¿Está 40?: " + lista.buscar(40)); // false
    }
}
