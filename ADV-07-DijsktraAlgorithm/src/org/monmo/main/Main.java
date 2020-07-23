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

import org.monmo.model.DijsktraAlgorithm;
import org.monmo.model.Edge;
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

    Vertex v1 = new Vertex("A");
    Vertex v2 = new Vertex("B");
    Vertex v3 = new Vertex("C");
    
    v1.addNeighbour(new Edge(1, v1, v2));
    v1.addNeighbour(new Edge(3, v1, v3));
    v2.addNeighbour(new Edge(1, v2, v3));
    
    DijsktraAlgorithm algo = new DijsktraAlgorithm();
    algo.computePaths(v1);
    
    System.out.println(algo.getShortestPathTo(v3));
  }

}
