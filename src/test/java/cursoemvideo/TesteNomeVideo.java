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
                        .salvarNomes("fundamentosPython3");
        ;
    }

    @Test(enabled = !TesteNomeVideo.HABILITAR)
    public void python3Estruturas() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dk_nZHmxxf_J0WRAqy5Czye";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("estruturasPython3");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void python3EstruturasCompostas() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dksnH2jVTIVNviIMBVYyFnH";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("estruturasCompostasPython3");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void hardware() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dn1JHgN9wpbIUhzZmycYQXW";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("hardware");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void logica() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dmSj0MHol_aoNYCSGFqvfXV";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("logica");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void html() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dlAnJ_jJtV29RFxnPHDuk9o";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("html");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void java() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dkI2ZdjTwZA4mPMxWTfNSpR";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("java");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void banco() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dkBs-795Dsgvau_ekxg8g1r";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("banco");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void pooJava() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dkqe2aR0tQK74m8SFe-aGsY";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("poojava");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void pooPHP() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dmGuLII3tsvryMMD7VgcT7x";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("poophp");
        ;
    }

    @Test(enabled = TesteNomeVideo.HABILITAR)
    public void PHP() {

        final String url = "https://www.youtube.com/playlist?list=PLHz_AreHm4dm4beCCCmW4xwpmLf6EHY9k";

        new ObterVideos(url)
                        .obterNomes()
                        .imprimirLista()
                        .salvarNomes("php");
        ;
    }
}
