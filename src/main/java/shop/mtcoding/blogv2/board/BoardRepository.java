package shop.mtcoding.blogv2.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * save()인터트, findId()프라이머리키로 조회,findALL() 전체조회, count()갯수알때,deleteById()
 JpaRepository crud메서드를 주는애
 
 */
public interface BoardRepository extends JpaRepository<Board, Integer>{

}
