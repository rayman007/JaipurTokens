package com.example.florian.jaipurtokens;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.LinkedList;

/**
 * Created by Florian on 18/08/2017.
 */

public class TokenStackView {

    final private LinkedList<Token> mTokenList;
    private ViewGroup originView;
    private int originViewId;
    private int tokenOffset;
    private Context originContext;
    private Activity activity;

    public void remove(Token t) {
        mTokenList.remove(t);
    }

    public TokenStackView(Activity _activity, int _originViewId, LinkedList<Token> _tokenList, boolean _stackedToken) {

        final TokenStackView me = this;
        this.activity = _activity;
        this.mTokenList = _tokenList;
        this.originViewId = _originViewId;
        this.originView = (ViewGroup) activity.findViewById(originViewId);
        this.originContext = activity.getBaseContext();
        if (_stackedToken)
            this.tokenOffset = 0;
        else
            this.tokenOffset = 50;

        RelativeLayout.LayoutParams lp;
        ImageView ovl = new ImageView(originContext);

        for(int i = 0 ; i < mTokenList.size(); i++) {
            ImageView iv = new ImageView(originContext);
            iv.setImageResource(mTokenList.get(i).getResid());
            lp = new RelativeLayout.LayoutParams(200, 200);
            lp.leftMargin = i * tokenOffset;
            lp.topMargin = 0;
            originView.addView(iv, lp);
            mTokenList.get(i).setImageView(iv);
        }

        ovl.setAlpha(0.5f);
        lp = new RelativeLayout.LayoutParams(2000, 2000);
        lp.leftMargin = 0;
        lp.topMargin = 0;
        originView.addView(ovl, lp);

        ovl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (mTokenList.size() != 0) {
                            Token token = mTokenList.get(mTokenList.size() - 1);
                            v.startDrag(null, new View.DragShadowBuilder(token.getImageView()), token, 0);
                            token.getImageView().setVisibility(View.INVISIBLE);
                            return true;
                        }
                }
                return false;
            }
        });


    }

}

