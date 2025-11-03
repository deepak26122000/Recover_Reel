package StepDefinitions;

import PageObjectMoodels.AddNewClientPage;
import Utility.ExcelReader;
import io.cucumber.java.en.*;

public class AddNewClient {

    AddNewClientPage addNewClientPage = new AddNewClientPage();

    @Given("Therapist clicks on Add New Client")
    public void therapist_clicks_on_add_new_client() {
    }

    @When("The Therapist enter name,email,phoneNumber,Clicks on save")
    public void the_therapist_enter_name_email_phone_number_clicks_on_save() throws InterruptedException {
        String excelPath="/Users/softsuave/Desktop/Recovary_Reel/TestData/ClientCrdentials/Client_credentials.xlsx";
        ExcelReader.loadExcel(excelPath);

        for (int i = 1; i < 50; i++) {// start from 1 if row 0 is header
            String name = ExcelReader.getExcel("Sheet1", i, 0);
            String email = ExcelReader.getExcel("Sheet1", i, 1);
            String phone = ExcelReader.getExcel("Sheet1", i, 2);

            addNewClientPage.clickOnAddClient();
            System.out.println(i+" Time");
            addNewClientPage.enterClientName(name);
            addNewClientPage.enterClientEmail(email);
            addNewClientPage.enterPhoneNumber(phone);

            // If groups selection is needed, call that method here
            // addNewClientPage.clickOnGroups();

            addNewClientPage.clickOnSave();
            Thread.sleep(10000);
           /* Optional: Validate after each client*/
            addNewClientPage.homePageValidation();
        }
    }


}
