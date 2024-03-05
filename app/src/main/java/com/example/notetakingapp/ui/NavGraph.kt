package com.example.notetakingapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notetakingapp.repository.NoteTakingAppScreen

@Composable
fun MiladysApp() {
    //************************1-Creating a NAV controller-1 : *************
    //holds the navigation graph and exposes methods that allow your app
    // to move between the destinations in the graph.
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NoteTakingAppScreen.Main.name) {
        composable(NoteTakingAppScreen.Main.name) {
            Home(onNavigateToNotes = {
                navController.navigate(NoteTakingAppScreen.Notes.name)
            })
        }
        composable(NoteTakingAppScreen.Notes.name) {
            NotesStateHoisting(onNavigateToHome = { navController.navigate(NoteTakingAppScreen.Main.name) })
        }


    }
}