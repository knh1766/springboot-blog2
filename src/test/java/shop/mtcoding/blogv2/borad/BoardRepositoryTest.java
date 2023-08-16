package shop.mtcoding.blogv2.borad;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.blogv2.board.Board;
import shop.mtcoding.blogv2.board.BoardRepository;
import shop.mtcoding.blogv2.user.User;

@DataJpaTest // 모든 Repository, EntityManager
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void findAll_paging_test() throws JsonProcessingException{
        Pageable pageable = PageRequest.of(0, 3, Direction.DESC,"id");
       Page<Board>boardPG = boardRepository.findAll(pageable);
       ObjectMapper om = new ObjectMapper();
       String json= om.writeValueAsString(boardPG); //자바객체를json으로변환
       System.out.println(json);
    }

    
    @Test
    public void mFindAll_test(){
       boardRepository.mFindAll();
    }
    @Test
    public void FindAll_test(){
        System.out.println("조회직전");
        List<Board> boradList = boardRepository.findAll();
        System.out.println("조회 후: Lazy");
        // 행 : 5개 -> 객체 : 5개
        // 각행 : Board (id=1, title=제목1, content=내용1, created_at=날짜, User(id=1))
        System.out.println(boradList.get(0).getId());  //1번
        System.out.println(boradList.get(0).getUser().getId()); //1번
        //lazy loading -지연로딩
        //영속회된 객체에 널값을 찾으려고하면 조회가일어남,연관된 객체에서 넓을 참조하려고하면조회가일어남
        System.out.println(boradList.get(0).getUser().getUsername()); //null->ssar
    }

    @Test
    public void save_test() {
        // 비영속 객체
        Board board = Board.builder()
                .title("제목6")
                .content("내용6")
                .user(User.builder().id(1).build())
                .build();

        // 영속 객체
        boardRepository.save(board); // insert 자동으로 실행됨
        // 디비데이터와 동기화됨
        System.out.println(board.getId());
    }


   
}