package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDaoTestSuite {
    @Autowired
    private TaskDao taskDao;
    private static String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    public void testSaveDao() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        //When
        taskDao.save(task);

        //Then

        int id = task.getId();
        Task readTask = taskDao.findOne(id);
        Assert.assertEquals(id, readTask.getId());

        //CleanUp

        taskDao.delete(id);
    }

    @Test
    public void findByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);

        int duration = task.getDuration();

        //When

        List<Task> taskList = taskDao.findByDuration(duration);

        //then

        Assert.assertEquals(1, taskList.size());

        //CleanUp

        taskDao.delete(taskList.get(0).getId());

    }

    @Test
    public void testTaskDaoWithFinancialDetails() {
        //When
        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal("12121"), false));

        //Then
        taskDao.save(task);
        int id = task.getId();
        List<Task> taskList = taskDao.findByDuration(30);

        //Then

        Assert.assertEquals(0 , id);

        //CleanUp
        // taskDao.delete(id);
    }

}
