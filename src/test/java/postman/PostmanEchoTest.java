package postman;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }


    // REQUEST METHODS


    @Test
    void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    void testPostRawText() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    void testPutRequest() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .body(body)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    void testPatchRequest() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .body(body)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    void testDeleteRequest() {
        String body = "This is expected to be sent back as part of response body.";

        given()
                .body(body)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }


    // HEADERS


    @Test
    void testRequestHeaders() {
        given()
                .header("my-sample-header", "Lorem ipsum dolor sit amet")
                .when()
                .get("/headers")
                .then()
                .statusCode(200)
                .body("headers.my-sample-header",
                        equalTo("Lorem ipsum dolor sit amet"));
    }

    @Test
    void testResponseHeaders() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/response-headers")
                .then()
                .statusCode(200)
                .header("foo1", "bar1")
                .header("foo2", "bar2")
                .body("foo1", equalTo("bar1"))
                .body("foo2", equalTo("bar2"));
    }

    // BASIC AUTH


    @Test
    void testBasicAuth() {
        given()
                .auth()
                .preemptive()
                .basic("postman", "password")
                .when()
                .get("/basic-auth")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true));
    }
}
