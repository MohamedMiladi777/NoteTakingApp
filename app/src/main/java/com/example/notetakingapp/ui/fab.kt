package com.example.notetakingapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

class fab {

    @Composable
    fun NoteFab(onClick : () -> Unit){
        FloatingActionButton(onClick = {onClick()}){
            Icon(Icons.Filled.Add, "Note taking button" )
        }
        
    }
}