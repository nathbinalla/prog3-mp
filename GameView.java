//not complete, this only shows a grid and the N, E, W, S buttons 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class GameView extends JFrame{

    private JButton btnNorth;
	private JButton btnEast;
	private JButton btnSouth;
    private JButton btnWest;

    private JLabel turn;

    public GameView()
    {
        super("Animal Chess");

        setLayout (new BorderLayout ());
		
		    drawGame ();
		
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setSize (600, 600);
        setVisible (true);
    }

    private void drawGame()
    {
// south
		JPanel panelSouth;

		panelSouth = new JPanel ();
		panelSouth.setLayout (new FlowLayout ());
		
        //up button
		btnNorth = new JButton ("N");
		btnNorth.setEnabled (false);
		panelSouth.add (btnNorth);

        //right button
        btnEast = new JButton ("E");
		btnEast.setEnabled (false);
		panelSouth.add (btnEast);

        //down button
        btnSouth = new JButton ("S");
		btnSouth.setEnabled (false);
		panelSouth.add (btnSouth);

        //left button
        btnWest = new JButton ("W");
		btnWest.setEnabled (false);
		panelSouth.add (btnWest);

		add (panelSouth, BorderLayout.SOUTH);

// north
		JPanel panelNorth = new JPanel ();
		panelNorth.setLayout (new FlowLayout ());

		turn = new JLabel ("Player's Turn");
		panelNorth.add (turn);

		add (panelNorth, BorderLayout.NORTH);
		
// center
		JPanel board = new JPanel(new GridLayout(9, 7));

        board.setBorder(BorderFactory.createEmptyBorder());
        board.setBackground(Color.BLACK);

        JPanel[][] panels = new JPanel[9][7];
        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                panels[i][j] = new JPanel(new GridLayout(1, 1, 1, 1));
                //panels[i][j].setBackground(BG);
                panels[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                board.add(panels[i][j]);
            }
        }
 
		add (board, BorderLayout.CENTER);
    }

    public void setListener (ActionListener listener)
	{
		  btnNorth.addActionListener (listener);
		  btnEast.addActionListener (listener);
		  btnSouth.addActionListener (listener);
      btnWest.addActionListener (listener);
	}

    public void setNorthEnabled(boolean b)
    {
        btnNorth.setEnabled(b);
    }

    public void setEastEnabled(boolean b)
    {
        btnEast.setEnabled(b);
    }

    public void setSouthEnabled(boolean b)
    {
        btnSouth.setEnabled(b);
    }

    public void setWestEnabled(boolean b)
    {
        btnWest.setEnabled(b);
    }

    public void setPlayerTurninfo(String color)
    {
        turn.setText(color + "'s Turn");
    }
}
