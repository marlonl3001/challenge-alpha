package br.com.mdr.starwars.ui.presentation.films.detail

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavHostController
import br.com.mdr.starwars.ui.presentation.components.DetailScreenTopBar
import br.com.mdr.starwars.ui.presentation.components.EmptyScreen
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmDetailScreen(navController: NavHostController) {
    val viewModel: FilmDetailViewModel = koinViewModel()
    val film by viewModel.film.collectAsState(null)

    val isFavorite by viewModel.isFavorite.collectAsState()

    val scrollBehavior = TopAppBarDefaults
        .enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = Color.Black,
        topBar = {
            DetailScreenTopBar(
                scrollBehavior = scrollBehavior,
                navController = navController,
                detailViewModel = viewModel,
                isFavorite = isFavorite
            )
        }
    ) {
        film?.let {
            FilmDetailItem(film = it)
        } ?: EmptyScreen(viewModel = viewModel)
    }
}
