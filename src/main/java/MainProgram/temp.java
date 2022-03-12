package MainProgram;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.*;

/**
 *
 * @author niebz
 */
public class temp extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public temp() {
        initComponents();


        Method.Escape( this );

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        user_name_show = new javax.swing.JLabel();
        dashboard_btn = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        account_btn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        banking_btn = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        aboutme_btn = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        close_btn = new javax.swing.JLabel();
        main_pane = new javax.swing.JTabbedPane();
        dashboard_panel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMenu1 = new swing.ListMenu<>();
        account_panel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        banking_panel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        aboutme_panel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar_panel.setBackground(new java.awt.Color(104, 103, 172));
        sidebar_panel.setMinimumSize(new java.awt.Dimension(200, 600));
        sidebar_panel.setPreferredSize(new java.awt.Dimension(200, 600));
        sidebar_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bank_logo_sidebar.png"))); // NOI18N
        sidebar_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 35, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User : ");
        sidebar_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 166, -1, -1));

        user_name_show.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        user_name_show.setForeground(new java.awt.Color(255, 255, 255));
        user_name_show.setText("#UserName#");
        sidebar_panel.add(user_name_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 166, -1, -1));

        dashboard_btn.setBackground(new java.awt.Color(174, 173, 235));
        dashboard_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard_btn.setPreferredSize(new java.awt.Dimension(200, 21));
        dashboard_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard_btnMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/dashboard.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dashboard");

        javax.swing.GroupLayout dashboard_btnLayout = new javax.swing.GroupLayout(dashboard_btn);
        dashboard_btn.setLayout(dashboard_btnLayout);
        dashboard_btnLayout.setHorizontalGroup(
            dashboard_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard_btnLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addComponent(jLabel4))
        );
        dashboard_btnLayout.setVerticalGroup(
            dashboard_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard_btnLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(dashboard_btnLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4))
        );

        sidebar_panel.add(dashboard_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 224, -1, 60));

        account_btn.setBackground(new java.awt.Color(104, 103, 172));
        account_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        account_btn.setPreferredSize(new java.awt.Dimension(200, 21));
        account_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                account_btnMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/account.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Account");

        javax.swing.GroupLayout account_btnLayout = new javax.swing.GroupLayout(account_btn);
        account_btn.setLayout(account_btnLayout);
        account_btnLayout.setHorizontalGroup(
            account_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(account_btnLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );
        account_btnLayout.setVerticalGroup(
            account_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(account_btnLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, account_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidebar_panel.add(account_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 200, 60));

        banking_btn.setBackground(new java.awt.Color(104, 103, 172));
        banking_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        banking_btn.setPreferredSize(new java.awt.Dimension(200, 21));
        banking_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                banking_btnMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/banking.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Banking");

        javax.swing.GroupLayout banking_btnLayout = new javax.swing.GroupLayout(banking_btn);
        banking_btn.setLayout(banking_btnLayout);
        banking_btnLayout.setHorizontalGroup(
            banking_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(banking_btnLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        banking_btnLayout.setVerticalGroup(
            banking_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(banking_btnLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, banking_btnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidebar_panel.add(banking_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, 60));

        aboutme_btn.setBackground(new java.awt.Color(104, 103, 172));
        aboutme_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aboutme_btn.setPreferredSize(new java.awt.Dimension(200, 21));
        aboutme_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutme_btnMouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/info.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("About Me");

        javax.swing.GroupLayout aboutme_btnLayout = new javax.swing.GroupLayout(aboutme_btn);
        aboutme_btn.setLayout(aboutme_btnLayout);
        aboutme_btnLayout.setHorizontalGroup(
            aboutme_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutme_btnLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        aboutme_btnLayout.setVerticalGroup(
            aboutme_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutme_btnLayout.createSequentialGroup()
                .addGroup(aboutme_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aboutme_btnLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10))
                    .addGroup(aboutme_btnLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        sidebar_panel.add(aboutme_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, -1, 60));

        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        close_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_btnMouseClicked(evt);
            }
        });
        sidebar_panel.add(close_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        getContentPane().add(sidebar_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        main_pane.setMaximumSize(new java.awt.Dimension(700, 600));
        main_pane.setMinimumSize(new java.awt.Dimension(700, 600));
        main_pane.setPreferredSize(new java.awt.Dimension(700, 600));

        dashboard_panel.setBackground(new java.awt.Color(232, 232, 255));
        dashboard_panel.setMaximumSize(new java.awt.Dimension(700, 600));
        dashboard_panel.setMinimumSize(new java.awt.Dimension(700, 600));
        dashboard_panel.setPreferredSize(new java.awt.Dimension(700, 600));

        jLabel11.setText("Dashboard");

        listMenu1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listMenu1);

        javax.swing.GroupLayout dashboard_panelLayout = new javax.swing.GroupLayout(dashboard_panel);
        dashboard_panel.setLayout(dashboard_panelLayout);
        dashboard_panelLayout.setHorizontalGroup(
            dashboard_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard_panelLayout.createSequentialGroup()
                .addGap(1053, 1053, 1053)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel11))
        );
        dashboard_panelLayout.setVerticalGroup(
            dashboard_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboard_panelLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        main_pane.addTab("tab1", dashboard_panel);

        account_panel.setBackground(new java.awt.Color(232, 232, 255));

        jLabel12.setText("Account");

        javax.swing.GroupLayout account_panelLayout = new javax.swing.GroupLayout(account_panel);
        account_panel.setLayout(account_panelLayout);
        account_panelLayout.setHorizontalGroup(
            account_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(account_panelLayout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel12)
                .addContainerGap(337, Short.MAX_VALUE))
        );
        account_panelLayout.setVerticalGroup(
            account_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(account_panelLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel12)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        main_pane.addTab("tab2", account_panel);

        banking_panel.setBackground(new java.awt.Color(232, 232, 255));

        jLabel14.setText("Banking");

        javax.swing.GroupLayout banking_panelLayout = new javax.swing.GroupLayout(banking_panel);
        banking_panel.setLayout(banking_panelLayout);
        banking_panelLayout.setHorizontalGroup(
            banking_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(banking_panelLayout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel14)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        banking_panelLayout.setVerticalGroup(
            banking_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(banking_panelLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel14)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        main_pane.addTab("tab2", banking_panel);

        aboutme_panel.setBackground(new java.awt.Color(232, 232, 255));

        jLabel13.setText("About Me");

        javax.swing.GroupLayout aboutme_panelLayout = new javax.swing.GroupLayout(aboutme_panel);
        aboutme_panel.setLayout(aboutme_panelLayout);
        aboutme_panelLayout.setHorizontalGroup(
            aboutme_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutme_panelLayout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel13)
                .addContainerGap(329, Short.MAX_VALUE))
        );
        aboutme_panelLayout.setVerticalGroup(
            aboutme_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutme_panelLayout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel13)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        main_pane.addTab("tab2", aboutme_panel);

        getContentPane().add(main_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, -40, 720, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_btnMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_close_btnMouseClicked

    private void dashboard_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboard_btnMouseClicked
        // TODO add your handling code here:
        dashboard_btn.setBackground( new Color(174, 173, 235) );
        account_btn.setBackground( new Color(104, 103, 172));
        banking_btn.setBackground( new Color(104, 103, 172) );
        aboutme_btn.setBackground( new Color(104, 103, 172) );
        main_pane.setSelectedIndex( 0 );
    }//GEN-LAST:event_dashboard_btnMouseClicked

    private void account_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_btnMouseClicked
        // TODO add your handling code here:
        account_btn.setBackground( new Color(174, 173, 235) );
        dashboard_btn.setBackground( new Color(104, 103, 172));
        banking_btn.setBackground( new Color(104, 103, 172) );
        aboutme_btn.setBackground( new Color(104, 103, 172) );
        main_pane.setSelectedIndex( 1 );
    }//GEN-LAST:event_account_btnMouseClicked

    private void banking_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_banking_btnMouseClicked
        // TODO add your handling code here:
        banking_btn.setBackground( new Color( 174, 173, 235 ));
        account_btn.setBackground( new Color(104, 103, 172));
        dashboard_btn.setBackground( new Color(104, 103, 172) );
        aboutme_btn.setBackground( new Color(104, 103, 172) );
        main_pane.setSelectedIndex( 2 );
    }//GEN-LAST:event_banking_btnMouseClicked

    private void aboutme_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutme_btnMouseClicked
        // TODO add your handling code here:
        aboutme_btn.setBackground( new Color( 174, 173, 235 ) );
        account_btn.setBackground( new Color(104, 103, 172));
        banking_btn.setBackground( new Color(104, 103, 172) );
        dashboard_btn.setBackground( new Color(104, 103, 172) );
        main_pane.setSelectedIndex( 3 );
    }//GEN-LAST:event_aboutme_btnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(temp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(temp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(temp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(temp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new temp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aboutme_btn;
    private javax.swing.JPanel aboutme_panel;
    private javax.swing.JPanel account_btn;
    private javax.swing.JPanel account_panel;
    private javax.swing.JPanel banking_btn;
    private javax.swing.JPanel banking_panel;
    private javax.swing.JLabel close_btn;
    private javax.swing.JPanel dashboard_btn;
    private javax.swing.JPanel dashboard_panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private swing.ListMenu<String> listMenu1;
    private javax.swing.JTabbedPane main_pane;
    private javax.swing.JPanel sidebar_panel;
    private javax.swing.JLabel user_name_show;
    // End of variables declaration//GEN-END:variables
}
