package abhi.springframework.spring5firstwebapp.bootstrap;

import abhi.springframework.spring5firstwebapp.model.Author;
import abhi.springframework.spring5firstwebapp.model.Book;
import abhi.springframework.spring5firstwebapp.model.Publisher;
import abhi.springframework.spring5firstwebapp.repositories.AuthorRepository;
import abhi.springframework.spring5firstwebapp.repositories.BookRepository;
import abhi.springframework.spring5firstwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    //Spring autowire and populate the data into repositories using injection as below:
    public DataBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        //Author-1
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher secPublisher = new Publisher();
        secPublisher.setName("bar");
        publisherRepository.save(secPublisher);

        //Author-2
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "134", secPublisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }
}
