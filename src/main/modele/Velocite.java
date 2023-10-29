public class Velocite
{
	private double velociteX;
	private double velociteY;

	public Velocite()
	{
		this.velociteX = 0;
		this.velociteY = 0;
	}

	public double getVelociteX(){ return this.velociteX; }
	public double getVelociteY(){ return this.velociteY; }

	public void setVelociteX( double vx ){ this.velociteX = vx; }
	public void setVelociteY( double vy ){ this.velociteY = vy; }

	public String toString()
	{
		return this.velociteX + "," + this.velociteY;	}
}
