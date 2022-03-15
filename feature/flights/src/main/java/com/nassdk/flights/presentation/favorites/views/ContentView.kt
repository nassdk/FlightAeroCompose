package com.nassdk.flights.presentation.favorites.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nassdk.flights.domain.entity.FlightEntity

@Composable
internal fun ContentView(
    content: List<FlightEntity>,
    onFlightSelect: (FlightEntity) -> Unit,
) {

    LazyColumn(
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp),
        modifier = Modifier.fillMaxSize(),
        content = {
            content.forEach { model ->
                item {
                    FlightItem(
                        model = model,
                        onFlightSelect = {
                            onFlightSelect.invoke(model)
                        }
                    )
                }
            }
        }
    )
}