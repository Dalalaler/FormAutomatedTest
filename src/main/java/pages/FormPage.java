package pages;

import configreader.ConfigManager;
import enums.Genders;
import enums.Hobbies;
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
    private By maleGender = By.xpath(".//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private By femaleGender = By.xpath(".//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private By otherGender = By.xpath(".//*[@id=\"genterWrapper\"]/div[2]/div[3]/label");
    private By userNumber = By.id("userNumber");
    private By dateOfBirthday = By.id("dateOfBirthInput");
    private By subjectsContainer = By.id("subjectsInput");
    private By sportHobby = By.xpath(".//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label");
    private By readingHobby = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[2]/label");
    private By musicHobby = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[3]/label");
    private By uploadPicture = By.id("uploadPicture");
    private By currentAddress = By.id("currentAddress");
    private By stateId = By.id("react-select-3-input");
    private By cityId = By.id("react-select-4-input");
    private By submit = By.id("submit");
    private String tableCellValue = "/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[%x]/td[2]";
    private By studentName = By.xpath(String.format(tableCellValue, 1));
    private By studentEmail = By.xpath(String.format(tableCellValue, 2));
    private By studentGender = By.xpath(String.format(tableCellValue, 3));
    private By studentMobile = By.xpath(String.format(tableCellValue, 4));
    private By studentBirth = By.xpath(String.format(tableCellValue, 5));
    private By studentSubject = By.xpath(String.format(tableCellValue, 6));
    private By studentHobby = By.xpath(String.format(tableCellValue, 7));
    private By studentPicture = By.xpath(String.format(tableCellValue, 8));
    private By studentAddress = By.xpath(String.format(tableCellValue, 9));
    private By studentStateAndCity = By.xpath("/html/body/div[3]/div/div/div[2]/div/table/tbody/tr[10]/td[2]");



    public void enterFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    public void enterLastName(String name) {
        driver.findElement(lastName).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(userEmail).sendKeys(email);
    }

    public void chooseGender(Genders gender) {
        switch (gender) {
            case MALE:
                driver.findElement(maleGender).click();
                break;
            case FEMALE:
                driver.findElement(femaleGender).click();
                break;
            default:
                driver.findElement(otherGender).click();
                break;
        }
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

    public void chooseHobby(Hobbies hobby) {
        switch (hobby) {
            case SPORT:
                driver.findElement(sportHobby).click();
                break;
            case READING:
                driver.findElement(readingHobby).click();
                break;
            default:
                driver.findElement(musicHobby).click();
                break;
        }
    }

    public void uploadPicture(String filePath) {
        driver.findElement(uploadPicture).sendKeys(filePath);
    }

    public void enterAdress(String adress) {
        driver.findElement(currentAddress).sendKeys(adress);
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

    public String getInputtedName() {
        return driver.findElement(studentName).getText();
    }

    public String getInputtedEmail() {
        return driver.findElement(studentEmail).getText();
    }

    public String getInputtedGender() {
        return driver.findElement(studentGender).getText();
    }

    public String getInputtedMobile() {
        return driver.findElement(studentMobile).getText();
    }

    public String getInputtedBirthday() {
        return driver.findElement(studentBirth).getText();
    }

    public String getInputtedSubject() {
        return driver.findElement(studentSubject).getText();
    }

    public String getInputtedHobby() {
        return driver.findElement(studentHobby).getText();
    }

    public String getInputtedPictureName() {
        return driver.findElement(studentPicture).getText();
    }

    public String getInputtedAdress() {
        return driver.findElement(studentAddress).getText();
    }

    public String getInputtedStateAndCity() {
        return driver.findElement(studentStateAndCity).getText();
    }

    @Override
    public void open() throws IOException {
        driver.get(ConfigManager.getProperty("formUrl"));
    }
}
