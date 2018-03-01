package mosquitokiller;

import java.awt.*;
import java.applet.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;


public class MosquitoKiller extends Applet implements Runnable, MouseListener {
    int hit=0, miss = 0;
    int xpos, ypos;
    Thread t;
    Image img;
    
   

    public void init() {
      
        img = getImage(getDocumentBase(), "mosquito.jpg");
        xpos = 10;
        ypos = 10;
        addMouseListener(this);
        t = new Thread(this);
        t.start();
    }

    public void run() {
        Random r = new Random();
        while (true) {
            xpos = r.nextInt((Integer) getSize().width);
            ypos = r.nextInt((Integer) getSize().height);
             img = getImage(getDocumentBase(), "mosquito.jpg");
            //repaint();
       
            repaint();
            try {
                t.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public void paint(Graphics g) {

        g.drawImage(img, xpos, ypos,200,200, this);
        g.drawString("Number of hits:   " + hit, 15, 22);
        g.drawString("Number of misses: " + miss, 15, 40);
       
     }
      
           
          

    @Override
    public void mouseClicked(MouseEvent e) {
       

    }

    @Override
    public void mousePressed(MouseEvent e) {
        hitMosquito(e.getX(), e.getY());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void hitMosquito(int x,int y){
        
        if (x-200<=xpos && x+200 >= xpos && y-200<=ypos && y+200>=ypos) {
          showStatus("Hit"+"xpos:"+xpos+" ypos:"+ypos+ "X:"+x+" Y:"+y);
            hit++;
            img = getImage(getDocumentBase(), "kill.jpg");
            repaint();
            
        } else {
          showStatus("Missed"+"xpos:"+xpos+" ypos:"+ypos+ "X:"+x+" Y:"+y);
            miss++;
            
        }
      
        }
    }


