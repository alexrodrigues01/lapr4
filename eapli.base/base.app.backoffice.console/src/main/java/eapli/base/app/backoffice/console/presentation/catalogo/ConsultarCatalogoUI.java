package eapli.base.app.backoffice.console.presentation.catalogo;

import eapli.base.catalogomanagement.application.ConsultarCatalogoController;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;


import java.util.List;

public class ConsultarCatalogoUI extends AbstractUI {



    public ConsultarCatalogoUI(){}


    @Override
    protected boolean doShow() {
        ConsultarCatalogoController consultarCatalogoController=new ConsultarCatalogoController();

        List<Catalogo> listaCatalogos= consultarCatalogoController.getCatalogos();
        for(Catalogo catalogo: listaCatalogos){
            System.out.println(catalogo);
        }
        String consulta= Console.readLine(String.format("1-Pesquisar catalogo por titulo\n" +
                "2- Pesquisar catalogo por identificador unico\n" +
                "3- Pesquisar servico por titulo\n" +
                "4- Pesquisar servico por keyword"));

        if(consulta.equalsIgnoreCase("1")){
            String tituloCatalogo=Console.readLine("Insira o titulo do catalogo que pretende visualizar");
            System.out.println(consultarCatalogoController.getCatalogobyTitulo(tituloCatalogo));
        }else{
            if(consulta.equalsIgnoreCase("2")){
                String identificadorCatalogo=Console.readLine("Insira o identificador unico do catalogo que pretende visualizar");
                System.out.println(consultarCatalogoController.getCatalogobyIdentificador(identificadorCatalogo));
            }
            else{
                if(consulta.equalsIgnoreCase("3")){
                    String tituloServico=Console.readLine("Insira o titulo do servico que pretende visualizar");
                    System.out.println(consultarCatalogoController.getServicoByTitulo(tituloServico));
                }
                else{
                    if(consulta.equalsIgnoreCase("4")){
                        String keywordServico=Console.readLine("Insira a keyword do servico que pretende visualizar");
                        System.out.println(consultarCatalogoController.getServicoByKeyword(keywordServico));
                    }
                }
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "+= Consultar Catálogo ===============";
    }
}
