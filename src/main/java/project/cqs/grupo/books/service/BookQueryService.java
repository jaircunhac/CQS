package project.cqs.grupo.books.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.cqs.grupo.books.model.Book;
import project.cqs.grupo.books.repository.BookRepository;

import java.util.List;

@Service
public class BookQueryService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> listarLivros(){
        return bookRepository.findAll();
    }

    public Book buscarLivroPorId(Long id){
        return bookRepository.findById(id).orElseThrow(
                () ->new ObjectNotFoundException("Livro nao encontrado", id)
        );
    }
}
