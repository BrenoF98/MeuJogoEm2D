package entidade;

import java.awt.image.BufferedImage;

public class Entidade {
    public int x, y; // posição
    public int velocidade; // velocidade

    // --- VARIÁVEIS DE FÍSICA PARA O PULO ---
    public double velY = 0;              // Velocidade vertical
    public final double GRAVIDADE = 0.8;  // Força puxando para baixo
    public final double FORCA_PULO = -13; // Impulso para cima (negativo sobe no Java 2D)
    public final int CHAO_Y = 100;       // Posição inicial / altura do chão
    public boolean estaNoAr = false;     // Evita pulos infinitos no ar
    

    public BufferedImage // banco de imagem
    emPeDireita, emPeEsquerda, // gato em pe. Deve ser substituido por sequencia que faça parecer caminhar.
    deitadaDireita, deitadaEsquerda, // gato deitado
    sentandaDireita, sentadaEsquerda, // gato sentado de lado para o plano da tela.
    sentadaFrenteDireita, sentadaFrenteEsquerda; // gato sentado de frente para o plano da tela. Deve ser usado
                                                 // em momento especificos como dialogos.

    public String direcao; // variavel para logica de orientação da direção do gato. 

}
