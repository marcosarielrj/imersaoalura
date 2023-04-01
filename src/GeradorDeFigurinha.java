
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinha {

    public void criar(InputStream inputStream, String nomeArquivo ) throws Exception{

        // leitura da imagem

        //InputStream inputStream = new FileInputStream(new File("imagens/1.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_Ratio0.6716_AL_.jpg").openStream();
        BufferedImage imgOrigin = ImageIO.read(inputStream);


        // cria nova imagem em memória com transparência e com tamanho novo

        int largura = imgOrigin.getWidth();
        int altura = imgOrigin.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImg = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);


        // copiar a imagem original pra nova imagem em memória

        Graphics2D graphics = (Graphics2D) novaImg.getGraphics();
        graphics.drawImage(imgOrigin, 0, 0, null);


        // configurar a font
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 130);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);
        // escrever uma frase na nova imagem

        graphics.drawString("MoFaia", largura / 4, novaAltura - 75);

        // escrever a nova imagem em um arquivo

        ImageIO.write(novaImg, "png", new File("figurinha/" + nomeArquivo));

    }
    
}
