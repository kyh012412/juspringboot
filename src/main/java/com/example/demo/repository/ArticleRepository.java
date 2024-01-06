package com.example.demo.repository;

import com.example.demo.entity.Article;
import org.springframework.data.repository.CrudRepository;

//CrudRepository는 JPA에서 제공하는 인터페이스로 이를 상속해서 엔티티를 관리( 생성,조회,수정,삭제) 할 수 있다.
// Long은 ID의 자료형
public interface ArticleRepository extends CrudRepository<Article,Long>{

}
