package com.github.sendiko.kostgoadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.sendiko.kostgoadmin.login.presentation.LoginViewModel
import com.github.sendiko.kostgoadmin.navigation.LoginDestination
import com.github.sendiko.kostgoandroid.core.ui.theme.KostgoandroidTheme
import androidx.compose.runtime.getValue
import com.github.sendiko.kostgoadmin.login.presentation.LoginScreen
import com.github.sendiko.kostgoadmin.navigation.RegisterDestination
import com.github.sendiko.kostgoadmin.register.presentation.RegisterScreen
import com.github.sendiko.kostgoadmin.register.presentation.RegisterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
        )
        setContent {
            KostgoandroidTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = LoginDestination
                ) {
                    composable<LoginDestination> {
                        val viewModel = viewModel<LoginViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        LoginScreen(
                            state = state,
                            onEvent = viewModel::onEvent,
                            onNavigate = { navController.navigate(it) }
                        )
                    }
                    composable<RegisterDestination> {
                        val viewModel = viewModel<RegisterViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        RegisterScreen(
                            state = state,
                            onEvent = viewModel::onEvent,
                            onNavigateBack = { navController.navigateUp() }
                        )
                    }
                }
            }
        }
    }
}
