package mine.mazzac409.pocgitintellij.repositories;

import mine.mazzac409.pocgitintellij.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
