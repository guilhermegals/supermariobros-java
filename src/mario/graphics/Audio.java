package mario.graphics;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {

	private Clip clip;

	public static void play(String path, boolean loop) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());

			Clip audio = AudioSystem.getClip();
			audio.open(audioInputStream);

			audio.start();

			if (loop) {
				audio.loop(audio.LOOP_CONTINUOUSLY);
			}else{
				audio.loop(0);
			}

		} catch (Exception ex) {
			System.out.println("Erro ao executar SOM!");
			ex.printStackTrace();
		}
	}

	// Get e Set

	public Clip getClip() {
		return clip;
	}

}
