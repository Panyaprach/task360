package com.asg360;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Panyaprach Tularak
 */
@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {
}
