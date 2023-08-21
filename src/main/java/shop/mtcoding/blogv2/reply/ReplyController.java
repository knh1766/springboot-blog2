package shop.mtcoding.blogv2.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.mtcoding.blogv2._core.util.Script;

@Controller
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    //댓글쓰기
    @PostMapping("/reply/save")
    public String save(ReplyRequest.SaveDTO saveDTO) {
        replyService.댓글쓰기(saveDTO, 1);
        return "redirect:/board/" + saveDTO.getBoardId();

    }

    //삭제하기
     @PostMapping("/reply/{id}/delete")
    public String delete(@PathVariable Integer id,Integer boardId) {
        replyService.삭제하기(id);
        return "redirect:/board/"+boardId ;
    }

}
