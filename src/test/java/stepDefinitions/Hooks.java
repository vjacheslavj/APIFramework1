package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {
        //write a code that will give you place id
        //execute this code only when place id is null

        StepDefinition m = new StepDefinition();
        if (StepDefinition.place_id == null) {
            m.add_place_payload("Shetty", "French", "Asia");
            m.user_calls_with_http_request("AddPlaceAPI", "POST");
            m.verify_place_id_create_maps_to_using_get_place_api("Shetty", "getPlaceAPI");
        }
    }
}
