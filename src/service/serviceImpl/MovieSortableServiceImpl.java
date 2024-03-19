package service.serviceImpl;
import models.DataBaseMovie;
import models.Movie;
import models.Producer;
import service.MovieSortableService;

import java.util.Collections;
import java.util.Comparator;
public class MovieSortableServiceImpl implements MovieSortableService {

    @Override
    public void sortMovieByName(String ascOrDesc) {
        try {
            switch (ascOrDesc){
                case "1":{
                    Collections.sort(DataBaseMovie.movies, Comparator.comparing(Movie::getName));
                    System.out.println(DataBaseMovie.movies);
                    break;
                }
                case "2":{
                    Collections.sort(DataBaseMovie.movies, Comparator.comparing(Movie::getName).reversed());
                    System.out.println(DataBaseMovie.movies);
                    break;
                }
                default:{
                    System.out.println("Такой опции нет!");
                }
            }
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void sortByYear(String ascOrDesc) {
        try {
            switch (ascOrDesc){
                case "1":{
                    Collections.sort(DataBaseMovie.movies, Comparator.comparing(Movie::getYear));
                    System.out.println(DataBaseMovie.movies);
                    break;
                }
                case "2":{
                    Collections.sort(DataBaseMovie.movies, Comparator.comparing(Movie::getName).reversed());
                    System.out.println(DataBaseMovie.movies);
                    break;
                }
                default:{
                    System.out.println("Такой опции нет!");
                }
            }
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        Comparator<Movie> compareByProducer = Comparator.comparing(movie -> {
            Producer producer = movie.getProducer();
            return nameOrLastName.equalsIgnoreCase("lastName") ? producer.getLastName() : producer.getFirstName();
        });
        DataBaseMovie.movies.sort(compareByProducer);
    }

    }

