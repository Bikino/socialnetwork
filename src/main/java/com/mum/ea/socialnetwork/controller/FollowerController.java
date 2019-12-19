package com.mum.ea.socialnetwork.controller;

import com.mum.ea.socialnetwork.controller.util.OperationMessage;
import com.mum.ea.socialnetwork.domain.Person;
import com.mum.ea.socialnetwork.service.FollowerService;
import com.mum.ea.socialnetwork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class FollowerController {

    private FollowerService followerService;
    private PersonService personService;

    @Autowired
    public FollowerController(FollowerService followerService, PersonService personService) {
        this.followerService = followerService;
        this.personService = personService;
    }

    @PostMapping(value = "/follow/{followerId}/{followeeId}")
    public @ResponseBody OperationMessage follow(@PathVariable Long followerId, @PathVariable Long followeeId) {
        followerService.follow(followerId, followeeId);
        OperationMessage message = new OperationMessage();
        message.setMessage("Successful");
        return message;
    }

    @GetMapping(value = "/follow-suggestions/{id}")
    public @ResponseBody List<Person> followSuggestions(@PathVariable Long id) {
        List<Long> followingsId = followerService.findAllByFollowerIdEquals(id);
        followingsId.add(id);
        return personService.findAllByIdNotIn(followingsId);
    }

    @GetMapping(value = "/followers/{id}")
    public @ResponseBody List<Person> followers(@PathVariable Long id) {
        List<Long> followersId = followerService.findAllByFolloweeIdEquals(id);
        return personService.findAllByIdIn(followersId);
    }

    @GetMapping(value = "/followings/{id}")
    public @ResponseBody List<Person> followings(@PathVariable Long id) {
        List<Long> followingsId = followerService.findAllByFollowerIdEquals(id);
        return personService.findAllByIdIn(followingsId);
    }
}
