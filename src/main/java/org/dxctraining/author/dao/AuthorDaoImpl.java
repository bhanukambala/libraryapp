package org.dxctraining.author.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import org.dxctraining.author.entities.Author;
import org.dxctraining.author.exceptions.AuthorNotFoundException;

@Repository
public class AuthorDaoImpl implements IAuthorDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Author findAuthorById(String id) {
		Author author = entityManager.find(Author.class, id);
		if (author == null) {
			throw new AuthorNotFoundException("Author not found for id=" + id);
		}
		return author;
	}

	@Override
	public Author updateAuthor(Author author) {
		author = entityManager.merge(author);
		return author;
	}

	@Override
	public Author saveAuthor(Author author) {
		entityManager.persist(author);
		return author;

	}

	@Override
	public void remove(String id) {
		Author author = findAuthorById(id);
		entityManager.remove(author);

	}

}
