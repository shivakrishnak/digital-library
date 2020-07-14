package com.shiva.book;

import com.shiva.book.model.Author;
import com.shiva.book.model.Book;
import com.shiva.book.model.Category;
import com.shiva.book.repository.BookRepository;
import com.shiva.book.service.BookService;
import com.shiva.book.repository.CategoryRepository;
import com.shiva.book.util.BookUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Log4j2
@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private BookRepository bookRepository;
    private BookService bookService;
    private CategoryRepository categoryRepository;

    @Autowired
    public ApplicationStartupRunner(BookRepository bookRepository, BookService bookService, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
        this.categoryRepository = categoryRepository;
    }

    public void run(String... args) throws Exception {
       /* log.info("Loading Categories");
        List<String> categories = Arrays.asList("100,Fiction", "101,Non-Fiction", "102, Software Development");
        categories.stream()
                .map(cat -> cat.split(","))
                .forEach(map -> categoryRepository.save(new Category(Long.parseLong(map[0]), map[1])));*/

/*        BookDto book1 = new BookDto.Builder().name("Effective Java").year("2019").category(CategoryEnum.SoftwareDevelopment.getName()).isbn(BookUtil.getUUID()).authors(Arrays.asList(new Author(1l, "Joshua", "Bloch"))).build();
        bookService.add(book1);*/
		List<Author> auth = new ArrayList<Author>(Arrays.asList(new Author(1l,"Joshua","Bloch")));
//		bookRepository.save(new Book(1l,"Effective Java", new ArrayList<Author>(Arrays.asList(new Author("Joshua","Bloch"))),"2019", BookUtil.getUUID(), new Category(Long.valueOf(102),"Software Development")));
//		bookRepository.save(new Book(2l,"Design Patterns", new ArrayList<>(Arrays.asList(new Author("Ralph","Johnson"),new Author("Erich","Gamma"),new Author("Richard","Helm"),new Author("John","Vlissides"))),"2002", BookUtil.getUUID(), new Category(Long.valueOf(102),"Software Development")));
//		bookRepository.save(new Book(3l,"The Theory of Everything", new ArrayList<>(Arrays.asList(new Author("Stephen","Hawking"))),"2005", BookUtil.getUUID(), new Category(Long.valueOf(101),"Non-Fiction")));
//		bookRepository.save(new Book(4l,"To Kill a Mockingbird", new ArrayList<>(Arrays.asList(new Author("Harper","Lee"))),"1991", BookUtil.getUUID(), new Category(Long.valueOf(100),"Fiction")));
    }
}
