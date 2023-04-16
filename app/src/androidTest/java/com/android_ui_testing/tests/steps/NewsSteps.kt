package com.android_ui_testing.tests.steps

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.interaction.BaristaClickInteractions.clickOn
import com.adevinta.android.barista.interaction.BaristaEditTextInteractions.writeTo
import com.android_ui_testing.NewsActivity
import io.cucumber.core.api.Scenario
import io.cucumber.java8.En
import org.junit.runner.RunWith
import com.android_ui_testing.R

@RunWith(AndroidJUnit4::class)
class NewsSteps : En {

    private var newsScenario: ActivityScenario<NewsActivity>? = null

    private fun before() {
        //initial setup code
    }

    private fun after() {
        //clean up code
        newsScenario?.close()
    }

    init {
        Before { _: Scenario ->
            before()
        }
        After { _: Scenario ->
            after()
        }

        Given("The app started") {
            newsScenario = launchActivity()
        }

        Then("I see News list screen") {
            assertRecyclerViewItemCount(
                R.id.rvNews,
                expectedItemCount = 10
            )
        }

        When("I input {string} in search box") { wording: String ->
            writeTo(
                R.id.edtSearch,
                wording
            )
        }

        And("I click on search button") {
            clickOn(R.id.btnSearch)
        }

        Then("I see only {int} news") { number: Int ->
            assertRecyclerViewItemCount(
                R.id.rvNews,
                expectedItemCount = number
            )
        }

        Then("I see {string} on screen") { wording: String ->
            assertDisplayed(wording)
        }
    }
}