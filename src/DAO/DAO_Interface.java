/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.varMatakuliah;

import java.util.List;

/**
 *
 * @author ACER ASPIRE 5
 */
public interface DAO_Interface <A>{
    public void insert(A object);
    public void update(A object);
    public void delete(String key);
    public List <A>getALL();
    public List <A>getCari(String key);

    public List<varMatakuliah> getAll();
  

  
    
    
}
