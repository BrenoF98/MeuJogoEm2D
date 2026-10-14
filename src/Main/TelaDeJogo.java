package Main;

// bibliotecas para criação da tela, cor, configuração, especifica para 2D... 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

import entidade.Jogador;

public class TelaDeJogo extends JPanel implements Runnable {

    // configurações de tela

    final int tamanhoOriginalBloco = 16; // tamanho . 16x16
    final int escala = 3;

    public final int tamanhoBloco = tamanhoOriginalBloco * escala; // 48X48

    final int numeroMaxColuna = 16; // numero de colulas.
    final int numeroMaxLinha = 12; // numero de linhas

    final int larguraTela = tamanhoBloco * numeroMaxColuna; // 768 px
    final int alturaTela = tamanhoBloco * numeroMaxLinha; // 576 px

    // definir a taxa de quadros:

    int FPS = 60;

    KeyHandler tecla = new KeyHandler();
    Thread linhaDeJogo;
    Jogador jogador = new Jogador(this, tecla);

    public TelaDeJogo() {
        this.setPreferredSize(new DimensionUIResource(larguraTela, alturaTela)); // altura e largura do quadro inserido
                                                                                 // na janela.
        this.setBackground(Color.white); // cor de fundo do quadro.
        this.setDoubleBuffered(true); // otimização?
        this.addKeyListener(tecla); // possibilita a leitura das teclas.
        this.setFocusable(true); // não sei??
    }

    public void inicioDaLinhaDeJogo() {

        linhaDeJogo = new Thread(this);
        linhaDeJogo.start();

    }

    @Override
    public void run() { // nucleo do jogo

        // define a taxa de atualização de informação para em quadros por segundo.

        double intervaloDeEscrita = 1000000000 / FPS; // 0,01666 s
        double proximoTempoDeEscrita = System.nanoTime() + intervaloDeEscrita;

        while (linhaDeJogo != null) {

            update();

            repaint(); // reimprime os quadros.
            try {

                double tempoRestante = proximoTempoDeEscrita - System.nanoTime();
                tempoRestante = tempoRestante / 1000000;

                if (tempoRestante < 0) {
                    tempoRestante = 0;
                }

                Thread.sleep((long) tempoRestante);

                proximoTempoDeEscrita += intervaloDeEscrita;

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }
    }

    public void update() {
        jogador.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // --- DESENHAR O CHÃO ---
        // Posição Y do chão = Posição Y do gato + Altura do bloco do gato
        int chaoY = jogador.CHAO_Y + tamanhoBloco;

        // Cor do chão (por exemplo, cinza-escuro ou verde)
        g2.setColor(new Color(100, 100, 100));

        // Desenha uma linha / retângulo do chão cobrindo toda a largura da tela
        g2.fillRect(0, chaoY, larguraTela, 5); // 5px de espessura para a linha do chão
        // -----------------------

        // Desenhar o gato por cima do chão
        jogador.graficos(g2);

        g2.dispose();

    }
}
