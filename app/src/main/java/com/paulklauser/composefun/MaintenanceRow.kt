package com.paulklauser.composefun

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulklauser.composefun.ui.theme.ComposeFunTheme

@Composable
fun MaintenanceRow(
    title: String,
    installDate: String,
    mileage: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
            .clickable { onClick() },
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_android_black_24dp),
            contentDescription = "Icon!",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .height(86.dp)
                .aspectRatio(1f),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            MyText(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.testTag("rowTitle")
            )
            MyText(text = installDate)
            MyText(text = mileage)
        }
    }
}

@Composable
fun MyText(
    text: String,
    fontWeight: FontWeight? = null,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        color = MaterialTheme.colors.contentColorFor(MaterialTheme.colors.background),
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposeFunTheme {
        MaintenanceRow(
            title = "Michelin Pilot Sport",
            installDate = "10/17/22",
            mileage = "121,250 Miles"
        ) {}
    }
}