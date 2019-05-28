package com.hemanand.sim

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder


class TokenResourceTest extends Simulation {

	val getAction: ScenarioBuilder = scenario("Test")
		.exec(
			http("test_get_request")
			.get("https://dog.ceo/api/breeds/image/random")
			.check(status.is(200))
		)

	setUp(
		getAction.inject(constantUsersPerSec(10) during 10)
	)
}

