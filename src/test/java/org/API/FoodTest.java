package org.API;

import io.restassured.response.Response;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("Food Finder API Tests")
@Feature("Verify each Food Finder Endpoint")
public class FoodTest {

    Response res;
    Map<String, String> headers;

    @BeforeClass
    @Description("Setup Base URI and headers for API tests")
    public void setup() {
        ApiResuable.uri("http://127.0.0.1:5000");

        headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
    }


    @Test(description = "GET - Fetch recipe details for ID 2")
    @Severity(SeverityLevel.CRITICAL)
    public void getRecipeDetail2() {
        executeAndVerify(new ApiResuable("/get-recipe-detail?id=2", "GET", null));
    }

    @Test(description = "GET - Fetch Non-Veg recipes")
    @Severity(SeverityLevel.NORMAL)
    public void getNonVegRecipes() {
        executeAndVerify(new ApiResuable("/get-recipes?category=Non-Veg", "GET", null));
    }

    @Test(description = "GET - Suggestions for query 'chi'")
    @Severity(SeverityLevel.NORMAL)
    public void getSuggestionChi() {
        executeAndVerify(new ApiResuable("/get-suggestions?query=chi", "GET", null));
    }

    @Test(description = "GET - Suggestions for query 'veg recipe'")
    @Severity(SeverityLevel.NORMAL)
    public void getSuggestionVeg() {
        executeAndVerify(new ApiResuable("/get-suggestions?query=veg recipe", "GET", null));
    }

    @Test(description = "GET - Suggestions for query 'ch'")
    @Severity(SeverityLevel.NORMAL)
    public void getSuggestionCh() {
        executeAndVerify(new ApiResuable("/get-suggestions?query=ch", "GET", null));
    }

    @Test(description = "GET - Suggestions for query 'fish'")
    @Severity(SeverityLevel.NORMAL)
    public void getSuggestionFish() {
        executeAndVerify(new ApiResuable("/get-suggestions?query=fish", "GET", null));
    }

    @Test(description = "POST - Chatbot API test with prompt 'hi'")
    @Severity(SeverityLevel.CRITICAL)
    public void chatbotAPI() {
        executeAndVerify(new ApiResuable("/chatbot-api", "POST", "{\"prompt\":\"hi\"}"));
    }

    @Test(description = "POST - AI Search test with query 'egg'")
    @Severity(SeverityLevel.CRITICAL)
    public void aiSearchAPI() {
        executeAndVerify(new ApiResuable("/ai-search", "POST", "{\"query\":\"egg\"}"));
    }

    @Test(description = "GET - Fetch recipe by name 'Chicken Biryani'")
    @Severity(SeverityLevel.NORMAL)
    public void getRecipeByName() {
        executeAndVerify(new ApiResuable("/recipe/Chicken%20Biryani", "GET", null));
    }

    @Step("Execute {api.method} request for endpoint: {api.endpoint}")
    public void executeAndVerify(ApiResuable api) {
        res = ApiResuable.execute(api, headers);

        int statusCode = res.getStatusCode();
        String body = res.getBody().asPrettyString();

        Allure.step("Method: " + api.getMethod());
        Allure.step("Endpoint: " + api.getEndpoint());
        Allure.step("Status Code: " + statusCode);
        Allure.addAttachment("Response for " + api.getEndpoint(), "application/json", body, ".json");

        System.out.println("➡️ " + api.getMethod() + " " + api.getEndpoint());
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response: " + body);

        Assert.assertTrue(statusCode == 200 || statusCode == 201,
                "❌ Expected status 200/201 but got " + statusCode + " for " + api.getEndpoint());
    }
}
