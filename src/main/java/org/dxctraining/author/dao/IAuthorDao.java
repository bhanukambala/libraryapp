package org.dxctraining.author.dao;

import org.dxctraining.author.entities.Author;
import org.dxctraining.book.entities.Book;

public interface IAuthorDao {
	 Author findAuthorById(String id);

	    Author updateAuthor(Author author);

	    Author saveAuthor(Author autor);

	    void remove(String id);

}
