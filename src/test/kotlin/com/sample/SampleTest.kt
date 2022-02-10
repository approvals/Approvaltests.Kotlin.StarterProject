package com.sample

import org.approvaltests.Approvals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SampleTests {
    @Test
    fun testNormalJunit() {
        Assertions.assertEquals(5, 5)
    }

    @Test
    fun testWithApprovalTests() {
        Approvals.verify("Hello World")
    }

    /**
     * note: this requires GSON which is currently added in the pom.xml file.
     * This is only required if you want to use the VerifyAsJson.
     */
    @Test
    fun testJson() {
        val hero = Person("jayne", "cobb", true, 38)
        Approvals.verifyAsJson(hero)
    }
}