package com.sysfel.timesheet.controller;

import java.util.Collection;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysfel.timesheet.jasper.report.GeneratePDFReport;
import com.sysfel.timesheet.model.Container;
import com.sysfel.timesheet.model.Job;
import com.sysfel.timesheet.model.Mail;
import com.sysfel.timesheet.service.ContainerService;
import com.sysfel.timesheet.service.JobService;
import com.sysfel.timesheet.service.SmtpMailSenderService;

@RestController
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:mail.properties")
})
public class JobController {

	@Autowired
	JobService jobService;
	
	@Autowired
	ContainerService containerService;
	
	@Autowired
	SmtpMailSenderService service;
	
	@Autowired
	Environment env;
	
	@RequestMapping(value="/job/add")
	Job add(Job job){
		return jobService.save(job);
	}
	
	@RequestMapping(value="/job/findAll")
	Collection<Job> findAll(){
		return jobService.findAll();
	}
	
	@RequestMapping(value="/job/findJobById")
	Job findJobById(Long id){
		return jobService.findJobById(id);
	}
	
	@RequestMapping(value="/job/generateTimeSheetPDF")
	void generateTimeSheet(Long id){

		//TODO It should be dinamic jasper file 
		GeneratePDFReport generatePDF = new GeneratePDFReport("daily_work_sheet_infront2");
		Job job = findJobById(id);
		if(job == null){
			//TODO IF THE JOB IS NULL I HAVE TO RETURN SOMETHING
		}
		
		try {
			//TODO NAO ESTA FUNCIONANDO PEGAR AS PROPRIEDADES DO ARQUIVO MAIL.PROPERTIES
			Mail mail = new Mail();
			mail.setToAddress(env.getProperty("mail.to"));
			mail.setSubject(env.getProperty("mail.subject"));
			mail.setMessage(env.getProperty("mail.message"));
	
			Long idCustomer = null;
			if(job.getCustomer()!= null){
				idCustomer = job.getCustomer().getId();
			}
			mail.setAttachmentPDFFilename(job.getId(), job.getDate(), idCustomer);
			mail.setAttachmentBytes(generatePDF.generateTimeSheetJobPDF(job));

		
			service.send(mail);
		} catch (MessagingException e) {
			// TODO I have to handle the EXCEPTIONS
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/container/findAll")
	Collection<Container> lsContainer(){
		return containerService.findAll();
	}
	
//	public void validateCustomer(String customerName){
//		Customer customer = this.laborerService.findByName(customerName);
//		if(customer == null){
//			throw new CustomerNotFoundException(customerName);
//		}
//	}
}
