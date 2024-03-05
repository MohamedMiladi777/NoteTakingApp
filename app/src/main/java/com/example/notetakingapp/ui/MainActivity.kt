package com.example.notetakingapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notetakingapp.R
import com.example.notetakingapp.repository.NoteTakingAppScreen
import com.example.notetakingapp.repository.NotesViewModel
import com.example.notetakingapp.ui.theme.NoteTakingAppTheme





@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(onNavigateToNotes: () -> Unit) {
    Scaffold(
        topBar = {
            val context = LocalContext.current
            CenterAlignedTopAppBar(
                title = {
                    Text("Miladys")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Test", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(Icons.Filled.Search, "Go back")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Menu, "Burger menu")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Add, "Add Button") },
                text = { Text("Add") },
                onClick = { onNavigateToNotes() }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {}
    }
}


@Composable
fun NotesStateHoisting(onNavigateToHome: () -> Unit, notesViewModel: NotesViewModel = viewModel()) {
    val titleText: String by notesViewModel.titleText.observeAsState("")
    val contentText: String by notesViewModel.contentText.observeAsState("")
    Notes(
        onNavigateToHome = {},
        titleText = titleText,
        contentText = contentText,
        onTitleChange = { notesViewModel.newNote(it) },
        onContentChange = { notesViewModel.newContentText(it) }
    )
}

//*********************************UsingStateHoisting*****************************
//@Composable
//fun NotesStateHoisting(onNavigateToHome : () -> Unit){
//    var titleText:String by rememberSaveable { mutableStateOf("") }
//    var contentText:String by rememberSaveable { mutableStateOf("") }
//    Notes(
//        onNavigateToHome = {},
//        titleText = titleText,
//        contentText = contentText ,
//        onTitleChange = {titleText = it}  ,
//        onContentChange = {contentText = it}
//    )
//}
//*********************************UsingStateHoisting*****************************


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notes(
    onNavigateToHome: () -> Unit, titleText: String, contentText: String,
    onTitleChange: (String) -> Unit, onContentChange: (String) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(

                title = { Text(text = "Miladys") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "Go back")
                    }

                }
            )
        },
//When clicking save title and content goes to Home screen
        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Check, "Save Button") },
                text = { Text("Save") },
                onClick = { onNavigateToHome() }

            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            //OutLinedAddTitleField()
            //OutlinedAddTextField()
            OutlinedTextField(
                value = titleText,
                onValueChange = { newValue -> onTitleChange(newValue) },
                label = { Text("Add a title") },
                enabled = true,
                keyboardActions = KeyboardActions.Default
            )
            OutlinedTextField(
                value = contentText,
                onValueChange = { newValue -> onContentChange(newValue) },
                label = { Text("Add content") }

            )

        }

    }


}

//@Composable
//fun OutLinedAddTitleField() {
//    //This keeps the composable tightly coupled and hard to test => We use state hoisting
//    var text: String by rememberSaveable { mutableStateOf("") }
//    OutlinedTextField(
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("Add a title") },
//        enabled = true,
//        keyboardActions = KeyboardActions.Default
//    )
//}
//
//@Composable
//fun OutlinedAddTextField() {
//    var text by rememberSaveable { mutableStateOf("") }
//    OutlinedTextField(
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("Add content") }
//
//    )
//}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteTakingAppTheme {
        //NotesStateHoisting {}
    }
}