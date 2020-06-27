package com.shiva;

import com.shiva.model.Author;
import com.shiva.model.Book;
import com.shiva.model.Category;
import com.shiva.service.BookRepository;
import com.shiva.service.CategoryRepository;
import com.shiva.util.BookUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    public ApplicationStartupRunner(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public void run(String... args) throws Exception {
        log.info("Loading Categories");
        List<String> categories = Arrays.asList("100,Fiction", "101,Non-Fiction", "102, Software Development");
        categories.stream()
                .map(cat -> cat.split(","))
                .forEach(map -> categoryRepository.save(new Category(Long.parseLong(map[0]), map[1])));

		/*List<Author> auth = new ArrayList<>(Arrays.asList(new Author(1l,"Joshua","Bloch")));
		bookRepository.save(new Book(1l,"Effective Java", auth,"2019", BookUtil.getUUID(), new Category(1l,"IT")));
		bookRepository.save(new Book(2l,"Design Patterns", new ArrayList<>(Arrays.asList(new Author("Ralph","Johnson"),new Author("Erich","Gamma"),new Author("Richard","Helm"),new Author("John","Vlissides"))),"2002", BookUtil.getUUID(), new Category("IT")));
		bookRepository.save(new Book(3l,"The Theory of Everything", new ArrayList<>(Arrays.asList(new Author("Stephen","Hawking"))),"2005", BookUtil.getUUID(), new Category("Science")));
		bookRepository.save(new Book(4l,"To Kill a Mockingbird", new ArrayList<>(Arrays.asList(new Author("Harper","Lee"))),"1991", BookUtil.getUUID(), new Category("Fiction")));*/
	}
}
