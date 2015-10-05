package com.jbehave.franqueador.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;

import com.jbehave.franqueador.pages.PageFactory;
import com.jbehave.franqueador.pages.PageLoged;

public class PageLogedSteps {
	
	PageLoged pageLoged;
	
	 public PageLogedSteps(PageFactory pageFactory){
		 pageLoged = pageFactory.newPageLoged();
	    }
	 
	
	@Given("that I stayed on $pageName page")
	public void accessPage(@Named("pageName")String pageName){
		
	}

}
