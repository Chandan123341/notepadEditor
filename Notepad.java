import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import javax.swing.ImageIcon;
import java.net.URL;

class Notepad
{
  public static void main(String[] args){
    Note note=new Note();
  }
}

class Note extends JFrame implements ActionListener
{

   JMenuBar menubar;

   JTextArea jarea;

   JScrollPane jpane;

  JMenu menu1,menu2,menu3,menu4,menu5;

  JMenuItem new1,open,newWindow,save,saveAs,exit,cut,copy,paste,selectAll,print,aboutNotepad,wordWrap;

  JMenu font,fontSize;

   JMenuItem zoomin,zoomout;

  JMenuItem v1,v2,v3,v4,v5,v6;

  JMenuItem fontArial,fontDevnagri,fontAlgebrian,fontArialRound;
 
  boolean WordWrap=false;

  String text="";
  int style=0;
   int currentFontSize=20;

  private  ImageIcon image1;
  private JLabel l1;

  public Note(){
   setSize(600,500);
   setLocation(100,200);
   setVisible(true);
   setTitle("Untitled Notepad");
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   menubar=new JMenuBar();
   menu1=new JMenu("File");
   menu2=new JMenu("Edit");
   menu3=new JMenu("Help");
   menu4=new JMenu("Format");
   menu5=new JMenu("View");

    new1=new JMenuItem("New");
    new1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_N,ActionEvent .CTRL_MASK));
    new1.addActionListener(this);

    open=new JMenuItem("Open");
    open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_O,ActionEvent .CTRL_MASK));
    open.addActionListener(this);

    newWindow=new JMenuItem("New Window");
    newWindow.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_W,ActionEvent .CTRL_MASK));
    newWindow.addActionListener(this);

    save=new JMenuItem("Save");
    save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_S,ActionEvent .CTRL_MASK));
    save.addActionListener(this);

    saveAs=new JMenuItem("Save As");
    saveAs.addActionListener(this);

    print=new JMenuItem("Print");
    print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_P,ActionEvent .CTRL_MASK));
    print.addActionListener(this);

    exit=new JMenuItem("Exit");
    exit.addActionListener(this);

    cut=new JMenuItem("Cut");
    cut.addActionListener(this);
    cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_X,ActionEvent .CTRL_MASK));

    copy=new JMenuItem("Copy");
    copy.addActionListener(this);
    copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_C,ActionEvent .CTRL_MASK));

    paste=new JMenuItem("Paste");
    paste.addActionListener(this);
    paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_V,ActionEvent .CTRL_MASK));

    selectAll=new JMenuItem("Select All");
    selectAll.addActionListener(this);
    selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent .VK_A,ActionEvent .CTRL_MASK));

   aboutNotepad=new JMenuItem("About Notepad");
   aboutNotepad.addActionListener(this);
   aboutNotepad.setActionCommand("aboutNotepad");

   jarea=new JTextArea();
   jarea.setFont(new Font("SAN_SARIF",Font.PLAIN,currentFontSize));
   jpane=new JScrollPane(jarea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  add(jpane,BorderLayout.CENTER);

   wordWrap=new JMenuItem("word wrap: OFF");
   wordWrap.addActionListener(this);
    wordWrap.setActionCommand("wrap");

    fontArial=new JMenuItem("ARIAL");
    fontArial.setActionCommand("arial");
    fontDevnagri=new JMenuItem("ADOBE DEVNAGRI");
    fontDevnagri.setActionCommand("devnagri");
    fontAlgebrian=new JMenuItem("ALGERIAN");
    fontAlgebrian.setActionCommand("algebrian");
    fontArialRound=new JMenuItem("ARIAL ROUND MT");
     fontArialRound.setActionCommand("arialround");

   font =new JMenu("Font");
   font.add(fontArial);
   font.add(fontDevnagri);
   font.add(fontAlgebrian);
  font.add(fontArialRound);

   fontArial.addActionListener(this);
   fontDevnagri.addActionListener(this);
   fontAlgebrian.addActionListener(this);
   fontArialRound.addActionListener(this);

   v1=new JMenuItem("10");
   v2=new JMenuItem("12");
   v3=new JMenuItem("14");
   v4=new JMenuItem("16");
   v5=new JMenuItem("18");
   v6=new JMenuItem("20");

   fontSize=new JMenu("Font Size");
   fontSize.add(v1);
   fontSize.add(v2);
   fontSize.add(v3);
   fontSize.add(v4);
  fontSize.add(v5);
  fontSize.add(v6);
  
  v1.addActionListener(this);
  v2.addActionListener(this);
  v3.addActionListener(this);
  v4.addActionListener(this);
  v5.addActionListener(this);
  v6.addActionListener(this);

   zoomin=new JMenuItem("ZOOM IN");
   zoomin.addActionListener(this);
   zoomout=new JMenuItem("ZOOM OUT");
   zoomout.addActionListener(this);

   menu5.add(zoomin);
   menu5.add(zoomout);
   
   menu4.add(wordWrap);
   menu4.add(font);
   menu4.add(fontSize);

    menubar.add(menu1);
    menubar.add(menu2);
    menubar.add(menu3);
    menubar.add(menu4);
    menubar.add(menu5);

    menu1.add(new1);
    menu1.add(open);
     menu1.add(newWindow);
    menu1.add(save);
    menu1.add(saveAs);
    menu1.add(print);
    menu1.add(exit);

    menu2.add(cut);
     menu2.add(copy);
     menu2.add(paste);
     menu2.add(selectAll);

     menu3.add(aboutNotepad);
    setJMenuBar(menubar);
  }

  public void actionPerformed(ActionEvent ae){
     if(ae.getActionCommand().equals("New")){
        jarea.setText("");
        setTitle("New");
     }

      if(ae.getActionCommand().equals("Open")){
         JFileChooser choose=new JFileChooser();
         choose.setAcceptAllFileFilterUsed(false);
         FileNameExtensionFilter fne=new FileNameExtensionFilter(".txt","txt"); 
         choose.addChoosableFileFilter(fne);
            int ac=choose.showOpenDialog(this);
         if(ac!=JFileChooser.APPROVE_OPTION){
             return;
         }
        File file=choose.getSelectedFile();
         try{
              BufferedReader b=new BufferedReader(new FileReader(file));
             jarea.read(b,null);
             }catch(Exception e){}
     }

     if(ae.getActionCommand().equals("New Window")){
       new Note();
     }

     if(ae.getActionCommand().equals("Save")){
         JFileChooser fc=new JFileChooser();
         fc.setApproveButtonText("Save");
         int ac=fc.showOpenDialog(this);
         if(ac!=JFileChooser.APPROVE_OPTION){
             return;
         }
        File filename=new File(fc.getSelectedFile()+".txt");
        BufferedWriter bf=null;
        try{
             bf=new BufferedWriter(new FileWriter(filename));
             jarea.write(bf);
         }catch(Exception e){}
     }

      if(ae.getActionCommand().equals("Print")){
        try{
            jarea.print();}
         catch(Exception e){}
      }

    if(ae.getActionCommand().equals("Save As")){
       
     }

    if(ae.getActionCommand().equals("Exit")){
       System.exit(0);}

    if(ae.getActionCommand().equals("Copy")){
         text=jarea.getSelectedText(); 
    }

    if(ae.getActionCommand().equals("Paste")){
       jarea.insert(text,jarea.getCaretPosition());
   }

    if(ae.getActionCommand().equals("Cut")){
     text=jarea.getSelectedText();
     jarea.replaceRange("",jarea.getSelectionStart(),jarea.getSelectionEnd());
    }

   if(ae.getActionCommand().equals("Select All")){
      jarea.selectAll();
    }

   if(ae.getActionCommand().equals("aboutNotepad")){
      // image1=new ImageIcon(ClassLoader.getSystemResource("C:/Users/chand/NotepadProject/icon/image.png"));
       l1=new JLabel( "<html><body>  <h1>ABOUT NOTEPAD</h1> <p>Windows 10 is a series of operating systems developed by Microsoft and released <br>as part of its Windows NT family of operating systems. It is the successor to Windows                                                                                                   8.1,<br>released nearly two years earlier, and was released to manufacturing on July 15, 2015, <br>and broadly released for the general public on July 29,2015</p></body></html>");
       add(l1);
     JOptionPane.showMessageDialog(this,l1);
   }
   if(ae.getActionCommand().equals("wrap")){
      if(WordWrap==false){
           WordWrap=true;
            jarea.setLineWrap(true);
           jarea.setWrapStyleWord(true);
           wordWrap.setText("word wrap:ON");
       }
      else{
           WordWrap=false;
           jarea.setLineWrap(false);
           jarea.setWrapStyleWord(false);
           wordWrap.setText("word wrap:OFF");
        }
    }
    if(ae.getActionCommand().equals("arial")){
       text="ARIAL";
       style=Font.BOLD;
       jarea.setFont(new Font("ARIAL",Font.BOLD,20));
        currentFontSize=20;
     }
      if(ae.getActionCommand().equals("devnagri")){
         text="ARIAL";
       style=Font.BOLD;
         jarea.setFont(new Font("ADOBE DEVANAGARI",Font.BOLD,25));
         currentFontSize=25;
     }
     if(ae.getActionCommand().equals("algebrian")){
          text="ALGERIAN";
           style=Font.BOLD;
          jarea.setFont(new Font("ALGERIAN",Font.BOLD,28));
           currentFontSize=28;
     }
     if(ae.getActionCommand().equals("arialround")){
         text="ARIAL ROUND MT";
       style=Font.BOLD;
         jarea.setFont(new Font("ARIAL ROUNDED MT",Font.BOLD,24));
          currentFontSize=24;
     }
     if(ae.getSource()==v1){
         jarea.setFont(new Font(text,style,10));
         currentFontSize=10;
      }
      if(ae.getSource()==v2){
         jarea.setFont(new Font(text,style,12));
         currentFontSize=12;
     }
      if(ae.getSource()==v3){
         jarea.setFont(new Font(text,style,14));
         currentFontSize=14;
     }
     if(ae.getSource()==v4){
         jarea.setFont(new Font(text,style,16));
         currentFontSize=16;
     }
     if(ae.getSource()==v5){
         jarea.setFont(new Font(text,style,18));
         currentFontSize=18;
     }
     if(ae.getSource()==v6){
         jarea.setFont(new Font(text,style,20));
         currentFontSize=20;
     }
    if(ae.getActionCommand().equals("ZOOM IN")){
            jarea.setFont(new Font(text,style,currentFontSize));
     }
      if(ae.getActionCommand().equals("ZOOM OUT")){
            jarea.setFont(new Font(text,style,currentFontSize*2));
      }
  }
}
