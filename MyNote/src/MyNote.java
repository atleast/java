/**
 * 
 * @author atleast
 * @purpose create a note
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;

import java.io.*;

public class MyNote extends JFrame implements ActionListener{

    /**
     * 
     */
    private static final long serialVersionUID = 1191476679407705262L;
    /**
     * @param args
     */
    //定义成员变量
    private JTextArea jTextArea = null;
    private JMenuBar jMenuBar = null;
    private JMenu menuFile = null;
    private JMenuItem menuItemOpen = null;
    private JMenuItem menuItemSave = null;
    private JMenuItem menuItemExit = null;
    
    
    public static void main( String[] args ) {
        
        @SuppressWarnings ( "unused" )
        MyNote myNote = new MyNote();
        
    }
    
    //构造函数，初始化成员变量
    public MyNote(){
        
        jTextArea = new JTextArea();
        jTextArea.setLineWrap(true);
        this.add( jTextArea );
        
        jMenuBar = new JMenuBar();
        this.add( jMenuBar, BorderLayout.NORTH );
        
        menuFile = new JMenu();
        jMenuBar.add( menuFile );
        menuFile.setText( "File" );
        
        menuItemOpen = new JMenuItem();
        menuFile.add( menuItemOpen );
        menuItemOpen.setText( "Open" );
        
        //注册监听File->Open
        menuItemOpen.setActionCommand( "open" );
        menuItemOpen.addActionListener( this );
        
        menuItemSave = new JMenuItem();
        menuFile.add( menuItemSave );
        menuItemSave.setText( "Save" );
        //注册监听File->Save
        menuItemSave.setActionCommand( "save" );
        menuItemSave.addActionListener( this );
        
        menuItemExit = new JMenuItem();
        menuItemExit.setText( "Exit" );
        menuFile.add( menuItemExit );
        //注册监听File->Exit
        menuItemExit.setActionCommand( "exit" );
        menuItemExit.addActionListener( this );
        
        //设置窗体属性
        //窗体大小
        this.setSize( 500, 400 );
        //窗体是否可以变化
        this.setResizable(false);
        this.setTitle("My Note");
        this.setLocation( 200, 200 );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        
        //监听File->Open功能
        if(e.getActionCommand().equals( "open" )){
            //打开文件夹选择文件
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle( "Please select a file to open..." );
            fileChooser.showOpenDialog( null );
            
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            //定义文件输入流读取文件内容
            FileReader fr = null;
            BufferedReader br = null;
            
            try {
                fr = new FileReader(filePath);
                br = new BufferedReader( fr );
                
                //从文件中读取内容
                
                String str = "";
                String totalString = "";
                while((str = br.readLine())!= null){
                    
                    totalString += str + "\r\n";
                }
                
                //将读取的内容显示到JTextArea
                jTextArea.setText( totalString );
                
            }
            catch ( IOException e1 ) {
                e1.printStackTrace();
            }
            finally{
                try {
                    br.close();
                    fr.close();
                }
                catch ( IOException e1 ) {
                    e1.printStackTrace();
                }
            }
            
        }
        
        //监听File->Save
        if(e.getActionCommand().equals( "save" )){
            //打开文件夹选择位置
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle( "Please select a folder..." );
            fileChooser.showSaveDialog( null );
            
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            //定义文件输出流写入文件内容
            FileWriter fw = null;
            BufferedWriter bw = null;
            
            try {
                fw = new FileWriter(filePath);
                bw = new BufferedWriter(fw);
                
                //将文件内容写入文件
                bw.write(this.jTextArea.getText());
            }
            catch ( IOException e1 ) {
                e1.printStackTrace();
            }
            finally{
                try {
                    bw.close();
                    fw.close();
                }
                catch ( IOException e1 ) {
                    e1.printStackTrace();
                }
            }
        }
        
        //监听File->Exit
        if(e.getActionCommand().equals( "exit" )){
            System.exit(0);
        }
        
    }

}
