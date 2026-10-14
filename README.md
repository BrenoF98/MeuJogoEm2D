# 🐱 Jogo em Java 2D - Movimentação e Física de Pulo (Em desenvolvimento)

Projeto esta sendo desenvolvido em **Java** utilizando a biblioteca gráfica nativa **Swing/AWT**, com foco em mecânicas básicas de jogos 2D, como loop de jogo (Game Loop), controle de taxa de quadros (FPS), movimentação por teclado e física de pulo/gravidade.

---

## 📸 Sobre o Projeto

O projeto consiste, até o momento, no controle de um personagem (um gato) em um ambiente 2D. O jogador pode se movimentar para os lados, alternar estados de animação/pose e realizar pulos com aceleração realista de gravidade.

### Para o futuro

- Ambiente interativo
- inimigos reativos
- itens coletaveis
- itens de modificação de caracteristicas física, como velocidade e altura do pulo. 

...

### 🎮 Funcionalidades
- **Movimentação Lateral:** Mover para a esquerda e direita com teclas `A` e `D`.
- **Efeito Wrap-Around:** O personagem reaparece do outro lado da tela ao passar dos limites laterais.
- **Mecânica de Pulo:** Implementação de física contendo velocidade vertical, aceleração por gravidade e detecção de chão ao pressionar a tecla `Espaço`.
- **Mudança de Estado/Poses:** Posições (em pé, sentado, deitado) alteradas pelas teclas `W` e `S`.
- **Game Loop:** Loop rodando a 60 FPS estáveis via `Thread` e `Runnable`.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java (JDK 8 ou superior)
- **Interface Gráfica:** `javax.swing` e `java.awt`
- **Controle de Teclado:** `java.awt.event.KeyListener`
- **Renderização:** `Graphics2D` / `BufferedImage`

---

## ⌨️ Controles do Jogo

| Tecla | Ação |
| :--- | :--- |
| `A` | Mover para a Esquerda |
| `D` | Mover para a Direita |
| `W` | Alterar pose (Ficar Sentado) |
| `S` | Alterar pose (Ficar Deitado) |
| `Espaço` | Pular |

---

## 📁 Estrutura do Código

```text
src/
 ├── Main/
 │    ├── Main.java         # Ponto de entrada da aplicação e criação da janela (JFrame)
 │    ├── TelaDeJogo.java    # Painel principal (JPanel), Game Loop e renderização do cenário
 │    └── KeyHandler.java    # Gerenciador de eventos de entrada do teclado
 └── entidade/
      ├── Entidade.java     # Classe base com atributos de posição e sprites
      └── Jogador.java      # Lógica do jogador, estados, física de pulo e desenho