package com.swietlik.swietlik;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@SpringBootTest
@RunWith(SpringRunner.class)
class SwietlikApplicationTests {
	@LocalServerPort
	private int port;

	@Before
	public void setUp(){
		RestAssured.port = port;
	}
	@Test
	public void testGetAllStreamers() {
		given()
				.when()
				.get("/api/streamers")
				.then()
				.statusCode(200)
				.body("size()",greaterThanOrEqualTo(2));
	}

}
