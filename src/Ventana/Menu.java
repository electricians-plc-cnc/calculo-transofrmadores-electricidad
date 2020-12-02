package Ventana;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import Controlador.Codigo;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Codigo codigo = new Codigo();
	
	public Menu() {
		
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("transformador.jpg"));
		setIconImage(icon);
	    setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 376);
		
		Icon imgMenu = new ImageIcon(getClass().getResource("/Img/uy2.png"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 0, 0));
		menuBar.setBackground(Color.BLACK);
		menuBar.setFont(new Font("Segoe UI Symbol", Font.BOLD, 27));
		setJMenuBar(menuBar);
		
		JMenu mnEdicin = new JMenu("| Edici\u00F3n |");
		mnEdicin.setForeground(new Color(255, 255, 255));
		mnEdicin.setFont(new Font("Segoe UI", Font.BOLD, 25));
		menuBar.add(mnEdicin);
		
		JMenuItem mntmSalir = new JMenuItem("Cerrar Programa");
		mntmSalir.setForeground(Color.RED);
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigo.sonidoCerrar();
				System.exit(0);
				
			}
		});
		mnEdicin.add(mntmSalir);
		
		JMenu mnInformacin = new JMenu("Ventanas\r\n");
		mnInformacin.setForeground(new Color(255, 255, 255));
		mnInformacin.setFont(new Font("Segoe UI", Font.BOLD, 25));
		menuBar.add(mnInformacin);
		
		JMenuItem mntmDatos = new JMenuItem("Transformador MONOFÁSICO - GARCIA");
		mntmDatos.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.sonidoDing();
				calculoTransformador transformador= new calculoTransformador(); 
				transformador.setVisible(true);// Hace visible ej JFRAME
				
				 
				
				
			}
		});
		
		JMenuItem mntmDatos2 = new JMenuItem("Transformador MONOFÁSICO - CHAGAS");
		mntmDatos2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mntmDatos2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.sonidoDing();
				calculoTransformadorCHAGAS transformador= new calculoTransformadorCHAGAS(); 
				transformador.setVisible(true);// Hace visible ej JFRAME
				
				 
				
				
			}
		});
		mnInformacin.add(mntmDatos);
		mnInformacin.add(mntmDatos2);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnInformacin.add(menuBar_1);
		
		JMenu mnContacto = new JMenu("| Contactos |");
		mnContacto.setForeground(new Color(255, 255, 255));
		mnContacto.setFont(new Font("Segoe UI", Font.BOLD, 25));
		menuBar.add(mnContacto);
		
		JMenu mnColegas = new JMenu("Developers   ");
		mnColegas.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnContacto.add(mnColegas);
		
		JMenuItem mntmMaru = new JMenuItem("   Maru   ");
		mntmMaru.setForeground(new Color(0, 102, 0));
		mntmMaru.setFont(new Font("ShadowedBlackWide", Font.PLAIN, 18));
		mntmMaru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.sonidoDing();
				JOptionPane.showMessageDialog(null, "María Eugenia Szwedowski \n Cel +598 91074131 \n Montevideo-Uruguay","Información developer",JOptionPane.ERROR_MESSAGE, imgMenu);
				
			}
		});
		mnColegas.add(mntmMaru);
		
		JMenuItem mntmDiego = new JMenuItem("   Diego   ");
		mntmDiego.setForeground(new Color(0, 102, 0));
		mntmDiego.setFont(new Font("ShadowedBlackWide", Font.PLAIN, 18));
		mntmDiego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.sonidoDing();
				JOptionPane.showMessageDialog(null, "Diego Velázquez Ineella \n Cel +598 95036103 \n Montevideo-Uruguay\n ","Información developer",JOptionPane.ERROR_MESSAGE, imgMenu);
				
			}
		});
		mnColegas.add(mntmDiego);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 204));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGif = new JLabel("");
		lblGif.setBounds(0, 0, 399, 302);
		contentPane.add(lblGif);
		
		//lblGif
		ImageIcon imagen2 = new ImageIcon(calculoTransformador.class.getResource("primerFondo.jpg"));
		Image imag2 = imagen2.getImage().getScaledInstance(lblGif.getWidth(), lblGif.getHeight(), Image.SCALE_SMOOTH);
		lblGif.setIcon(new ImageIcon(imag2));
		
	}
}
