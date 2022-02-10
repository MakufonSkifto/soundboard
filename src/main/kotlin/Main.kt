import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.File
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.LineEvent


@Composable
@Preview
fun App() {
    val clip = AudioSystem.getClip()

    MaterialTheme {
        Button(onClick = {
            val file = File("C:/Users/emirs/Downloads/This is a Certified Hood Classic.wav")
            val audioIn: AudioInputStream = AudioSystem.getAudioInputStream(file)
            clip.open(audioIn)
            clip.start()

            clip.addLineListener {
                LineEvent.Type.STOP
                clip.close()
            }
        }, modifier = Modifier.padding(10.dp)) {
            Text("This is a Certified Hood Classic")
        }
    }
}

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Soundboard",
        icon = painterResource("icon.png")
    ) {
        App()
    }
}
