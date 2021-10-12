package concurrency;


import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @description:
 * @author: zyb
 * @date: 2020/9/22 12:10
 */
public class GuiTest01 extends JFrame {

    private GuiTest01() {

        this.setTitle("Find/Replace");
        this.setSize(600, 600);
        this.setLocation(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // find
        JPanel panelFind = new JPanel();
        JLabel findLabel = new JLabel("Find:");
        JComboBox findBox = new JComboBox();
        findBox.setEditable(true);
        panelFind.setLayout(new GridLayout(1, 2));
        panelFind.add(findLabel);
        panelFind.add(findBox);

        // replace
        JPanel panelReplace = new JPanel();
        panelReplace.setLayout(new GridLayout(1, 2));
        JLabel replaceLabel = new JLabel("Replace with:");
        ;
        JComboBox replaceBox = new JComboBox();
        replaceBox.setEditable(true);
        panelReplace.add(replaceLabel);
        panelReplace.add(replaceBox);

        // find and replace
        JPanel panelArea1 = new JPanel();
        panelArea1.setLayout(new BoxLayout(panelArea1, BoxLayout.Y_AXIS));
        panelArea1.add(panelFind);
        panelArea1.add(panelReplace);

        // direction
        JPanel panelDirection = new JPanel();
        panelDirection.setLayout(new BoxLayout(panelDirection, BoxLayout.Y_AXIS));
        JRadioButton forButton = new JRadioButton("Forward");
        JRadioButton backButton = new JRadioButton("Backward");
        ButtonGroup directionGroup = new ButtonGroup();
        directionGroup.add(forButton);
        directionGroup.add(backButton);
        panelDirection.add(forButton);
        panelDirection.add(backButton);
        panelDirection.setBorder(BorderFactory.createTitledBorder("Director"));

        // scope
        JPanel panelScope = new JPanel();
        panelScope.setLayout(new BoxLayout(panelScope, BoxLayout.Y_AXIS));
        JRadioButton allButton = new JRadioButton("All");
        JRadioButton selectedButton = new JRadioButton("Seleted lines");
        ButtonGroup scopeGroup = new ButtonGroup();
        scopeGroup.add(allButton);
        scopeGroup.add(selectedButton);
        panelScope.add(allButton);
        panelScope.add(selectedButton);
        panelScope.setBorder(BorderFactory.createTitledBorder("Scope"));

        // direction and scope
        JPanel panelDireAndScope = new JPanel();
        panelDireAndScope.setLayout(new GridLayout(1, 2));
        panelDireAndScope.add(panelDirection);
        panelDireAndScope.add(panelScope);

        // options
        JPanel panelOptions = new JPanel();
        panelOptions.setLayout(new GridLayout(3, 2));
        JCheckBox checkBox1 = new JCheckBox("Case sensitive");
        JCheckBox checkBox2 = new JCheckBox("Wrap search");
        JCheckBox checkBox3 = new JCheckBox("Whole word");
        JCheckBox checkBox4 = new JCheckBox("Incremental");
        JCheckBox checkBox5 = new JCheckBox("Regular expressions");
        ButtonGroup optionsGroup = new ButtonGroup();
        optionsGroup.add(checkBox1);
        optionsGroup.add(checkBox2);
        optionsGroup.add(checkBox3);
        optionsGroup.add(checkBox4);
        optionsGroup.add(checkBox5);
        panelOptions.add(checkBox1);
        panelOptions.add(checkBox2);
        panelOptions.add(checkBox3);
        panelOptions.add(checkBox4);
        panelOptions.add(checkBox5);
        panelOptions.setBorder(BorderFactory.createTitledBorder("Options"));

        // choose buttons
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(3, 2));
        JButton btnFind = new JButton("Find");
        JButton btnReOrFind = new JButton("Replace/Find");
        JButton btnReplace = new JButton("Replace");
        JButton btnReplaceAll = new JButton("Replace All");
        JLabel lblNull = new JLabel("");
        JButton btnClose = new JButton("Close");
        panelButtons.add(btnFind);
        panelButtons.add(btnReOrFind);
        panelButtons.add(btnReplace);
        panelButtons.add(btnReplaceAll);
        panelButtons.add(lblNull);
        panelButtons.add(btnClose);

        // panel south
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(panelButtons, BorderLayout.EAST);

        // panel north
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(3, 1));
        northPanel.add(panelArea1);
        northPanel.add(panelDireAndScope);
        northPanel.add(panelOptions);

        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        // Single mode
        GuiTest01 mainView = new GuiTest01();
    }

}
