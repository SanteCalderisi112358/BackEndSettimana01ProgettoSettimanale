
public class Video extends ElementoMultimediale implements Riproducibile {
	private int volume;
	private int durata;
	private int luminosita;

	public Video(String _titolo, int _durata) {
		this.titolo = _titolo;
		this.durata = _durata;

	}

	@Override
	public void play() {
		System.out.println("----------");
		String asterischi = "";
		String puntiEsclamativi = "";
		for (int i = 0; i < this.luminosita; i++) {
			asterischi += "*";
		}
		for (int i = 0; i < this.volume; i++) {
			puntiEsclamativi += "!";
		}
		for (int i = 0; i < this.durata; i++) {
			System.out.println("Stai guardando " + "'" + this.titolo + "'" + " con volume: " + puntiEsclamativi
					+ " e luminosità: " + asterischi);
		}
		System.out.println("----------");
	}




	@Override
	public void setVolume(int volume) {
		if (volume >= 0) {
			this.volume = volume;
		} else {
			System.out.println("Il volume deve essere un valore positivo.");
		}
	}

	public void setLuminosita(int luminosita) {
		if (luminosita >= 0) {
			this.luminosita = luminosita;
		} else {
			System.out.println("La luminosità deve essere un valore positivo.");
		}

	}

	@Override
	public String toString() {
		return "Titolo:" + this.titolo + ", Durata:" + this.durata + ", minuti, Formato: Video";
	}

}
