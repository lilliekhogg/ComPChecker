/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luke
 */
public class Issue {
    
    int selectedPart, ID1, ID2;
    
    /**
     *
     * @param part sets selectedPart.
     */
    public void setSelectedPart(int part) {
        selectedPart = part;
    }
    
    /**
     *
     * @return gets selectedPart.
     */
    public int getSelectedPart () {
        return selectedPart;
    }
    
    /**
     *
     * @param id1 sets ID1.
     */
    public void setID1(int id1) {
        ID1 = id1;
    }
    
    /**
     *
     * @return gets ID1.
     */
    public int getID1() {
        return ID1;
    }
    
    /**
     *
     * @param id2 sets ID2.
     */
    public void setID2(int id2) {
        ID2 = id2;
    }
    
    /**
     *
     * @return gets ID2.
     */
    public int getID2() {
        return ID2;
    }
    
}
