package kr.ac.daegu.springbootapi.board.service;

import kr.ac.daegu.springbootapi.board.model.BoardDAO;
import kr.ac.daegu.springbootapi.board.model.BoardDTO;
import kr.ac.daegu.springbootapi.comment.model.CommentDAO;
import kr.ac.daegu.springbootapi.comment.model.CommentDTO;
import kr.ac.daegu.springbootapi.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BoardService {

    public final BoardDAO boardDAO;
    public final CommentDAO commentDAO;

    public List<BoardDTO> getBoardList() {
        return boardDAO.getBoardList();
    }

    public BoardDTO postBoard(BoardDTO boardDTO) throws Exception {
        log.debug(boardDTO.toString());

        // Inserted Date, Inserted Time 정의
        boardDTO.setWriteDate(LocalDate.now());
        boardDTO.setWriteTime(LocalTime.now());

        int insertedRowCount = boardDAO.postBoard(boardDTO);
        if(insertedRowCount > 0){
            return boardDTO;
        } else {
            throw new Exception("failed to insert board data");
        }
    }

    public String putBoard(int id, BoardDTO boardDTO) throws Exception {
        boardDTO.setId(id);
        boardDTO.setWriteDate(LocalDate.now());
        boardDTO.setWriteTime(LocalTime.now());
        int result = boardDAO.putBoard(boardDTO);

        if(result > 0){
            return result + " rows updated";
        }
        throw new Exception("failed to update " + id + " content");
    }

    public ApiResponse<BoardDTO> getBoardById(int boardId) {
        BoardDTO data = boardDAO.getBoardById(boardId);
        if(isDeletedData(data)){
            return new ApiResponse(false, "boardId " + boardId + " is already deleted");
        }
        List<CommentDTO> commentsById = commentDAO.getCommentsByBoardId(boardId);
        data.setComments(commentsById);
        return new ApiResponse(true, data);
    }

    private boolean isDeletedData(BoardDTO data) {
        return data.getIsDel().equals("Y");
    }

    // Board테이블의 isDel 컬럼의 데이터를 'Y' 로 업데이트
    public ApiResponse<BoardDTO> updateIsDelBoardById(int id) {
        int updatedRow = boardDAO.updateIsDelBoardById(id);
        if(updatedRow > 0) {
            return new ApiResponse(true, "board id " + id + " is successfully deleted");
        }
        return new ApiResponse(false, "failed to delete board id " + id);
    }
}
