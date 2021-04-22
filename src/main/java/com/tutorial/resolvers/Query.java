package com.tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.tutorial.entities.Author;
import com.tutorial.entities.Tutorial;
import com.tutorial.repositories.AuthorRepository;
import com.tutorial.repositories.TutorialRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final AuthorRepository authorRepository;
    private final TutorialRepository tutorialRepository;

    public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
        this.authorRepository = authorRepository;
        this.tutorialRepository = tutorialRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public long countTutorials() {
        return tutorialRepository.count();
    }

}
