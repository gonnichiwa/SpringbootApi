package kr.ac.daegu.springbootapi.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@Getter
@Setter
public class BoardDTO {
    private int id;
    private String author;
    private String subject;
    private String content;
    private Date writeDate;
    private Time writeTime;
    private int readCount;
    private int commentCount;
    private String password;
    private int replyRootId;
    private int depth;
    private int orderNum;

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", writeDate=" + writeDate +
                ", writeTime=" + writeTime +
                ", readCount=" + readCount +
                ", commentCount=" + commentCount +
                ", password='" + password + '\'' +
                ", replyRootId=" + replyRootId +
                ", depth=" + depth +
                ", orderNum=" + orderNum +
                '}';
    }
}
