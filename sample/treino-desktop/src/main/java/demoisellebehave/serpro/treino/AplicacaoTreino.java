package demoisellebehave.serpro.treino;

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
