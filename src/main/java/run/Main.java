package run;

import entities.Autor;
import entities.Categoria;
import entities.Libro;
import jakarta.persistence.EntityManager;
import services.dao.MyDao;
import services.interfaces.ICRUD;
import util.JPAConexion;

import java.util.List;

public class Main {

    public static final ICRUD dao = new MyDao();

    public static void insertarAutor() {
        Autor a = new Autor();
        a.setNombre("Gabriel Garcia Marquez");
        a.setNacionalidad("Mexicana");
        dao.insert(a);

        Autor r = new Autor();
        r.setNombre("Ruben Dario");
        r.setNacionalidad("Nicaraguense");
        dao.insert(r);
    }

    public static void listarAutores() {
        System.out.println("Registro Almacenados:");
        List<Autor> autores = dao.getAll("autores.All", Autor.class);
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void editarAutor() {
        Autor a = new Autor();
        a = dao.findById(1, Autor.class);
        a.setNacionalidad("Colombiana");
        dao.update(a);

    }

    public static void eliminarAutor() {
        Autor a = new Autor();
        a = dao.findById(1, Autor.class);
        dao.delete(a);
    }
    public static void insertarCategoria() {
        Categoria a = new Categoria();
        a.setNombre("Realismo Mágico");
        dao.insert(a);

        Categoria r = new Categoria();
        r.setNombre("Modernismo");
        dao.insert(r);
    }

    public static void listarCategoria() {
        System.out.println("Registro Almacenados:");
        List<Categoria> categorias = dao.getAll("categorias.All", Categoria.class);
        categorias.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void editarCategoria() {
        Categoria a = new Categoria();
        a = dao.findById(1, Categoria.class);
        a.setNombre("Realismo No tan Magico");
        dao.update(a);
    }

    public static void eliminarCategoria() {
        Categoria a = new Categoria();
        a = dao.findById(1, Categoria.class);
        dao.delete(a);
    }

    public static void insertarLibro() {
        Libro b = new Libro();
        b.setTitulo("100 años de soledad");
        b.setAutor(dao.findById(1, Autor.class));
        b.setCategoria(dao.findById(1, Categoria.class));
        b.setAñoPub(1967);
        dao.insert(b);

        Libro c = new Libro();
        c.setTitulo("Azul");
        c.setAutor(dao.findById(2, Autor.class));
        c.setCategoria(dao.findById(2, Categoria.class));
        c.setAñoPub(1988);
        dao.insert(c);
    }

    public static void listarLibros() {
        System.out.println("Registro Almacenados:");
        List<Libro> libros = dao.getAll("libros.All", Libro.class);
        libros.forEach(libro -> System.out.println(libro.toString()));
    }

    public static void editarLibro() {
        Libro l = new Libro();
        l = dao.findById(1, Libro.class);
        l.setTitulo("Cien años de soledad");
        dao.update(l);
    }

    public static void eliminarLibro() {
        Libro l = new Libro();
        l = dao.findById(1, Libro.class);
        dao.delete(l);
    }


    public static void main(String[] args) {
        insertarAutor();
        insertarCategoria();
        insertarLibro();
        listarAutores();
        listarLibros();
        listarCategoria();
        editarAutor();
        editarCategoria();
        editarLibro();
        listarAutores();
        listarCategoria();
        eliminarLibro();
        eliminarAutor();
        eliminarCategoria();
        listarAutores();
        listarCategoria();
        listarLibros();
    }
}


