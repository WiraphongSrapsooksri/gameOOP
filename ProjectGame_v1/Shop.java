import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shop extends JFrame {
    Shop(){
        setSize(700 ,500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel LogonameShop = new JPanel();
        JLabel label = new JLabel("SHOP ITEM");
        label.setFont(new Font("Serif", Font.PLAIN, 24));
        LogonameShop.add(label,SwingConstants.CENTER);
        add(LogonameShop,BorderLayout.NORTH);

        MyGraphics_v1 g1 = new MyGraphics_v1(this,1500);

    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.setVisible(true);
    }
}
class MyGraphics_v1 extends JPanel implements KeyListener {
    Shop frameshop;
    JToggleButton[] item = new JToggleButton[6];
    JTextField textField = new JTextField();
    JTextArea textdatill = new JTextArea();
    ButtonGroup buttonGroup = new ButtonGroup();
    int price[] = new int[6];
    int property;
    int indexButton;
    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("ICON1.JPG"));
    JButton buttonbuy = new JButton("BUY");
    boolean isSelected= false;
    MyGraphics_v1(Shop F,int property){
        this.property = property;
        this.frameshop = F;
        setSize(700,450);
        setLayout(new BorderLayout());
        setBackground(new Color(135, 134, 134));

        JPanel paneldeitll = new JPanel(new BorderLayout());
        JPanel PtextF = new JPanel();
        JPanel Pitem = new JPanel(new GridLayout(item.length,0));

        textField.setText(""+this.property);
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(250,40));
        textField.setFont(new Font("Serif", Font.PLAIN, 20));
        PtextF.add(textField);
        PtextF.setPreferredSize(new Dimension(250,40));
        PtextF.setBackground(new Color(42, 239, 239, 158));


        paneldeitll.setPreferredSize(new Dimension(700,100));
        paneldeitll.setBackground(new Color(126, 245, 127, 202));
        textdatill.setPreferredSize(new Dimension(400,60));
        paneldeitll.add(buttonbuy,BorderLayout.EAST);
        paneldeitll.add(textdatill,BorderLayout.CENTER);


        Pitem.setPreferredSize(new Dimension(400,400));


        price[0]=100;
        price[1]=200;
        price[2]=500;
        price[3]=50;
        price[4]=20;
        price[5]=1000;

        String ss ="                                                             ";
        item[0] = new JToggleButton(0+" Button"+ss+" "+price[0]+"\t   Bath",icon);
        item[1] = new JToggleButton(1+" Button"+ss+" "+price[1]+"\t   Bath",icon);
        item[2] = new JToggleButton(2+" Button"+ss+" "+price[2]+"\t   Bath",icon);
        item[3] = new JToggleButton(3+" Button"+ss+" "+price[3]+"\t   Bath",icon);
        item[4] = new JToggleButton(4+" Button"+ss+" "+price[4]+"\t   Bath",icon);
        item[5] = new JToggleButton(5+" Button"+ss+" "+price[5]+"\t   Bath",icon);


        item[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textdatill.setText("ITEM "+0+"AAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAAAAA\n0000000000000000000");
                indexButton = 0;
                System.out.println("isSelected: "+item[0].isSelected());
                isSelected = item[0].isSelected();
            }
        });
        item[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textdatill.setText("ITEM "+1+"BBBBBBBBBBBBBBBBB\nBBBBBBBBBBBBBBBBBBBBB\n11111111111111111");
                indexButton = 1;
                System.out.println("isSelected: "+item[1].isSelected());
                isSelected = item[1].isSelected();
            }
        });
        item[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textdatill.setText("ITEM "+2+"CCCCCCCCCCCCCCC\nCCCCCCCCCCCCCCCCCC\n2222222222222222222");
                indexButton=2;
                System.out.println("isSelected: "+item[2].isSelected());
                isSelected = item[2].isSelected();
            }
        });
        item[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textdatill.setText("ITEM "+3+"DDDDDDDDDDDDDD\nDDDDDDDDDDDDDDDDDDD\n3333333333333333333");
                indexButton=3;
                System.out.println("isSelected: "+item[3].isSelected());
                isSelected = item[3].isSelected();
            }
        });
        item[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textdatill.setText("ITEM "+4+"EEEEEEEEEEEEEEEEE\nEEEEEEEEEEEEEEEEEEE\n4444444444444444");
                indexButton=4;
                System.out.println("isSelected: "+item[4].isSelected());
                isSelected = item[4].isSelected();
            }
        });
        item[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textdatill.setText("ITEM "+5+"FFFFFFFFFFFFFFFF\nFFFFFFFFFFFFFFFFFFF\n555555555555555555");
                indexButton=5;
                System.out.println("isSelected: "+item[5].isSelected());
                isSelected = item[5].isSelected();
            }
        });

        buttonbuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (Integer.parseInt(textField.getText())<=0){
                        buttonbuy.setVisible(false);
                        for (int i = 0; i < price.length; i++) {
                            item[i].setVisible(false);
                        }
                        setErrorFrame("Unable to purchase items");
                    }
                    for (int i = 0; i < item.length; i++) {
                        if (Integer.parseInt(textField.getText())>=price[i]){
                            item[i].setVisible(true);
                        }
                        else{
                            item[i].setVisible(false);
                        }
                    }


                    if (isSelected){
                        int x = Integer.parseInt(textField.getText());
                        if (x>=0){
                            int Ans = x - price[indexButton];
                            if (Ans>=0){
                                textField.setText(Ans+"");
                            }
                            else{
                                setErrorFrame("Unable to purchase items");
                            }
                            for (int i = 0; i < item.length; i++) {
                                if (Integer.parseInt(textField.getText())>=price[i]){
                                    item[i].setVisible(true);
                                    Pitem.add(item[i]);
                                }
                                else{
                                    item[i].setVisible(false);
                                }
                            }
                        }
                    }else{
                        setErrorFrame("Please select an item");
                    }

                    System.out.println("isSelected: "+buttonbuy.isSelected());
                    System.out.println("indexButton: "+indexButton);
                    System.out.println(item[indexButton].getText());
                    System.out.println("Price: "+price[indexButton]);

                }catch (Exception E){
                    System.out.println("Error Buttonbuy");
                }
            }
        });


        for (int i = 0; i < item.length; i++) {
            item[i].setRolloverIcon(icon);
            Pitem.add(item[i]);
            buttonGroup.add(item[i]);
        }

        textField.addKeyListener(this);
        add(PtextF,BorderLayout.WEST);
        add(Pitem,BorderLayout.EAST);
        add(paneldeitll,BorderLayout.SOUTH);

        frameshop.add(this,BorderLayout.CENTER);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            int x = Integer.parseInt(textField.getText());
            System.out.println("Put: "+x);
            for (int i = 0; i < price.length; i++) {
                if (x>=price[i]){
                    item[i].setVisible(true);
                }
                else{
                    item[i].setVisible(false);
                }
            }
        }catch (Exception E){}
    }
    void setErrorFrame(String string){
        JFrame F = new JFrame();
        F.setSize(300 ,100);
        JPanel p = new JPanel(new BorderLayout());
        JLabel l = new JLabel(string,SwingConstants.CENTER);
        F.add(p.add(l));
        F.setLocationRelativeTo(null);
        F.setVisible(true);
    }
}