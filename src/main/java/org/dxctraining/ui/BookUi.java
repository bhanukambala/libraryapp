package org.dxctraining.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;

import org.dxctraining.book.exceptions.*;
import org.dxctraining.book.entities.*;
import org.dxctraining.book.service.*;
import org.dxctraining.*;
import org.dxctraining.author.entities.Author;
import org.dxctraining.author.exceptions.AuthorNotFoundException;
import org.dxctraining.author.service.IAuthorService;

@Component
public class BookUi {
	@Autowired
	private IBookService bookservice;
	@Autowired
	private IAuthorService authorservice;
		
	@PostConstruct
	public void runApp() {
		try {
			Author a1= new Author("h1","stephen king");
			Author a2= new Author("h2","toni");
			authorservice.saveAuthor(a1);
			authorservice.saveAuthor(a2);
			Book b1=new Book(73);
			Book b2=new Book(724);
			ItBook book1=new ItBook("bk1 ","misery ",a1,1500,b1, "english",1.0);
			bookservice.add(book1);
			FictionBook book2=new FictionBook("bk2 ","Beloved ",a2,2000,b2, "bhanu");
			bookservice.add(book2);
			displayAll();
			}
		 catch (InvalidArgumentException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			catch (AuthorNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.println("some thing went wrong");
			}

			
		}
		private void displayAll() {
			List<Book> list=bookservice.findAll();
			for(Book book:list) {
				display(book);
			}
			
		}
		public void display(Book book) {
			
			System.out.println("Id is "+book.getId()+" book name "+book.getName()+" book number "+book.getBooknum()+"and cost is"+book.getCost());
			Author author=book.getAuthor();
			System.out.println("Author id "+author.getId()+" and name "+author.getName());
			
			if(book instanceof FictionBook) {
				FictionBook fiction=(FictionBook) book;
				System.out.println("character name is "+fiction.getCharactername());
			}
			if(book instanceof ItBook) {
				ItBook it=(ItBook) book;
				System.out.println("language is "+it.getLanguage()+" and version is "+it.getVersion());
			}
		}
	}
		