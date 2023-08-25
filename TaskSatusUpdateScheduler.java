package com.simplesystems.taskmanagement.scheduler;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.simplesystems.taskmanagement.service.TaskManagementService;


public class TaskSatusUpdateScheduler {
	
@Autowired
private TaskManagementService service;
Logger logger = LogManager.getLogger(TaskManagementService.class);

	@Scheduled(cron = "0 15 12 * * ?")
    public void launchJob() throws Exception {
	logger.debug("Scheduled job started");
	service.updateTasksToPastDueDate();
	logger.debug("Scheduled job ended");
	}

}
