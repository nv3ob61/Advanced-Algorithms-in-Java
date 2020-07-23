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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author nv3ob61
 */
public class DijsktraAlgorithm {
  
  public void computePaths(Vertex sourceVertex){
    
    sourceVertex.setDistance(0);
    PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(sourceVertex);
    
    while (!priorityQueue.isEmpty()) {
      
      Vertex actualVertex = priorityQueue.poll();
      
      for (Edge edge : actualVertex.getAdjacenciesList()) {
        Vertex v = edge.getTargetVertex();
        
        double newDistance = actualVertex.getDistance() + edge.getWeight();
        
        if(newDistance < v.getDistance()){
         priorityQueue.remove(v);
         v.setDistance(newDistance);
         v.setPredecessor(actualVertex);
         priorityQueue.add(v);
        }
      }
    }
  }
  
  public List<Vertex> getShortestPathTo(Vertex targetVertex){
    
    List<Vertex> shortestPathToTarget = new ArrayList<>();
    
    for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
      shortestPathToTarget.add(vertex);
    }
    
    Collections.reverse(shortestPathToTarget);
    
    return shortestPathToTarget;
  }
}
