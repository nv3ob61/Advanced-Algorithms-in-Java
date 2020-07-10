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
import java.util.Stack;
import org.monmo.model.TopologicalOrdering;
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
    //instance of Topological Ordering
    TopologicalOrdering to = new TopologicalOrdering();

    //Arraylist with vertices
    List<Vertex> graph = new ArrayList<>();

    //vertex instances
    graph.add(new Vertex("0"));
    graph.add(new Vertex("1"));
    graph.add(new Vertex("2"));
    graph.add(new Vertex("3"));
    graph.add(new Vertex("4"));
    graph.add(new Vertex("5"));
    
    //set neighbours
    graph.get(2).addNeighbour(graph.get(3));
    graph.get(3).addNeighbour(graph.get(1));
    graph.get(4).addNeighbour(graph.get(0));
    graph.get(4).addNeighbour(graph.get(1));
    graph.get(5).addNeighbour(graph.get(0));
    graph.get(5).addNeighbour(graph.get(2));

    //iterate through the graph, if we have not visited that vertex pull to the
    //topological order.
    for (int i = 0; i < graph.size(); i++) {
      if (!graph.get(i).isVisited()) {
        to.dfs(graph.get(i));
      }
    }
    
    //storing vertex
    Stack<Vertex> stack = to.getStack();

    //iterate again to show sort topological ordered
    for (int j = 0; j < graph.size(); j++) {
      Vertex vertex = stack.pop();
      System.out.println(vertex + " -> ");
    }
  }
}
