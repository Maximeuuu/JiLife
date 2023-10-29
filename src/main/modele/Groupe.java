import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Groupe implements Iterable<Cellule>
{
	private List<Cellule> ensCellule;
	private String nom;

	public Groupe( String nom )
	{
		this.nom = nom;
		this.ensCellule = new ArrayList<>();
	}

	public void addCellule( Cellule c )
	{
		this.ensCellule.add( c );
	}

	public final String getNom()
	{
		return this.nom;
	}

	@Override
	public Iterator<Cellule> iterator()
	{
		return ensCellule.iterator();
	}

	public String toString()
	{
		String s="# " + this.nom;
		for( Cellule c : this.ensCellule )
		{
			s+="\n" + c.toString();
		}
		return s;
	}
}
