package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.orangehrmlive.demo.driverfactory.ManageDriver.driver;

public class DashBoardPage extends Utility {
    private static final Logger log = LogManager.getLogger(DashBoardPage.class.getName());

    public void DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']")
    WebElement  dashboardTab;
    @FindBy (xpath="//h6[normalize-space()='Dashboard']")
            WebElement dashboardText;
    public void ClickDeshboad(){clickOnElement(dashboardTab);}

    public String verifyTextDashboard(){
        return getTextFromElement(dashboardText);
    }
}
