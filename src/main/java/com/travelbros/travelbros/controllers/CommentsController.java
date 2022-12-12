package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.Comments;
import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.repositories.CommentsRepository;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    // Dependency Injection
    private final TripRepository tripDao;
    private final CommentsRepository commentsDao;
    private final UserRepository usersDao;

    // Constructor
    public CommentsController(CommentsRepository commentsDao, UserRepository usersDao, TripRepository tripDao) {
        this.commentsDao = commentsDao;
        this.usersDao = usersDao;
        this.tripDao = tripDao;
    }

    // Get method to send user to comment.html view with Comment and Post objects as attributes on model
    @GetMapping("/{id}/create")
    public String showCommentForm(@PathVariable long id, Model model) {
        Trip trip = tripDao.findById(id);
        model.addAttribute("trip", trip);
        model.addAttribute("comment", new Comments());
        return "trips/comment";
    }

    // Post method to save comment to database
    @PostMapping("/{id}/create")
    public String addComment(@ModelAttribute Comments comment, @PathVariable long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long UserId = user.getId();
        user = usersDao.findById(UserId);
        Trip trip = tripDao.findById(id);
        Comments newComment = new Comments(comment.getBody(), user, trip);
        commentsDao.save(newComment);
        return "redirect:/trips";
    }

}
