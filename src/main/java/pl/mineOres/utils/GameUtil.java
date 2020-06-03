package pl.mineOres.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class GameUtil {

	private String licenseKey;
	private Plugin plugin;
	private String validationServer = "https://minecodes.pl/mclicense/verify.php";
	private LogType logType = LogType.NORMAL;
	private String securityKey = "M4A5B2U97AWAXHCWQDDXT48B5Z7QFSCR";
	private boolean debug = false;

	public GameUtil(String licenseKey, Plugin plugin) {
		this.licenseKey = licenseKey;
		this.plugin = plugin;
	}

	public GameUtil setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
		return this;
	}

	public GameUtil setConsoleLog(LogType logType) {
		this.logType = logType;
		return this;
	}

	public GameUtil debug() {
		debug = true;
		return this;
	}

	public boolean register() {
		log(1, " ");
		log(1, "           MC LICENSE");
		log(1, " ");
		log(1, " Laczenie z serwerem licencyjnym...");
		ValidationType vt = isValid();
		if (getIncorrect()) {
			log(1, " Posiadasz poprawna licencje!");
			log(1, " ");
			return true;
		} else {
			log(1, " Nie posiadasz poprawnej licencji!");
			log(1, " W rezultacie plugin zostal wylaczony!");
			log(1, "" + vt);
			log(1, Bukkit.getIp());

			Bukkit.getScheduler().cancelTasks(plugin);
			Bukkit.getPluginManager().disablePlugin(plugin);
			return false;
		}
	}

	public boolean isValidSimple() {
		return (isValid() == ValidationType.VALID);
	}

	public static String getErrorName(ValidationType vt) {
		if (vt == ValidationType.INVALID_PLUGIN) {
			return "ls-0KcbMPTyMFA";
		}
		if (vt == ValidationType.KEY_NOT_FOUND) {
			return "ls-1DbvbZyMHJe";
		}
		if (vt == ValidationType.KEY_OUTDATED) {
			return "ls-24E4zdkgtPU";
		}
		if (vt == ValidationType.NOT_VALID_IP) {
			return "ls-3wfLJN4pnxa";
		}
		if (vt == ValidationType.PAGE_ERROR) {
			return "ls-4h5JFwe8cXH";
		}
		if (vt == ValidationType.URL_ERROR) {
			return "ls-5YcfhaupYW2";
		}
		if (vt == ValidationType.WRONG_RESPONSE) {
			return "ls-6dfN9Re84nh";
		}
		return null;
	}

	public boolean getIncorrect() {
		boolean bol = true;
		ValidationType vt = isValid();
		if (vt == ValidationType.INVALID_PLUGIN || vt == ValidationType.KEY_NOT_FOUND
				|| vt == ValidationType.KEY_OUTDATED || vt == ValidationType.NOT_VALID_IP
				|| vt == ValidationType.PAGE_ERROR || vt == ValidationType.URL_ERROR
				|| vt == ValidationType.WRONG_RESPONSE) {
			bol = false;

		}
		return bol;
	}

	public ValidationType isValid() {
		String rand = toBinary(UUID.randomUUID().toString());
		String sKey = toBinary(securityKey);
		String key = toBinary(licenseKey);

		try {
			URL url = new URL(
					validationServer + "?v1=" + xor(rand, sKey) + "&v2=" + xor(rand, key) + "&pl=" + plugin.getName());
			if (debug)
				System.out.println("RequestURL -> " + url.toString());
			Scanner s = new Scanner(url.openStream());
			if (s.hasNext()) {
				String response = s.next();
				s.close();
				try {
					return ValidationType.valueOf(response);
				} catch (IllegalArgumentException exc) {
					String respRand = xor(xor(response, key), sKey);
					if (rand.substring(0, respRand.length()).equals(respRand))
						return ValidationType.VALID;
					else
						return ValidationType.WRONG_RESPONSE;
				}
			} else {
				s.close();
				return ValidationType.PAGE_ERROR;
			}
		} catch (IOException exc) {
			if (debug)
				exc.printStackTrace();
			return ValidationType.URL_ERROR;
		}
	}

	//
	// Cryptographic
	//

	private static String xor(String s1, String s2) {
		String s0 = "";
		for (int i = 0; i < (s1.length() < s2.length() ? s1.length() : s2.length()); i++)
			s0 += Byte.valueOf("" + s1.charAt(i)) ^ Byte.valueOf("" + s2.charAt(i));
		return s0;
	}

	//
	// Enums
	//

	public enum LogType {
		NORMAL, LOW, NONE;
	}

	public static enum ValidationType {
		WRONG_RESPONSE, PAGE_ERROR, URL_ERROR, KEY_OUTDATED, KEY_NOT_FOUND, NOT_VALID_IP, INVALID_PLUGIN, VALID;
	}

	//
	// Binary methods
	//

	private String toBinary(String s) {
		byte[] bytes = s.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
		}
		return binary.toString();
	}

	//
	// Console-Log
	//

	private void log(int type, String message) {
		if (logType == LogType.NONE || (logType == LogType.LOW && type == 0))
			return;
		System.out.println(message);
	}
}
