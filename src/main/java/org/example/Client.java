package org.example;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.builder.RequestSpecBuilder;

import static org.example.Urls.BASE_URL;

public class Client {
    public RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URL)
                .build();
    }
}
