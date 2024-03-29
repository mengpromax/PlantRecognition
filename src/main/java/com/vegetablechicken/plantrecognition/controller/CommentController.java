package com.vegetablechicken.plantrecognition.controller;

import com.vegetablechicken.plantrecognition.entity.Comment;
import com.vegetablechicken.plantrecognition.entity.Like;
import com.vegetablechicken.plantrecognition.entity.User;
import com.vegetablechicken.plantrecognition.repository.CommentRepository;
import com.vegetablechicken.plantrecognition.request.CommentRequest;
import com.vegetablechicken.plantrecognition.request.ThoughtRequest;
import com.vegetablechicken.plantrecognition.response.ReducePlantsResponse;
import com.vegetablechicken.plantrecognition.service.CommentService;
import com.vegetablechicken.plantrecognition.service.ThoughtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Api("评论")
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/insertComment")
    @ApiOperation(value = "发布评论", notes = "发布评论", tags = "Comment",httpMethod = "POST")
    public String insertComment(@RequestBody CommentRequest commentRequest){

        return commentService.insertComment(commentRequest.getTid(),commentRequest.getEmail(),commentRequest.getContent());
    }

    @GetMapping("/getComments")
    @ApiOperation(value = "获得评论", notes = "获得一个想法所有的评论", tags = "Comment",httpMethod = "GET")
    public List<Comment> getComments(@RequestParam long tid){
        return commentService.getComments(tid);
    }

}
