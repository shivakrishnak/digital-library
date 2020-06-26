package com.shiva.book;

import com.shiva.book.model.Author;
import com.shiva.book.model.Book;
import com.shiva.book.model.Category;
import com.shiva.book.service.BookRepository;
import com.shiva.book.util.BookUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication {

	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Bean
	public LinkDiscoverers discoverers(){
		return new LinkDiscoverers(SimplePluginRegistry.create(Arrays.asList(new CollectionJsonLinkDiscoverer())));
	}

/*	@Override
	public void run(String... args) throws Exception {
		List<Author> auth = new ArrayList<>(Arrays.asList(new Author(1l,"Joshua","Bloch")));
		bookRepository.save(new Book(1l,"Effective Java", auth,"2019", BookUtil.getUUID(), new Category(1l,"IT")));
		*//*bookRepository.save(new Book(2l,"Design Patterns", new ArrayList<>(Arrays.asList(new Author("Ralph","Johnson"),new Author("Erich","Gamma"),new Author("Richard","Helm"),new Author("John","Vlissides"))),"2002", BookUtil.getUUID(), new Category("IT")));
		bookRepository.save(new Book(3l,"The Theory of Everything", new ArrayList<>(Arrays.asList(new Author("Stephen","Hawking"))),"2005", BookUtil.getUUID(), new Category("Science")));
		bookRepository.save(new Book(4l,"To Kill a Mockingbird", new ArrayList<>(Arrays.asList(new Author("Harper","Lee"))),"1991", BookUtil.getUUID(), new Category("Fiction")));*//*
	}*/
}
