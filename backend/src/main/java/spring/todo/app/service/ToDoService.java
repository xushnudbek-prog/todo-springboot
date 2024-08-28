package spring.todo.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.todo.app.entity.ToDo;
import spring.todo.app.exception.EntityNotFoundException;
import spring.todo.app.repository.ToDoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDo save(ToDo todo) {
        return toDoRepository.save(todo);
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }
    public ToDo update(ToDo todo) {
        checkToDo(todo.getId());
        return toDoRepository.save(todo);
    }
    public void delete(Long id) {
        checkToDo(id);
        toDoRepository.deleteById(id);
    }
    private void checkToDo(Long id) {
        toDoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ToDo with ID " + id + " not found"));
    }
}
