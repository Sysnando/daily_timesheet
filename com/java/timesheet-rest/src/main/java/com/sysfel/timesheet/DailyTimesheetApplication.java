package com.sysfel.timesheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.sysfel.timesheet.enums.JobRole;
import com.sysfel.timesheet.model.Address;
import com.sysfel.timesheet.model.Container;
import com.sysfel.timesheet.model.Customer;
import com.sysfel.timesheet.model.Job;
import com.sysfel.timesheet.model.Laborer;
import com.sysfel.timesheet.service.CustomerService;
import com.sysfel.timesheet.service.JobService;

@SpringBootApplication
public class DailyTimesheetApplication {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private CustomerService custService;
	
    public static void main(String[] args) {
        SpringApplication.run(DailyTimesheetApplication.class, args);
    }
    
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }
    
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	//TODO REMOVE THIS CODE WHEN IN PRODUCTION
        	loadJob();
        	
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
        };
    }
    private Laborer addLaborer(String name, JobRole jRole){
    	Laborer laborer = new Laborer();
    	laborer.setName(name);
    	laborer.setInitial(name.substring(2));
    	laborer.setJobRole(jRole);
//    	lService.save(laborer);
    	return laborer;
    }
    private Container addContainer(String ref){
    	Container c = new Container();
    	c.setReference(ref);
    	c.setSize(40);
    	return c;
    }
    
    private Customer addCustomer(String name){
    	Customer c = new Customer();
    	c.setName(name);
    	return custService.save(c);
    }
    
    private void loadJob(){
    	Job job = new Job();
    	System.out.println("##################INSERINDO JOB#################");
    	Address a = new Address();
    	a.setLocation("Mascot");
    	job.setAddress(a);
    	
    	List<Laborer> lsLaborer = new ArrayList<Laborer>();
    	System.out.println("INSERINDO PRIMEIRO LABOURER");
    	lsLaborer.add(addLaborer("Sisnando Felipe", JobRole.DRIVER));
    	System.out.println("INSERINDO SEGUNDO LABOURER");
    	lsLaborer.add(addLaborer("Vini Aleixo", JobRole.LABOURER));
    	job.setLsLaborer(lsLaborer);
    	
    	System.out.println("INSERINFO CUSTOMER");
    	job.setCustomer(addCustomer("Containers Fast Furious"));
    	
    	System.out.println("INSERINDO CONTAINER");
    	List<Container> lsC = new ArrayList<Container>();
    	lsC.add(addContainer("container1"));
    	lsC.add(addContainer("container2"));
    	lsC.add(addContainer("container3"));
    	job.setLsContainer(lsC);
    	
    	job.setDate(new Date(System.currentTimeMillis()));
    	
    	System.out.println("SALVANDO O JOB");
    	jobService.save(job);
    	System.out.println("################JOB INSERIDO#####################");
    }
}
