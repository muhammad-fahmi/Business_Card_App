package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                Modifier.fillMaxSize(),
                color = Color(0xFFD2E8D4)
            ) {
                BusinessCardLayout()
            }
        }
    }
}

@Composable
fun CompanyInfoSection(
    image: Painter,
    description: String,
    name: String,
    title: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = description,
            modifier = Modifier
                .size(150.dp, 150.dp)
                .clip(RoundedCornerShape(50))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = name,
            fontWeight = FontWeight.Light,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            fontSize = 12.sp,
            color = Color(0xFF278355)
        )
    }
}

@Composable
fun ContactInfoSection(
    phoneNumber: String,
    socialMedia: String,
    emailText: String
) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 64.dp)
    ) {
        Column(modifier = Modifier.padding(start = 32.dp)) {
            Row() {
                Icon(
                    Icons.Rounded.Phone,
                    contentDescription = "Phone Icon",
                    tint = Color(0xFF278355)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = phoneNumber)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row() {
                Icon(
                    Icons.Rounded.Share,
                    contentDescription = "Sahre Icon",
                    tint = Color(0xFF278355)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = socialMedia)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row() {
                Icon(
                    Icons.Rounded.Email,
                    contentDescription = "Email Icon",
                    tint = Color(0xFF278355)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = emailText)
            }
        }
    }
}

@Composable
fun BusinessCardLayout() {
    val image = painterResource(id = R.drawable.zanimal)
    val description = stringResource(id = R.string.image_description)


    CompanyInfoSection(
        image = image,
        description = description,
        name = "Muhammad Fahmi",
        title = "Animal Consultant Expert"
    )
    ContactInfoSection(
        "+62 87335302429",
        "@ZanimalConsultant",
        "zanimalconsultant@gov.en"
    )

}

@Preview
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme() {
        Surface(
            Modifier.fillMaxSize(),
            color = Color(0xFFD2E8D4)
        ) {
            BusinessCardLayout()
        }
    }

}