package com.example.busschedule.ui.stopschedule

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.busschedule.database.schedule.Schedule
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun StopScheduleScreen(
    viewModel: StopScheduleViewModel = hiltViewModel(),
    navCallback: (String) -> Unit = { }
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Stop Name",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Arrival Time",
                style = MaterialTheme.typography.h6
            )
        }
        LazyColumn {
            items(viewModel.schedule.value) { item: Schedule ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = item.stopName, style = MaterialTheme.typography.h6)
                    Text(
                        text = SimpleDateFormat("h:mm a").format(
                            Date(item.arrivalTime.toLong() * 1000)
                        ),
                        style = MaterialTheme.typography.h5
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    StopScheduleScreen()
}