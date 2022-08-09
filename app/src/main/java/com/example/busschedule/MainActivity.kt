/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.busschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.busschedule.ui.fullschedule.FullScheduleScreen
import com.example.busschedule.ui.stopschedule.StopScheduleScreen
import com.example.mealz.ui.theme.MealzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzTheme {
                BusScheduleApp()
            }
        }
    }

}

@Composable
private fun BusScheduleApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "full_schedule") {
        composable(route = "full_schedule") {
            FullScheduleScreen { stopName ->
                navController.navigate("stop_schedule/${stopName}")
            }
        }

        composable(
            route = "stop_schedule/{stop_name}",
            arguments = listOf(navArgument("stop_name") {
                type = NavType.StringType
            })
        ) {
           StopScheduleScreen()
        }
    }
}
