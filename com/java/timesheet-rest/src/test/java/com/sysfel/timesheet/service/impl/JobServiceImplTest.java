package com.sysfel.timesheet.service.impl;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sysfel.timesheet.DailyTimesheetApplication;
import com.sysfel.timesheet.model.Job;
import com.sysfel.timesheet.service.JobService;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DailyTimesheetApplication.class)
public class JobServiceImplTest {
	
	@Autowired
	private JobService jobService;
	
//	verificar a UTL http://spring.io/guides/tutorials/bookmarks/ para fazer os testes
//	@Before
//	public void setup(){
//		
//	}
	
	@Test
	public void testFindAll() {
		Collection<Job> listJob = jobService.findAll();
		
		Assert.assertTrue(!listJob.isEmpty());
	}

}
