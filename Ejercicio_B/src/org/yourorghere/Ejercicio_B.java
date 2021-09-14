package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;


public class Ejercicio_B implements GLEventListener {
static GLU glu;
static GL gl;
static JFrame frame;

    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Ejercicio_B());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }
    
    public void init(GLAutoDrawable drawable) {
    glu = new GLU ();
    gl = drawable.getGL();
    gl.glClearColor(0, 0, 0, 1);
    gl.glMatrixMode(GL.GL_PROJECTION);
    glu.gluOrtho2D(-350,350,-300,300);
    
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
  
    }

    public void display(GLAutoDrawable drawable) {
       gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        int tam=20;
        gl.glLineWidth(1);
        gl.glColor3d(0, 255, 0);
       for (int i=0;i<20;i++){
         gl.glBegin(GL.GL_LINE_LOOP);
            gl.glVertex2d(tam*i, tam*i);
            gl.glVertex2d(tam*i, -tam*i);
            gl.glVertex2d(-tam*i, -tam*i);
            gl.glVertex2d(-tam*i, tam*i);
        gl.glEnd();  
       }
        
        gl.glFlush();  
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

