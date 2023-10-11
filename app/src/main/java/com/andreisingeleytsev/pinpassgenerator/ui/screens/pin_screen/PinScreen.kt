package com.andreisingeleytsev.pinpassgenerator.ui.screens.pin_screen

import androidx.activity.compose.BackHandler
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.pinpassgenerator.R
import com.andreisingeleytsev.pinpassgenerator.ui.theme.MainColor
import com.andreisingeleytsev.pinpassgenerator.ui.utils.PinPassAppFonts

@Composable
fun PinScreen(navHostController: NavHostController, viewModel: PinScreenViewModel = hiltViewModel()) {
    if (viewModel.isFirstScreen.value) ChoosePin()
    else PinGenerator()
    BackHandler {
        if (viewModel.isFirstScreen.value) navHostController.popBackStack()
        else viewModel.isFirstScreen.value = true
    }
}

@Composable
fun ChoosePin(viewModel: PinScreenViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.pin_img),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 70.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(50.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.onEvent(PinScreenEvent.OnPinChose(Indexes.Light))
                }, elevation = CardDefaults.cardElevation(
                6.dp
            ), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(28.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.pin_code), style = TextStyle(
                            color = MainColor,
                            fontSize = 18.sp,
                            fontFamily = PinPassAppFonts.font
                        )
                    )
                    Text(
                        text = 4.toString() + stringResource(R.string.characters),
                        style = TextStyle(
                            color = MainColor,
                            fontSize = 18.sp,
                            fontFamily = PinPassAppFonts.font
                        )
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.icon_lock),
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.onEvent(PinScreenEvent.OnPinChose(Indexes.Medium))
                }, elevation = CardDefaults.cardElevation(
                6.dp
            ), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(28.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.pin_code), style = TextStyle(
                            color = MainColor,
                            fontSize = 18.sp,
                            fontFamily = PinPassAppFonts.font
                        )
                    )
                    Text(
                        text = 6.toString() + stringResource(R.string.characters),
                        style = TextStyle(
                            color = MainColor,
                            fontSize = 18.sp,
                            fontFamily = PinPassAppFonts.font
                        )
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.icon_lock),
                    contentDescription = null,
                    tint = Color.Yellow
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    viewModel.onEvent(PinScreenEvent.OnPinChose(Indexes.Hard))
                }, elevation = CardDefaults.cardElevation(
                6.dp
            ), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(28.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 14.dp, vertical = 20.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = stringResource(R.string.pin_code), style = TextStyle(
                            color = MainColor,
                            fontSize = 18.sp,
                            fontFamily = PinPassAppFonts.font
                        )
                    )
                    Text(
                        text = 8.toString() + stringResource(R.string.characters),
                        style = TextStyle(
                            color = MainColor,
                            fontSize = 18.sp,
                            fontFamily = PinPassAppFonts.font
                        )
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.icon_lock),
                    contentDescription = null,
                    tint = Color.Green
                )
            }
        }
    }
}

@Composable
fun PinGenerator(viewModel: PinScreenViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 50.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.pin_img),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(90.dp))
        Card(
            elevation = CardDefaults.cardElevation(
                6.dp
            ), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = viewModel.currentPin.value, style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontFamily = PinPassAppFonts.font,
                    fontWeight = FontWeight.Bold
                ), modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            viewModel.onEvent(PinScreenEvent.OnCopyCode)
        }, colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        )) {
            Text(
                text = stringResource(R.string.copy_code), style = TextStyle(
                    color = MainColor,
                    fontSize = 12.sp,
                    fontFamily = PinPassAppFonts.font
                )
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = {
                viewModel.onEvent(PinScreenEvent.OnGenerateCode)

            }, colors = ButtonDefaults.buttonColors(
                containerColor = MainColor
            )
        ) {
            Text(
                text = stringResource(R.string.generate_a_pin_code), style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = PinPassAppFonts.font
                )
            )
        }
    }
}