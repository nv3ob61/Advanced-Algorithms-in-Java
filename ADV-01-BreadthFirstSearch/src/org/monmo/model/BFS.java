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

import org.monmo.model.Vertex;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author nv3ob61
 */
public class BFS {

  public void bfs(Vertex root) {
    //we can instantiate the cue as a linked list
    //queue is FIFO
    Queue<Vertex> queue = new LinkedList<>();

    root.setVisited(true);
    //add root to the queue
    queue.add(root);

    while (!queue.isEmpty()) {
      Vertex actualVertex = queue.remove();
      System.out.println(actualVertex + " ");

      //visit neighbours 
      for (Vertex v : actualVertex.getNeighbourList()) {
        if (!v.isVisited()) {
          v.setVisited(true);
          queue.add(v);
        }
      }
    }
  }
}
