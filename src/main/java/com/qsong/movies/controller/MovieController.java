package com.qsong.movies.controller;

import com.qsong.movies.controller.dto.MovieDTO;
import com.qsong.movies.repository.ActorRepository;
import com.qsong.movies.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private static Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ActorRepository actorRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getMovieById(@PathVariable Long id) {
        logger.info("[**]GET Request From /movie/" + id);
        return "Get Index Page";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateMovieById(@PathVariable Long id) {
        logger.info("[**]PUT Request From /movie/" + id);
        return "Get Index Page";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteMovieById(@PathVariable Long id) {
        logger.info("[**]DELETE Request From /movie/" + id);
        return "Get Index Page";
    }

    //只能处理 request.body json方式参数，form-data不能处理
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addMovie(@RequestBody MovieDTO movieDTO) {
        logger.info("[**] POST Request From /movie");
        String name = movieDTO.getName();
        String poster = movieDTO.getPoster();
        logger.info("[**] Get movie name = " + name + ", poster = " + poster);

        return "Post Index Page";
    }

}

