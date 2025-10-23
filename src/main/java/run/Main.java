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

        Autor k = new Autor();
        k.setNombre("Franz Kafka");
        k.setNacionalidad("Checa");
        dao.insert(k);

        Autor d = new Autor();
        d.setNombre("Fiodor Dostoievski");
        d.setNacionalidad("Rusa");
        dao.insert(d);
    }

    public static void listarAutores() {
        System.out.println("Registro Almacenados:");
        List<Autor> autores = dao.getAll("autores.All", Autor.class);
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void editarAutor() {
        Autor a = new Autor();
        a = dao.findById(1, Autor.class);
        a.setNacionalidad("Mexicana Actualizada");
        dao.update(a);

    }

    public static void eliminarAutor() {
        Autor a = new Autor();
        a = dao.findById(3, Autor.class);
        dao.delete(a);
    }
    public static void insertarCategoria() {
        Categoria a = new Categoria();
        a.setNombre("Realismo Mágico");
        dao.insert(a);

        Categoria r = new Categoria();
        r.setNombre("Modernismo");
        dao.insert(r);

        Categoria k = new Categoria();
        k.setNombre("Existencialismo");
        dao.insert(k);

        Categoria d = new Categoria();
        d.setNombre("Psicológico");
        dao.insert(d);
    }

    public static void listarCategoria() {
        System.out.println("Registro Almacenados:");
        List<Categoria> categorias = dao.getAll("categorias.All", Categoria.class);
        categorias.forEach(categoria -> System.out.println(categoria.getNombre()));
    }

    public static void editarCategoria() {
        Categoria a = new Categoria();
        a = dao.findById(1, Categoria.class);
        a.setNombre("Realismo Mágico Actualizado");
        dao.update(a);
    }

    public static void eliminarCategoria() {
        Categoria a = new Categoria();
        a = dao.findById(3, Categoria.class);
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

        Libro k = new Libro();
        k.setTitulo("El Proceso");
        k.setAutor(dao.findById(3, Autor.class));
        k.setCategoria(dao.findById(3, Categoria.class));
        k.setAñoPub(1925);
        dao.insert(k);

        Libro dd = new Libro();
        dd.setTitulo("Crimen y Castigo");
        dd.setAutor(dao.findById(4, Autor.class));
        dd.setCategoria(dao.findById(4, Categoria.class));
        dd.setAñoPub(1866);
        dao.insert(dd);
    }

    public static void listarLibros() {
        System.out.println("Registro Almacenados:");
        List<Libro> libros = dao.getAll("libros.All", Libro.class);
        libros.forEach(libro -> System.out.println(libro.toString()));
    }

    public static void editarLibro() {
        Libro l = new Libro();
        l = dao.findById(1, Libro.class);
        l.setTitulo("100 años de soledad Actualizado");
        dao.update(l);
    }

    public static void eliminarLibro() {
        Libro l = new Libro();
        l = dao.findById(3, Libro.class);
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