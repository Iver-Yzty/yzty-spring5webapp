package guru.springframework.spring5webapp.conttrollers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookcontroller {
    private final BookRepository bookRepository;

    public bookcontroller(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getbooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";


    }


}
