package project.cqs.grupo.books.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.cqs.grupo.books.model.Book;
import project.cqs.grupo.books.service.BookCommandService;
import project.cqs.grupo.books.service.BookQueryService;

import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class BookResource {
    @Autowired
    private BookQueryService queryService;
    @Autowired
    private BookCommandService commandService;

    // Commands

    @PostMapping
    public ResponseEntity<Book> cadastrarLivro(@RequestBody Book book){
        Book novoLivro = commandService.cadastrarLivro(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> atualizarLivro(@PathVariable Long id, @RequestBody Book book){
        Book auxLivro = commandService.atualizarLivro(id, book);
        return ResponseEntity.ok().body(auxLivro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id){
        commandService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    // Queries

    @GetMapping
    public ResponseEntity<List<Book>> listarLivros(){
        List<Book> auxBook = queryService.listarLivros();
        return ResponseEntity.ok().body(auxBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> buscarLivro(@PathVariable Long id){
        Book auxBook = queryService.buscarLivroPorId(id);
        return ResponseEntity.ok().body(auxBook);
    }
}
