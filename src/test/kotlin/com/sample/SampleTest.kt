package com.sample

import org.approvaltests.Approvals
import org.approvaltests.JsonApprovals
import org.approvaltests.combinations.CombinationApprovals
import org.approvaltests.integrations.junit5.JupiterApprovals
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class SampleTests {
    @Test
    fun testNormalJunit() {
        Assertions.assertEquals(5, 5)
    }

    @Test
    fun testWithApprovalTests() {
        Approvals.verify("Hello World")
    }

    @Test
    fun testCombinations() {
        val numbers = arrayOf(10, 20, 30, 40, 50)
        CombinationApprovals.verifyAllCombinations({ a, b -> "$a + $b" }, numbers, numbers)
    }

    /**
     * note: this requires GSON which is currently added in the pom.xml file.
     * This is only required if you want to use the VerifyAsJson.
     */
    @Test
    fun testJson() {
        val hero = Person("jayne", "cobb", true, 38)
        JsonApprovals.verifyAsJson(hero)
    }

    // begin_snippet: kotlin_dynamic_test
    @TestFactory
    fun `test factory`(): List<DynamicTest> {
        return listOf(1, 2).map { it ->
            JupiterApprovals.dynamicTest("square $it") {
                    o -> Approvals.verify("${it}^2 = ${it * it}", o)
            }
        }
    }
    // end_snippet

}