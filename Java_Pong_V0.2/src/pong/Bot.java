package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Bot {
    public int x;
    public int y;
    public int larguraBot;
    public int alturaBot;

    public Bot(int x, int y){
        this.x=x;
        this.y=y;
        this.larguraBot=10;
        this.alturaBot=70;
    }

    public void desenhar(Graphics g){
        g.setColor(new Color(255,0,0));    
        g.fillRect(x,y,larguraBot,alturaBot);

    }

    public void atualizar (){ // IA

        y+= (JogoBot.bola.y -y -6)* 0.5; //Existe um bug que o bot consegue ir alem da tela, mas e dificil consertar


    }
}
