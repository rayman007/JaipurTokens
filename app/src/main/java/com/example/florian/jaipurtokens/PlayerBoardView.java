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

public class PlayerBoardView implements TokenHandler {

    Activity act;
    int resid;
    int textresid;
    int score;
    final private PlayerBoardView me;

    public PlayerBoardView(Activity _act, int _resid, int _textresid) {

        this.resid = _resid;
        this.textresid = _textresid;
        this.act = _act;
        this.score = 0;
        this.me = this;

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
                            History.getInstance().abortTransaction();
                        }
                        break;
                    case DragEvent.ACTION_DROP:
                        History.getInstance().completeTransaction(me);
                }
                return true;
            }
        });


    }

    @Override
    public void add(Token t) {
        score += t.getValue();
    }

    @Override
    public void remove(Token t) {
        score -= t.getValue();
    }
}
