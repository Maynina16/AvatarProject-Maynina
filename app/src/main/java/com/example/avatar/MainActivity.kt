package com.example.avatar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avatar.ui.theme.AvatarTheme
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AvatarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AvatarScreen(
                        onBack = { finish() },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AvatarScreen(onBack: () -> Unit, modifier: Modifier = Modifier) {
    var showEyes by remember { mutableStateOf(true) }
    var showNose by remember { mutableStateOf(true) }
    var showMouth by remember { mutableStateOf(true) }
    var showBrows by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Bagian Avatar
        Box(
            modifier = Modifier
                .size(280.dp),
            contentAlignment = Alignment.Center
        ) {
            // Base wajah
            Image(
                painter = painterResource(id = R.drawable.face_0004),
                contentDescription = "Base"
            )

            // Brow
            if (showBrows) {
                Image(
                    painter = painterResource(id = R.drawable.face_0001),
                    contentDescription = "Brow",
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 45.dp)
                )
            }

            // Eye
            if (showEyes) {
                Image(
                    painter = painterResource(id = R.drawable.face_0003),
                    contentDescription = "Eye",
                    modifier = Modifier
                        .size(110.dp)
                        .align(Alignment.Center)
                )
            }

            // Nose
            if (showNose) {
                Image(
                    painter = painterResource(id = R.drawable.face_0002),
                    contentDescription = "Nose",
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.Center)
                        .offset(y = 20.dp) // agak turun ke bawah
                )
            }

            // Mouth
            if (showMouth) {
                Image(
                    painter = painterResource(id = R.drawable.face_0000),
                    contentDescription = "Mouth",
                    modifier = Modifier
                        .size(70.dp)
                        .align(Alignment.BottomCenter)
                        .offset(y = (-50).dp)
                )
            }
        }

        // Checkbox controls (horizontal row)
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.widthIn(min = 40.dp)
            ) {
                Checkbox(checked = showBrows, onCheckedChange = { showBrows = it })
                Text("Brow", fontSize = 12.sp)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.widthIn(min = 40.dp)
            ) {
                Checkbox(checked = showEyes, onCheckedChange = { showEyes = it })
                Text("Eye", fontSize = 12.sp)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.widthIn(min = 40.dp)
            ) {
                Checkbox(checked = showNose, onCheckedChange = { showNose = it })
                Text("Nose", fontSize = 12.sp)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.widthIn(min = 40.dp)
            ) {
                Checkbox(checked = showMouth, onCheckedChange = { showMouth = it })
                Text("Mouth", fontSize = 12.sp)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AvatarPreview() {
    AvatarTheme {
        AvatarScreen(
            onBack = {},
            modifier = Modifier
        )
    }
}

