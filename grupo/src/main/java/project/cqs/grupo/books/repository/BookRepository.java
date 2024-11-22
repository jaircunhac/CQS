package project.cqs.grupo.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cqs.grupo.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}
