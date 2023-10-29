import javax.swing.*;
import java.awt.BorderLayout;

public class FrameJiLife extends JFrame
{
	private Controleur ctrl;
	private PanelDessin panelDessin;

	public FrameJiLife( Controleur ctrl )
	{
		this.setTitle   ( "JiLife");
		this.setSize    ( 600,600 );
		this.setLocation( 100, 100 );
		this.setLayout  ( new BorderLayout() );

		this.ctrl = ctrl;

		this.panelDessin = new PanelDessin( this.ctrl );

		this.add( this.panelDessin, BorderLayout.CENTER );

		// Gestion de la fermeture de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}
}
