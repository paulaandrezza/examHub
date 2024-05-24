package view.utils;

import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

final public class FieldMask extends PlainDocument {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MaskType maskType;

	public enum MaskType {
		NUMBERS_ONLY, LETTERS_ONLY
	}

	public void setMaskType(MaskType maskType) {
		this.maskType = maskType;
	}

	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str == null || str.isEmpty()) {
			return;
		}

		if (maskType == null) {
			throw new IllegalStateException("Mask type is not set");
		}

		switch (maskType) {
		case NUMBERS_ONLY:
			formatedLabelNumber(offs, str, a);
			break;
		case LETTERS_ONLY:
			formatedLabelLetters(offs, str, a);
			break;
		default:
			super.insertString(offs, str, a);
		}
	}

	public void formatedLabelNumber(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str == null || str.isEmpty()) {
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return;
			}
		}

		super.insertString(offs, str, a);
	}

	public void formatedLabelLetters(int offs, String str, AttributeSet a) throws BadLocationException {
		if (Pattern.matches("[a-zA-Z-ZÀ-ü ]", str)) {
			super.insertString(offs, str, a);
		}
	}
}
