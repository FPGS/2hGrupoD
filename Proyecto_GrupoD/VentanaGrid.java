import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

public class VentanaGrid {
    // elementos graficos a visualizar
    private JFrame frame;
    private JTable table;
    private char[][] contenido;
    int rows = 30, columns = 30;

    /**
     * crea una ventana con un grid de 30x30 posiciones todas ellas en blanco..
     */
    public VentanaGrid() {
        // inicializamos el grid de celulas
        contenido = new char[rows][columns];
        for (int i = 0; i < contenido.length; i++) {
            for (int j = 0; j < contenido[0].length; j++) {
                contenido[i][j] = ' ';
            }
        }

        // construimos la representaci�n gr�fica
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 600, 599);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        // construimos el modelo de la tabla
        TableModel dataModel = new AbstractTableModel() {
                private static final long serialVersionUID = 6701872192730589499L;

                public int getColumnCount() {
                    return rows;
                }

                public int getRowCount() {
                    return columns;
                }

                public Object getValueAt(int row, int col) {
                    return "";
                }
            };

        table = new JTable(dataModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(19);
        frame.getContentPane().add(table, BorderLayout.CENTER);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                private static final long serialVersionUID = 6703872492730589499L;

                public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);

                    if (contenido[row][column] == ' ') {
                        c.setBackground(Color.WHITE);
                    } else if (contenido[row][column] == '@') {
                        c.setBackground(Color.cyan);
                    } else {
                        c.setBackground(Color.orange);
                    }
                    return this;
                }
            });
        frame.setVisible(true);
    }

    /**
     * ilumna la casilla (row,col) con color cyan si tiene otro color, lo cambia
     * 
     * @param row
     *            fila donde esta la casilla a iluminar
     * @param col
     *            columna donde esta al casilla a iluminar
     */
    public void iluminarCasillaColor1(int row, int col) {
        if (row >= 0 && col >= 0 && row < table.getRowCount()
        && col < table.getColumnCount()) {
            contenido[row][col] = '@';
            table.repaint();
        }
    }

    /**
     * ilumna la casilla (row,col) con color naranja si tiene otro color, lo
     * cambia
     * 
     * @param row
     *            fila donde esta la casilla a iluminar
     * @param col
     *            columna donde esta al casilla a iluminar
     */
    public void iluminarCasillaColor2(int row, int col) {
        if (row >= 0 && col >= 0 && row < table.getRowCount()
        && col < table.getColumnCount()) {
            contenido[row][col] = '#';
            table.repaint();
        }
    }

    /**
     * apaga la casilla (row,col), lo pone en color blanco
     * 
     * @param row
     *            fila de la casilla a apagar
     * @param col
     *            columna de la casilla a apagar
     */
    public void apagarCasilla(int row, int col) {
        if (row >= 0 && col >= 0 && row < table.getRowCount()
        && col < table.getColumnCount()) {
            contenido[row][col] = ' ';
            table.repaint();
        }
    }

    /**
     * detiene la ejecucion del programa un numero de milisegundos
     * 
     * @param miliseg
     *            milisegundos que se detendria la ejecucion del programa
     */
    public void esperar(int miliseg) {
        try {
            Thread.sleep(miliseg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * cierra la ventana con el grid de celulas
     */
    public void cerrarVentana() {
        frame.dispose();
    }
}