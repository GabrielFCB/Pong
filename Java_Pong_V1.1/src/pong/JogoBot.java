package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class JogoBot extends Jogo {
    public static Bola bola = new Bola(false);
    public static Bot bot = new Bot(largura - 15 - jogador1.largura, 165);
    

    public static Bola getBola() {
        return bola;
    }

    public static void setBola(Bola bola) {
        JogoBot.bola = bola;
    }

    public static Bot getBot() {
        return bot;
    }

    public static void setBot(Bot bot) {
        JogoBot.bot = bot;
    }

    public JogoBot() {
        super();
        bola.x=(Jogo.largura - bola.largura) / 2;
        bola.y =(Jogo.altura - bola.altura) / 2;
        bola.definirAngulo(80);
        Placar.pontuacao=0;
    }

    public void desenhar(Graphics g, BufferStrategy bs) {
        
        g.setColor(new Color(0, 0, 0)); // Escolhe a cor
        g.fillRect(0, 0, largura, altura); // X e y de onde começa e o tamanho
        bola.desenhar(g);
        jogador1.desenhar(g);
        bot.desenhar(g);
        placar.desenhar(g);
        bs.show(); // Mostra o grafico no buffer
    }

    public void atualizar() {
        bola.atualizar();
        jogador1.atualizar();
        bot.atualizar();
        placar.atualizar();
        if (bola.pontoJogador1) {
            placar.jogador1 += 1;
            jogador1 = new Jogador(15, 165);
            bot = new Bot(largura - 15 - jogador1.largura, 165);
            bola = new Bola(false);
        }
        if (bola.pontoJogador2) {
            placar.jogador2 += 1;
            jogador1 = new Jogador(15, 165);
            bot = new Bot(largura - 15 - jogador1.largura, 165);
            bola = new Bola(false);
        }
    }

    @Override
    public String toString() {
        return "JogoBot [largura="+largura+", altura="+altura+"]";
    }

}
