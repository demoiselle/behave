package demoisellebehave.serpro.treino;

import demoisellebehave.serpro.treino.ui.JFrameLogin;

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
