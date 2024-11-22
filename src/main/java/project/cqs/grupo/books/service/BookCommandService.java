package project.cqs.grupo.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cqs.grupo.books.model.Book;
import project.cqs.grupo.books.repository.BookRepository;

@Service
public class BookCommandService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookQueryService bookQueryService;

    public Book cadastrarLivro(Book book){
        return bookRepository.save(book);
    }

    public void deletarLivro(Long id){
        Book book = bookQueryService.buscarLivroPorId(id);
        bookRepository.delete(book);
    }

    public Book atualizarLivro(Long id, Book book){
        Book auxBook = bookQueryService.buscarLivroPorId(id);
        auxBook.setNomeLivro(book.getNomeLivro());
        auxBook.setEditoraLivro(book.getEditoraLivro());
        auxBook.setAutorLivro(book.getAutorLivro());
        auxBook.setNumPaginas(book.getNumPaginas());

        return bookRepository.save(auxBook);
    }
}
