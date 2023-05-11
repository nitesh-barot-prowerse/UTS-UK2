package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ManageClaimPage;
import utils.ScreenRecorderUtil;

public class ManageClaimsSteps {
    ManageClaimPage claimPage = new ManageClaimPage(DriverFactory.getDriver());

    @When("User clicks on manage claims icon on left tool bar")
    public void user_clicks_on_manage_claims_icon_on_left_tool_bar() {
        claimPage.clickManageClaimIcon();

    }

    @Then("User will able see all data available on manage claim page")
    public void user_will_able_see_all_data_available_on_manage_claim_page() {
        String displayedData = claimPage.verifyClaimPageInformation();
        System.out.println(displayedData);
    }

    @Then("All data under treatment and cliam first advised date column displays in dd-mm-yyyy format")
    public void all_data_under_treatment_and_cliam_first_advised_date_column_displays_in_dd_mm_yyyy_format() {
        String treatmentDate = claimPage.verifyTreatmentDate();
        String tDate[] = treatmentDate.split(" ");
        for (String staDate : tDate) {
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = staDate.matches(datePattern);
            if (!isDate) {
                System.out.println("Treatment Date Column data displays with dd-mm-yyyy format");
                break;
            } else {
                Assert.fail();
            }
        }

        String advisedDate = claimPage.verifyFirstAdvisedDate();
        String adDate[] = advisedDate.split(" ");
        for (String eDate : adDate) {
            String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
            boolean isDate = eDate.matches(datePattern);
            if (!isDate) {
                System.out.println("Advised Date Column data displays with dd-mm-yyyy format");
                break;
            } else {
                Assert.fail();
            }
        }

    }

    @Then("All data under Amount paybale column prefixed by £ sign")
    public void all_data_under_amount_paybale_column_prefixed_by_£_sign() {
        String amountPayable = claimPage.verifyAmountPayableColumn();
        //System.out.println(yearlyArray);

        String[] split = amountPayable.split("[ .\\ ]+");
        // System.out.println(split);
        for (int j = 1; j <= split.length-1; j=j+3) {
            System.out.println(split[j]);
            if (split[j].contains("£")) {
                System.out.println("Data Prefixed by £");

            } else {
                Assert.fail();
            }


        }

    }

    @When("User clicks on claim number on manage claim page")
    public void user_clicks_on_claim_number_on_manage_claim_page() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        claimPage.redirectToClaimInformationPage();

    }

    @Then("User will redirects to respected claim information page")
    public void user_will_redirects_to_respected_claim_information_page() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String message = claimPage.verifyClaimInfoPageText();
        Assert.assertEquals(message, "Claim Information");


    }

    @When("User clicks on add claim button")
    public void user_clicks_on_add_claim_button() {
        claimPage.clickAddClaimIcon();
    }

    @Then("User will redirect to add claim page")
    public void user_will_redirect_to_add_claim_page() {
        String Message = claimPage.verifyAddClaimPage();
        Assert.assertEquals(Message, "Add Claim");
    }

    @Then("Page has all dropdown with valid list items'")
    public void page_has_all_dropdown_with_valid_list_items() {
        claimPage.verifyDropDown();

    }

    @When("User selects any options from treatment status dropdown on manage claim page")
    public void user_selects_any_options_from_treatment_status_dropdown_on_manage_claim_page() {
        claimPage.selectItemFromStatusDropDown();

    }

    @Then("Appropriate treatment status will display on manage claim page under claim details")
    public void appropriate_treatment_status_will_display_on_manage_claim_page_under_claim_details() {
        String treatmentStatus = claimPage.verifyTreatmentStatus();

       if (treatmentStatus.contains("Pending")){
           System.out.println("Treatment status appeared as per requirement");
       }
    }


}
