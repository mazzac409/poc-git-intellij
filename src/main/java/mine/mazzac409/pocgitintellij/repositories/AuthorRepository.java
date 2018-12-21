package mine.mazzac409.pocgitintellij.repositories;

import mine.mazzac409.pocgitintellij.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
