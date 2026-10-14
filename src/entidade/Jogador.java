package entidade;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.KeyHandler;
import Main.TelaDeJogo;

public class Jogador extends Entidade {

    TelaDeJogo tj; // devine nome para o metodo da tela
    KeyHandler tecla; // Define nome para o metodo das teclas

    public Jogador(TelaDeJogo tj, KeyHandler tecla) {

        this.tj = tj; // não sei o que significa.
        this.tecla = tecla;

        valoresPadraoDeConfiguracao();
        buscaImagemJogador();
    }

    public void valoresPadraoDeConfiguracao() { // define configurações iniciais para o gato.

        x = 100;
        y = CHAO_Y; // Define a posição inicial Y exatamente no chão
        velocidade = 4; // velocidade do jogador de caminhada.
        direcao = "sentandaDireita";

    }

    public void buscaImagemJogador() {
        try {
            // busca as imagens e atribuiu a uma variavel que será usada para formar o
            // quadro.

            emPeDireita = ImageIO.read(getClass().getResourceAsStream("/jogador/eva-empe-direita.png"));
            emPeEsquerda = ImageIO.read(getClass().getResourceAsStream("/jogador/eva-empe-esquerda.png"));
            deitadaDireita = ImageIO.read(getClass().getResourceAsStream("/jogador/eva-deitada-direita.png"));
            deitadaEsquerda = ImageIO.read(getClass().getResourceAsStream("/jogador/eva-deitada-esquerda.png"));
            sentandaDireita = ImageIO.read(getClass().getResourceAsStream("/jogador/eva-sentada-direita.png"));
            sentadaEsquerda = ImageIO.read(getClass().getResourceAsStream("/jogador/eva-sentada-esquerda.png"));
            sentadaFrenteDireita = ImageIO
                    .read(getClass().getResourceAsStream("/jogador/eva-sentada-frente-direita.png"));
            sentadaFrenteEsquerda = ImageIO
                    .read(getClass().getResourceAsStream("/jogador/eva-sentada-frente-esquerda.png"));

        } catch (IOException e) { // não sei
            e.printStackTrace();
        }
    }

    public void update() {

        // define o gato como sentado para direita se o botão w "paracima" por apertado
        // e se já estivesse em pé para direta ou deitado para direita.
        // essa logica se repede para outroas direções.

        if (tecla.paraCima == true && (direcao.equals("emPeDireita") || direcao.equals("deitadaDireita"))) {
            direcao = "sentandaDireita";

            marcadorDireita = true; // flag para indicar direção. 

        } else if (tecla.paraCima == true && (direcao.equals("emPeEsquerda") || direcao.equals("deitadaEsquerda"))) {

            direcao = "sentadaEsquerda";

            marcadorDireita = false;

        }

        if (tecla.paraBaixo == true && (direcao.equals("emPeDireita") || direcao.equals("sentandaDireita"))) {
            direcao = "deitadaDireita";

            marcadorDireita = true;

        } else if (tecla.paraBaixo == true && (direcao.equals("emPeEsquerda") || direcao.equals("sentadaEsquerda"))) {
            direcao = "deitadaEsquerda";

            marcadorDireita = false;

        }

        // define o gato como em pé e indica se chegar no fim da tela deve reaparece do
        // outro lado.
        if (tecla.paraEsquerda == true) {
            x -= velocidade;
            direcao = "emPeEsquerda";

            marcadorDireita = false;
            if (x == 0 - tj.tamanhoBloco) {
                x = 768 + tj.tamanhoBloco;
            }
        } else if (tecla.paraDireita == true) {
            x += velocidade;
            direcao = "emPeDireita";
            marcadorDireita = true;

            if (x == 768 + tj.tamanhoBloco) {
                x = 0 - tj.tamanhoBloco;
            }
        }

        // --- LÓGICA DO PULO E GRAVIDADE ---
        // Detecta o comando de pulo quando está no chão
        if (tecla.pular && !estaNoAr) {
            if (marcadorDireita == false) {
                direcao = "emPeEsquerda";
            } else if (marcadorDireita == true) {

                direcao = "emPeDireita";
            }

            velY = FORCA_PULO; // Aplica a força inicial para subir
            estaNoAr = true;
        }

        // Aplica a velocidade atual na posição Y
        y += velY;

        // Aplica a gravidade continuamente se estiver no ar
        if (estaNoAr) {
            velY += GRAVIDADE;
        }

        // Detecção de colisão com o chão
        if (y >= CHAO_Y) {
            y = CHAO_Y; // Mantém o jogador exatamente sobre o chão
            velY = 0; // Zera a velocidade vertical
            estaNoAr = false; // Libera para poder pular de novo
        }
    }

    public void graficos(Graphics2D g2) {

        // g2.setColor(Color.black);

        // g2.fillRect(x, y, tj.tamanhoBloco, tj.tamanhoBloco);

        BufferedImage image = null;

        // decisão que faz mostrar a imagem correta.

        switch (direcao) {
            case "emPeEsquerda":
                image = emPeEsquerda;
                break;
            case "emPeDireita":
                image = emPeDireita;
                break;
            case "deitadaDireita":
                image = deitadaDireita;
                break;
            case "deitadaEsquerda":
                image = deitadaEsquerda;
                break;
            case "sentandaDireita":
                image = sentandaDireita;
                break;
            case "sentadaEsquerda":
                image = sentadaEsquerda;
                break;

            default:
                direcao = "emPeDireita";
                image = emPeDireita; // define caso erro.
                break;
        }

        g2.drawImage(image, x, y, tj.tamanhoBloco, tj.tamanhoBloco, null); // define onde vede ser mostrado no quadro e
                                                                           // suas dimenções.

    }

}
