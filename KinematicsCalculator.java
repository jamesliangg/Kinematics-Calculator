import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KinematicsCalculator {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Kinematics Calculator", "Calculator", JOptionPane.INFORMATION_MESSAGE);

        JTextField viField = new JTextField(5);
        JTextField vfField = new JTextField(5);
        JTextField aField = new JTextField(5);
        JTextField tField = new JTextField(5);
        JTextField dField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("vi:"));
        myPanel.add(viField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("vf:"));
        myPanel.add(vfField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("a:"));
        myPanel.add(aField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Δt:"));
        myPanel.add(tField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Δd:"));
        myPanel.add(dField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Given Values (0 is unknown)", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
        double vi = Double.parseDouble(viField.getText());
        double vf = Double.parseDouble(vfField.getText());
        double a = Double.parseDouble(aField.getText());
        double t = Double.parseDouble(tField.getText());
        double d = Double.parseDouble(dField.getText());
        if (d == 0)
        {
            if (vf == 0)
            {
                System.out.println("Calculate vf & d");
                vf = vi + a*t;
                d = vi*t + 0.5*a*Math.pow(t,2);
                System.out.println(vf + " " + d);
            }
            if (vi == 0)
            {
                System.out.println("Calculate vi & d");
                vi = vf - a*t;
                d = vf*t - 0.5*a*Math.pow(t,2);
                System.out.println(vi + " " + d);
            }
            if (a == 0)
            {
                System.out.println("Calculate a & d");
                a = (vf-vi)/t;
                d = (vi+vf)/2*t;
                System.out.println(a + " " + d);
            }
            if (t == 0)
            {
                System.out.println("Calculate t & d");
                t = (vf-vi)/a;
                d = ((Math.pow(vf,2)-Math.pow(vi,2))/2)/a;
                System.out.println(t + " " + d);
            }
        }
        if (vf == 0)
        {
            if (vi == 0)
            {
                System.out.println("Calculate vi & vf");
                vi = (d-0.5*a*Math.pow(t,2))/t;
                vf = (d+0.5*a*Math.pow(t,2))/t;
                System.out.println(vi + " " + vf);
            }
            if (a == 0)
            {
                System.out.println("Calculate a & vf");
                a = ((d-vi*t)/0.5)/Math.pow(t,2);
                vf = Math.sqrt(Math.pow(vi,2)+2*a*d);
                System.out.println(a + " " + vf);
            }
            if (t == 0)
            {
                System.out.println("Calculate t & vf");
                vf = Math.sqrt((Math.pow(vi,2)+2*a*d));
                t = (vf-vi)/a;
                System.out.println(t + " " + vf);
            }
        }
        if (vi == 0)
        {
            if (a == 0)
            {
                System.out.println("Calculate a & vi");
                a = ((d-vf*t)/-0.5)/Math.pow(t,2);
                vi = (d*2-t*vf)/t;
                System.out.println(a + " " + vi);
            }
            if (t == 0)
            {
                System.out.println("Calculate t & vi");
                vi = Math.sqrt((Math.pow(vf,2)-2*a*d));
                t = (vf-vi)/a;
                System.out.println(t + " " + vi);
            }
        }
        if (a == 0)
        {
            if (t == 0)
            {
                System.out.println("Calculate t & a");
                t = (d*2)/(vi+vf);
                a = ((Math.pow(vf,2)-Math.pow(vi,2))/2)/d;
                System.out.println(t + " " + a);
            }
        }
        }
    }
}
