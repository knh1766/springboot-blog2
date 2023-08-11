package shop.mtcoding.blogv2.board;

import lombok.Getter;
import lombok.Setter;

//내부클래스
public class BoardRequest {
    @Getter
    @Setter
   public static class SaveDTO{
    private String title;
    private String content;

   }


   public static void main(String[] args) {
    SaveDTO saveDTO = new BoardRequest.SaveDTO();
   }
    
}
