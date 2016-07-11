package com.example.lc_me.curriculoleticia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by lc-me on 07/07/2016.
 */
public class MyDataProvider {
    public static HashMap<String, List<String>> getDataHashMap() {
        HashMap<String, List<String>> listasHashMap= new HashMap<String, List<String>>();

        List<String> outrasInfoLista = new ArrayList<String>();
        List<String> experienciaLista = new ArrayList<String>();
        List<String> cursosLista = new ArrayList<String>();
        List<String> conhecimentosLista = new ArrayList<String>();
        List<String> formacaoLista  = new ArrayList<String>();


        for(int i = 0; i < MyDataArrays.cursosArray.length;i++){
            cursosLista.add(MyDataArrays.cursosArray[i]);
        }

        for (int i = 0; i < MyDataArrays.outrasInfoArray.length; i++) {
            outrasInfoLista.add(MyDataArrays.outrasInfoArray[i]);
        }

        for (int i = 0; i < MyDataArrays.experienciaArray.length; i++) {
            experienciaLista.add(MyDataArrays.experienciaArray[i]);
        }

        for(int i = 0; i < MyDataArrays.conhecimentoArray.length;i++){
            conhecimentosLista.add(MyDataArrays.conhecimentoArray[i]);
        }


        for (int i = 0; i < MyDataArrays.formacaoArray.length; i++) {
            formacaoLista.add(MyDataArrays.formacaoArray[i]);
        }



        listasHashMap.put("Outras Informações", outrasInfoLista);
        listasHashMap.put("Experiências ", experienciaLista);
        listasHashMap.put("Cursos ", cursosLista);
        listasHashMap.put("Formação", formacaoLista);
        listasHashMap.put("Conhecimentos", conhecimentosLista);



        return listasHashMap;
    }
}
