
public class Immagine extends ElementoMultimediale {
	private int luminosita;

	public Immagine(String _titolo) {
		this.titolo = _titolo;
	}

	public void setLuminosita(int luminosita) {
		if (luminosita >= 0) {
			this.luminosita = luminosita;
		} else {
			System.out.println("La luminosità deve essere un valore positivo.");
			this.luminosita = 5;
		}

	}

	public void show() {
		System.out.println("----------");
		String asterischi = "";
		for (int i = 0; i < this.luminosita; i++) {
			asterischi += "*";
		}
		System.out.println("Stai guardando " + "'" + this.titolo + "'" + " con luminosità: " + asterischi);
		System.out.println("----------");
	}

	@Override
	public String toString() {
		return "Titolo: " + this.titolo + ", Formato: Immagine";
	}

}
