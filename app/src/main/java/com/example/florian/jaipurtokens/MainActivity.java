package com.example.florian.jaipurtokens;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<ImageView> tokenRow1List = new ArrayList<>();

    void initiateRandom(int destresid, int resid, TokenStackViewList tsvl, List<Integer> valueList) {
        LinkedList<Token> tokenlist;

        Collections.shuffle(valueList);
        tokenlist = new LinkedList<Token>();
        for (Integer i : valueList)
            tokenlist.add(new Token(resid, i));
        tsvl.addStackView(new TokenStackView(
                this,
                destresid,
                tokenlist,
                true));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);

        final TokenStackViewList tsvl = new TokenStackViewList();

        tsvl.addStackView(new TokenStackView(
                this,
                R.id.tokenRow1,
                new LinkedList<Token>(Arrays.asList(
                        new Token(R.drawable.rouge5, 5),
                        new Token(R.drawable.rouge5, 5),
                        new Token(R.drawable.rouge5, 5),
                        new Token(R.drawable.rouge7, 7),
                        new Token(R.drawable.rouge7, 7))),
                false));

        tsvl.addStackView(new TokenStackView(
                this,
                R.id.tokenRow2,
                new LinkedList<Token>(Arrays.asList(
                        new Token(R.drawable.jaune5, 5),
                        new Token(R.drawable.jaune5, 5),
                        new Token(R.drawable.jaune5, 5),
                        new Token(R.drawable.jaune6, 6),
                        new Token(R.drawable.jaune6, 6))),
                false));

        tsvl.addStackView(new TokenStackView(
                this,
                R.id.tokenRow3,
                new LinkedList<Token>(Arrays.asList(
                        new Token(R.drawable.bleu5, 5),
                        new Token(R.drawable.bleu5, 5),
                        new Token(R.drawable.bleu5, 5),
                        new Token(R.drawable.bleu5, 5),
                        new Token(R.drawable.bleu5, 5))),
                false));

        tsvl.addStackView(new TokenStackView(
                this,
                R.id.tokenRow5,
                new LinkedList<Token>(Arrays.asList(
                        new Token(R.drawable.violet1, 1),
                        new Token(R.drawable.violet1, 1),
                        new Token(R.drawable.violet2, 2),
                        new Token(R.drawable.violet2, 2),
                        new Token(R.drawable.violet3, 3),
                        new Token(R.drawable.violet3, 3),
                        new Token(R.drawable.violet5, 5))),
                false));

        tsvl.addStackView(new TokenStackView(
                this,
                R.id.tokenRow6,
                new LinkedList<Token>(Arrays.asList(
                        new Token(R.drawable.vert1, 1),
                        new Token(R.drawable.vert1, 1),
                        new Token(R.drawable.vert2, 2),
                        new Token(R.drawable.vert2, 2),
                        new Token(R.drawable.vert3, 3),
                        new Token(R.drawable.vert3, 3),
                        new Token(R.drawable.vert5, 5))),
                false));

        tsvl.addStackView(new TokenStackView(
                this,
                R.id.tokenRow7,
                new LinkedList<Token>(Arrays.asList(
                        new Token(R.drawable.marron1, 1),
                        new Token(R.drawable.marron1, 1),
                        new Token(R.drawable.marron1, 1),
                        new Token(R.drawable.marron1, 1),
                        new Token(R.drawable.marron1, 1),
                        new Token(R.drawable.marron1, 1),
                        new Token(R.drawable.marron2, 2),
                        new Token(R.drawable.marron3, 3),
                        new Token(R.drawable.marron4, 4))),
                false));

        // 3 3 2 2 2 1 1
        initiateRandom(R.id.bonus3slot, R.drawable.random3, tsvl, Arrays.asList(3, 3, 2, 2, 2, 1, 1));
        // 6 6 5 5 4 4
        initiateRandom(R.id.bonus4slot, R.drawable.random4, tsvl, Arrays.asList(6, 6, 5, 5, 4, 4));
        // 10 10 9 8 8
        initiateRandom(R.id.bonus5slot, R.drawable.random5, tsvl, Arrays.asList(10, 10, 9, 8, 8));

        tsvl.addStackView(new TokenStackView(
                this,
                R.id.camelslot,
                new LinkedList<Token>(Arrays.asList(
                        new Token(R.drawable.camel, 5),
                        new Token(R.drawable.camel, 5))),
                true));


        new PlayerBoardView(this, R.id.player1board, R.id.player1score, tsvl);
        new PlayerBoardView(this, R.id.player2board, R.id.player2score, tsvl);

    }
}
