import java.util.List;
import java.util.ArrayList;

public class Interaction
{
	private Groupe groupeA;
	private Groupe groupeB;
	private double gravite;
	public final double RATIO = 1;//0.999; //(entre 0 et 1)

	public Interaction( Groupe grpA, Groupe grpB, double gravite )
	{
		this.groupeA = grpA;
		this.groupeB = grpB;
		this.gravite = gravite;
	}

	public void update()
	{
		for( Cellule cA : this.groupeA )
		{
			double fx = 0;
			double fy = 0;

			for( Cellule cB : this.groupeB )
			{
				double dx = cA.getX() - cB.getX();
				double dy = cA.getY() - cB.getY();

				double d = Math.sqrt( dx*dx + dy*dy );

				if( d > 0 && d < (cB.getMasse()*cA.getMasse())/2 )
				{
					double F = this.gravite * ( cA.getMasse() * cB.getMasse() ) / (d*d);
					fx += F*dx;
					fy += F*dy;
					//System.out.println("F : " + F );
				}
			}

			cA.setVX( ( (cA.getVX() + fx)*RATIO ) );
			cA.setVY( ( (cA.getVY() + fy)*RATIO ) );
			cA.setX( cA.getX() + cA.getVX() );
			cA.setY( cA.getY() + cA.getVY() );

			if( cA.getX() <= 0 || cA.getX() >= 500 ){ cA.setVX( cA.getVX() * -1 ); }
			if( cA.getY() <= 0 || cA.getY() >= 500 ){ cA.setVY( cA.getVY() * -1 ); }
		}
	}

	public void update2() {
        for (Cellule cA : this.groupeA) {
            double fx = 0;
            double fy = 0;

            for (Cellule cB : this.groupeB) {
                double dx = cA.getX() - cB.getX();
                double dy = cA.getY() - cB.getY();

                double d = Math.sqrt(dx * dx + dy * dy);

                // Évitez les divisions par zéro
                if (d == 0) {
                    continue;
                }

                // Calcul de la force gravitationnelle
                double F = (gravite * cA.getMasse() * cB.getMasse()) / (d * d);

                // Calcul des composantes de la force
                double Fx = (F * dx) / d;
                double Fy = (F * dy) / d;

                // Ajout des forces aux accélérations des particules
                double ax = Fx / cA.getMasse();
                double ay = Fy / cA.getMasse();

                cA.setVX( (cA.getVX() + ax ) * RATIO);
                cA.setVY( (cA.getVY() + ay ) * RATIO);

                // Vous pouvez ajouter ici des conditions de collision entre les particules
                // par exemple :
                if (d < 5 + 5/*cA.getRayon() + cB.getRayon()*/) {
                    // Collision détectée, ajustez les vitesses en conséquence
                    // Vous devrez implémenter une logique de collision appropriée ici
					cA.setVX( (cA.getVX()/10) * RATIO);
	                cA.setVY( (cA.getVY()/10) * RATIO);
                }
            }

            // Appliquer la vitesse aux positions des particules
            cA.setX(cA.getX() + cA.getVX());
            cA.setY(cA.getY() + cA.getVY());

            // Gestion des rebonds avec les bords du monde
            if (cA.getX() <= 0 || cA.getX() >= 500) {
                cA.setVX(cA.getVX() * -1);
            }
            if (cA.getY() <= 0 || cA.getY() >= 500) {
                cA.setVY(cA.getVY() * -1);
            }
        }
    }

	public void update3() {
        for (Cellule cA : this.groupeA) {
            // Utilisation de la méthode de Verlet pour la simulation
            double oldX = cA.getX();
            double oldY = cA.getY();

            double ax = 0;
            double ay = 0;

            for (Cellule cB : this.groupeB) {
                double dx = cA.getX() - cB.getX();
                double dy = cA.getY() - cB.getY();

                double d = Math.sqrt(dx * dx + dy * dy);

                // Évitez les divisions par zéro
                if (d == 0) {
                    continue;
                }

                // Calcul de la force gravitationnelle
                double F = (gravite * cA.getMasse() * cB.getMasse()) / (d * d);

                // Calcul des composantes de la force
                double Fx = (F * dx) / d;
                double Fy = (F * dy) / d;

                // Ajout des forces aux accélérations des particules
                ax += Fx / cA.getMasse();
                ay += Fy / cA.getMasse();
            }

            // Mise à jour des positions en utilisant la méthode de Verlet avec vélocité
            double newX = 2 * cA.getX() - oldX + ax;
            double newY = 2 * cA.getY() - oldY + ay;

            // Gestion des rebonds avec les bords du monde
            if (newX <= 0 || newX >= 500) {
                newX = Math.max(0, Math.min(newX, 500));
                cA.setVX(cA.getVX() * -1);
            }
            if (newY <= 0 || newY >= 500) {
                newY = Math.max(0, Math.min(newY, 500));
                cA.setVY(cA.getVY() * -1);
            }

            // Mise à jour de la vélocité
            double newVX = (newX - oldX) / 2;
            double newVY = (newY - oldY) / 2;

            cA.setVX(newVX);
            cA.setVY(newVY);

            // Mise à jour des positions
            cA.setX(newX);
            cA.setY(newY);
        }
    }
}
