package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola extends Objeto implements Renderizar{
    public double dx; // Direcao de X
    public double dy; // Direcao de Y
    public double velocidade = 7;
    public boolean modo; // Se de 2 jogadores ou contra bot. True indica que é de 2 jogadores
    public boolean pontoJogador1 = false;
    public boolean pontoJogador2 = false;



    public void definirAngulo(int itensidadeAngulo) { // Funcao de gerar angulo aleatorio
        int angulo = new Random().nextInt(itensidadeAngulo);
        this.dx = Math.cos(Math.toRadians(angulo));
        this.dy = Math.sin(Math.toRadians(angulo));
    }


    public Bola(boolean modo) {
        this.modo = modo;
        this.largura=8;
        this.altura=8;
        this.x=(Jogo.largura - largura) / 2;
        this.y =(Jogo.altura - altura) / 2;

        this.definirAngulo(80);
        int lado = new Random().nextInt(2); // Utilizado para randomizar lado inicial
        if (lado == 0) {
            lado = -1;
        }
        dx *= lado;
    }

    public void desenhar(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillOval(x, y, largura, altura);
    }

    public void atualizar() {
        double contatoY = y + (dy * velocidade);
        double contatoX = x + (dx * velocidade);

        if (contatoY >= Jogo.altura) {
            dy *= -1; // Colisao com parede de baixo
        }
        if (contatoY <= 0) {
            dy *= -1; // Colisao com a parede de cima
        }

        Rectangle bola = new Rectangle((int) contatoX, (int) contatoY, largura, altura);// classe que lida com
                                                                                                // Retangulo
        Rectangle jogador1 = new Rectangle(Jogo.jogador1.x, Jogo.jogador1.y, Jogo.jogador1.largura,
                Jogo.jogador1.altura);
        Rectangle jogador2 = new Rectangle(Jogo2Jogador.jogador2.x, Jogo2Jogador.jogador2.y,
                Jogo2Jogador.jogador2.largura, Jogo2Jogador.jogador2.altura);
        Rectangle bot = new Rectangle(JogoBot.bot.x, JogoBot.bot.y, JogoBot.largura, JogoBot.altura);

        if (bola.intersects(jogador1)) { // Colisao com direita

            this.definirAngulo(50);
            int lado = new Random().nextInt(2); // Utilizado para randomizar lado que a bola vai
            velocidade += 1;
            if (lado == 0) {
                lado = -1;
            }
            dy *= lado;

            if (dx < 0) {
                dx *= -1;
            }
        }

        if (modo) {
            if (bola.intersects(jogador2)) {
                this.definirAngulo(50);
                int lado = new Random().nextInt(2); // Utilizado para randomizar lado que a bola vai
                velocidade += 1;
                if (lado == 0) {
                    lado = -1;
                }
                dy *= lado;

                if (dx > 0) {
                    dx *= -1;
                }
            }
        } else if (bola.intersects(bot)) {
            velocidade += 1;
            int angulo = new Random().nextInt(50); // Angulo da bola depois de bater
            this.dx = Math.cos(Math.toRadians(angulo));
            this.dy = Math.sin(Math.toRadians(angulo));

            if (dx > 0) {
                dx *= -1;
            }
        }

        if (x <= 0) { // Ponto no lado esquerdo
            System.out.println("Ponto do inimigo");
            pontoJogador2 = true;
        }

        if (x >= Jogo.largura) { // Ponto no lado direito
            System.out.println("Ponto do jogador");
            pontoJogador1 = true;
        }

        x += dx * velocidade;// movimento x
        y += dy * velocidade;// movimento y
    }
}
