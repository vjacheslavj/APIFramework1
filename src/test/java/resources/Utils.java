package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {
        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            RestAssured.baseURI = "https://rahulshettyacademy.com";
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        // FileInputStream fis = new FileInputStream("/Users/vjaceslavsjermakovs/IdeaProjects/APIFramefork/src/test/java/resources/global.properties"); //mac
        FileInputStream fis = new FileInputStream("C:\\Proj\\git projects\\APIFramefork\\src\\test\\java\\resources\\global.properties"); //hp

        prop.load(fis);
        return prop.getProperty(key);
    }
}