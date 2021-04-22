package com.tutorial.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.tutorial.entities.Author;
import com.tutorial.entities.Tutorial;
import com.tutorial.repositories.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

    private final AuthorRepository authorRepository;

    public TutorialResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Tutorial tutorial) {
        return authorRepository.findById(tutorial.getAuthorId()).orElseThrow(null);
    }
}
