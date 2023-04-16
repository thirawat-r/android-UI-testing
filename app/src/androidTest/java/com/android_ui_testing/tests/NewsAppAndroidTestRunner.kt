package com.android_ui_testing.tests

import io.cucumber.android.runner.CucumberAndroidJUnitRunner
import io.cucumber.junit.CucumberOptions

@CucumberOptions(
    features = ["features"],
    glue = ["com.android_ui_testing.tests.steps"],
    tags = ["~@wip"]
)
class NewsAppAndroidTestRunner : CucumberAndroidJUnitRunner()