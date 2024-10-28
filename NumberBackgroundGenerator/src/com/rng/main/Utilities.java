package com.rng.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.security.SecureRandom;
import java.text.DecimalFormat;

/**
 * List of utilities to support the random
 * generation of styled numbers.
 * 
 * @author Adnan Wazwaz
 * @version SE 19
 * @since SE 19
 * 
 * Updated: 2024-10-28.
 */
public final class Utilities {
	
	/**
	 * Class does not require instantiation.
	 */
	private Utilities() {
	}

	// Random number generator.
	private static final SecureRandom RNG = new SecureRandom();
	
	// List of font families.
	private static final String[] FONT_NAMES = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	
	// RGB max value.
	public static final int RGB_LIMIT = 256;
	
	// Formats numbers from 1000 upwards so that commas are shown.
	public static final DecimalFormat COMMAS = new DecimalFormat("#,###");
	
	/**
	 * Returns a random number in between a range.
	 * 
	 * @param lowerBound the lower bound (inclusive)
	 * @param upperBound the upper bound (inclusive); must be greater than lower bound.
	 * @return a random number between {@code lowerBound} and {@code upperBound}
	 */
	public static int randomNumberBetween(int lowerBound, int upperBound) {
		if (lowerBound > upperBound) {
			throw new IllegalArgumentException("Lower bound must be less than or equal to upper bound.");
		}
		return lowerBound + RNG.nextInt(upperBound - lowerBound + 1);
	}
	
	/**
	 * Returns a random color using {@link SecureRandom#nextInt()}
	 * 
	 * @return a random color.
	 */
	public static Color randomColor() {
		int red = RNG.nextInt(RGB_LIMIT);
		int green = RNG.nextInt(RGB_LIMIT);
		int blue = RNG.nextInt(RGB_LIMIT);
		
		return new Color(red, green, blue);
	}
	
	/**
	 * Computes the negative of a given color.
	 * 
	 * @param color the color.
	 * @return the negative of {@code color}.
	 */
	public static Color negative(Color color) {
		int red = RGB_LIMIT - color.getRed() - 1;
		int green = RGB_LIMIT - color.getGreen() - 1;
		int blue = RGB_LIMIT - color.getBlue() - 1;
		return new Color(red, green, blue);
	}
	
	/**
	 * Returns a random font name.
	 * 
	 * @return a random font name.
	 */
	public static String randomFontName() {
		return FONT_NAMES[RNG.nextInt(FONT_NAMES.length)];
	}
	
	/**
	 * Formats a number as - #,###.
	 * 
	 * @param number the number.
	 * @return a string representation of the formatted number.
	 */
	public static String numberForamt(int number) {
		return COMMAS.format(number);
	}
	
}
