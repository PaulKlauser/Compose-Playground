package com.paulklauser.composefun

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun details_displayed_with_valid_id() {
        composeTestRule.setContent {
            DetailScreen(
                viewModel = DetailViewModel(
                    SavedStateHandle.createHandle(
                        defaultState = bundleOf(DETAIL_ID_KEY to "1"),
                        restoredState = null
                    ),
                    FakeMaintenanceRepository(
                        listOf(
                            MaintenanceItem(
                                "1",
                                "Title",
                                "Date",
                                "Mileage"
                            )
                        )
                    )
                ),
                goBack = {}
            )
        }
        composeTestRule.onNodeWithTag("title").assertTextEquals("Title")
    }

    @Test
    fun details_not_displayed_with_invalid_id() {
        composeTestRule.setContent {
            DetailScreen(
                viewModel = DetailViewModel(
                    SavedStateHandle.createHandle(
                        defaultState = bundleOf(DETAIL_ID_KEY to "2"),
                        restoredState = null
                    ),
                    FakeMaintenanceRepository(
                        listOf(
                            MaintenanceItem(
                                "1",
                                "Title",
                                "Date",
                                "Mileage"
                            )
                        )
                    )
                ),
                goBack = {}
            )
        }
        composeTestRule.onNodeWithTag("title").assertDoesNotExist()
    }
}