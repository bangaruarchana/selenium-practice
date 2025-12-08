package restAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class postMethodTest {
	@Test
	public void jsonValidate() {
		baseURI="https://reqres.in/api";

		given().
		get("/api/users?page=2")
		.then().assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
		.statusCode(200);
	}
}
