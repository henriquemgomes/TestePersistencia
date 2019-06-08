/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testepersistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henrique
 */
public class TestePersistencia {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        Cliente cli1 = new Cliente(0, "Henrique", "Gomes", 0);
        Cliente cli2 = new Cliente(1, "Outro", "Mais Outro", 0);
        clientes.add(cli1);
        clientes.add(cli2);
        //escrita
        try {
            FileOutputStream fout = new FileOutputStream("arq.ext");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(clientes);
            out.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Algum erro ocorreu:");
            System.out.println(ex.getMessage());
        }
        //leitura
        try {
            FileInputStream fin = new FileInputStream("arq.ext");
            ObjectInputStream oin = new ObjectInputStream(fin);
            ArrayList<Cliente> clientesLidos = (ArrayList) oin.readObject();
            
            for(Cliente clienteLido : clientesLidos){
                System.out.println("Nome cli1: " +clienteLido.getNome());
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException ex) {
            System.out.println("Algum erro ocorreu:");
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Não foi possivel ler objeto Cliente do arquivo");
        }
    }

}
