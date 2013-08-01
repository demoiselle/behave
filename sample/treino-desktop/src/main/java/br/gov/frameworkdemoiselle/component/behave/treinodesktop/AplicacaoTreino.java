package br.gov.frameworkdemoiselle.component.behave.treinodesktop;

/**
 * Hello world!
 *
 */
public class AplicacaoTreino 
{
    public static void main( String[] args )
    {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new JFrameLogin().setVisible(true);
            }
        });
    }
}
