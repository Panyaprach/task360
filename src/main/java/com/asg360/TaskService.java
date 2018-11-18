package com.asg360;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Panyaprach Tularak
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public List<Task> getAll() {
        return repo.findAll();
    }

    public Task getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ContentNegotiationFailedException("Task id not found: " + id));
    }

    public Task create(Task t) {
        try {
            return repo.save(t);
        } catch (Exception e) {
            throw new ContentNegotiationFailedException("Failed to create task", e);
        }
    }

    public void update(Task t) {
        try {
            repo.save(t);
        } catch (Exception e) {
            throw new ContentNegotiationFailedException("Failed to update task", e);
        }
    }

    public void update(Long id, Task newt) {
        Task oldt = getById(id);
        if (!oldt.getId().equals(newt.getId())) {
            throw new ContentNegotiationFailedException("Could not update id");
        }
        update(newt);
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            throw new ContentNegotiationFailedException("Failed to delete task", e);
        }
    }
}
