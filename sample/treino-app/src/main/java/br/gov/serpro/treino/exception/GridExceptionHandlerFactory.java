package br.gov.serpro.treino.exception;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

 public class GridExceptionHandlerFactory extends ExceptionHandlerFactory {  
	       
	     private ExceptionHandlerFactory exceptionHandlerFactory;  
	       
	     public GridExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory){
	         this.exceptionHandlerFactory = exceptionHandlerFactory;  
	     }  
	       
	     @Override  
	     public ExceptionHandler getExceptionHandler() {  
	         ExceptionHandler result = exceptionHandlerFactory.getExceptionHandler();  
	         result = new GridExceptionHandler(result);  
	         return result;  
	     }  
	   
	 }  