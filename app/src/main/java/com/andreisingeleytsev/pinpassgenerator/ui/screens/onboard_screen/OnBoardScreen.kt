package com.andreisingeleytsev.pinpassgenerator.ui.screens.onboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.pinpassgenerator.R
import com.andreisingeleytsev.pinpassgenerator.ui.theme.MainColor
import com.andreisingeleytsev.pinpassgenerator.ui.utils.PinPassAppFonts
import com.andreisingeleytsev.pinpassgenerator.ui.utils.Routes

@Composable
fun OnBoardScreen(navHostController: NavHostController, onClick: ()-> Unit) {
    Column(Modifier.padding(40.dp).fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(id = R.drawable.pass_img),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = stringResource(R.string.onboard_title), style = TextStyle(
                color = MainColor,
                fontSize = 16.sp,
                fontFamily = PinPassAppFonts.font,
                textAlign = TextAlign.Center
            ), modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {
                onClick.invoke()
                navHostController.popBackStack()
                navHostController.navigate(Routes.HOME_SCREEN)
            }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {
            Text(
                text = stringResource(R.string.start).capitalize(Locale.current), style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = PinPassAppFonts.font
                )
            )
        }
    }
}