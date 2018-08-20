    
package chapter6ex;
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    import java.util.*;

    public class PaintFrame extends JFrame {

       public static void main(String[] args) {
              
          new PaintFrame();
       }

       JRadioButtonMenuItem black, red, green, blue, cyan, magenta, 
                               yellow, white, custom;
            
       JRadioButtonMenuItem curve, straightLine, rectangle, oval,
                            roundRect, filledRectangle, filledOval, filledRoundRect;
           
       JRadioButtonMenuItem noSymmetry, twoWay, fourWay, eightWay;
           
       public boolean standAlone = true;
           
       public PaintFrame() {  
            

          super("PaintHomework");  .

          Display canvas = new Display(); 
          setContentPane(canvas);

          // main menu

          JMenuBar menubar = new JMenuBar();
          JMenu controlMenu = new JMenu("Control",true);
          menubar.add(controlMenu);
          JMenu colorMenu = new JMenu("Color",true);
          menubar.add(colorMenu);
          JMenu shapeMenu = new JMenu("Shape",true);
          menubar.add(shapeMenu);
          JMenu symmetryMenu = new JMenu("Symmetry",true);
          menubar.add(symmetryMenu);
          setJMenuBar(menubar);

          // control menu

          controlMenu.add("Fill with Black").addActionListener(canvas);
          controlMenu.add("Fill with Red").addActionListener(canvas);
          controlMenu.add("Fill with Green").addActionListener(canvas);
          controlMenu.add("Fill with Blue").addActionListener(canvas);
          controlMenu.add("Fill with Cyan").addActionListener(canvas);
          controlMenu.add("Fill with Magenta").addActionListener(canvas);
          controlMenu.add("Fill with Yellow").addActionListener(canvas);
          controlMenu.add("Fill with White").addActionListener(canvas);
          controlMenu.add("Fill with Custom").addActionListener(canvas);
          controlMenu.addSeparator();
          JMenuItem customItem = new JMenuItem("Set Custom Color...");
          customItem.addActionListener(canvas);
          customItem.setAccelerator( KeyStroke.getKeyStroke("ctrl T") );
          controlMenu.add(customItem);
          JMenuItem clearItem = new JMenuItem("Clear");
          clearItem.addActionListener(canvas);
          clearItem.setAccelerator( KeyStroke.getKeyStroke("ctrl K") );
          controlMenu.add(clearItem);
          JMenuItem undoItem = new JMenuItem("Undo");
          undoItem.addActionListener(canvas);
          undoItem.setAccelerator( KeyStroke.getKeyStroke("ctrl Z") );
          controlMenu.add(undoItem);
          JMenuItem quitItem = new JMenuItem("Quit");
          quitItem.setAccelerator( KeyStroke.getKeyStroke("ctrl Q") );
          quitItem.addActionListener(canvas);
          controlMenu.add(quitItem);

        	//color menu

          ButtonGroup colorGroup = new ButtonGroup();
          black = new JRadioButtonMenuItem("Black");
          colorGroup.add(black);
          colorMenu.add(black);
          red = new JRadioButtonMenuItem("Red");
          colorGroup.add(red);
          colorMenu.add(red);
          green = new JRadioButtonMenuItem("Green");
          colorGroup.add(green);
          colorMenu.add(green);
          blue = new JRadioButtonMenuItem("Blue");
          colorGroup.add(blue);
          colorMenu.add(blue);
          cyan = new JRadioButtonMenuItem("Cyan");
          colorGroup.add(cyan);
          colorMenu.add(cyan);
          magenta = new JRadioButtonMenuItem("Magenta");
          colorGroup.add(magenta);
          colorMenu.add(magenta);
          yellow = new JRadioButtonMenuItem("Yellow");
          colorGroup.add(yellow);
          colorMenu.add(yellow);
          white = new JRadioButtonMenuItem("White");
          colorGroup.add(white);
          colorMenu.add(white);
          custom = new JRadioButtonMenuItem("Custom Color");
          colorGroup.add(custom);
          colorMenu.add(custom);
          black.setSelected(true);

    		//shape menu

          ButtonGroup shapeGroup = new ButtonGroup();
          curve = new JRadioButtonMenuItem("Curve");
          shapeGroup.add(curve);
          shapeMenu.add(curve);
          straightLine = new JRadioButtonMenuItem("Straight Line");
          shapeGroup.add(straightLine);
          shapeMenu.add(straightLine);
          rectangle = new JRadioButtonMenuItem("Rectangle");
          shapeGroup.add(rectangle);
          shapeMenu.add(rectangle);
          oval = new JRadioButtonMenuItem("Oval");
          shapeGroup.add(oval);
          shapeMenu.add(oval);
          roundRect = new JRadioButtonMenuItem("RoundRect");
          shapeGroup.add(roundRect);
          shapeMenu.add(roundRect);
          filledRectangle = new JRadioButtonMenuItem("Filled Rectangle");
          shapeGroup.add(filledRectangle);
          shapeMenu.add(filledRectangle);
          filledOval = new JRadioButtonMenuItem("Filled Oval");
          shapeGroup.add(filledOval);
          shapeMenu.add(filledOval);
          filledRoundRect = new JRadioButtonMenuItem("Filled RoundRect");
          shapeGroup.add(filledRoundRect);
          shapeMenu.add(filledRoundRect);
          curve.setSelected(true);
		
		//symetry menu

          ButtonGroup symmetryGroup = new ButtonGroup();
          noSymmetry = new JRadioButtonMenuItem("None");
          noSymmetry.setAccelerator( KeyStroke.getKeyStroke("ctrl 0") );
          symmetryGroup.add(noSymmetry);
          symmetryMenu.add(noSymmetry);
          twoWay = new JRadioButtonMenuItem("Two-way");
          twoWay.setAccelerator( KeyStroke.getKeyStroke("ctrl 2") );
          symmetryGroup.add(twoWay);
          symmetryMenu.add(twoWay);
          fourWay = new JRadioButtonMenuItem("Four-way");
          fourWay.setAccelerator( KeyStroke.getKeyStroke("ctrl 4") );
          symmetryGroup.add(fourWay);
          symmetryMenu.add(fourWay);
          eightWay = new JRadioButtonMenuItem("Eight-way");
          eightWay.setAccelerator( KeyStroke.getKeyStroke("ctrl 8") );
          symmetryGroup.add(eightWay);
          symmetryMenu.add(eightWay);
          noSymmetry.setSelected(true);

          pack();
          setLocation(75,50);
          setResizable(false);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          show();

       }  
       private class Display extends JPanel 
                  implements MouseListener, MouseMotionListener, ActionListener {
          private final static int
                     CURVE = 0,
                     LINE = 1,
                     RECT = 2,               
                     OVAL = 3,               
                     ROUNDRECT = 4,          
                     FILLED_RECT = 5,
                     FILLED_OVAL = 6,
                     FILLED_ROUNDRECT = 7;

          private final static int
                      NO_SYMMETRY = 0,       
                      SYMMETRY_2 = 1,        
                      SYMMETRY_4 = 2,        
                      SYMMETRY_8 = 3;


          Color customColor = Color.gray;  

          Image OSI;  

          int widthOfOSI, heightOfOSI; 

          Image undoBuffer;  

          private int mouseX, mouseY;   
          private int prevX, prevY;     
          private int startX, startY;   
          private boolean dragging;     
          private int figure;    

          private int symmetry;  
          private Graphics dragGraphics;  
          private Color dragColor; 

          Display() {
             addMouseListener(this);
             addMouseMotionListener(this);
             setBackground(Color.white);
             setPreferredSize( new Dimension(450,450) );
          }


          private Color getSelectedColor() {
             if (black.isSelected())
                return Color.black;
             else if (red.isSelected())
                return Color.red;
             else if (green.isSelected())
                return Color.green;
             else if (blue.isSelected())
                return Color.blue;
             else if (cyan.isSelected())
                return Color.cyan;
             else if (magenta.isSelected())
                return Color.magenta;
             else if (yellow.isSelected())
                return Color.yellow;
             else if (white.isSelected())
                return Color.white;
             else
                return customColor;
          }


          private int getSelectedShape() {
             if (curve.isSelected())
                return CURVE;
             else if (straightLine.isSelected())
                return LINE;
             else if (rectangle.isSelected())
                return RECT;
             else if (oval.isSelected())
                return OVAL;
             else if (roundRect.isSelected())
                return ROUNDRECT;
             else if (filledRectangle.isSelected())
                return FILLED_RECT;
             else if (filledOval.isSelected())
                return FILLED_OVAL;
             else
                return FILLED_ROUNDRECT;
          }


          private int getSelectedSymmetry() {
             if (noSymmetry.isSelected())
                return NO_SYMMETRY;
             else if (twoWay.isSelected())
                return SYMMETRY_2;
             else if (fourWay.isSelected())
                return SYMMETRY_4;
             else 
                return SYMMETRY_8;
          }


          private void drawFigure(Graphics g, int shape, int x1, int y1, int x2, int y2){
             if (shape == LINE) {
                g.drawLine(x1,y1,x2,y2);
                return;
             }
             int x, y;  
             int w, h; 
             if (x1 >= x2) {  
                x = x2;
                w = x1 - x2;
             }
             else {         
                x = x1;
                w = x2 - x1;
             }
             if (y1 >= y2) {  
                y = y2;
                h = y1 - y2;
             }
             else {         
                y = y1;
                h = y2 - y1;
             }
             switch (shape) {   
                case RECT:
                   g.drawRect(x, y, w, h);
                   break;
                case OVAL:
                   g.drawOval(x, y, w, h);
                   break;
                case ROUNDRECT:
                   g.drawRoundRect(x, y, w, h, 20, 20);
                   break;
                case FILLED_RECT:
                   g.fillRect(x, y, w, h);
                   break;
                case FILLED_OVAL:
                   g.fillOval(x, y, w, h);
                   break;
                case FILLED_ROUNDRECT:
                   g.fillRoundRect(x, y, w, h, 20, 20);
                   break;
             }
          }


          private void putMultiFigure(Graphics g, int shape, int x1, int y1, int x2, int y2) {
	     int width = getWidth();
             int height = getHeight();

             drawFigure(g,shape,x1,y1,x2,y2);  // Draw the basic frame

             if (symmetry >= SYMMETRY_2) {  
                drawFigure(g, shape, width - x1, y1, width - x2, y2);
             }

             if (symmetry >= SYMMETRY_4) {  
                drawFigure(g, shape, x1, height - y1, x2, height - y2);
                drawFigure(g, shape, width - x1, height - y1, width - x2, height - y2);
             }

             if (symmetry == SYMMETRY_8) {  
                int a1 = (int)( ((double)y1 / height) * width );
                int b1 = (int)( ((double)x1 / width) * height );
                int a2 = (int)( ((double)y2 / height) * width );
                int b2 = (int)( ((double)x2 / width) * height );
                drawFigure(g, shape, a1, b1, a2, b2);
                drawFigure(g, shape, width - a1, b1, width - a2, b2);
                drawFigure(g, shape, a1, height - b1, a2, height - b2);
                drawFigure(g, shape, width - a1, height - b1, width - a2, height - b2);
             }

          }


          private void repaintRect(int x1, int y1, int x2, int y2) {
             int x, y;  
             int w, h;  
             if (x2 >= x1) {  
                x = x1;
                w = x2 - x1;
             }
             else {          
                x = x2;
                w = x1 - x2;
             }
             if (y2 >= y1) {  
                y = y1;
                h = y2 - y1;
             }
             else {          
                y = y2;
                h = y1 - y2;
             }
             repaint(x,y,w+1,h+1);
          }


          private void repaintMultiRect(int x1, int y1, int x2, int y2) {
             int width = getWidth();
             int height = getHeight();
             repaintRect(x1,y1,x2,y2); // repaint the original rect
             if (symmetry >= SYMMETRY_2) {  // repaint the horizontal reflection.
                repaintRect(width - x1, y1, width - x2, y2);
             }
             if (symmetry >= SYMMETRY_4) {  // repaint the two vertical reflections.
                repaintRect(x1, height - y1, x2, height - y2);
                repaintRect(width - x1, height - y1, width - x2, height - y2);
             }
             if (symmetry == SYMMETRY_8) {  // repaint the four diagonal reflections.
                int a1 = (int)( ((double)y1 / height) * width );
                int b1 = (int)( ((double)x1 / width) * height );
                int a2 = (int)( ((double)y2 / height) * width );
                int b2 = (int)( ((double)x2 / width) * height );
                repaintRect(a1, b1, a2, b2);
                repaintRect(width - a1, b1, width - a2, b2);
                repaintRect(a1, height - b1, a2, height - b2);
                repaintRect(width - a1, height - b1, width - a2, height - b2);
             }
          }


          private void checkOSI() {
             if (OSI == null || widthOfOSI != getSize().width || heightOfOSI != getSize().height) {
                    // Create the OSI, or make a new one if panel size has changed.
                OSI = null;  // (If OSI already exists, this frees up the memory.)
                undoBuffer = null;  // (Free memory.)
                widthOfOSI = getWidth();
                heightOfOSI = getHeight();
                OSI = createImage(widthOfOSI,heightOfOSI);
                Graphics OSG = OSI.getGraphics();  // Graphics context for drawing to OSI.
                OSG.setColor(getBackground());
                OSG.fillRect(0, 0, widthOfOSI, heightOfOSI);
                OSG.dispose();
                undoBuffer = createImage(widthOfOSI,heightOfOSI);
                OSG = undoBuffer.getGraphics();  // Graphics context for drawing to undoBuffer
                OSG.setColor(getBackground());
                OSG.fillRect(0, 0, widthOfOSI, heightOfOSI);
                OSG.dispose();
             }
          }


          public void paintComponent(Graphics g) {
             checkOSI();
             g.drawImage(OSI, 0, 0, this);
             if (dragging && figure != CURVE) {
                g.setColor(dragColor);
                putMultiFigure(g,figure,startX,startY,mouseX,mouseY);
             }
          }


          public void actionPerformed(ActionEvent evt) {
             String command = evt.getActionCommand();
             checkOSI();
             if (command.equals("Fill with Black"))
                clear(Color.black);
             else if (command.equals("Fill with Red"))
                clear(Color.red);
             else if (command.equals("Fill with Green"))
                clear(Color.green);
             else if (command.equals("Fill with Blue"))
                clear(Color.blue);
             else if (command.equals("Fill with Cyan"))
                clear(Color.cyan);
             else if (command.equals("Fill with Magenta"))
                clear(Color.magenta);
             else if (command.equals("Fill with Yellow"))
                clear(Color.yellow);
             else if (command.equals("Fill with White"))
                clear(Color.white);
             else if (command.equals("Fill with Custom"))
                clear(customColor);
             else if (command.equals("Set Custom Color...")) {
                Color c = JColorChooser.showDialog(this,"Select Custom Color",customColor);
                if (c != null) {
                   customColor = c;
                   custom.setSelected(true);
                }
             }
             else if (command.equals("Clear")) {
                Graphics g = OSI.getGraphics();
                g.setColor(getBackground());
                g.fillRect(0,0,getSize().width,getSize().height);
                g.dispose();
                repaint();
             }
             else if (command.equals("Undo")) {
                Image temp = OSI;
                OSI = undoBuffer;
                undoBuffer = temp;
                repaint();
             }
             else if (command.equals("Quit")) 
                dispose();
                if (standAlone)
                   System.exit(0);
             }
          }

          private void clear(Color background) {
             setBackground(background);
             if (background.equals(getSelectedColor())) {
                if (background.equals(Color.black))
                   white.setSelected(true);  // On a black background, draw in white.
                else
                   black.setSelected(true);  // On other backgrounds, use black.
             }
             Graphics g = OSI.getGraphics();
             g.setColor(getBackground());
             g.fillRect(0,0,getSize().width,getSize().height);
             g.dispose();
             repaint();
          }


          public void mousePressed(MouseEvent evt) {
             if (dragging == true)  
                 return;                                    
             prevX = startX = evt.getX();  
             prevY = startY = evt.getY();

             figure = getSelectedShape();     
             symmetry = getSelectedSymmetry();
             dragColor = getSelectedColor();  

             checkOSI();

             Graphics undoGraphics = undoBuffer.getGraphics();
             undoGraphics.drawImage(OSI,0,0,null);  
             undoGraphics.dispose();   
             dragGraphics = OSI.getGraphics();
             dragGraphics.setColor(dragColor);

             dragging = true;  // Start drawing.

          } 


          public void mouseReleased(MouseEvent evt) {
                  // Called whenever the user releases the mouse button.
              if (dragging == false)
                 return;  
              dragging = false;
              mouseX = evt.getX();
              mouseY = evt.getY();
              if (figure == CURVE) {
                  putMultiFigure(dragGraphics,LINE,prevX,prevY,mouseX,mouseY);
                  repaintMultiRect(prevX,prevY,mouseX,mouseY);
              }
              else if (figure == LINE) {
                 repaintMultiRect(startX,startY,prevX,prevY);
                 if (mouseX != startX || mouseY != startY) {
                    putMultiFigure(dragGraphics,figure,startX,startY,mouseX,mouseY);
                    repaintMultiRect(startX,startY,mouseX,mouseY);
                 }
              }
              else {
                 repaintMultiRect(startX,startY,prevX,prevY);
                 if (mouseX != startX && mouseY != startY) {
                    putMultiFigure(dragGraphics,figure,startX,startY,mouseX,mouseY);
                    repaintMultiRect(startX,startY,mouseX,mouseY);
                 }
              }
              dragGraphics.dispose();
              dragGraphics = null;
          }


          public void mouseDragged(MouseEvent evt) {
              if (dragging == false)
                 return;  
              mouseX = evt.getX();   // xcoordinate of mouse.
              mouseY = evt.getY();   // ycoordinate of mouse.

              if (figure == CURVE) { 
                 putMultiFigure(dragGraphics,LINE,prevX,prevY,mouseX,mouseY);
                 repaintMultiRect(prevX,prevY,mouseX,mouseY);
              }
              else {
                    
                 repaintMultiRect(startX,startY,prevX,prevY);
                 repaintMultiRect(startX,startY,mouseX,mouseY);
              }

              prevX = mouseX;  // Save coords for the next call to mouseDragged or mouseReleased.
              prevY = mouseY;

          } 


          public void mouseEntered(MouseEvent evt) { }   
          public void mouseExited(MouseEvent evt) { }    
          public void mouseClicked(MouseEvent evt) { }   
          public void mouseMoved(MouseEvent evt) { }     

       } 
