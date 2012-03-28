package pl.seam.validator;

/**
 * Walidatory NIP, PESEL, REGOn
 * 
 * 
 * Bazuje na kodzie Klaudiusz Kulika.
 * 
 * <ul>
 * <li>Wprowadzono poprawke walidacji Regonu 14 cyfr (brakowalo odpowiednich
 * wag)</li>
 * </ul>
 * 
 * @author marian <mariuszs@gmail.com>
 * @author Klaudiusz Kulik <kulikk(at)monstrum.org>
 * @version 0.3
 */
public class Validators {
	public static boolean isValidREGON(String regon) {

		int rsize = regon.length();
		if (!((rsize == 9) || (rsize == 14))) {
			return false;
		}

		int[] weights = { 8, 9, 2, 3, 4, 5, 6, 7 };
		int[] weights14 = { 2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8 };

		if (rsize == 14) {
			weights = weights14;
		}

		int j = 0, sum = 0, control = 0;
		int csum = Integer.valueOf(regon.substring(rsize - 1));
		for (int i = 0; i < rsize - 1; i++) {
			char c = regon.charAt(i);
			j = Integer.valueOf(String.valueOf(c));
			sum += j * weights[i];
		}

		control = sum % 11;
		if (control == 10) {
			control = 0;
		}
		return (control == csum);

	}

	public static boolean isValidPESEL(String pesel) {

		int psize = pesel.length();
		if (psize != 11) {
			return false;
		}
		int[] weights = { 1, 3, 7, 9, 1, 3, 7, 9, 1, 3 };
		int j = 0, sum = 0, control = 0;
		int csum = Integer.valueOf(pesel.substring(psize - 1));
		for (int i = 0; i < psize - 1; i++) {
			char c = pesel.charAt(i);
			j = Integer.valueOf(String.valueOf(c));
			sum += j * weights[i];
		}
		control = 10 - (sum % 10);
		if (control == 10) {
			control = 0;
		}
		return (control == csum);

	}

	public static boolean isValidNIP(String nip) {
		int nsize = nip.length();
		if (nsize != 10) {
			return false;
		}
		int[] weights = { 6, 5, 7, 2, 3, 4, 5, 6, 7 };
		int j = 0, sum = 0, control = 0;
		int csum = Integer.valueOf(nip.substring(nsize - 1));
		for (int i = 0; i < nsize - 1; i++) {
			char c = nip.charAt(i);
			j = Integer.valueOf(String.valueOf(c));
			sum += j * weights[i];
		}
		control = sum % 11;
		return (control == csum);

	}

}
