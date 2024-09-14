import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.ash.french.sudoku.compose.app

fun main() =
    application {
        Window(onCloseRequest = ::exitApplication) {
            app()
        }
    }
