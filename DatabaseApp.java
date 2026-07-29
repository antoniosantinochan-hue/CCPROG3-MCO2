import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class DatabaseApp extends JFrame{
    private JTextField searchField;
    private JTextArea displayArea;

    public DatabaseApp(){
        setTitle("One Piece Database");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        createMenuBar();

        createMainInterface();
    }

    private void createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu systemMenu = new JMenu("System");
        JMenu viewMenu = new JMenu("View");

        JMenuItem exitItem = new JMenuItem("Exit System");

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        systemMenu.add(exitItem);
        menuBar.add(systemMenu);
        menuBar.add(viewMenu);
    }

    private void createMainInterface(){
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        JLabel searchLabel = new JLabel("Item / Person");
        searchField = new JTextField(20);
        JButton searchBtn = new JButton("Search Databank");

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        displayArea.setText("Welcome to the One Piece Database\n" +
                "Enter a query above to retrieve data");

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText().toLowerCase();

                if (query.equalsIgnoreCase("Geo")){
                    displayArea.setText("Geo LOL");
                }
            }
        });

        add(searchPanel, BorderLayout.NORTH);
        add(searchPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DatabaseApp app = new DatabaseApp();
                app.setVisible(true);
            }
        });


    }
}
