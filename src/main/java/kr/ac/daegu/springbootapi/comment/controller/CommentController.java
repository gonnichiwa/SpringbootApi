package kr.ac.daegu.springbootapi.comment.controller;

import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.board.service.BoardService;
import kr.ac.daegu.springbootapi.comment.model.CommentDTO;
import kr.ac.daegu.springbootapi.comment.service.CommentService;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/comment")
public class CommentController {

    public final CommentService commentService;

    @PostMapping(value = "/")
    public ApiResponse<BoardDTO> postComment(@RequestBody CommentDTO commentDTO) throws Exception {
        CommentDTO dto = commentService.postComment(commentDTO);
        String successMessage = "success to insert board Id " + commentDTO.getId();
        return new ApiResponse(true, successMessage, dto);
    }

}
