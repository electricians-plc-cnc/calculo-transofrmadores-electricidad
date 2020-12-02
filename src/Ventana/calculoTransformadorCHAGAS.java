package Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.ParagraphView;
import javax.xml.parsers.DocumentBuilder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Controlador.Codigo;
import Controlador.Formulas;
import Ventana.Fondo;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;


public class calculoTransformadorCHAGAS extends JFrame {

	protected static final NumberFormat PdfWriter = null;
	private JPanel contentPane;
	private JTextField textField_LadoInterno;
	private JTextField textField_AnchoInterno;
	private JTextField textField_VoltajeSalida;
	private JTextField textField_ConstanteK;
	Formulas controlador = new Formulas();
	
	
	Icon img = new ImageIcon(getClass().getResource("enchufar.gif"));
	public static Codigo codigo = new Codigo();
	private JTextField textField_PrimarioAmperes;
	private JTextField textField_SecundarioAmperes;
	private JTextField textField_Frecuencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calculoTransformadorCHAGAS frame = new calculoTransformadorCHAGAS();
					frame.setVisible(true);
					frame.setResizable(false); 
					codigo.sonidoDing();
					 
				      
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public calculoTransformadorCHAGAS() {
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("transformador.jpg"));
		setIconImage(icon);
	    setVisible(true);
		
	    JButton btnCalcularSeccin = new JButton("Calcular Secci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 483);
		contentPane = new Fondo("primerFondo.jpg");
		//contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_Seccion_1 = new JLabel("");
		JLabel label_Seccion_2 = new JLabel("");
		JLabel label_resultadoPrimario = new JLabel("");
		JLabel label_ResultadoSecundario = new JLabel("");
		JLabel label_Asterisco_10 = new JLabel("*");
		JLabel label_Asterisco_11 = new JLabel("*");
		label_Asterisco_10.setVisible(false);
		label_Asterisco_11.setVisible(false);
		JRadioButton rdbtnManual = new JRadioButton("Manual");
		rdbtnManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnManual.isSelected()){
					codigo.sonidoLimpiar();
					textField_PrimarioAmperes.setText(null);
					textField_SecundarioAmperes.setText(null);
					label_Seccion_1.setText(null);
					label_Seccion_2.setText(null);
					label_resultadoPrimario.setText(null);
					label_ResultadoSecundario.setText(null);
					btnCalcularSeccin.setVisible(true);
				}
				
				if (!rdbtnManual.isSelected()){
					codigo.sonidoLimpiar();
					textField_PrimarioAmperes.setText(null);
					textField_SecundarioAmperes.setText(null);
					label_Seccion_1.setText(null);
					label_Seccion_2.setText(null);
					label_resultadoPrimario.setText(null);
					label_ResultadoSecundario.setText(null);
					btnCalcularSeccin.setVisible(false);
				}
			}
		});
		rdbtnManual.setOpaque(false);
		rdbtnManual.setForeground(Color.WHITE);
		
		
		
		
		textField_PrimarioAmperes = new JTextField();
		
		JPanel panelMedidasInternas = new JPanel();
		panelMedidasInternas.setBounds(41, 98, 484, 160);
		contentPane.add(panelMedidasInternas);
		panelMedidasInternas.setLayout(null);
		panelMedidasInternas.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Medidas Internas  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelMedidasInternas.setOpaque(false);
		
		textField_LadoInterno = new JTextField();
		textField_LadoInterno.setBounds(209, 42, 86, 20);
		panelMedidasInternas.add(textField_LadoInterno);
		textField_LadoInterno.setColumns(10);
		
		
		textField_LadoInterno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                        && (c != '.') ) {
                    arg0.consume();
				}
				if (textField_VoltajeSalida.getText().length() >= 5) {
					arg0.consume();
				}
			}
		});
		
		textField_AnchoInterno = new JTextField();
		textField_AnchoInterno.setBounds(209, 84, 86, 20);
		panelMedidasInternas.add(textField_AnchoInterno);
		textField_AnchoInterno.setColumns(10);
		
		textField_AnchoInterno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                        && (c != '.') ) {
                    arg0.consume();
				}
				if (textField_VoltajeSalida.getText().length() >= 5) {
					arg0.consume();
				}
			}
		});
		
		JLabel lbl_LadoInterno = new JLabel("Lado Interno");
		lbl_LadoInterno.setForeground(Color.WHITE);
		lbl_LadoInterno.setBounds(92, 45, 86, 14);
		panelMedidasInternas.add(lbl_LadoInterno);
		
		JLabel lbl_AnchoInterno = new JLabel("Ancho Interno");
		lbl_AnchoInterno.setForeground(Color.WHITE);
		lbl_AnchoInterno.setBounds(92, 87, 86, 14);
		panelMedidasInternas.add(lbl_AnchoInterno);
		
		JLabel lblMm = new JLabel("mm");
		lblMm.setForeground(Color.WHITE);
		lblMm.setBounds(305, 45, 86, 17);
		panelMedidasInternas.add(lblMm);
		
		JLabel label = new JLabel("mm");
		label.setForeground(Color.WHITE);
		label.setBounds(305, 87, 106, 29);
		panelMedidasInternas.add(label);
		
		JLabel label_Asterisco_3 = new JLabel("*");
		label_Asterisco_3.setVisible(false);
		label_Asterisco_3.setForeground(Color.RED);
		label_Asterisco_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_Asterisco_3.setBounds(335, 43, 17, 14);
		panelMedidasInternas.add(label_Asterisco_3);
		
		JLabel label_Asterisco_4 = new JLabel("*");
		label_Asterisco_4.setVisible(false);
		label_Asterisco_4.setForeground(Color.RED);
		label_Asterisco_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_Asterisco_4.setBounds(335, 90, 17, 14);
		panelMedidasInternas.add(label_Asterisco_4);
		
		JPanel panelDatosVoltajes = new JPanel();
		
		panelDatosVoltajes.setOpaque(false);
		panelDatosVoltajes.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Datos  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelDatosVoltajes.setBounds(38, 11, 487, 76);
		
		
		contentPane.add(panelDatosVoltajes);
		panelDatosVoltajes.setLayout(null);
		
		
		JLabel lbl_VoltajeEntrada = new JLabel("Voltaje Entrada:");
		lbl_VoltajeEntrada.setForeground(Color.WHITE);
		lbl_VoltajeEntrada.setBounds(70, 21, 123, 14);
		panelDatosVoltajes.add(lbl_VoltajeEntrada);
		
		JLabel lbl_VoltajeSalida = new JLabel("Voltaje Salida:");
		lbl_VoltajeSalida.setForeground(Color.WHITE);
		lbl_VoltajeSalida.setBounds(203, 21, 86, 14);
		panelDatosVoltajes.add(lbl_VoltajeSalida);
		
		textField_VoltajeSalida = new JTextField();
		textField_VoltajeSalida.setBounds(203, 36, 86, 20);
		panelDatosVoltajes.add(textField_VoltajeSalida);
		textField_VoltajeSalida.setColumns(10);
		
		textField_VoltajeSalida.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                        && (c != '.') ) {
                    arg0.consume();
				}
				if (textField_VoltajeSalida.getText().length() >= 5) {
					arg0.consume();
				}
			}
		});
		
		JComboBox comboBox_voltajeEntrada = new JComboBox();
		comboBox_voltajeEntrada.setModel(new DefaultComboBoxModel(new String[] {"230", "120", "25"}));
		comboBox_voltajeEntrada.setBounds(70, 36, 82, 20);
		panelDatosVoltajes.add(comboBox_voltajeEntrada);
		comboBox_voltajeEntrada.addItem("230");
		comboBox_voltajeEntrada.addItem("120");
		
		JLabel label_voltaje = new JLabel("v");
		label_voltaje.setForeground(Color.WHITE);
		label_voltaje.setBounds(158, 42, 35, 14);
		panelDatosVoltajes.add(label_voltaje);
		
		JLabel label_4 = new JLabel("v");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(299, 42, 11, 23);
		panelDatosVoltajes.add(label_4);
		
		JLabel label_Asterisco_1 = new JLabel("*");
		label_Asterisco_1.setVisible(false);
		label_Asterisco_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_Asterisco_1.setForeground(Color.RED);
		label_Asterisco_1.setBounds(309, 37, 17, 14);
		panelDatosVoltajes.add(label_Asterisco_1);
		
		JLabel label_Asterisco_2 = new JLabel("*");
		label_Asterisco_2.setForeground(Color.RED);
		label_Asterisco_2.setVisible(false);
		label_Asterisco_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_Asterisco_2.setBounds(162, 36, 17, 14);
		panelDatosVoltajes.add(label_Asterisco_2);
		
		textField_Frecuencia = new JTextField();
		textField_Frecuencia.setColumns(10);
		textField_Frecuencia.setBounds(343, 36, 86, 20);
		panelDatosVoltajes.add(textField_Frecuencia);
		
		JLabel lblFrecuencia = new JLabel("Frecuencia:");
		lblFrecuencia.setForeground(Color.WHITE);
		lblFrecuencia.setBounds(343, 21, 86, 14);
		panelDatosVoltajes.add(lblFrecuencia);
		
		JLabel lblHz = new JLabel("Hz");
		lblHz.setForeground(Color.WHITE);
		lblHz.setBounds(439, 42, 26, 14);
		panelDatosVoltajes.add(lblHz);
		
		JLabel label_Asterisco_Hz = new JLabel("*");
		label_Asterisco_Hz.setVisible(false);
		label_Asterisco_Hz.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Asterisco_Hz.setForeground(Color.RED);
		label_Asterisco_Hz.setBounds(455, 37, 26, 14);
		panelDatosVoltajes.add(label_Asterisco_Hz);
		
		JPanel panelResultados = new JPanel();
		panelResultados.setBounds(39, 287, 848, 106);
		contentPane.add(panelResultados);
		panelResultados.setLayout(null);
		panelResultados.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Resultados ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelResultados.setOpaque(false);
		
		JLabel lbl_Potencia = new JLabel("POTENCIA:");
		lbl_Potencia.setForeground(Color.WHITE);
		lbl_Potencia.setBounds(25, 44, 86, 14);
		panelResultados.add(lbl_Potencia);
		
		JLabel lbl_VueltaPrimario = new JLabel("VUELTA PRIM.:");
		lbl_VueltaPrimario.setForeground(Color.WHITE);
		lbl_VueltaPrimario.setBounds(183, 44, 92, 14);
		panelResultados.add(lbl_VueltaPrimario);
		
		JLabel lbl_VueltaSecundario = new JLabel("VUELTA SEC.:");
		lbl_VueltaSecundario.setForeground(Color.WHITE);
		lbl_VueltaSecundario.setBounds(183, 69, 86, 14);
		panelResultados.add(lbl_VueltaSecundario);
		
		JLabel lbl_AmperPrimario = new JLabel("AMPER PRIM.:");
		lbl_AmperPrimario.setForeground(Color.WHITE);
		lbl_AmperPrimario.setBounds(405, 44, 86, 14);
		panelResultados.add(lbl_AmperPrimario);
		
		JLabel lbl_AmperSecundario = new JLabel("AMPER SEC.:");
		lbl_AmperSecundario.setForeground(Color.WHITE);
		lbl_AmperSecundario.setBounds(405, 69, 86, 14);
		panelResultados.add(lbl_AmperSecundario);
		
		JLabel lbl_RESULTADO_potencia = new JLabel("");
		lbl_RESULTADO_potencia.setForeground(Color.RED);
		lbl_RESULTADO_potencia.setFont(new Font("Arial", Font.BOLD, 17));
		lbl_RESULTADO_potencia.setBounds(25, 57, 86, 26);
		panelResultados.add(lbl_RESULTADO_potencia);
		
		JLabel lbl_vuelta_primario_RESULTADO = new JLabel("");
		lbl_vuelta_primario_RESULTADO.setForeground(Color.RED);
		lbl_vuelta_primario_RESULTADO.setBounds(277, 44, 43, 14);
		panelResultados.add(lbl_vuelta_primario_RESULTADO);
		
		JLabel lbl_vuelta_secundario_RESULTADO = new JLabel("");
		lbl_vuelta_secundario_RESULTADO.setForeground(Color.RED);
		lbl_vuelta_secundario_RESULTADO.setBounds(279, 69, 41, 14);
		panelResultados.add(lbl_vuelta_secundario_RESULTADO);
		
		JLabel lbl_amperPrimario_RESULTADO = new JLabel("");
		lbl_amperPrimario_RESULTADO.setForeground(Color.RED);
		lbl_amperPrimario_RESULTADO.setBounds(501, 44, 67, 14);
		panelResultados.add(lbl_amperPrimario_RESULTADO);
		
		JLabel lbl_AmperSecundario_RESULTADO = new JLabel("");
		lbl_AmperSecundario_RESULTADO.setForeground(Color.RED);
		lbl_AmperSecundario_RESULTADO.setBounds(494, 69, 74, 14);
		panelResultados.add(lbl_AmperSecundario_RESULTADO);
		
		JLabel lblNuevoLado = new JLabel("N:");
		lblNuevoLado.setForeground(Color.WHITE);
		lblNuevoLado.setBounds(637, 44, 81, 14);
		panelResultados.add(lblNuevoLado);
		
		JLabel lbl_nuevoLado = new JLabel("");
		lbl_nuevoLado.setForeground(Color.RED);
		lbl_nuevoLado.setBounds(722, 44, 53, 14);
		panelResultados.add(lbl_nuevoLado);
		
		JLabel lbl_Gauss = new JLabel("");
		lbl_Gauss.setForeground(Color.RED);
		lbl_Gauss.setBounds(722, 69, 53, 14);
		panelResultados.add(lbl_Gauss);
		
		JLabel lblEspv = new JLabel("esp/v");
		lblEspv.setForeground(Color.WHITE);
		lblEspv.setBounds(774, 44, 32, 14);
		panelResultados.add(lblEspv);
		
		JLabel lblA = new JLabel("A");
		lblA.setForeground(Color.WHITE);
		lblA.setBounds(561, 44, 32, 14);
		panelResultados.add(lblA);
		
		JLabel label_7 = new JLabel("A");
		label_7.setForeground(Color.WHITE);
		label_7.setBounds(561, 69, 32, 14);
		panelResultados.add(label_7);
		
		JLabel lblN = new JLabel("N");
		lblN.setForeground(Color.WHITE);
		lblN.setBounds(323, 44, 32, 14);
		panelResultados.add(lblN);
		
		JLabel label_8 = new JLabel("N");
		label_8.setForeground(Color.WHITE);
		label_8.setBounds(323, 69, 32, 14);
		panelResultados.add(label_8);
		
		JLabel lblW = new JLabel("W");
		lblW.setForeground(Color.WHITE);
		lblW.setBounds(95, 44, 32, 14);
		panelResultados.add(lblW);
		
		JLabel lblGaus = new JLabel("gaus");
		lblGaus.setForeground(Color.WHITE);
		lblGaus.setBounds(774, 69, 32, 14);
		panelResultados.add(lblGaus);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		label_2.setBounds(722, 69, 53, 14);
		panelResultados.add(label_2);
		
		JLabel lblB = new JLabel("B:");
		lblB.setForeground(Color.WHITE);
		lblB.setBounds(637, 69, 81, 14);
		panelResultados.add(lblB);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(41, 392, 89, 23);
		contentPane.add(btnCalcular);
		btnCalcular.setForeground(Color.WHITE);
		btnCalcular.setBackground(Color.RED);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				codigo.sonidoCerrar();
				dispose();
			}
		});
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setBounds(239, 392, 89, 23);
		contentPane.add(btnCerrar);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					codigo.sonidoLimpiar();
					textField_LadoInterno.setText(null);
					textField_AnchoInterno.setText(null);
					
					textField_VoltajeSalida.setText(null);
				
			}
		});
		btnRestart.setForeground(Color.BLACK);
		btnRestart.setBackground(Color.LIGHT_GRAY);
		btnRestart.setBounds(140, 392, 89, 23);
		contentPane.add(btnRestart);
		
		JPanel panel = new JPanel();
		
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "  Intensidad & Sección  ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setOpaque(false);
		
		panel.setBounds(535, 11, 341, 247);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPrimarioa = new JLabel("Prim. (A):");
		lblPrimarioa.setForeground(Color.WHITE);
		lblPrimarioa.setBounds(117, 27, 86, 14);
		panel.add(lblPrimarioa);
		
		JLabel lblSecundarioa = new JLabel("Sec. (A):");
		lblSecundarioa.setForeground(Color.WHITE);
		lblSecundarioa.setBounds(117, 52, 86, 14);
		panel.add(lblSecundarioa);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(17, 84, 301, 5);
		panel.add(separator);
		
		JLabel lblPrimario = new JLabel("Prim. (\u00D8):");
		lblPrimario.setForeground(Color.WHITE);
		lblPrimario.setBounds(162, 182, 86, 14);
		panel.add(lblPrimario);
		
		JLabel lblSecundario = new JLabel("Sec. (\u00D8):");
		lblSecundario.setForeground(Color.WHITE);
		lblSecundario.setBounds(162, 207, 86, 14);
		panel.add(lblSecundario);
		
		
		textField_PrimarioAmperes.setColumns(10);
		textField_PrimarioAmperes.setBounds(204, 24, 68, 20);
		panel.add(textField_PrimarioAmperes);
		
		textField_PrimarioAmperes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                        && (c != '.') ) {
                    arg0.consume();
				}
				if (textField_PrimarioAmperes.getText().length() >= 5) {
					arg0.consume();
				}
			}
		});
		
		textField_SecundarioAmperes = new JTextField();
		textField_SecundarioAmperes.setColumns(10);
		textField_SecundarioAmperes.setBounds(204, 52, 68, 20);
		panel.add(textField_SecundarioAmperes);
		
		textField_SecundarioAmperes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				char c = arg0.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                        && (c != '.') ) {
                    arg0.consume();
				}
				if (textField_SecundarioAmperes.getText().length() >= 5) {
					arg0.consume();
				}
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 131, 308, 5);
		panel.add(separator_1);
		
		JLabel lblDensidad = new JLabel("Densidad :");
		lblDensidad.setForeground(Color.WHITE);
		lblDensidad.setBounds(93, 103, 86, 14);
		panel.add(lblDensidad);
		
		JComboBox comboBoxDensidad = new JComboBox();
		comboBoxDensidad.setBounds(180, 100, 68, 20);
		comboBoxDensidad.addItem("3.5");
		comboBoxDensidad.addItem("3");
		comboBoxDensidad.addItem("4");
		panel.add(comboBoxDensidad);
		
		
		btnCalcularSeccin.setVisible(false);
		btnCalcularSeccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnManual.isSelected()){
				
				if(
						textField_PrimarioAmperes.equals("") || 
						textField_PrimarioAmperes.getText().equals("") 
       				
						){
					codigo.sonidoDing();
					JOptionPane.showMessageDialog(null, " Por favor completar\n los campos obligatorios,\n gracias","Mensaje",JOptionPane.ERROR_MESSAGE, img);
					
					label_Asterisco_10.setVisible(true);
					label_Asterisco_11.setVisible(true);
					
					
				}else{
					
					label_Asterisco_10.setVisible(false);
					label_Asterisco_11.setVisible(false);
					codigo.sonidoPasar();
					
				String amperes_primario = textField_PrimarioAmperes.getText();
				String amperes_secundario = textField_SecundarioAmperes.getText();
				String densidad = (String) comboBoxDensidad.getSelectedItem();
				
				double amperP = Double.parseDouble(amperes_primario);
				double amperS = Double.parseDouble(amperes_secundario);
				double densidadElegida = Double.parseDouble(densidad);
				
				double diametroP = Math.sqrt(amperP/densidadElegida/Math.PI)*2;
				double diametroS = Math.sqrt(amperS/densidadElegida/Math.PI)*2;
				
				String diametroP_string = Double.toString(controlador.formatearDecimales(diametroP,4));
				String diametroS_string = Double.toString(controlador.formatearDecimales(diametroS,4));
				label_resultadoPrimario.setText(diametroP_string);
				label_ResultadoSecundario.setText(diametroS_string);
				
				label_Seccion_1.setText(Double.toString(controlador.formatearDecimales(amperP/densidadElegida,2)));
				label_Seccion_2.setText(Double.toString(controlador.formatearDecimales(amperS/densidadElegida,2)));
				//label_Seccion_2.setText(densidad/amperS);
				
				}
			}else{
				codigo.sonidoDing();
				JOptionPane.showMessageDialog(null, " Por favor selecciona manual y completa datos,\n gracias","Mensaje",JOptionPane.ERROR_MESSAGE, img);
				
			}
			}
		});
		
		
		
		btnCalcularSeccin.setForeground(Color.BLACK);
		btnCalcularSeccin.setBackground(Color.LIGHT_GRAY);
		btnCalcularSeccin.setBounds(117, 148, 155, 23);
		panel.add(btnCalcularSeccin);
		
		
		label_resultadoPrimario.setForeground(Color.RED);
		label_resultadoPrimario.setBounds(245, 182, 86, 14);
		panel.add(label_resultadoPrimario);
		
		
		label_ResultadoSecundario.setForeground(Color.RED);
		label_ResultadoSecundario.setBounds(245, 207, 86, 14);
		panel.add(label_ResultadoSecundario);
		
		
		label_Asterisco_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Asterisco_10.setForeground(Color.RED);
		label_Asterisco_10.setBounds(277, 25, 9, 14);
		panel.add(label_Asterisco_10);
		
		
		label_Asterisco_11.setForeground(Color.RED);
		label_Asterisco_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_Asterisco_11.setBounds(277, 52, 9, 14);
		panel.add(label_Asterisco_11);
		
		
		label_Seccion_1.setForeground(Color.RED);
		label_Seccion_1.setBounds(94, 182, 58, 14);
		panel.add(label_Seccion_1);
		
		
		label_Seccion_2.setForeground(Color.RED);
		label_Seccion_2.setBounds(94, 207, 58, 14);
		panel.add(label_Seccion_2);
		
		JLabel lblPrimMm = new JLabel("Prim. mm2:");
		lblPrimMm.setForeground(Color.WHITE);
		lblPrimMm.setBounds(10, 182, 86, 14);
		panel.add(lblPrimMm);
		
		JLabel lblSecMm = new JLabel("Sec. mm2:");
		lblSecMm.setForeground(Color.WHITE);
		lblSecMm.setBounds(10, 207, 86, 14);
		panel.add(lblSecMm);
		
		
		rdbtnManual.setBounds(17, 23, 68, 23);
		panel.add(rdbtnManual);
		btnCalcular.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if(
						textField_LadoInterno.equals("") || 
       					textField_AnchoInterno.getText().equals("") ||
       					textField_VoltajeSalida.getText().equals("") ||	
       					textField_Frecuencia.getText().equals("")	
       					
       					
						
						){
					
					codigo.sonidoDing();
					JOptionPane.showMessageDialog(null, "Por favor completar \nlos campos obligatorios, \ngracias","Mensaje",JOptionPane.ERROR_MESSAGE, img);
					
					label_Asterisco_1.setVisible(true);
					label_Asterisco_2.setVisible(true);
					label_Asterisco_3.setVisible(true);
					label_Asterisco_4.setVisible(true);
					label_Asterisco_Hz.setVisible(true);
					
					
				
				}
					
				else{
					
					label_Asterisco_1.setVisible(false);
					label_Asterisco_2.setVisible(false);
					label_Asterisco_3.setVisible(false);
					label_Asterisco_4.setVisible(false);
					label_Asterisco_Hz.setVisible(false);
					
				
								
				codigo.sonidoPasar();
				String ladInt = textField_LadoInterno.getText();
				String anchoInt = textField_AnchoInterno.getText();
				String voltajeEntrada = (String) comboBox_voltajeEntrada.getSelectedItem();
				String voltajeSalida =textField_VoltajeSalida.getText();
				
				
				double ladoInterno = Double.parseDouble(ladInt);
				double anchoInterno = Double.parseDouble(anchoInt);
				double voltaje_Entrada = Double.parseDouble(voltajeEntrada);
				double voltaje_Salida = Double.parseDouble(voltajeSalida);
				
				
				double areaTotal = controlador.area(ladoInterno, anchoInterno);
				double potencia = 0;
				double constante = 1.2;
				double gauss = 10000;
				double potenciaReal = codigo.buscarConstantePOTENCIA_Ch(areaTotal);
				
				if(potenciaReal <= 150){
					 constante = 1.5;
					 gauss = 8000;
						
				}else if(potenciaReal <= 990){
					 constante = 1.2;
					 gauss = 10000;
				}else if(potenciaReal <= 4000){
					 constante = 1;
					 gauss = 12000;
				}
				double frecuencia = Double.parseDouble(textField_Frecuencia.getText());
				
				double potenciaReal_Ch = codigo.potenciaReal_Ch(potenciaReal, constante);
				String potenciaReal_Cha = Double.toString(controlador.formatearDecimales(potenciaReal_Ch,2));
				lbl_RESULTADO_potencia.setText( potenciaReal_Cha);
				lbl_Gauss.setText(Double.toString(controlador.formatearDecimales(gauss,0)));
				
				double voltajeEspira = codigo.voltajeVueltaEspira_Ch(areaTotal,frecuencia,gauss);
				String voltajeEspira_1 = Double.toString(controlador.formatearDecimales(voltajeEspira,2));
				lbl_nuevoLado.setText(voltajeEspira_1);
				
				double vueltasPrimario = codigo.vueltasPrimario_Ch(voltajeEspira, voltaje_Entrada);
				String vueltas_primario_1 = Double.toString(controlador.formatearDecimales(vueltasPrimario,2));
				
				double vueltasSecundario = codigo.vueltasPrimario_Ch(voltajeEspira, voltaje_Salida);
				String vueltas_secundario_1 = Double.toString(controlador.formatearDecimales(vueltasSecundario,2));
				
				double intensidadPrimario = controlador.intensidadPrimario(potenciaReal_Ch, voltaje_Entrada);
				String intensidadPrimario_1 = Double.toString(controlador.formatearDecimales(intensidadPrimario,2));
				
				double intensidadSecundario = controlador.intensidadPrimario(potenciaReal_Ch, voltaje_Salida);
				String intensidadSecundario_1 = Double.toString(controlador.formatearDecimales(intensidadSecundario,2));
			
				
								
				
				
				lbl_vuelta_primario_RESULTADO.setText(vueltas_primario_1);
				lbl_vuelta_secundario_RESULTADO.setText(vueltas_secundario_1);
				lbl_amperPrimario_RESULTADO.setText(intensidadPrimario_1);
				lbl_AmperSecundario_RESULTADO.setText(intensidadSecundario_1);
				
				
				
				
				
					if(!rdbtnManual.isSelected()){
					
						
					textField_PrimarioAmperes.setText(intensidadPrimario_1);
					textField_SecundarioAmperes.setText(intensidadSecundario_1);
					
					String densidad = (String) comboBoxDensidad.getSelectedItem();
					
					double amperP = intensidadPrimario;
					double amperS = intensidadSecundario;
					double densidadElegida = Double.parseDouble(densidad);
					
					double diametroP = Math.sqrt(amperP/densidadElegida/Math.PI)*2;
					double diametroS = Math.sqrt(amperS/densidadElegida/Math.PI)*2;
					
					String diametroP_string = Double.toString(controlador.formatearDecimales(diametroP,4));
					String diametroS_string = Double.toString(controlador.formatearDecimales(diametroS,4));
					label_resultadoPrimario.setText(diametroP_string);
					label_ResultadoSecundario.setText(diametroS_string);
					
					label_Seccion_1.setText(Double.toString(controlador.formatearDecimales(amperP/densidadElegida,2)));
					label_Seccion_2.setText(Double.toString(controlador.formatearDecimales(amperS/densidadElegida,2)));
										
					}
							
				
				}
			}
			
		});
		
		
		
	}
	}
		
			


