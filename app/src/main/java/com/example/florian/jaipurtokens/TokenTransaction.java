package com.example.florian.jaipurtokens;

/**
 * Created by Florian on 20/08/2017.
 */

public class TokenTransaction {

    Token token;
    TokenHandler src;
    TokenHandler dest;

    public TokenTransaction(Token t, TokenHandler src, TokenHandler dest) {
        this.token = t;
        this.src = src;
        this.dest = dest;
    }

    public Token getToken() {
        return token;
    }

    public TokenHandler getSrc() {
        return src;
    }

    public TokenHandler getDest() {
        return dest;
    }

    public TokenTransaction(Token token, TokenHandler src) {
        this.token = token;
        this.src = src;
    }

    public void setDest(TokenHandler dest) {
        this.dest = dest;
    }
}
