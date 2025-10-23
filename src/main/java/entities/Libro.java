package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "libros")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "libros.All",
                query = "select l from Libro l"
        )
})
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", unique = true, length = 150, nullable = false)
    private String titulo;

    private int añoPub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="autor_id")
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @Override
    public String toString() {
        return titulo;
    }
}

