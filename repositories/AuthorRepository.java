package abhi.springframework.spring5firstwebapp.repositories;

import abhi.springframework.spring5firstwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
