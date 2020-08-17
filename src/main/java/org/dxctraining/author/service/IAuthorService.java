package org.dxctraining.author.service;

import org.dxctraining.author.entities.Author;

public interface IAuthorService {
	Author findAuthorById(String id);

    Author updateAuthor(Author author);

    Author saveAuthor(Author autor);

    void remove(String id);

}
