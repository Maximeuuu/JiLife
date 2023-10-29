import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDessin extends JPanel
{
    private Timer timer;
    private Controleur ctrl;

    public PanelDessin(Controleur ctrl) {
        this.ctrl = ctrl;
        this.timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				PanelDessin.this.ctrl.update();
                repaint(); // Redessine le panneau à intervalles réguliers
            }
        });
        timer.start(); // Démarre le timer
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int taille = ctrl.getNbCellule();

        // Parcourt les indices et dessine un cercle à chaque position
        for (int indice = 0; indice < taille; indice++) {
            int x = (int)ctrl.getPosXCellule(indice)+50;
            int y = (int)ctrl.getPosYCellule(indice)+50;
			Color c = ctrl.getCouleurCellule(indice);
            dessinerCercle(g, x, y, c);
        }
    }

    private void dessinerCercle(Graphics g, int x, int y, Color c) {
        int rayon = 5; // Vous pouvez ajuster la taille du cercle
        g.setColor( c ); // Couleur du cercle (par exemple, bleu)
        g.fillOval(x - rayon, y - rayon, 2 * rayon, 2 * rayon); // Dessine le cercle
    }
}
