package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import testutils.PathGetter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest extends BasicTest {
    private String name = "Danila";
    private String lastName = "Vouk";
    private String email = "dalalaler@gmail.com";
    private String gender = "Male";
    private String number = "0297675285";
    private String birthDay = "25 Mar 1997";
    private String subject = "English";
    private String hobby = "Music";
    private String pictureName = "kfc_fighter.jpg";
    private String adress = "Belarus, Hrodno, Sverdlova street, 19, 9";
    private String state = "Haryana";
    private String city = "Panipat";

    @BeforeEach
    public void pageSetup() throws IOException {
        formPage = new FormPage(driver);
        formPage.open();
    }

    @Test
    public void formTest() throws IOException {
        formPage.enterFirstName(name);
        formPage.enterLastName(lastName);
        formPage.enterEmail(email);
        formPage.chooseGender(gender);
        formPage.enterUserNumber(number);
        formPage.enterDateOfBirthday(birthDay);
        formPage.enterSubjects(subject);
        formPage.chooseHobby(hobby);
        formPage.uploadPicture(PathGetter.getAbsoluteFilePath("picturesPath", pictureName));
        formPage.enterAddress(adress);
        formPage.enterState(state);
        formPage.enterCity(city);
        formPage.pressSubmit();

        assertEquals(name + " " + lastName, formPage.getInputtedValueFromTable("Student Name"));
        assertEquals(email, formPage.getInputtedValueFromTable("Student Email"));
        assertEquals(gender, formPage.getInputtedValueFromTable("Gender"));
        assertEquals(number, formPage.getInputtedValueFromTable("Mobile"));
        assertEquals(subject, formPage.getInputtedValueFromTable("Subjects"));
        assertEquals(hobby, formPage.getInputtedValueFromTable("Hobbies"));
        assertEquals(pictureName, formPage.getInputtedValueFromTable("Picture"));
        assertEquals(adress, formPage.getInputtedValueFromTable("Address"));
        assertEquals(state + " " + city, formPage.getInputtedValueFromTable("State and City"));
        assertEquals(birthDay, formPage.getInputtedValueFromTable("Date of Birth"));
    }
}
