package com.nassdk.flights.presentation.list.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nassdk.common.helpers.ItemUi
import com.nassdk.flights.domain.entity.FlightEntity
import com.nassdk.flights.presentation.list.ui.FlightsListModel

@Composable
internal fun ContentView(
    content: List<ItemUi>,
    loadNextPage: () -> Unit,
    onFlightSelect: (FlightEntity) -> Unit,
) {

    LazyColumn(
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 12.dp),
        modifier = Modifier.fillMaxSize(),
        content = {

            itemsIndexed(items = content) { index, item ->
                if (index == content.lastIndex) {
                    SideEffect(
                        effect = {
                            loadNextPage.invoke()
                        }
                    )
                }

                when (item) {
                    is FlightsListModel.Loading -> LoadingItem()
                    is FlightsListModel.Flight -> FlightItem(
                        model = item,
                        onFlightSelect = onFlightSelect
                    )
                }
            }
        }
    )
}