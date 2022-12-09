package com.example.profilepage

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.profilepage.ui.theme.ProfilePageTheme
import com.google.accompanist.systemuicontroller.SystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,

                    ) {
                    Image(
                        painterResource(R.drawable.husky_dog), null,
                        contentScale = ContentScale.Crop,
                    )
                    Box(
                        Modifier.background(
                            Brush.horizontalGradient(
                                listOf(
                                    MaterialTheme.colors.background,
                                    MaterialTheme.colors.background
                                )
                            ), RectangleShape, 0.92f
                        )
                    )
                    MainController(this)
                }
            }
        }
    }
}

@Composable
fun MainController(
    context: Context,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "profile"
){
    //the nav host manages the navigation graph builder
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable("profile"){
            ProfileUI(
                context,
                onNavigateToDetailsList = {
                    navController.navigate("detailList"){
                        //managing the backstack after navigating to the details composable
                        popUpTo("profile") {
                            inclusive = true //this exits the profile from the backstack
                        }
                    }
                }
            )
        }
        composable("detailList"){
            DetailsList(context)
        }
    }
}

@Composable
fun ProfileUI(
    context: Context,
    onNavigateToDetailsList: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.husky_dog),
            contentDescription = "dog",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colors.primary, CircleShape),
            contentScale = ContentScale.Crop
        )
//      spacer is used to create a space of a given density btn elements
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Husky Dog",
            fontFamily = FontFamily.Monospace,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            softWrap = true,
            color = MaterialTheme.colors.primary
        )
        Text(
            text = "Germany Most humble Dog",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.secondary
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            ProfileStatus(1120, "Following")
            ProfileStatus(21220, "Followers")
            ProfileStatus(20, "Likes")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth(.5f)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                onClick = onNavigateToDetailsList
//                    Toast.makeText(context, "Thanks For following Me", Toast.LENGTH_LONG).show(
            ) {
                Text(text = "View")
            }
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                onClick = {
                    Toast.makeText(context, "Thanks For following Me", Toast.LENGTH_LONG).show()
                }) {
                Text(text = "Follow")
            }
        }

    }
}

@Composable
fun ProfileStatus(count: Int, type: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$count",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
        )
        Text(text = "$type")
    }
}


@Composable
fun DetailsList(context: Context) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.padding(top = 100.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.husky_dog),
            contentDescription = "dog",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
//      spacer is used to create a space of a given density btn elements
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Husky Dog",
            fontFamily = FontFamily.Monospace,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            softWrap = true,
            color = MaterialTheme.colors.primary
        )
        Text(
            text = "Germany Most humble Dog",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.secondary
        )

    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ProfilePageTheme {
//        DetailsList()
//    }
//}