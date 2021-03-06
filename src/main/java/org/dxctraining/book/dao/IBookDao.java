package org.dxctraining.book.dao;

import java.util.List;

import org.dxctraining.book.entities.Book;

public interface IBookDao {

	Book findById(String id);
	List<Book> findAll();
	Book updateCost(String id,double cost);
	void add(Book book);
	Book update(Book book);
	void delete(String id);
}