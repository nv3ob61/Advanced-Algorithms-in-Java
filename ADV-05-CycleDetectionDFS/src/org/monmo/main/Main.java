/* 
 * Copyright (C) 2020 mon_mode   0mon.mode@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.monmo.main;

import java.util.ArrayList;
import java.util.List;
import org.monmo.model.CycleDetection;
import org.monmo.model.Vertex;


/**
 *
 * @author nv3ob61
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    Vertex v1 = new Vertex("1");
    Vertex v2 = new Vertex("2");
    Vertex v3 = new Vertex("3");
    Vertex v4 = new Vertex("4");
    Vertex v5 = new Vertex("5");
    Vertex v6 = new Vertex("6");
    
    v1.addNeighbour(v2);
    v2.addNeighbour(v3);
    v1.addNeighbour(v3);
    v4.addNeighbour(v1);
    v4.addNeighbour(v5);
    v5.addNeighbour(v6);
//    v6.addNeighbour(v4);
    
    List<Vertex> vertexList = new ArrayList<>();
    
    //add vertex to the list
    vertexList.add(v1);
    vertexList.add(v2);
    vertexList.add(v3);
    vertexList.add(v4);
    vertexList.add(v5);
    vertexList.add(v6);
    
    CycleDetection cd = new CycleDetection();
    cd.detectCycle(vertexList);
    
  }

}
