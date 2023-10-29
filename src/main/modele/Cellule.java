import java.awt.Color;

public class Cellule
{
	private Position position;
	private Velocite velocite;
	private Color couleur;
	private double masse;

	public Cellule( Position p, Color c, double masse )
	{
		this.position = p;
		this.velocite = new Velocite();
		this.couleur  = c;
		this.masse = masse;
	}
	
	public Cellule( Color c, double masse )
	{
		this( new Position((int)(Math.random() * 400),(int)(Math.random() * 400)), c, masse );
	}

	public Cellule( Color c )
	{
		this( c, 1 );
	}

	public Position getPosition() { return this.position; }
	public Velocite getVelocite() { return this.velocite; }
	public double   getMasse()    { return this.masse; }
	public Color    getCouleur()  { return this.couleur; }
	
	public double getX() { return this.position.getPosX(); }
	public double getY() { return this.position.getPosY(); }
	public double getVX(){ return this.velocite.getVelociteX(); }
	public double getVY(){ return this.velocite.getVelociteY(); }
	
	public void setX( double x ) { this.position.setPosX(x); }
	public void setY( double y ) { this.position.setPosY(y); }
	public void setVX( double vx ){ this.velocite.setVelociteX(vx); }
	public void setVY( double vy ){ this.velocite.setVelociteY(vy); }
	public void setCouleur( Color c ){ this.couleur = c; }

	public String toString()
	{
		return this.couleur + " : (" + this.position.toString() + ") [" + this.velocite.toString() + "] : " + this.masse;
	}
}
