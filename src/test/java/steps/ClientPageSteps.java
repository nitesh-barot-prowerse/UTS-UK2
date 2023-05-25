package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ClientPage;
import pages.LogInPage;

public class ClientPageSteps {

    ClientPage clientPage = new ClientPage(DriverFactory.getDriver());

    @Given("User should log in with username {string} and password {string} to the admin panel")
    public void user_should_log_in_with_username_and_password_to_the_admin_panel(String string, String string2) {
        LogInPage logInPage = new LogInPage(DriverFactory.getDriver());
        logInPage.enterUserName(string);
        logInPage.enterPassword(string2);
        logInPage.clickSubmit();

    }

    @When("User clicks on client icon on left tool bar")
    public void user_clicks_on_client_icon_on_left_tool_bar() {
        String Message = clientPage.verifyClientManage();
        Assert.assertEquals(Message, "Manage Client");

    }


    @Then("Manage client page displays with list of clients")
    public void manage_client_page_displays_with_list_of_clients() {
        String clientData = clientPage.fetchAndDisplayData();
        if (clientData.length() > 0) {
            System.out.println(clientData);
        } else {
            Assert.fail();
        }

    }

    @When("User enters code number inside search box on manage client page")
    public void user_enters_code_number_inside_search_box_on_manage_client_page() {
        clientPage.enterCodeDetails();
    }

    @When("User clicks on search button manage client page")
    public void user_clicks_on_search_button_manage_client_page() {
        clientPage.clickOnButton();
    }

    @Then("Appropriate client information displays inside table on manage client page")
    public void appropriate_client_information_displays_inside_table_on_manage_client_page() {
        String clientCode = clientPage.verifyClient();
        Assert.assertEquals(clientCode, "RAOA-0001");
    }

    @When("User selects appropriate option from Active dropdown on manage client page")
    public void user_selects_appropriate_option_from_active_dropdown_on_manage_client_page() {
        clientPage.selectClientStatus();

    }

    @When("User clicks on search button")
    public void user_clicks_on_search_button() {
        clientPage.clickOnButton();
    }

    @When("User clicks on client code on manage client page")
    public void user_clicks_on_client_code_on_manage_client_page() {
        clientPage.clickClientCode();
    }

    @Then("Client status displays on view client page")
    public void client_status_displays_on_view_client_page() {
        String Status = clientPage.verifyClientStatus();
        Assert.assertEquals(Status, "Active");
    }

    @When("User clicks on add button on view client page")
    public void user_clicks_on_add_button_on_view_client_page() {
        clientPage.clickOnAddQuoteButton();
    }

    @Then("Add quote page displays with same client code")
    public void add_quote_page_displays_with_same_client_code() {
        String clientId = clientPage.verifyExistingClientOnAddQuote();
        Assert.assertEquals(clientId, "DANK-00005");
    }

    //To add new Client test case step definition

    @When("User clicks on add client icon on manage client page")
    public void user_clicks_on_add_client_icon_on_manage_client_page() {
        clientPage.clickOnAddClientButton();

    }

    @When("User enters all mandatory details on add client page")
    public void user_enters_all_mandatory_details_on_add_client_page() {
        clientPage.enterUserDetails();
    }

    @When("User clicks on create button on add client page")
    public void user_clicks_on_create_button_on_add_client_page() {
        clientPage.clickOnCreateClientButton();
    }

    @Then("View client page appears with the details of currently added client")
    public void view_client_page_appears_with_the_details_of_currently_added_client() {
        String clientMessage = clientPage.verifyCreatedClient();
        Assert.assertEquals(clientMessage, "View Client");

    }

    //Add contact details of client

    @When("User selects Add contact option from setting dropdown besides of active text on view client page")
    public void user_selects_add_contact_option_from_setting_dropdown_besides_of_active_text_on_view_client_page() {
        clientPage.selectAddContactOfClient();

    }

    @When("User enters all details inside add client window")
    public void user_enters_all_details_inside_add_client_window() {
        clientPage.enterContactDetails();

    }

    @Then("Contact details can view under contacts menu on view client page")
    public void contact_details_can_view_under_contacts_menu_on_view_client_page() {
        String contactDetail = clientPage.verifyGeneratedContactDetails();
        if (contactDetail.length() > 0) {
            System.out.println(contactDetail);

        }
    }


}
