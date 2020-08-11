package org.dxctraining.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;

import org.dxctraining.exceptions.*;
import org.dxctraining.entities.*;
import org.dxctraining.service.*;
import org.dxctraining.*;

@Component
public class BookMain {
	@Autowired
	private IBookService service=new BookServiceImpl();
	public static void main(String[] args) {
		BookMain demo = new BookMain();
		demo.runApp();
	}
	@PostConstruct
	public void runApp() {
		try {
			Author a1= new Author("h1","stephen king");
			Author a2= new Author("h2","toni");
			Book b1=new Book(73);
			Book b2=new Book(724);
			ItBook book1=new ItBook("bk1 ","misery ",a1,1500,b1, "english",1.0);
			service.add(book1);
			FictionBook book2=new FictionBook("bk2 ","Beloved ",a2,2000,b2, "bhanu");
			service.add(book2);
			displayAll();
			}
		 catch (InvalidArgumentException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			catch (BookNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			catch (Exception e) {
				e.printStackTrace();
				System.out.println("some thing went wrong");
			}

			
		}
		private void displayAll() {
			List<Book> list=service.findAll();
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
		