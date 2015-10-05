package com.jbehave.franqueador.steps;

import com.jbehave.franqueador.pages.Category;
import com.jbehave.franqueador.pages.PageFactory;

public class CategorySteps {

	Category category;

	public CategorySteps(PageFactory pageFactory) {
		category = pageFactory.newCategory();
	}

}
