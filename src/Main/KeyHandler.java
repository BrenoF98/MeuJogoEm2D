package Main;

// permitem a leitura de teclas no teclado. 

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean paraCima, paraBaixo, paraEsquerda, paraDireita, pular; // define variaveis para os potões, servem para a
                                                                   // logica de ação apartir do teclado.

    @Override
    public void keyTyped(KeyEvent e) { // para cliques unicos

    }

    @Override
    public void keyPressed(KeyEvent e) { // para precionar.
        int code = e.getKeyCode(); // variavel recebe a tecla apertada.

        // identifica a tecla apertada e atribui a variavel que à representa.

        if (code == KeyEvent.VK_W) {
            paraCima = true;
        }
        if (code == KeyEvent.VK_S) {
            paraBaixo = true;
        }
        if (code == KeyEvent.VK_A) {
            paraEsquerda = true;
        }
        if (code == KeyEvent.VK_D) {
            paraDireita = true;
        }
        if (code == KeyEvent.VK_SPACE) {
            pular = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); // variavel recebe a tecla solta.

        // identifica a tecla solta e atribuiu a variavel que à representa.

        if (code == KeyEvent.VK_W) {
            paraCima = false;
        }
        if (code == KeyEvent.VK_S) {
            paraBaixo = false;
        }
        if (code == KeyEvent.VK_A) {
            paraEsquerda = false;
        }
        if (code == KeyEvent.VK_D) {
            paraDireita = false;
        }
        if (code == KeyEvent.VK_SPACE) {
            pular = false;
        }
    }

}
