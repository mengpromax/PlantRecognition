package com.vegetablechicken.plantrecognition.service;

import com.vegetablechicken.plantrecognition.Method.Method;
import com.vegetablechicken.plantrecognition.entity.Comment;
import com.vegetablechicken.plantrecognition.entity.Thought;
import com.vegetablechicken.plantrecognition.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {
    @Resource
    private CommentRepository commentRepository;

    public String insertComment(long tid, String email, String content) {
        Comment comment = Comment.builder().tid(tid).email(email).content(content).build();
        commentRepository.save(comment);
        return "success";
    }

    public List<Comment> getComments(long tid) {
        return commentRepository.findByTidOrderByCid(tid);
    }
}
