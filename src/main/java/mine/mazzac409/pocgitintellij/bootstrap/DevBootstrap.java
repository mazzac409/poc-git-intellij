package mine.mazzac409.pocgitintellij.bootstrap;

import mine.mazzac409.pocgitintellij.model.Author;
import mine.mazzac409.pocgitintellij.model.Book;
import mine.mazzac409.pocgitintellij.repositories.AuthorRepository;
import mine.mazzac409.pocgitintellij.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Joe
        Author joe = new Author("Joe","Hubeny");
        Book ddd = new Book("Accounting 101", "1234", "Harper Collins");
        joe.getBooks().add(ddd);
        ddd.getAuthors().add(joe);

        authorRepository.save(joe);
        bookRepository.save(ddd);


        //Jimmy
        Author jim = new Author("Jim", "Hubeny");
        Book fleet = new Book("Fleet Car Mgmt", "2345", "Wrox");
        jim.getBooks().add(fleet);

        authorRepository.save(jim);
        bookRepository.save(fleet);
    }
}
