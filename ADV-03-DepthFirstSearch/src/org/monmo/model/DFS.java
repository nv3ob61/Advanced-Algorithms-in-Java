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
package org.monmo.model;

import java.util.List;
import java.util.Stack;

/**
 *
 * @author nv3ob61
 */
public class DFS {

  private Stack<Vertex> stack;

  public DFS() {
    this.stack = new Stack<>();
  }

  public void dfs(List<Vertex> vertexList) {
    for (Vertex v : vertexList) {
      if (!v.isVisited()) {
        v.setVisited(true);
        dfsRecursive(v);
      }
    }

  }
  
  private void dfsRecursive(Vertex v){
    
    System.out.println(v + " ");
    
    //neighbours
    for (Vertex vertex : v.getNeighbourList()) {
      if(!vertex.isVisited()){
        vertex.setVisited(true);
        dfsRecursive(vertex);
      }
    }
  }

  private void dfsWithStack(Vertex v) {
    //Stack has LIFO structure
    this.stack.add(v);
    v.setVisited(true);

    while (!stack.isEmpty()) {
      Vertex actual = this.stack.pop();
      System.out.print(actual + " ");

      for (Vertex vertex : actual.getNeighbourList()) {
        if (!vertex.isVisited()) {
          vertex.setVisited(true);
          this.stack.push(vertex);
        }
      }
    }
  }
}
