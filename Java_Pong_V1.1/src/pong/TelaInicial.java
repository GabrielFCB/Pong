package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

public class TelaInicial extends Tela implements Runnable, KeyListener {
    public int ix = 220; // Indicador X
    public int iy = 236; // Indicador Y
    public Map<Integer, Integer> vetor;
    public int posicao = 1;
    public JFrame jframe = new JFrame(); // Utilizado para abrir uma janela com Java
    public Jogo jogo1;
    public Derrota derrota;
    public Placares placares;
    public static boolean jogoBot = false;
    public static boolean jogo2Jogador = false;
    public static boolean telaDerrota = false;
    public static boolean telaPlacares = false;
    public BufferStrategy bs;
    public static Graphics g;
    public Graphics2D g2d;

    public TelaInicial() throws SaveException {
        this.setPreferredSize(new Dimension(largura, altura)); // Determina as dimensões do jogo
        this.addKeyListener(this);
        vetor = new HashMap<>();
        vetor.put(1, 186);
        vetor.put(2, 236);
        vetor.put(3, 286);
        vetor.put(4, 336);
        placares = new Placares();
        jogo1 = new JogoBot();

        jframe.setVisible(true);
        jframe.requestFocus(); // Foca a tela quando é aberta
        jframe.add(this);
        jframe.pack();
        jframe.setLocationRelativeTo(null); // Cria a janela no centro da tela
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Fecha o programa se a janela for fechada
    }

    public void run() { // Metodo do FPS do jogo
        try {
            while (true) {
                this.desenhar();
                this.atualizar();
                Thread.sleep(1000 / 30); // Velocidade que o jogo atualiza o frame
            }
        } catch (InterruptedException e) { // Excecao para caso a thread seja interrompida
            e.printStackTrace();// Rastreia o momento que a excecao ocorreu
        }
    }

    public void desenhar() {
        bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g2d = (Graphics2D) g;

        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, getLargura(), getAltura());

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font fonte = new Font("Arial", Font.BOLD, 48);
        g2d.setFont(fonte);
        g2d.setColor(Color.WHITE);

        // Obtém as dimensões do texto "Pong"
        String texto = "Pong";
        String texto2 = "Jogar - 1 Jogador";
        String texto3 = "Jogar - 2 Jogadores";
        String texto4 = "Placares";
        String texto5 = "Sair";
        int larguraTexto = g2d.getFontMetrics().stringWidth(texto);

        // Calcula as coordenadas para centralizar o texto
        int x = (largura - larguraTexto) / 2;
        int y = 100;

        int y2 = 200;
        int y3 = 250;
        int y4 = 300;
        int y5 = 350;

        // Desenha o texto "Pong" centralizado
        g2d.drawString(texto, x, y);
        fonte = new Font("Arial", Font.BOLD, 30);
        x = (largura - larguraTexto) / 2;
        g2d.setFont(fonte);
        g2d.drawString(texto2, x, y2);
        g2d.drawString(texto3, x, y3);
        g2d.drawString(texto4, x, y4);
        g2d.drawString(texto5, x, y5);
        g.fillOval(ix, iy, 8, 8);

        if (jogoBot) {
            try {
                jogo1.run(g, bs);
                derrota = new Derrota();
                telaDerrota = true;
                derrota.run(g, bs);
                telaDerrota = false;
            } catch (FalhaJogo e) {
                System.out.println("Falha em carregar o jogo. Tente novamente ou contate o desenvolvedor");
                e.printStackTrace();
            }
        }

        if (jogo2Jogador) {
            try{
            jogo1.run(g, bs);
            derrota = new Derrota();
            telaDerrota = true;
            derrota.run(g, bs);
            telaDerrota = false;
            }catch (FalhaJogo e) {
                System.out.println("Falha em carregar o jogo. Tente novamente ou contate o desenvolvedor");
                e.printStackTrace();
            }
        }

        if (telaPlacares) {
            placares.run(g, bs);
        }

        g.dispose();
        bs.show();
    }

    public void atualizar() {
        iy = vetor.get(posicao);

    } // Classe utilizada para desenhar o jogo

    public void keyTyped(KeyEvent e) { // Método desnecessário

    }

    public void keyPressed(KeyEvent e) { // O que fazer se a tecla for apertada
        if ((e.getKeyCode() == KeyEvent.VK_W) && (posicao > 1)) {
            posicao -= 1;
        }
        if ((e.getKeyCode() == KeyEvent.VK_S) && (posicao < 4)) {
            posicao += 1;
        }

        if (telaDerrota) {
            if (derrota.trigger1) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    derrota.trigger1 = false;
                }
            } else if (derrota.trigger2) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    derrota.trigger2 = false;
                }
            } else if (derrota.trigger3) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    derrota.trigger3 = false;
                }
            }
        }

        if (!telaDerrota) {
            if ((e.getKeyCode() == KeyEvent.VK_ENTER) && (posicao == 1)) {
                jogoBot = true;
                jogo1 = new JogoBot();
            }
            if ((e.getKeyCode() == KeyEvent.VK_ENTER) && (posicao == 2)) {
                jogo2Jogador = true;
                jogo1 = new Jogo2Jogador();
            }

            if ((e.getKeyCode() == KeyEvent.VK_ENTER) && (posicao == 3)) {
                telaPlacares = true;
            }

            if ((e.getKeyCode() == KeyEvent.VK_ENTER) && (posicao == 4)) {

                try {
                    placares.salvarLista("Highscore.txt");
                } catch (SaveException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        }

        if ((jogoBot) || (jogo2Jogador)) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                Jogo.jogador1.up = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                Jogo.jogador1.down = true;
            }
        }

        if ((jogo2Jogador)) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                Jogo.jogador2.up = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Jogo.jogador2.down = true;
            }
        }

        if ((telaDerrota)) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                if (derrota.numero > 1) {
                    derrota.numero--;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                if (derrota.numero < 26) {
                    derrota.numero++;
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jogoBot = false;
            jogo2Jogador = false;
            telaPlacares = false;
        }
    }

    public void keyReleased(KeyEvent e) { // O que fazer se a tecla for solta
        if ((jogoBot) || (jogo2Jogador)) {
            if (e.getKeyCode() == KeyEvent.VK_W) {
                Jogo.jogador1.up = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                Jogo.jogador1.down = false;
            }
        }

        if (jogo2Jogador) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                Jogo.jogador2.up = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Jogo.jogador2.down = false;
            }
        }
    }

    @Override
    public void desenhar(Graphics g, BufferStrategy bs) {

    }

    public int getIx() {
        return ix;
    }

    public void setIx(int ix) {
        this.ix = ix;
    }

    public int getIy() {
        return iy;
    }

    public void setIy(int iy) {
        this.iy = iy;
    }

    public Map<Integer, Integer> getVetor() {
        return vetor;
    }

    public void setVetor(Map<Integer, Integer> vetor) {
        this.vetor = vetor;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public JFrame getJframe() {
        return jframe;
    }

    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }

    public Jogo getJogo1() {
        return jogo1;
    }

    public void setJogo1(Jogo jogo1) {
        this.jogo1 = jogo1;
    }

    public Derrota getDerrota() {
        return derrota;
    }

    public void setDerrota(Derrota derrota) {
        this.derrota = derrota;
    }

    public Placares getPlacares() {
        return placares;
    }

    public void setPlacares(Placares placares) {
        this.placares = placares;
    }

    public static boolean isJogoBot() {
        return jogoBot;
    }

    public static void setJogoBot(boolean jogoBot) {
        TelaInicial.jogoBot = jogoBot;
    }

    public static boolean isJogo2Jogador() {
        return jogo2Jogador;
    }

    public static void setJogo2Jogador(boolean jogo2Jogador) {
        TelaInicial.jogo2Jogador = jogo2Jogador;
    }

    public static boolean isTelaDerrota() {
        return telaDerrota;
    }

    public static void setTelaDerrota(boolean telaDerrota) {
        TelaInicial.telaDerrota = telaDerrota;
    }

    public static boolean isTelaPlacares() {
        return telaPlacares;
    }

    public static void setTelaPlacares(boolean telaPlacares) {
        TelaInicial.telaPlacares = telaPlacares;
    }

    public BufferStrategy getBs() {
        return bs;
    }

    public void setBs(BufferStrategy bs) {
        this.bs = bs;
    }

    public static Graphics getG() {
        return g;
    }

    public static void setG(Graphics g) {
        TelaInicial.g = g;
    }

    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }

    @Override
    public String toString() {
        return "TelaInicial [largura="+largura+", altura="+altura+", ix=" + ix + ", iy=" + iy + ", vetor=" + vetor + ", posicao=" + posicao + ", jframe="
                + jframe + ", jogo1=" + jogo1 + ", derrota=" + derrota + ", placares=" + placares + ", bs=" + bs
                + ", g2d=" + g2d + "]";
    }

}
