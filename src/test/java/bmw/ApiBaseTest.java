package bmw;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.SSLConfig.sslConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class ApiBaseTest {

    private static final String LocalhostSSL = "https://localhost:22950";
    private RequestSpecification httpRequest;


    /**
     * This method will run before EVERY test case
     */

    @Before
    public void beforeScenario() {

        RestAssured.baseURI = LocalhostSSL;
        RestAssured.useRelaxedHTTPSValidation();
        httpRequest = RestAssured.given();

    }

    /**
     * Set the applicationID for different users
     *
     * @param applicationId Different applicationID for different AOS users
     */

    @Then("I set the applicationID: \"([^\"]*)\"$")
    public void setApplicationId(String applicationId) {

        httpRequest.given().header("X-rgw-applicationid", applicationId);

    }

    /**
     * Global method for validate clearanceID GET response
     *
     * @param clearanceId The Pre-condition for the test cases, can be expired deleted or modified
     */

    @Given("I request telematic data with clearanceID: \"([^\"]*)\"$")
    public void getDataForClearanceId(String clearanceId) {

        httpRequest.given().auth().preemptive().basic("otptest", "otp$int");

        if (httpRequest.contentType(ContentType.JSON).
                get("/otpdatadelivery/api/thirdparty/v1/clearances/" +
                        clearanceId + "/telematicdata").body().prettyPrint().contains("telematicKeyValues")) {

            httpRequest.contentType(ContentType.JSON).
                    get("/otpdatadelivery/api/thirdparty/v1/clearances/" +
                            clearanceId + "/telematicdata")
                    .then()
                    .statusCode(200)
                    .and()
                    .statusLine("HTTP/1.1 200 OK")
                    .and()
                    .body("telematicKeyValues.unit", hasItems("null"))
                    .and()
                    .body("telematicKeyValues.value", hasItems("null"))
                    .and()
                    .body("telematicKeyValues.timestamp", hasItems("null"));
        } else {

            httpRequest.contentType(ContentType.JSON).
                    get("/otpdatadelivery/api/thirdparty/v1/clearances/" +
                            clearanceId + "/telematicdata")
                    .then()
                    .statusCode(403)
                    .and()
                    .body("errorCode", equalTo("TP-107")).and()
                    .body("message", equalTo("No permission for specified 'clearanceId'"));
        }
    }

    @Given("I request clearance with container ID: \"([^\"]*)\" and VIN number: \"([^\"]*)\"$")
    public void requestClearanceForVehicle(String containerId, String vinNumber){

        httpRequest.given().auth().preemptive().basic("otptest","otp$int");

        // THIS IS THE IMPORTANT SENDING CODE LIKE IN CHROME
        httpRequest.header("Content-Type", "application/evmg.v18.3+json");
        httpRequest.header("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");
        httpRequest.header("Host", "https://localhost:22950");
        httpRequest.header("Connection", "Keep-Alive");

        System.out.println(httpRequest.contentType(ContentType.JSON)
                .post("/otpclearance/api/thirdparty/v1/applications/containers/"+ containerId +"/vehicles/"+ vinNumber +"/clearances")
                .getBody().prettyPrint());

        httpRequest.contentType(ContentType.JSON)
                .post("/otpclearance/api/thirdparty/v1/applications/containers/"+ containerId +"/vehicles/"+ vinNumber +"/clearances")
                .then()
                .statusCode(403)
                .and()
                .body("errorCode", equalTo("TP-103"))
                .and()
                .body("message", equalTo("No permission for specified 'containerId'"));

    }



}
