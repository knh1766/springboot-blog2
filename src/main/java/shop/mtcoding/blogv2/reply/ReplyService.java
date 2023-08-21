package shop.mtcoding.blogv2.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blogv2.board.Board;
import shop.mtcoding.blogv2.board.BoardRequest;
import shop.mtcoding.blogv2.reply.ReplyRequest.SaveDTO;
import shop.mtcoding.blogv2.user.User;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

     @Transactional
    public void 댓글쓰기(ReplyRequest.SaveDTO saveDTO, int sessionUserId) {
        Reply reply = Reply.builder()
                .board(Board.builder().id(saveDTO.getBoardId()).build())
                .comment(saveDTO.getComment())
                .user(User.builder().id(sessionUserId).build())
                .build();

       replyRepository.save(reply);
    }

    @Transactional
    public void 삭제하기(Integer id) {
        try {
            replyRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(id+"를 찾을 수 없어요");
        }
    }
}
