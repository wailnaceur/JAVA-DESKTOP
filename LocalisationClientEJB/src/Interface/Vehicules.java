/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import dao.IVehicule;
import entities.Vehicule;
import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author EL MAHDI
 */
public class Vehicules extends javax.swing.JInternalFrame {

    
    private IVehicule remote;
    private DefaultTableModel model;
    private int id = -1;
    public static IVehicule lookUp() throws NamingException {
		Hashtable<Object, Object> config = new Hashtable<Object, Object>();
		config.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		config.put(Context.PROVIDER_URL, "http-remoting://localhost:8099");
		final Context context = new InitialContext(config);
		return (IVehicule) context.lookup("ejb:/LocalisationEJB-SERVER/VEH!dao.IVehicule");
	}

    /**
     * Creates new form Machines
     */
    public Vehicules() {
         try {
            initComponents();
            model = (DefaultTableModel) listeM.getModel();
            remote = lookUp();
            Load();
        } catch (NamingException ex) {
            Logger.getLogger(Vehicules.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Load() {
        for(Vehicule v:remote.findAll()) {
            model.addRow(new Object[]{
                v.getId(),
                v.getMatricule(),
                v.getMarque(),
                v.getType()

            });
        };
        
        cmbrech.removeAllItems();
        remote.findAll().forEach((m)->{
            cmbrech.addItem(m.getId());
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listeM = new javax.swing.JTable();
        imprimer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        matricule = new javax.swing.JTextField();
        marque = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        sup = new javax.swing.JLabel();
        ajouter = new javax.swing.JLabel();
        nouvaeu = new javax.swing.JLabel();
        modif = new javax.swing.JLabel();
        ADD = new javax.swing.JLabel();
        Modify = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        newa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cmbrech = new javax.swing.JComboBox<>();
        search = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestion Machines");
        setAutoscrolls(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setDoubleBuffered(true);

        jPanel4.setBackground(new java.awt.Color(0, 78, 57));
        jPanel4.setForeground(new java.awt.Color(0, 11, 28));

        jPanel3.setBackground(new java.awt.Color(0, 78, 57));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Vehicules", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        listeM.setAutoCreateRowSorter(true);
        listeM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Matricule", "Marque", "Type"
            }
        ));
        listeM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeMMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listeM);

        imprimer.setBackground(new java.awt.Color(255, 255, 255));
        imprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-print-30.png"))); // NOI18N
        imprimer.setBorder(null);
        imprimer.setBorderPainted(false);
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(253, 253, 253))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 78, 57));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations Vehicule", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Matricule:");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Marque:");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type:");

        matricule.setBackground(new java.awt.Color(204, 255, 255));

        marque.setBackground(new java.awt.Color(204, 255, 255));
        marque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marqueActionPerformed(evt);
            }
        });

        type.setBackground(new java.awt.Color(204, 255, 255));

        sup.setToolTipText("supprimer le client");
        sup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supMouseClicked(evt);
            }
        });

        ajouter.setToolTipText("Ajouter le client");
        ajouter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ajouterMouseClicked(evt);
            }
        });

        nouvaeu.setToolTipText("Nouveau client");
        nouvaeu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nouvaeu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nouvaeuMouseClicked(evt);
            }
        });

        modif.setToolTipText("Modifier le client");
        modif.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        modif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifMouseClicked(evt);
            }
        });

        ADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moi/icons8-plus-32.png"))); // NOI18N
        ADD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ADDMouseClicked(evt);
            }
        });

        Modify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moi/icons8-modifier-32.png"))); // NOI18N
        Modify.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Modify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModifyMouseClicked(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/moi/icons8-supprimer-32.png"))); // NOI18N
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });

        newa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-new-30_1.png"))); // NOI18N
        newa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(marque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(matricule, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(type, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                                .addGap(0, 98, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nouvaeu)
                                .addGap(18, 18, 18)
                                .addComponent(ajouter))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ADD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Modify)
                        .addGap(12, 12, 12)
                        .addComponent(delete)
                        .addGap(9, 9, 9)
                        .addComponent(newa)
                        .addGap(98, 98, 98)))
                .addGap(18, 18, 18)
                .addComponent(sup)
                .addGap(18, 18, 18)
                .addComponent(modif)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {marque, matricule, type});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADD)
                    .addComponent(newa)
                    .addComponent(Modify)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sup, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ajouter, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(modif, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(88, 88, 88)
                .addComponent(nouvaeu)
                .addGap(35, 35, 35))
        );

        jPanel2.setBackground(new java.awt.Color(0, 78, 57));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chercher", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID Vehicule:");

        cmbrech.setBackground(new java.awt.Color(255, 51, 51));
        cmbrech.setEditable(true);
        cmbrech.setToolTipText("Id_Client");

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-detective-30.png"))); // NOI18N
        search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(cmbrech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbrech, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(search))
                .addGap(37, 37, 37))
        );

        jLabel9.setBackground(new java.awt.Color(0, 78, 57));
        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("  Gestion des Vehicules");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeMMouseClicked
        // TODO add your handling code here:

        id = Integer.parseInt(model.getValueAt(listeM.getSelectedRow(), 0).toString());
        marque.setText(model.getValueAt(listeM.getSelectedRow(), 1).toString());
        matricule.setText(model.getValueAt(listeM.getSelectedRow(), 2).toString());
        type.setText(model.getValueAt(listeM.getSelectedRow(), 3).toString());
        
        
    }//GEN-LAST:event_listeMMouseClicked

    private void modifMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifMouseClicked

    }//GEN-LAST:event_modifMouseClicked

    private void nouvaeuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nouvaeuMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_nouvaeuMouseClicked

    private void ajouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ajouterMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ajouterMouseClicked

    private void supMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_supMouseClicked

    private void marqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marqueActionPerformed

    private void ADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ADDMouseClicked
        // TODO add your handling code here:
        model.setRowCount(0);
        String mar = marque.getText();
        String tp = type.getText();
        String mat = matricule.getText();
        if (remote.ajouter(new Vehicule(mat, mar,tp))) {
            JOptionPane.showMessageDialog(this, "Bien Ajoute");
            Load();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur D'Ajout");
        }
    }//GEN-LAST:event_ADDMouseClicked

    private void ModifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifyMouseClicked
        // TODO add your handling code here:
         model.setRowCount(0);
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment modifier?");
        if (reponse == 0) {
            String mar = marque.getText();
            String tp = type.getText();
            String mat = matricule.getText();
            
            if (remote.modifier(new Vehicule(mat,mar,tp))) {
                JOptionPane.showMessageDialog(this, "Bien Modifi??");
                Load();
            } else {
                JOptionPane.showMessageDialog(this, "Erreur de Modification");
            }
        }
    }//GEN-LAST:event_ModifyMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
         model.setRowCount(0);
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer?");
        if (reponse == 0) {
            if (remote.supprimer(remote.findById(id))) {
                JOptionPane.showMessageDialog(this, "Bien Supprim??");
                Load();
            } else {
                JOptionPane.showMessageDialog(this, "Erreur de suppression");
            }
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void newaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newaMouseClicked
        // TODO add your handling code here:
        marque.setText("");
        matricule.setText("");
        type.setText("");
        
    }//GEN-LAST:event_newaMouseClicked

    private void searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchMouseClicked
        // TODO add your handling code here:
         id = cmbrech.getSelectedIndex();
        marque.setText(model.getValueAt(id, 1).toString());
        matricule.setText(model.getValueAt(id, 2).toString());
        type.setText(model.getValueAt(id, 3).toString());
        
    }//GEN-LAST:event_searchMouseClicked

    private void imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerActionPerformed
        // TODO add your handling code here:
        MessageFormat header=new MessageFormat("Liste Vehicules ");
        MessageFormat footer=new MessageFormat("Page{0,number,integer} ");
        try{
            listeM.print(JTable.PrintMode.NORMAL,header,footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_imprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ADD;
    private javax.swing.JLabel Modify;
    private javax.swing.JLabel ajouter;
    private javax.swing.JComboBox<Object> cmbrech;
    private javax.swing.JLabel delete;
    private javax.swing.JButton imprimer;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listeM;
    private javax.swing.JTextField marque;
    private javax.swing.JTextField matricule;
    private javax.swing.JLabel modif;
    private javax.swing.JLabel newa;
    private javax.swing.JLabel nouvaeu;
    private javax.swing.JLabel search;
    private javax.swing.JLabel sup;
    private javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables
}
