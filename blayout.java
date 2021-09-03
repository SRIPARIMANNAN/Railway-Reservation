import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public interface blayout {

    public static void main(final String[] args) {

        JFrame frame = new JFrame();

        final int FRAME_WIDTH = 1000;
        final int FRAME_HEIGHT = 1000;

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

    
        // Content Panel
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(-1, 1));
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setPreferredSize(new Dimension(1200, 1900));
        p2.setAutoscrolls(true);

        JScrollPane scrollPane = new JScrollPane(p2);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1000, 1000);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(990, 1000));
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel[] sp1 = new JPanel[10000] ;
        for (int i = 0; i < 20; i++) {

            sp1[i]= new JPanel();
            sp1[i].setLayout(new FlowLayout());
            sp1[i].setBackground(Color.black);
            sp1[i].setPreferredSize(new Dimension(900, 180));
            sp1[i].setBorder(new LineBorder(Color.RED));

            p2.add(sp1[i]);

        }

        // contentPane.add(p2);
       
        // frame.add(p2);
        // frame.setContentPane(contentPane);
        frame.add(contentPane);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }

}