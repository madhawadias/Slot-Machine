package sample;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Madhawa on 5/11/2017.
 */
public class Reel {

    static Symbol[] symbols = new Symbol[6];

    public static Symbol[] spin(){


        symbols[0] = (new Symbol(6,new Image("Images/bell.png")));
        symbols[1] =(new Symbol(2,new Image("Images/cherry.png")));
        symbols[2] = (new Symbol(3,new Image("Images/lemon.png")));
        symbols[3]=(new Symbol(4,new Image("Images/plum.png")));
        symbols[4]=(new Symbol(7,new Image("Images/redseven.png")));
        symbols[5]=(new Symbol(5,new Image("Images/watermelon.png")));

        return symbols;
    }
}
