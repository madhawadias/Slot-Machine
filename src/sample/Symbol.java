package sample;

import javafx.scene.image.Image;

/**
 * Created by Madhawa on 5/11/2017.
 */
public class Symbol implements ISymbol {

    private int imageValue;
    private Image img;
    String symbol;

    public Symbol(int imageValue, Image img) {
        this.imageValue = imageValue;
        this.img = img;

    }


    public int getImageValue() {
        return imageValue;
    }

    public void setImageValue(int imageValue) {
        this.imageValue = imageValue;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }





}