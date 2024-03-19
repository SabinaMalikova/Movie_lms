package service.serviceImpl;

import models.Actor;
import models.DataBaseMovie;
import models.Movie;
import enums.Genre;
import service.MovieFindableService;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

public class MovieFindableServiceImpl  implements MovieFindableService  {

    @Override
    public List<Movie> getAllMovies() {
        return DataBaseMovie.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        try {
            for (Movie movie : DataBaseMovie.movies){
                if (movie.getName().equalsIgnoreCase(name)){
                    return movie;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println(" Не найдено! ");

        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        try {
            for (Movie movie : DataBaseMovie.movies) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getActorFullName().contains(actorName)) {
                        return movie;
                    }
                }
            }
        }catch (NoSuchElementException e){
            System.out.println(" Не найдено! ");
        }

        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        try {
            for (Movie movie : DataBaseMovie.movies) {
                if (movie.getYear().equals(year)) {
                    return movie;
                }
            }
        }catch (NoSuchElementException e) {
            System.out.println(" Не найдено! ");
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerName) {
        try {
            for (Movie movie : DataBaseMovie.movies) {
                if (movie.getProducer().getFirstName().equals(producerName)) {
                    return movie;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println(" Не найдено! ");
        }
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        try {
            for (Movie movie : DataBaseMovie.movies) {
                if (movie.getGenre().equals(genre)) {
                    return movie;
                }
            }
        }catch (NoSuchElementException e){
            System.out.println(" Не найдено! ");
        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        try {
            for (Movie movie : DataBaseMovie.movies) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getRole().contains(role)) {
                        return movie;
                    }
                }
            }
        }catch (NoSuchElementException e){
            System.out.println(" Не найдено! ");
        }
        return null;
    }
}
