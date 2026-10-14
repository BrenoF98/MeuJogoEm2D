package Main;

import javax.swing.JFrame; // Imparta biblioteca pra criar a janela.

public class Main {
    public static void main(String[] args) {

        // configuração da janela.

        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(true); // não permite redimencionar a janela se falso
        janela.setTitle("JOGO");

        // adiciona o quadro gerado pela TelaDeJogo na janela.

        TelaDeJogo telaDeJogo = new TelaDeJogo();
        janela.add(telaDeJogo);

        janela.pack();// permite que a tela tome tamanhos configuraveis.

        janela.setLocationRelativeTo(null);// indica a posição com central.

        janela.setVisible(true); // permite que a tela fique visivel;

        telaDeJogo.inicioDaLinhaDeJogo(); // inicialisa a linha de jogo, os cliclos e tarefas para a gameplay são
                                          // inicializados.
    }
}
