/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.concurrency;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Professor
 */
public class BufferImpressao {
    private String linha = null;
    public synchronized void write(String linha){
        while(this.linha!=null)
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BufferImpressao.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println(Thread.currentThread().getName()+
                " escreveu: "+linha);
        this.linha = linha;
        notifyAll();
    }
    public  synchronized String read(){
        while(this.linha==null)
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BufferImpressao.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println(Thread.currentThread().getName()+
                " recuperou: "+linha);
        String conteudo = linha;
        linha = null;
        notifyAll();
        return conteudo;
    }
}
