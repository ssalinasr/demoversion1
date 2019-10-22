/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import builder.BuilderPersonaje;
import builder.ConstructorPersonajeElfo;
import builder.ConstructorPersonajeEnano;
import builder.ConstructorPersonajeHumano;
import builder.Director;
import builder.Personaje;
import builder.PrototypePersonaje;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.PrototypeObject;

/**
 *
 * @author estudiantes
 */
public class Frame extends javax.swing.JFrame {

    private Personaje personaje;
    private PrototypePersonaje pp;
    private Personaje pp1;
    private Personaje pp2;
    private Personaje pp3;
    private Thread h1;
    private Thread h2;
    private Thread h3;
    private Thread h4;
    private boolean est1;
    private boolean est2;
    private boolean est3;
    private boolean est4;

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.est1 = false;
        this.est2 = false;
        this.est3 = false;
        this.est4 = false;
    }

    public void instanciaPersonaje(String p) throws CloneNotSupportedException {
        Director director = new Director();
        BuilderPersonaje humano = new ConstructorPersonajeHumano();
        BuilderPersonaje enano = new ConstructorPersonajeEnano();
        BuilderPersonaje elfo = new ConstructorPersonajeElfo();

        if (p.equals("Humano")) {
            director.setBuilderPersonaje(humano);
            director.construirPersonaje();
            personaje = director.getPersonaje();
            pp = new PrototypePersonaje();
            pp1 = (Personaje) pp.prototipo("humano");
            pp2 = (Personaje) pp.prototipo("humano");
            pp3 = (Personaje) pp.prototipo("humano");

        } else {
            if (p.equals("Enano")) {
                director.setBuilderPersonaje(enano);
                director.construirPersonaje();
                personaje = director.getPersonaje();
                pp = new PrototypePersonaje();
                pp1 = (Personaje) pp.prototipo("enano");
                pp2 = (Personaje) pp.prototipo("enano");
                pp3 = (Personaje) pp.prototipo("enano");
            } else {
                if (p.equals("Elfo")) {
                    director.setBuilderPersonaje(elfo);
                    director.construirPersonaje();
                    personaje = director.getPersonaje();
                    pp = new PrototypePersonaje();
                    pp1 = (Personaje) pp.prototipo("elfo");
                    pp2 = (Personaje) pp.prototipo("elfo");
                    pp3 = (Personaje) pp.prototipo("elfo");
                }
            }
        }
    }

    public boolean isEst1() {
        return est1;
    }

    public void setEst1(boolean est1) {
        this.est1 = est1;
    }

    public boolean isEst2() {
        return est2;
    }

    public void setEst2(boolean est2) {
        this.est2 = est2;
    }

    public boolean isEst3() {
        return est3;
    }

    public void setEst3(boolean est3) {
        this.est3 = est3;
    }

    public boolean isEst4() {
        return est4;
    }

    public void setEst4(boolean est4) {
        this.est4 = est4;
    }

    /**
     * .start de los hilos
     */
    public void hilos() {
        this.h1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isEst1()) {
                    try {
                        Anima1();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Hilo Interrumpido", "Error", 0);
                    }
                }
            }
        });

        this.h2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isEst2()) {
                    try {
                        Anima2();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Hilo Interrumpido", "Error", 0);

                    }
                }
            }
        });

        this.h3 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isEst3()) {
                    try {
                        Anima3();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Hilo Interrumpido", "Error", 0);

                    }
                }
            }
        });

        this.h4 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (isEst4()) {
                    try {
                        Anima4();
                    } catch (InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "Hilo Interrumpido", "Error", 0);

                    }
                }
            }
        });

        this.h1.start();
        this.h2.start();
        this.h3.start();
        this.h4.start();
    }

    /**
     * Ciclo Animación 1 Animación Caminar
     *
     * @throws InterruptedException
     */
    public void Anima1() throws InterruptedException {

        if (isEst1()) {
            this.LblAnima1.setEnabled(true);
            int cont = 0;
            while (cont < 9 && isEst1()) {
                cont = (cont + 1) % 8;
                this.LblAnima1.setIcon(personaje.getWalk()[cont]);
                this.LblAnima5.setIcon(pp1.getWalk()[cont]);
                this.LblAnima6.setIcon(pp2.getWalk()[cont]);
                this.LblAnima7.setIcon(pp3.getWalk()[cont]);
                Thread.sleep(125);
            }
            this.LblAnima1.setEnabled(false);
        }
    }

    /**
     * Ciclo Animación 2 Animación Morir
     *
     * @throws InterruptedException
     */
    public void Anima2() throws InterruptedException {
        if (isEst2()) {
            this.LblAnima2.setEnabled(true);
            int cont = 0;
            while (cont < 7 && isEst2()) {
                cont = (cont + 1) % 6;
                this.LblAnima2.setIcon(personaje.getDead()[cont]);
                this.LblAnima5.setIcon(pp1.getDead()[cont]);
                this.LblAnima6.setIcon(pp2.getDead()[cont]);
                this.LblAnima7.setIcon(pp3.getDead()[cont]);
                Thread.sleep(125);
            }
            this.LblAnima2.setEnabled(false);
        }

    }

    /**
     * Ciclo Animación 3 Animación Ataque
     *
     * @throws InterruptedException
     */
    public void Anima3() throws InterruptedException {
        if (isEst3()) {
            this.LblAnima3.setEnabled(true);
            int cont = 0;
            while (cont < 14 && isEst3()) {
                cont = (cont + 1) % 13;
                this.LblAnima3.setIcon(personaje.getAttack()[cont]);
                this.LblAnima5.setIcon(pp1.getAttack()[cont]);
                this.LblAnima6.setIcon(pp2.getAttack()[cont]);
                this.LblAnima7.setIcon(pp3.getAttack()[cont]);
                Thread.sleep(125);
            }
            this.LblAnima3.setEnabled(false);
        }
    }

    /**
     * Ciclo Animación 4 Animación Movimiento
     *
     * @throws InterruptedException
     */
    public void Anima4() throws InterruptedException {
        if (isEst4()) {
            this.LblAnima4.setEnabled(true);
            int cont = 0;
            while (cont < 7 && isEst4()) {
                cont = (cont + 1) % 6;
                this.LblAnima4.setIcon(personaje.getMove()[cont]);
                this.LblAnima5.setIcon(pp1.getMove()[cont]);
                this.LblAnima6.setIcon(pp2.getMove()[cont]);
                this.LblAnima7.setIcon(pp3.getMove()[cont]);
                Thread.sleep(125);
            }
            this.LblAnima4.setEnabled(false);
        }
    }

    /**
     * Función cambio de estados
     */
    public void validarAccion() throws CloneNotSupportedException {
        String valuePer = this.cbbPers.getSelectedItem().toString();
        String valueBox = this.BoxSelection.getSelectedItem().toString();
        switch (valuePer) {
            case "Humano":
                instanciaPersonaje("Humano");
                switch (valueBox) {
                    case "A1":
                        setEst1(true);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        break;
                    case "A2":
                        setEst1(false);
                        setEst2(true);
                        setEst3(false);
                        setEst4(false);
                        break;
                    case "A3":
                        setEst1(false);
                        setEst2(false);
                        setEst3(true);
                        setEst4(false);
                        break;
                    case "A4":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(true);
                        break;
                    case "A5":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        break;
                }
                break;
            case "Enano":
                instanciaPersonaje("Enano");
                switch (valueBox) {
                    case "A1":
                        setEst1(true);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        break;
                    case "A2":
                        setEst1(false);
                        setEst2(true);
                        setEst3(false);
                        setEst4(false);
                        break;
                    case "A3":
                        setEst1(false);
                        setEst2(false);
                        setEst3(true);
                        setEst4(false);
                        break;
                    case "A4":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(true);
                        break;
                    case "A5":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        break;
                }
                break;
            case "Elfo":
                instanciaPersonaje("Elfo");
                switch (valueBox) {
                    case "A1":
                        setEst1(true);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        break;
                    case "A2":
                        setEst1(false);
                        setEst2(true);
                        setEst3(false);
                        setEst4(false);
                        break;
                    case "A3":
                        setEst1(false);
                        setEst2(false);
                        setEst3(true);
                        setEst4(false);
                        break;
                    case "A4":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(true);
                        break;
                    case "A5":
                        setEst1(false);
                        setEst2(false);
                        setEst3(false);
                        setEst4(false);
                        break;
                }
                break;

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LblAnima1 = new javax.swing.JLabel();
        BtnRun = new javax.swing.JButton();
        LblAnima2 = new javax.swing.JLabel();
        LblAnima3 = new javax.swing.JLabel();
        LblAnima4 = new javax.swing.JLabel();
        BoxSelection = new javax.swing.JComboBox<>();
        cbbPers = new javax.swing.JComboBox<>();
        LblAnima5 = new javax.swing.JLabel();
        LblAnima6 = new javax.swing.JLabel();
        LblAnima7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LblAnima1.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        BtnRun.setText("Run");
        BtnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRunActionPerformed(evt);
            }
        });

        LblAnima2.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        LblAnima3.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        LblAnima4.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        BoxSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2", "A3", "A4" }));
        BoxSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoxSelectionActionPerformed(evt);
            }
        });

        cbbPers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Humano", "Elfo", "Enano" }));

        LblAnima5.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        LblAnima6.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        LblAnima7.setFont(new java.awt.Font("Tahoma", 0, 64)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbbPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BoxSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LblAnima1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblAnima2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblAnima3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblAnima4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LblAnima6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblAnima7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LblAnima5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoxSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbPers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(LblAnima1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblAnima2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblAnima4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LblAnima3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblAnima5, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(LblAnima6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LblAnima7, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(BtnRun)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción Botón Run
     *
     * @param evt
     */
    private void BtnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRunActionPerformed
        try {
            validarAccion();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        hilos();
    }//GEN-LAST:event_BtnRunActionPerformed

    private void BoxSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoxSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BoxSelectionActionPerformed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BoxSelection;
    private javax.swing.JButton BtnRun;
    private javax.swing.JLabel LblAnima1;
    private javax.swing.JLabel LblAnima2;
    private javax.swing.JLabel LblAnima3;
    private javax.swing.JLabel LblAnima4;
    private javax.swing.JLabel LblAnima5;
    private javax.swing.JLabel LblAnima6;
    private javax.swing.JLabel LblAnima7;
    private javax.swing.JComboBox<String> cbbPers;
    // End of variables declaration//GEN-END:variables
}
