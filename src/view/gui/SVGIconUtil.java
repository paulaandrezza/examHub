package view.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;

public class SVGIconUtil {

	public static BufferedImage convertSVGToBufferedImage(String svgFilePath) throws IOException {
		try (InputStream inputStream = SVGIconUtil.class.getResourceAsStream(svgFilePath)) {
			TranscoderInput transcoderInput = new TranscoderInput(inputStream);
			MyImageTranscoder imageTranscoder = new MyImageTranscoder();
			imageTranscoder.transcode(transcoderInput, null);
			return imageTranscoder.getImage();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static ImageIcon createImageIcon(String svgFilePath) throws IOException {
		BufferedImage bufferedImage = convertSVGToBufferedImage(svgFilePath);
		return new ImageIcon(bufferedImage);
	}

	private static class MyImageTranscoder extends ImageTranscoder {
		private BufferedImage image = null;

		@Override
		public BufferedImage createImage(int width, int height) {
			return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		}

		@Override
		public void writeImage(BufferedImage bufferedImage, TranscoderOutput transcoderOutput) {
			this.image = bufferedImage;
		}

		public BufferedImage getImage() {
			return image;
		}
	}
}
