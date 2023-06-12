package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Bola extends Objeto implements RenderizarObjeto{
    private double dx; // Direcao de X
    private double dy; // Direcao de Y
    private double velocidade = 7;
    private boolean modo; // Se de 2 jogadores ou contra bot. True indica que é de 2 jogadores
    private boolean pontoJogador1 = false;
    private boolean pontoJogador2 = false;


    public double getDx() {
        return dx;
    }


    public void setDx(double dx) {
        this.dx = dx;
    }


    public double getDy() {
        return dy;
    }


    public void setDy(double dy) {
        this.dy = dy;
    }


    public double getVelocidade() {
        return velocidade;
    }


    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }


    public boolean isModo() {
        return modo;
    }


    public void setModo(boolean modo) {
        this.modo = modo;
    }


    public boolean getPontoJogador1() {
        return pontoJogador1;
    }


    public void setPontoJogador1(boolean pontoJogador1) {
        this.pontoJogador1 = pontoJogador1;
    }


    public boolean getPontoJogador2() {
        return pontoJogador2;
    }


    public void setPontoJogador2(boolean pontoJogador2) {
        this.pontoJogador2 = pontoJogador2;
    }


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

    public void desenhar(Graphics g, BufferStrategy bs) {
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
        Rectangle jogador1 = new Rectangle(Jogo.getJogador1().x, Jogo.getJogador1().y, Jogo.getJogador1().largura,
                Jogo.getJogador1().altura);
        Rectangle jogador2 = new Rectangle(Jogo2Jogador.getJogador2().x, Jogo2Jogador.getJogador2().y,
                Jogo2Jogador.getJogador2().largura, Jogo2Jogador.getJogador2().altura);
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
            pontoJogador2 = true;
            TelaInicial.setJogoBot(false);
            TelaInicial.setJogo2Jogador(false);
        }

        if (x >= Jogo.largura) { // Ponto no lado direito
            pontoJogador1 = true;
            TelaInicial.setJogoBot(false);
            TelaInicial.setJogo2Jogador(false);
        }

        x += dx * velocidade;// movimento x
        y += dy * velocidade;// movimento y
    }


    @Override
    public String toString() {
        return "Bola [x= "+x+", y="+y+", largura="+largura+", altura="+altura+",dx=" + dx + ", dy=" + dy + ", velocidade=" + velocidade + ", modo=" + modo + ", pontoJogador1="
                + pontoJogador1 + ", pontoJogador2=" + pontoJogador2 + "]";
    }
 
}
