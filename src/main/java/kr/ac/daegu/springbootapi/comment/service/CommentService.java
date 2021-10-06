package kr.ac.daegu.springbootapi.comment.service;

import kr.ac.daegu.springbootapi.board.model.BoardDAO;
import kr.ac.daegu.springbootapi.comment.model.CommentDAO;
import kr.ac.daegu.springbootapi.comment.model.CommentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CommentService {

    public final CommentDAO commentDAO;

    public CommentDTO postComment(CommentDTO commentDTO) throws Exception {
        int insertedRowCount = commentDAO.postComment(commentDTO);
        if(insertedRowCount > 0) {
            return commentDTO;
        }
        throw new Exception("failed to insert board data");
    }
}
