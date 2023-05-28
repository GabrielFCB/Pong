package pong;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Jogo extends Canvas implements Runnable, KeyListener { //Classe utilizada para desenhar o jogo
    public static int largura=600;
    public static int altura=400;
    public static Jogador jogador1=new Jogador(15, 165);


    public Jogo (){
        this.setPreferredSize(new Dimension(largura,altura)); //Determina as dimensões do jogo
        this.addKeyListener(this);
    }


    public abstract void run();

    public abstract void desenhar();

    public abstract void atualizar();



    public void keyTyped(KeyEvent e) { //Método desnecessário
        
    }



    public void keyPressed(KeyEvent e) { //O que fazer se a tecla for apertada
        if(e.getKeyCode()==KeyEvent.VK_W){
            jogador1.up=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            jogador1.down=true;
        }
    }


    public void keyReleased(KeyEvent e) { // O que fazer se a tecla for solta
        if(e.getKeyCode()==KeyEvent.VK_W){
            jogador1.up=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            jogador1.down=false;
        }
    }

}
