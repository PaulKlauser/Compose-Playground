package com.paulklauser.composefun

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.paulklauser.composefun.ui.theme.ComposeFunTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RobolectricTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test() {
        composeTestRule.setContent {
            ComposeFunTheme {
                MainScreen(
                    mainViewModel = MainViewModel(
                        FakeMaintenanceRepository(
                            listOf(
                                MaintenanceItem(
                                    "Title",
                                    "Date",
                                    "Mileage"
                                )
                            )
                        )
                    )
                ) {}
            }
        }
        composeTestRule.onNodeWithTag("rowTitle", true).assertTextEquals("Title")
    }

}