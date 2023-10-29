//https://youtu.be/0Kx4Y9TVMGg?si=OuaVbS4Ug2-37Blk

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

public class Monde
{
	private List<Groupe> ensGroupe;
	private List<Interaction> ensRegle;
	private List<Cellule> ensCellule;

	public Monde()
	{
		this.ensGroupe = new ArrayList<Groupe>();
		this.ensRegle = new ArrayList<Interaction>();
		this.ensCellule = new ArrayList<Cellule>();
	}

	public void addGroupe( String nom )
	{
		this.ensGroupe.add( new Groupe( nom ) );
	}

	public void addCellule( String nomGroupe, Cellule cellule )
	{
		Groupe tmpGrp = this.findGroupe( nomGroupe );
		if( tmpGrp != null )
		{
			tmpGrp.addCellule( cellule );
			this.ensCellule.add( cellule );
		}
	}

	public void addCellules( String nomGroupe, int nombreCellules, Color couleur, double masse )
	{
		for( int cpt=0; cpt<nombreCellules; cpt++ )
		{
			this.addCellule( nomGroupe, new Cellule( couleur, masse ) );
		}
	}

	public void addInteraction( String nomGroupeA, String nomGroupeB, double gravite )
	{
		Groupe grpA = this.findGroupe( nomGroupeA );
		Groupe grpB = this.findGroupe( nomGroupeB );

		if( grpA != null && grpB != null )
		{
			this.ensRegle.add( new Interaction(grpA, grpB, gravite) );
		}
	}

	public int getNbCellule()
	{
		return this.ensCellule.size();
	}

	public Cellule getCellule( int indice )
	{
		return this.ensCellule.get( indice );
	}

	private final Groupe findGroupe( String nom )
	{
		for( Groupe grp : this.ensGroupe )
		{
			if( grp.getNom().equals( nom ) )
			{
				return grp;
			}
		}
		return null;
	}

	public void update()
	{
		for( Interaction i : this.ensRegle )
		{
			i.update2();
		}
	}

	public String toString()
	{
		String s="Monde : ";
		for( Groupe g : this.ensGroupe )
		{
			s+="\n" + g.toString();
		}
		return s;
	}
}
