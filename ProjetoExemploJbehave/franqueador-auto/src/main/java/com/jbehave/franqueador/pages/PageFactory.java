package com.jbehave.franqueador.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    public Login newLogin() {
        return new Login(webDriverProvider);
    }
    
    public ActionsButtons newActionsButtons() {
        return new ActionsButtons(webDriverProvider);
    }
    
    public Category newCategory() {
        return new Category(webDriverProvider);
    }

    public PageLoged newPageLoged() {
        return new PageLoged(webDriverProvider);
    }
}
