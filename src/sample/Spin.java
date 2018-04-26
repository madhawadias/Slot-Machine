package sample;

import javafx.scene.image.ImageView;


public class Spin implements Runnable {

    private ImageView lbel,lbl2,lbl3;

    public Spin(ImageView lbl,ImageView lbl2, ImageView lbl3) {
        this.lbel = lbl;
        this.lbl2 = lbl2;
        this.lbl3 = lbl3;
    }

    @Override
    public void run() {
        Symbol[] symbols;
        symbols = Reel.spin();
        ImageView img = new ImageView();
        while (true ) {
            int randomNum1 = (int) (Math.random() * 5);
            Symbol one = symbols[randomNum1];
            int randomNum2 = (int) (Math.random() * 5);
            Symbol two = symbols[randomNum2];
            int randomNum3 = (int) (Math.random() * 5);
            Symbol three =  symbols[randomNum3];
            lbel.setImage(one.getImg());
            lbl2.setImage(two.getImg());
            lbl3.setImage(three.getImg());


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
