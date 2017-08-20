package com.example.florian.jaipurtokens;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Florian on 16/08/2017.
 */

public class PlayerBoardView {

    Activity act;
    int resid;
    int textresid;
    TokenStackViewList tsvl;
    int score;

    public PlayerBoardView(Activity _act, int _resid, int _textresid, TokenStackViewList _tsvl) {

        this.resid = _resid;
        this.textresid = _textresid;
        this.tsvl = _tsvl;
        this.act = _act;
        this.score = 0;

        act.findViewById(resid).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ((TextView) act.findViewById(textresid)).setText(String.valueOf(score));
                        break;
                    case MotionEvent.ACTION_UP:
                        ((TextView) act.findViewById(textresid)).setText("");
                        break;
                }
                return true;
            }
        });

        act.findViewById(resid).setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {

                final Token tok = (Token) event.getLocalState();

                switch (event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                    case DragEvent.ACTION_DRAG_EXITED:
                        ((ImageView) v).setColorFilter(act.getResources().getColor(R.color.colorDropHereHover), PorterDuff.Mode.MULTIPLY);
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        ((ImageView) v).clearColorFilter();
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                        ((ImageView) v).clearColorFilter();
                        if (!event.getResult()) {
                            v.post(new Runnable() {
                                @Override
                                public void run() {
                                    tok.getImageView().setVisibility(View.VISIBLE);
                                }
                            });
                        }
                        break;
                    case DragEvent.ACTION_DROP:
                        score += tok.getValue();
                        tsvl.removeToken(tok);
                }
                return true;
            }
        });


    }

}
