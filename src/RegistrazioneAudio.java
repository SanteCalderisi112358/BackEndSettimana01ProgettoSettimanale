
public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {

	private int durata;
	private int volume;

	public RegistrazioneAudio(String _titolo, int _durata) {
		this.titolo = _titolo;
		this.durata = _durata;

	}

	@Override
	public void play() {
		String asterischi = "";
		for (int i = 0; i < this.volume; i++) {
			asterischi += "*";
		}
		for (int i = 0; i < this.durata; i++) {
			System.out.println("Stai ascoltando " + "'" + this.titolo + "'" + " con volume: " + asterischi);
		}

	}




	@Override
	public void setVolume(int volumeAlzato) {
		if (volumeAlzato >= 0) {
			this.volume = volumeAlzato;
		} else {
			System.out.println("Il volume deve essere un valore positivo.");
		}
	}


	@Override
	public String toString() {
		return "Titolo:" + this.titolo + ", Durata: " + this.durata + " minuti, Formato: Audio";
	}

}
