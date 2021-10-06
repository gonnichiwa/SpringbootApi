package kr.ac.daegu.springbootapi.comment.model;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO {

    int postComment(CommentDTO commentDTO);
}
