package tests;

import configreader.ConfigManager;
import enums.Genders;
import enums.Hobbies;
import org.junit.jupiter.api.Test;
import testutils.ComparisonUtil;

import java.io.IOException;

public class FormTest extends BasicTest {
    private String name = "Danila";
    private String lastName = "Vouk";
    private String email = "dalalaler@gmail.com";
    private String number = "0297675285";
    private String birthDay = "25 Mar 1997";
    private String subject = "English";
    private String picturePath = "D:\\java\\projects\\FormAutomatedTest\\src\\main\\resources\\kfc_fighter.jpg";
    private String adress = "Belarus, Hrodno, Sverdlova street, 19, 9";
    private String state = "Haryana";
    private String city = "Panipat";

    @Test
    public void loginTest() throws IOException {
        loginPage.open();
        loginPage.enterUsername(ConfigManager.getProperty("demoQaLogin"));
        loginPage.enterPassword(ConfigManager.getProperty("demoQaPassword"));
        loginPage.clickLogin();
        dashboardPage.clickLogout();
    }

    @Test
    public void formTest() throws IOException {
        formPage.open();

        formPage.enterFirstName(name);
        formPage.enterLastName(lastName);
        formPage.enterEmail(email);
        formPage.chooseGender(Genders.ATTACK_HELICOPTER);
        formPage.enterUserNumber(number);
        formPage.enterDateOfBirthday(birthDay);
        formPage.enterSubjects(subject);
        formPage.chooseHobby(Hobbies.SPORT);
        formPage.uploadPicture(picturePath);
        formPage.enterAdress(adress);
        formPage.enterState(state);
        formPage.enterCity(city);
        formPage.pressSubmit();

        ComparisonUtil.dataCompare(name + " " + lastName, formPage.getInputtedName());
        ComparisonUtil.dataCompare(email, formPage.getInputtedEmail());
        ComparisonUtil.dataCompare("Other", formPage.getInputtedGender());
        ComparisonUtil.dataCompare(number, formPage.getInputtedMobile());
        ComparisonUtil.dataCompare(birthDay, formPage.getInputtedBirthday());
        ComparisonUtil.dataCompare(subject, formPage.getInputtedSubject());
        ComparisonUtil.dataCompare("Sports", formPage.getInputtedHobby());
        ComparisonUtil.dataCompare("kfc_fighter.jpg", formPage.getInputtedPictureName());
        ComparisonUtil.dataCompare(adress, formPage.getInputtedAdress());
        ComparisonUtil.dataCompare(state + " " + city, formPage.getInputtedStateAndCity());
    }
}
