package component;

import MainProgram.main;
import MainProgram.loginPage;
import event.EventMenuSelected;
import model.Model_Menu;
import swing.ListMenu;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Menu extends javax.swing.JPanel {

    private EventMenuSelected event;

    public void addEventMenuSelected (EventMenuSelected event) {
        this.event = event;
        listMenu1.addEventMenuSelected( event );
    }


    public Menu () {
        initComponents();
        setOpaque( false );
        listMenu1.setOpaque( false );
        init();


    }





    private void init () {
        listMenu1.addItem( new Model_Menu( "1.png", "Dashboard", Model_Menu.MenuType.MENU ) );
        listMenu1.addItem( new Model_Menu( "8.png", "Account", Model_Menu.MenuType.MENU ) );
        listMenu1.addItem( new Model_Menu( "5.png", "Banking", Model_Menu.MenuType.MENU ) );
        listMenu1.addItem( new Model_Menu( "10.png", "About Me", Model_Menu.MenuType.MENU ) );
        listMenu1.addItem( new Model_Menu( "4.png", "Logout", Model_Menu.MenuType.MENU ) );
        listMenu1.addItem( new Model_Menu( "", "", Model_Menu.MenuType.EMPTY ) );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents () {

        panelMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new swing.ListMenu();

        panelMoving.setOpaque( false );

        jLabel1.setFont( new java.awt.Font( "sansserif", 1, 18 ) ); // NOI18N
        jLabel1.setForeground( new java.awt.Color( 255, 255, 255 ) );
        jLabel1.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/resources/bank_logo_60.png" ) ) ); // NOI18N
        jLabel1.setText( "Banking System" );

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout( panelMoving );
        panelMoving.setLayout( panelMovingLayout );
        panelMovingLayout.setHorizontalGroup(
                panelMovingLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( panelMovingLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent( jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE )
                                .addContainerGap() )
        );
        panelMovingLayout.setVerticalGroup(
                panelMovingLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                                .addGap( 15, 15, 15 )
                                .addComponent( jLabel1 )
                                .addContainerGap() )
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout( this );
        this.setLayout( layout );
        layout.setHorizontalGroup(
                layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addComponent( panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
                        .addComponent( listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
                        .addGroup( layout.createSequentialGroup()
                                .addComponent( panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE )
                                .addGap( 15, 15, 15 )
                                .addComponent( listMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE ) )
        );


    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren (Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        GradientPaint g = new GradientPaint( 0, 0, Color.decode( "#E8CBC0" ), 0, getHeight(), Color.decode( "#636FA4" ) );
        g2.setPaint( g );
        g2.fillRoundRect( 0, 0, getWidth(), getHeight(), 15, 15 );
        g2.fillRect( getWidth() - 20, 0, getWidth(), getHeight() );
        super.paintChildren( grphcs );
    }

    private int x;
    private int y;

    public void initMoving (JFrame fram) {
        panelMoving.addMouseListener( new MouseAdapter() {
            @Override
            public void mousePressed (MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }

        } );
        panelMoving.addMouseMotionListener( new MouseMotionAdapter() {
            @Override
            public void mouseDragged (MouseEvent me) {
                fram.setLocation( me.getXOnScreen() - x, me.getYOnScreen() - y );
            }
        } );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public static ListMenu listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
