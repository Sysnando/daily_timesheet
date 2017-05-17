package com.sysfel.timesheet.jasper.report;

import java.util.HashMap;
import java.util.Map;

import com.sysfel.timesheet.model.Job;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeneratePDFReport {

	public final String fileName;
	
	public GeneratePDFReport(String fileName) {
		this.fileName = fileName;
	}

	public byte[] generateTimeSheetJobPDF(Job job){
		byte[] pdfByteArray = new byte[]{}; 
		
		try {
            /* Using compiled version(.jasper) of Jasper report to generate PDF */
			//TODO GET ABSOLUT PATH FROM  THE CLASS LOADER OR SYSTEM CONTEXT
            String jasperFile = "/Users/sysnando/Documents/dev/projects/daily_timesheet/com/java/timesheet-rest/src/main/resources/com/sysfel/timesheet/jasperreports/" + this.fileName + ".jasper";
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile, mapParameters(job), new JREmptyDataSource());

            pdfByteArray = JasperExportManager.exportReportToPdf(jasperPrint);
            
        } catch (JRException ex) {
            ex.printStackTrace();
        }
		return pdfByteArray;
	} 
	
	private Map<String, Object> mapParameters(Job job){
        /* Map to hold Jasper report Parameters */
        Map<String, Object> parameters = new HashMap<String, Object>();
        if(job != null){
	        	
	        if(job.getLsLaborer() != null && !job.getLsLaborer().isEmpty()){
	            /* Convert List to JRBeanCollectionDataSource */
	            JRBeanCollectionDataSource lsLaborerJRBean = new JRBeanCollectionDataSource(job.getLsLaborer(), false);
	            parameters.put("LaborerDataSource", lsLaborerJRBean);        	
	        }
	        
	        if(job.getLsContainer() != null && !job.getLsContainer().isEmpty()) {
	            /* Convert List to JRBeanCollectionDataSource */
	            JRBeanCollectionDataSource lsConstainerJRBean = new JRBeanCollectionDataSource(job.getLsContainer(), false);
	            parameters.put("ContainerDataSource", lsConstainerJRBean);	
	        }
        }        
        return parameters;
	}

}
