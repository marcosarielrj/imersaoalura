import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
        //String url = "https://api.nasa.gov/planetary/apod?api_key=hmaiRz0GBftu2y4v5TihPUyw5zWNRecVNawWHj5G&start_date=2023-03-15&end_date=2023-03-20";
        
        ExtratorDeConteudoDoImdb extrator = new ExtratorDeConteudoDoImdb();
        String url = "https://imdb-api.com/pt-br/API/MostPopularMovies/k_b2g36n8t";
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        

        // exibir e manipular os dados recebidos
       
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var gerador = new GeradorDeFigurinha();

        for (int i = 0; i < 4; i++ ) {

            Conteudo conteudo = conteudos.get(i);


            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            var nomeArquivo =  conteudo.getTitulo() + ".png";

            gerador.criar(inputStream, nomeArquivo);

            
            System.out.println(conteudo.getTitulo());
            System.out.println(conteudo.getUrlImagem());
            System.out.println();
           
        }
            
    }
}
