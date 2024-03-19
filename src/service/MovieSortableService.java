package service;

import models.Movie;

import java.util.Comparator;

public interface MovieSortableService {
    void sortMovieByName(String ascOrDesc);

//-from A to Z

//-from Z to A

    void sortByYear(String ascOrDesc);

//-Ascending

//-Descending

    void sortByProducer(String nameOrlastName);
}
