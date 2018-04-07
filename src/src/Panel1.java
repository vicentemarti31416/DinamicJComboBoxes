package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Panel1 extends JPanel {

    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private Linked_Active_Records records = new Linked_Active_Records();
    private PanelListener panelListener;
    private FlowLayout flowLayout;
    private Set<String> finalRecords;

    public Panel1() {
            comboBox1 = new JComboBox();
            finalRecords = records.getInitialRecords();
            for (String ciudades : finalRecords) {
                comboBox1.addItem(ciudades);
            }
            comboBox2 = new JComboBox();
            flowLayout = new FlowLayout();
            setLayout(flowLayout);
            add(comboBox1);
            add(comboBox2);
            panelListener = new PanelListener();
            comboBox1.addActionListener(panelListener);
    }

    private class PanelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            finalRecords = records.getFinalRecords(comboBox1.getSelectedItem());
            comboBox2.removeAllItems();
            for (String item: finalRecords) {
                comboBox2.addItem(item);
            }
        }
    }
}

