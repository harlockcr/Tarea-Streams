import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)
    {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));

    //Obtener un sublistado con las películas estrenadas en el siglo XXI (a partir del año 2000, inclusive)
        System.out.println("Ejercicio 1");
        List<Pelicula> sigloXXI = peliculas.stream().filter(p->p.getEstreno() >= 2000).toList();
        sigloXXI.forEach(System.out::println);
        System.out.println();
    //Mostrar por pantalla, separados por comas, los títulos de las películas de Steven Spielberg
        System.out.println("Ejercicio 2");
       String spielbergPeliculas = peliculas.stream().filter(p->p.getDirector().equals("Steven Spielberg")).map(Pelicula::getTitulo).collect(Collectors.joining(", ", "Peliculas de Steven Spielber: ","."));

       System.out.println(spielbergPeliculas);

        System.out.println();
    //Obtener un sublistado con los nombres de las películas, ordenados alfabéticamente
        System.out.println("Ejercicio 3");
        List<String> nombresOrdenados = peliculas.stream().sorted(Comparator.comparing(Pelicula::getTitulo)).map(Pelicula::getTitulo).toList();
        nombresOrdenados.forEach(System.out::println);
        System.out.println();

        //Mostrar por pantalla el año de estreno más reciente
        System.out.println("Ejercicio 4");
        System.out.println(peliculas.stream().max(Comparator.comparing(Pelicula::getEstreno)).get());
    }
}