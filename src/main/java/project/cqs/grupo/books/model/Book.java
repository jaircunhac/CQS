package project.cqs.grupo.books.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LIVROS")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIVRO")
    private Long idLivro;
    @Column(name = "NOME")
    private String nomeLivro;
    @Column(name = "NUMERO_PAGINAS")
    private int numPaginas;
    @Column(name = "AUTOR")
    private String autorLivro;
    @Column(name = "EDITORA")
    private String editoraLivro;
}
