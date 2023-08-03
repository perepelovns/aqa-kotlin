package com.example.quiz.suites

import io.restassured.RestAssured.*
import org.junit.Test


class Test_API {

    private val BASE_URL = "https://pokeapi.co/api/v2"

    @Test
    fun testGetPokemonInfo() {
        val pokemonName = "ditto"

        given()
            .baseUri(BASE_URL)
            .`when`()
            .get("/pokemon/$pokemonName")
            .then()
            .statusCode(200)
    }
}
