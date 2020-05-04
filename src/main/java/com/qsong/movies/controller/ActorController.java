package com.qsong.movies.controller;

import com.qsong.movies.controller.dto.ActorDTO;
import com.qsong.movies.domain.Actor;
import com.qsong.movies.repository.ActorRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    Logger logger = LoggerFactory.getLogger(ActorController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Actor addActor(ActorDTO actorDTO) {
        logger.info("[**]Get POST request.");
        String actorName = actorDTO.getName();
        int actorSex = actorDTO.getSex();
        String actorBorn = actorDTO.getBorn();
        logger.info("[**] - reqeust form-data: name=" + actorName + ", sex=" + actorSex + ", born=" + actorBorn);

        Actor actor = new Actor();
        actor.setName(actorName);
        actor.setSex(actorSex);
        actor.setBorn(new Date(actorBorn));
        actorRepository.save(actor);

        logger.info("[**] Add new actor success");

        return actor;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Actor getActorById(@PathVariable Long id) {
        logger.info("[**] Get GET request.");
        logger.info("[**]  - request params id=" + id);
        Optional<Actor> result = actorRepository.findById(id);
        Actor actor = result.get();

        logger.info("[**] actor id=" + actor.getId() + ", name=" + actor.getName() + ", sex=" + actor.getSex() + ", born=" + actor.getBorn().toString());

        return actor;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateActorById(@PathVariable Long id, ActorDTO actorDTO) {
        logger.info("[**] Get PUT request.");
        logger.info("[**]  - request params id=" + id);
        String actorName = actorDTO.getName();
        int actorSex = actorDTO.getSex();
        String actorBorn = actorDTO.getBorn();
        logger.info("[**] - reqeust form-data: name=" + actorName + ", sex=" + actorSex + ", born=" + actorBorn);

        Optional<Actor> result = actorRepository.findById(id);
        Actor actor = result.get();
        logger.info("[**] actor id=" + actor.getId() + ", name=" + actor.getName() + ", sex=" + actor.getSex() + ", born=" + actor.getBorn().toString());

        actor.setName(actorName);
        actor.setSex(actorSex);
        actor.setBorn(new Date(actorBorn));

        actorRepository.save(actor);

        return "HHHC";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteActorById(@PathVariable Long id) {
        logger.info("[**] Get DELETE request.");
        logger.info("[**]  - request params id=" + id);

        Optional<Actor> result = actorRepository.findById(id);
        Actor actor = result.get();
        logger.info("[**] actor id=" + actor.getId() + ", name=" + actor.getName() + ", sex=" + actor.getSex() + ", born=" + actor.getBorn().toString());

        actorRepository.delete(actor);
        logger.info("[**]  - Delete actor success");

        return "hahahb";
    }
}
