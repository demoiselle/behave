package br.gov.frameworkdemoiselle.behave.regression.report.imagemagick.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class Image {
    BufferedImage image;
    File imageFile;
    BigDecimal heightInPixels;
    BigDecimal widthInPixels;
    BigDecimal totalPixels;

    public Image(String pathToImageFile) {
        try {
            this.imageFile = new File(pathToImageFile);
            this.image = ImageIO.read(this.imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setHeightInPixels(new BigDecimal(image.getHeight()));
        setWidthInPixels(new BigDecimal(image.getWidth()));
        setTotalPixels(this.heightInPixels.multiply(this.widthInPixels));
    }

    public File getImageFile() {
        return this.imageFile;
    }

    public BigDecimal getHeightInPixels() {
        return heightInPixels;
    }

    public void setHeightInPixels(BigDecimal heightInPixels) {
        this.heightInPixels = heightInPixels;
    }

    public BigDecimal getWidthInPixels() {
        return widthInPixels;
    }

    public void setWidthInPixels(BigDecimal widthInPixels) {
        this.widthInPixels = widthInPixels;
    }

    public BigDecimal getTotalPixels() {
        return totalPixels;
    }

    public void setTotalPixels(BigDecimal totalPixels) {
        this.totalPixels = totalPixels;
    }
}
