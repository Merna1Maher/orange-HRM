package org.example.stepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.loginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class login {
    loginPage AdminUserFlow = new loginPage();
    SoftAssert soft = new SoftAssert();
    Faker fake = new Faker();
    WebDriverWait wait;

    int recordCount = 0;
    String fakeUserName;

    @Given("User navigates to OrangeHRM login page")
    public void userNavigateToTheOrangeHRMLoginPage() {
        Hooks.driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("User logs in with username \"Admin\" and password \"admin123\"")
    public void iLoginWithUsernameAndPassword() {
        AdminUserFlow.username.sendKeys("Admin");
        AdminUserFlow.password.sendKeys("admin123");
        AdminUserFlow.loginButton.click();
    }

    @And("User navigates to Admin section")
    public void iClickOnTheAdminTab() {
        AdminUserFlow.adminTab.click();
    }

    @And("User gets the current number of records")
    public void iGetTheNumberOfRecords() {
        String numberOfRecord = AdminUserFlow.numberOfRecord.getText();
        String number = numberOfRecord.replaceAll("[^0-9]", "");
        recordCount = Integer.parseInt(number);
        //System.out.println("reached here with result "+ recordCount);
    }

    @And("User clicks on Add and fills required data and save")
    public void iAddANewUserWithUsername() throws InterruptedException {
        AdminUserFlow.addButton.click();
        AdminUserFlow.selectUserRole.click();
        AdminUserFlow.optionAdmin.click();
        AdminUserFlow.selectStatus.click();
        AdminUserFlow.statusEnabled.click();
        AdminUserFlow.passwordField.sendKeys("ASDqwe12!@");
        AdminUserFlow.confirmPassword.sendKeys("ASDqwe12!@");
        fakeUserName =fake.name().username();
        AdminUserFlow.userName.sendKeys(fakeUserName);
        String sameFakeUserName = AdminUserFlow.userName.getText();
        AdminUserFlow.employeeName.click();
        AdminUserFlow.employeeName.sendKeys("mo");
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AdminUserFlow.employeeNumber1.click();
        AdminUserFlow.saveButton.click();
        Thread.sleep(2000);

    }

    @Then("The number of records should increase by 1")
    public void theNumberOfRecordsShouldIncreaseBy() {
        wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(50));
        String numberOfRecord = AdminUserFlow.numberOfRecord.getText();
        String number = numberOfRecord.replaceAll("[^0-9]", "");
        int recordAfterCreation = Integer.parseInt(number);
        soft.assertEquals(recordCount+1 , recordAfterCreation);
        soft.assertAll();
    }

    @When("User searches for the new user by username")
    public void iSearchForUser() {
        AdminUserFlow.userNameSearch.sendKeys(fakeUserName);
        AdminUserFlow.search.click();

    }

    @And("User deletes the new user")
    public void iDeleteTheUser() throws InterruptedException {
        Thread.sleep(6000);
        AdminUserFlow.deleteButton.click();
        Thread.sleep(5000);
        AdminUserFlow.yesDeleteButton.click();
    }

    @Then("The number of records should decrease by 1")
    public void theNumberOfRecordsShouldDecreaseBy() {
        AdminUserFlow.adminTab.click();
        String numberOfRecord = AdminUserFlow.numberOfRecord.getText();
        String number = numberOfRecord.replaceAll("[^0-9]", "");
        recordCount = Integer.parseInt(number);

    }
}

