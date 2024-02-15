package com.example.notetakingapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notetakingapp.ui.theme.NoteTakingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTakingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    MiladysApp()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MiladysApp() {

    //************************1-Creating a NAV controller-1 : *************
    //holds the navigation graph and exposes methods that allow your app
    // to move between the destinations in the graph.
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            Home(onNavigateToNotes = { navController.navigate("notes") })
        }
        composable("Notes") { Notes(onNavigateToHome = { navController.navigate("home") }) }


    }
}

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
        Column(modifier = Modifier.padding(innerPadding)) {
//       Text("اللهم يسر و أعن")
//       Text("This is a note taking Application")
//       Text("This is a test message")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Notes(onNavigateToHome: () -> Unit) {
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

        floatingActionButton = {
            ExtendedFloatingActionButton(
                icon = { Icon(Icons.Filled.Check, "Save Button") },
                text = { Text("Save") },
                onClick = { onNavigateToHome() }

            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            OutLinedAddTitleField()
            OutlinedAddTextField()
            //Text("Add action to be implemented")
        }

    }


}

@Composable
fun OutLinedAddTitleField(){
    var text by remember {mutableStateOf("")}
    OutlinedTextField(
        value = text,
        onValueChange = {text = it},
        label = {Text("Add a title")},
        enabled = true,
        keyboardActions = KeyboardActions.Default
    )
}
@Composable
fun OutlinedAddTextField(){
    var text by remember {mutableStateOf("")}
    OutlinedTextField(
        value = text,
        onValueChange = {text = it},
        label = {Text("Add content")}

    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteTakingAppTheme {
        Greeting("Android")
    }
}