package gameTedio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Tela extends JFrame {

    private int jogadorX = 100, jogadorY = 450;
    private final int jogadorLargura = 25, jogadorAltura = 25;
    private boolean movendoEsquerda = false, movendoDireita = false;
    private boolean pulando = false, emChao = true;
    private int velocidadePulo = -15, gravidade = 1;

    private ArrayList<Rectangle> blocos;
    private final int larguraTela = 500, alturaTela = 700;
    private int velocidadeBloco = 9;

    private Timer timer;
    private int tempoDecorrido = 0;

    public Tela() {
        setTitle("Jogo de Plataforma");
        setSize(larguraTela, alturaTela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        blocos = new ArrayList<>();
        adicionarBloco();

        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharJogo(g);
            }
        };
        painel.setBackground(Color.gray);
        setContentPane(painel);

        painel.setFocusable(true);
        painel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    movendoEsquerda = true;
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    movendoDireita = true;
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE && emChao) {
                    pulando = true;
                    emChao = false;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    movendoEsquerda = false;
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    movendoDireita = false;
                }
            }
        });

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moverJogador();
                moverBlocos();
                checarColisao();
                tempoDecorrido += 1;
                repaint();
            }
        });
        timer.start();

        setVisible(true);
    }

    private void desenharJogo(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, alturaTela - 50, larguraTela, 50);

        g.setColor(Color.RED);
        g.fillRect(jogadorX, jogadorY, jogadorLargura, jogadorAltura);

        g.setColor(Color.YELLOW);
        for (Rectangle bloco : blocos) {
            g.fillRect(bloco.x, bloco.y, bloco.width, bloco.height);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Pontuação: " + tempoDecorrido, 10, 30);
    }

    private void moverJogador() {
        if (movendoEsquerda && jogadorX > 0) {
            jogadorX -= 7;
        }
        if (movendoDireita && jogadorX < larguraTela - jogadorLargura) {
            jogadorX += 7;
        }

        if (pulando) {
            jogadorY += velocidadePulo;
            velocidadePulo += gravidade;
        }

        if (jogadorY >= alturaTela - 50 - jogadorAltura) {
            jogadorY = alturaTela - 50 - jogadorAltura;
            pulando = false;
            emChao = true;
            velocidadePulo = -15;
        }
    }

    private void moverBlocos() {
        ArrayList<Rectangle> blocosRemover = new ArrayList<>();
        for (Rectangle bloco : blocos) {
            bloco.y += velocidadeBloco;
            if (bloco.y > alturaTela) {
                blocosRemover.add(bloco);
            }
        }
        blocos.removeAll(blocosRemover);
        if (blocos.isEmpty() || blocos.get(blocos.size() - 1).y > 100) {
            adicionarBloco();
        }
    }

    private void checarColisao() {
        Rectangle jogador = new Rectangle(jogadorX, jogadorY, jogadorLargura, jogadorAltura);
        for (Rectangle bloco : blocos) {
            if (jogador.intersects(bloco)) {
                JOptionPane.showMessageDialog(this, "Você perdeu! Colidiu com o bloco.");
                resetarJogo();
                break;
            }
        }
    }

    private void adicionarBloco() {
        Random rand = new Random();
        int larguraBloco = rand.nextInt(50) + 30;
        int xPosicao = rand.nextInt(larguraTela - larguraBloco);
        blocos.add(new Rectangle(xPosicao, 0, larguraBloco, 30));
    }

    private void resetarJogo() {
        jogadorX = 100;
        jogadorY = alturaTela - 50 - jogadorAltura;
        blocos.clear();
        tempoDecorrido = 0;
        adicionarBloco();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tela();
            }
        });
    }
}
