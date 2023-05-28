package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Jogador {
    public boolean up;
    public boolean down;
    public int x;
    public int y;
    public int larguraJogador;
    public int alturaJogador;

    public Jogador(int x, int y){
        this.x=x;
        this.y=y;
        this.larguraJogador=10;
        this.alturaJogador=70;
    }

    public void desenhar(Graphics g){
        g.setColor(new Color(255,255,255));
        g.fillRect(x,y,larguraJogador,alturaJogador);

    }

    public void atualizar (){
        if (up){
            if(y>0){
                y-=6;
            }
        }
        if (down){
            if(y<Jogo.altura-alturaJogador){
                y+=6;
            }
        }
    }
}
