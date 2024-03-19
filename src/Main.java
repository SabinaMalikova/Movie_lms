import models.Actor;
import models.DataBaseMovie;
import models.Movie;
import models.Producer;
import enums.Genre;
import service.serviceImpl.MovieFindableServiceImpl;
import service.serviceImpl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerStr = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        MovieSortableServiceImpl movieSortableService = new MovieSortableServiceImpl();
        MovieFindableServiceImpl movieFindableService = new MovieFindableServiceImpl();

        List<Actor> actorsCruella = Arrays.asList(
                new Actor("Эмма Стоун", "Круэлла"),
                new Actor("Эмма Тампсон", "Баронесса"),
                new Actor("Эмили Бичем", "Кэтрин"),
                new Actor("Джэйми Дтмитриу", "Джэральд"),
                new Actor("Пол Уолтер Хаузер", "Хорейс"));

        List<Actor> actorsPrada = Arrays.asList(
                new Actor("Мерил Стрип", "Миранда"),
                new Actor("Энн Хэтэуэй", "Андреа"),
                new Actor("Стэнли Туччи", "Найджэл"),
                new Actor("Эдриан Гренье", "Нейт"),
                new Actor("Жизель Бюндхен", "Серена"));

        List<Actor> actorsTitanic = Arrays.asList(
                new Actor("Кейт Уинслет", "Роза Дьюит"),
                new Actor("Леонардо Ди Каприо", "Джек Доусон"),
                new Actor("Билли Зейн", "Каледон Хокли"),
                new Actor("Кэти Бейтс", "Молли Браун"),
                new Actor("Бернард Хилл", "Капитан Смит"));

        List<Actor> actorsIdentification = Arrays.asList(
                new Actor("Джон Кьюсак", "Эд Дакота"),
                new Actor("Рэй Лиотта", "Родс Невада"),
                new Actor("Аманда Питт", "Перис Невада"),
                new Actor("Ребекка Дэ Морнэй", "Каролайн"),
                new Actor("Альфред Молина", "Психиатр Малик"));


        Producer producerCruella = new Producer("Гленн", "Клоуз");
        Producer producerPrada = new Producer("Дэвид", "Френкель");
        Producer producerTitanic = new Producer("Джэймс", "Кэмерон");
        Producer producerIdentification = new Producer("Стюарт", "Бессер");


        List<Movie> movies = Arrays.asList(
                new Movie("Круэлла", LocalDate.of(2021, 5, 25), Genre.КОМЕДИЯ, producerCruella, actorsCruella),
                new Movie("Дьявол носит Прада", LocalDate.of(2006, 6, 30), Genre.ДРАМА, producerPrada, actorsPrada),
                new Movie("Титаник", LocalDate.of(1997, 12, 19), Genre.ДРАМА, producerTitanic, actorsTitanic),
                new Movie("Идентификация", LocalDate.of(2003, 4, 25), Genre.ДЕТЕКТИВ, producerIdentification, actorsIdentification));
        DataBaseMovie.movies.addAll(movies);


        while (true) {
            try {
                System.out.println("           Возможные действия: \n" +
                        "1.  Посмотреть предоставленные фильмы. \n" +
                        "2.  Найти фильм по названию. \n" +
                        "3.  Найти фильм по имени актера.\n" +
                        "4.  Найти фильм по дате выхода фильма.\n" +
                        "5.  Найти фильм по имени продюсера.\n" +
                        "6.  Найти фильм по жанру.\n" +
                        "7.  Найти фильм по роли.\n" +
                        "            Сортировка: \n" +
                        "8.  Сортировка фильмов: Алфавит\n" +
                        "9.  Сортировка фильмов: Дате релиза .\n" +
                        "10. Сортировка фильмов: \n" +
                        "11. Выйти. \n" +
                        "            Введите свой выбор: ");
                switch (scannerNum.nextInt()) {
                    case 1: {
                        System.out.println("            Фильмы: ");
                        System.out.println(DataBaseMovie.movies);
                        break;
                    }
                    case 2: {
                        System.out.println("Введите название фильма: ");
                        String movieName = scannerStr.nextLine();
                        System.out.println(movieFindableService.findMovieByFullNameOrPartName(movieName));
                        break;
                    }
                    case 3: {
                        System.out.println("Введите имя актера: ");
                        String actorName = scannerStr.nextLine();
                        System.out.println(movieFindableService.findMovieByActorName(actorName));
                        break;
                    }
                    case 4: {
                        System.out.println("Введите дату релиза фильма: ");
                        System.out.println(movieFindableService.findMovieByYear(LocalDate.of(scannerNum.nextInt(), scannerNum.nextInt(), scannerNum.nextInt())));
                        break;
                    }
                    case 5: {
                        System.out.println("Введите имя продюсера:");
                        String produceName = scannerStr.nextLine();
                        System.out.println(movieFindableService.findMovieByProducer(produceName));
                        break;
                    }
                    case 6: {
                        System.out.println("Введите жанр: Драма, Комедия, Детектив ");
                        Genre genre = Genre.valueOf(scannerStr.nextLine());
                        System.out.println(movieFindableService.findMovieByGenre(genre));
                        break;
                    }
                    case 7: {
                        System.out.println("Введите роль: ");
                        String roleName = scannerStr.nextLine();
                        System.out.println(movieFindableService.findMovieByRole(roleName));
                        break;
                    }
                    case 8: {
                        System.out.println("Выберите:\n" +
                                "1) в алфавитном порядке\n" +
                                "2) в алфавитном порядке наборот ");
                        String choice = scannerStr.nextLine();
                        movieSortableService.sortMovieByName(choice);
                        break;
                    }
                    case 9: {
                        System.out.println("Выберите \n" +
                                "1) Старые \n" +
                                "2) Новые ");
                        String choice = scannerStr.nextLine();
                        movieSortableService.sortByYear(choice);
                        break;
                    }
                    case 10: {
                        System.out.println("Sort by name or last name? (firstname/lastname)");
                        movieSortableService.sortByProducer(scannerStr.nextLine());
                        break;
                    }

                    case 11: {
                        System.out.println("Хорошего вам дня! ");
                        return;
                    }
                    default: {
                        System.err.println("Такой опции нет.");
                    }
                }
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
