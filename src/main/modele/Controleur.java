import java.awt.Color;

public class Controleur
{
	private Monde metier;
	private FrameJiLife ihm;

	private void config1()
	{
		this.metier.addGroupe("Noir");
		this.metier.addGroupe("Rouge");
		this.metier.addCellules("Noir", 100, Color.BLACK, 10);
		this.metier.addCellules("Rouge", 100, Color.RED, 10);
		this.metier.addInteraction("Noir", "Rouge", 0.1);
	}

	private void configClassic()
	{
		this.metier.addGroupe( "Noir" );
		this.metier.addGroupe( "Rouge" );
		this.metier.addGroupe( "Vert" );

		this.metier.addCellules( "Noir", 200, Color.BLACK, 30 ); //20
		this.metier.addCellules( "Rouge", 50, Color.RED, 40 ); //10
		this.metier.addCellules( "Vert", 200, Color.GREEN, 10 ); //10

		this.metier.addInteraction( "Rouge", "Rouge", 0.1 ); //0.1
		this.metier.addInteraction( "Noir", "Rouge", 0.15 ); //0.15
		this.metier.addInteraction( "Vert", "Noir", -0.4 ); //x
		this.metier.addInteraction( "Vert", "Vert", -0.7 ); //-0.7
		this.metier.addInteraction( "Vert", "Rouge", -0.2 ); //-0.2
		this.metier.addInteraction( "Rouge", "Vert", -0.1 ); //-0.1
	}

	private void configMaxime()
	{
		this.metier.addGroupe( "Noir" );
		this.metier.addGroupe( "Rouge" );
		this.metier.addGroupe( "Vert" );
		this.metier.addGroupe( "Bleu" );
		this.metier.addGroupe( "Jaune" );
		/**/

		this.metier.addCellules( "Noir", 100, Color.BLACK, 10 ); //20
		this.metier.addCellules( "Rouge", 100, Color.RED, 10 ); //10
		this.metier.addCellules( "Vert", 400, Color.GREEN, 30 ); //10
		this.metier.addCellules( "Bleu", 30, Color.BLUE, 5 ); //10
		this.metier.addCellules( "Jaune", 400, Color.YELLOW, 10 ); //10

		//this.metier.addInteraction( "Jaune", "Jaune", 0.1 ); //0.1
		this.metier.addInteraction( "Jaune", "Noir", 5 ); //0.1
		this.metier.addInteraction( "Jaune", "Bleu", -0.8 ); //0.1
		this.metier.addInteraction( "Noir", "Rouge", 0.1 ); //0.15
		this.metier.addInteraction( "Rouge", "Noir", -0.9 ); //x
		this.metier.addInteraction( "Noir", "Noir", 0.5 ); //-0.7
		this.metier.addInteraction( "Vert", "Rouge", -1 ); //-0.2
		this.metier.addInteraction( "Vert", "Noir", -1 ); //-0.2
		this.metier.addInteraction( "Bleu", "Vert", 5 ); //-0.1
		this.metier.addInteraction( "Bleu", "Noir", -5 ); //-0.1
	}

	private void config2()
	{
		this.metier.addGroupe("Noir");
		this.metier.addGroupe("Rouge");
		this.metier.addGroupe("Vert");
		this.metier.addGroupe("Bleu");
		this.metier.addGroupe("Jaune");

		this.metier.addCellules("Noir", 50, Color.BLACK, 10);
		this.metier.addCellules("Rouge", 50, Color.RED, 10);
		this.metier.addCellules("Vert", 100, Color.GREEN, 10);
		this.metier.addCellules("Bleu", 30, Color.BLUE, 5);
		this.metier.addCellules("Jaune", 100, Color.YELLOW, 10);

		this.metier.addInteraction("Noir", "Rouge", 0.1);
		this.metier.addInteraction("Noir", "Vert", -0.2);
		this.metier.addInteraction("Rouge", "Vert", -0.15);
		this.metier.addInteraction("Bleu", "Jaune", 0.05);
	}

	private void config3()
	{
		this.metier.addGroupe("Noir");
		this.metier.addGroupe("Rouge");
		this.metier.addGroupe("Vert");
		this.metier.addGroupe("Bleu");
		this.metier.addGroupe("Jaune");

		this.metier.addCellules("Noir", 100, Color.BLACK, 15);
		this.metier.addCellules("Rouge", 80, Color.RED, 12);
		this.metier.addCellules("Vert", 120, Color.GREEN, 8);
		this.metier.addCellules("Bleu", 50, Color.BLUE, 6);
		this.metier.addCellules("Jaune", 90, Color.YELLOW, 10);

		this.metier.addInteraction("Noir", "Rouge", 0.2);
		this.metier.addInteraction("Noir", "Vert", -0.15);
		this.metier.addInteraction("Rouge", "Vert", -0.1);
		this.metier.addInteraction("Bleu", "Jaune", 0.1);
		this.metier.addInteraction("Jaune", "Noir", 0.15);

	}

	public Controleur()
	{
		this.metier = new Monde();

		this.configClassic();

		this.ihm = new FrameJiLife( this );
	}

	public int getNbCellule()
	{
		return this.metier.getNbCellule();
	}

	public Color getCouleurCellule( int indice )
	{
		return this.metier.getCellule(indice).getCouleur();
	}

	public double getPosXCellule( int indice )
	{
		return this.metier.getCellule( indice ).getX();
	}

	public double getPosYCellule( int indice )
	{
		return this.metier.getCellule( indice ).getY();
	}

	public void update()
	{
		//System.out.println( this.metier.toString() );
		this.metier.update();
	}

	public static void main( String[] args )
	{
		new Controleur();
	}
}
