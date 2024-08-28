package spring.todo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.todo.app.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}