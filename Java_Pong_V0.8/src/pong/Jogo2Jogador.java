package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Jogo2Jogador extends Jogo {
    public Bola bola = new Bola(true);

    public Jogo2Jogador(){
        super();
        Placar.pontuacao=0;
    }

    public void desenhar(Graphics g, BufferStrategy bs) {
        g.setColor(new Color(0, 0, 0)); // Escolhe a cor
        g.fillRect(0, 0, largura, altura); // X e y de onde começa e o tamanho
        bola.desenhar(g);
        jogador1.desenhar(g);
        jogador2.desenhar(g);
        placar.desenhar(g);
        bs.show(); // Mostra o grafico no buffer
    }

    public void atualizar() {
        bola.atualizar();
        jogador1.atualizar();
        jogador2.atualizar();
        placar.atualizar();
        if (bola.pontoJogador1) {
            placar.jogador1 += 1;
            jogador1 = new Jogador(15, 165);
            jogador2 = new Jogador(largura - 15 - jogador1.largura, 165);
            bola = new Bola(true);
        }
        if (bola.pontoJogador2) {
            placar.jogador2 += 1;
            jogador1 = new Jogador(15, 165);
            jogador2 = new Jogador(largura - 15 - jogador1.largura, 165);
            bola = new Bola(true);
        }
    }


}
