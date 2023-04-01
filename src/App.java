import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Fazer uma conexão HTTP e buscar os top 250 filmes
        // https://imdb-api.com/en/API/MostPopularMovies/k_b2g36n8t
        String url = "https://api.nasa.gov/planetary/apod?api_key=hmaiRz0GBftu2y4v5TihPUyw5zWNRecVNawWHj5G&start_date=2023-03-15&end_date=2023-03-20";
        //String imdburl = "https://imdb-api.com/pt-br/API/MostPopularMovies/k_b2g36n8t";
        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        

        // exibir e manipular os dados recebidos

        var gerador = new GeradorDeFigurinha();

        for (int i = 0; i < 4; i++ ) {

            Map<String,String> conteudo = listaDeConteudos.get(i);


            InputStream inputStream = new URL(urlImagem).openStream();
            var nomeArquivo =  titulo + ".png";

            gerador.criar(inputStream, nomeArquivo);

            
            System.out.println(titulo);
            System.out.println(urlImagem);
            System.out.println();
            //System.out.println(filme.get("image"));
            //System.out.println(filme.get("imDbRating"));
        }
            
    }
}
