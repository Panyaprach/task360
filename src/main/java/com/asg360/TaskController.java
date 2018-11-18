package com.asg360;

import com.asg360.Task.Status;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Panyaprach Tularak
 */
@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<?> getTasks() {
        List task = service.getAll();

        return ResponseEntity.ok(task);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getTask(@Valid @PathVariable("id") Long id) {
        Task task = service.getById(id);

        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<?> createTask(@Valid @RequestBody Task task) {
        task = service.create(task);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(task);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateTaskById(@Valid @PathVariable("id") Long id, @Valid @RequestBody Task task) {
        service.update(id, task);

        return ResponseEntity
                .noContent()
                .build();
    }

    @PatchMapping("{id}/status")
    public ResponseEntity<?> updateTaskStatus(@Valid @PathVariable("id") Long id) {
        Task task = service.getById(id);
        switch (task.getStatus()) {
            case PENDING:
                task.setStatus(Status.DONE);
                break;
            case DONE:
                task.setStatus(Status.PENDING);
                break;
        }
        service.update(task);

        return ResponseEntity
                .noContent()
                .build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @ExceptionHandler(ContentNegotiationFailedException.class)
    public ResponseEntity<?> handleContentNegotiationFailed(ContentNegotiationFailedException ex) {
        return ResponseEntity.badRequest()
                .body(ex.getMessage());
    }
}
