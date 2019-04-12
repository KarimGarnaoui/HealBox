/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import static javax.swing.SwingConstants.LEFT;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class MenuPrincipal extends JFrame implements ActionListener{
      
    public JPanel P1, P2;
    public JButton six, huit,douze,seize, six2, huit2,douze2,seize2, six3, huit3,douze3,seize3,ajouter, retirer, plus, moins, plus2, moins2,plus3, moins3, cloche, menu, accueil, oui, non, oui2, non2, ok_final, ok1, okay, ok2, inventaire_general, faibles_quantites, peremption, notice;
    public JLabel l1, notifs;
    public JTextField t1, t12,t123, t2, consommer, QRCode, QRCode2, QRCode3,QRCode4, Berreur;
    public int nombre;
    public String nombre2;
    public Connection connexion;
    public JTable table;
    public  String erreur,Label_consomme; 
    public int Gelules_consomme, notifications;
    
    //fonction qui gère l'affichage au lancement de l'application et qui gère l'initialisation des variables importantes 
    public MenuPrincipal (Connection connexion){
        
    this.connexion=connexion;   
    
    notifications = 0;
    notifications();
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setSize(1024,600);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
    setTitle("Mon App");
    
           
    P1 = new JPanel();
    P2 = new JPanel();
    P1.setBackground(new Color(0xFFFFFF));
    P2.setBackground(new Color(0xFFFFFF));
      
    P1.setPreferredSize(new Dimension(1024,430));
    P2.setPreferredSize(new Dimension(1024,137));
    P1.setBorder(BorderFactory.createLineBorder(Color.black));   
    P2.setBorder(BorderFactory.createLineBorder(Color.black));  
    P1.setLayout(null);
    P2.setLayout(null);

    Font font = new Font ("Arial",Font.BOLD,34);
    Font boutons = new Font ("Arial",Font.BOLD,28);
    Font font2 = new Font ("Arial",Font.PLAIN,35);
    
     notifs = new JLabel("(" + String.valueOf(notifications) + ")" );
    notifs.setBounds(275,10,100,100);
    notifs.setFont(font2);
    notifs.setForeground(new Color(0xF70808));  
    
    ajouter= new JButton("Ajouter");
    ajouter.setBounds(830,25,170,90 ); 
    ajouter.setBackground(new Color(0x11FF00));
    ajouter.setForeground(new Color(0xFFFFFF));
    ajouter.addActionListener(this);
    ajouter.setFont(boutons);
   
    retirer= new JButton("Retirer");
    retirer.setBounds(640,25,170,90);
    retirer.setBackground(new Color(0xFF0000));
    retirer.setForeground(new Color(0xFFFFFF));
    retirer.addActionListener(this);
    retirer.setFont(boutons);
   
    accueil = new JButton("Accueil");
    accueil.setBounds(370,50,200,30);
    accueil.setFont(font);
    accueil.setBackground(new Color(0xFFFFFF));
    accueil.setBorderPainted(false);
    accueil.addActionListener(this);
    
    Font Fplus = new Font ("Arial",Font.BOLD,80);
    Font Fplus2 = new Font ("Arial",Font.BOLD,100);
    Font Fchiffre = new Font ("Arial",Font.BOLD,20);
    
    
    plus= new JButton("+");
    plus.setBounds(580,150,120,100);
    plus.setFont(Fplus);
    plus.setBackground(new Color(0xFFFFFF));
    plus.addActionListener(this);
    plus.setBorderPainted(false);
    //plus.setBorder(BorderFactory.createLineBorder(Color.black));
    
    moins= new JButton("-");
    moins.setBounds(280,145,100,100);
    moins.setFont(Fplus);
    moins.setBackground(new Color(0xFFFFFF));
    moins.addActionListener(this);
    moins.setBorderPainted(false);
    //moins.setBorder(BorderFactory.createLineBorder(Color.black));
    
    six= new JButton("6");
        six.setBounds(270,260,120,50);
        six.setFont(Fchiffre);
        six.setBackground(new Color(0xFFFFFF));
        six.setBorderPainted(false);
        six.addActionListener(this);

        huit= new JButton("8");
        huit.setBounds(380,260,120,50);
        huit.setFont(Fchiffre);
        huit.setBackground(new Color(0xFFFFFF));
        huit.setBorderPainted(false);
        huit.addActionListener(this);

        douze= new JButton("12");
        douze.setBounds(490,260,120,50);
        douze.setFont(Fchiffre);
        douze.setBackground(new Color(0xFFFFFF));
        douze.setBorderPainted(false);
        douze.addActionListener(this);

        seize= new JButton("16");
        seize.setBounds(600,260,120,50);
        seize.setFont(Fchiffre);
        seize.setBackground(new Color(0xFFFFFF));
        seize.setBorderPainted(false);
        seize.addActionListener(this);

    nombre=0;
    nombre2=String.valueOf(nombre);
    t1 = new JTextField(nombre2);
    t1.setEditable(false);
    t1.setFont(Fplus2);
    t1.setBackground(new Color(0xFFFFFF));
    t1.setBounds(445,150,135,100);
    t1.setBorder(BorderFactory.createLineBorder(Color.white));
    
    consommer = new JTextField("Combien de gélules voulez-vous consommer ?");
    consommer.setEditable(false);
    consommer.setFont(font2);
    consommer.setBackground(new Color(0xFFFFFF));
    consommer.setBounds(145,50,850,100);
    consommer.setBorder(BorderFactory.createLineBorder(Color.white));
    
    QRCode = new JTextField();
    QRCode.setBackground(new Color(0xFFFFFF));
    QRCode.setForeground(new Color(0xFFFFFF));
    QRCode.setBounds(145,300,800,50);
    QRCode.setBorder(BorderFactory.createLineBorder(Color.white));
    QRCode.setFocusable(true);
    QRCode.addActionListener(this);
    
    
    ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("pkginterface/cloche.jpg")); 
    JLabel lab = new JLabel(ii);
    ImageIcon ii2 = new ImageIcon(ClassLoader.getSystemResource("pkginterface/menu.jpg")); 
    JLabel lab2 = new JLabel(ii2);
    menu= new JButton(ii2);
    menu.setBounds(10,10,120,100);
    menu.setBorderPainted(false);
    menu.addActionListener(this);
    
    cloche= new JButton(ii);
    cloche.setBounds(150,10,120,100);
    cloche.setBorderPainted(true);
    cloche.addActionListener(this);
    cloche.setBackground(new Color(0xFFFFFF));
    cloche.setBorder(BorderFactory.createLineBorder(Color.black));
    
    P2.add(cloche); 
    P2.add(menu); 
    P2.add(accueil);
    P2.add(ajouter);
    P2.add(retirer);
    P2.add(notifs);

    P1.add(consommer);
    P1.add(QRCode);
    P1.add(moins);
    P1.add(plus);
    P1.add(t1);
    P1.add(six);
    P1.add(huit);
    P1.add(douze);
    P1.add(seize);
     
   
    add(P2, "North");
    add(P1, "South");
    QRCode.requestFocus(); 
    setVisible(true); 
    }
    
    //fonction qui gère les action réalisées par chaque élément graphique lorsqu'il est activé
    public void actionPerformed(ActionEvent e)
       {
           if(e.getSource()==ajouter)
           {
              P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
             //ajouter_interface();
               non2_interface();
           }
           
           if(e.getSource()==retirer)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
            //retirer_interface();
               non_interface();
           }

           if(e.getSource()== plus)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
             QRCode.requestFocus(); 
             nombre++;
             if(nombre>=0)
             {
                nombre2=String.valueOf(nombre);
                t1.setText(nombre2);
             }
             else nombre=0;
             
           }
           
           if(e.getSource()==moins)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
             QRCode.requestFocus(); 
             nombre--;
             
             if(nombre>=0)
             {
               nombre2=String.valueOf(nombre);
               t1.setText(nombre2);
             }
             else nombre=0;
             
           }           
           
           if(e.getSource()== plus2)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
             QRCode2.requestFocus(); 
             nombre++;
             if(nombre>=0)
             {
                nombre2=String.valueOf(nombre);
                t12.setText(nombre2);
             }
             else nombre=0;             
           }
           
           if(e.getSource()==moins2)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
             QRCode2.requestFocus(); 
             nombre--;
             if(nombre>=0)
             {
                nombre2=String.valueOf(nombre);
                t12.setText(nombre2);
             }
             else nombre=0;
             
           }           
           
           if(e.getSource()== plus3)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
             QRCode3.requestFocus(); 
             nombre++;
             if(nombre>=0)
             {
                nombre2=String.valueOf(nombre);
                t123.setText(nombre2);
             }
             else nombre=0;
           }
           
           if(e.getSource()==moins3)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
             QRCode3.requestFocus(); 
             nombre--;
             if(nombre>=0)
             {
                nombre2=String.valueOf(nombre);
                t123.setText(nombre2);
             }
             else nombre=0;
             
           }    
           
           if(e.getSource()==cloche)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
               cloche_interface();
           }
           
           if(e.getSource()==menu)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
               menu_interface();
           }
           
           if(e.getSource()==accueil)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
              accueil_interface();   
           }
           
           if(e.getSource()==ok_final)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
              P1.removeAll();
              P1.updateUI(); 
              accueil_interface();
           }
          
           if(e.getSource()==inventaire_general)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
              P1.removeAll();
              
              JScrollPane stockgen = new JScrollPane();
              Font Fok = new Font ("Arial",Font.PLAIN,20);
              JTable tab = new JTable();
    
              tab = scanner_inventaire_general();
              
              DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
              custom.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau
              
              for (int i=0 ; i < tab.getColumnCount() ; i++) {// centre chaque cellule de ton tableau
                    tab.getColumnModel().getColumn(i).setCellRenderer(custom); 
                }
              
              stockgen.setBounds(0,0,1018,430);
              stockgen.setBorder(BorderFactory.createLineBorder(Color.black));
              tab.setFont(Fok);
              tab.setRowHeight(40);
              tab.setCellSelectionEnabled(false);
              tab.setRowSelectionAllowed(false);
              stockgen.getViewport().add(tab);
              P1.add(stockgen);
              P1.updateUI();
           }
           
          if(e.getSource()==faibles_quantites)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
              P1.removeAll();
              
              JScrollPane stockgen = new JScrollPane();
              Font Fok = new Font ("Arial",Font.PLAIN,20);
              JTable tab = new JTable();
    
              tab = scanner_faible_quantite();
              
              DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
              custom.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau
              
              for (int i=0 ; i < tab.getColumnCount() ; i++) {// centre chaque cellule de ton tableau
                    tab.getColumnModel().getColumn(i).setCellRenderer(custom); 
                }
              
              stockgen.setBounds(0,0,1018,430);
              stockgen.setBorder(BorderFactory.createLineBorder(Color.black));
              tab.setFont(Fok);
              tab.setRowHeight(40);
              tab.setCellSelectionEnabled(false);
              tab.setRowSelectionAllowed(false);
              stockgen.getViewport().add(tab);
              P1.add(stockgen);
              P1.updateUI();
           }
           
           if(e.getSource()==peremption)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
              P1.removeAll();
              
              JScrollPane stockgen = new JScrollPane();
              Font Fok = new Font ("Arial",Font.PLAIN,20);
              JTable tab = new JTable();
    
              tab = scanner_peremption();
              
              DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
              custom.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau
              
              for (int i=0 ; i < tab.getColumnCount() ; i++) {// centre chaque cellule de ton tableau
                    tab.getColumnModel().getColumn(i).setCellRenderer(custom); 
                }
              
              stockgen.setBounds(0,0,1018,430);
              stockgen.setBorder(BorderFactory.createLineBorder(Color.black));
              tab.setFont(Fok);
              tab.setRowHeight(40);
              tab.setCellSelectionEnabled(false);
              tab.setRowSelectionAllowed(false);
              stockgen.getViewport().add(tab);
              P1.add(stockgen);
              P1.updateUI();
           }
                   
           if(e.getSource()==notice)
           {
               P2.remove(notifs);
              notifications();
              notifs.setText("(" + String.valueOf(notifications) + ")");
              P2.add(notifs);
              P2.updateUI();
              P1.removeAll();
              notices();
              P1.updateUI();
           }
           
           if(e.getSource()==QRCode)
           {         
             scanner_accueil();
           }
           if(e.getSource()==QRCode2)
           {         
             scanner_retirer();
           }
           if(e.getSource()==QRCode3)
           {         
             scanner_ajouter();
           }
           if(e.getSource()==QRCode4){
             scanner_notice();
           }
            
           //bouton de retour à l'interface des notices
           if(e.getSource()==okay){
               notices();
           }
           
            if(e.getSource()==six){
               t1.setText("6");
               nombre=Integer.parseInt(t1.getText());
               QRCode.requestFocus();
           }
             if(e.getSource()==huit){
               t1.setText("8");
               nombre=Integer.parseInt(t1.getText());
               QRCode.requestFocus();
           }
              if(e.getSource()==douze){
               t1.setText("12");
               nombre=Integer.parseInt(t1.getText());
               QRCode.requestFocus();
           }
               if(e.getSource()==seize){
              t1.setText("16");
              nombre=Integer.parseInt(t1.getText());
              QRCode.requestFocus();
           }
               
                if(e.getSource()==six2){
               t12.setText("6");
               nombre=Integer.parseInt(t12.getText());
               QRCode2.requestFocus();
           }
             if(e.getSource()==huit2){
               t12.setText("8");
               nombre=Integer.parseInt(t12.getText());
               QRCode2.requestFocus();
           }
              if(e.getSource()==douze2){
               t12.setText("12");
               nombre=Integer.parseInt(t12.getText());
               QRCode2.requestFocus();
           }
               if(e.getSource()==seize2){
              t12.setText("16");
              nombre=Integer.parseInt(t12.getText());
              QRCode2.requestFocus();
           }
               
               if(e.getSource()==six3){
               t123.setText("6");
               nombre=Integer.parseInt(t123.getText());
               QRCode3.requestFocus();
           }
             if(e.getSource()==huit3){
               t123.setText("8");
               nombre=Integer.parseInt(t123.getText());
               QRCode3.requestFocus();
           }
              if(e.getSource()==douze3){
               t123.setText("12");
               nombre=Integer.parseInt(t123.getText());
               QRCode3.requestFocus();
           }
               if(e.getSource()==seize3){
              t123.setText("16");
              nombre=Integer.parseInt(t123.getText());
              QRCode3.requestFocus();
           }
           
                  
       }
    

     //fonction qui gère l'affichage des notifications
   public void cloche_interface(){
          P1.removeAll();
         
          Date actuelle = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          String date = dateFormat.format(actuelle);
          int jourAct = Integer.parseInt(date.substring(0,2));
          int moisAct = Integer.parseInt(date.substring(3,5));
          int anneeAct = Integer.parseInt(date.substring(8,10));
          
          Font Fok = new Font ("Arial",Font.PLAIN,25);
          JScrollPane stockgen = new JScrollPane();
          
          MyTableModel model_notifs = new MyTableModel();
          model_notifs.addColumn("Notifications");
          
         try {
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			/* Exécution d'une requête de lecture */
			ResultSet resultat = statement.executeQuery( "SELECT Label, Quantite, DatePeremption, NbrBoite FROM stock;" );
			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next()) {
                            
                            String jour = resultat.getString("DatePeremption").substring(0,2);
                            int journee = Integer.parseInt(jour);
                            String mois = resultat.getString("DatePeremption").substring(3,5);
                            int moisInt = Integer.parseInt(mois);
                            String annee = resultat.getString("DatePeremption").substring(8,10);
                            int anneeInt = Integer.parseInt(annee);
                            
                            
                            if((moisInt==moisAct)&&(anneeInt==anneeAct)&&((journee-jourAct)>=0)){
                                
                                if((journee-jourAct)<=5){
                                    String laligne = " Votre boîte de " + resultat.getString("Label") + " va expirer dans " + String.valueOf(journee-jourAct) + " jour(s)";
                                    Object[]data2 ={laligne};
                                    model_notifs.addRow(data2);
                                }
                                
                            }
                            
                            else if((moisAct==(moisInt-1))&&(journee<=3)){
                                if(((journee+30)-jourAct)<5){
                                    String laligne = " Votre boîte de " + resultat.getString("Label") + " va expirer dans " + String.valueOf((journee+30)-jourAct) + " jour(s)";
                                    Object[]data2 ={laligne};
                                    model_notifs.addRow(data2);
                                } 
                            }
                            
                            else if ((moisAct>moisInt)||((moisAct==moisInt)&&(jourAct>journee))||(anneeAct>anneeInt)){
                                String laligne = " Votre boîte de " + resultat.getString("Label") + " est périmée ";
                                    Object[]data2 ={laligne};
                                    model_notifs.addRow(data2);
                            }
                            
			}
                        
                        resultat = statement.executeQuery( "SELECT Label, Quantite, DatePeremption, NbrBoite FROM stock;" );
			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next()) {
                            if(resultat.getInt("Quantite")<=3){
                            String laligne = "Il ne vous reste plus que " + resultat.getString("Quantite") + " " +resultat.getString("Label");
                            Object[]data2 ={laligne};
                            model_notifs.addRow(data2);
                            }
			}
                        
                        table = new JTable(model_notifs);
                        table.getTableHeader().setPreferredSize(new Dimension(table.getTableHeader().getWidth(), 50));
                        table.getTableHeader().setFont(Fok);
                        
                        DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
                        custom.setHorizontalAlignment(JLabel.CENTER); // centre les données de ton tableau
              
                        for (int i=0 ; i < table.getColumnCount() ; i++) {// centre chaque cellule de ton tableau
                              table.getColumnModel().getColumn(i).setCellRenderer(custom); 
                          }
              
                        stockgen.setBounds(0,0,1018,430);
                        stockgen.setBorder(BorderFactory.createLineBorder(Color.black));
                        table.setFont(Fok);
                        table.setRowHeight(40);
                        table.setCellSelectionEnabled(false);
                        table.setRowSelectionAllowed(false);
                        stockgen.getViewport().add(table);
                        
                        P1.add(stockgen);
                        P1.updateUI();
             
		} catch (SQLException e) {
			e.printStackTrace();
		}  
          P1.updateUI();
     }
   
   //fonction qui compte le nombre de notifications 
   public final void notifications(){
         
          Date actuelle = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          String date = dateFormat.format(actuelle);
          int jourAct = Integer.parseInt(date.substring(0,2));
          int moisAct = Integer.parseInt(date.substring(3,5));
          int anneeAct = Integer.parseInt(date.substring(8,10));
          
          notifications = 0;
          
         try {
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			/* Exécution d'une requête de lecture */
			ResultSet resultat = statement.executeQuery( "SELECT Label, Quantite, DatePeremption, NbrBoite FROM stock;" );
			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next()) {
                            
                            String jour = resultat.getString("DatePeremption").substring(0,2);
                            int journee = Integer.parseInt(jour);
                            String mois = resultat.getString("DatePeremption").substring(3,5);
                            int moisInt = Integer.parseInt(mois);
                            String annee = resultat.getString("DatePeremption").substring(8,10);
                            int anneeInt = Integer.parseInt(annee);
                            
                            
                            if((moisInt==moisAct)&&(anneeInt==anneeAct)){
                                
                                if((journee-jourAct)<=5){
                                    notifications ++;
                                }
                                
                            }
                            
                            else if((moisAct==(moisInt-1))&&(journee<=3)){
                                if(((journee+30)-jourAct)<5){
                                    notifications ++;
                                } 
                            }
                            
                            else if ((moisAct>moisInt)||((moisAct==moisInt)&&(jourAct>journee))||(anneeAct>anneeInt)){
                                    notifications ++;
                            }
                            
			}
                        
                        resultat = statement.executeQuery( "SELECT Label, Quantite, DatePeremption, NbrBoite FROM stock;" );
			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next()) {
                            if(resultat.getInt("Quantite")<=3){
                            notifications ++; 
                            }
			}
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}
     }
     
   //Fonction d'affichage des options de sous-menu dispo en haut à gauche de l'écran
     public void menu_interface(){
       P1.removeAll();
       P1.updateUI();
       
       JPanel P3 = new JPanel();
       P3.setBackground(new Color(0xFFFFFF));     
       P3.setBorder(BorderFactory.createLineBorder(Color.black));  
       P3.setBounds(30,60,954,300);
       P3.setLayout(null);
       
       Font font = new Font("Arial",Font.PLAIN,35);
         
       inventaire_general = new JButton ("Inventaire général");
       inventaire_general.setBounds(10,30,625,50);
       inventaire_general.setBackground(new Color(0xFFFFFF));
       inventaire_general.addActionListener(this);
       inventaire_general.setBorderPainted(false);
       inventaire_general.setFont(font);
       inventaire_general.setHorizontalAlignment(LEFT);
       
       faibles_quantites= new JButton ("Inventaire des faibles quantités");
       faibles_quantites.setBounds(10,90,625,50);
       faibles_quantites.setBackground(new Color(0xFFFFFF));
       faibles_quantites.addActionListener(this);
       faibles_quantites.setBorderPainted(false);
       faibles_quantites.setFont(font);
       faibles_quantites.setHorizontalAlignment(LEFT);
       
       peremption= new JButton ("Inventaire des médicaments bientôt périmés");
       peremption.setBounds(10,150,920,50);
       peremption.setBackground(new Color(0xFFFFFF));
       peremption.addActionListener(this);
       peremption.setBorderPainted(false);
       peremption.setFont(font);
       peremption.setHorizontalAlignment(LEFT);
       
       notice=new JButton ("Notices");
       notice.setBounds(10,210,625,50);
       notice.setBackground(new Color(0xFFFFFF));
       notice.addActionListener(this);
       notice.setBorderPainted(false);
       notice.setFont(font);
       notice.setHorizontalAlignment(LEFT);
       
       P3.add(inventaire_general);
       P3.add(faibles_quantites);
       P3.add(notice);
       P3.add(peremption);
       P1.add(P3);
     }
     
     //Fonction d'affichage de l'accueil de l'interface
     public void accueil_interface(){
       P1.removeAll();
       P1.updateUI();
         
       Font Fplus = new Font ("Arial",Font.BOLD,80);
       Font Fplus2 = new Font ("Arial",Font.BOLD,100);
       Font boutons = new Font ("Arial",Font.BOLD,28);
    
       plus= new JButton("+");
       plus.setBounds(580,150,120,100);
       plus.setFont(Fplus);
       plus.setBackground(new Color(0xFFFFFF));
       plus.addActionListener(this);
       plus.setBorderPainted(false);
        //plus.setBorder(BorderFactory.createLineBorder(Color.black));

        moins= new JButton("-");
        moins.setBounds(280,145,100,100);
        moins.setFont(Fplus);
        moins.setBackground(new Color(0xFFFFFF));
        moins.addActionListener(this);
        moins.setBorderPainted(false);
        //moins.setBorder(BorderFactory.createLineBorder(Color.black));

        nombre=0;
        nombre2=String.valueOf(nombre);
        t1 = new JTextField(nombre2);
        t1.setEditable(false);
        t1.setFont(Fplus2);
        t1.setBackground(new Color(0xFFFFFF));
        t1.setBounds(445,150,135,100);
        t1.setBorder(BorderFactory.createLineBorder(Color.white));
        
        Font font2 = new Font ("Arial",Font.PLAIN,35);
        
        consommer = new JTextField("Combien de gélules voulez-vous consommer ?");
        consommer.setEditable(false);
        consommer.setFont(font2);
        consommer.setBackground(new Color(0xFFFFFF));
        consommer.setBounds(145,50,850,100);
        consommer.setBorder(BorderFactory.createLineBorder(Color.white));
        
        QRCode = new JTextField();
        QRCode.setBackground(new Color(0xFFFFFF));
        QRCode.setForeground(new Color(0xFFFFFF));
        QRCode.setBounds(145,300,800,50);
        QRCode.setBorder(BorderFactory.createLineBorder(Color.white));
        QRCode.setFocusable(true);
        QRCode.addActionListener(this);
        
        Font Fchiffre = new Font ("Arial",Font.BOLD,20);
        
        six= new JButton("6");
        six.setBounds(270,260,120,50);
        six.setFont(Fchiffre);
        six.setBackground(new Color(0xFFFFFF));
        six.setBorderPainted(false);
        six.addActionListener(this);

        huit= new JButton("8");
        huit.setBounds(380,260,120,50);
        huit.setFont(Fchiffre);
        huit.setBackground(new Color(0xFFFFFF));
        huit.setBorderPainted(false);
        huit.addActionListener(this);

        douze= new JButton("12");
        douze.setBounds(490,260,120,50);
        douze.setFont(Fchiffre);
        douze.setBackground(new Color(0xFFFFFF));
        douze.setBorderPainted(false);
        douze.addActionListener(this);

        seize= new JButton("16");
        seize.setBounds(600,260,120,50);
        seize.setFont(Fchiffre);
        seize.setBackground(new Color(0xFFFFFF));
        seize.setBorderPainted(false);
        seize.addActionListener(this);
 
        
        P1.add(QRCode);
        P1.add(consommer);
        P1.add(plus);
        P1.add(moins);
        P1.add(t1);
        P1.add(six);
        P1.add(huit);
        P1.add(douze);
        P1.add(seize);
        QRCode.requestFocus();
     }
     
     //Il s'agit de la fonction qui permet d'afficher le menu de choix du nombre de médicaments à retirer
     public void non_interface()
     {
        P1.removeAll();
        P1.updateUI();            
            
            
        JPanel P5 = new JPanel();
        P5.setBackground(new Color(0xFFFFFF));     
        P5.setBorder(BorderFactory.createLineBorder(Color.black));  
        P5.setBounds(100,60,824,300);
        P5.setLayout(null);
        
        Font font3 = new Font ("Arial",Font.PLAIN,30);
      

            JLabel l4 = new JLabel("Combien de médicaments votre boîte contient-elle ?");
            l4.setBounds(20,20,820,30);
            l4.setFont(font3);
                    
            Font Fplus = new Font ("Arial",Font.BOLD,80);
            Font Fplus2 = new Font ("Arial",Font.BOLD,100);
            Font boutons = new Font ("Arial",Font.BOLD,28);
            Font Fok = new Font ("Arial",Font.PLAIN,45);
            

            ok1 = new JButton("Ok");
            ok1.setBounds(330,200,150,90);
            ok1.setBackground(new Color(0xFFFFFF));
            ok1.addActionListener(this);
            ok1.setFont(Fok);
            ok1.setBorderPainted(false);

            plus2= new JButton("+");
            plus2.setBounds(510,80,120,100);
            plus2.setFont(Fplus);
            plus2.setBackground(new Color(0xFFFFFF));
            plus2.addActionListener(this);
            plus2.setBorderPainted(false);
            //plus.setBorder(BorderFactory.createLineBorder(Color.black));

            moins2= new JButton("-");
            moins2.setBounds(210,80,100,100);
            moins2.setFont(Fplus);
            moins2.setBackground(new Color(0xFFFFFF));
            moins2.addActionListener(this);
            moins2.setBorderPainted(false);
            //moins.setBorder(BorderFactory.createLineBorder(Color.black));

            nombre=0;
            nombre2=String.valueOf(nombre);
            t12 = new JTextField(nombre2);
            t12.setEditable(false);
            t12.setFont(Fplus2);
            t12.setBackground(new Color(0xFFFFFF));
            t12.setBounds(375,80,135,100);
            t12.setBorder(BorderFactory.createLineBorder(Color.white));
            
            QRCode2 = new JTextField();
            QRCode2.setBackground(new Color(0xFFFFFF));
            QRCode2.setForeground(new Color(0xFFFFFF));
            QRCode2.setBounds(10,180,800,40);
            QRCode2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            QRCode2.setFocusable(true);
            QRCode2.addActionListener(this);
            
            Font Fchiffre = new Font ("Arial",Font.BOLD,20);
            
            six2= new JButton("6");
            six2.setBounds(190,220,120,50);
            six2.setFont(Fchiffre);
            six2.setBackground(new Color(0xFFFFFF));
            six2.setBorderPainted(false);
            six2.addActionListener(this);
            
            huit2= new JButton("8");
            huit2.setBounds(300,220,120,50);
            huit2.setFont(Fchiffre);
            huit2.setBackground(new Color(0xFFFFFF));
            huit2.setBorderPainted(false);
            huit2.addActionListener(this);

            douze2= new JButton("12");
            douze2.setBounds(410,220,120,50);
            douze2.setFont(Fchiffre);
            douze2.setBackground(new Color(0xFFFFFF));
            douze2.setBorderPainted(false);
            douze2.addActionListener(this);

            seize2= new JButton("16");
            seize2.setBounds(520,220,120,50);
            seize2.setFont(Fchiffre);
            seize2.setBackground(new Color(0xFFFFFF));
            seize2.setBorderPainted(false);
            seize2.addActionListener(this);
                       
            P5.add(plus2);
            P5.add(moins2);
            P5.add(t12);
            P5.add(six2);
            P5.add(huit2);
            P5.add(seize2);
            P5.add(douze2);
            //P5.add(ok1);
            P5.add(QRCode2);
            P5.add(l4);
            P1.add(P5);
            QRCode2.requestFocus();
     }
     
     
     // Ajouter
     //Il s'agit de la fonction qui permet d'afficher le menu de choix du nombre de médicaments à ajouter
     public void non2_interface()
     {
            P1.removeAll();
            P1.updateUI();            

            JPanel P5 = new JPanel();
            P5.setBackground(new Color(0xFFFFFF));     
            P5.setBorder(BorderFactory.createLineBorder(Color.black));  
            P5.setBounds(100,60,824,300);
            P5.setLayout(null);

            Font font3 = new Font ("Arial",Font.PLAIN,30);
      

            JLabel l4 = new JLabel("Combien de médicaments votre boîte contient-elle ?");
            l4.setBounds(20,20,820,30); 
            l4.setFont(font3);
                    
            Font Fplus = new Font ("Arial",Font.BOLD,80);
            Font Fplus2 = new Font ("Arial",Font.BOLD,100);
            Font boutons = new Font ("Arial",Font.BOLD,28);
            Font Fok = new Font ("Arial",Font.PLAIN,45);
            

            ok2 = new JButton("Ok");
            ok2.setBounds(330,200,150,90);
            ok2.setBackground(new Color(0xFFFFFF));
            ok2.addActionListener(this);
            ok2.setFont(Fok);
            ok2.setBorderPainted(false);

            plus3= new JButton("+");
            plus3.setBounds(510,80,120,100);
            plus3.setFont(Fplus);
            plus3.setBackground(new Color(0xFFFFFF));
            plus3.addActionListener(this);
            plus3.setBorderPainted(false);
            //plus.setBorder(BorderFactory.createLineBorder(Color.black));

            moins3= new JButton("-");
            moins3.setBounds(210,80,100,100);
            moins3.setFont(Fplus);
            moins3.setBackground(new Color(0xFFFFFF));
            moins3.addActionListener(this);
            moins3.setBorderPainted(false);
            //moins.setBorder(BorderFactory.createLineBorder(Color.black));

            nombre=0;
            nombre2=String.valueOf(nombre);
            t123 = new JTextField(nombre2);
            t123.setEditable(false);
            t123.setFont(Fplus2);
            t123.setBackground(new Color(0xFFFFFF));
            t123.setBounds(375,80,135,100);
            t123.setBorder(BorderFactory.createLineBorder(Color.white));
            
            QRCode3 = new JTextField();
            QRCode3.setBackground(new Color(0xFFFFFF));
            QRCode3.setForeground(new Color(0xFFFFFF));
            QRCode3.setBounds(10,180,800,40);
            QRCode3.setBorder(BorderFactory.createLineBorder(Color.white));
            QRCode3.setFocusable(true);
            QRCode3.addActionListener(this);
            
            Font Fchiffre = new Font ("Arial",Font.BOLD,20);
            
            six3= new JButton("6");
            six3.setBounds(190,220,120,50);
            six3.setFont(Fchiffre);
            six3.setBackground(new Color(0xFFFFFF));
            six3.setBorderPainted(false);
            six3.addActionListener(this);
            
            huit3= new JButton("8");
            huit3.setBounds(300,220,120,50);
            huit3.setFont(Fchiffre);
            huit3.setBackground(new Color(0xFFFFFF));
            huit3.setBorderPainted(false);
            huit3.addActionListener(this);

            douze3= new JButton("12");
            douze3.setBounds(410,220,120,50);
            douze3.setFont(Fchiffre);
            douze3.setBackground(new Color(0xFFFFFF));
            douze3.setBorderPainted(false);
            douze3.addActionListener(this);

            seize3= new JButton("16");
            seize3.setBounds(520,220,120,50);
            seize3.setFont(Fchiffre);
            seize3.setBackground(new Color(0xFFFFFF));
            seize3.setBorderPainted(false);
            seize3.addActionListener(this);
            
            P5.add(plus3);
            P5.add(moins3);
            P5.add(t123);
            P5.add(QRCode3);
            P5.add(six3);
            P5.add(huit3);
            P5.add(seize3);
            P5.add(douze3);
            //P5.add(ok2);
            P5.add(l4);
            P1.add(P5);
            
            QRCode3.requestFocus();
     }
     
     //fonction qui permet de supprimer un médicament
     //elle gère l'affichage du menu de suppression 
     public void supprimer_medicament(){
            P1.removeAll();
            P1.updateUI();
             
             
            JPanel P4 = new JPanel();
            P4.setBackground(new Color(0xFFFFFF));     
            P4.setBorder(BorderFactory.createLineBorder(Color.black));  
            P4.setBounds(100,60,824,300);
            P4.setLayout(null);
            
            Font font2 = new Font ("Arial",Font.PLAIN,35);
            
            //System.out.println(erreur);
            if( erreur=="QRCode invalide !" || erreur=="Vous avez enlevé trop de gélules !" || erreur== "Vous avez enlevé trop de boîtes !" || erreur== "Vous avez enlevé trop de gélules et de boîtes !"){
               JLabel l3 = new JLabel(erreur);
               l3.setBounds(40,70,730,40);
               l3.setFont(font2);
                P4.add(l3);
            }
            if(erreur=="") {
                JLabel l3 = new JLabel("Votre boîte a été correctement supprimée !");
                l3.setBounds(40,70,800,40);
                l3.setFont(font2);
                 P4.add(l3);
            }
            
            Font Fok = new Font ("Arial",Font.PLAIN,45);

            ok_final = new JButton("Ok");
            ok_final.setBounds(330,150,150,90);
            ok_final.setBackground(new Color(0xFFFFFF));
            ok_final.addActionListener(this);
            ok_final.setBorderPainted(false);
            ok_final.setFont(Fok);

           
            P4.add(ok_final);
            P1.add(P4);
            
     }
     
     //fonction qui permet de consommer un médicament à partir de l'écran d'accueil
      public void consommer_medicament(){
            P1.removeAll();
            P1.updateUI();
             
             
            JPanel P4 = new JPanel();
            P4.setBackground(new Color(0xFFFFFF));     
            P4.setBorder(BorderFactory.createLineBorder(Color.black));  
            P4.setBounds(100,60,824,300);
            P4.setLayout(null);
            
            Font font2 = new Font ("Arial",Font.PLAIN,35);
            
            if( erreur=="QRCode invalide !" || erreur=="Vous avez enlevé trop de gélules !"){
               JLabel l3 = new JLabel(erreur);
               l3.setBounds(40,70,730,40);
               l3.setFont(font2);
                P4.add(l3);
            }
            if(erreur=="") {
                JLabel l3 = new JLabel("Vous avez consommé "+Gelules_consomme+" gélules de "+Label_consomme+" !");
                l3.setBounds(0,70,860,40);
                l3.setFont(font2);
                P4.setBounds(90,60,840,300);
                 P4.add(l3);
            }
            
            Font Fok = new Font ("Arial",Font.PLAIN,45);

            ok_final = new JButton("Ok");
            ok_final.setBounds(330,150,150,90);
            ok_final.setBackground(new Color(0xFFFFFF));
            ok_final.addActionListener(this);
            ok_final.setBorderPainted(false);
            ok_final.setFont(Fok);

           
            P4.add(ok_final);
            P1.add(P4);
            
     }
     
     //fonction qui permet d'ajouter un médicament à la base de donnée 
     public void ajouter_medicament(){
            P1.removeAll();
            P1.updateUI();            
             
            JPanel P4 = new JPanel();
            P4.setBackground(new Color(0xFFFFFF));     
            P4.setBorder(BorderFactory.createLineBorder(Color.black));  
            P4.setBounds(100,60,824,300);
            P4.setLayout(null);
            
            Font font2 = new Font ("Arial",Font.PLAIN,35);
            
            
            if( erreur=="QRCode invalide !"){
             JLabel l3 = new JLabel(erreur);
            l3.setBounds(40,70,730,40);
            l3.setFont(font2);   
            P4.add(l3);
            }
            else {
                JLabel l3 = new JLabel("Votre boîte a été correctement ajoutée !");
            l3.setBounds(40,70,730,40);
            l3.setFont(font2);
            P4.add(l3);
            }
            

            
            Font Fok = new Font ("Arial",Font.PLAIN,45);
            ok_final = new JButton("Ok");
            ok_final.setBounds(330,150,150,90);
            ok_final.setBackground(new Color(0xFFFFFF));
            ok_final.addActionListener(this);
            ok_final.setBorderPainted(false);
            ok_final.setFont(Fok);

            P4.add(ok_final);
            P1.add(P4);
     }
     
     //fonction qui permet de consommer des médicaments à partir de l'écran d'accueil de l'interface en effectuant les requêtes nécessaires
     public void scanner_accueil(){
         
          String datamatrix= QRCode.getText();
          //System.out.println("chaine: " + datamatrix);
          
          String CIP_QR = get_CIP(datamatrix);
          //System.out.println(CIP_QR);
          String date=get_Date_Peremption(datamatrix);
          //System.out.println("date: "+date);
          
          int quantite = 0;
          String nomMedicament="";
          String CIP="";
          erreur="";

	try {
	/* Création de l'objet gérant les requêtes */
	Statement statement = connexion.createStatement();
	/* Exécution d'une requête de lecture */
        try{
	ResultSet resultat = statement.executeQuery( "SELECT CIP, Label, Quantite  FROM stock WHERE CIP=" + CIP_QR + ";" );
        
        
        while ( resultat.next() ) {
	CIP = resultat.getString( "CIP" );
	nomMedicament = resultat.getString( "Label" );
        quantite=resultat.getInt( "Quantite" );
        
         
	/* Traiter ici les valeurs récupérées. */
	//System.out.println("CIP : " + CIP + " | Nom : " + nomMedicament);
			}
         } catch(SQLException e){  
             erreur="QRCode invalide !";
         }
	/* Récupération des données du résultat de la requête de lecture */
        
	
                        
                        
        int nbr_gelules= Integer.parseInt(t1.getText());
        //System.out.println(nbr_gelules);
         Gelules_consomme= nbr_gelules;
              
        nbr_gelules= quantite-nbr_gelules;
        //System.out.println(nbr_gelules);
        
        Label_consomme= nomMedicament;

        if(nbr_gelules<0){
            erreur="Vous avez enlevé trop de gélules !";
            nbr_gelules=0;
        }
        
               
       // System.out.println("UPDATE stock SET Quantite ='"+ nbr_gelules+ "' WHERE CIP='" + CIP_QR + "' AND DatePeremption='"+ date + "';" );
        try{    
        int statut = statement.executeUpdate( "UPDATE stock SET Quantite ='"+ nbr_gelules+ "' WHERE CIP='" + CIP_QR + "' AND DatePeremption='"+ date + "';" );
         } catch(SQLException e){     
             erreur="QRCode invalide !";
         }  
            
        QRCode.setText("");
	} catch (SQLException e) {
		e.printStackTrace();
		}
          consommer_medicament();              
     }
     
     //Fonction qui permet de retirer un boite de médicaments de la base de données
     public void scanner_retirer(){
         
         // Code CIP
        String datamatrix= QRCode2.getText();
        //System.out.println("chaine: " + datamatrix);
        
       String CIP_QR = get_CIP(datamatrix);
       //System.out.println(CIP_QR);
       String date=get_Date_Peremption(datamatrix);
       //System.out.println("date: "+date);
        
        int quantite = 0;
        int nbr_boite=0;
        String nomMedicament = "";
        String CIP="";
        erreur="";

	try {
	/* Création de l'objet gérant les requêtes */
	Statement statement = connexion.createStatement();
	/* Exécution d'une requête de lecture */
        try{
	ResultSet resultat = statement.executeQuery( "SELECT CIP, Label, Quantite, NbrBoite  FROM stock WHERE CIP=" + CIP_QR + ";" );
        
        while ( resultat.next() ) {
	CIP = resultat.getString( "CIP" );
	nomMedicament = resultat.getString( "Label" );
        quantite=resultat.getInt( "Quantite" );
        nbr_boite=resultat.getInt( "NbrBoite" );
	/* Traiter ici les valeurs récupérées. */
	//System.out.println("CIP : " + CIP + " | Nom : " + nomMedicament + " | Quantite : "+ quantite + " | NbrBoite : "+ nbr_boite);
			}
        
	         } catch(SQLException e){ 
                     erreur="QRCode invalide !";
         }
        /* Récupération des données du résultat de la requête de lecture */

        //System.out.println(nbr_boite);                 
        nbr_boite--; 
        //System.out.println(nbr_boite);
        int nbr_gelules= Integer.parseInt(t12.getText());
        //System.out.println(nbr_gelules);
              
        nbr_gelules= quantite - nbr_gelules;
        
       //System.out.println("Nombres de gélules : "+nbr_gelules);   
        //System.out.println("Nombres de boites : "+nbr_boite);   
        
         if(nbr_boite<0 && nbr_gelules<0){
            erreur="Vous avez enlevé trop de gélules et de boîtes !"; 
            nbr_boite=0;
            nbr_gelules=0;
        }
         
        if(nbr_gelules<0){
            erreur="Vous avez enlevé trop de gélules !";
            nbr_gelules=0;
        }
        if(nbr_boite<0){
            erreur="Vous avez enlevé trop de boîtes !"; 
            nbr_boite=0;
        }
        
        
        //System.out.println(nbr_gelules);
         try{
             int statut = statement.executeUpdate( "UPDATE stock SET Quantite ="+ nbr_gelules+ ", NbrBoite ="+nbr_boite +" WHERE CIP='" + CIP_QR + "'AND DatePeremption='"+ date + "';" );
         } catch(SQLException e){    
             erreur="QRCode invalide !";
         }  
               
        QRCode2.setText("");
	} catch (SQLException e) {
		e.printStackTrace();
		}
        
        supprimer_medicament();
     }
    
     //fonction qui permet d'ajouter une boite de médicaments 
      public void scanner_ajouter(){
         
         // Code CIP
        String datamatrix= QRCode3.getText();
        // String CIP= "3400949497294";
        //System.out.println("QRCode: " + datamatrix);
        
        //Date péremption
       // String date= "01/09/2020";
        
        
       String CIP_QR = get_CIP(datamatrix);
       //System.out.println(CIP_QR);
       String date=get_Date_Peremption(datamatrix);
       //System.out.println(date);
        
        int nbr_gelules= Integer.parseInt(t123.getText()); 
        int quantite = 0;
        int nbr_boite=0;
        String nomMedicament = "";
  
	try {
    
	/* Création de l'objet gérant les requêtes */
	Statement statement = connexion.createStatement();
            
        String CIP_courant="";
        String date_courant="";
        boolean bool=false;
        
        try{
        ResultSet resultat_contenu = statement.executeQuery( "SELECT CIP,DatePeremption  FROM stock " + ";" );
        while (resultat_contenu.next() && bool==false ) {
            
	CIP_courant = resultat_contenu.getString( "CIP" );
        date_courant=resultat_contenu.getString( "DatePeremption" );
        
        //System.out.println("CIP courant"+CIP_courant);
        //System.out.println("CIP humex"+CIP_QR);
        //System.out.println("date courant"+date_courant);
        //System.out.println("date humex"+date);
        
        if((date.equals(date_courant)) && (CIP_courant.equals(CIP_QR))){
 
            bool=true; // Ce sont les mêmes

        }
        else bool=false;
	
   }
         } catch(SQLException e){  
             erreur="QRCode invalide !";
         }
	
        
        //System.out.println("BOOL: "+bool);
        
        // Le médicament exite déja dans la BDD => update la BDD
        if(bool==true){
            
         //System.out.println("merde");   
        /* Exécution d'une requête de lecture */
        try{
	ResultSet resultat = statement.executeQuery( "SELECT Label, Quantite, NbrBoite FROM stock WHERE CIP='" + CIP_QR + "'AND DatePeremption='"+ date +"';" );
	/* Récupération des données du résultat de la requête de lecture */
        while ( resultat.next() ) {
           
	nomMedicament = resultat.getString( "LABEL" );
        quantite=resultat.getInt( "Quantite" );
        nbr_boite=resultat.getInt( "NbrBoite" );
	/* Traiter ici les valeurs récupérées. */
	//System.out.println("CIP : " + CIP_QR + " | Label : " + nomMedicament + " | Quantite : "+ quantite + " | NbrBoite : "+ nbr_boite + " | DatePeremption : "+ date);
        }
         } catch(SQLException e){   
             //System.out.println("EXCEPTION SA MEEEEEEEERE");
             erreur="QRCode invalide !";
         }
	
                
        nbr_boite++; 
        nbr_gelules=nbr_gelules + quantite;  
        try{
        int statut = statement.executeUpdate( "UPDATE stock SET Quantite ="+ nbr_gelules+ ", NbrBoite ="+ nbr_boite +" WHERE Label='" + nomMedicament + "';" );
         } catch(SQLException e){   
             //System.out.println("EXCEPTION SA MEEEEEEEERE");
             erreur="QRCode invalide !";
         }  
            
        }
        String label="";
        String CIS="";
        String chaine="";
        // Le médicament n'existe pas deja dans la BDD => inser une nouvelle ligne
        if(bool==false){
            
            try{
            ResultSet res2 = statement.executeQuery( "SELECT CIS FROM cis_cip WHERE CIP='"+CIP_QR+"';" );
              while ( res2.next() ) {
             //System.out.println("SELECT CIS FROM cis_cip WHERE CIP="+CIP_QR+";"); 
             CIS = res2.getString("CIS");
            //System.out.println(CIS); 
            }
            } catch(SQLException e){  
                //System.out.println("EXCEPTION SA MEEEEEEEERE");
                erreur="QRCode invalide !";
         }
            
            try{
            ResultSet res = statement.executeQuery( "SELECT  Label FROM cis_label WHERE CIS="+CIS+";" );
              while ( res.next() ) {
            
            chaine=res.getString( "Label" );
            label=RetournerLabel(chaine);
            
            }
               } catch(SQLException e){  
                   //System.out.println("EXCEPTION SA MEEEEEEEERE");
                   erreur="QRCode invalide !";
         }
         
            //System.out.println(CIS);
            //System.out.println(CIP_QR);
            //System.out.println(label);
            //System.out.println(nbr_gelules);

            //System.out.println( "INSERT INTO stock VALUES ('"+CIP_QR+"',  '"+label+"', '"+CIS+"',  '"+nbr_gelules+"', '01/09/2020','1');");
            try{
            int statut2 = statement.executeUpdate( "INSERT INTO stock VALUES ('"+CIP_QR+"',  '"+label+"', '"+CIS+"',  '"+nbr_gelules+"',  '"+date+"','1');");             
             } catch(SQLException e){
                 //System.out.println("EXCEPTION SA MEEEEEEEERE");
                 erreur="QRCode invalide !";
         }  
            
            }
 
        QRCode3.setText("");
        bool=false;
        
	} catch (SQLException e) {
		e.printStackTrace();
		}
        
        ajouter_medicament();
     }
     
     //fonction qui permet de récupérer le code CIP d'un médicament à partir de son code QR
      public static String get_CIP(String QR_Code) {
		String CIP = "";
		for(int i = 0 ; i < 13 ; i++) {
			CIP += QR_Code.charAt(i+3);
		}
		return CIP;
	}
	
      //fonction qui permet de récupérer la date de péremption d'un médicament à partir de son code QR
	public static String get_Date_Peremption(String QR_Code) {
		String date = "";
		date += QR_Code.charAt(22);
		date += QR_Code.charAt(23);
		date += "/";
		date += QR_Code.charAt(20);
		date += QR_Code.charAt(21);
		date += "/20";
		date += QR_Code.charAt(18);
		date += QR_Code.charAt(19);
		return date; 
	}
        //fonction qui retourne un tableau rempli de avec la liste de médicaments en stock
        //cette fonction est appelée lorsque l'on souhait accéder à la liste des médicaments en stock
        public JTable scanner_inventaire_general(){
         
          int quantite = 0;
          String nomMedicament="";
          String peremption="";
          int nbrboite=0;
          
          Font Fok = new Font ("Arial",Font.PLAIN,25);
          
          /*
          *Mise en place du tableau d'affichage
          */
          MyTableModel model = new MyTableModel();
          model.addColumn("Label");
          model.addColumn("Quantité");
          model.addColumn("Date de péremption");
          model.addColumn("Nombre de boîtes");
          JTable tablegen = new JTable(model);

		try {
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			/* Exécution d'une requête de lecture */
			ResultSet resultat = statement.executeQuery( "SELECT Label, Quantite, DatePeremption, NbrBoite FROM stock;" );
			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() ) {
                            quantite = resultat.getInt("Quantite");
			    nomMedicament = resultat.getString("Label");
                            peremption = resultat.getString("DatePeremption");
                            nbrboite = resultat.getInt("NbrBoite");
                            Object[]data2 ={nomMedicament,quantite,peremption,nbrboite};
                            model.addRow(data2);
			}
                        
                     tablegen = new JTable(model);
                     tablegen.getTableHeader().setPreferredSize(new Dimension(tablegen.getTableHeader().getWidth(), 50));
                     tablegen.getTableHeader().setFont(Fok);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return(tablegen);       
     }
        //fonction qui retourne un tableau rempli de avec la liste de médicaments en faible quantité
        //cette fonction est appelée lorsque l'on souhait accéder à la liste des médicaments en faible quantité
        public JTable scanner_faible_quantite(){
         
          int quantite = 0;
          String nomMedicament="";
          String peremption="";
          int nbrboite=0;
          
          Font Fok = new Font ("Arial",Font.PLAIN,25);
          
          /*
          *Mise en place du tableau d'affichage
          */
          MyTableModel model = new MyTableModel();
          model.addColumn("Label");
          model.addColumn("Quantité");
          model.addColumn("Date de péremption");
          model.addColumn("Nombre de boîtes");
          JTable tablegen = new JTable(model);

		try {
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			/* Exécution d'une requête de lecture */
			ResultSet resultat = statement.executeQuery( "SELECT Label, Quantite, DatePeremption, NbrBoite FROM stock;" );
			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next()) {
                            if(resultat.getInt("Quantite")<=3){
                            quantite = resultat.getInt("Quantite");
			    nomMedicament = resultat.getString("Label");
                            peremption = resultat.getString("DatePeremption");
                            nbrboite = resultat.getInt("NbrBoite");
                            Object[]data2 ={nomMedicament,quantite,peremption,nbrboite};
                            model.addRow(data2);
                            }
			}
                        
                     tablegen = new JTable(model);
                     tablegen.getTableHeader().setPreferredSize(new Dimension(tablegen.getTableHeader().getWidth(), 50));
                     tablegen.getTableHeader().setFont(Fok);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return(tablegen);       
     }
        //fonction qui retourne un tableau rempli de avec la liste de médicaments périmés
        //cette fonction est appelée lorsque l'on souhait accéder à la liste des médicaments périmés
        public JTable scanner_peremption(){
         
          int quantite = 0;
          String nomMedicament="";
          String peremption="";
          int nbrboite=0;
          Date actuelle = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          String date = dateFormat.format(actuelle);
          int jourAct = Integer.parseInt(date.substring(0,2));
          int moisAct = Integer.parseInt(date.substring(3,5));
          int anneeAct = Integer.parseInt(date.substring(8,10));
          
          Font Fok = new Font ("Arial",Font.PLAIN,25);
          
          /*
          *Mise en place du tableau d'affichage
          */
          MyTableModel model = new MyTableModel();
          model.addColumn("Label");
          model.addColumn("Quantité");
          model.addColumn("Date de péremption");
          model.addColumn("Nombre de boîtes");
          JTable tablegen = new JTable(model);

		try {
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			/* Exécution d'une requête de lecture */
			ResultSet resultat = statement.executeQuery( "SELECT Label, Quantite, DatePeremption, NbrBoite FROM stock;" );
			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next()) {
                            
                            String jour = resultat.getString("DatePeremption").substring(0,2);
                            int journee = Integer.parseInt(jour);
                            String mois = resultat.getString("DatePeremption").substring(3,5);
                            int moisInt = Integer.parseInt(mois);
                            String annee = resultat.getString("DatePeremption").substring(8,10);
                            int anneeInt = Integer.parseInt(annee);
                            
                            
                            if((moisInt==moisAct)&&(anneeInt==anneeAct)){
                                
                                if((journee-jourAct)<=5){
                                    quantite = resultat.getInt("Quantite");
                                    nomMedicament = resultat.getString("Label");
                                    peremption = resultat.getString("DatePeremption");
                                    nbrboite = resultat.getInt("NbrBoite");
                                    Object[]data2 ={nomMedicament,quantite,peremption,nbrboite};
                                    model.addRow(data2);
                                }
                                
                            }
                            
                            else if((moisAct==(moisInt-1))&&(journee<=3)){
                                if(((journee+30)-jourAct)<5){
                                    quantite = resultat.getInt("Quantite");
                                    nomMedicament = resultat.getString("Label");
                                    peremption = resultat.getString("DatePeremption");
                                    nbrboite = resultat.getInt("NbrBoite");
                                    Object[]data2 ={nomMedicament,quantite,peremption,nbrboite};
                                    model.addRow(data2);
                                } 
                            }
                            
			}
                        
                     tablegen = new JTable(model);
                     tablegen.getTableHeader().setPreferredSize(new Dimension(tablegen.getTableHeader().getWidth(), 50));
                     tablegen.getTableHeader().setFont(Fok);
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return(tablegen);       
     }
        
        public class MyTableModel extends DefaultTableModel { @Override public boolean isCellEditable(int rowIndex, int columnIndex) { 
         return false;
    }
        }
        
        //Fonction qui affiche le menu de scan du sous-menu "notices
        public void notices(){
        P1.removeAll();
        P1.updateUI();            
            
            
        JPanel P5 = new JPanel();
        P5.setBackground(new Color(0xFFFFFF));     
        P5.setBorder(BorderFactory.createLineBorder(Color.black));  
        P5.setBounds(100,60,824,300);
        P5.setLayout(null);
        
        Font font3 = new Font ("Arial",Font.PLAIN,30);
      

            JLabel l4 = new JLabel("   Veuillez scanner le médicament pour consulter");
            l4.setBounds(20,20,820,30);
            l4.setFont(font3);
            JLabel l5 = new JLabel("            la notice");
            l5.setBounds(160,60,300,30);
            l5.setFont(font3);
            
            Font Fok = new Font ("Arial",Font.PLAIN,45);
            
            
            QRCode4 = new JTextField();
            QRCode4.setBackground(new Color(0xFFFFFF));
            QRCode4.setForeground(new Color(0xFFFFFF));
            QRCode4.setBounds(10,180,800,40);
            QRCode4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            QRCode4.setFocusable(true);
            QRCode4.addActionListener(this);
          
            P5.add(QRCode4);
            P5.add(l4);
            P5.add(l5);
            P1.add(P5);
            QRCode4.requestFocus();
      }
      
      //Fonction qui permet d'envoyer une requete récupérant la notice d'un médicament lorsque le code CIP
      //est entré via le scanner
      public void scanner_notice(){
            P1.removeAll();
            P1.updateUI();
            
            String CIP = get_CIP(QRCode4.getText());
            String label = "";
            String forme = "";
            String admin = "";
                               
            JPanel P4 = new JPanel();
            P4.setBackground(new Color(0xFFFFFF));     
            P4.setBorder(BorderFactory.createLineBorder(Color.black));  
            P4.setBounds(100,60,824,300);
            P4.setLayout(null);
         
            Font font3 = new Font ("Arial",Font.PLAIN,30);
        
            try {
			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();
			/* Exécution d'une requête de lecture */
                        try{
                        ResultSet resultat_CIS = statement.executeQuery("SELECT CIS FROM cis_cip WHERE CIP=" + CIP + ";");
                          if(resultat_CIS.next()){
                            //System.out.println("voie :" + resultat_CIS.getString("CIS"));
                            ResultSet resultat = statement.executeQuery( "SELECT Label, Forme, Voie FROM cis_label WHERE CIS=" + resultat_CIS.getString("CIS") + ";");
                            if(resultat.next()){
                                label = resultat.getString("Label");
                                forme = resultat.getString("Forme");
                                admin = resultat.getString("Voie");
                            }
                        }
            JLabel nom = new JLabel("Médicament : " + label );
            JLabel forme_ad = new JLabel("Forme d'administration : " + forme);
            JLabel voie = new JLabel("Voie d'administration : " + admin);
            nom.setBounds(40,20,820,40);
            nom.setFont(font3);
            forme_ad.setBounds(40,80,820,40);
            forme_ad.setFont(font3);
            voie.setBounds(40,140,820,40);
            voie.setFont(font3);
            
            Font Fok = new Font ("Arial",Font.PLAIN,45);
            okay = new JButton("Ok");
            okay.setBounds(330,200,150,90);
            okay.setBackground(new Color(0xFFFFFF));
            okay.addActionListener(this);
            okay.setBorderPainted(false);
            okay.setFont(Fok);

            P4.add(okay);
            P4.add(nom);
            P4.add(forme_ad);
            P4.add(voie);
                          
                        } catch(SQLException e){    
             erreur="QRCode invalide !";
             JLabel err = new JLabel(erreur);
             err.setBounds(280,90,820,40);
             err.setFont(font3);
             P4.add(err);
             
             Font Fok = new Font ("Arial",Font.PLAIN,45);
            okay = new JButton("Ok");
            okay.setBounds(330,200,150,90);
            okay.setBackground(new Color(0xFFFFFF));
            okay.addActionListener(this);
            okay.setBorderPainted(false);
            okay.setFont(Fok);

            P4.add(okay);
         } 
	
                    
                        
		} catch (SQLException e) {
			e.printStackTrace();
		}
            
           
            P1.add(P4);
            
      }
      
      ///Fonction permettant de retirer les parties inutiles des noms des médicaments
      public String RetournerLabel(String chaine)
      {
       int i=0;
       String chaine_recup="";
       boolean bool=false;
       
      
       do{
            if(chaine.charAt(i)==' ' || chaine.charAt(i)==',')
           {
               bool=true;
           }
           i++;
           
           
       } while(bool==false);
       for(int j=0; j<i-1;j++)
       {
           chaine_recup=chaine_recup+chaine.charAt(j);
       }
       return chaine_recup;
       
      }
        

    
}