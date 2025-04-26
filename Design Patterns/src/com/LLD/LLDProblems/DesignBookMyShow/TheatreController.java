//package com.LLD.Example.DesignBookMyShow;
//import com.LLD.Example.DesignBookMyShow.Enums.City;
//
//import java.util.*;
//public class TheatreController {
//    Map<City, List<Theatre>> cityVsThreatre;
//    List<Theatre> allThreatre;
//
//    TheatreController(){
//        cityVsThreatre = new HashMap<>();
//        allThreatre = new ArrayList<>();
//    }
//
//    void addTheatre(Theatre theatre, City city){
//        allThreatre.add(theatre);
//
//        List<Theatre>theatres = cityVsThreatre.getOrDefault(city,new ArrayList<>());
//        theatres.add(theatre);
//        cityVsThreatre.put(city,theatres);
//    }
//
//    Map<Theatre, List<Show>> getAllShow(Movie movie, City city){
//        // get all the theater of this city
//        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
//        List<Theatre> theatres = cityVsThreatre.getOrDefault(city);
//        // filter the theatres which run this movie
//        for(Theatre theatre : theatres) {
//            List<Show> givenMovieShows = new ArrayList<>();
//            List<Show> shows = theatre.getShows();
//            for(Show show : shows) {
//                if(show.movie.getMovieId() == movie.getMovieId()) {
//                    givenMovieShows.add(show);
//                }
//            }
//            if(!givenMovieShows.isEmpty()) {
//                theatreVsShows.put(theatre, givenMovieShows);
//            }
//        }
//        return theatreVsShows;
//
//    }
//
//}
