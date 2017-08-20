package com.example.florian.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 18/08/2017.
 */

public class TokenStackViewList {

    List<TokenStackView> list = new ArrayList<TokenStackView>();

    public void addStackView(TokenStackView tsv) {
        list.add(tsv);
    }

    public void removeToken(Token tok) {
        for (int i = 0 ; i < list.size() ; i++) {
            list.get(i).remove(tok);
        }
    }

}
