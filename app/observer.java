import java.util.ArrayList;
import java.util.List;

// Observador
interface Observer {
    void actualizar(String noticia);
}

// Sujeto Observable
class ServicioNoticias {
    private List<Observer> observadores = new ArrayList<>();

    public void agregarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observer observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String noticia) {
        for (Observer observador : observadores) {
            observador.actualizar(noticia);
        }
    }

    public void publicarNoticia(String noticia) {
        System.out.println("Nueva noticia: " + noticia);
        notificarObservadores(noticia);
    }
}

// Observador concreto
class Usuario implements Observer {
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String noticia) {
        System.out.println(nombre + " ha recibido una actualización: " + noticia);
    }
}

 class ProgramaObserver {
    public static void main(String[] args) {
        // Crear el sujeto observable
        ServicioNoticias servicioNoticias = new ServicioNoticias();

        // Crear observadores (usuarios)
        Observer usuario1 = new Usuario("Usuario1");
        Observer usuario2 = new Usuario("Usuario2");

        // Registrar observadores con el sujeto observable
        servicioNoticias.agregarObservador(usuario1);
        servicioNoticias.agregarObservador(usuario2);
        servicioNoticias.publicarNoticia("Importante: ¡Nuevo descubrimiento científico!");

    }
}

