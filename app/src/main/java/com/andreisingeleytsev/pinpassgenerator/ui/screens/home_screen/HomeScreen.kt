package com.andreisingeleytsev.pinpassgenerator.ui.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.pinpassgenerator.R
import com.andreisingeleytsev.pinpassgenerator.ui.theme.MainColor
import com.andreisingeleytsev.pinpassgenerator.ui.utils.PinPassAppFonts
import com.andreisingeleytsev.pinpassgenerator.ui.utils.Routes

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.pass_img),
            contentDescription = null,
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navHostController.navigate(Routes.PIN_SCREEN)
                }, elevation = CardDefaults.cardElevation(
                6.dp
            ), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(28.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pin_img),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = stringResource(R.string.pin_code), style = TextStyle(
                        color = MainColor,
                        fontSize = 34.sp,
                        fontFamily = PinPassAppFonts.font
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navHostController.navigate(Routes.PASS_SCREEN)
                }, elevation = CardDefaults.cardElevation(
                6.dp
            ), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(28.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pass_img),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = stringResource(R.string.password), style = TextStyle(
                        color = MainColor,
                        fontSize = 34.sp,
                        fontFamily = PinPassAppFonts.font
                    )
                )
            }
        }
    }
}