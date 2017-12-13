package com.example.florian.jaipurtokens;

import android.app.Activity;
import android.media.MediaPlayer;

import java.util.LinkedList;

/**
 * Created by Florian on 20/08/2017.
 */

public class History {

    LinkedList<TokenTransaction> list;
    TokenTransaction currentTransaction;
    boolean transactionInProgress;
    Activity act;

    private static History instance = new History();
    private MediaPlayer coinMediaPlayer;
    private MediaPlayer undoMediaPlayer;

    public History() {

        this.list = new LinkedList<TokenTransaction>();
    }

    public static History getInstance() {
        return instance;
    }

    public void setAct(Activity act) {

        this.act = act;
        coinMediaPlayer = MediaPlayer.create(act, R.raw.petite_piece);
        undoMediaPlayer = MediaPlayer.create(act, R.raw.undo);

    }

    public void addTransaction (TokenTransaction tt) {
        list.add(tt);
    }

    public void initiateTransaction(Token t, TokenHandler th) {

        if (!transactionInProgress) {
            transactionInProgress = true;
            currentTransaction = new TokenTransaction(t, th);
            currentTransaction.getSrc().remove(currentTransaction.getToken());
        }
    }

    public void abortTransaction() {
        if (transactionInProgress) {
            transactionInProgress = false;
            currentTransaction.getSrc().add(currentTransaction.getToken());
        }
    }

    public void completeTransaction(TokenHandler th) {
        if (transactionInProgress) {
            coinMediaPlayer.start();
            transactionInProgress = false;
            currentTransaction.setDest(th);
            currentTransaction.getDest().add(currentTransaction.getToken());
            list.add(currentTransaction);

        }
    }

    public void undo() {
        if (list.size() != 0) {
            undoMediaPlayer.start();
            TokenTransaction tt = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            tt.getDest().remove(tt.getToken());
            tt.getSrc().add(tt.getToken());
        }
    }

}
