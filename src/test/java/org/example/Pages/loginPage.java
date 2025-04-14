package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.stepDef.Hooks;

public class loginPage {

    public loginPage() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement username;

    @FindBy(xpath = "//input[@name=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@href=\"/web/index.php/admin/viewAdminModule\"]")
    public WebElement adminTab;

    @FindBy(xpath = "//div[@class=\"orangehrm-horizontal-padding orangehrm-vertical-padding\"]/span[@class=\"oxd-text oxd-text--span\"]")
    public WebElement numberOfRecord;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
    public WebElement addButton ;

    @FindBy(xpath = "//div[@class=\"oxd-autocomplete-wrapper\"]//input[@placeholder=\"Type for hints...\"]")
    public WebElement employeeName;

    @FindBy(xpath = "//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][1]//input[@class=\"oxd-input oxd-input--active\"]")
    public WebElement confirmPassword;

    @FindBy(xpath = "//div[@class=\"oxd-grid-item oxd-grid-item--gutters user-password-cell\"]//input[@class=\"oxd-input oxd-input--active\"]")
    public WebElement passwordField;

    @FindBy(xpath = "//div[label[contains(text(), 'Username')]]/following-sibling::div[1]//input")
    public WebElement userName;

    @FindBy(xpath = "//div[@class=\"oxd-form-row\"]/div//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][1]//div[2]//div[@class=\"oxd-select-wrapper\"]")
    public WebElement selectUserRole;

    @FindBy(xpath = "//div[@class=\"oxd-form-row\"]/div//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"][3]//div[2]//div[@class=\"oxd-select-wrapper\"]")
    public WebElement selectStatus;

    @FindBy(xpath = "//div[@class=\"oxd-select-dropdown --positon-bottom\"]//div[2]")
    public WebElement optionAdmin;

    @FindBy(xpath = "//div[@class=\"oxd-select-dropdown --positon-bottom\"]//div[2]")
    public WebElement statusEnabled;

    @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]//button[@type=\"submit\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class=\"oxd-autocomplete-dropdown --positon-bottom\"]//div[@class=\"oxd-autocomplete-option\"][1]")
    public WebElement employeeNumber1;

    @FindBy(xpath = "//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]//input[@class=\"oxd-input oxd-input--active\"]")
    public WebElement userNameSearch;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")
    public WebElement search;

    @FindBy(xpath = "//div[@class=\"oxd-table-cell oxd-padding-cell\"][6]//button[@class=\"oxd-icon-button oxd-table-cell-action-space\"][1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin\"]")
    public WebElement yesDeleteButton ;



}

