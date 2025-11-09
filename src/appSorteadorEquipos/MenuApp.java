package appSorteadorEquipos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.io.*;

public class MenuApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelBg;
	private JTextField txtNombreEquipo;
	private JTable tablaEquiposAgregados;
	private DefaultTableModel modeloTabla;
	private JComboBox <String> cbEtapasCampeonato;
	private String[] etapasCampeonato = {"Octavos de final", "Cuartos de final", "Semifinales"};
	private String[] nombresColumnas= {"Nombre del equipo"};
	private JButton btnAgregarEquipo, btnSortearPartidos;
	private JTextArea txtContenedorResultados;
	
	public MenuApp() {
		Organizador organizador = new Organizador();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 550);
		panelBg = new JPanel();
		panelBg.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelBg);
		panelBg.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(0, 150, 136));
		panelPrincipal.setBounds(0, 0, 746, 513);
		panelBg.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblTitulo = new JLabel("EMPAREJADOR DE EQUIPOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 18));
		lblTitulo.setBounds(269, 10, 261, 34);
		panelPrincipal.add(lblTitulo);
		
		JPanel panelCentralDatos = new JPanel();
		panelCentralDatos.setBackground(new Color(128, 203, 196));
		panelCentralDatos.setBounds(0, 92, 746, 363);
		panelPrincipal.add(panelCentralDatos);
		panelCentralDatos.setLayout(null);
		
		btnAgregarEquipo = new JButton("AGREGAR EQUIPO");
		btnAgregarEquipo.setForeground(new Color(31, 58, 61));
		btnAgregarEquipo.setBackground(new Color(255, 255, 255));
		btnAgregarEquipo.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnAgregarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//accion realizada en octavos de final
				if("Octavos de final".equals(cbEtapasCampeonato.getSelectedItem())) {
					
					//mensaje de error cuando el nombre del equipo esta vacio
					if(txtNombreEquipo.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(MenuApp.this, "Debe ingresar el nombre de un equipo.", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					//creacion del equipo e ingreso de datos al sistema
					String nombreEquipo = txtNombreEquipo.getText().trim();
					organizador.agregarEquipo(nombreEquipo);
					
					//el boton de agregar se desactiva al alcanzar el limite de equipos en esta etapa
					if(organizador.getListaEquipos().size() == 16) {
						btnAgregarEquipo.setEnabled(false);
					}	
					
					//mensaje de exito al agregar equipo
					JOptionPane.showMessageDialog(MenuApp.this, "Equipo " + nombreEquipo + " agregado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
					actualizarTabla(nombreEquipo);
					txtNombreEquipo.setText("");
				}
				
				//accion realizada en cuartos de final
				if("Cuartos de final".equals(cbEtapasCampeonato.getSelectedItem())) {
					
					//mensaje de error cuando el nombre del equipo esta vacio
					if(txtNombreEquipo.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(MenuApp.this, "Debe ingresar el nombre de un equipo.", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					//creacion del equipo e ingreso de datos al sistema
					String nombreEquipo = txtNombreEquipo.getText().trim();
					organizador.agregarEquipo(nombreEquipo);
					
					//el boton de agregar se desactiva al alcanzar el limite de equipos en esta etapa
					if(organizador.getListaEquipos().size() == 8) {
						btnAgregarEquipo.setEnabled(false);
					}	
					
					//mensaje de exito al agregar equipo
					JOptionPane.showMessageDialog(MenuApp.this, "Equipo " + nombreEquipo + " agregado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
					actualizarTabla(nombreEquipo);
					txtNombreEquipo.setText("");
					
				}
				
				//accion realizada en semifinales
				if("Semifinales".equals(cbEtapasCampeonato.getSelectedItem())) {
					
					//mensaje de error cuando el nombre del equipo esta vacio
					if(txtNombreEquipo.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(MenuApp.this, "Debe ingresar el nombre de un equipo.", "Error de validación", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					//creacion del equipo e ingreso de datos al sistema
					String nombreEquipo = txtNombreEquipo.getText().trim();
					organizador.agregarEquipo(nombreEquipo);
					
					//el boton de agregar se desactiva al alcanzar el limite de equipos en esta etapa
					if(organizador.getListaEquipos().size() == 4) {
						btnAgregarEquipo.setEnabled(false);
					}	
					
					//mensaje de exito al agregar equipo
					JOptionPane.showMessageDialog(MenuApp.this, "Equipo " + nombreEquipo + " agregado correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
					actualizarTabla(nombreEquipo);
					txtNombreEquipo.setText("");
				}
				
			}
		});
		btnAgregarEquipo.setBounds(237, 26, 134, 28);
		panelCentralDatos.add(btnAgregarEquipo);
		
		JLabel lblNombreDelEquipo = new JLabel("NOMBRE DEL EQUIPO:");
		lblNombreDelEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelEquipo.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNombreDelEquipo.setBounds(0, 0, 174, 28);
		panelCentralDatos.add(lblNombreDelEquipo);
		
		txtNombreEquipo = new JTextField();
		txtNombreEquipo.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtNombreEquipo.setBounds(10, 27, 182, 28);
		panelCentralDatos.add(txtNombreEquipo);
		txtNombreEquipo.setColumns(10);
		
		modeloTabla = new DefaultTableModel();
		tablaEquiposAgregados = new JTable(modeloTabla);
		tablaEquiposAgregados.setFont(new Font("Roboto", Font.PLAIN, 10));
		modeloTabla.setColumnIdentifiers(nombresColumnas);
		tablaEquiposAgregados.setBackground(new Color(178, 223, 219));
		tablaEquiposAgregados.setForeground(new Color(0, 0, 0));
		tablaEquiposAgregados.setRowSelectionAllowed(false);
		tablaEquiposAgregados.setBounds(10, 74, 361, 267);
		tablaEquiposAgregados.setFillsViewportHeight(true);
		panelCentralDatos.add(tablaEquiposAgregados);
		
		txtContenedorResultados = new JTextArea();
		txtContenedorResultados.setLineWrap(true);
		txtContenedorResultados.setWrapStyleWord(true);
		txtContenedorResultados.setEditable(false);
		txtContenedorResultados.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtContenedorResultados.setForeground(new Color(0, 0, 0));
		txtContenedorResultados.setBackground(new Color(175, 238, 238));
		txtContenedorResultados.setBounds(381, 74, 355, 267);
		panelCentralDatos.add(txtContenedorResultados);
		
		JLabel lblSelector = new JLabel("SELECCIONE LA ETAPA DEL CAMPEONATO:");
		lblSelector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelector.setFont(new Font("Roboto", Font.BOLD, 14));
		lblSelector.setBounds(0, 54, 313, 28);
		panelPrincipal.add(lblSelector);
		
		cbEtapasCampeonato = new JComboBox<String>(etapasCampeonato);
		cbEtapasCampeonato.setFont(new Font("Roboto", Font.PLAIN, 12));
		cbEtapasCampeonato.setBounds(475, 54, 261, 28);
		panelPrincipal.add(cbEtapasCampeonato);
		cbEtapasCampeonato.addItemListener(new ItemListener() {
		//limpia la tabla y la lista de equipos al cambiar de etapa
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					limpiarTabla();
					organizador.listaEquipos.clear();
					btnAgregarEquipo.setEnabled(true);
				}
				
			}
			
		});
		
		btnSortearPartidos = new JButton("SORTEAR PARTIDOS");
		btnSortearPartidos.setForeground(new Color(31, 58, 61));
		btnSortearPartidos.setBackground(new Color(255, 255, 255));
		btnSortearPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtContenedorResultados.setText("");
				if("Octavos de final".equals(cbEtapasCampeonato.getSelectedItem()) && organizador.getListaEquipos().size() < 16) {
					JOptionPane.showMessageDialog(MenuApp.this, "Esta etapa requiere 16 equipos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				} else if("Cuartos de final".equals(cbEtapasCampeonato.getSelectedItem()) && organizador.getListaEquipos().size() < 8) {
					JOptionPane.showMessageDialog(MenuApp.this, "Esta etapa requiere 8 equipos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				} else if("Semifinales".equals(cbEtapasCampeonato.getSelectedItem()) && organizador.getListaEquipos().size() < 4) {
					JOptionPane.showMessageDialog(MenuApp.this, "Esta etapa requiere 4 equipos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					ArrayList<String> partidos = new ArrayList <>(organizador.sortearPartidos());
					mostrarResultados(partidos);
					
					//pregunta a usuario si desea guardar el sorteo en un archivo
					int opcion = JOptionPane.showConfirmDialog(MenuApp.this, "¿Quiere guardar estos resultados en un archivo?",
							"Guardar resultados", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					
					//si el usuario desea guardar el archivo entonces se llama al metodo que permite esa accion
					if (opcion == JOptionPane.YES_OPTION) {
						guardarResultados(partidos);
					}
					
					//limpia la tabla y reinicia la app
					limpiarTabla();
					btnAgregarEquipo.setEnabled(true);
					organizador.listaEquipos.clear();
					
				} catch (InvalidTeamsException ex) {
					JOptionPane.showMessageDialog(MenuApp.this, "Error crítico: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					
				} catch (Exception ex1) {
					JOptionPane.showMessageDialog(MenuApp.this, "Error inesperado: " + ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
					
			}
		});
		btnSortearPartidos.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnSortearPartidos.setBounds(300, 465, 165, 28);
		panelPrincipal.add(btnSortearPartidos);
		
	}
	
	//actualiza la tabla con cada nueva entrada
	private void actualizarTabla(String nombreEquipo) {
		
		Object [] nuevoEquipo = new Object[] {nombreEquipo};
		
		if(modeloTabla != null) {
			modeloTabla.addRow(nuevoEquipo);
		}
		
		tablaEquiposAgregados.revalidate();
		tablaEquiposAgregados.repaint();
	}
	
	//limpia la tabla
	private void limpiarTabla() {
		
		if(modeloTabla != null) {
			while(modeloTabla.getRowCount() > 0) {
				modeloTabla.removeRow(0);
			}
		}
	}
	
	//muestra los resultados del sorteo
	private void mostrarResultados(ArrayList<String> partidos) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("---- PARTIDOS QUE SE LIBRARÁN EN ESTA ETAPA ----\n");
		
		for(int i = 0; i < partidos.size(); i++) {
			sb.append("Partido " + (i+1) + ": " + partidos.get(i) + "\n");
		}
		
		txtContenedorResultados.setText(sb.toString());
		JOptionPane.showMessageDialog(MenuApp.this, "Sorteo realizado exitosamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	//guarda los resultados en un archivo de texto
	private void guardarResultados(ArrayList<String> partidos) {
		JFileChooser archivo = new JFileChooser();
		archivo.setDialogTitle("Guardar resultados");
		
		archivo.setSelectedFile(new File("Resultados_Sorteo_" + cbEtapasCampeonato.getSelectedItem().toString().trim() + ".txt"));
		
		int eleccionUsuario = archivo.showSaveDialog(this);
		
		if(eleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File archivoParaGuardar = archivo.getSelectedFile();
			try(PrintWriter writer = new PrintWriter(new FileWriter(archivoParaGuardar))){
				
				writer.println("---------RESULTADOS SORTEO ETAPA " + cbEtapasCampeonato.getSelectedItem().toString().toUpperCase().trim() + "-------------");
				writer.println("------------------------------------------------------------------------");
				
				for(int i = 0; i < partidos.size(); i++) {
					writer.println("PARTIDO " + (i+1) + ": " + partidos.get(i));
				}
				
				JOptionPane.showMessageDialog(MenuApp.this, "Archivo guardado con éxito en: \n." + archivoParaGuardar.getAbsolutePath(), 
						"Exito", JOptionPane.INFORMATION_MESSAGE);
				
			} catch(IOException e) {
				JOptionPane.showMessageDialog(MenuApp.this, "Error de escritura: " + e.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		
	}
	
}
