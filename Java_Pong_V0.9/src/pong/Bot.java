package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Bot extends Objeto implements Renderizar {

    public Bot(int x, int y) {
        this.x = x;
        this.y = y;
        this.largura=10;
        this.altura=70;
    }

    public void desenhar(Graphics g) {
        g.setColor(new Color(255, 0, 0));
        g.fillRect(x, y, largura, altura);

    }

    public void atualizar() { // IA

        y += (JogoBot.bola.y - y - 6) * 0.5; // Existe um bug que o bot consegue ir alem da tela, mas e dificil
                                             // consertar

    }
}
