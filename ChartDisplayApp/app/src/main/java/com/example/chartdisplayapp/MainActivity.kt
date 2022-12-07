package com.example.chartdisplayapp

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.layout.FixedScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.chartdisplayapp.ui.theme.ChartDisplayAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChartDisplayAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MessageCard("William", "William is tall")
                }
            }
        }
    }
}

data class Message(val name: String, val desc: String)

@Composable
fun MessageCard(name: String, desc: String){
    Surface(
        Modifier
            .fillMaxWidth()
    ) {
        Row(Modifier.height(100.dp)) {
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(R.drawable.pro_pic),
                contentDescription = "Profile Picture",
                Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Black, CircleShape)
            )
//            spacer with a param "width" is used for creating space on the right/end of 
//            of a component.
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.height(100.dp),
            ) {
                Text(text = "Hello $name")
                Spacer(modifier = Modifier.height(10.dp))
                Box(){
                    Arrangement.Bottom
                    Text(
                        text = "Hello $desc"
                    )
                }

            }
        }

    }

}

@Composable
fun Displays(){
    val msg = Message("Williams", "William is tall")
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
    ){
        MessageCard(msg.name, msg.desc)

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard(){
    Displays()
}
