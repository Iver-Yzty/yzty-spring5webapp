package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publisher");
        publisher.setCity("St Peterburg");
        publisher.setState("Fl");

        publisherRepository.save(publisher);

        Author albert = new Author("Albert", "Strang");
        Book lg = new Book("Linear Gebra", "123456");

        albert.getBooks().add(lg);
        lg.getAuthors().add(albert);

        lg.setPublisher(publisher);
        publisher.getBooks().add(lg);

        authorRepository.save(albert);
        bookRepository.save(lg);
        publisherRepository.save(publisher);

        Author  craig= new Author("Craig", "Walls");
        Book sia = new Book("Spring in action", "123456");

        albert.getBooks().add(sia);
        sia.getAuthors().add(craig);

        sia.setPublisher(publisher);
        publisher.getBooks().add(sia);

        authorRepository.save(craig);
        bookRepository.save(sia);
        publisherRepository.save(publisher);

        System.out.println("books nums" + bookRepository.count());
        System.out.println(publisher.getBooks().size());

    }
}
