package com.paulklauser.composefun

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.paulklauser.composefun.ui.theme.ComposeFunTheme
import org.junit.Rule
import org.junit.Test

class BabysFirstComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test() {
        composeTestRule.setContent {
            ComposeFunTheme {
                MainScreen(
                    mainViewModel = MainViewModel(
                        listOf(
                            MaintenanceItem(
                                "Title",
                                "Date",
                                "Mileage"
                            )
                        )
                    ),
                    {}
                )
            }
        }
        composeTestRule.onNodeWithTag("rowTitle", true).assertTextEquals("Title")
    }

}