package org.acme;

import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.CoreMatchers.is;

public class HelloResourceTest {

    private static List<String> expected;

    @Test
    void testHelloEndpoint() {
        final String HELLO = "hello";
        expected.add(HELLO);

        given()
            .when()
                .get("/hello")
            .then()
                .statusCode(200)
                .body(is(expected.toString()));

        expected.add(HELLO);


        Response response = post("/hello");

        System.out.println(response.getBody().peek());
        System.out.println(response.getHeaders());

        given()
            .when()
                .post("/hello")
            .then()
                .statusCode(201)
                .body(is(expected.toString()));

        expected.remove(HELLO);

        given()
            .when()
                .delete("/hello")
            .then()
                .statusCode(200)
                .body(is(expected.toString()));
    }

    @BeforeAll
    static void setUp() {
        expected = new ArrayList<>();
    }

    @AfterAll
    static void tearDown() {
        expected = null;
    }
}


