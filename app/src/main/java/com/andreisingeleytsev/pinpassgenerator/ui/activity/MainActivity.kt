package com.andreisingeleytsev.pinpassgenerator.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.pinpassgenerator.R
import com.andreisingeleytsev.pinpassgenerator.ui.navigation.PinPassAppMainNavigationGraph
import com.andreisingeleytsev.pinpassgenerator.ui.theme.MainColor
import com.andreisingeleytsev.pinpassgenerator.ui.utils.PinPassAppFonts
import com.andreisingeleytsev.pinpassgenerator.ui.utils.Routes
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navHostController = rememberNavController()
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            if (!viewModel.isLoading.value) {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    if (currentRoute == Routes.PIN_SCREEN || currentRoute == Routes.PASS_SCREEN) CenterAlignedTopAppBar(
                        title = {

                            Text(
                                text = stringResource(
                                    id = if (currentRoute == Routes.PIN_SCREEN) R.string.pin
                                    else R.string.pass
                                ), style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontFamily = PinPassAppFonts.font,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }, navigationIcon = {
                            IconButton(onClick = { navHostController.popBackStack() }) {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowLeft,
                                    contentDescription = null,
                                    tint = Color.Black
                                )
                            }
                        })
                }) {
                    Box(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize()
                    ) {
                        PinPassAppMainNavigationGraph(
                            navHostController = navHostController,
                            startDestination = viewModel.startDestination.value!!
                        ) { viewModel.onBoardFinished() }
                    }
                }
            }
        }
    }
}