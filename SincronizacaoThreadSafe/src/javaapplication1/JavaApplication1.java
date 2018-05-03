/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import br.edu.ifpb.tsi.pd.concurrency.BufferImpressao;
import br.edu.ifpb.tsi.pd.concurrency.EditorTexto;
import br.edu.ifpb.tsi.pd.concurrency.Impressora;

/**
 *
 * @author Professor
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferImpressao buffer = new BufferImpressao();
        EditorTexto editor = new EditorTexto(buffer);
        Impressora impressora1 = new Impressora(buffer,1);
        Impressora impressora2 = new Impressora(buffer,2);
        editor.start();
        impressora1.start();
        impressora2.start();
    }
    
}
