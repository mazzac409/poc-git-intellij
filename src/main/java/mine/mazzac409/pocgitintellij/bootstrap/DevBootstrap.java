package mine.mazzac409.pocgitintellij.bootstrap;

import mine.mazzac409.pocgitintellij.model.Author;
import mine.mazzac409.pocgitintellij.model.Book;
import mine.mazzac409.pocgitintellij.model.Publisher;
import mine.mazzac409.pocgitintellij.repositories.AuthorRepository;
import mine.mazzac409.pocgitintellij.repositories.BookRepository;
import mine.mazzac409.pocgitintellij.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Joe
        Author joe = new Author("Joe","Hubeny");
        Publisher hc = new Publisher("Harper Collins", "123 Main St", "Suite 100", "Chicago", "IL", "60606", "usa");
        publisherRepository.save(hc);

        Book ddd = new Book("Accounting 101", "1234", hc);
        joe.getBooks().add(ddd);
        ddd.getAuthors().add(joe);

        authorRepository.save(joe);
        bookRepository.save(ddd);


        //Jimmy
        Author jim = new Author("Jim", "Hubeny");
        Publisher wx = new Publisher("Wrox", "6999 Beachmont Dr", "", "Sykesville", "MD", "21784", "usa");
        publisherRepository.save(wx);
        Book fleet = new Book("Fleet Car Mgmt", "2345", wx);
        jim.getBooks().add(fleet);

        authorRepository.save(jim);
        bookRepository.save(fleet);
    }
}
