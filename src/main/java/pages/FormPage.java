package pages;

import configreader.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class FormPage extends AbstractPage {
    public FormPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By userEmail = By.id("userEmail");
    private String genderXpath = "//div[.=\"%s\"][@class=\"custom-control custom-radio custom-control-inline\"]";
    private By userNumber = By.id("userNumber");
    private By dateOfBirthday = By.id("dateOfBirthInput");
    private By subjectsContainer = By.id("subjectsInput");
    private String hobbyXpath = "//label[.=\"%s\"][@class=\"custom-control-label\"]";
    private By uploadPicture = By.id("uploadPicture");
    private By currentAddress = By.id("currentAddress");
    private By stateId = By.id("react-select-3-input");
    private By cityId = By.id("react-select-4-input");
    private By submit = By.id("submit");
    private String tableCellValueXpath = "//td[.=\"%s\"]//following-sibling::td";

    public void enterFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    public void enterLastName(String name) {
        driver.findElement(lastName).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(userEmail).sendKeys(email);
    }

    public void chooseGender(String genderChoice) {
        driver.findElement(By.xpath(String.format(genderXpath, genderChoice))).click();
    }

    public void enterUserNumber(String number) {
        driver.findElement(userNumber).sendKeys(number);
    }

    public void enterDateOfBirthday(String date) {
        for (int i = 0; i < 10; i++) {
            driver.findElement(dateOfBirthday).sendKeys(Keys.BACK_SPACE);
        }
        driver.findElement(dateOfBirthday).sendKeys(date);
    }

    public void enterSubjects(String subj) {
        driver.findElement(subjectsContainer).sendKeys(subj);
        driver.findElement(subjectsContainer).sendKeys(Keys.ENTER);
    }

    public void chooseHobby(String hobby) {
        driver.findElement(By.xpath(String.format(hobbyXpath, hobby))).click();
    }

    public void uploadPicture(String filePath) {
        driver.findElement(uploadPicture).sendKeys(filePath);
    }

    public void enterAddress(String address) {
        driver.findElement(currentAddress).sendKeys(address);
    }

    public void enterState(String state) {
        driver.findElement(stateId).sendKeys(state);
        driver.findElement(stateId).sendKeys(Keys.ENTER);
    }

    public void enterCity(String city) {
        driver.findElement(cityId).sendKeys(city);
        driver.findElement(cityId).sendKeys(Keys.ENTER);
    }

    public void pressSubmit() {
        driver.findElement(submit).click();
    }

    public String getInputtedValueFromTable(String cellName) {
        return driver.findElement(By.xpath(String.format(tableCellValueXpath, cellName))).getText();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("formUrl"));
    }
}
