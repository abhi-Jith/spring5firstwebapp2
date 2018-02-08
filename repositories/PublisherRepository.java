package abhi.springframework.spring5firstwebapp.repositories;

import abhi.springframework.spring5firstwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
