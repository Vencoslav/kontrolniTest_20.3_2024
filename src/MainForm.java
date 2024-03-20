import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JButton predchoziButton;
    private JButton pridejButton;
    private JButton dalsiButton;
    private JTextField textField1;
    private List<String> seznam = new ArrayList<>();
    private int akutualiniIndex = 0;

    public MainForm(){
        setContentPane(panelMain);
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Listování soubory");


        String vstupA = "K:\\simunek\\2b_sk1\\Dolezal_Vaclav\\ktDolezal\\src\\vstupA";
        String vstupB = "K:\\simunek\\2b_sk1\\Dolezal_Vaclav\\ktDolezal\\src\\vstupB";
        String vstupC = "K:\\simunek\\2b_sk1\\Dolezal_Vaclav\\ktDolezal\\src\\vstupC";

        seznam = new ArrayList<>();
        seznam.add(vstupA);
        seznam.add(vstupB);
        seznam.add(vstupC);

        predchoziButton.addActionListener(e -> {
            if(akutualiniIndex > 0){
                akutualiniIndex--;
                vlozSoubor();
            }
        });

        dalsiButton.addActionListener(e -> {
            if(akutualiniIndex < seznam.size() - 1){
                akutualiniIndex++;
                vlozSoubor();
            }
        });

        pridejButton.addActionListener(e -> {
            pridejSoubor();
//            textField1.setText(selectedFile);
        });

        vlozSoubor();
    }
    public void vlozSoubor(){
        String aktualniSoubor = seznam.get(akutualiniIndex);
        textField1.setText(aktualniSoubor);
    }
    public void pridejSoubor(){
        JFileChooser fc = new JFileChooser(".");
        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fc.getSelectedFile();
        }
//        seznam.add(selectedFile);
    }
}
