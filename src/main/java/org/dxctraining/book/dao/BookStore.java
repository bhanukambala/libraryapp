package org.dxctraining.book.dao;

import java.util.*;

import org.dxctraining.book.entities.Book;

public class BookStore {
	private static Map<String,Book> store=new HashMap<>();
	public static Map<String,Book> getStore(){
		return store;
	}
}