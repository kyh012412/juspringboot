package com.example.demo.repository;

import com.example.demo.entity.Members;
import org.springframework.data.repository.CrudRepository;

public interface MembersRepository extends CrudRepository<Members,Long> {

}
