/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tsi.pd.concurrency;

/**
 *
 * @author Professor
 */
public class EditorTexto extends Thread{
    private BufferImpressao buffer;
    public EditorTexto(BufferImpressao buffer){
        this.buffer = buffer;
        setName("EditorTexto");
    }
    public void run(){
        for(int i=0;i<20;i++)
            buffer.write("Linha"+i);
    }
}
