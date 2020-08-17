package org.dxctraining.author.service;

import org.dxctraining.author.entities.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.dxctraining.author.dao.IAuthorDao;
import org.dxctraining.author.exceptions.*;

@Transactional
@Service
public class AuthorServiceImpl implements IAuthorService{

	@Autowired
	private IAuthorDao dao;
	@Override
	public Author findAuthorById(String id) {
		Author author=dao.findAuthorById(id);
		return author;
	}

	@Override
	public Author updateAuthor(Author author) {
		display(author);
		author=dao.updateAuthor(author);
		return author;
	}

	private void display(Author author) {
		 if(author==null){
	            throw new InvalidArgumentException("argument is null");
	        }
	    }
	@Override
	public Author saveAuthor(Author author) {
		display(author);
		author=dao.saveAuthor(author);
		return author;
	}

	@Override
	public void remove(String id) {
		dao.remove(id);		
	}

}
