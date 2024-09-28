package com.vinayshenoy.json_parser.test

import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.test.Test

class CanaryTest {

    @Test
    fun `it should be able to run tests`() {
        expectThat(2 + 2).isEqualTo(4)
    }
}