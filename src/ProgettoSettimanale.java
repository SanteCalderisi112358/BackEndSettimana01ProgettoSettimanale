import java.util.Scanner;

public class ProgettoSettimanale {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean continua = true;
		System.out.println("Quanti elementi multimediali vuoi caricare?");
		int lunghezza = input.nextInt();
		ElementoMultimediale[] elementiMultimediali = new ElementoMultimediale[lunghezza];

		elementiMultimediali = controlloScelta(elementiMultimediali);

		stampareElementi(elementiMultimediali);

		do {
			System.out.println("Cosa vuoi riprodurre?\nSeleziona l'indice dell'elemento da eseguire (0 - "
					+ (elementiMultimediali.length - 1) + "):");
			Scanner inputSceltaObj = new Scanner(System.in);
			int sceltaObj = inputSceltaObj.nextInt();

			if (sceltaObj >= 0 && sceltaObj < elementiMultimediali.length) {
				ElementoMultimediale elementoScelto = elementiMultimediali[sceltaObj];
				if (elementoScelto != null) {
					if (elementoScelto instanceof Video) {
						Video video = (Video) elementoScelto;
						System.out.println("Imposta il volume:");
						int volume = input.nextInt();
						video.setVolume(volume);
						System.out.println("Imposta la luminosità:");
						int luminosita = input.nextInt();
						video.setLuminosita(luminosita);
						video.play();
					} else if (elementoScelto instanceof Immagine) {
						Immagine immagine = (Immagine) elementoScelto;
						System.out.println("Imposta la luminosità:");
						int luminosita = input.nextInt();
						immagine.setLuminosita(luminosita);
						immagine.show();
					} else if (elementoScelto instanceof RegistrazioneAudio) {
						RegistrazioneAudio audio = (RegistrazioneAudio) elementoScelto;
						System.out.println("Imposta il volume:");
						int volume = input.nextInt();
						audio.setVolume(volume);
						audio.play();
					}
				}
			} else {
				System.out.println("Indice non valido.");
			}
			System.out.println("Vuoi eseguire un altro elemento multimediale? (sì/no)");
			String sceltaContinua = input.next();
			if (sceltaContinua.equals("no")) {
				continua = false;
			}
		} while (continua);
		input.close();
		System.out.println("---------------------");
	}

	public static ElementoMultimediale[] controlloScelta(ElementoMultimediale[] elementi) {
		Scanner input = new Scanner(System.in);
		int scelta;
		int indice = 0;

		do {
			System.out.println("Digita:");
			System.out.println("- 1 se vuoi caricare un Audio.");
			System.out.println("- 2 se vuoi caricare un Video.");
			System.out.println("- 3 se vuoi caricare una Immagine.");
			System.out.println("---------------------");

			scelta = input.nextInt();
			input.nextLine();

			switch (scelta) {
			case 1:
				if (indice < elementi.length) {
					System.out.println("Inserisci il titolo della traccia audio: ");
					String titoloNuovoAudio = input.nextLine();
					System.out.println("Inserisci la durata della traccia audio: ");
					int durataNuovaAudio = input.nextInt();
					input.nextLine();

					RegistrazioneAudio audio = new RegistrazioneAudio(titoloNuovoAudio, durataNuovaAudio);
					elementi[indice] = audio;
					indice++;
					System.out.println("Audio memorizzato correttamente.");
				} else {
					System.out.println("Spazio esaurito. Impossibile memorizzare altri elementi.");
				}
				break;

			case 2:
				if (indice < elementi.length) {
					System.out.println("Inserisci il titolo del video: ");
					String titoloNuovoVideo = input.nextLine();
					System.out.println("Inserisci la durata del video: ");
					int durataNuovaVideo = input.nextInt();
					input.nextLine();

					Video video = new Video(titoloNuovoVideo, durataNuovaVideo);
					elementi[indice] = video;
					indice++;
					System.out.println("Video memorizzato correttamente.");
				} else {
					System.out.println("Spazio esaurito. Impossibile memorizzare altri elementi.");
				}
				break;

			case 3:
				if (indice < elementi.length) {
					System.out.println("Inserisci il titolo dell'immagine: ");
					String titoloNuovaImmagine = input.nextLine();

					Immagine immagine = new Immagine(titoloNuovaImmagine);
					elementi[indice] = immagine;
					indice++;
					System.out.println("Immagine memorizzata correttamente.");
				} else {
					System.out.println("Spazio esaurito. Impossibile memorizzare altri elementi.");
				}
				break;

			case 0:
				System.out.println("Terminazione del programma.");
				break;

			default:
				System.out.println("Scelta non valida. Inserisci un valore intero tra 1 e 3.");
				break;
			}
		} while (indice < elementi.length);

		// input.close();
		return elementi;
	}

	public static void stampareElementi(ElementoMultimediale[] elementi) {
		System.out.println("Ecco la lista degli elementi multimediali che hai caricato:");
		System.out.println("---------------------");
		for (int i = 0; i < elementi.length; i++) {
			ElementoMultimediale elemento = elementi[i];
			if (elemento != null) {
				System.out.println(" " + i + " - " + elemento.toString());
				System.out.println("---------------------");
			}
		}
	}

}
