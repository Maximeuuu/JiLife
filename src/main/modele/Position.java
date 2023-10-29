public class Position
{
	private double posX;
	private double posY;

	public Position( int x, int y )
	{
		this.posX = x;
		this.posY = y;
	}

	public double getPosX(){ return this.posX; }
	public double getPosY(){ return this.posY; }

	public void setPosX( double x ){ this.posX = x; }
	public void setPosY( double y ){ this.posY = y; }

	public String toString()
	{
		return this.posX + "," + this.posY;
	}
}
