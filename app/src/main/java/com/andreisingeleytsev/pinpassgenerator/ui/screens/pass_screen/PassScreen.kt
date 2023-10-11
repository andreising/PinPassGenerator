package com.andreisingeleytsev.pinpassgenerator.ui.screens.pass_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreisingeleytsev.pinpassgenerator.R
import com.andreisingeleytsev.pinpassgenerator.ui.screens.pin_screen.Indexes
import com.andreisingeleytsev.pinpassgenerator.ui.screens.pin_screen.PinScreenEvent
import com.andreisingeleytsev.pinpassgenerator.ui.theme.MainColor
import com.andreisingeleytsev.pinpassgenerator.ui.utils.PinPassAppFonts

@Composable
fun PassScreen(viewModel: PassScreenViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.pass_img),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 70.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.letters).capitalize(Locale.current),
                    style = TextStyle(
                        color = MainColor,
                        fontSize = 12.sp,
                        fontFamily = PinPassAppFonts.font
                    )
                )
                Card(
                    elevation = CardDefaults.cardElevation(
                        6.dp
                    ), colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ), shape = RoundedCornerShape(28.dp)
                ) {
                    Switch(
                        checked = viewModel.switchByLetters.value,
                        onCheckedChange = { viewModel.onEvent(PassScreenEvent.OnSwitchPressed(0)) },
                        thumbContent = {
                            Icon(
                                imageVector = if (viewModel.switchByLetters.value) Icons.Default.Done
                                else Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.White
                            )
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.Green.copy(alpha = 0.4F),
                            uncheckedThumbColor = Color.Red.copy(alpha = 0.4F),
                            checkedTrackColor = Color.White,
                            uncheckedTrackColor = Color.White,
                            checkedBorderColor = Color.White,
                            uncheckedBorderColor = Color.White
                        ), modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.numbers).capitalize(Locale.current),
                    style = TextStyle(
                        color = MainColor,
                        fontSize = 12.sp,
                        fontFamily = PinPassAppFonts.font
                    )
                )
                Card(
                    elevation = CardDefaults.cardElevation(
                        6.dp
                    ), colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ), shape = RoundedCornerShape(28.dp)
                ) {
                    Switch(
                        checked = viewModel.switchByNumbers.value,
                        onCheckedChange = { viewModel.onEvent(PassScreenEvent.OnSwitchPressed(2)) },
                        thumbContent = {
                            Icon(
                                imageVector = if (viewModel.switchByNumbers.value) Icons.Default.Done
                                else Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.White
                            )
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.Green.copy(alpha = 0.4F),
                            uncheckedThumbColor = Color.Red.copy(alpha = 0.4F),
                            checkedTrackColor = Color.White,
                            uncheckedTrackColor = Color.White,
                            checkedBorderColor = Color.White,
                            uncheckedBorderColor = Color.White
                        ), modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(13.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.symbols),
                    style = TextStyle(
                        color = MainColor,
                        fontSize = 12.sp,
                        fontFamily = PinPassAppFonts.font
                    )
                )
                Card(
                    elevation = CardDefaults.cardElevation(
                        6.dp
                    ), colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ), shape = RoundedCornerShape(28.dp)
                ) {
                    Switch(
                        checked = viewModel.switchBySymbols.value,
                        onCheckedChange = { viewModel.onEvent(PassScreenEvent.OnSwitchPressed(1)) },
                        thumbContent = {
                            Icon(
                                imageVector = if (viewModel.switchBySymbols.value) Icons.Default.Done
                                else Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.White
                            )
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.Green.copy(alpha = 0.4F),
                            uncheckedThumbColor = Color.Red.copy(alpha = 0.4F),
                            checkedTrackColor = Color.White,
                            uncheckedTrackColor = Color.White,
                            checkedBorderColor = Color.White,
                            uncheckedBorderColor = Color.White
                        ), modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.cap_letters).capitalize(Locale.current),
                    style = TextStyle(
                        color = MainColor,
                        fontSize = 12.sp,
                        fontFamily = PinPassAppFonts.font
                    )
                )
                Card(
                    elevation = CardDefaults.cardElevation(
                        6.dp
                    ), colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ), shape = RoundedCornerShape(28.dp)
                ) {
                    Switch(
                        checked = viewModel.switchByCapitals.value,
                        onCheckedChange = { viewModel.onEvent(PassScreenEvent.OnSwitchPressed(3)) },
                        thumbContent = {
                            Icon(
                                imageVector = if (viewModel.switchByCapitals.value) Icons.Default.Done
                                else Icons.Default.Close,
                                contentDescription = null,
                                tint = Color.White
                            )
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.Green.copy(alpha = 0.4F),
                            uncheckedThumbColor = Color.Red.copy(alpha = 0.4F),
                            checkedTrackColor = Color.White,
                            uncheckedTrackColor = Color.White,
                            checkedBorderColor = Color.White,
                            uncheckedBorderColor = Color.White
                        ), modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Card(
                elevation = CardDefaults.cardElevation(
                    6.dp
                ), colors = CardDefaults.cardColors(
                    containerColor = if (viewModel.currentLength.value == 4) MainColor
                    else Color.White
                ), modifier = Modifier.clickable {
                    viewModel.onEvent(PassScreenEvent.OnLengthChose(4))
                }
            ) {
                Text(
                    text = (4).toString(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = PinPassAppFonts.font
                    ), modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Card(
                elevation = CardDefaults.cardElevation(
                    6.dp
                ), colors = CardDefaults.cardColors(
                    containerColor = if (viewModel.currentLength.value == 6) MainColor
                    else Color.White
                ), modifier = Modifier.clickable {
                    viewModel.onEvent(PassScreenEvent.OnLengthChose(6))
                }
            ) {
                Text(
                    text = (6).toString(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = PinPassAppFonts.font
                    ), modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Card(
                elevation = CardDefaults.cardElevation(
                    6.dp
                ), colors = CardDefaults.cardColors(
                    containerColor = if (viewModel.currentLength.value == 8) MainColor
                    else Color.White
                ), modifier = Modifier.clickable {
                    viewModel.onEvent(PassScreenEvent.OnLengthChose(8))
                }
            ) {
                Text(
                    text = (8).toString(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = PinPassAppFonts.font
                    ), modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Card(
                elevation = CardDefaults.cardElevation(
                    6.dp
                ), colors = CardDefaults.cardColors(
                    containerColor = if (viewModel.currentLength.value == 12) MainColor
                    else Color.White
                ), modifier = Modifier.clickable {
                    viewModel.onEvent(PassScreenEvent.OnLengthChose(12))
                }
            ) {
                Text(
                    text = (12).toString(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontFamily = PinPassAppFonts.font
                    ), modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            elevation = CardDefaults.cardElevation(
                6.dp
            ), colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = viewModel.currentPass.value, style = TextStyle(
                        color = MainColor,
                        fontSize = 24.sp,
                        fontFamily = PinPassAppFonts.font,
                        fontWeight = FontWeight.Bold
                    )
                )
                IconButton(onClick = { viewModel.onEvent(PassScreenEvent.OnCopyCode) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_copy),
                        contentDescription = null,
                        tint = MainColor
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                viewModel.onEvent(PassScreenEvent.OnGenerateCode)
            }, colors = ButtonDefaults.buttonColors(
                containerColor = MainColor
            )
        ) {
            Text(
                text = stringResource(R.string.generate_a_password), style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = PinPassAppFonts.font
                )
            )
        }
    }
}