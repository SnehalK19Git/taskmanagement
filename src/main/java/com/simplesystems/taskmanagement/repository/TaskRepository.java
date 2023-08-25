package com.simplesystems.taskmanagement.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simplesystems.taskmanagement.entity.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long>{

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Task SET taskStatus = :taskStatusPastDueDate WHERE taskDueDate <= :today AND taskStatus = :taskStatusNotDone")
	void updateTaskStatusToPastDueDate(@Param("today") LocalDate today, @Param("taskStatusNotDone") String taskStatusNotDone, @Param("taskStatusPastDueDate") String taskStatusPastDueDate);

}
