import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Maze extends JFrame implements KeyListener{
    private int playerX = 0, playerY = 0;


    /**
     * maze is a 2D array
     * maze [row][column]
     * values: 0 = not visted node, 1 = wall, 2 = visited node, 5 = target/finish line
     */
//basically the 0's are like the "path" and the 1's are the walls like once i fill in the rest of the array you'll see what i mean
    private int [][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1,1,0,0,1,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,0,0,0,1,1,0,1},
        {1,0,0,0,1,1,1,0,0,1,0,0,1,1,0,1,1,0,1},
        {1,0,1,0,0,0,0,0,1,1,1,0,1,1,0,0,0,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,0,1,1,1,1,1,1},
        {1,0,1,0,1,0,0,0,1,1,1,1,0,1,0,0,0,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,0,1,1,1,0,1,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,0,1}, 
        {1,0,1,0,1,1,0,1,1,0,1,0,0,0,0,1,1,1,1},
        {1,0,1,0,1,0,0,1,1,0,1,0,1,1,0,1,0,5,1}, //5 is the target 
        {1,0,0,0,1,1,0,0,1,0,1,0,0,0,0,0,0,1,1},
        {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1},
        {1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    
    };

    //frame of the maze
    //plus graphics
    public Maze(){
        setTitle("MAZE GAME");
        setSize(840, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        requestFocus();

    }

        @Override
        public void paint(Graphics g){
            super.paint(g);
            g.translate(50, 50); //keeps the grid in the center

            for (int row = 0; row < maze.length; row++)
            {
                for (int column = 0; column < maze[0].length; column++)
                {
                    Color color;
                    switch (maze[row][column])
                    {
                        case 1: color = Color.black; break;
                        case 5: color = Color.green; break;
                        default: color = Color.white;
                    }

                    g.setColor(color);
                    g.fillRect(40*column, 40* row, 40, 40);
                    g.setColor(Color.black);
                    g.drawRect(40*column, 40*row, 40, 40);
                    g.setColor(Color.blue);
                    g.fillOval(playerX, playerY, 30, 30);
                }
            }

        }

        
        public static void main(String [] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run (){
                    Maze maze1 = new Maze();
                    maze1.setVisible(true);
                }
                
            });
            
        }

        //keys: WASD

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_W){
                playerY-=10;
            }
            else if(key == KeyEvent.VK_S){
                playerY+=10;
            }
            else if(key == KeyEvent.VK_A){
                playerX-=10;
            }
            else if(key == KeyEvent.VK_D){
                playerX+=10;
            }

            repaint();
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            
        }

}