/*
 * Copyright (C) 2020 nv3ob61
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.monmo.model;

import java.util.Stack;

/**
 *
 * @author nv3ob61
 */
public class TopologicalOrdering {
  //underlying abstract data type
  private Stack<Vertex> stack;
  
  public TopologicalOrdering(){
    this.stack = new Stack<>();
  }
  
  public void dfs(Vertex vertex){
    vertex.setVisited(true);
    
    //visit all neighbours recursively
    for (Vertex v : vertex.getNeighbourList()) {
      if(!v.isVisited()){
        dfs(v);
      }
    }
    //push vertex to the stack
    stack.push(vertex);
  }
  
  public Stack<Vertex> getStack(){
    return this.stack;
  }
}
