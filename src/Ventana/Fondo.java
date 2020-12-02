package Ventana;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {

	ImageIcon imagen;
	
	public Fondo() {

	}
	

public Fondo (String nombre){
	super();
	initialize();
	imagen = new ImageIcon(getClass().getResource(nombre));
	setSize(imagen.getIconWidth(), imagen.getIconHeight());
}

protected void paintComponent (Graphics g){

	Dimension d = getSize();
	g.drawImage(imagen.getImage(),0,0, d.width, d.height, null);
	this.setOpaque(false);
	super.paintComponent(g);
}

private void initialize(){

	this.setSize(300,200);
	this.setLayout(new GridBagLayout());
}
	

}
