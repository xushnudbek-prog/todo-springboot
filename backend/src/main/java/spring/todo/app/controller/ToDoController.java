package spring.todo.app.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.todo.app.entity.ToDo;
import spring.todo.app.service.ToDoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "ToDo APIs")
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping("/add")
    public ToDo addToDo(@RequestBody ToDo toDo) {
        return toDoService.save(toDo);
    }

    @GetMapping("/")
    public List<ToDo> getAll() {
        return toDoService.findAll();
    }
    @PostMapping("/update/{id}")
    public ToDo updateToDo(@PathVariable Long id, @RequestBody ToDo toDo) {
        toDo.setId(id);
        return toDoService.update(toDo);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id) {
        toDoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
