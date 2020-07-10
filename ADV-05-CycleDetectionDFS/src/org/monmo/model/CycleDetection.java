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

/**
 *
 * @author nv3ob61
 */
public class CycleDetection {

  public void detectCycle(List<Vertex> vertexList) {
    for (Vertex v : vertexList) {
      if (!v.isVisited()) {
        dfs(v);
      }
    }
  }

  private void dfs(Vertex v) {
    System.out.println("DFS on vertex " + v);
    v.setBeingVisited(true);

    for (Vertex vertex : v.getAdjList()) {

      System.out.println("Visiting the neighbours of vertex " + v);
      if (!vertex.isBeingVisited()) {
        System.out.println("There is a backward edge: so there is a cycle!");
        return;
      }
      if (!vertex.isVisited()) {
        System.out.println("Visiting vertex " + vertex + " recursively...");
        vertex.setVisited(true);
        dfs(vertex);
      }
    }

    System.out.println("Set vertex " + v + " setBeingVisited(false) and visited(true)...");
    v.setBeingVisited(false);
    v.setVisited(true);
  }
}
