package chapter18; // window listeners as inner classes

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sub1 extends JFrame {

    public static void main(String[] args) {
        Sub1 window =   new Sub1();
        window.setVisible(true);
    }
    /*
     * Let's start with main() method and then let's explain things in the right
     * order when it's easier to understand.
     */

    public Sub1() {
        super("winder listener as inner class");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new CloseWindowListener());
        setLayout(new FlowLayout());

        add(new JButton("nothing"));
        add(new JLabel("Hello. This is main JFrame. Try to close the window."));
        add(new JButton("nothing"));
        pack();

        /*
         * New thing here is addWindowListener(). This method adds a listener to the
         * window. How is WindowListener different from ActionListener? The latter one
         * is activated when pressing a button (including menu item), the former one
         * activated by what is happening with window (frame). This listeners listens
         * when frame is closed, opened, maximised, minimised etc. Same as
         * ActionListener, WindowsListener is a WindowListener when it implements a
         * proper interface. Later is more explained about that interface.
         *
         * Note that you MUST invoke method setDefaultCloseOperation(). Otherwise the
         * default operation will be hiding the window, which is usually not what we
         * need. If you want to make your own close operation, like for example,
         * confirmation dialog, you usually set DO_NOTHING_ON_CLOSE.
         */

    }

    private class CloseWindowListener implements WindowListener {
        /*
         * WindowListener is an interface that has 7 method headings. You need to define
         * all 7 of them, but you can keep their body empty if you don't want to
         * sensibly define all of them. Sometimes you do not want to event take place
         * when a frame is minimised.
         */

        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("test");
            ConfirmCloseWindow windowConfirm = new ConfirmCloseWindow();
            windowConfirm.setVisible(true);
        }
        /*
         * windowClosing is when you press X button to close a frame. In here when we
         * press X button new Windows is opened and set to visible. Let's have a look at
         * ConfirmCloseWindow class to see what this windows is.
         */

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    }

    private class ConfirmCloseWindow extends JFrame implements ActionListener {
        /*
		 * This is the second window that appears when pressing X button. Note that as
		 * expected, this class extends JFrame and implements ActionListener. This is
		 * because this windows will create buttons which one of them will close the
		 * program.
		 *
		 * As you may wonder, there are alternative solutions. This is inner class. This
		 * class implements ActionListener because this class will also be a listener.
		 * In previous examples you remember that you can have a new class that is only
		 * a listener. And, an inner class to be ActionListener. This would be an inner
		 * class of an inner class. The ActionListener would be doubly nested. This is a
		 * solution, but that could make code less readable.
		 */

        public ConfirmCloseWindow() {
            super("Save");
            setSize(250, 125);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            /*
             * Here we set default operation to be dispose on close. Why? This is just a
             * windows asking if we are sure to close the program. We have 2 buttons, yes to
             * close the program and no to close the window. Pressing no and X button here
             * does the same thing. Of course you could have set Do nothing on close, but
             * then X would be useless.
             */

            setLayout(new GridLayout(0, 1));
            JPanel panel1 = new JPanel();
            panel1.setLayout(new FlowLayout());
            panel1.add(new JLabel("Are you sure you want to exit?"));
            add(panel1);
            JButton closeProgram = new JButton("Yes");
            JButton closeWindow = new JButton("No");
            closeProgram.addActionListener(this);
            closeWindow.addActionListener(this);
            JPanel panel2 = new JPanel();
            panel2.setLayout(new FlowLayout());
            panel2.add(closeProgram);
            panel2.add(closeWindow);
            add(panel2);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String word = e.getActionCommand();
            if (word.equals("Yes"))
                System.exit(0);
            else if (word.equals("No"))
                dispose();
            else {
                System.out.println("Error. No such button.");
            }
            /*
             * As already said, this method is part of inner class. But this method could
             * have been a part of another inner class. An inner class inside another inner
             * class.
             */
        }
    }

}
