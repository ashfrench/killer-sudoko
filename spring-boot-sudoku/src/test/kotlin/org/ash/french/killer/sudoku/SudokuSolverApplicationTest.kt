package org.ash.french.killer.sudoku

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.client.getForEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SudokuSolverApplicationTest {
    private val restTemplate = RestTemplateBuilder().build()

    @Test
    fun `can load spring context`() {
        assert(true) { "Spring Failed to Start" }
    }

    @Test
    fun `test swagger page is up`() {
        restTemplate.getForEntity<String>("http://localhost:8080/swagger-ui/index.html").apply {
            assert(statusCode.is2xxSuccessful) { "Swagger Page is not up" }
        }
    }
}
