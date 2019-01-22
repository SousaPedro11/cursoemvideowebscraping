package cursoemvideo;

import org.testng.annotations.Test;

import cursoemvideo.webscraping.ObterVideos;

public class TesteNomeVideo {

    static final boolean HABILITAR = false;

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void python3Fundamentos() {

        final String url = "http://www.youtube.com/playlist?list=PLHz_AreHm4dlKP6QQCekuIPky1CiwmdI6";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("fundamentosPython3");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void python3Estruturas() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dk_nZHmxxf_J0WRAqy5Czye";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista();
        // .salvarNomes("estruturasPython3");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void python3EstruturasCompostas() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dksnH2jVTIVNviIMBVYyFnH";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista();
        // .salvarNomes("estruturasCompostasPython3");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void hardware() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dn1JHgN9wpbIUhzZmycYQXW";

        // final String nomePasta = "Curso de Hardware Grátis";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("/Downloads/" + nomePasta + "/", "hardware");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void logica() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dmSj0MHol_aoNYCSGFqvfXV";

        // final String nomePasta = "Curso de Lógica de Programação";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("/Downloads/" + nomePasta + "/", "logica");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void html() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dlAnJ_jJtV29RFxnPHDuk9o";

        // final String nomePasta = "Curso de HTML5 Completo e GRÁTIS";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("/Downloads/" + nomePasta + "/", "html");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void java() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dkI2ZdjTwZA4mPMxWTfNSpR";

        // final String nomePasta = "Curso de Java para Iniciantes";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("/Downloads/" + nomePasta + "/", "java");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void banco() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dkBs-795Dsgvau_ekxg8g1r";

        // final String nomePasta = "Curso de Banco de Dados MySQL";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("/Downloads/" + nomePasta + "/", "banco");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void pooJava() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dkqe2aR0tQK74m8SFe-aGsY";

        // final String nomePasta = "Curso de POO Java";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("/Downloads/" + nomePasta + "/", "poojava");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void pooPHP() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dmGuLII3tsvryMMD7VgcT7x";

        // final String nomePasta = "Curso de POO PHP";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("/Downloads/" + nomePasta + "/", "poophp");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void PHP() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dm4beCCCmW4xwpmLf6EHY9k";

        // final String nomePasta = "Curso de PHP para Iniciantes";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
        // .salvarNomes("/Downloads/" + nomePasta + "/", "php");
        ;
    }
}
