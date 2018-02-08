package abhi.springframework.spring5firstwebapp.repositories;

import abhi.springframework.spring5firstwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
