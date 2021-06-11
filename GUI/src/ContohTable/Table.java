package ContohTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {
    private JTextField textAngka;
    private JButton urutkanButton;
    private JPanel rootPanel;
    private JTable table1;
    private JTextField textJumlah;
    private DefaultTableModel tableModel;
    private boolean tambahkan = false;

    public JPanel getRootPanel1() {
        return rootPanel;
    }

    public Table() {
        this.initComponents();

        urutkanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table1.getModel();
                String input = textAngka.getText();
                int jumlah = Integer.parseInt(textJumlah.getText());
                String[] xlt = input.split(",");
                if (textJumlah.getText().length()>3){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Data Melebihi Kapasitas!",
                            "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (xlt.length > jumlah || xlt.length < jumlah){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Jumlah Angka Tidak Sesuai!",
                            "PERHATIAN!!",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!tambahkan) {
                    for (int i = 0; i < jumlah; i++) {
                        model.addRow(new Object[]{});
                    }
                    tambahkan = true;
                }
                int a = 0;
                for (int i : Urutan.getAsce(input, jumlah)){
                    model.setValueAt(i, a, 0);
                    a++;
                }
                int b = 0;
                for (int i : Urutan.getDesc(input, jumlah)){
                    model.setValueAt(i, b, 1);
                    b++;
                }

            }
        });

    }

    private void initComponents() {
        Object[] tableColom = {
                "Ascending",
                "Descending"
        };
        Object[][] iniData = {

        };
        tableModel = new DefaultTableModel(iniData, tableColom);
        table1.setModel(tableModel);
        table1.setAutoCreateRowSorter(true);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

}