package com.company;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

public class ResultPresenter {

    private URI uri;

    public void presentResult(URI uri){
        try {
            Desktop.getDesktop().browse(uri);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


}
