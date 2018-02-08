package abhi.springframework.spring5firstwebapp.controllers;

import abhi.springframework.spring5firstwebapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*This does the registration of the class in spring and detects it as a spring bean
and create a class for us ad wire it to  the spring context*/
@Controller
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //getBooks-View name
    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "books";
    }
}
