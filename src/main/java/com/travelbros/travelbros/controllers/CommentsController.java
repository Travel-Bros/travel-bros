package com.travelbros.travelbros.controllers;

import com.travelbros.travelbros.models.Comments;
import com.travelbros.travelbros.models.Trip;
import com.travelbros.travelbros.models.User;
import com.travelbros.travelbros.models.Vehicle;
import com.travelbros.travelbros.repositories.CommentsRepository;
import com.travelbros.travelbros.repositories.TripRepository;
import com.travelbros.travelbros.repositories.UserRepository;
import com.travelbros.travelbros.utils.Utils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;

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
    public String showCommentForm(Model model, @PathVariable long id) {
        Trip trip = tripDao.findById(id);

        model.addAttribute("trip", trip);
        model.addAttribute("comment", new Comments());

        String[] endPointParser = trip.getEndPoint().split(",", 0);
        String betterEndPoint = endPointParser[0];
        model.addAttribute("endPoint", betterEndPoint);
        return "user_profile/comments";
    }

    // Post method to save comment to database
    @PostMapping("/{id}/create")
    public String addComment(@ModelAttribute Comments comments, @PathVariable long id) {
        User user = usersDao.findById(Utils.currentUserId());
        Trip trip = tripDao.findById(id);
        Comments newComments = new Comments(comments.getBody(), user, trip);
        commentsDao.save(newComments);
        return "redirect:/profile";
    }

//    @GetMapping("/{id}/edit")
//    public String showEditCommentForm(@PathVariable long id, Model model) {
//        User user = usersDao.findById(Utils.currentUserId());
//        Comments comments = commentsDao.findById(id);
//        // redirects back to all posts if user is not the owner of the post
//        if(!user.equals(comments.getUser())) {
//            return "redirect:/profile";
//        }
//        model.addAttribute("comments", comments);
//        return "user_profile/comments";
//    }
//
//    @PostMapping("/{id}/edit")
//    public String editComment(@ModelAttribute Comments comment, @PathVariable long id) {
//        User user = usersDao.findById(Utils.currentUserId());
//        Comments currentComment = commentsDao.findById(id);
//        // Only edits post if correct user sending post request
//        if(user.equals(currentComment.getUser())){
//            comment.setUser(user);
//            commentsDao.save(comment);
//        }
//        comment.setUser(user);
//        commentsDao.save(comment);
//        return "redirect:/profile";
//    }

// Get method to delete comment from database
    @GetMapping("/{id}/delete")
    public String deleteTrip(@PathVariable long id) {
        User user = usersDao.findById(Utils.currentUserId());
        Comments comments = commentsDao.findById(id);
        // Only deletes post if correct user sending post request
        if (user.getId() == comments.getUser().getId()) {
            commentsDao.deleteById(comments.getId());
        }
        return "redirect:/profile";
    }

}
