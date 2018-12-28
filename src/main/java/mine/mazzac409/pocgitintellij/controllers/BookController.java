package mine.mazzac409.pocgitintellij.controllers;

import mine.mazzac409.pocgitintellij.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
