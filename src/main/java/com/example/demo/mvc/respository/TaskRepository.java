package com.example.demo.mvc.respository;

import com.example.demo.mvc.domain.Task1;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task1, Long> {

}
