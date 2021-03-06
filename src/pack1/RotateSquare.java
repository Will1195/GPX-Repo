package pack1;

import javax.swing.*;
import java.awt.Graphics;

public class RotateSquare  extends JFrame {
// Liang listing 14.3



  public RotateSquare() {
    add(new DrawPanel());
  }

  public static void main(String[] args) {
    RotateSquare frame = new RotateSquare();
    frame.setTitle("RotateSquare");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 700);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setVisible(true);
  }

  class DrawPanel extends JPanel {
    S2 S = new S2(50,50,200,400);
    V2 A=new V2(2,2);
    V2 B=new V2(4,2);
    V2 C=new V2(4,4);
    V2 D=new V2(2,4);
    V2 R=A.add(B).add(C).add(D).div(4);
    double phi=Math.PI/3;
    M2 M=new M2(Math.cos(phi), -Math.sin(phi),
    		        Math.sin(phi),  Math.cos(phi));

    V2 Am=M.mul(A.sub(R)).add(R);
    V2 Bm=M.mul(B.sub(R)).add(R);
    V2 Cm=M.mul(C.sub(R)).add(R);
    V2 Dm=M.mul(D.sub(R)).add(R);
    
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      S.drawaxis(g);
      S.drawline(g, A, B);
      S.drawline(g, B, C);
      S.drawline(g, C, D);
      S.drawline(g, D, A);
      S.drawpoint(g, R);

      S.drawline(g, Am, Bm);
      S.drawline(g, Bm, Cm);
      S.drawline(g, Cm, Dm);
      S.drawline(g, Dm, Am);
          

    }
  }

}
